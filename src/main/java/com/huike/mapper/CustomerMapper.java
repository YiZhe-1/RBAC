package com.huike.mapper;

import com.huike.entity.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {

    @Select("select * from customer ORDER BY id DESC")
    List <Customer> list();

    @Select("select * from customer where status = 2")
    List <Customer> findpc();

    @Insert("INSERT INTO customer VALUES (null,#{name},#{age},#{gender},#{tel},#{qq},#{job_id},#{source_id});")
    void add(Customer customer);

    @Update("update customer set name=#{name},status=#{status} where id=#{id}")
    void update(Customer customer);
}
