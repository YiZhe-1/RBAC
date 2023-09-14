package com.huike.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huike.entity.Department;
import com.huike.entity.Employee;
import com.huike.entity.Permission;
import com.huike.entity.Role;
import com.huike.exception.LoginException;
import com.huike.mapper.DepartmentMapper;
import com.huike.mapper.EmployeeMapper;
import com.huike.mapper.PermissionMapper;
import com.huike.mapper.RoleMapper;
import com.huike.query.EmployeeQuery;
import com.huike.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.beans.Transient;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Employee> findAll() {
        return employeeMapper.findAll();
    }

    @Override
    public Employee login(String usernane) {

        //1.根据用户名密码去数据库做校验
        Employee emp =  employeeMapper.login(usernane);
        //普通管理员
        if(emp.getAdmin() == null){
            Collection<Permission> permissions =  employeeMapper.getPermissionsByEmpName(usernane);
            emp.setPermissions(permissions);
        }else {//超级管理员
            List<Permission> allPermission = permissionMapper.findAllPermission();
            emp.setPermissions(allPermission);
        }


        return emp;
    }



    @Override
    public PageInfo<Employee> findPage(EmployeeQuery employeeQuery) {
        PageHelper.startPage(employeeQuery.getCurrentPage(),employeeQuery.getPageSize());
        List<Employee> employees= employeeMapper.findPage(employeeQuery);

        for (Employee employee : employees) {
            Integer deptId=employee.getDeptId();
            //根据部门id查询部门
            //把查到的部门对象放到employee中
            //此写法性能较低,mybatis有个关联查询性能好一些
            Department department= departmentMapper.getDeptById(deptId);
            employee.setDept(department);
        }
        PageInfo<Employee> pageInfo=new PageInfo<>(employees);
        return pageInfo;
    }

    @Override
    public void add(Employee employee, int[] roleIds) {
        //1.把employee中的数据保存到employee表
        employeeMapper.addToEmployee(employee);
        //2.获取到employee新添加的数据的主键
        Long empId = employee.getId();
        //3.把roleIds遍历,分别保存到employee_role表中
        if(roleIds!=null){
            for (int roleId : roleIds) {
                employeeMapper.addToMid(empId,roleId);
            }
        }

    }

    @Override
    public void delete(int id) {
        //1.先删除中间表employee
        employeeMapper.deleteMidById(id);

        //2.再删除employee表
        employeeMapper.deleteEmployeeById(id);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        //1.根据id查询员工employee
        Employee employee= employeeMapper.getEmployeeById(id);
        //2.获取部门id,查询部门，封装到employee中
        Integer deptId = employee.getDeptId();
        Department dept = departmentMapper.getDeptById(deptId);
        employee.setDept(dept);
        //3.根据员工id,查询所有角色,封装到employee中
        List<Role> roles= roleMapper.findRolesByEmployeeId(id);
        employee.setRoles(roles);
        return employee;
    }

    @Transactional//开启事务
    @Override
    public void update(Employee employee, int[] roleIds) {
        //1.根据employee对象修改employee表
        employeeMapper.updateByEmployee(employee);
        //2.根据员工 roleIds修改中间表
        employeeMapper.deleteMidByEmployeeId(employee.getId());
        if(roleIds!=null){
            for (int roleId : roleIds) {
                employeeMapper.addToMid(employee.getId(),roleId);
            }
        }
    }

}
