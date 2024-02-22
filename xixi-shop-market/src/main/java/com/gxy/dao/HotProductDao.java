package com.gxy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxy.entity.common.vo.Search;
import com.gxy.entity.market.HotProducts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Title: HotProductDao
 * @Author GUOXINYV
 * @Date 2024/2/22 16:32
 * @description:
 */
@Mapper
@Repository
public interface HotProductDao extends BaseMapper<HotProducts> {
    @Select("select * from hot_product")
    List<HotProducts> getHotByPage(Search search);
}
