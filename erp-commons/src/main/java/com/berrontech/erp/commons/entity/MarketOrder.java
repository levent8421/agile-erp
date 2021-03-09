package com.berrontech.erp.commons.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * Create By Levent8421
 * Create Time: 2021/3/8 16:07
 * Class Name: MarketOrder
 * Author: Levent8421
 * Description:
 * 市场订单实体类
 *
 * @author Levent8421
 */
@Table(name = "t_market_order")
@EqualsAndHashCode(callSuper = true)
@Data
public class MarketOrder extends AbstractEntity {
    /**
     * 状态码
     */
    @Column(name = "state", length = 3, nullable = false)
    private Integer state;
    /**
     * 订单号
     */
    @Column(name = "order_no", nullable = false)
    private String orderNo;
    /**
     * 创建人ID
     */
    @Column(name = "creator_id", length = 10, nullable = false)
    private Integer creatorId;
    /**
     * 创建人
     */
    private User creator;
    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;
    /**
     * 预计发货时间
     */
    @Column(name = "exceed_date", nullable = false)
    private Date exceedDate;
    /**
     * 客户名称
     */
    @Column(name = "customer_name")
    private String customerName;
    /**
     * 发货地址
     */
    @Column(name = "delivery_address")
    private String deliveryAddress;
}
