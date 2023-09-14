package com.huike.service;

import com.github.pagehelper.PageInfo;
import com.huike.entity.Department;
import com.huike.query.QueryObject;

import java.util.List;

public interface DepartmentService {
    PageInfo<Department> list(QueryObject queryObject);

    void delete(Integer id);


    void saveOrUpdate(Department department);


    List<Department> findAllDepts();
}
