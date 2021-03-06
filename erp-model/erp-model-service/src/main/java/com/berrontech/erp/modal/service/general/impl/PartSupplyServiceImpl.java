package com.berrontech.erp.modal.service.general.impl;

import com.berrontech.erp.commons.entity.PartSupply;
import com.berrontech.erp.modal.service.basic.impl.AbstractServiceImpl;
import com.berrontech.erp.modal.service.general.PartSupplyService;
import com.berrontech.erp.model.repository.general.PartSupplyMapper;
import org.springframework.stereotype.Service;

/**
 * Create By Levent8421
 * Create Time: 2020/7/16 15:11
 * Class Name: PartSupplyServiceImpl
 * Author: Levent8421
 * Description:
 * 物料-供应商关系相关业务行为实现
 *
 * @author Levent8421
 */
@Service
public class PartSupplyServiceImpl extends AbstractServiceImpl<PartSupply> implements PartSupplyService {
    private final PartSupplyMapper partSupplyMapper;

    public PartSupplyServiceImpl(PartSupplyMapper partSupplyMapper) {
        super(partSupplyMapper);
        this.partSupplyMapper = partSupplyMapper;
    }
}
