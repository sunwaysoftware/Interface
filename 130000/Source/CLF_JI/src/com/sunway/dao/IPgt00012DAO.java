package com.sunway.dao;

import java.util.ArrayList;
import com.sunway.vo.Pgt00012;
import com.sunway.vo.Pgv00012;


/**
 * @category 系统常规配置
 * @author Lee
 * @version 1.0
 */
public interface IPgt00012DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00012 sysConfig) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00012 sysConfig) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00012 sysConfig) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00012> LoadAll(Pgv00012 sysConfig) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00012 LoadByPrimaryKey(Pgt00012 sysConfig) throws Exception;
	
}
