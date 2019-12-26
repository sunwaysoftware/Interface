package com.sunway.service;

import com.sunway.entity.BdcCq;
import com.sunway.vo.ChartJsVo;

import java.util.List;

public interface BdcCqService {
    public BdcCq getDataById(BdcCq bean);
    public List<BdcCq> getDataByYwh(BdcCq bean);
    public List<BdcCq> getAllData(BdcCq bean, int pageIndex, int pageSize);
    public List<ChartJsVo> getCountGroupMonthByYear(Integer year);
}
