package com.sunway.service.impl;

import com.sunway.dao.BaseDao;
import com.sunway.dao.TaxSpfjDao;
import com.sunway.entity.TaxSpfj;
import com.sunway.service.TaxSpfjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaxSpfjServiceImpl implements TaxSpfjService {
    @Autowired
    private TaxSpfjDao taxSpfjDao;

    @Override
    public TaxSpfj getDataById(TaxSpfj bean) {
        return (TaxSpfj)taxSpfjDao.getById(bean.getId());
    }

    @Override
    public List<TaxSpfj> getAllData(TaxSpfj bean, int pageIndex, int pageSize) {
        return taxSpfjDao.getAllData(bean, pageIndex, pageSize);
    }

    @Override
    public boolean execDelete(TaxSpfj bean) {
        boolean bRtn = true;
        try {
            taxSpfjDao.execDelete(bean);
        }catch (Exception e){
            bRtn = false;
        }
        return bRtn;
    }

    @Override
    public boolean execInsert(TaxSpfj bean) {
        boolean bRtn = true;
        try {
            taxSpfjDao.execInsert(bean);
        }catch (Exception e){
            bRtn = false;
        }
        return bRtn;
    }

    @Override
    public boolean execUpdate(TaxSpfj bean) {
        boolean bRtn = true;
        try {
            taxSpfjDao.execUpdate(bean);
        }catch (Exception e){
            bRtn = false;
        }
        return bRtn;
    }
}
