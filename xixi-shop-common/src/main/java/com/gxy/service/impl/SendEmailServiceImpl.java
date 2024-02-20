package com.gxy.service.impl;

import com.gxy.entity.common.Email;
import com.gxy.entity.common.vo.Result;
import com.gxy.entity.utils.StringUtil;
import com.gxy.service.SendEmailService;
import com.gxy.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: SendEmailServiceImpl
 * @Author GUOXINYV
 * @Date 2024/2/8 0:31
 * @description:
 */
@Service
public class SendEmailServiceImpl implements SendEmailService {
    @Autowired
    RedisServiceImpl redisService;
    @Autowired
    private EmailUtil emailUtil;
    @Override
    public Result<String> sendEmail(Email email) {
        if(email==null) return new Result<>(500,"请输入邮箱");
        //获取邮箱
        String e = email.getEmail();
        //邮箱验证
        if(!StringUtil.checkEmail(e)) return new Result<>(500,"邮箱不正确");
        //随机生成6位验证码
        String code=StringUtil.randomSixCode();
        //正文
        String content = "亲爱的用户：\n" +
                "您此次的验证码为：\n\n" +
                code + "\n\n" +
                "此验证码5分钟内有效，请立即进行下一步操作。 如非你本人操作，请忽略此邮件。\n" +
                "感谢您的使用！";
        HashMap<String, Object> map = emailUtil.sendSimpleMail(e, "此次验证码为：" + code, content);
        if(map.get("status").equals("success")){
            //发送成功就将验证码放到缓存中，设置过期时间为5分钟
            Map<String, String> map1 = new HashMap<>();
            map1.put("code", code);
            redisService.insertModel("emailCode",map1,5);
            return new Result<>(200,"验证码发送成功");
        }else return new Result<>(500,"验证码发送失败");
    }
}
