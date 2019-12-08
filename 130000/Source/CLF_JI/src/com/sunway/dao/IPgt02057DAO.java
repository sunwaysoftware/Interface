package com.sunway.dao;

import java.util.ArrayList;
import com.sunway.vo.Pgt02057;
import com.sunway.vo.Pgv02057;


/**
 * 收益法资本化率维护
 * @category 收益法资本化率
 * @author Lee
 * @version 1.0
 */
public interface IPgt02057DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt02057 zbhl) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt02057 zbhl) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt02057 zbhl) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02057> LoadAll(Pgv02057 zbhl) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02057 LoadByPrimaryKey(Pgt02057 zbhl) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt02057 zbhl) throws Exception;
}
