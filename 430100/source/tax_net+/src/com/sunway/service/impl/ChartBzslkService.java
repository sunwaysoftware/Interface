/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;
import com.sunway.dao.IChartBzslkDAO;
import com.sunway.service.IChartBzslkService;
import com.sunway.vo.ChartBzslk;

/**
 * @author Lee
 *
 */
public class ChartBzslkService implements IChartBzslkService {

	private IChartBzslkDAO chartBzslkDao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IChartBzslkService#GetUpdateSlk(java.util.Date, java.lang.Double, java.lang.String)
	 */
	@Override
	public Boolean GetUpdateSlk(ChartBzslk chart) throws Exception{
		return chartBzslkDao.GetUpdateSlk(chart);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IChartBzslkService#LoadByUpdate(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<ChartBzslk> LoadByUpdate(ChartBzslk chart) throws Exception{
		return chartBzslkDao.LoadByUpdate(chart);
	}

	/**
	 * @return the chartBzslkDao
	 */
	public IChartBzslkDAO getChartBzslkDao() {
		return chartBzslkDao;
	}

	/**
	 * @param chartBzslkDao the chartBzslkDao to set
	 */
	public void setChartBzslkDao(IChartBzslkDAO chartBzslkDao) {
		this.chartBzslkDao = chartBzslkDao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IChartBzslkService#GetZzl(com.sunway.vo.ChartBzslk)
	 */
	@Override
	public Double GetZzl(ChartBzslk chart) throws Exception {
		return chartBzslkDao.GetZzl(chart);
	}

}
