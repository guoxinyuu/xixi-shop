package com.gxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import com.gxy.dao.UserDao;
import com.gxy.entity.common.vo.Result;
import com.gxy.entity.common.vo.Search;
import com.gxy.entity.market.User;
import com.gxy.entity.utils.JwtUtils;
import com.gxy.entity.utils.MdFiveUtil;
import com.gxy.service.CommonOpenFeign;
import com.gxy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Title: UserServiceImpl
 * @Author GUOXINYV
 * @Date 2024/2/22 10:37
 * @description:
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CommonOpenFeign commonOpenFeign;
    @Override
    public Result<User> insertModel(User model) {
        String salt=UUID.randomUUID() + "";
        String pwd = MdFiveUtil.pwdChange(model.getPassword(), salt);
        model.setPassword(pwd);
        model.setUserSalt(salt);
        int i = userDao.insert(model);
        return i>0?new Result<>(200,"注册成功"):new Result<>(500,"注册失败");
    }

    @Override
    public Result<User> updateModel(User model) {
        int i = userDao.updateById(model);
        return i>0?new Result<>(200,"修改成功"):new Result<>(500,"修改失败");

    }

    @Override
    public Result<Object> deleteModelById(int id) {
        int i = userDao.deleteById(id);
        return i>0?new Result<>(200,"删除成功"):new Result<>(500,"删除失败");

    }

    @Override
    public User getModelById(int id) {
        return null;
    }

    @Override
    public PageInfo<User> getModelsBySearch(Search search) {
        return null;
    }

    @Override
    public Result<String> login(User user) {
        String userName = user.getUserName();
        String password = user.getPassword();
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName,userName);
        User user1 = userDao.selectOne(wrapper);
        if(user1!=null){
            String pwdChange = MdFiveUtil.pwdChange(password, user1.getUserSalt());
            if(pwdChange.equals(user1.getPassword())){
                String token = JwtUtils.createUserToken(user1.getId() + "", userName, user1.getUserSalt());
                HashMap<String, Object> map = new HashMap<>();
                map.put("token",token);
                map.put("user",user1);
                return new Result(200,"登录成功",map);
            }else {
                return new Result<>(500,"密码错误，请重试");
            }
        }
        return new Result<>(500,"账号有误或不存在");
    }

    @Override
    public Result<String> forgetPassword(User user, String code) {
        String email = user.getEmail();
        String newPwd = user.getPassword();
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getEmail,email);
        User user1 = userDao.selectOne(wrapper);
        if(user1!=null){
            Map emailCode = commonOpenFeign.getModel("emailCode");
            if(emailCode==null){
                return new Result<>(500,"验证码不存在或已失效");
            }else {
                String cacheCode = (String) emailCode.get("code");
                if(cacheCode.equals(code)){
                    String s = MdFiveUtil.pwdChange(newPwd, user1.getUserSalt());
                    user1.setPassword(s);
                    int i = userDao.updateById(user1);
                    return i>0? new Result<>(200,"修改密码成功"):new Result<>(500,"修改密码失败");
                }
                return new Result<>(500,"验证码错误");
            }
        }
        return new Result<>(500,"邮箱有误或不存在，请重试");
    }
}
