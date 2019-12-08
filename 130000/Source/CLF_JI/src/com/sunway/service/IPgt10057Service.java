package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt10057;
import com.sunway.vo.Pgv10057;


/**
 * 成新率最小值设置(Pgt10057)
 * @category 成新率最小值设置
 * @author Lee
 * @version 1.0
 */
public interface IPgt10057Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt10057 cxl) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt10057 cxl) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt10057 cxl) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv10057> LoadAll(Pgv10057 cxl) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt10057 LoadByPrimaryKey(Pgt10057 cxl) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt10057 cxl) throws Exception;
}
