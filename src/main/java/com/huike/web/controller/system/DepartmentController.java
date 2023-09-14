package com.huike.web.controller.system;

import com.github.pagehelper.PageInfo;
import com.huike.entity.Department;
import com.huike.query.QueryObject;
import com.huike.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    /*
    * 分页查询部门
       请求地址：/department/list
       请求参数：无
       返回值：pageInfo、qo
    * */
    @RequestMapping("/list")
    //ModelAttribute注解既接收参数，也可以返回参数
    public String list(Model model , @ModelAttribute("qo") QueryObject queryObject) {
        PageInfo <Department> departments = departmentService.list ( queryObject );
        //查询到的departments要放在model中
        model.addAttribute ( "pageInfo" , departments );
        return "department/list";
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        departmentService.delete ( id );
        //重定向到查询接口
        return "redirect:/department/list";
    }


    /*
    *
    *   部门添加
            请求地址:/department/saveOrUpdate
            请求参数:name sn

        部门修改
            请求地址:/department/saveOrUpdate
            请求参数:id name sn
    * */
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Department department) {
        departmentService.saveOrUpdate ( department );
        return "redirect:/department/list";
    }
}
