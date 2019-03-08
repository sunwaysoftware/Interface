package com.sunway.service;

import com.sunway.entity.tax.BdcZdsx;

import java.util.List;

public interface BdcZdsxService {
    public BdcZdsx getDataById(BdcZdsx bean);
    public List<BdcZdsx> getAllData(BdcZdsx bean, int pageIndex, int pageSize);
}
