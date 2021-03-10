package com.berrontech.erp.commons.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
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
    /**
     * 市场订单ID
     */
    @Column(name = "market_order_id", length = 10, nullable = false)
    private Integer marketOrderId;
    /**
     * 关联的市场订单
     */
    private MarketOrder marketOrder;
    /**
     * 物料ID
     */
    @Column(name = "part_id", length = 10, nullable = false)
    private Integer partId;
    /**
     * 关联的物料对象
     */
    private Part part;
    /**
     * 数量
     */
    @Column(name = "pcs", length = 20, nullable = false)
    private BigDecimal pcs;
    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;
    /**
     * 状态
     */
    @Column(name = "state", length = 2, nullable = false)
    private Integer state;
}
