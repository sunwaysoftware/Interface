/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv02002c;

/**
 * 
 * 收益法商品房房屋信息综合修正
 * @author Andy
 *
 */
public interface IPgt02002cDAO {
	
	/**
	 * 取值：综合修正
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv02002c> LoadAll(Pgv02002c bean) throws Exception;
	
	/**
	 * 取得市场法全面评估国土其它修正参数表
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv02002c> LoadAllQM(Pgv02002c v02002c) throws Exception;	
	
}
