package com.berrontech.erp.modal.service.general;

import com.berrontech.erp.commons.entity.User;
import com.berrontech.erp.modal.service.basic.AbstractService;

/**
 * Create By Levent8421
 * Create Time: 2020/1/8 15:58
 * Class Name: UserService
 * Author: Levent8421
 * Description:
 * 用户相关业务行为定义
 *
 * @author Levent*421
 */
public interface UserService extends AbstractService<User> {
    /**
     * Final User By Username
     *
     * @param username username
     * @return user
     */
    User findByName(String username);

    /**
     * 登录
     *
     * @param username username
     * @param password password
     * @return User
     */
    User login(String username, String password);
}
