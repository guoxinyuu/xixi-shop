package com.gxy.util;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.springframework.stereotype.Component;


/**
 * @Title: EmailUtil
 * @Author GUOXINYV
 * @Date 2024/2/8 0:36
 * @description:
 */
@Component
public class EmailUtil {
    @Resource
    private JavaMailSender javaMailSender;

    @Autowired
    public EmailUtil(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    @Value("${spring.mail.username}")
    private String from;
    /**
     * 发送简单的邮箱
     *
     * @param to 收件人
     * @param theme 标题
     * @param content 正文内容
     * @param cc 抄送
     * @return HashMap 包含发送邮件的结果信息
     */
    public HashMap<String, Object> sendSimpleMail(String to, String theme, String content, String... cc) {
        HashMap<String, Object> resultMap = new HashMap<>();

        // 创建邮件对象
        SimpleMailMessage message = new SimpleMailMessage();

        try {
            message.setFrom(String.valueOf(new InternetAddress(from, "曦曦零食铺", "UTF-8")));      // 发件人
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        message.setTo(to);          // 收件人
        message.setSubject(theme);  // 标题
        message.setText(content);   // 内容

        if (ArrayUtils.isNotEmpty(cc)) {
            message.setCc(cc);
        }

        try {
            // 发送邮件
            javaMailSender.send(message);

            // 发送成功，设置结果信息
            resultMap.put("status", "success");
            resultMap.put("message", "邮件发送成功");

        } catch (Exception e) {
            // 发送失败，设置结果信息
            resultMap.put("status", "error");
            resultMap.put("message", e.getMessage());
        }

        return resultMap;
    }
}
