package com.sunway.service;

import java.util.ArrayList;
import com.sunway.vo.Pgt00002;
import com.sunway.vo.Pgt00003;
import com.sunway.vo.Pgt00004;
import com.sunway.vo.Pgv00003;


/**
 * @category 用户组维护
 * @author Lee
 * @version 1.0
 */
public interface IPgt00003Service {

	/**
	 * 进行数据增加操作
	 * @return 0成功；1数据已存在
	 * @throws Exception
	 */
	public Integer GetInsertCommand(Pgt00003 role) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00003 role) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return 0成功；1数据已存在
	 * @throws Exception
	 */
	public Integer GetUpdateCommand(Pgt00003 role) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00003> LoadAll(Pgv00003 role) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00003 LoadByPrimaryKey(Pgt00003 role) throws Exception;
	
	/**
	 * 根据用户取得带状态的用户组
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00003> LoadRoleByUserID(Pgt00002 user) throws Exception;
	
	/**
	 * 根据权限取得带状态的用户组
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00003> LoadRoleByRightID(Pgt00004 right) throws Exception;
	
}
