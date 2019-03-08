package com.sunway.service.impl;

import com.sunway.dao.BdcFwsxDao;
import com.sunway.entity.tax.BdcFwsx;
import com.sunway.service.BdcFwsxService;
import com.sunway.vo.ChartJsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BdcFwsxServiceImpl implements BdcFwsxService {

    @Autowired
    private BdcFwsxDao bdcFwsxDao;

    @Override
    public BdcFwsx getDataById(BdcFwsx bean) {
        return bdcFwsxDao.getDataById(bean);
    }

    @Override
    public List<BdcFwsx> getAllData(BdcFwsx bean, int pageIndex, int pageSize) {
        return bdcFwsxDao.getAllData(bean, pageIndex, pageSize);
    }

    @Override
    public List<ChartJsVo> getCountGroupMonthByYear(Integer year) {
        return bdcFwsxDao.getCountGroupMonthByYear(year);
    }
}
