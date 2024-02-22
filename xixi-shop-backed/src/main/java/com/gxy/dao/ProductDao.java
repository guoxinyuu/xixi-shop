package com.gxy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxy.entity.backed.Product;
import com.gxy.entity.common.vo.Search;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Title: ProductDao
 * @Author GUOXINYV
 * @Date 2024/2/21 18:50
 * @description:
 */
@Mapper
@Repository
public interface ProductDao extends BaseMapper<Product> {
    @Select("select * from product where product_name=#{productName}")
    Product getProductByName(String productName);

    @Select("select p.*,ptc.product_type_category as ptcategory from product p join product_ptc pp on p.id=pp.product_id join product_types_category ptc on ptc.id=pp.ptc_id")
    List<Product> getProductsBySearch(Search search);
}
