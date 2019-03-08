package com.sunway.dao;

import com.sunway.entity.tax.TaxShxx;

import java.util.List;

public interface TaxShxxDao {

    public List<TaxShxx> getAllData(TaxShxx bean, int pageIndex, int pageSize);

}
