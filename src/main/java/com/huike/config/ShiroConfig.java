package com.huike.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //1.配置reaml
    @Bean
    public UserReaml reaml(){
        return new UserReaml();
    }

    //2.配置DefaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("reaml") UserReaml reaml){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(reaml);

        return defaultWebSecurityManager;
    }

    //3.配置ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //拦截
        /*
         * anon:无需认证就可访问
         * authc：必须认证了才可访问
         * user:必须拥有  记住我  功能才可访问
         * perms:必须拥有某个资源的权限才可访问
         * role: 拥有某个角色权限才能访问
         * */
        Map<String,String> map = new LinkedHashMap<>();

        map.put("/css/**","anon");
        map.put("/img/**","anon");
        map.put("/js/**","anon");
        map.put("/login.html","anon");
        map.put("/user/login","anon");

        map.put("/**","authc");

        filterFactoryBean.setFilterChainDefinitionMap(map);
        //如果没有登录，可以跳转到登录页面
        filterFactoryBean.setLoginUrl("/user/toLogin");
        filterFactoryBean.setUnauthorizedUrl("/permission/unauthorized");
        return filterFactoryBean;
    }
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
