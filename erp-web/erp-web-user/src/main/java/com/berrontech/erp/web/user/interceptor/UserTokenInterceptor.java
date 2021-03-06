package com.berrontech.erp.web.user.interceptor;

import com.berrontech.erp.web.commons.interceptor.AbstractTokenInterceptor;
import com.berrontech.erp.web.commons.security.TokenDataHolder;
import com.berrontech.erp.web.commons.security.TokenVerifier;
import com.berrontech.erp.web.user.security.UserTokenVerifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2020/12/29 19:40
 * Class Name: UserTokenInterceptor
 * Author: Levent8421
 * Description:
 * 用户令牌拦截器
 *
 * @author Levent8421
 */
@Component
public class UserTokenInterceptor extends AbstractTokenInterceptor {
    private final TokenDataHolder tokenDataHolder;
    private final UserTokenVerifier userTokenVerifier;
    private final List<String> interceptorList;

    public UserTokenInterceptor(TokenDataHolder tokenDataHolder,
                                UserTokenVerifier userTokenVerifier) {
        this.tokenDataHolder = tokenDataHolder;
        this.userTokenVerifier = userTokenVerifier;
        interceptorList = new ArrayList<>();
        loadInterceptorPaths();
    }

    private void loadInterceptorPaths() {
        interceptorList.add("/api/token/**");
    }

    @Override
    protected boolean needAuthorization(HttpServletRequest request) {
        final String uri = request.getRequestURI();
        for (String path : interceptorList) {
            if (matchPath(path, uri)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected TokenVerifier getTokenVerifier() {
        return userTokenVerifier;
    }

    @Override
    protected TokenDataHolder getDataHolder() {
        return tokenDataHolder;
    }
}
