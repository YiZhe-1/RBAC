package com.huike.web.controller.system;

import com.github.pagehelper.PageInfo;
import com.huike.entity.Permission;
import com.huike.query.QueryObject;
import com.huike.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/list")
    public String list(Model model, @ModelAttribute("qo") QueryObject queryObject){
        PageInfo<Permission> permissionPageInfo=permissionService.list(queryObject);
        model.addAttribute("pageInfo",permissionPageInfo);
        return "permission/list";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized(){
        return "nopermission";
    }
}
