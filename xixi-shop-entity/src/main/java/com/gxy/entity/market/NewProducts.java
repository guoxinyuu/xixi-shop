package com.gxy.entity.market;

import lombok.Data;

/**
 * @Title: NewProducts
 * @Author GUOXINYV
 * @Date 2024/2/6 15:58
 * @description:
 */
@Data
public class NewProducts {
    private int id;
    private String newProductName;
    private String newProductImg;
    private float newProductPrice;
}
