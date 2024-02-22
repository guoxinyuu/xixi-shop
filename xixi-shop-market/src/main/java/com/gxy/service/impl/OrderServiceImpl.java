package com.gxy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import com.gxy.dao.OrderDao;
import com.gxy.entity.common.vo.Result;
import com.gxy.entity.common.vo.Search;
import com.gxy.entity.market.Order;
import com.gxy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Title: OrderService
 * @Author GUOXINYV
 * @Date 2024/2/22 23:10
 * @description:
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public Result<Order> insertModel(Order model) {
        String orderNumber = System.currentTimeMillis()/1000+"";
        model.setOrderNumber(orderNumber);
        LocalDateTime now = LocalDateTime.now();
        model.setOrderCreateDate(now);
        return null;
    }

    @Override
    public Result<Order> updateModel(Order model) {
        return null;
    }

    @Override
    public Result<Object> deleteModelById(int id) {
        return null;
    }

    @Override
    public Order getModelById(int id) {
        return null;
    }

    @Override
    public PageInfo<Order> getModelsBySearch(Search search) {
        return null;
    }
}
