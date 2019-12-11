package com.sunway.service.impl;

import com.sunway.dao.BaseDao;
import com.sunway.dao.TaxShxxDao;
import com.sunway.entity.TaxShxx;
import com.sunway.service.TaxShxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaxShxxServiceImpl implements TaxShxxService {

    @Autowired
    private TaxShxxDao taxShxxDao;

    @Override
    public TaxShxx getDataById(TaxShxx bean) {
        return (TaxShxx)taxShxxDao.getById(bean.getId());
    }

    @Override
    public boolean execDelete(TaxShxx bean) {
        boolean bRtn = true;
        try {
            taxShxxDao.execDelete(bean);
        }catch (Exception e){
            bRtn = false;
        }
        return bRtn;
    }

    @Override
    public boolean execInsert(TaxShxx bean) {
        boolean bRtn = true;
        try {
            taxShxxDao.execInsert(bean);
        }catch (Exception e){
            bRtn = false;
        }
        return bRtn;
    }

    @Override
    public boolean execUpdate(TaxShxx bean) {
        boolean bRtn = true;
        try {
            taxShxxDao.execUpdate(bean);
        }catch (Exception e){
            bRtn = false;
        }
        return bRtn;
    }

    @Override
    public List<TaxShxx> getAllData(TaxShxx bean, int pageIndex, int pageSize) {
        return taxShxxDao.getAllData(bean, pageIndex, pageSize);
    }
}
