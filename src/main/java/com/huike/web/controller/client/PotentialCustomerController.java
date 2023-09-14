package com.huike.web.controller.client;

import com.github.pagehelper.PageInfo;
import com.huike.entity.Customer;
import com.huike.query.CustomerQuery;
import com.huike.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

public class PotentialCustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/potentialcustomer")
    public String list(Model model , @ModelAttribute("qo") CustomerQuery customerQuery) {
        //查询潜在客户
        PageInfo <Customer> customers = customerService.findpc ( customerQuery );
        model.addAttribute ( "pageInfo" , customers );
        return "potentialcustomerlist";
    }
}


