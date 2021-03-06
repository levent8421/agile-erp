package com.berrontech.erp.modal.service.general.impl;

import com.berrontech.erp.commons.entity.PartRelation;
import com.berrontech.erp.modal.service.basic.impl.AbstractServiceImpl;
import com.berrontech.erp.modal.service.general.PartRelationService;
import com.berrontech.erp.model.repository.general.PartRelationMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2020/12/22 10:54
 * Class Name: PartRelationServiceImpl
 * Author: Levent8421
 * Description:
 * Part Relation Service implementation
 *
 * @author Levent8421
 */
@Service
public class PartRelationServiceImpl extends AbstractServiceImpl<PartRelation> implements PartRelationService {
    private final PartRelationMapper partRelationMapper;

    public PartRelationServiceImpl(PartRelationMapper partRelationMapper) {
        super(partRelationMapper);
        this.partRelationMapper = partRelationMapper;
    }

    @Override
    public List<PartRelation> findByPrimaryPart(Integer partId) {
        return partRelationMapper.selectByPart(partId);
    }
}
