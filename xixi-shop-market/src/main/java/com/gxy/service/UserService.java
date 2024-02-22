package com.gxy.service;

import com.gxy.entity.common.vo.Result;
import com.gxy.entity.market.User;
import com.gxy.entity.service.ModelService;

/**
 * @Title: UserSerivce
 * @Author GUOXINYV
 * @Date 2024/2/22 10:35
 * @description:
 */
public interface UserService extends ModelService<User> {
    Result login(User user);
    Result<String> forgetPassword(User user,String code);
}
