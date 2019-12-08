/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt10033;

/**
 * 
 * 成本法个案评税其它修正参数表
 * @author Andy.Gao
 *
 */
public interface IPgt10033Service {
	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt10033 bean) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @param PSSD, MXID, QTXZID, CZR, SSGX
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt10033 bean) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt10033 bean) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @param PSSD, MXID
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgt10033> LoadAll(Pgt10033 bean) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @param PSSD, MXID, QTXZID
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt10033 LoadByPrimaryKey(Pgt10033 bean) throws Exception;
}
