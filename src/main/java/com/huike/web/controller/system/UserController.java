package com.huike.web.controller.system;

import com.huike.entity.Employee;
import com.huike.exception.LoginException;
import com.huike.service.EmployeeService;
import com.huike.util.ReturnObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/toLogin")
    public void toLogin(HttpServletResponse response) throws IOException {
        response.sendRedirect ( "/login.html" );
    }

    /*
    * 一、登录
            请求地址：user/login
            请求参数：username和password
            返回值：data（success、message）
    * */
    @RequestMapping("/login")
    @ResponseBody
    public ReturnObject login(Employee employee) {
        Subject subject = SecurityUtils.getSubject ();
        UsernamePasswordToken token = new UsernamePasswordToken ( employee.getUsername () , employee.getPassword () );
        try {
            subject.login ( token );
            return new ReturnObject ( true , "登录成功" );
        } catch (Exception e) {
            e.printStackTrace ();
            throw new LoginException ( "用户名或密码不匹配" );
        }
    }

    @RequestMapping("/logout")
    public void logout(HttpServletResponse response) throws IOException {
        Subject subject = SecurityUtils.getSubject ();
        subject.logout ();
        response.sendRedirect ( "/login.html" );
    }
}
