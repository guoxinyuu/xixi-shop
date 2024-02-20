package com.gxy.entity.dto;

import com.gxy.entity.backed.ProductTypes;
import com.gxy.entity.backed.ProductTypesCategory;
import lombok.Data;

/**
 * @Title: ProductTypesCategoryDto
 * @Author GUOXINYV
 * @Date 2024/2/20 22:16
 * @description:
 */
@Data
public class ProductTypesCategoryDto extends ProductTypesCategory {
    private ProductTypes productTypes;

    public ProductTypes getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(ProductTypes productTypes) {
        this.productTypes = productTypes;
    }
}
