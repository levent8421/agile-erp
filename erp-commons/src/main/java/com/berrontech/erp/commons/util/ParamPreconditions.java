package com.berrontech.erp.commons.util;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

/**
 * Create By Levent8421
 * Create Time: 2021/1/11 20:58
 * Class Name: ParamPreconditions
 * Author: Levent8421
 * Description:
 * 参数检查
 *
 * @author Levent8421
 */
public class ParamPreconditions {
    public static <T> void notNullAndSet(T value, String message, NoReturnFunction<T> setter) {
        Preconditions.checkNotNull(value, message);
        setter.apply(value);
    }

    public static <T extends CharSequence> void notBlankAndSet(T value, String message, NoReturnFunction<T> setter) {
        notBlank(value, message);
        setter.apply(value);
    }

    public static void notBlank(CharSequence value, String message) {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException(message);
        }
    }
}
