package com.berrontech.erp.commons.context;

/**
 * Create By Levent8421
 * Create Time: 2021/1/7 14:11
 * Class Name: MessageState
 * Author: Levent8421
 * Description:
 * Message state
 *
 * @author Levent8421
 */
public class MessageState {
    /**
     * 状态：等待回应
     */
    public static final int STATE_WAITING_FOR_RESPONSE = 0x01;
    /**
     * 状态：交互成功
     */
    public static final int STATE_SUCCESS = 0x02;
    /**
     * 状态：通信超时
     */
    public static final int STATE_TIMEOUT = 0x03;
    /**
     * 状态：通信错误
     */
    public static final int STATE_ERROR = 0x04;
}
