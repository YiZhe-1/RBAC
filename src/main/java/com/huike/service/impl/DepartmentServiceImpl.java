package com.huike.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huike.entity.Department;
import com.huike.mapper.DepartmentMapper;
import com.huike.query.QueryObject;
import com.huike.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public PageInfo<Department> list(QueryObject queryObject) {
        PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());

        List<Department> departments =  departmentMapper.list();

        PageInfo<Department> pageInfo= new PageInfo<>(departments);
        return pageInfo;
    }

    @Override
    public void delete(Integer id) {
        departmentMapper.delete(id);
    }

    @Override
    public void saveOrUpdate(Department department) {
        //1.区分添加还是修改
        //有无id来区分
        Long id = department.getId();
        if(id==null){
            //添加
            departmentMapper.add(department);
        }else{
            //修改
            departmentMapper.update(department);
        }
    }

    @Override
    public List<Department> findAllDepts() {
        List<Department> list = departmentMapper.list();
        return list;
    }


}
