package com.sunway.service.impl;

import com.sunway.dao.TaxWsxxDao;
import com.sunway.entity.TaxWsxx;
import com.sunway.service.TaxWsxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxWsxxServiceImpl implements TaxWsxxService {

    @Autowired
    private TaxWsxxDao taxWsxxDao;

    @Override
    public TaxWsxx getDataById(TaxWsxx bean) {
        return taxWsxxDao.getDataById(bean);
    }

    @Override
    public List<TaxWsxx> getAllData(TaxWsxx bean, int pageIndex, int pageSize) {
        return taxWsxxDao.getAllData(bean, pageIndex, pageSize);
    }

    @Override
    public boolean execDelete(TaxWsxx bean) {
        return taxWsxxDao.execDelete(bean);
    }

    @Override
    public boolean execInsert(TaxWsxx bean) {
        return taxWsxxDao.execInsert(bean);
    }

    @Override
    public boolean execUpdate(TaxWsxx bean) {
        return taxWsxxDao.execUpdate(bean);
    }
}
