package com.gxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxy.dao.ManageAndRoleDao;
import com.gxy.dao.ManagersDao;
import com.gxy.entity.backed.Managers;
import com.gxy.entity.backed.RoleManagers;
import com.gxy.entity.common.vo.Result;
import com.gxy.entity.common.vo.Search;
import com.gxy.entity.utils.JwtUtils;
import com.gxy.entity.utils.MdFiveUtil;
import com.gxy.service.CommonOpenFeign;
import com.gxy.service.ManagersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;


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

    @Autowired
    private ManageAndRoleDao manageAndRoleDao;

    @Autowired
    CommonOpenFeign commonOpenFeign;
    //读取锁定次数
    @Value("${pwdLock}")
    Integer num;

    @Override
    public Result<String> login(Managers managers) {
        String managePhone = managers.getManagePhone();
        String password = managers.getPassword();
        LambdaQueryWrapper<Managers> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Managers::getManagePhone,managePhone);
        Managers manager = managersDao.selectOne(queryWrapper);
        //判断账号是否存在
        if(manager!=null){
            //将输入的密码进行加密后与数据库的密码进行比较
            String pwd = MdFiveUtil.pwdChange(password, manager.getSalt());
            if(pwd.equals(manager.getPassword())){
                String token = JwtUtils.createUserToken(manager.getId() + "", manager.getManageName(), manager.getSalt());
                commonOpenFeign.insertModel("manager",manager,0);
                return new Result(200,"登录成功",token);
            }else {
                return new Result<>(500,"密码错误，请重试");
            }
        }else {
            return new Result<>(500,"账号不存在，请重试");
        }
    }

    @Override
    public Result<String> forgetPassword(Managers managers,String code) {
        String newPwd = managers.getPassword();
        String email = managers.getEmail();
        //查询输入的账号是否存在
        LambdaQueryWrapper<Managers> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Managers::getEmail,email);
        Managers managers1 = managersDao.selectOne(queryWrapper);
        if(managers1!=null){
            //获取缓存中的验证码
            Map emailCode = commonOpenFeign.getModel("emailCode");
            if(emailCode==null){
                return new Result<>(500,"验证码不存在或已失效");
            }else {
                //验证码相同就进行修改密码
                String cacheCode = (String) emailCode.get("code");
                if(code.equals(cacheCode)){
                    String mdPwd = MdFiveUtil.pwdChange(newPwd, UUID.randomUUID() + "");
                    managers1.setPassword(mdPwd);
                    int i = managersDao.updateById(managers1);
                    if(i>0){
                        return new Result<>(200,"修改密码成功");
                    }else return new Result<>(500,"修改密码失败");
                }else return new Result<>(500,"验证码错误，请重试");
            }
        }else
        return new Result<>(500,"账号不存在，请重新输入");
    }

//    @Override
//    public Result<String> deleteManage(Managers managers) {
//        int i = managersDao.deleteById(managers.getId());
//        int i1 = manageAndRoleDao.deleteById(managers.getRole().getId());
//        if(i>0&&i1>0) return new Result<>(200,"删除成功");
//        else return new Result<>(500,"删除失败");
//    }

    @Override
    public Result<Managers> insertModel(Managers model) {
        String salt=UUID.randomUUID() + "";
        String pwd = MdFiveUtil.pwdChange(model.getPassword(),salt );
        model.setPassword(pwd);
        model.setSalt(salt);
        int i = managersDao.insert(model);
        Managers manager = managersDao.getManagerByName(model.getManageName());
        //向中间表添加数据
        RoleManagers mar = new RoleManagers();
        mar.setManagerId(manager.getId());
        mar.setRoleId(model.getRole().getId());
        int i1 = manageAndRoleDao.insert(mar);
        if(i>0&&i1>0) return new Result<>(200,"添加成功");
        else return new Result<>(500,"添加失败");
    }

    @Override
    public Result<Managers> updateModel(Managers model) {
        int i = managersDao.updateById(model);
//        RoleManagers roleManagers = new RoleManagers();
//        roleManagers.setRoleId(model.getRole().getId());
//        Managers one = manageAndRoleDao.selectOne(model.getId());
//        roleManagers.setId(one.getId());
//        roleManagers.setManagerId(model.getId());
        //不是通过主键id修改，使用wrapper
        LambdaUpdateWrapper<RoleManagers> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(RoleManagers::getManagerId,model.getId());//类似where manager_id=#{id}
        updateWrapper.set(RoleManagers::getRoleId,model.getRole().getId());
        int i1 = manageAndRoleDao.update(null,updateWrapper);
        return i>0&&i1>0? new Result<>(200,"修改成功"):new Result<>(500,"修改失败");
    }

    @Override
    public Result<Object> deleteModelById(int id) {
//        Managers manager = managersDao.selectById(id);
        int i1 = managersDao.deleteById(id);
        Managers mar = manageAndRoleDao.selectOne(id);
        int i = manageAndRoleDao.deleteById(mar.getId());
        if(i>0&&i1>0) return new Result<>(200,"删除成功");
        else return new Result<>(500,"删除失败");
    }

    @Override
    public Managers getModelById(int id) {
        return null;
    }

    //分页
    @Override
    public PageInfo<Managers> getModelsBySearch(Search search) {
        search.initSearch();
        PageHelper.startPage(search.getCurrentPage(),search.getPageSize());
        return new PageInfo(Optional.ofNullable(managersDao.getManagersBySearch(search)).orElse(Collections.emptyList()));
    }
}
