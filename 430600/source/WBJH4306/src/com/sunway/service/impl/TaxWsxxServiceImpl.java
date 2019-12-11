package com.sunway.service.impl;

import com.sunway.dao.TaxWsxxDao;
import com.sunway.entity.TaxWsxx;
import com.sunway.service.TaxWsxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaxWsxxServiceImpl implements TaxWsxxService {
    @Autowired
    private TaxWsxxDao taxWsxxDao;

    @Override
    public TaxWsxx getDataById(TaxWsxx bean) {
        return taxWsxxDao.getById(bean.getId());
    }

    @Override
    public List<TaxWsxx> getAllData(TaxWsxx bean, int pageIndex, int pageSize) {
        return taxWsxxDao.getAllData(bean, pageIndex, pageSize);
    }

    @Override
    public boolean execDelete(TaxWsxx bean) {
        boolean bRtn = true;
        try {
            taxWsxxDao.execDelete(bean);
        }catch (Exception e){
            bRtn = false;
        }
        return bRtn;
    }

    @Override
    public boolean execInsert(TaxWsxx bean) {
        boolean bRtn = true;
        try {
            taxWsxxDao.execInsert(bean);
        }catch (Exception e){
            bRtn = false;
        }
        return bRtn;
    }

    @Override
    public boolean execUpdate(TaxWsxx bean) {
        boolean bRtn = true;
        try {
            taxWsxxDao.execUpdate(bean);
        }catch (Exception e){
            bRtn = false;
        }
        return bRtn;
    }
}
