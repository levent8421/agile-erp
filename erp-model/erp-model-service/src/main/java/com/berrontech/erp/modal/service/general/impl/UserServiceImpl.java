package com.berrontech.erp.modal.service.general.impl;

import com.berrontech.erp.commons.entity.User;
import com.berrontech.erp.commons.util.encrypt.MD5Utils;
import com.berrontech.erp.modal.service.basic.impl.AbstractServiceImpl;
import com.berrontech.erp.modal.service.general.UserService;
import com.berrontech.erp.model.repository.general.UserMapper;
import lombok.val;
import org.springframework.stereotype.Service;


/**
 * Create By Levent8421
 * Create Time: mm 15:59
 * Class Name: UserServiceImpl
 * Author: Levent8421
 * Description:
 * 用户相关业务行为实现
 *
 * @author Levent*421
 */
@Service
public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        super(userMapper);
        this.userMapper = userMapper;
    }

    @Override
    public User findByName(String username) {
        return userMapper.selectByName(username);
    }

    @Override
    public User login(String username, String password) {
        val user = findByName(username);
        if (user == null) {
            return null;
        }
        if (MD5Utils.isMatched(user.getPassword(), password)) {
            return user;
        }
        return null;
    }
}
