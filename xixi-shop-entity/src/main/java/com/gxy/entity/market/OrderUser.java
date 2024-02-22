package com.gxy.entity.market;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Title: OrderUser
 * @Author GUOXINYV
 * @Date 2024/2/22 23:08
 * @description:
 */
@Data
public class OrderUser {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private int orderId;
    private int userId;
}
