package com.berrontech.erp.modal.service.general;

import com.berrontech.erp.commons.entity.MarketOrderItem;
import com.berrontech.erp.modal.service.basic.AbstractService;

import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2021/3/9 13:26
 * Class Name: MarketOrderItemService
 * Author: Levent8421
 * Description:
 * 市场订单详情相关业务行为定义
 *
 * @author Levent8421
 */
public interface MarketOrderItemService extends AbstractService<MarketOrderItem> {
    /**
     * 通过订单ID查询订单项
     *
     * @param orderId 订单ID
     * @return items
     */
    List<MarketOrderItem> findByOrderFetchAll(Integer orderId);

    /**
     * 创建订单项
     *
     * @param item item
     */
    void create(MarketOrderItem item);
}
