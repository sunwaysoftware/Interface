package com.sunway.dao;

import com.sunway.entity.TaxTsxx;

import java.util.List;

public interface TaxTsxxDao {

    public TaxTsxx getDataById(TaxTsxx bean);

    public List<TaxTsxx> getAllData(TaxTsxx bean, int pageIndex, int pageSize);

    public boolean execDelete(TaxTsxx bean);

    public boolean execInsert(TaxTsxx bean);

    public boolean execUpdate(TaxTsxx bean);
}
