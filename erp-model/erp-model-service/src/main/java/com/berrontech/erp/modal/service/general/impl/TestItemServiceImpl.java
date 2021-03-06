package com.berrontech.erp.modal.service.general.impl;

import com.berrontech.erp.commons.entity.TestItem;
import com.berrontech.erp.modal.service.basic.impl.AbstractServiceImpl;
import com.berrontech.erp.modal.service.general.TestItemService;
import com.berrontech.erp.model.repository.general.TestItemMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2020/1/9 16:07
 * Class Name: TestItemServiceImpl
 * Author: Levent8421
 * Description:
 * 测试项相关业务行为实现
 *
 * @author Levent*421
 */
@Service
@Slf4j
public class TestItemServiceImpl extends AbstractServiceImpl<TestItem> implements TestItemService {
    private final TestItemMapper testItemMapper;

    public TestItemServiceImpl(TestItemMapper testItemMapper) {
        super(testItemMapper);
        this.testItemMapper = testItemMapper;
    }

    @Override
    public void log(List<TestItem> testItems) {
        save(testItems);
    }
}
