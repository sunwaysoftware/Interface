package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt02059;
import com.sunway.vo.Pgv02059;


/**
 * 收益法租金标准维护
 * @category 收益法租金标准
 * @author Lee
 * @version 1.0
 */
public interface IPgt02059Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt02059 zjbz) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt02059 zjbz) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt02059 zjbz) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02059> LoadAll(Pgv02059 zjbz) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02059 LoadByPrimaryKey(Pgt02059 zjbz) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt02059 zjbz) throws Exception;
}
