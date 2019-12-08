/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv12002e;

/**
 * 
 * 成本法土地其它评税参数表
 * @author Andy.Gao
 *
 */
public interface IPgt12002eDAO {

	/**
	 * 取得土地其它评税参数列表
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv12002e> LoadAll(Pgv12002e v12002e) throws Exception;
	
}
