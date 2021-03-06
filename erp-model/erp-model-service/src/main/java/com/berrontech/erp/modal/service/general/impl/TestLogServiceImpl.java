package com.berrontech.erp.modal.service.general.impl;

import com.berrontech.erp.commons.entity.TestLog;
import com.berrontech.erp.commons.entity.User;
import com.berrontech.erp.commons.util.RandomUtils;
import com.berrontech.erp.modal.service.basic.impl.AbstractServiceImpl;
import com.berrontech.erp.modal.service.general.TestLogService;
import com.berrontech.erp.model.repository.general.TestLogMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

/**
 * Create By Levent8421
 * Create Time: 2020/1/9 16:05
 * Class Name: TestLogServiceImpl
 * Author: Levent8421
 * Description:
 * 测试记录相关业务行为实现
 *
 * @author Levent*421
 */
@Service
@Slf4j
public class TestLogServiceImpl extends AbstractServiceImpl<TestLog> implements TestLogService {
    private static final int TRACE_SUFFIX_LENGTH = 4;
    public static final int TRACE_TIME_STRING_LENGTH = 10;
    private final TestLogMapper testLogMapper;

    public TestLogServiceImpl(TestLogMapper testLogMapper) {
        super(testLogMapper);
        this.testLogMapper = testLogMapper;
    }

    @Override
    public void log(TestLog testLog, User tester) {
        randomTrace(testLog);
        testLog.setTesterId(tester.getId());
        save(testLog);
    }

    /**
     * Fill Random Trace Id
     *
     * @param testLog test log
     */
    private void randomTrace(TestLog testLog) {
        val traceId = RandomUtils.currentTimeMillisWithIncrement(TRACE_TIME_STRING_LENGTH, TRACE_SUFFIX_LENGTH);
        testLog.setTraceNo(traceId);
    }

    @Override
    public PageInfo<TestLog> listFetchAll(int page, int rows) {
        return PageHelper.startPage(page, rows)
                .doSelectPageInfo(testLogMapper::selectFetchAll);
    }
}
