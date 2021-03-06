package com.berrontech.erp.commons.util;

import com.google.common.base.Strings;

/**
 * Create By Levent8421
 * Create Time: 2021/1/11 20:46
 * Class Name: ExceptionUtils
 * Author: Levent8421
 * Description:
 * 异常处理相关工具类
 *
 * @author Levent8421
 */
public class ExceptionUtils {
    private static final String EXCEPTION_2_STRING_TEMPLATE = "%s:%s";
    private static final String NULL = "null";

    /**
     * As exception string
     *
     * @param e e
     * @return errString
     */
    public static String asString(Throwable e) {
        if (e == null) {
            return NULL;
        }
        final Class<? extends Throwable> errClass = e.getClass();
        final String err = e.getMessage();
        return Strings.lenientFormat(EXCEPTION_2_STRING_TEMPLATE, errClass.getSimpleName(), err);
    }

    public static String asString(Throwable e, String prefix) {
        return prefix + "," + asString(e);
    }
}
