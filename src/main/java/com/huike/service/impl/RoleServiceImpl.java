package com.huike.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huike.entity.Permission;
import com.huike.entity.Role;
import com.huike.mapper.RoleMapper;
import com.huike.query.QueryObject;
import com.huike.service.RoleService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl  implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> slelectAllRoles() {
        List<Role> roles= roleMapper.slelectAllRoles();
        return roles;
    }

    @Override
    public PageInfo<Role> list(QueryObject queryObject) {
        PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
        List<Role> roles= roleMapper.slelectAllRoles();
        PageInfo<Role> pageInfo=new PageInfo(roles);
        return pageInfo;
    }

    @Transactional
    @Override
    public void addRole(Role role, int[] permissionIds) {
        //1.根据role对象添加角色,且获取自动生成主键
        roleMapper.addRole(role);
        Long roleId = role.getId();
        //2.根据遍历permissionIds得到权限id,再结合生成的主键加入到中间表中
        if(permissionIds!=null){
            for (int permissionId : permissionIds) {
                roleMapper.addToMid(roleId,permissionId);
            }
        }
    }

    @Override
    public Role findRoleById(Integer id) {
        //1.查询role表,返回角色基本数据
        Role role= roleMapper.findRoleById(id);
        //2.根据id利用子查询查询到对应所有的权限,把权限数据放到role对象中
        List<Permission> permissionList= roleMapper.findPermissionsByRoleId(id);
        role.setPermissionList(permissionList);
        return role;
    }

    @Override
    public void updateRole(Role role,int[] permissionIds) {
        //1.修改角色表的数据
        roleMapper.updateRole(role);
        //2.修改中间表的数据(先删后加)
        roleMapper.deleteRolePermissionMid(role.getId());
        if(permissionIds!=null){
            for (int permissionId : permissionIds) {
                roleMapper.addToMid(role.getId(), permissionId);
            }

        }

    }

    @Override
    public void deleteRoleById(Long id) {
        roleMapper.deleteRolePermissionMid(id);
        roleMapper.deleteRole(id);
    }
}
