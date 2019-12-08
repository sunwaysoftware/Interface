/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt00333;

/**
 * 
 * 市場法个案评税其它修正参数表
 * @author Andy.Gao
 *
 */
public interface IPgt00333DAO {
	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00333 bean) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @param PSSD, MXID, QTXZID, CZR, SSGX
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00333 bean) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00333 bean) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @param PSSD, MXID
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgt00333> LoadAll(Pgt00333 bean) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @param PSSD, MXID, QTXZID
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00333 LoadByPrimaryKey(Pgt00333 bean) throws Exception;
	
	/**
	 * 更新个案结果
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean GetModifyCommand(Pgt00333 bean) throws Exception;
}
