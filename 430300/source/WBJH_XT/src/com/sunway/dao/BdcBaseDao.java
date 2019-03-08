package com.sunway.dao;

import com.sunway.entity.tax.TaxWsxx;

public interface BdcBaseDao {
    public boolean execInsert_wsxx(TaxWsxx bean);
    public boolean execDelete_wsxx(TaxWsxx bean);
}
