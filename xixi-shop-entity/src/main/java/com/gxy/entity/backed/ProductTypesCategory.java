package com.gxy.entity.backed;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Title: ProductTypesCategory
 * @Author GUOXINYV
 * @Date 2024/2/6 16:08
 * @description:
 */
@Data
public class ProductTypesCategory {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private String productTypeCategory;
    private String categoryImg;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductTypeCategory() {
        return productTypeCategory;
    }

    public void setProductTypeCategory(String productTypeCategory) {
        this.productTypeCategory = productTypeCategory;
    }

    public String getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(String categoryImg) {
        this.categoryImg = categoryImg;
    }
}
