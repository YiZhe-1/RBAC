package com.huike.mapper;

import com.huike.entity.Permission;
import com.huike.entity.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    @Select("select * from role ")
    List<Role> slelectAllRoles();

    @Select("SELECT * FROM role WHERE id IN (SELECT role_id FROM employee_role WHERE employee_id=#{id})")
    List<Role> findRolesByEmployeeId(Long id);



    void addRole(Role role);

    @Insert("insert into role_permission values (#{roleId},#{permissionId})")
    void addToMid(@Param("roleId") Long roleId,@Param("permissionId") int permissionId);

    @Select("select * from role where id=#{id}")
    Role findRoleById(Integer id);

    @Select("SELECT * FROM  permission where id in(select permission_id FROM role_permission where role_id=#{id})")
    List<Permission> findPermissionsByRoleId(Integer id);

    @Update("update role set name=#{name},sn=#{sn} where id=#{id}")
    void updateRole(Role role);

    @Delete("delete from role_permission where role_id=#{id}")
    void deleteRolePermissionMid(Long id);



    @Delete("delete from role where id=#{id}")
    void deleteRole(Long id);
}
