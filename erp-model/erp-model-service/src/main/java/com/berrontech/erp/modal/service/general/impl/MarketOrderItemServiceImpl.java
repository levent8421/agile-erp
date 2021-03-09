package com.berrontech.erp.modal.service.general.impl;

import com.berrontech.erp.commons.entity.MarketOrderItem;
import com.berrontech.erp.modal.service.basic.impl.AbstractServiceImpl;
import com.berrontech.erp.modal.service.general.MarketOrderItemService;
import com.berrontech.erp.model.repository.general.MarketOrderItemMapper;
import org.springframework.stereotype.Service;

/**
 * Create By Levent8421
 * Create Time: 2021/3/9 13:27
 * Class Name: MarketOrderItemServiceImpl
 * Author: Levent8421
 * Description:
 * 市场订单详情相关业务行为实现
 *
 * @author Levent8421
 */
@Service
public class MarketOrderItemServiceImpl extends AbstractServiceImpl<MarketOrderItem> implements MarketOrderItemService {
    private final MarketOrderItemMapper marketOrderItemMapper;

    public MarketOrderItemServiceImpl(MarketOrderItemMapper marketOrderItemMapper) {
        super(marketOrderItemMapper);
        this.marketOrderItemMapper = marketOrderItemMapper;
    }
}
