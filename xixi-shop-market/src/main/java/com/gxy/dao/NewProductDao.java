package com.gxy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxy.entity.common.vo.Search;
import com.gxy.entity.market.NewProducts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Title: NewProductDao
 * @Author GUOXINYV
 * @Date 2024/2/22 19:06
 * @description:
 */
@Mapper
@Repository
public interface NewProductDao extends BaseMapper<NewProducts> {
    @Select("select * from new_product")
    List<NewProducts> getNewByPage(Search search);
}
