package com.huike.mapper;

import com.huike.entity.Employee;
import com.huike.entity.Permission;
import com.huike.query.EmployeeQuery;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface EmployeeMapper {
    @Select("select * from employee where username = #{username}")
    Employee login(String username);

    List <Employee> findPage(EmployeeQuery employeeQuery);

    void addToEmployee(Employee employee);

    //俩个参数就要加@Param()
    @Insert("INSERT INTO employee_role values (#{empId},#{roleId})")
    void addToMid(@Param("empId") Long empId , @Param("roleId") int roleId);

    @Delete("delete from employee_role where employee_id=#{id}")
    void deleteMidById(int id);

    @Delete("delete from employee where  id=#{id}")
    void deleteEmployeeById(int id);

    @Select("select * from employee where id=#{id}")
    Employee getEmployeeById(Long id);

    @Update("update employee set name=#{name},email=#{email},age=#{age},admin=#{admin},dept_id=#{dept.id} where id=#{id}")
    void updateByEmployee(Employee employee);

    @Delete("delete from employee_role where employee_id=#{id}")
    void deleteMidByEmployeeId(Long id);

    @Select("select * from permission where id in (SELECT DISTINCT permission_id FROM  role_permission WHERE role_id IN (SELECT role_id FROM  employee_role  WHERE employee_id = (SELECT id FROM employee WHERE username = #{usernane})))")
    Collection <Permission> getPermissionsByEmpName(String usernane);

    @Select("select * from employee ORDER BY id DESC")
    List <Employee> findAll();
}
