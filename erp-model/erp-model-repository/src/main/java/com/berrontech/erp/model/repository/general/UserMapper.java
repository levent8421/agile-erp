package com.berrontech.erp.model.repository.general;

import com.berrontech.erp.commons.entity.User;
import com.berrontech.erp.model.repository.basic.AbstractMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Create By Levent8421
 * Create Time: 2020/1/8 15:40
 * Class Name: UserMapper
 * Author: Levent8421
 * Description:
 * 用户相关数据库访问组件
 *
 * @author Levent*421
 */
@Repository
public interface UserMapper extends AbstractMapper<User> {
    /**
     * Final User by Username
     *
     * @param username Username
     * @return user
     */
    User selectByName(@Param("username") String username);
}
