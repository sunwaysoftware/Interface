package com.sunway.dao;

import java.util.ArrayList;
import com.sunway.vo.Pgt12085;
import com.sunway.vo.Pgv12085;


/**
 * 各地区审核类型设置表
 * @category 各地区审核类型
 * @author Lee
 * @version 1.0
 */
public interface IPgt12085DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt12085 shlx) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt12085 shlx) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt12085 shlx) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv12085> LoadAll(Pgv12085 shlx) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt12085 LoadByPrimaryKey(Pgt12085 shlx) throws Exception;
	
}
