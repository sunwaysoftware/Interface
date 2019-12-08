package com.sunway.service;

import java.util.ArrayList;
import com.sunway.vo.Pgt00365;


public interface IPgt00365Service {
	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgt00365 bean) throws Exception;

	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt00365 bean) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt00365 bean) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgt00365> LoadAll(Pgt00365 bean) throws Exception;

	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt00365 LoadByPrimaryKey(Pgt00365 bean) throws Exception;
	
	
	
}
