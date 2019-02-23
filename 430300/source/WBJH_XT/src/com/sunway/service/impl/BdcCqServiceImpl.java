package com.sunway.service.impl;

import com.sunway.dao.BdcCqDao;
import com.sunway.entity.BdcCq;
import com.sunway.service.BdcCqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BdcCqServiceImpl implements BdcCqService {

    @Autowired
    private BdcCqDao bdcCqDao;

    @Override
    public BdcCq getDataById(BdcCq bean) {
        return bdcCqDao.getDataById(bean);
    }

    @Override
    public List<BdcCq> getAllData(BdcCq bean, int pageIndex, int pageSize) {
        return bdcCqDao.getAllData(bean, pageIndex, pageSize);
    }
}
