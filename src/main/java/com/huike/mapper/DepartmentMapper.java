package com.huike.mapper;

import com.github.pagehelper.PageInfo;
import com.huike.entity.Department;
import com.huike.query.QueryObject;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface DepartmentMapper {

    @Select("select * from department ORDER BY id DESC ")
    List<Department> list();

    @Delete("delete from department where id = #{id}")
    void delete(Integer id);

    @Insert("INSERT INTO customer VALUES( null,#{name},#{sn});")
    void add(Department department);

    @Update("update department set name=#{name},sn=#{sn} where id=#{id}")
    void update(Department department);

    @Select("select * from department where id=#{deptId}")
    Department getDeptById(Integer deptId);
}
