package com.berrontech.erp.web.user.vo;

import lombok.Data;

/**
 * Create By Levent8421
 * Create Time: 2021/2/6 17:40
 * Class Name: ResetPasswordParam
 * Author: Levent8421
 * Description:
 * 重置密码参数
 *
 * @author Levent8421
 */
@Data
public class ResetPasswordParam {
    private String oldPassword;
    private String password;
}
