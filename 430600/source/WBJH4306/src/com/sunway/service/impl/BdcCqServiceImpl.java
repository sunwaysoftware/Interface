package com.sunway.service.impl;

import com.sunway.dao.BdcCqDao;
import com.sunway.entity.BdcCq;
import com.sunway.service.BdcCqService;
import com.sunway.vo.ChartJsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BdcCqServiceImpl implements BdcCqService {

    @Autowired
    private BdcCqDao bdcCqDao;

    @Override
    public BdcCq getDataById(BdcCq bean) {
        return bdcCqDao.getById(bean.getId());
    }

    @Override
    public List<BdcCq> getDataByYwh(BdcCq bean) {
        return bdcCqDao.getDataByYwh(bean);
    }

    @Override
    public List<BdcCq> getAllData(BdcCq bean, int pageIndex, int pageSize) {
        return bdcCqDao.getAllData(bean, pageIndex, pageSize);
    }

    @Override
    public List<ChartJsVo> getCountGroupMonthByYear(Integer year) {
        List<ChartJsVo> rtnList = new ArrayList<>();
        List<ChartJsVo> tmpList = bdcCqDao.getCountGroupMonthByYear(year);
        for(int i=1; i<13; i++){
            ChartJsVo chartVo = new ChartJsVo(i, 0);
            for(ChartJsVo vo : tmpList){
                if(i == Integer.parseInt(vo.getLabel())){
                    chartVo.setData(vo.getData());
                }
            }
            chartVo.setLabel(i + "月");
            rtnList.add(chartVo);
            chartVo = null;
        }
        return rtnList;
    }
}
