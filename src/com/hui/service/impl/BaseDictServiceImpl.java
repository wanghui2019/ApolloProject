package com.hui.service.impl;

import com.hui.dao.BaseDictDao;
import com.hui.domain.BaseDict;
import com.hui.service.BaseDictService;

import java.util.List;

public class BaseDictServiceImpl implements BaseDictService {
    private BaseDictDao baseDictDao;

    public void setBaseDictDao(BaseDictDao baseDictDao) {
        this.baseDictDao = baseDictDao;
    }

    public List<BaseDict> findByCode(String Dict_type_code){
        return baseDictDao.findByCode(Dict_type_code);
    }
}
