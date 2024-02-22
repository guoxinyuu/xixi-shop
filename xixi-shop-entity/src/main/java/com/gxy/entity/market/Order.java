package com.gxy.entity.market;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Title: Order
 * @Author GUOXINYV
 * @Date 2024/2/6 15:59
 * @description:
 */
@Data
public class Order {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private String orderNumber;
    private String orderName;
    private int orderAmount;
    private float orderTotalPrice;
    private LocalDateTime orderCreateDate;
    private String orderStatus;
    private String receiveName;
    private String receivePhone;
    private Date orderSendDate;
    private Date orderReceiveDate;
}
