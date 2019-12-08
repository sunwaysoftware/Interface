/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt00352f;
import com.sunway.vo.Pgv00352f;

/**
 * 
 * 土地相关照片
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public interface IPgt00352fService {
	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgt00352f t00352f) throws Exception;

	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt00352f t00352f) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt00352f t00352f) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgv00352f> LoadAll(Pgt00352f t00352f) throws Exception;

	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt00352f LoadByPrimaryKey(Pgt00352f t00352f) throws Exception;
	
	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt00352f LoadByPrimaryKeyFC(Pgt00352f t00352f) throws Exception;
	
	/**
	 * 取得照片类型列表
	 * @return 照片类型列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00352f> LoadZplxList() throws Exception;
	
	/**
	 * 根据小区代码删除小区所有图片
	 * @param t00352f
	 * @return
	 * @throws Exception
	 */
	public Boolean GetDeleteByXQCommand(Pgt00352f t00352f) throws Exception;
	
	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgv00352f> LoadAllFC(Pgt00352f t00352f) throws Exception;
}
