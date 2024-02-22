package com.gxy.entity.market;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Title: HotProducts
 * @Author GUOXINYV
 * @Date 2024/2/6 15:56
 * @description:
 */
@Data
public class HotProducts {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private String hotProductName;
    private String hotProductImg;
    private float hotProductPrice;
}
