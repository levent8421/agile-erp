package com.berrontech.erp.modal.service.general.impl;

import com.berrontech.erp.commons.entity.PartType;
import com.berrontech.erp.modal.service.basic.impl.AbstractServiceImpl;
import com.berrontech.erp.modal.service.general.PartTypeService;
import com.berrontech.erp.model.repository.general.PartTypeMapper;
import org.springframework.stereotype.Service;

/**
 * Create By Levent8421
 * Create Time: 2020/2/12 0:17
 * Class Name: PartTypeServiceImpl
 * Author: Levent8421
 * Description:
 * 库存分类相关业务行为实现
 *
 * @author Levent8421
 */
@Service
public class PartTypeServiceImpl extends AbstractServiceImpl<PartType> implements PartTypeService {
    private final PartTypeMapper partTypeMapper;

    public PartTypeServiceImpl(PartTypeMapper partTypeMapper) {
        super(partTypeMapper);
        this.partTypeMapper = partTypeMapper;
    }
}
