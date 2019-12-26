package com.sunway.service.impl;

import com.sunway.dao.BdcFwsxDao;
import com.sunway.entity.BdcFwsx;
import com.sunway.service.BdcFwsxService;
import com.sunway.vo.ChartJsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BdcFwsxServiceImpl implements BdcFwsxService {

    @Autowired
    private BdcFwsxDao bdcFwsxDao;

    @Override
    public BdcFwsx getDataById(BdcFwsx bean) {
        return bdcFwsxDao.getById(bean.getId());
    }

    @Override
    public List<BdcFwsx> getDataByYwh(BdcFwsx bean) {
        return bdcFwsxDao.getDataByYwh(bean);
    }

    @Override
    public List<BdcFwsx> getAllData(BdcFwsx bean, int pageIndex, int pageSize) {
        return bdcFwsxDao.getAllData(bean, pageIndex, pageSize);
    }

}
