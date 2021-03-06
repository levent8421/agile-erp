package com.berrontech.erp.web.user.controller.token;

import com.berrontech.erp.commons.entity.TestItem;
import com.berrontech.erp.commons.entity.TestLog;
import com.berrontech.erp.commons.entity.User;
import com.berrontech.erp.modal.service.general.TestItemService;
import com.berrontech.erp.modal.service.general.TestLogService;
import com.berrontech.erp.modal.service.general.UserService;
import com.berrontech.erp.web.commons.controller.AbstractController;
import com.berrontech.erp.web.commons.security.TokenDataHolder;
import com.berrontech.erp.web.commons.vo.GeneralResult;
import com.berrontech.erp.web.user.security.UserToken;
import com.berrontech.erp.web.user.util.TestLogUtils;
import com.berrontech.erp.web.user.vo.TestLogParam;
import com.berrontech.erp.web.user.vo.TestLogResult;
import com.github.pagehelper.PageInfo;
import lombok.val;
import org.springframework.web.bind.annotation.*;

/**
 * Create By Levent8421
 * Create Time: 2020/1/11 10:54
 * Class Name: ApiTestLogController
 * Author: Levent8421
 * Description:
 * TestLog 数据访问控制器
 *
 * @author Levent*421
 */
@RestController
@RequestMapping("/api/token/test-log")
public class ApiTestLogController extends AbstractController {
    private final TestLogService testLogService;
    private final TestItemService testItemService;
    private final TokenDataHolder tokenDataHolder;
    private final UserService userService;

    public ApiTestLogController(TestLogService testLogService,
                                TestItemService testItemService,
                                TokenDataHolder tokenDataHolder,
                                UserService userService) {
        this.testLogService = testLogService;
        this.testItemService = testItemService;
        this.tokenDataHolder = tokenDataHolder;
        this.userService = userService;
    }

    /**
     * 记录日志
     *
     * @param param 参数
     * @return GR
     */
    @PutMapping("/")
    public GeneralResult<TestLogResult> log(@RequestBody TestLogParam param) {
        val pair = TestLogUtils.convertParam2Entity(param);
        val testLog = pair.getO1();
        val testerId = UserToken.obtainUserIdFromHolder(tokenDataHolder);
        final User tester = userService.require(testerId);
        testLogService.log(testLog, tester);
        val testItems = pair.getO2();
        for (TestItem testItem : testItems) {
            testItem.setTestLogId(testLog.getId());
        }
        testItemService.log(testItems);
        return GeneralResult.ok();
    }

    /**
     * 查询所有日志
     *
     * @param page page
     * @param rows rows
     * @return GR
     */
    @GetMapping("/")
    public GeneralResult<PageInfo<TestLog>> all(Integer page, Integer rows) {
        page = defaultPage(page);
        rows = defaultRows(rows);

        val res = testLogService.listFetchAll(page, rows);
        return GeneralResult.ok(res);
    }
}
