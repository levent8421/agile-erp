package com.berrontech.erp.web.user.vo;

import com.berrontech.erp.commons.entity.TestItem;
import com.berrontech.erp.commons.entity.TestLog;
import com.berrontech.erp.commons.entity.User;
import lombok.Data;

import java.util.Collection;

/**
 * Create By Levent8421
 * Create Time: 2020/1/11 10:56
 * Class Name: TestLogResult
 * Author: Levent8421
 * Description:
 * 记录测试日志接口放回结果
 *
 * @author Levent*421
 */
@Data
public class TestLogResult {
    /**
     * 测试员
     */
    private User tester;
    /**
     * 测试项
     */
    private Collection<TestItem> testItems;
    /**
     * 测试日志
     */
    private TestLog testLog;
}
