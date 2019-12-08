/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv00333a;

/**
 * @author Andy.Gao
 *
 */
public interface IPgv00333aDAO {

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgv00333a> LoadAll(Pgv00333a bean) throws Exception;
	
	/**
	 * 从历史库中把个案评税参数添加到个案评税参数里
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Boolean GetExecCommand(Pgv00333a bean) throws Exception;
	
}
