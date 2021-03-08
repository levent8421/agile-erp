package com.berrontech.erp.commons.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Create By Levent8421
 * Create Time: 2021/3/8 16:15
 * Class Name: MarketOrderItem
 * Author: Levent8421
 * Description:
 * 市场订单项
 *
 * @author Levent8421
 */
@Table(name = "t_market_order_item")
@EqualsAndHashCode(callSuper = true)
@Data
public class MarketOrderItem extends AbstractEntity {
    private Integer marketOrderId;
    private Integer partId;
    private BigDecimal pcs;
    private String remark;
    private Integer state;
}
