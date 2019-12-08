/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv12004c;

/**
 * 
 * 房產明細当前承租人历史表
 * @author Andy.Gao
 *
 */
public interface IPgt12004cDAO {
	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgv12004c> LoadAll(Pgv12004c v12004c) throws Exception;
}
