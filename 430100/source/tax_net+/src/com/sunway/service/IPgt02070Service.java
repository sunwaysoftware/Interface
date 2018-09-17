package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt02070;

/**
 * 税种
 * @author HuanWei
 *
 */
public interface IPgt02070Service {

	/**
	 * 进行数据插入操作
	 * @param t02070
	 * @return
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt02070 t02070)throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @param t02070
	 * @return
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt02070 t02070)throws Exception ;
	
	/**
	 * 进行数据更新操作
	 * @param t02070
	 * @return
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt02070 t02070)throws Exception ;
	
	/**
	 * 根据PK进行数据提取操作
	 * @param t02070
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt02070> LoadByPrimaryKey(Pgt02070 v02070)throws Exception ;
	/**
	 * 根据PK进行数据提取操作
	 * @param t02070
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt02070> LoadByPrimaryKey_B(Pgt02070 v02070)throws Exception ;
	
	/**
	 * 进行数据提取操作
	 * @param v02070
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt02070> LoadAll(Pgt02070 v02070)throws Exception ;
	
	/**
	 * 插入发票税票代码
	 * @param v02070
	 * @return
	 * @throws Exception
	 *//*
	public boolean GetInsertCommandFPSP(Pgt02070 v02070)throws Exception;*/
}
