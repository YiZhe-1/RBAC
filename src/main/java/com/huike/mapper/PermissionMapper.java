package com.huike.mapper;

import com.huike.entity.Permission;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper {
    @Select("select * from permission")
    List<Permission> findAllPermission();
}
