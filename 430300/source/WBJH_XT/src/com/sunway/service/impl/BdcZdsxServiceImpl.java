package com.sunway.service.impl;

import com.sunway.dao.BdcZdsxDao;
import com.sunway.entity.tax.BdcZdsx;
import com.sunway.service.BdcZdsxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BdcZdsxServiceImpl implements BdcZdsxService {

    @Autowired
    private BdcZdsxDao zdsxDao;

    @Override
    public BdcZdsx getDataById(BdcZdsx bean) {
        return zdsxDao.getDataById(bean);
    }

    @Override
    public List<BdcZdsx> getAllData(BdcZdsx bean, int pageIndex, int pageSize) {
        return zdsxDao.getAllData(bean, pageIndex, pageSize);
    }
}
