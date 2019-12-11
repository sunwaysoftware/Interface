package com.sunway.service;

import com.sunway.entity.TaxSpfj;

import java.util.List;

public interface TaxSpfjService {
    public TaxSpfj getDataById(TaxSpfj bean);

    public List<TaxSpfj> getAllData(TaxSpfj bean, int pageIndex, int pageSize);

    public boolean execDelete(TaxSpfj bean);

    public boolean execInsert(TaxSpfj bean);

    public boolean execUpdate(TaxSpfj bean);
}
