package com.berrontech.erp.commons.util;

/**
 * Create By Levent8421
 * Create Time: 2021/1/13 18:53
 * Class Name: NoReturnFunction
 * Author: Levent8421
 * Description:
 * No Return Function
 *
 * @author Levent8421
 */
@FunctionalInterface
public interface NoReturnFunction<T> {
    /**
     * function
     *
     * @param arg arg
     */
    void apply(T arg);
}
