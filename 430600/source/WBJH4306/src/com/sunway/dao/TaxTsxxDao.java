package com.sunway.dao;

import com.sunway.entity.TaxTsxx;

import java.util.List;

public interface TaxTsxxDao extends BaseDao<TaxTsxx> {

    public List<TaxTsxx> getAllData(TaxTsxx bean, int pageIndex, int pageSize);

}
