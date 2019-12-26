package com.sunway.dao;

import com.sunway.entity.BdcFwsx;
import com.sunway.entity.TaxShxx;
import com.sunway.vo.ChartJsVo;

import java.util.List;

public interface BdcFwsxDao extends BaseDao<BdcFwsx> {

    public List<BdcFwsx> getDataByYwh(BdcFwsx bean);
    public List<BdcFwsx> getAllData(BdcFwsx bean, int pageIndex, int pageSize);
}
