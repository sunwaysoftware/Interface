package com.sunway.dao;

import java.util.ArrayList;
import com.sunway.vo.Pgt12083;
import com.sunway.vo.Pgv12083;


/**
 * 审核土地面积
 * @category 审核土地面积维护
 * @author Lee
 * @version 1.0
 */
public interface IPgt12083DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt12083 tdmj) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt12083 tdmj) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt12083 tdmj) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv12083> LoadAll(Pgv12083 tdmj) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt12083 LoadByPrimaryKey(Pgt12083 tdmj) throws Exception;
	
}
