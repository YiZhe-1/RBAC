package com.huike.service;

import com.github.pagehelper.PageInfo;
import com.huike.entity.Employee;
import com.huike.query.EmployeeQuery;
import org.apache.ibatis.annotations.Select;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee login(String username);

    PageInfo<Employee> findPage(EmployeeQuery employeeQuery);

    void add(Employee employee, int[] roleIdS);

    void delete(int id);

    Employee getEmployeeById(Long id);

    void update(Employee employee, int[] roleIds);
}
