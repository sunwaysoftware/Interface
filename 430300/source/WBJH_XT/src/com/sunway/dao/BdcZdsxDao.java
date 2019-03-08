package com.sunway.dao;

import com.sunway.entity.tax.BdcZdsx;

import java.util.List;

public interface BdcZdsxDao {
    public BdcZdsx getDataById(BdcZdsx bean);
    public List<BdcZdsx> getAllData(BdcZdsx bean, int pageIndex, int pageSize);
}
