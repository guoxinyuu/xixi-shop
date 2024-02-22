package com.gxy.entity.market;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Title: User
 * @Author GUOXINYV
 * @Date 2024/2/6 15:39
 * @description:
 */
@Data
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private String userName;
    private String password;
    private String sex;
    private int age;
    private String address;
    private String phone;
    private String headImg;
    private String userSalt;
    private String email;
}
