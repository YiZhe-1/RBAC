package com.huike.service.impl;

import com.huike.entity.SystemDictionaryItem;
import com.huike.mapper.SystemDictionaryItemMapper;
import com.huike.service.SystemDictionaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemDictionaryItemServiceImpl implements SystemDictionaryItemService {

    @Autowired
    private SystemDictionaryItemMapper systemDictionaryItemMapper;

    @Override
    public SystemDictionaryItem findAllById(Long id) {
        return systemDictionaryItemMapper.findAllById ( id );
    }

    @Override
    public List <SystemDictionaryItem> finAll() {

        return systemDictionaryItemMapper.findAll ();
    }
}
