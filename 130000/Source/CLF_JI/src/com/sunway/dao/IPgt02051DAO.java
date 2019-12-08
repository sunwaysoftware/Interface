package com.sunway.dao;

import java.util.ArrayList;
import com.sunway.vo.Pgt02051;
import com.sunway.vo.Pgv02051;


/**
 * 收益法房屋朝向修正
 * @category 收益法房屋朝向修正
 * @author Lee
 * @version 1.0
 */
public interface IPgt02051DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt02051 fwcx) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt02051 fwcx) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt02051 fwcx) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02051> LoadAll(Pgv02051 fwcx) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02051 LoadByPrimaryKey(Pgt02051 fwcx) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt02051 fwcx) throws Exception;
}
