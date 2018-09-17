package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.CzArcgis;


/**
 * @category 地图相关
 * @author Lee
 * @version 1.0
 */
public interface ICzArcgisService {

	/**
	 * 根据ID得到XY坐标
	 * @return 
	 * @throws Exception
	 */
	public CzArcgis ExecCommandCZ00062(CzArcgis arcgis) throws Exception;
	
	/**
	 * 得到小区名称价格范围
	 * 
	 * @return
	 * @throws Exception
	 */
	public CzArcgis ExecCommandCZ00063(CzArcgis arcgis) throws Exception;

	/**
	 * 得到地产位置信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<CzArcgis> ExecCommandCZ00064(CzArcgis arcgis)
			throws Exception;

	/**
	 * 地产统计
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<CzArcgis> ExecCommandCZ00061(CzArcgis arcgis)
			throws Exception;
}
