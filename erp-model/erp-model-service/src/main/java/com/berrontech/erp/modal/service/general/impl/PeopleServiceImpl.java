package com.berrontech.erp.modal.service.general.impl;

import com.berrontech.erp.commons.entity.People;
import com.berrontech.erp.modal.service.basic.impl.AbstractServiceImpl;
import com.berrontech.erp.modal.service.general.PeopleService;
import com.berrontech.erp.model.repository.general.PeopleMapper;
import org.springframework.stereotype.Service;

/**
 * Create By Levent8421
 * Create Time: 2020/2/14 18:26
 * Class Name: PeopleServiceImpl
 * Author: Levent8421
 * Description:
 * 联系人相关业务行为实现
 *
 * @author Levent8421
 */
@Service
public class PeopleServiceImpl extends AbstractServiceImpl<People> implements PeopleService {
    private final PeopleMapper peopleMapper;

    public PeopleServiceImpl(PeopleMapper peopleMapper) {
        super(peopleMapper);
        this.peopleMapper = peopleMapper;
    }
}
