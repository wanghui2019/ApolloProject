package com.hui.service;

import com.hui.domain.BaseDict;

import java.util.List;

public interface BaseDictService {
    //根据Dict_type_code查询数据字典
    List<BaseDict> findByCode(String Dict_type_code);
}
