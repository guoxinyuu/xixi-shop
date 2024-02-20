package com.gxy.entity.common;

import lombok.Data;

/**
 * @Title: Email
 * @Author GUOXINYV
 * @Date 2024/2/7 23:39
 * @description:
 */
@Data
public class Email {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
