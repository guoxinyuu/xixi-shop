package com.gxy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxy.entity.backed.Managers;
import com.gxy.entity.backed.Role;
import com.gxy.entity.common.vo.Search;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Title: ManagersDao
 * @Author GUOXINYV
 * @Date 2024/2/6 16:43
 * @description:
 */
@Mapper
@Repository
public interface ManagersDao extends BaseMapper<Managers> {
    @Select("select * from managers where manage_name=#{manageName}")
    Managers getManagerByName(String manageName);

    @Select("<script>"
            + "SELECT m.*, r.role_name "
            + "FROM managers m "
            + "JOIN role_managers rm ON m.id = rm.manager_id "
            + "JOIN role r ON r.id=rm.role_id"

            + "</script>")
    List<Managers> getManagersBySearch(Search search);
}
