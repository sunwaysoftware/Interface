package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt02056;
import com.sunway.vo.Pgv02056;


/**
 * 收益法星级标准修正
 * @category 星级标准修正
 * @author Lee
 * @version 1.0
 */
public interface IPgt02056Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt02056 xjbz) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt02056 xjbz) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt02056 xjbz) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02056> LoadAll(Pgv02056 xjbz) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02056 LoadByPrimaryKey(Pgt02056 xjbz) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt02056 xjbz) throws Exception;
}
