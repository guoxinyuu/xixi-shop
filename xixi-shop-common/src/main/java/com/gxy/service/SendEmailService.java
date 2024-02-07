package com.gxy.service;

import com.gxy.entity.common.Email;
import com.gxy.entity.common.vo.Result;

/**
 * @Title: SendEmail
 * @Author GUOXINYV
 * @Date 2024/2/7 23:14
 * @description:
 */
public interface SendEmailService {
    Result<String> sendEmail(Email email);
}
