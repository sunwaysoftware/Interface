package com.sunway.service.impl;

import com.sunway.dao.BaseDao;
import com.sunway.dao.TaxShxxDao;
import com.sunway.entity.TaxShxx;
import com.sunway.service.TaxShxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxShxxServiceImpl implements TaxShxxService {

    @Autowired
    private BaseDao baseDao;
    @Autowired
    private TaxShxxDao taxShxxDao;

    @Override
    public TaxShxx getDataById(TaxShxx bean) {
        return (TaxShxx)baseDao.getDataById(TaxShxx.class, bean.getId());
    }

    @Override
    public boolean execDelete(TaxShxx bean) {
        return baseDao.execDelete(bean);
    }

    @Override
    public boolean execInsert(TaxShxx bean) {
        return baseDao.execInsert(bean);
    }

    @Override
    public boolean execUpdate(TaxShxx bean) {
        return baseDao.execUpdate(bean);
    }

    @Override
    public List<TaxShxx> getAllData(TaxShxx bean, int pageIndex, int pageSize) {
        return taxShxxDao.getAllData(bean, pageIndex, pageSize);
    }
}
