package com.gxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxy.dao.ProductTypesDao;
import com.gxy.dao.TypeAndCategoryDao;
import com.gxy.entity.backed.PtPtc;
import com.gxy.entity.common.vo.Result;
import com.gxy.entity.common.vo.Search;
import com.gxy.entity.backed.ProductTypes;
import com.gxy.service.ProductTypesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @Title: ProductTypesServiceImpl
 * @Author GUOXINYV
 * @Date 2024/2/19 18:56
 * @description:
 */
@Service
@Slf4j
public class ProductTypesServiceImpl extends ServiceImpl<ProductTypesDao, ProductTypes> implements ProductTypesService {
    @Autowired
    private ProductTypesDao productTypesDao;

    @Autowired
    private TypeAndCategoryDao typeAndCategoryDao;

    @Override
    public Result<ProductTypes> insertModel(ProductTypes model) {
        int i = productTypesDao.insert(model);
        return i>0?new Result<>(200,"添加成功",model):new Result<>(500,"添加失败");
    }

    @Override
    public Result<ProductTypes> updateModel(ProductTypes model) {
        int i = productTypesDao.updateById(model);
        return i>0?new Result<>(200,"修改成功"):new Result<>(500,"修改失败");
    }

    @Override
    public Result<Object> deleteModelById(int id) {
        int i = productTypesDao.deleteById(id);
        List<PtPtc> ptc = typeAndCategoryDao.getPtPtcById(id);
//        LambdaQueryWrapper<PtPtc> wrapper= new LambdaQueryWrapper<>();
//        wrapper.eq(PtPtc::getPtId,id);
//        int i2 = typeAndCategoryDao.delete(wrapper);
        //判断中间表中是否有要删除的pt_id,有就删除
        if(ptc.size()!=0){
            int i1 = typeAndCategoryDao.deletePtPtc(id);
            return i>0&&i1>0?new Result<>(200,"删除成功"):new Result<>(500,"删除失败");
        }
        return i>0?new Result<>(200,"删除成功"):new Result<>(500,"删除失败");
    }

    @Override
    public ProductTypes getModelById(int id) {
        return null;
    }

    @Override
    public PageInfo<ProductTypes> getModelsBySearch(Search search) {
        search.initSearch();
        PageHelper.startPage(search.getCurrentPage(),search.getPageSize());
        return new PageInfo<>(Optional.ofNullable(productTypesDao.getTypesBySearch(search)).orElse(Collections.emptyList()));
    }
}
