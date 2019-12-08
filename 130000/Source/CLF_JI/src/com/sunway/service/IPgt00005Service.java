package com.sunway.service;

import java.util.ArrayList;
import com.sunway.vo.Pgt00005;
import com.sunway.vo.Pgv00005;


/**
 * 用户组与功能权限关系
 * @author Lee
 */
public interface IPgt00005Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00005 roleRight) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00005 roleRight) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00005 roleRight) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00005> LoadAll(Pgv00005 roleRight) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00005 LoadByPrimaryKey(Pgt00005 roleRight) throws Exception;

	/**
	 * 得到某用户组下有哪些权限
	 * @param v00005
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00005> LoadT000052(Pgv00005 v00005) throws Exception;
}
