/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv12004d;

/**
 * 
 * 成本法、收益法房屋设施参数表
 * @author Andy.Gao
 *
 */
public interface IPgt12004dDAO {
	/**
	 * 取得房屋设施参数表
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv12004d> LoadAll(Pgv12004d v12004d) throws Exception;
}
