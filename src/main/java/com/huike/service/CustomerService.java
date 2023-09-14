package com.huike.service;

import com.github.pagehelper.PageInfo;
import com.huike.entity.Customer;
import com.huike.query.CustomerQuery;


public interface CustomerService {

    PageInfo <Customer> list(CustomerQuery customerQuery);

    PageInfo <Customer> findpc(CustomerQuery customerQuery);

    //修改状态
    void saveOrUpdate(Customer customer);
}
