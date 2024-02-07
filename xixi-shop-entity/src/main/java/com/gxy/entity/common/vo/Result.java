package com.gxy.entity.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Title: Result
 * @Author GUOXINYV
 * @Date 2024/2/6 15:43
 * @description:
 */


public class Result<T> {
    private int code;
    private String message;
    private T data;

    public Result(int code,String message){
        this.code=code;
        this.message=message;
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
