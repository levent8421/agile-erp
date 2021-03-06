package com.berrontech.erp.modal.service.general.impl;

import com.berrontech.erp.commons.entity.Part;
import com.berrontech.erp.modal.service.basic.impl.AbstractServiceImpl;
import com.berrontech.erp.modal.service.general.PartService;
import com.berrontech.erp.model.repository.general.PartMapper;
import org.springframework.stereotype.Service;

/**
 * Create By Levent8421
 * Create Time: 2020/2/13 18:06
 * Class Name: PartServiceImpl
 * Author: Levent8421
 * Description:
 * Part物料相关业务行为实现
 *
 * @author Levent8421
 */
@Service
public class PartServiceImpl extends AbstractServiceImpl<Part> implements PartService {
    private final PartMapper partMapper;

    public PartServiceImpl(PartMapper partMapper) {
        super(partMapper);
        this.partMapper = partMapper;
    }
}
