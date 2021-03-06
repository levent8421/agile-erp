package com.berrontech.erp.web.user.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.berrontech.erp.web.commons.conf.TokenConfiguration;
import com.berrontech.erp.web.commons.security.jwt.AbstractJwtTokenVerifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Create By Levent8421
 * Create Time: 2020/12/29 19:37
 * Class Name: UserTokenVerifier
 * Author: Levent8421
 * Description:
 * 用户令牌校验组件
 *
 * @author Levent8421
 */
@Component
public class UserTokenVerifier extends AbstractJwtTokenVerifier {
    public UserTokenVerifier(TokenConfiguration tokenConfiguration) {
        super(tokenConfiguration);
    }

    @Override
    protected Map<String, Object> getPayload(DecodedJWT jwt) {
        final Map<String, Object> payload = new HashMap<>(16);
        final Integer userId = jwt.getClaim(UserToken.USER_ID).asInt();
        payload.put(UserToken.USER_ID, userId);
        return payload;
    }
}
