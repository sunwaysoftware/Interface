package com.sunway.dao;

import com.sunway.entity.BdcZdsx;
import com.sunway.entity.TaxShxx;

import java.util.List;

public interface BdcZdsxDao extends BaseDao<BdcZdsx> {

    public List<BdcZdsx> getAllData(BdcZdsx bean, int pageIndex, int pageSize);
}
