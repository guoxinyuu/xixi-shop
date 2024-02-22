package com.gxy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxy.dao.NewProductDao;
import com.gxy.entity.common.vo.Result;
import com.gxy.entity.common.vo.Search;
import com.gxy.entity.market.NewProducts;
import com.gxy.service.NewProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.OpenOption;
import java.util.Collections;
import java.util.Optional;

/**
 * @Title: NewProductServiceImpl
 * @Author GUOXINYV
 * @Date 2024/2/22 19:06
 * @description:
 */
@Service
public class NewProductServiceImpl extends ServiceImpl<NewProductDao, NewProducts> implements NewProductsService {
    @Autowired
    private NewProductDao newProductDao;
    @Override
    public Result<NewProducts> insertModel(NewProducts model) {
        int i = newProductDao.insert(model);
        return i>0?new Result<>(200,"添加成功"):new Result<>(500,"添加失败");

    }

    @Override
    public Result<NewProducts> updateModel(NewProducts model) {
        int i = newProductDao.updateById(model);
        return i>0?new Result<>(200,"修改成功"):new Result<>(500,"修改失败");

    }

    @Override
    public Result<Object> deleteModelById(int id) {
        int i = newProductDao.deleteById(id);
        return i>0?new Result<>(200,"删除成功"):new Result<>(500,"删除失败");

    }

    @Override
    public NewProducts getModelById(int id) {
        return null;
    }

    @Override
    public PageInfo<NewProducts> getModelsBySearch(Search search) {
        search.initSearch();
        PageHelper.startPage(search.getCurrentPage(),search.getPageSize());
        return new PageInfo<>(Optional.ofNullable(newProductDao.getNewByPage(search)).orElse(Collections.emptyList()));
    }
}
