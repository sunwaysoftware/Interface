package com.sunway.dao;

import java.util.ArrayList;
import com.sunway.vo.Pgt12082;
import com.sunway.vo.Pgv12082;


/**
 * 审核容积率
 * @category 审核容积率维护
 * @author Lee
 * @version 1.0
 */
public interface IPgt12082DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt12082 rjl) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt12082 rjl) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt12082 rjl) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv12082> LoadAll(Pgv12082 rjl) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt12082 LoadByPrimaryKey(Pgt12082 rjl) throws Exception;
	
}
