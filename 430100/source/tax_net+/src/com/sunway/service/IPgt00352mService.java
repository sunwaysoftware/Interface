/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;
import com.sunway.vo.Pgt00352m;

/**
 * 
 * 土地相关照片
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public interface IPgt00352mService {
	
	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt00352m t00352m) throws Exception;
	

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt00352m t00352m) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgt00352m> LoadAll(Pgt00352m t00352m) throws Exception;
	
	public ArrayList<Pgt00352m> LoadAll0(Pgt00352m t00352m) throws Exception;
	
	public boolean GetDeleteAllCommand(Pgt00352m t00352m) throws Exception;
	
	public boolean GetDeleteCommand(Pgt00352m t00352m) throws Exception ;
	}
