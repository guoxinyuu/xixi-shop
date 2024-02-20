package com.gxy.entity.backed;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Title: ProductTypes
 * @Author GUOXINYV
 * @Date 2024/2/6 16:06
 * @description:
 */
@Data
public class ProductTypes {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private String productType;
}
