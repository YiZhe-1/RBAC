package com.huike.config;

import com.huike.entity.Employee;
import com.huike.entity.Permission;
import com.huike.service.EmployeeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserReaml extends AuthorizingRealm {
    @Autowired
    private EmployeeService employeeService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();


        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        Collection<String> perms = new ArrayList<>();
        for (Permission permission:employee.getPermissions()) {
            perms.add(permission.getExpression());
        }
        simpleAuthorizationInfo.addStringPermissions(perms);


        return simpleAuthorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //从subject中取出前端传入的用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        Employee employee =  employeeService.login(username);
        if(employee == null){
            return null;
        }

        return new SimpleAuthenticationInfo(employee,employee.getPassword(),"");

    }
}
