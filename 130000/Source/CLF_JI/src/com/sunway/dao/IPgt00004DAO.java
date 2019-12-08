package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt00002;
import com.sunway.vo.Pgt00003;
import com.sunway.vo.Pgt00004;
import com.sunway.vo.Pgv00004;

/**
 * 功能权限
 * @category 功能权限维护
 * @author Lee
 * @version 1.0
 */
public interface IPgt00004DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00004 right) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00004 right) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00004 right) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00004> LoadAll(Pgv00004 right) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00004 LoadByPrimaryKey(Pgt00004 right) throws Exception;
	
	/**
	 * 根据用户取得带状态的权限
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00004> LoadRightByUserID(Pgt00002 user) throws Exception;
	
	/**
	 * 根据用户组取得带状态的权限
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00004> LoadRightByRoleID(Pgt00003 role) throws Exception;
}
