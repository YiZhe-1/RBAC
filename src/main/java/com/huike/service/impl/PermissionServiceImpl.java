package com.huike.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huike.entity.Permission;
import com.huike.mapper.PermissionMapper;
import com.huike.query.QueryObject;
import com.huike.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> findAllPermission() {
        List<Permission> permissionList= permissionMapper.findAllPermission();
        return permissionList;
    }

    @Override
    public PageInfo<Permission> list(QueryObject queryObject) {
        PageHelper.startPage(queryObject.getCurrentPage(),queryObject.getPageSize());
        List<Permission> permissions = permissionMapper.findAllPermission();
        PageInfo<Permission> pageInfo=new PageInfo<>(permissions);
        return pageInfo;
    }
}
