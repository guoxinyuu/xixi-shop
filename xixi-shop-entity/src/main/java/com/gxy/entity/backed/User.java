package com.gxy.entity.backed;

import lombok.Data;

/**
 * @Title: User
 * @Author GUOXINYV
 * @Date 2024/2/6 15:39
 * @description:
 */
@Data
public class User {
    private int id;
    private String userName;
    private String password;
    private String sex;
    private int age;
    private String address;
    private String phone;
    private String headImg;
    private String userSalt;
}
