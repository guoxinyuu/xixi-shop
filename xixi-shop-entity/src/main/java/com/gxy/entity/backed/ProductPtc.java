package com.gxy.entity.backed;

import lombok.Data;

/**
 * @Title: ProductPtc
 * @Author GUOXINYV
 * @Date 2024/2/20 16:29
 * @description:
 */
@Data
public class ProductPtc {
    private int id;
    private int productId;
    private int ptcId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPtcId() {
        return ptcId;
    }

    public void setPtcId(int ptcId) {
        this.ptcId = ptcId;
    }
}
