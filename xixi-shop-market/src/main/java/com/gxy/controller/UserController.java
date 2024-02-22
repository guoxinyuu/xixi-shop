package com.gxy.controller;

import com.gxy.entity.common.vo.Result;
import com.gxy.entity.market.User;
import com.gxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: UserController
 * @Author GUOXINYV
 * @Date 2024/2/22 14:18
 * @description:
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result login(@RequestBody User user){
        return userService.login(user);
    }

    @PostMapping(value = "/forgetPwd/{code}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result forgetPwd(@RequestBody User user, @PathVariable String code){
        return userService.forgetPassword(user,code);
    }

    @PostMapping(value = "/addUser",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result addUser(@RequestBody User user){
        return userService.insertModel(user);
    }

    @PutMapping(value = "/updateUser",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result updateUser(@RequestBody User user){
        return userService.updateModel(user);
    }

    @DeleteMapping(value = "/deleteUser/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result deleteUser(@PathVariable int id){
        return userService.deleteModelById(id);
    }
}
