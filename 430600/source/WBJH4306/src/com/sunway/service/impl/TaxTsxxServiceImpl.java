package com.sunway.service.impl;

import com.sunway.dao.BaseDao;
import com.sunway.dao.TaxTsxxDao;
import com.sunway.entity.TaxTsxx;
import com.sunway.service.TaxTsxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaxTsxxServiceImpl implements TaxTsxxService {
    @Autowired
    private TaxTsxxDao taxTsxxDao;

    public TaxTsxx getDataById(TaxTsxx bean) {
        return (TaxTsxx)taxTsxxDao.getById(bean.getId());
    }

    public List<TaxTsxx> getAllData(TaxTsxx bean, int pageIndex, int pageSize) {
        return taxTsxxDao.getAllData(bean, pageIndex, pageSize);
    }

    @Override
    public boolean execDelete(TaxTsxx bean) {
        boolean bRtn = true;
        try {
            taxTsxxDao.execDelete(bean);
        }catch (Exception e){
            bRtn = false;
        }
        return bRtn;
    }

    @Override
    public boolean execInsert(TaxTsxx bean) {
        boolean bRtn = true;
        try {
            taxTsxxDao.execInsert(bean);
        }catch (Exception e){
            bRtn = false;
        }
        return bRtn;
    }

    @Override
    public boolean execUpdate(TaxTsxx bean) {
        boolean bRtn = true;
        try {
            taxTsxxDao.execUpdate(bean);
        }catch (Exception e){
            bRtn = false;
        }
        return bRtn;
    }
}
