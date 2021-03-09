package com.berrontech.erp.modal.service.general;

import com.berrontech.erp.commons.entity.MarketOrder;
import com.berrontech.erp.modal.service.basic.AbstractService;
import com.github.pagehelper.PageInfo;

/**
 * Create By Levent8421
 * Create Time: 2021/3/9 13:25
 * Class Name: MarketOrderService
 * Author: Levent8421
 * Description:
 * 市场订单相关业务行为定义
 *
 * @author Levent8421
 */
public interface MarketOrderService extends AbstractService<MarketOrder> {
    /**
     * 创建市场订单
     *
     * @param order 订单
     * @return 创建结果
     */
    MarketOrder create(MarketOrder order);

    /**
     * Find by id fetch user
     *
     * @param id id
     * @return order
     */
    MarketOrder requireWithAll(Integer id);

    /**
     * 分页查询数据 抓取内部对象
     *
     * @param page 页码
     * @param rows 行数
     * @return PageInfo
     */
    PageInfo<MarketOrder> listWithAll(int page, int rows);
}
