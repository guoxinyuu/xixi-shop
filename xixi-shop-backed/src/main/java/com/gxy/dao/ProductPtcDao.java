package com.gxy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxy.entity.backed.ProductPtc;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Title: ProductPtcDao
 * @Author GUOXINYV
 * @Date 2024/2/20 18:55
 * @description:
 */
@Mapper
@Repository
public interface ProductPtcDao extends BaseMapper<ProductPtc> {
}
