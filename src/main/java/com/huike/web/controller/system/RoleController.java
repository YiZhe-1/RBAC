package com.huike.web.controller.system;

import com.github.pagehelper.PageInfo;
import com.huike.entity.Permission;
import com.huike.entity.Role;
import com.huike.query.QueryObject;
import com.huike.service.PermissionService;
import com.huike.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    /*
    *     1.角色查询
        请求地址:/role/list
        请求参数:
        返回值:pageonfo、qo
    *
    * */
    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo") QueryObject queryObject){
        PageInfo<Role> rolePageInfo=roleService.list(queryObject);
        model.addAttribute("pageInfo",rolePageInfo);
        return "role/list";
    }

    /*
    *     2.跳转到角色添加页面
        请求地址:/role/input
        请求参数:无
        返回值:permissions(所有权限)
    *
    * */

        /*
    *     4.跳转到编辑角色页面
        请求地址:/role/input
        请求参数:id
        返回值:role(包含当前的角色的所拥有的所有权限)、permission

    *
    *
    * */

    @RequestMapping("/input")
    public String input(Model model,Integer id){
        if(id!=null){
            //查询所有role
            Role role= roleService.findRoleById(id);
            model.addAttribute("role",role);
        }
        List<Permission> permissionList= permissionService.findAllPermission();
        model.addAttribute("permissions",permissionList);
        return "role/input";
    }

    /*
    *     3.添加角色
        请求地址:/role/saveOrUpdate

        请求参数:id:
                name: 财务管理
                sn: CFM
                permissionIds: 9
                permissionIds: 12
                permissionIds: 14
        返回值:重定向到查询接口
    *
    * */




    /*
    *     5.编辑角色
        请求地址:/role/saveOrUpdate
        请求参数:id
        返回值:重定向到查询接口
    *
    * */

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Role role ,int[] permissionIds){
        if(role.getId()!=null){
            roleService.updateRole(role,permissionIds);
        }else{
            roleService.addRole(role,permissionIds);
        }
        return "redirect:/role/list";
    }

    @RequestMapping("delete")
    public String delete(Long id){
        roleService.deleteRoleById(id);
        return "redirect:/role/list";
    }
}
