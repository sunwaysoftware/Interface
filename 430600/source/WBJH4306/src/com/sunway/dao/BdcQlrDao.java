package com.sunway.dao;

import com.sunway.entity.BdcQlr;
import com.sunway.entity.TaxShxx;

import java.util.List;

public interface BdcQlrDao extends BaseDao<BdcQlr> {

    public List<BdcQlr> getDataByYwh(BdcQlr bean);

}
