package com.berrontech.erp.model.repository.general;

import com.berrontech.erp.commons.entity.Part;
import com.berrontech.erp.model.repository.basic.AbstractMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2020/2/13 17:57
 * Class Name: PartMapper
 * Author: Levent8421
 * Description:
 * 物料相关数据库访问组件
 *
 * @author Levent8421
 */
@Repository
public interface PartMapper extends AbstractMapper<Part> {
    /**
     * 搜索物料
     *
     * @param query query
     * @param max   max
     * @return parts
     */
    List<Part> search(@Param("query") String query, @Param("max") Integer max);
}
