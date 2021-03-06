package com.berrontech.erp.modal.service.general.impl;

import com.berrontech.erp.commons.entity.PartStatus;
import com.berrontech.erp.modal.service.basic.impl.AbstractServiceImpl;
import com.berrontech.erp.modal.service.general.PartStatusService;
import com.berrontech.erp.model.repository.general.PartStatusMapper;
import org.springframework.stereotype.Service;

/**
 * Create By Levent8421
 * Create Time: 2020/2/12 22:06
 * Class Name: PartStatusServiceImpl
 * Author: Levent8421
 * Description:
 * Part Status 物料状态相关业务行为实现
 *
 * @author Levent8421
 */
@Service
public class PartStatusServiceImpl extends AbstractServiceImpl<PartStatus> implements PartStatusService {
    private final PartStatusMapper partStatusMapper;

    public PartStatusServiceImpl(PartStatusMapper partStatusMapper) {
        super(partStatusMapper);
        this.partStatusMapper = partStatusMapper;
    }
}
