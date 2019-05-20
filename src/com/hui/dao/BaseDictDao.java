package com.hui.dao;

import com.hui.domain.BaseDict;

import java.util.List;

public interface BaseDictDao {
    //根据Dict_type_code查询数据字典
    List<BaseDict> findByCode(String Dict_type_code);
}
