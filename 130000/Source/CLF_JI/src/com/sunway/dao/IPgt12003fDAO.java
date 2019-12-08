/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt12003f;
import com.sunway.vo.Pgv12003f;

/**
 * 
 * 房产相关照片
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public interface IPgt12003fDAO {

	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgt12003f t12003f) throws Exception;

	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt12003f t12003f) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt12003f t12003f) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgv12003f> LoadAll(Pgt12003f t12003f) throws Exception;

	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt12003f LoadByPrimaryKey(Pgt12003f t12003f) throws Exception;
	
	/**
	 * 取得照片类型列表
	 * @return 照片类型列表
	 * @throws Exception
	 */
	public ArrayList<Pgv12003f> LoadZplxList() throws Exception;
	
}
