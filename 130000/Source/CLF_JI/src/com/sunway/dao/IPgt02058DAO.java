package com.sunway.dao;

import java.util.ArrayList;
import com.sunway.vo.Pgt02058;
import com.sunway.vo.Pgv02058;


/**
 * 收益法综合修正维护
 * @category 收益法综合修正
 * @author Lee
 * @version 1.0
 */
public interface IPgt02058DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt02058 zhxz) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt02058 zhxz) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt02058 zhxz) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02058> LoadAll(Pgv02058 zhxz) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02058 LoadByPrimaryKey(Pgt02058 zhxz) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt02058 zhxz) throws Exception;
}
