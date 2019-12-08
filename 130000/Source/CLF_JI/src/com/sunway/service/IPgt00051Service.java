package com.sunway.service;

import java.util.ArrayList;
import com.sunway.vo.Pgt00051;
import com.sunway.vo.Pgv00051;


/**
 * 税率指数维护
 * @category 税率指数
 * @author Lee
 * @version 1.0
 */
public interface IPgt00051Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00051 slzs) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00051 slzs) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00051 slzs) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00051> LoadAll(Pgv00051 slzs) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00051 LoadByPrimaryKey(Pgt00051 slzs) throws Exception;
	
}
