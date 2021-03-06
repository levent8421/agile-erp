package com.berrontech.erp.web.user.controller.token;

import com.berrontech.erp.commons.entity.User;
import com.berrontech.erp.modal.service.general.UserService;
import com.berrontech.erp.modal.service.vo.UserPermission;
import com.berrontech.erp.web.commons.controller.AbstractController;
import com.berrontech.erp.web.commons.security.TokenDataHolder;
import com.berrontech.erp.web.commons.vo.GeneralResult;
import com.berrontech.erp.web.user.security.UserToken;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By Levent8421
 * Create Time: 2020/1/9 17:35
 * Class Name: ApiUserController
 * Author: Levent8421
 * Description:
 * 用户相关API数据访问控制器
 *
 * @author Levent*421
 */
@RestController
@RequestMapping("/api/token/user")
public class ApiUserController extends AbstractController {
    private final TokenDataHolder tokenDataHolder;
    private final UserService userService;

    public ApiUserController(TokenDataHolder tokenDataHolder,
                             UserService userService) {
        this.tokenDataHolder = tokenDataHolder;
        this.userService = userService;
    }

    /**
     * 获取当前登录的用户
     *
     * @return GR
     */
    @GetMapping("/_me")
    public GeneralResult<User> getCurrentUser() {
        final int uid = UserToken.obtainUserIdFromHolder(tokenDataHolder);
        return GeneralResult.ok(userService.require(uid));
    }

    /**
     * 当前用户的权限星系
     *
     * @return GR with permission Object
     */
    @GetMapping("/_permission")
    public GeneralResult<UserPermission> currentUserPermission() {
        final int uid = UserToken.obtainUserIdFromHolder(tokenDataHolder);
        val user = userService.require(uid);
        val permission = UserPermission.fromUser(user);
        return GeneralResult.ok(permission);
    }
}
