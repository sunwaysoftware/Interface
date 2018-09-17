package com.sunway.service;

import java.util.ArrayList;
import com.sunway.vo.ChartBzslk;
public interface IChartBzslkService {
	/**
	 * 批量产生新实例
	 * @param bzSlk
	 * @return
	 */
	public Boolean GetUpdateSlk(ChartBzslk chart) throws Exception;
	
	/**
	 * 取得图形数据
	 * @return
	 */
	public ArrayList<ChartBzslk> LoadByUpdate(ChartBzslk chart) throws Exception;
	
	/**
	 * 计算取得【增长率】
	 * @param chart 更新月份
	 * @return 增长率
	 * @throws Exception
	 */
	public Double GetZzl(ChartBzslk chart) throws Exception;
}
