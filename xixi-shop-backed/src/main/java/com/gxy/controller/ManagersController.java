package com.gxy.controller;

import com.github.pagehelper.PageInfo;
import com.gxy.entity.backed.Managers;
import com.gxy.entity.common.vo.Result;
import com.gxy.entity.common.vo.Search;
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

    @PostMapping(value = "/findPassword", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result findPassword(@RequestBody Managers managers,String code){
        return managersService.forgetPassword(managers,code);
    }

    @PostMapping(value = "/addManager", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result addManager(@RequestBody Managers managers){
        return managersService.insertModel(managers);
    }

    @DeleteMapping(value = "/deleteManager/{id}")
    public Result deleteManager(@PathVariable int id){
        return managersService.deleteModelById(id);
    }

    @PutMapping(value = "/updateManager")
    public Result updateManager(@RequestBody Managers managers){
        return managersService.updateModel(managers);
    }

    @PostMapping(value = "/getManagerByPage")
    public PageInfo<Managers> getManagersByPages(@RequestBody Search search){
        return managersService.getModelsBySearch(search);
    }

}
