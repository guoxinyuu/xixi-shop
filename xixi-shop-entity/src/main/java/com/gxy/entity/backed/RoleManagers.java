package com.gxy.entity.backed;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Title: ManagersAndRole
 * @Author GUOXINYV
 * @Date 2024/2/18 14:31
 * @description:
 */
@Data
public class RoleManagers {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private int roleId;
    private int managerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
}
