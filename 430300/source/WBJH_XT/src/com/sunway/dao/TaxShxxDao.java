package com.sunway.dao;

import com.sunway.entity.TaxShxx;

import java.util.List;

public interface TaxShxxDao {

    public List<TaxShxx> getAllData(TaxShxx bean, int pageIndex, int pageSize);

}
