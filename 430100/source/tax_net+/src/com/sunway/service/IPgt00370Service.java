package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt00370;
import com.sunway.vo.Pgv00370;

/**
 * 税种
 * @author HuanWei
 *
 */
public interface IPgt00370Service {

	/**
	 * 进行数据插入操作
	 * @param t00370
	 * @return
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00370 t00370)throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @param t00370
	 * @return
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00370 t00370)throws Exception ;
	
	/**
	 * 进行数据更新操作
	 * @param t00370
	 * @return
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00370 t00370)throws Exception ;
	
	/**
	 * 根据PK进行数据提取操作
	 * @param t00370
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00370> LoadByPrimaryKey(Pgv00370 v00370)throws Exception ;
	/**
	 * 根据PK进行数据提取操作
	 * @param t00370
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00370> LoadByPrimaryKey_B(Pgv00370 v00370)throws Exception ;
	
	/**
	 * 进行数据提取操作
	 * @param v00370
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00370> LoadAll(Pgv00370 v00370)throws Exception ;
	
	/**
	 * 插入发票税票代码
	 * @param v00370
	 * @return
	 * @throws Exception
	 */
	public boolean GetInsertCommandFPSP(Pgv00370 v00370)throws Exception;
}
