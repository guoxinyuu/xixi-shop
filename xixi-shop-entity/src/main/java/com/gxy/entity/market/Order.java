package com.gxy.entity.market;

import lombok.Data;

import java.util.Date;

/**
 * @Title: Order
 * @Author GUOXINYV
 * @Date 2024/2/6 15:59
 * @description:
 */
@Data
public class Order {
    private int id;
    private String orderNumber;
    private String orderName;
    private int orderAmount;
    private float orderTotalPrice;
    private Date orderCreateDate;
    private String orderStatus;
}
