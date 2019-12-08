/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv12002c;

/**
 * 
 * 房地产当前承租人历史表
 * @author Andy.Gao
 *
 */
public interface IPgt12002cService {

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgv12002c> LoadAll(Pgv12002c v12002c) throws Exception;
}
