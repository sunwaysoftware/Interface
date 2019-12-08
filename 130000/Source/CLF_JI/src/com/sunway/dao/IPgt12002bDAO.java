/**
 * 
 */
package com.sunway.dao;

import com.sunway.vo.Pgt12002b;
import com.sunway.vo.Pgv12002b;

/**
 * 
 * 土地当前承租人表
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public interface IPgt12002bDAO {

	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgt12002b t12002b) throws Exception;

	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt12002b t12002b) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt12002b t12002b) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public Pgv12002b LoadAll(Pgv12002b v12002b) throws Exception;

	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt12002b LoadByPrimaryKey(Pgt12002b t12002b) throws Exception;
	
}
