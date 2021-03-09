package com.berrontech.erp.commons.context;

/**
 * Create By Levent8421
 * Create Time: 2021/3/9 14:23
 * Class Name: OrderState
 * Author: Levent8421
 * Description:
 * 订单状态描述类
 *
 * @author Levent8421
 */
public enum OrderState {
    /**
     * 订单状态：创建
     */
    CREATED(0x01, "created"),
    /**
     * 订单状态：完成
     */
    COMPLETED(0x02, "completed");

    OrderState(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int code;
    private String name;
}
