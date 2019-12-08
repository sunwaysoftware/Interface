package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt10053;
import com.sunway.vo.Pgv10053;


/**
 * 成本法间接费用比率
 * @category 成本法间接费用比率
 * @author Lee
 * @version 1.0
 */
public interface IPgt10053Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt10053 jjfybl) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt10053 jjfybl) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt10053 jjfybl) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv10053> LoadAll(Pgv10053 jjfybl) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt10053 LoadByPrimaryKey(Pgt10053 jjfybl) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt10053 jjfybl) throws Exception;
}
