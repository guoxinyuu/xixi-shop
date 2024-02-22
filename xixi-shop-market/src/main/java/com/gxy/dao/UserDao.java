package com.gxy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxy.entity.market.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Title: UserDao
 * @Author GUOXINYV
 * @Date 2024/2/22 10:36
 * @description:
 */
@Mapper
@Repository
public interface UserDao extends BaseMapper<User> {
}
