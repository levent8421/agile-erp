package com.berrontech.erp.web.commons.controller;

import com.berrontech.erp.web.commons.error.ExceptionHandler;
import com.berrontech.erp.web.commons.error.handler.GeneralResultExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;

/**
 * Create By Levent8421
 * Create Time: 2020/8/17 17:51
 * Class Name: AbstractController
 * Author: Levent8421
 * Description:
 * Abstract Controller
 *
 * @author Levent8421
 */
public abstract class AbstractController {
    /**
     * 默认页码
     */
    private static final int DEFAULT_PAGE = 1;
    /**
     * 默认每页大小
     */
    private static final int DEFAULT_ROWS = 10;

    private final ExceptionHandler exceptionHandler;

    public AbstractController() {
        this.exceptionHandler = getExceptionHandler();
    }

    /**
     * Get Default Exception Handler
     *
     * @return exception handler
     */
    protected ExceptionHandler getExceptionHandler() {
        return new GeneralResultExceptionHandler();
    }

    /**
     * 处理异常
     *
     * @param error error exception
     * @return view object
     */
    @org.springframework.web.bind.annotation.ExceptionHandler
    public Object onAnyException(Throwable error) {
        return exceptionHandler.onException(error);
    }

    /**
     * 重定向视图名称
     *
     * @param url 视图
     * @return view name
     */
    protected String redirect(String url) {
        return String.format("redirect:%s", url);
    }

    /**
     * 重定向视图
     *
     * @param url url
     * @return MV
     */
    protected ModelAndView redirectView(String url) {
        final String view = redirect(url);
        return new ModelAndView(view);
    }

    /**
     * 当传入的page=null时返回默认页码，否则返回page
     *
     * @param page 页码
     * @return 页码
     */
    @NotNull
    protected int defaultPage(Integer page) {
        return (page == null || page < 1) ? DEFAULT_PAGE : page;
    }

    /**
     * 当传入的rows==null时返回默认每页大小，否则反回rows
     *
     * @param rows 每页大小
     * @return 每页大小
     */
    @NotNull
    protected int defaultRows(Integer rows) {
        return (rows == null || rows < 1) ? DEFAULT_ROWS : rows;
    }
}
