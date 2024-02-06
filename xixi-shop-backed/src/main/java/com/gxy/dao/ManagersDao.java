package com.gxy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxy.entity.backed.Managers;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Title: ManagersDao
 * @Author GUOXINYV
 * @Date 2024/2/6 16:43
 * @description:
 */
@Mapper
@Repository
public interface ManagersDao extends BaseMapper<Managers> {

}
