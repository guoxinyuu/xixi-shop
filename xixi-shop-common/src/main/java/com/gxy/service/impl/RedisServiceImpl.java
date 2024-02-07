package com.gxy.service.impl;

import com.gxy.entity.common.vo.Result;
import com.gxy.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Title: RedisServiceImpl
 * @Author GUOXINYV
 * @Date 2024/2/7 15:04
 * @description:
 */
@Slf4j
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Override
    public <T> Result<T> insertModel(String key, T model, long timeOut) {
        if (timeOut > 0 ) {
            redisTemplate.opsForValue().set(key, model, timeOut, TimeUnit.MINUTES);
        } else {
            redisTemplate.opsForValue().set(key, model);
        }
        return new Result<>(200,"success",model);
    }

    @Override
    public Result<Object> deleteModels(String... key) {
        redisTemplate.delete(Stream.of(key).collect(Collectors.toList()));
        return new Result<>(200,"success");
    }

    @Override
    public Map getModel(String key) {
        return (Map) redisTemplate.opsForValue().get(key);
    }

    @Override
    public Result<Object> expire(String key, long timeOut) {
        redisTemplate.expire(key, timeOut, TimeUnit.SECONDS);
        return new Result<>(200,"success");

    }
}
