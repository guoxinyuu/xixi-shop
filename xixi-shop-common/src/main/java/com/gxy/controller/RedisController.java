package com.gxy.controller;

import com.gxy.entity.common.vo.Result;
import com.gxy.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Title: RedisController
 * @Author GUOXINYV
 * @Date 2024/2/7 15:12
 * @description:
 */
@RestController
@RequestMapping(value = "/api/common")
public class RedisController {
    @Autowired
    private RedisService redisService;

    /**
     * 127.0.0.1/api/common/redis/name?timeOut=100 ---- post
     */
    @PostMapping(value = "/redis/{key}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Object> insertModel(
            @PathVariable String key,
            @RequestBody Object model,
            @RequestParam(required = false, defaultValue = "0") int timeOut) {
        return redisService.insertModel(key, model, timeOut);
    }

    /**
     * 127.0.0.1/api/common/redis/name?timeOut=100 ---- put
     */
    @PutMapping(value = "/redis/{key}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Object> updateModel(
            @PathVariable String key,
            @RequestBody Object model,
            @RequestParam(required = false, defaultValue = "0") int timeOut) {
        return redisService.insertModel(key, model, timeOut);
    }

    /**
     * 127.0.0.1/api/common/redis/name ---- delete
     */
    @DeleteMapping(value = "/redis/{key}")
    public Result<Object> deleteModels(@PathVariable String key) {
        return redisService.deleteModels(key);
    }

    /**
     * 127.0.0.1/api/common/redis/name ---- get
     */
    @GetMapping(value = "/redis/{key}")
    public Map getModel(@PathVariable String key) {
        return redisService.getModel(key);
    }

    /**
     * 127.0.0.1/api/common/redis/expire/name?timeOut=100 ---- put
     */
    @PutMapping(value = "/redis/expire/{key}")
    public Result<Object> expire(@PathVariable String key, @RequestParam long timeOut) {
        return redisService.expire(key, timeOut);
    }
}
