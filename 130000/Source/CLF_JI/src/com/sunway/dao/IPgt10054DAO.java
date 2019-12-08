package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt10054;
import com.sunway.vo.Pgv10054;


/**
 * 成本法容积率
 * @category 成本法容积率
 * @author Lee
 * @version 1.0
 */
public interface IPgt10054DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt10054 rjl) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt10054 rjl) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt10054 rjl) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv10054> LoadAll(Pgv10054 rjl) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt10054 LoadByPrimaryKey(Pgt10054 rjl) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt10054 rjl) throws Exception;
	
}
