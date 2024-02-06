package com.gxy.entity.utils;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.UUID;

/**
 * @Title: MdFiveUtil
 * @Author GUOXINYV
 * @Date 2023/10/7 13:26
 * @description:
 */
public class MdFiveUtil {
    public static String pwdChange(String pwd,String salt){
        //创建盐值对象
        Object o = new Md5Hash(salt);
        //加密密码
        Object o1=new SimpleHash("MD5",pwd,o,1024);
        return o1+"";
    }

    public static void main(String[] args) {
        String slat=UUID.randomUUID()+ "";
        System.out.println(slat);
        String pwd= pwdChange("123456",slat);
        System.out.println(pwd);

    }
}
