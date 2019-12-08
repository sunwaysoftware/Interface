/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt12002f;
import com.sunway.vo.Pgv12002f;

/**
 * 
 * 土地相关照片
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public interface IPgt12002fService {
	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgt12002f t12002f) throws Exception;

	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt12002f t12002f) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt12002f t12002f) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgv12002f> LoadAll(Pgt12002f t12002f) throws Exception;

	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt12002f LoadByPrimaryKey(Pgt12002f t12002f) throws Exception;
	
	/**
	 * 取得照片类型列表
	 * @return 照片类型列表
	 * @throws Exception
	 */
	public ArrayList<Pgv12002f> LoadZplxList() throws Exception;
}
