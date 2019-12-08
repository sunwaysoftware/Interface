package com.sunway.dao;

import java.util.ArrayList;
import com.sunway.vo.Pgt00010;
import com.sunway.vo.Pgv00010;


/**
 * 用户与角色
 * @author Lee
 */
public interface IPgt00010DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00010 userRole) throws Exception;
	
	/**
	 * 进行批量数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetBatchInsCommand(Pgt00010 userRole) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00010 userRole) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00010 userRole) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00010> LoadAll(Pgv00010 userRole) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00010 LoadByPrimaryKey(Pgt00010 userRole) throws Exception;
	
}