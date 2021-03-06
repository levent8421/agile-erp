package com.berrontech.erp.modal.service.general.impl;

import com.berrontech.erp.commons.entity.PartCategory;
import com.berrontech.erp.commons.entity.PartType;
import com.berrontech.erp.modal.service.basic.impl.AbstractServiceImpl;
import com.berrontech.erp.modal.service.general.PartCategoryService;
import com.berrontech.erp.modal.service.vo.PartTypeVo;
import com.berrontech.erp.model.repository.general.PartCategoryMapper;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2020/2/12 0:23
 * Class Name: PartCategoryServiceImpl
 * Author: Levent8421
 * Description:
 * 库存类别相关业务行为实现
 *
 * @author Levent8421
 */
@Service
public class PartCategoryServiceImpl extends AbstractServiceImpl<PartCategory> implements PartCategoryService {
    private final PartCategoryMapper partCategoryMapper;

    public PartCategoryServiceImpl(PartCategoryMapper partCategoryMapper) {
        super(partCategoryMapper);
        this.partCategoryMapper = partCategoryMapper;
    }

    @Override
    public List<PartCategory> findByTypeId(Integer typeId) {
        return partCategoryMapper.selectByTypeId(typeId);
    }

    @Override
    public List<PartTypeVo> asTree(List<PartType> types, List<PartCategory> categories) {
        val categoriesMap = new HashMap<Integer, List<PartCategory>>(16);
        for (val category : categories) {
            val list = categoriesMap.computeIfAbsent(category.getPartTypeId(), k -> new ArrayList<>());
            list.add(category);
        }
        val res = new ArrayList<PartTypeVo>();
        for (val type : types) {
            val list = categoriesMap.get(type.getId());
            val typeVo = new PartTypeVo(type);
            typeVo.setPartCategories(list);
            res.add(typeVo);
        }
        return res;
    }
}
