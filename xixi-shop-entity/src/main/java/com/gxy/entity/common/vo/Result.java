package com.gxy.entity.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Title: Result
 * @Author GUOXINYV
 * @Date 2024/2/6 15:43
 * @description:
 */
@Data
@AllArgsConstructor
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public Result(int code,String message){
        this.code=code;
        this.message=message;
    }
}
