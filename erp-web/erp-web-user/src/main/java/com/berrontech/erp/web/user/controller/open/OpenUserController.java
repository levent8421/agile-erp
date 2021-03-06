package com.berrontech.erp.web.user.controller.open;

import com.berrontech.erp.commons.entity.User;
import com.berrontech.erp.commons.exception.BadRequestException;
import com.berrontech.erp.modal.service.general.UserService;
import com.berrontech.erp.modal.service.vo.UserPermission;
import com.berrontech.erp.web.commons.conf.TokenConfiguration;
import com.berrontech.erp.web.commons.controller.AbstractController;
import com.berrontech.erp.web.commons.security.vo.TokenAccountVo;
import com.berrontech.erp.web.commons.util.ParamChecker;
import com.berrontech.erp.web.commons.vo.GeneralResult;
import com.berrontech.erp.web.commons.vo.LoginParam;
import com.berrontech.erp.web.user.security.UserToken;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2020/1/8 15:50
 * Class Name: OpenUserController
 * Author: Levent8421
 * Description:
 * 开放访问权限的用户控制器
 *
 * @author Levent*421
 */
@Slf4j
@RestController
@RequestMapping("/api/open/user")
public class OpenUserController extends AbstractController {
    private final UserService userService;
    private final TokenConfiguration tokenConfiguration;

    public OpenUserController(UserService userService,
                              TokenConfiguration tokenConfiguration) {
        this.userService = userService;
        this.tokenConfiguration = tokenConfiguration;
    }

    /**
     * Find  All Users As A List
     *
     * @return GR
     */
    @GetMapping("/")
    public GeneralResult<List<User>> all() {
        val users = userService.all();
        return GeneralResult.ok(users);
    }

    /**
     * 用户权限信息
     *
     * @param id ID
     * @return GR
     */
    @GetMapping("/{id}/_permissions")
    public GeneralResult<UserPermission> userPermissions(@PathVariable("id") Integer id) {
        val user = userService.require(id);
        val permission = UserPermission.fromUser(user);
        return GeneralResult.ok(permission);
    }

    /**
     * 用户登录
     *
     * @param param param
     * @return GR
     */
    @PostMapping("/_login")
    public GeneralResult<TokenAccountVo<User>> login(@RequestBody LoginParam param) {
        final Class<BadRequestException> ex = BadRequestException.class;
        ParamChecker.notNull(param, ex, "No Params sent!");
        ParamChecker.notEmpty(param.getLoginName(), ex, "用户名必填！");
        ParamChecker.notEmpty(param.getPassword(), ex, "密码必填！");
        final User user = userService.login(param.getLoginName(), param.getPassword());
        if (user == null) {
            return GeneralResult.permissionDenied("用户名或密码错误！");
        }

        final UserToken token = new UserToken(tokenConfiguration.getKey(), user);
        final String tokenString = token.toTokenString();
        log.info("User[{}/{}] login res=[{}]", user.getId(), user.getName(), tokenString);
        final TokenAccountVo<User> res = new TokenAccountVo<>();
        res.setAccount(user);
        res.setToken(tokenString);
        return GeneralResult.ok(res);
    }
}
