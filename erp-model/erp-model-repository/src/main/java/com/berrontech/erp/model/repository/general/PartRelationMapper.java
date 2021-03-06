package com.berrontech.erp.model.repository.general;

import com.berrontech.erp.commons.entity.PartRelation;
import com.berrontech.erp.model.repository.basic.AbstractMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2020/12/22 10:45
 * Class Name: PartRelationMapper
 * Author: Levent8421
 * Description:
 * Part relation
 *
 * @author Levent8421
 */
@Repository
public interface PartRelationMapper extends AbstractMapper<PartRelation> {
    /**
     * Find child part relation by primary part id
     *
     * @param partId primary part id
     * @return child part relations
     */
    List<PartRelation> selectByPart(@Param("partId") Integer partId);
}
