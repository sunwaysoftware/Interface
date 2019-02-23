package com.sunway.service.impl;

import com.sunway.dao.BaseDao;
import com.sunway.dao.TaxSpfjDao;
import com.sunway.entity.TaxSpfj;
import com.sunway.service.TaxSpfjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxSpfjServiceImpl implements TaxSpfjService {

    @Autowired
    private BaseDao baseDao;
    @Autowired
    private TaxSpfjDao taxSpfjDao;

    @Override
    public TaxSpfj getDataById(TaxSpfj bean) {
        return (TaxSpfj)baseDao.getDataById(TaxSpfj.class,bean.getId());
    }

    @Override
    public List<TaxSpfj> getAllData(TaxSpfj bean, int pageIndex, int pageSize) {
        return taxSpfjDao.getAllData(bean, pageIndex, pageSize);
    }

    @Override
    public boolean execDelete(TaxSpfj bean) {
        return baseDao.execDelete(bean);
    }

    @Override
    public boolean execInsert(TaxSpfj bean) {
        return baseDao.execInsert(bean);
    }

    @Override
    public boolean execUpdate(TaxSpfj bean) {
        return baseDao.execUpdate(bean);
    }
}
