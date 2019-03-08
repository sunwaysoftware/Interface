package com.sunway.dao;

import com.sunway.entity.tax.BdcFwsx;
import com.sunway.vo.ChartJsVo;

import java.util.List;

public interface BdcFwsxDao {

    public BdcFwsx getDataById(BdcFwsx bean);
    public List<BdcFwsx> getDataByYwh(BdcFwsx bean);
    public List<BdcFwsx> getAllData(BdcFwsx bean, int pageIndex, int pageSize);

    public List<ChartJsVo> getCountGroupMonthByYear(Integer year);
}
