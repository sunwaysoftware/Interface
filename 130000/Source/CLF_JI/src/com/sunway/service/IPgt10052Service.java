package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt10052;
import com.sunway.vo.Pgv10052;


/**
 * 成本法建安造价标准
 * @category 成本法建安造价标准
 * @author Lee
 * @version 1.0
 */
public interface IPgt10052Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt10052 jazj) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt10052 jazj) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt10052 jazj) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv10052> LoadAll(Pgv10052 jazj) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt10052 LoadByPrimaryKey(Pgt10052 jazj) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt10052 jazj) throws Exception;
	
}
