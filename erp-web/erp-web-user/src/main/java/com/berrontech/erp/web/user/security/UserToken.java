package com.berrontech.erp.web.user.security;

import com.auth0.jwt.JWTCreator;
import com.berrontech.erp.commons.entity.User;
import com.berrontech.erp.web.commons.security.TokenDataHolder;
import com.berrontech.erp.web.commons.security.jwt.AbstractJwtToken;

/**
 * Create By Levent8421
 * Create Time: 2020/12/29 19:35
 * Class Name: UserToken
 * Author: Levent8421
 * Description:
 * 用户令牌
 *
 * @author Levent8421
 */
public class UserToken extends AbstractJwtToken {
    /**
     * User ID
     */
    public static final String USER_ID = "uid";

    /**
     * Find user id from token date holder
     *
     * @param dataHolder holder
     * @return uid
     */
    public static Integer obtainUserIdFromHolder(TokenDataHolder dataHolder) {
        return dataHolder.get(USER_ID, Integer.class);
    }

    private static final int TTL = 7 * 24 * 60 * 60 * 1000;
    private final User user;

    public UserToken(String key, User user) {
        super(key, TTL);
        this.user = user;
    }

    @Override
    protected void initClaims(JWTCreator.Builder builder) {
        builder.withClaim(USER_ID, user.getId());
    }
}
