package com.berrontech.erp.modal.service.general.impl;

import com.berrontech.erp.commons.entity.StorageLocation;
import com.berrontech.erp.modal.service.basic.impl.AbstractServiceImpl;
import com.berrontech.erp.modal.service.general.StorageLocationService;
import com.berrontech.erp.model.repository.general.StorageLocationMapper;
import org.springframework.stereotype.Service;

/**
 * Create By Levent8421
 * Create Time: 2020/2/13 10:30
 * Class Name: StorageLocationServiceImpl
 * Author: Levent8421
 * Description:
 * 库存位置相关业务行为实现
 *
 * @author Levent8421
 */
@Service
public class StorageLocationServiceImpl extends AbstractServiceImpl<StorageLocation> implements StorageLocationService {
    private final StorageLocationMapper storageLocationMapper;

    public StorageLocationServiceImpl(StorageLocationMapper storageLocationMapper) {
        super(storageLocationMapper);
        this.storageLocationMapper = storageLocationMapper;
    }
}
