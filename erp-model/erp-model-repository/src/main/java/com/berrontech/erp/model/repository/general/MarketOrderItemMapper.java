package com.berrontech.erp.model.repository.general;

import com.berrontech.erp.commons.entity.MarketOrderItem;
import com.berrontech.erp.model.repository.basic.AbstractMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2021/3/9 11:33
 * Class Name: MarketOrderItemMapper
 * Author: Levent8421
 * Description:
 * 时长订单项相关数据仓库访问组件
 *
 * @author Levent8421
 */
@Repository
public interface MarketOrderItemMapper extends AbstractMapper<MarketOrderItem> {
    /**
     * Select by order id fetch all inner objects
     *
     * @param orderId orderId
     * @return order items
     */
    List<MarketOrderItem> selectByOrderFetchAll(@Param("orderId") Integer orderId);
}
