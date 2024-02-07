package com.gxy.service;

import com.gxy.entity.common.vo.Result;

import java.util.Map;

public interface RedisService {

    <T> Result<T> insertModel(String key, T model, long timeOut);

    Result<Object> deleteModels(String... key);

    Map getModel(String key);

    Result<Object> expire(String key, long timeOut);
}
