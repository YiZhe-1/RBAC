package com.huike.mapper;

import com.huike.entity.SystemDictionaryItem;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SystemDictionaryItemMapper {
    @Select("select * from systemdictionaryitem;")
    List<SystemDictionaryItem> findAll();

    @Select("select * from systemdictionaryitem where id = #{id} ;")
    SystemDictionaryItem findAllById(Long id);
}
