package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt02064;

public interface IPgt02064DAO {
	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgt02064 bean) throws Exception;

	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt02064 bean) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt02064 bean) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgt02064> LoadAll(Pgt02064 bean) throws Exception;

	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt02064 LoadByPrimaryKey(Pgt02064 bean) throws Exception;
	
	

}
