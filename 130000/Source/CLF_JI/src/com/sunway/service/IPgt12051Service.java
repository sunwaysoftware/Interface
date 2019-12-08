package com.sunway.service;

import java.util.ArrayList;
import com.sunway.vo.Pgt12051;
import com.sunway.vo.Pgv12051;


/**
 * @category 免税比例维护
 * @author Lee
 * @version 1.0
 */
public interface IPgt12051Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt12051 msbl) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt12051 msbl) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt12051 msbl) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv12051> LoadAll(Pgv12051 msbl) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt12051 LoadByPrimaryKey(Pgt12051 msbl) throws Exception;
	
}
