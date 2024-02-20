package com.gxy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxy.entity.backed.Managers;
import com.gxy.entity.backed.RoleManagers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Title: ManageAndRoleDao
 * @Author GUOXINYV
 * @Date 2024/2/18 14:30
 * @description:
 */
@Mapper
@Repository
public interface ManageAndRoleDao extends BaseMapper<RoleManagers> {
    @Select("select * from role_managers where manager_id=#{managerId}")
    Managers selectOne(int managerId);
}
