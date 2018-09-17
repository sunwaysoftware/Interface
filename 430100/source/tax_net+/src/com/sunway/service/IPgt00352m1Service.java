/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt00352m1;

/**
 * 
 * 所在区域的地图范围
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public interface IPgt00352m1Service {
	
	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt00352m1 t00352m1) throws Exception;
	

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt00352m1 t00352m1) throws Exception;

	public ArrayList<Pgt00352m1> LoadAll(Pgt00352m1 t00352m1) throws Exception;
	
	public boolean GetDeleteAllCommand(Pgt00352m1 t00352m1) throws Exception;
	
	public boolean GetDeleteCommand(Pgt00352m1 t00352m1) throws Exception ;
	}
