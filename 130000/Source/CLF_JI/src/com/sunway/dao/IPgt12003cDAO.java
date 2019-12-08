/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv12003c;

/**
 * 
 * 房地产当前承租人历史表
 * @author Andy.Gao
 *
 */
public interface IPgt12003cDAO {

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgv12003c> LoadAll(Pgv12003c v12003c) throws Exception;
	
}
