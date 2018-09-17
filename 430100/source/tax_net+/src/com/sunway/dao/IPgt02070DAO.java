package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt02070;

/**
 * 税种
 * @author HuanWei
 *
 */
public interface IPgt02070DAO {

	/**
	 * 进行数据增加操作
	 * @param t02070
	 * @return
	 * @throws Excepiton
	 */
	public boolean GetInsertCommand(Pgt02070 t02070)throws Exception ;
	
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
	 * @param t02070
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt02070> LoadAll(Pgt02070 v02070)throws Exception ;
	
	/**
	 * 进行发票和税票插入
	 * @param v02070
	 * @return
	 * @throws Exception
	 *//*
	public boolean GetInsertCommandFPSP(Pgt02070 v02070)throws Exception ;*/
}
