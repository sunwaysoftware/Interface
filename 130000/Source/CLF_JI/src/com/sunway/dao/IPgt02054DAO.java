package com.sunway.dao;

import java.util.ArrayList;
import com.sunway.vo.Pgt02054;
import com.sunway.vo.Pgv02054;


/**
 * 收益法房屋设施修正
 * @category 收益法房屋设施
 * @author Lee
 * @version 1.0
 */
public interface IPgt02054DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt02054 fwss) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt02054 fwss) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt02054 fwss) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02054> LoadAll(Pgv02054 fwss) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02054 LoadByPrimaryKey(Pgt02054 fwss) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt02054 fwss) throws Exception;
}
