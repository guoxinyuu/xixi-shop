package com.gxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxy.dao.ProductDao;
import com.gxy.dao.ProductPtcDao;
import com.gxy.entity.backed.Product;
import com.gxy.entity.backed.ProductPtc;
import com.gxy.entity.common.vo.Result;
import com.gxy.entity.common.vo.Search;
import com.gxy.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

/**
 * @Title: ProductServiceImpl
 * @Author GUOXINYV
 * @Date 2024/2/21 18:50
 * @description:
 */
@Service
@Slf4j
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product> implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductPtcDao productPtcDao;
    @Override
    public Result<Product> insertModel(Product model) {
        int i = productDao.insert(model);
        Product product = productDao.getProductByName(model.getProductName());

        ProductPtc productPtc = new ProductPtc();
        productPtc.setProductId(product.getId());
        productPtc.setPtcId(model.getProductTypesCategory().getId());
        int i1 = productPtcDao.insert(productPtc);
        return i>0&&i1>0?new Result<>(200,"添加成功",model):new Result<>(500,"添加失败");

    }

    @Override
    public Result<Product> updateModel(Product model) {
        int i = productDao.updateById(model);

        LambdaUpdateWrapper<ProductPtc> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(ProductPtc::getProductId,model.getId());
        wrapper.set(ProductPtc::getPtcId,model.getProductTypesCategory().getId());
        int i1 = productPtcDao.update(null, wrapper);
        return i1>0&&i>0?new Result<>(200,"修改成功"):new Result<>(500,"修改失败");

    }

    @Override
    public Result<Object> deleteModelById(int id) {
        int i = productDao.deleteById(id);
        LambdaQueryWrapper<ProductPtc> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProductPtc::getProductId,id);
        int i1 = productPtcDao.delete(wrapper);
        return i>0&&i1>0?new Result<>(200,"删除成功"):new Result<>(500,"修改失败");

    }

    @Override
    public Product getModelById(int id) {
        return null;
    }

    @Override
    public PageInfo<Product> getModelsBySearch(Search search) {
        search.initSearch();
        PageHelper.startPage(search.getCurrentPage(),search.getPageSize());
        return new PageInfo<>(Optional.ofNullable(productDao.getProductsBySearch(search)).orElse(Collections.emptyList()));
    }
}
