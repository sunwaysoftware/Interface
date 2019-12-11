package com.sunway.dao;

import com.sunway.entity.TaxWsxx;

import java.util.List;

public interface TaxWsxxDao extends BaseDao<TaxWsxx> {

    public List<TaxWsxx> getAllData(TaxWsxx bean, int pageIndex, int pageSize);

}
