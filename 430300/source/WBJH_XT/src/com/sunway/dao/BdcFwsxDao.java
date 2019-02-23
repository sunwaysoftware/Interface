package com.sunway.dao;

import com.sunway.entity.BdcFwsx;

import java.util.List;

public interface BdcFwsxDao {

    public BdcFwsx getDataById(BdcFwsx bean);
    public List<BdcFwsx> getDataByYwh(BdcFwsx bean);
    public List<BdcFwsx> getAllData(BdcFwsx bean, int pageIndex, int pageSize);

    public List<Double> getCountGroupMonthByYear(Integer year);
}
