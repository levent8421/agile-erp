package com.berrontech.erp.model.repository.general;

import com.berrontech.erp.commons.entity.MarketOrder;
import com.berrontech.erp.model.repository.basic.AbstractMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2021/3/9 11:32
 * Class Name: MarketOrderMapper
 * Author: Levent8421
 * Description:
 * 市场订单数据仓库访问组件
 *
 * @author Levent8421
 */
@Repository
public interface MarketOrderMapper extends AbstractMapper<MarketOrder> {
    /**
     * 通过ID查询 同时抓取内部对象
     *
     * @param id id
     * @return order
     */
    MarketOrder selectByIdFetchAll(@Param("id") Integer id);

    /**
     * 查询所有数据 同时抓取内部对象
     *
     * @return list
     */
    List<MarketOrder> selectFetchAll();
}
