package com.berrontech.erp.modal.service.general;

import com.berrontech.erp.commons.entity.TestLog;
import com.berrontech.erp.commons.entity.User;
import com.berrontech.erp.modal.service.basic.AbstractService;
import com.github.pagehelper.PageInfo;

/**
 * Create By Levent8421
 * Create Time: 2020/1/9 16:04
 * Class Name: TestLogService
 * Author: Levent8421
 * Description:
 * 测试记录相关业务行为定义
 *
 * @author Levent*421
 */
public interface TestLogService extends AbstractService<TestLog> {
    /**
     * 记录测试日志
     *
     * @param tester  测试人
     * @param testLog testLog entity object
     */
    void log(TestLog testLog, User tester);

    /**
     * Find all log fetch all inner objects
     *
     * @param page page
     * @param rows rows per page
     * @return PageInfo
     */
    PageInfo<TestLog> listFetchAll(int page, int rows);
}
