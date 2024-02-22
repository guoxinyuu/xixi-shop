package com.gxy.entity.backed;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Title: Product
 * @Author GUOXINYV
 * @Date 2024/2/6 16:05
 * @description:
 */
@Data
public class Product {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private String productName;
    private String productImg;
    private float productPrice;
    @TableField(exist = false)
    private ProductTypesCategory productTypesCategory;
}

