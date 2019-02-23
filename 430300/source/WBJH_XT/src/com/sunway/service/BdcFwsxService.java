package com.sunway.service;

import com.sunway.entity.BdcFwsx;

import java.util.List;

public interface BdcFwsxService {

    public BdcFwsx getDataById(BdcFwsx bean);
    public List<BdcFwsx> getAllData(BdcFwsx bean, int pageIndex, int pageSize);
    public List<Double> getCountGroupMonthByYear(Integer year);
}
