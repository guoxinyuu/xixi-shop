package com.gxy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxy.entity.common.vo.Search;
import com.gxy.entity.backed.ProductTypes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Title: ProductTypesDao
 * @Author GUOXINYV
 * @Date 2024/2/19 18:57
 * @description:
 */
@Mapper
@Repository
public interface ProductTypesDao extends BaseMapper<ProductTypes> {
    @Select("select * from product_types")
    List<ProductTypes> getTypesBySearch(Search search);
}
