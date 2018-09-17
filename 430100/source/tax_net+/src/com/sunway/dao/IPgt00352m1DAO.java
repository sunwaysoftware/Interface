/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt00352m1;

public interface IPgt00352m1DAO {

	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt00352m1 t00352m1) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt00352m1 t00352m1) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgt00352m1> LoadAll(Pgt00352m1 t00352m1) throws Exception;
	
	public boolean GetDeleteAllCommand(Pgt00352m1 t00352m1) throws Exception;
	
	public boolean GetDeleteCommand(Pgt00352m1 t00352m1) throws Exception ;
}
