package com.sunway.dao;

import java.util.ArrayList;
import com.sunway.vo.Pgt12081;
import com.sunway.vo.Pgv12081;


/**
 * 审核平方米单价
 * @category 审核平方米维护
 * @author Lee
 * @version 1.0
 */
public interface IPgt12081DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt12081 pfmdj) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt12081 pfmdj) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt12081 pfmdj) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv12081> LoadAll(Pgv12081 pfmdj) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt12081 LoadByPrimaryKey(Pgt12081 pfmdj) throws Exception;
	
}
