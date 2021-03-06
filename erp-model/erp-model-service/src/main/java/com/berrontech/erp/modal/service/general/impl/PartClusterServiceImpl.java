package com.berrontech.erp.modal.service.general.impl;

import com.berrontech.erp.commons.entity.PartCluster;
import com.berrontech.erp.modal.service.basic.impl.AbstractServiceImpl;
import com.berrontech.erp.modal.service.general.PartClusterService;
import com.berrontech.erp.model.repository.general.PartClusterMapper;
import org.springframework.stereotype.Service;

/**
 * Create By Levent8421
 * Create Time: 2020/2/13 0:04
 * Class Name: PartClusterServiceImpl
 * Author: Levent8421
 * Description:
 * 物料类型相关业务行为实现
 *
 * @author Levent8421
 */
@Service
public class PartClusterServiceImpl extends AbstractServiceImpl<PartCluster> implements PartClusterService {
    private final PartClusterMapper partClusterMapper;

    public PartClusterServiceImpl(PartClusterMapper partClusterMapper) {
        super(partClusterMapper);
        this.partClusterMapper = partClusterMapper;
    }
}
