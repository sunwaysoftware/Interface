package com.sunway.dao;

import com.sunway.entity.BdcCq;
import com.sunway.entity.TaxShxx;
import com.sunway.vo.ChartJsVo;

import java.util.List;

public interface BdcCqDao extends BaseDao<BdcCq> {

    public List<BdcCq> getDataByYwh(BdcCq bean);
    public List<BdcCq> getAllData(BdcCq bean, int pageIndex, int pageSize);
    public List<ChartJsVo> getCountGroupMonthByYear(Integer year);
}
