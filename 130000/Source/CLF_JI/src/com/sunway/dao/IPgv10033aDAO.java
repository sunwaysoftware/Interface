/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv10033a;

/**
 * @author Andy.Gao
 *
 */
public interface IPgv10033aDAO {

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgv10033a> LoadAll(Pgv10033a bean) throws Exception;
	
	/**
	 * 从历史库中把个案评税参数添加到个案评税参数里
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Boolean GetExecCommand(Pgv10033a bean) throws Exception;
	
}
