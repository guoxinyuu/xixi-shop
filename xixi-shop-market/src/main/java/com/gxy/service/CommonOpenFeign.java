
package com.gxy.service;


import com.gxy.entity.common.Email;
import com.gxy.entity.common.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Component
@FeignClient(value = "xixi-shop-common")
public interface CommonOpenFeign {


    @GetMapping(value = "/api/common/redis/{key}", consumes = MediaType.APPLICATION_JSON_VALUE)
    Map getModel(@PathVariable String key);


    // 在登录时将用户信息存入redis
    @PostMapping(value = "/api/common/redis/{key}")
    Result<Object> insertModel(
            @PathVariable String key,
            @RequestBody Object model,
            @RequestParam(required = false, defaultValue = "0") int timeOut
    );

    @PostMapping(value = "/api/common/sendEmail")
    Result sendEmailCode(@RequestBody Email email);



}

