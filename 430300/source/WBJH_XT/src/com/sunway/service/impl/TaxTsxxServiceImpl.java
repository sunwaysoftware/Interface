package com.sunway.service.impl;

import com.sunway.dao.TaxTsxxDao;
import com.sunway.entity.tax.TaxTsxx;
import com.sunway.service.TaxTsxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxTsxxServiceImpl implements TaxTsxxService {
    @Autowired
    private TaxTsxxDao taxTsxxDao;

    @Override
    public TaxTsxx getDataById(TaxTsxx bean) {
        return taxTsxxDao.getDataById(bean);
    }

    @Override
    public List<TaxTsxx> getAllData(TaxTsxx bean, int pageIndex, int pageSize) {
        return taxTsxxDao.getAllData(bean, pageIndex, pageSize);
    }

    @Override
    public boolean execDelete(TaxTsxx bean) {
        return taxTsxxDao.execDelete(bean);
    }

    @Override
    public boolean execInsert(TaxTsxx bean) {
        return taxTsxxDao.execInsert(bean);
    }

    @Override
    public boolean execUpdate(TaxTsxx bean) {
        return taxTsxxDao.execUpdate(bean);
    }
}
