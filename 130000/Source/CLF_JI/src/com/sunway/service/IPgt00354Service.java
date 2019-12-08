package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt00354;
import com.sunway.vo.Pgv00354;


/**
 * @category 市场法房屋朝向修正系数
 * @author Lee
 * @version 1.0
 */
public interface IPgt00354Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00354 fwcx) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00354 fwcx) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00354 fwcx) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00354> LoadAll(Pgv00354 fwcx) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00354 LoadByPrimaryKey(Pgt00354 fwcx) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt00354 fwcx) throws Exception;
}
