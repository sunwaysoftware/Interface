package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt10055;
import com.sunway.vo.Pgv10055;


/**
 * @category 成本法土地基准地价
 * @author Lee
 * @version 1.0	
 */
public interface IPgt10055Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt10055 tdjzdj) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt10055 tdjzdj) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt10055 tdjzdj) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv10055> LoadAll(Pgv10055 tdjzdj) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt10055 LoadByPrimaryKey(Pgt10055 tdjzdj) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt10055 tdjzdj) throws Exception;
}
