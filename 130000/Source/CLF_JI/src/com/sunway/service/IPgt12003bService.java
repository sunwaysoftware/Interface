/**
 * 
 */
package com.sunway.service;

import com.sunway.vo.Pgt12003b;
import com.sunway.vo.Pgv12003b;

/**
 * 
 * 房产当前承租人表
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public interface IPgt12003bService {
	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgt12003b t12003b) throws Exception;

	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt12003b t12003b) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt12003b t12003b) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public Pgv12003b LoadAll(Pgv12003b v12003b) throws Exception;

	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt12003b LoadByPrimaryKey(Pgt12003b t12003b) throws Exception;
}
