package com.berrontech.erp.web.commons.interceptor;

import com.alibaba.fastjson.JSON;
import com.berrontech.erp.commons.exception.PermissionDeniedException;
import com.berrontech.erp.web.commons.security.TokenDataHolder;
import com.berrontech.erp.web.commons.security.TokenException;
import com.berrontech.erp.web.commons.security.TokenVerifier;
import com.berrontech.erp.web.commons.vo.GeneralResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Create By Levent8421
 * Create Time: 2020/8/20 12:17
 * Class Name: AbstractTokenInterceptor
 * Author: Levent8421
 * Description:
 * Token Interceptor
 *
 * @author Levent8421
 */
@Slf4j
public abstract class AbstractTokenInterceptor implements HandlerInterceptor, ApplicationContextAware {
    private static final String TOKEN_PARAM_NAME = "token";
    private static final String TOKEN_HEADER_NAME = "X-Token";
    private ApplicationContext applicationContext;
    private PathMatcher pathMatcher;

    private String tryFindToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_HEADER_NAME);
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(TOKEN_PARAM_NAME);
        }
        return token;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!needAuthorization(request)) {
            return true;
        }
        try {
            doInterceptor(request);
            return true;
        } catch (Exception e) {
            writeErrorData(response, e);
            log.warn("PermissionDenied [{}],[{},{}]", request.getRequestURI(),
                    e.getClass().getSimpleName(), e.getMessage());
            return false;
        }
    }

    /**
     * ??????????????????????????????
     *
     * @param request request
     * @return need?
     */
    protected abstract boolean needAuthorization(HttpServletRequest request);

    /**
     * ??????Token?????????
     *
     * @return verifier
     */
    protected abstract TokenVerifier getTokenVerifier();

    /**
     * ?????????????????????
     *
     * @return holder
     */
    protected abstract TokenDataHolder getDataHolder();

    private void doInterceptor(HttpServletRequest request) throws TokenException {
        final String token = tryFindToken(request);
        if (StringUtils.isBlank(token)) {
            throw new PermissionDeniedException("No Token!");
        }
        final TokenVerifier verifier = getTokenVerifier();
        final Map<String, Object> claims = verifier.verifyAndDecode(token);
        getDataHolder().putAll(claims);
    }

    private void writeErrorData(HttpServletResponse response, Throwable error) {
        final String errorMessage = String.format("Error [%s]:%s", error.getClass().getSimpleName(), error.getMessage());
        final GeneralResult<?> res = GeneralResult.permissionDenied(errorMessage);
        final String errorJson = JSON.toJSONString(res);
        try {
            final PrintWriter writer = response.getWriter();
            writer.write(errorJson);
            writer.flush();
        } catch (IOException e) {
            log.warn("Error on write error message to http response", e);
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        getDataHolder().clearData();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private PathMatcher obtainPathMatcher() {
        if (pathMatcher == null) {
            pathMatcher = applicationContext.getBean(PathMatcher.class);
        }
        return pathMatcher;
    }

    /**
     * ???????????????????????????
     *
     * @param pattern ??????
     * @param path    ??????
     * @return ????????????
     */
    protected boolean matchPath(String pattern, String path) {
        return obtainPathMatcher().match(pattern, path);
    }
}
