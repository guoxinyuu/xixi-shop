package com.gxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import com.gxy.dao.ManagersDao;
import com.gxy.entity.backed.Managers;
import com.gxy.entity.common.vo.Result;
import com.gxy.entity.common.vo.Search;
import com.gxy.entity.utils.JwtUtils;
import com.gxy.entity.utils.MdFiveUtil;
import com.gxy.service.ManagersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;


/**
 * @Title: ManagersServiceImpl
 * @Author GUOXINYV
 * @Date 2024/2/6 16:59
 * @description:
 */
@Service
@Slf4j
public class ManagersServiceImpl extends ServiceImpl<ManagersDao, Managers> implements ManagersService {
    @Autowired
    private ManagersDao managersDao;

    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public Result<String> login(Managers managers) {
        String managePhone = managers.getManagePhone();
        String password = managers.getPassword();
        String keyLock=managePhone+":num";
        String key=managePhone+":lock";
        Object obj = redisTemplate.opsForValue().get(key);
        if(obj!=null){
            return new Result(500,"账号已被锁定");
        }
        LambdaQueryWrapper<Managers> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Managers::getManagePhone,managePhone);
        Managers manager = managersDao.selectOne(queryWrapper);
        //判断账号是否存在
        if(manager!=null){
            //将输入的密码进行加密后与数据库的密码进行比较
            String pwd = MdFiveUtil.pwdChange(password, manager.getSalt());
            if(pwd.equals(manager.getPassword())){
                String token = JwtUtils.createUserToken(manager.getId() + "", manager.getManageName(), manager.getSalt());
                HashMap<Object, Object> map = new HashMap<>();
                map.put("token",token);
                map.put("id",manager.getId());
                return new Result(200,"登录成功",map);
            }
        }

        return null;
    }

    @Override
    public Result<Managers> insertModel(Managers model) {
        return null;
    }

    @Override
    public Result<Managers> updateModel(Managers model) {
        return null;
    }

    @Override
    public Result<Object> deleteModelById(int id) {
        return null;
    }

    @Override
    public Managers getModelById(int id) {
        return null;
    }

    @Override
    public PageInfo<Managers> getModelsBySearch(Search search) {
        return null;
    }
}
