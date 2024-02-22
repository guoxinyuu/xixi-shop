package com.gxy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxy.entity.backed.ProductTypesCategory;
import com.gxy.entity.common.vo.Search;
import com.gxy.entity.dto.ProductTypesCategoryDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import javax.persistence.AssociationOverride;
import java.util.List;

/**
 * @Title: PTCategoryDao
 * @Author GUOXINYV
 * @Date 2024/2/20 14:08
 * @description:
 */
@Mapper
@Repository
public interface PTCategoryDao extends BaseMapper<ProductTypesCategory> {
    @Select("select ptc.*,pt.product_type,pt.id as pt_id from product_types_category ptc join pt_ptc pp on ptc.id=pp.ptc_id join product_types pt on pp.pt_id=pt.id")
//    @Results(id="ptcMap",value = {
//            @Result(column="id", property="id", id=true),
//            @Result(column="product_type_category", property="productTypeCategory"),
//            @Result(column="category_img", property="categoryImg"),
//            @Result(column = "product_type",property = "productTypes")
//    })
//
//    @ResultMap("ptcMap")
    List<ProductTypesCategoryDto> getPTCBySearch(Search search);

    @Select("select * from product_types_category where product_type_category=#{ptc}")
    ProductTypesCategory getOneByName(String ptc);
}
