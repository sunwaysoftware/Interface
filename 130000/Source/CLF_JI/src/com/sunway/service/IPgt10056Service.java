package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt10056;
import com.sunway.vo.Pgv10056;


/**
 * @category 成本法评税时点修正
 * @author Lee
 * @version 1.0
 */
public interface IPgt10056Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt10056 pssdxz) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt10056 pssdxz) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt10056 pssdxz) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv10056> LoadAll(Pgv10056 pssdxz) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt10056 LoadByPrimaryKey(Pgt10056 pssdxz) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt10056 pssdxz) throws Exception;
}
