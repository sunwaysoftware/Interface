package com.sunway.service;

import com.sunway.entity.tax.TaxShxx;

import java.util.List;

public interface TaxShxxService {

    public TaxShxx getDataById(TaxShxx bean);

    public List<TaxShxx> getAllData(TaxShxx bean, int pageIndex, int pageSize);

    public boolean execDelete(TaxShxx bean);

    public boolean execInsert(TaxShxx bean);

    public boolean execUpdate(TaxShxx bean);
}
