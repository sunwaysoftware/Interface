package com.sunway.service;

import com.sunway.entity.tax.TaxTsxx;

import java.util.List;

public interface TaxTsxxService {

    public TaxTsxx getDataById(TaxTsxx bean);

    public List<TaxTsxx> getAllData(TaxTsxx bean, int pageIndex, int pageSize);

    public boolean execDelete(TaxTsxx bean);

    public boolean execInsert(TaxTsxx bean);

    public boolean execUpdate(TaxTsxx bean);


}
