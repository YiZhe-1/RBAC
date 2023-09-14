package com.huike.service;

import com.github.pagehelper.PageInfo;
import com.huike.entity.Role;
import com.huike.query.QueryObject;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoleService {
    List<Role> slelectAllRoles();

    PageInfo<Role> list(QueryObject queryObject);

    void addRole(Role role, int[] permissionIds);


    Role findRoleById(Integer id);

    void updateRole(Role role,int[] permissionIds);


    void deleteRoleById(Long id);

}
