package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt12052;
import com.sunway.vo.Pgv12052;


/**
 * @category 成本法、收益法经济耐用年限指标
 * @author Lee
 * @version 1.0
 */
public interface IPgt12052Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt12052 jjnynx) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt12052 jjnynx) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt12052 jjnynx) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv12052> LoadAll(Pgv12052 jjnynx) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt12052 LoadByPrimaryKey(Pgt12052 jjnynx) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt12052 jjnynx) throws Exception;
}
