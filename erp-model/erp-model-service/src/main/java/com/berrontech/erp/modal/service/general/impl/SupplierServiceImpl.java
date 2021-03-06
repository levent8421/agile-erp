package com.berrontech.erp.modal.service.general.impl;

import com.berrontech.erp.commons.entity.Supplier;
import com.berrontech.erp.modal.service.basic.impl.AbstractServiceImpl;
import com.berrontech.erp.modal.service.general.SupplierService;
import com.berrontech.erp.model.repository.general.SupplierMapper;
import org.springframework.stereotype.Service;

/**
 * Create By Levent8421
 * Create Time: 2020/2/14 16:59
 * Class Name: SupplierServiceImpl
 * Author: Levent8421
 * Description:
 * 供应商相关业务行为定义
 *
 * @author Levent8421
 */
@Service
public class SupplierServiceImpl extends AbstractServiceImpl<Supplier> implements SupplierService {
    private final SupplierMapper supplierMapper;

    public SupplierServiceImpl(SupplierMapper supplierMapper) {
        super(supplierMapper);
        this.supplierMapper = supplierMapper;
    }
}
