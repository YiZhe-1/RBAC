package com.huike.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huike.entity.Customer;
import com.huike.entity.Employee;
import com.huike.entity.SystemDictionaryItem;
import com.huike.mapper.CustomerMapper;
import com.huike.mapper.EmployeeMapper;
import com.huike.mapper.SystemDictionaryItemMapper;
import com.huike.query.CustomerQuery;
import com.huike.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private SystemDictionaryItemMapper systemDictionaryItemMapper;

    @Override
    public PageInfo <Customer> list(CustomerQuery customerQuery) {
        PageHelper.startPage ( customerQuery.getCurrentPage () , customerQuery.getPageSize () );
        //获取客户信息列表
        List <Customer> customers = customerMapper.list ();
        for (Customer customer : customers) {
            Long jobID = customer.getJobId ();
            Long sourceId = customer.getSourceId ();
            Long sellerId = customer.getSellerId ();
            //销售人员
            Employee employee = employeeMapper.getEmployeeById ( sellerId );
            customer.setSeller ( employee );
            //职业
            SystemDictionaryItem job = systemDictionaryItemMapper.findAllById ( jobID );
            customer.setJob ( job );
            //来源
            SystemDictionaryItem source = systemDictionaryItemMapper.findAllById ( sourceId );
            customer.setSource ( source );
        }
        //封装成一个PageInfo对象返回
        PageInfo <Customer> pageInfo = new PageInfo <> ( customers );
        return pageInfo;
    }

    @Override
    public PageInfo <Customer> findpc(CustomerQuery customerQuery) {
        //获取客户信息列表
        List <Customer> customers = customerMapper.findpc ();
        for (Customer customer : customers) {
            Long jobID = customer.getJobId ();
            Long sourceId = customer.getSourceId ();
            Long sellerId = customer.getSellerId ();
            //销售人员
            Employee employee = employeeMapper.getEmployeeById ( sellerId );
            customer.setSeller ( employee );
            //职业
            SystemDictionaryItem job = systemDictionaryItemMapper.findAllById ( jobID );
            customer.setJob ( job );
            //来源
            SystemDictionaryItem source = systemDictionaryItemMapper.findAllById ( sourceId );
            customer.setSource ( source );
        }
        //封装成一个PageInfo对象返回
        PageInfo <Customer> pageInfo = new PageInfo <> ( customers );
        return pageInfo;
    }

    @Override
    public void saveOrUpdate(Customer customer) {
        Long id = customer.getId ();
        if (id == null) {
            //添加
            customerMapper.add ( customer );
        } else {
            //修改
            customerMapper.update ( customer );
        }
    }
}
