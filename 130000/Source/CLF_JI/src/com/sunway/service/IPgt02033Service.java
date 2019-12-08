/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt02033;

/**
 * 
 * 收益法个案评税其它修正参数表
 * @author Andy.Gao
 *
 */
public interface IPgt02033Service {
	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt02033 bean) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @param PSSD, MXID, QTXZID, CZR, SSGX
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt02033 bean) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt02033 bean) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @param PSSD, MXID
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgt02033> LoadAll(Pgt02033 bean) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @param PSSD, MXID, QTXZID
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02033 LoadByPrimaryKey(Pgt02033 bean) throws Exception;
}
