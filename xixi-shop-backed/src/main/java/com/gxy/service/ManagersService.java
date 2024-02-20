package com.gxy.service;

import com.gxy.entity.backed.Managers;
import com.gxy.entity.common.vo.Result;
import com.gxy.entity.service.ModelService;

/**
 * @Title: ManagersService
 * @Author GUOXINYV
 * @Date 2024/2/6 16:48
 * @description:
 */

public interface ManagersService extends ModelService<Managers> {
    Result<String> login(Managers managers);
    Result<String> forgetPassword(Managers managers,String code);
//    Result<String> deleteManage(Managers managers);
}
