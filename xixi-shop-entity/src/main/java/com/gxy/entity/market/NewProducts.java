package com.gxy.entity.market;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Title: NewProducts
 * @Author GUOXINYV
 * @Date 2024/2/6 15:58
 * @description:
 */
@Data
public class NewProducts {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private String newProductName;
    private String newProductImg;
    private float newProductPrice;
}
