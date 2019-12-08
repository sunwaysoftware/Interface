/**
 * 
 */
package com.sunway.service;

import com.sunway.vo.Pgt12004b;
import com.sunway.vo.Pgv12004b;

/**
 * 
 * 房产明细当前承租人表
 * @author Andy.Gao
 *
 */
public interface IPgt12004bService {
	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgt12004b t12004b) throws Exception;

	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt12004b t12004b) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt12004b t12004b) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public Pgv12004b LoadAll(Pgv12004b v12004b) throws Exception;

	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt12004b LoadByPrimaryKey(Pgt12004b t12004b) throws Exception;
}
