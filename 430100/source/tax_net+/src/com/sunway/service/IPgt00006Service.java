package com.sunway.service;

import java.util.ArrayList;
import com.sunway.vo.Pgt00006;
import com.sunway.vo.Pgv00006;


/**
 * 用户与功能权限关系
 * @author Lee
 */
public interface IPgt00006Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00006 userRight) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00006 userRight) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00006 userRight) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00006> LoadAll(Pgv00006 userRight) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00006 LoadByPrimaryKey(Pgt00006 userRight) throws Exception;
	
}
