package com.gxy.controller;

import com.gxy.entity.common.Email;
import com.gxy.entity.common.vo.Result;
import com.gxy.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: SendEmailController
 * @Author GUOXINYV
 * @Date 2024/2/8 0:57
 * @description:
 */
@RestController
@RequestMapping("/api/common")
public class SendEmailController {
    @Autowired
    SendEmailService sendEmailService;
    @PostMapping("/sendEmail")
    public Result sendCode(@RequestBody Email email){
        return sendEmailService.sendEmail(email);
    }
}
