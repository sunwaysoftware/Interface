/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv02033a;

/**
 * @author Andy.Gao
 *
 */
public interface IPgv02033aService {

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgv02033a> LoadAll(Pgv02033a bean) throws Exception;
	
	/**
	 * 从历史库中把个案评税参数添加到个案评税参数里
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Boolean GetExecCommand(Pgv02033a bean) throws Exception;
	
}
