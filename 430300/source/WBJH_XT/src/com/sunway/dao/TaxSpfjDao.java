package com.sunway.dao;

import com.sunway.entity.tax.TaxSpfj;

import java.util.List;

public interface TaxSpfjDao {

    public List<TaxSpfj> getAllData(TaxSpfj bean, int pageIndex, int pageSize);
}
