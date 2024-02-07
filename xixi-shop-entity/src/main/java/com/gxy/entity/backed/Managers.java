package com.gxy.entity.backed;

import lombok.Data;

/**
 * @Title: Managers
 * @Author GUOXINYV
 * @Date 2024/2/5 21:57
 * @description:
 */
@Data
public class Managers {
    private int id;
    private String manageName;
    private String managePhone;
    private String password;
    private int age;
    private String sex;
    private String salt;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManageName() {
        return manageName;
    }

    public void setManageName(String manageName) {
        this.manageName = manageName;
    }

    public String getManagePhone() {
        return managePhone;
    }

    public void setManagePhone(String managePhone) {
        this.managePhone = managePhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
