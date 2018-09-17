package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt00364;


public interface IPgt00364Service {
	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgt00364 bean) throws Exception;

	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt00364 bean) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt00364 bean) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgt00364> LoadAll(Pgt00364 bean) throws Exception;

	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt00364 LoadByPrimaryKey(Pgt00364 bean) throws Exception;
	
	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommandA(Pgt00364 bean) throws Exception;

	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommandA(Pgt00364 bean) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommandA(Pgt00364 bean) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgt00364> LoadAllA(Pgt00364 bean) throws Exception;

	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt00364 LoadByPrimaryKeyA(Pgt00364 bean) throws Exception;
	
}
