package com.berrontech.erp.modal.service.general;

import com.berrontech.erp.commons.entity.PartCategory;
import com.berrontech.erp.commons.entity.PartType;
import com.berrontech.erp.modal.service.basic.AbstractService;
import com.berrontech.erp.modal.service.vo.PartTypeVo;

import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2020/2/12 0:22
 * Class Name: PartCategoryService
 * Author: Levent8421
 * Description:
 * 库存类别相关业务行为定义
 *
 * @author Levent8421
 */
public interface PartCategoryService extends AbstractService<PartCategory> {
    /**
     * Find By PartTypeId
     *
     * @param typeId partTypeId
     * @return Category List
     */
    List<PartCategory> findByTypeId(Integer typeId);

    /**
     * As type-Categories Tree
     *
     * @param types      types
     * @param categories categories
     * @return PartTypeVo List
     */
    List<PartTypeVo> asTree(List<PartType> types, List<PartCategory> categories);
}
