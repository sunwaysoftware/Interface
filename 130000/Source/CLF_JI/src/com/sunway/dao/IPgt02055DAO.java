package com.sunway.dao;

import java.util.ArrayList;
import com.sunway.vo.Pgt02055;
import com.sunway.vo.Pgv02055;


/**
 * 收益法收益年限维护
 * @category 收益年限维护
 * @author Lee
 * @version 1.0
 */
public interface IPgt02055DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt02055 synx) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt02055 synx) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt02055 synx) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02055> LoadAll(Pgv02055 synx) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02055 LoadByPrimaryKey(Pgt02055 synx) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt02055 synx) throws Exception;
}
