package com.berrontech.erp.web.commons.vo;

import lombok.Data;

/**
 * Create By Levent8421
 * Create Time: 2020/12/29 20:37
 * Class Name: LoginParam
 * Author: Levent8421
 * Description:
 * 登录参数
 *
 * @author Levent8421
 */
@Data
public class LoginParam {
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 密码
     */
    private String password;
}
