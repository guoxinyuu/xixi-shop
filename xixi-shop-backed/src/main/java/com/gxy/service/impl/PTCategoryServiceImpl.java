package com.gxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxy.dao.PTCategoryDao;
import com.gxy.dao.ProductPtcDao;
import com.gxy.dao.TypeAndCategoryDao;
import com.gxy.entity.backed.ProductPtc;
import com.gxy.entity.backed.ProductTypesCategory;
import com.gxy.entity.backed.PtPtc;
import com.gxy.entity.common.vo.Result;
import com.gxy.entity.common.vo.Search;
import com.gxy.entity.dto.ProductTypesCategoryDto;
import com.gxy.entity.service.ModelService;
import com.gxy.service.PTCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

/**
 * @Title: PTCategoryServiceImpl
 * @Author GUOXINYV
 * @Date 2024/2/20 14:08
 * @description:
 */
@Service
@Slf4j
public class PTCategoryServiceImpl extends ServiceImpl<PTCategoryDao, ProductTypesCategory> implements PTCategoryService {
    @Autowired
    private PTCategoryDao ptCategoryDao;
    @Autowired
    private ProductPtcDao productPtcDao;
    @Autowired
    private TypeAndCategoryDao typeAndCategoryDao;
    @Override
    public Result<ProductTypesCategoryDto> insertModel(ProductTypesCategoryDto model) {
        //先判断名称是否存在
//        LambdaQueryWrapper<ProductTypesCategory> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(ProductTypesCategory::getProductTypeCategory,model.getProductTypeCategory());
//        ProductTypesCategory model1 = ptCategoryDao.selectOne(wrapper);
//        if(model1!=null){
//            return new Result<>(500,"该系列已存在");
//        }
        //不存在就进行插入
        int i = ptCategoryDao.insert(model);

        ProductTypesCategory one = ptCategoryDao.getOneByName(model.getProductTypeCategory());
        PtPtc ptPtc = new PtPtc();
        ptPtc.setPtId(model.getProductTypes().getId());
        ptPtc.setPtcId(one.getId());
        int i1 = typeAndCategoryDao.insert(ptPtc);
        return i>0&&i1>0?new Result<>(200,"添加成功",model):new Result<>(500,"添加失败");
    }

    @Override
    public Result<ProductTypesCategoryDto> updateModel(ProductTypesCategoryDto model) {
        int i = ptCategoryDao.updateById(model);
//        ProductTypesCategory ptc = new ProductTypesCategory();
//        BeanUtils.copyProperties(model,ptc);
        //BeanUtils.copyProperties(model,ptc) ->  ptc.set??(model.get??)
//        if(model.getProductTypeCategory()!=null&&model.getCategoryImg()!=null) {
//            int i = ptCategoryDao.updateById(model);
//            LambdaUpdateWrapper<PtPtc> wrapper = new LambdaUpdateWrapper<>();
//            wrapper.eq(PtPtc::getPtcId,model.getId());
//            wrapper.set(PtPtc::getPtId,model.getProductTypes().getId());
//            int i1 = typeAndCategoryDao.update(null, wrapper);
//            return i>0&& i1>0?new Result<>(200,"修改成功"):new Result<>(500,"修改失败");
//
//        }
        //1.
        LambdaUpdateWrapper<PtPtc> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(PtPtc::getPtcId,model.getId());
        wrapper.set(PtPtc::getPtId,model.getProductTypes().getId());
        int i1 = typeAndCategoryDao.update(null, wrapper);
        return i1>0&&i>0?new Result<>(200,"修改成功"):new Result<>(500,"修改失败");

    }

    @Override
    public Result<Object> deleteModelById(int id) {
        int i = ptCategoryDao.deleteById(id);
        //判断一下product_ptc这个中间表需不需要删除
        LambdaQueryWrapper<ProductPtc> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProductPtc::getPtcId,id);
        LambdaQueryWrapper<PtPtc> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(PtPtc::getPtcId,id);
        PtPtc ptPtc = typeAndCategoryDao.selectOne(wrapper1);
        if(ptPtc!=null) {
            int i2 = typeAndCategoryDao.delete(wrapper1);
            if (productPtcDao.selectList(wrapper).size() > 0) {
                int i1 = productPtcDao.delete(wrapper);
                return i > 0 && i1 > 0 &&i2>0? new Result<>(200, "删除成功") : new Result<>(500, "修改失败");

            }
            return i>0&&i2>0?new Result<>(200,"删除成功"):new Result<>(500,"修改失败");
        }

        return i>0?new Result<>(200,"删除成功"):new Result<>(500,"修改失败");

    }

    @Override
    public ProductTypesCategoryDto getModelById(int id) {
        return null;
    }

    @Override
    public PageInfo<ProductTypesCategoryDto> getModelsBySearch(Search search) {
        search.initSearch();
        PageHelper.startPage(search.getCurrentPage(),search.getPageSize());
        return new PageInfo<>(Optional.ofNullable(ptCategoryDao.getPTCBySearch(search)).orElse(Collections.emptyList()));
    }
}
