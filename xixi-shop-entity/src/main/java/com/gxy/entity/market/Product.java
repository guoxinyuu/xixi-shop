package com.gxy.entity.market;

import lombok.Data;

/**
 * @Title: Product
 * @Author GUOXINYV
 * @Date 2024/2/6 16:05
 * @description:
 */
@Data
public class Product {
    private int id;
    private String productName;
    private String productImg;
    private float productPrice;
}

