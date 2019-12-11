package com.sunway.dao;

import com.sunway.entity.TaxShjgDict;
import com.sunway.entity.TaxShxx;

import java.util.List;

public interface TaxShjgDictDao extends BaseDao<TaxShjgDict> {
    public List<TaxShjgDict> getAllData();
}
