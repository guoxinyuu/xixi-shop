package com.gxy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxy.entity.market.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Title: OrderDao
 * @Author GUOXINYV
 * @Date 2024/2/22 23:10
 * @description:
 */
@Mapper
@Repository
public interface OrderDao extends BaseMapper<Order> {
}
