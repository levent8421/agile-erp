package com.berrontech.erp.model.repository.general;

import com.berrontech.erp.commons.entity.TestLog;
import com.berrontech.erp.model.repository.basic.AbstractMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2020/1/9 16:03
 * Class Name: TestLogMapper
 * Author: Levent8421
 * Description:
 * 测试记录相关数据库访问组件
 *
 * @author Levent*421
 */
@Repository
public interface TestLogMapper extends AbstractMapper<TestLog> {
    /**
     * Select All Log
     *
     * @return all log
     */
    List<TestLog> selectFetchAll();
}
