package com.gxy.entity.market;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Title: Banner
 * @Author GUOXINYV
 * @Date 2024/2/22 22:52
 * @description:
 */
@Data
public class Banner {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private String bannerImg;
}
