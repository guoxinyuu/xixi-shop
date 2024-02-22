package com.gxy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import com.gxy.dao.BannerDao;
import com.gxy.entity.common.vo.Result;
import com.gxy.entity.common.vo.Search;
import com.gxy.entity.market.Banner;
import com.gxy.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title: BannerServiceImpl
 * @Author GUOXINYV
 * @Date 2024/2/22 22:54
 * @description:
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerDao, Banner> implements BannerService {
    @Autowired
    private BannerDao bannerDao;

    @Override
    public Result<Banner> insertModel(Banner model) {
        return null;
    }

    @Override
    public Result<Banner> updateModel(Banner model) {
        return null;
    }

    @Override
    public Result<Object> deleteModelById(int id) {
        return null;
    }

    @Override
    public Banner getModelById(int id) {
        return null;
    }

    @Override
    public PageInfo<Banner> getModelsBySearch(Search search) {
        return null;
    }
}
