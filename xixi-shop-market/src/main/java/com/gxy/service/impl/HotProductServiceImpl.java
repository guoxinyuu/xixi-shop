package com.gxy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxy.dao.HotProductDao;
import com.gxy.entity.common.vo.Result;
import com.gxy.entity.common.vo.Search;
import com.gxy.entity.market.HotProducts;
import com.gxy.service.HotProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

/**
 * @Title: HotProductServiceImpl
 * @Author GUOXINYV
 * @Date 2024/2/22 16:31
 * @description:
 */
@Service
public class HotProductServiceImpl extends ServiceImpl<HotProductDao, HotProducts> implements HotProductService {
    @Autowired
    private HotProductDao hotProductDao;
    @Override
    public Result<HotProducts> insertModel(HotProducts model) {
        int i = hotProductDao.insert(model);
        return i>0?new Result<>(200,"添加成功"):new Result<>(500,"添加失败");

    }

    @Override
    public Result<HotProducts> updateModel(HotProducts model) {
        int i = hotProductDao.updateById(model);
        return i>0?new Result<>(200,"修改成功"):new Result<>(500,"修改失败");

    }

    @Override
    public Result<Object> deleteModelById(int id) {
        int i = hotProductDao.deleteById(id);
        return i>0?new Result<>(200,"删除成功"):new Result<>(500,"删除失败");

    }

    @Override
    public HotProducts getModelById(int id) {
        return null;
    }

    @Override
    public PageInfo<HotProducts> getModelsBySearch(Search search) {
        search.initSearch();
        PageHelper.startPage(search.getCurrentPage(),search.getPageSize());
        return new PageInfo<>(Optional.ofNullable(hotProductDao.getHotByPage(search)).orElse(Collections.emptyList()));
    }
}
