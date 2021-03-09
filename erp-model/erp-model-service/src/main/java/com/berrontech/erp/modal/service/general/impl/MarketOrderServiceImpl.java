package com.berrontech.erp.modal.service.general.impl;

import com.berrontech.erp.commons.entity.MarketOrder;
import com.berrontech.erp.commons.util.SerialNumberGenerator;
import com.berrontech.erp.modal.service.basic.impl.AbstractServiceImpl;
import com.berrontech.erp.modal.service.general.MarketOrderService;
import com.berrontech.erp.model.repository.general.MarketOrderMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Create By Levent8421
 * Create Time: 2021/3/9 13:26
 * Class Name: MarketOrderServiceImpl
 * Author: Levent8421
 * Description:
 * 市场订单次昂管业务行为实现
 *
 * @author Levent8421
 */
@Slf4j
@Service
public class MarketOrderServiceImpl extends AbstractServiceImpl<MarketOrder> implements MarketOrderService {
    private final MarketOrderMapper marketOrderMapper;
    private final SerialNumberGenerator orderNoGenerator = new SerialNumberGenerator("M", "", 4);

    public MarketOrderServiceImpl(MarketOrderMapper marketOrderMapper) {
        super(marketOrderMapper);
        this.marketOrderMapper = marketOrderMapper;
    }

    @Override
    public MarketOrder create(MarketOrder order) {
        final String orderNo = orderNoGenerator.next();
        log.info("Create marketOrder with orderNo [{}]", orderNo);
        order.setOrderNo(orderNo);
        return save(order);
    }

    @Override
    public MarketOrder requireWithAll(Integer id) {
        return marketOrderMapper.selectByIdFetchAll(id);
    }

    @Override
    public PageInfo<MarketOrder> listWithAll(int page, int rows) {
        return PageHelper.startPage(page, rows).doSelectPageInfo(marketOrderMapper::selectFetchAll);
    }
}
