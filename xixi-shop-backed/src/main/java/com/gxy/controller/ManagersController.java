package com.gxy.controller;

import com.gxy.entity.backed.Managers;
import com.gxy.entity.common.vo.Result;
import com.gxy.service.ManagersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: ManagersController
 * @Author GUOXINYV
 * @Date 2024/2/7 14:45
 * @description:
 */
@RestController
@RequestMapping("/api/manage")
public class ManagersController {
    @Autowired
    ManagersService managersService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> login(@RequestBody Managers managers){
        return managersService.login(managers);
    }

    @PostMapping(value = "/findPassword/{code}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result findPassword(@RequestBody Managers managers, @PathVariable("code") String code){
        return managersService.forgetPassword(managers,code);
    }
}
