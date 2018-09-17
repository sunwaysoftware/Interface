/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt00371a;

/**
 * 
 * 市场法登记信息
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public interface IPgt00371aService {
	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgt00371a t00371a) throws Exception;

	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt00371a t00371a) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt00371a t00371a) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgt00371a> LoadAll(Pgt00371a v00371a) throws Exception;
	public ArrayList<Pgt00371a> LoadAll00302(Pgt00371a v00371a) throws Exception;
	public ArrayList<Pgt00371a> LoadAll00302_B(Pgt00371a v00371a) throws Exception;
	public ArrayList<Pgt00371a> LoadAll02002(Pgt00371a v00371a) throws Exception;
	public ArrayList<Pgt00371a> LoadAll02002_B(Pgt00371a v00371a) throws Exception;

	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt00371a LoadByPrimaryKey(Pgt00371a t00371a) throws Exception;
	
}
