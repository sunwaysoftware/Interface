package com.sunway.dao;

import com.sunway.entity.tax.BdcCq;

import java.util.List;

public interface BdcCqDao {

    public BdcCq getDataById(BdcCq bean);
    public List<BdcCq> getDataByYwh(BdcCq bean);
    public List<BdcCq> getAllData(BdcCq bean, int pageIndex, int pageSize);

}
