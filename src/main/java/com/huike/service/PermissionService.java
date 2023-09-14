package com.huike.service;

import com.github.pagehelper.PageInfo;
import com.huike.entity.Permission;
import com.huike.query.QueryObject;

import java.util.List;

public interface PermissionService {
    List<Permission> findAllPermission();


    PageInfo<Permission> list(QueryObject queryObject);
}
