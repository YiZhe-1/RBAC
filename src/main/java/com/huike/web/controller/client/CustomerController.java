package com.huike.web.controller.client;

import com.github.pagehelper.PageInfo;
import com.huike.entity.Customer;
import com.huike.entity.Employee;
import com.huike.entity.SystemDictionaryItem;
import com.huike.query.CustomerQuery;
import com.huike.service.CustomerService;
import com.huike.service.EmployeeService;
import com.huike.service.SystemDictionaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SystemDictionaryItemService systemDictionaryItemService;

    @RequestMapping("/list")
    public String list(Model model , @ModelAttribute("qo") CustomerQuery customerQuery) {
        //职业回显
        List <SystemDictionaryItem> jobs = systemDictionaryItemService.finAll ();
        model.addAttribute ( "job" , jobs );
        //来源回显
        List <SystemDictionaryItem> sources = systemDictionaryItemService.finAll ();
        model.addAttribute ( "source" , sources );
        //销售员回显
        List <Employee> employees = employeeService.findAll ();
        model.addAttribute ( "sellers" , employees );
        //查询全部客户
        PageInfo <Customer> customers = customerService.list ( customerQuery );
        model.addAttribute ( "pageInfo" , customers );
        return "customer/list";
    }

    //编辑
    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Customer customer) {
        customerService.saveOrUpdate ( customer );
        return "redirect:/customer/list";
    }

}
