package com.sunway.service;

import java.util.ArrayList;
import com.sunway.vo.Pgt10051;
import com.sunway.vo.Pgv10051;


/**
 * 成本法残值率
 * @category 成本法残值率
 * @author Lee
 * @version 1.0
 *
 */
public interface IPgt10051Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt10051 czl) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt10051 czl) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt10051 czl) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv10051> LoadAll(Pgv10051 czl) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt10051 LoadByPrimaryKey(Pgt10051 czl) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt10051 czl) throws Exception;
}
