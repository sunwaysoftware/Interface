package com.sunway.dao;

import com.sunway.entity.TaxWsxx;

import java.util.List;

public interface TaxWsxxDao {

    public TaxWsxx getDataById(TaxWsxx bean);

    public List<TaxWsxx> getAllData(TaxWsxx bean, int pageIndex, int pageSize);

    public boolean execDelete(TaxWsxx bean);

    public boolean execInsert(TaxWsxx bean);

    public boolean execUpdate(TaxWsxx bean);
}
