package com.berrontech.erp.modal.service.general.impl;

import com.berrontech.erp.commons.entity.PartInoutAction;
import com.berrontech.erp.modal.service.basic.impl.AbstractServiceImpl;
import com.berrontech.erp.modal.service.general.PartInoutActionService;
import com.berrontech.erp.model.repository.general.PartInoutActionMapper;
import org.springframework.stereotype.Service;

/**
 * Create By Levent8421
 * Create Time: 2020/2/14 19:51
 * Class Name: PartInoutActionServiceImpl
 * Author: Levent8421
 * Description:
 * 物料进出库记录相关业务行为实现
 *
 * @author Levent8421
 */
@Service
public class PartInoutActionServiceImpl extends AbstractServiceImpl<PartInoutAction> implements PartInoutActionService {
    private final PartInoutActionMapper partInoutActionMapper;

    public PartInoutActionServiceImpl(PartInoutActionMapper partInoutActionMapper) {
        super(partInoutActionMapper);
        this.partInoutActionMapper = partInoutActionMapper;
    }
}
