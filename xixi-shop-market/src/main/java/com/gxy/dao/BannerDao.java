package com.gxy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxy.entity.market.Banner;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Title: BannerDao
 * @Author GUOXINYV
 * @Date 2024/2/22 22:54
 * @description:
 */
@Mapper
@Repository
public interface BannerDao extends BaseMapper<Banner> {
}
