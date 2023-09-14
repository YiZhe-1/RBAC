package com.huike.service;

import com.huike.entity.SystemDictionaryItem;

import java.util.List;

public interface SystemDictionaryItemService {

    SystemDictionaryItem findAllById(Long id);

    List<SystemDictionaryItem> finAll();
}
