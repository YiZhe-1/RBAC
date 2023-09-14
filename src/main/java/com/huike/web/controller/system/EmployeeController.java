package com.huike.web.controller.system;

import com.github.pagehelper.PageInfo;
import com.huike.entity.Department;
import com.huike.entity.Employee;
import com.huike.entity.Role;
import com.huike.query.EmployeeQuery;
import com.huike.service.DepartmentService;
import com.huike.service.EmployeeService;
import com.huike.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private RoleService roleService;
    /*
    * 三、员工
        查询：
            请求地址:/employee/list
            请求参数:keyword (姓名,邮箱) deptId、currentPage、pageSize
            返回值:departments(所有的部门),pageInfo(员工分页数据)、qo 都要放到Model中
    *
    * */

    //EmployeeQuery 里面有所有的参数
    //@ModelAttribute既可以接受请求参数 也可以把数据放到model中返回到前端
    @RequestMapping("/list")
    public String list(Model model,@ModelAttribute("qo") EmployeeQuery employeeQuery){
        //1.返回所有部门,放到model中
        List<Department> departmentList=departmentService.findAllDepts();
        model.addAttribute("departments",departmentList);

        //2.查询员工的分页数据,放到model中
        PageInfo<Employee> pageInfo= employeeService.findPage(employeeQuery);
        model.addAttribute("pageInfo",pageInfo);

        //3.跳转到employee/list页面
        //  默认视图解析器(前缀http 后缀.html)
        //先跳转 后解析model中的数据
        return "employee/list";
    }


    /*
    *     跳转到添加页面:
        请求地址:/employee/input
        请求参数:无
        返回值:departments(所有部门)、roles(所有角色)
    *
    * */


    /*
    *     跳转到编辑页面:
        请求地址:/employee/input?id=1
        请求参数:id
        返回值:departments(所有部门)、roles(所有角色)
              department(当前对象所在的部门)、roles(当前对象所拥有的所有角色)、
              employee(当前对象包含当前对象所在的部门和角色)
    *
    * */

    @RequestMapping("/input")
    public  String toAdd(Model model,Long id){
        if(id!=null){
            //把当前的employee对象(要包含department、role)
            Employee employee= employeeService.getEmployeeById(id);
            model.addAttribute("employee",employee);
        }

        List<Department> departments = departmentService.findAllDepts();
        model.addAttribute("departments",departments);

        List<Role> roles= roleService.slelectAllRoles();
        model.addAttribute("roles",roles);

        return "employee/input";
    }


    /*
    *     添加用户:
        请求地址:/employee/saveOrUpdate
        请求参数:
            id:
            username: point
            name: dudu
            password: 123
            repassword: 123
            email: 510520165@qq.com
            age: 1
            dept.id: 6
            roleIds: 2
            roleIds: 5
            roleIds: 3
        返回值:重定向到查询页面
    *
    * */
    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Employee employee,int[] roleIds){
        if(employee.getId()!=null){
            employeeService.update(employee,roleIds);
        }else{
            employeeService.add(employee,roleIds);
        }
        return "redirect:/employee/list";
    }

    @RequestMapping("/delete")
    public String deleteById(int id){
        employeeService.delete(id);
        return "redirect:/employee/list";
    }


}
