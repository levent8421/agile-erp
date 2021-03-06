package com.berrontech.erp.model.repository.general;

import com.berrontech.erp.commons.entity.PartCategory;
import com.berrontech.erp.model.repository.basic.AbstractMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2020/2/11 23:39
 * Class Name: PartCategoryMapper
 * Author: Levent8421
 * Description:
 * 库存类别相关数据库访问组件
 *
 * @author Levent8421
 */

public interface PartCategoryMapper extends AbstractMapper<PartCategory> {
    /**
     * Select Categories By TypeId
     *
     * @param typeId typeId
     * @return categories
     */
    List<PartCategory> selectByTypeId(@Param("typeId") Integer typeId);
}
