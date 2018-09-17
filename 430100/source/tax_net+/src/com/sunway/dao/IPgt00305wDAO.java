package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv00302;

/**
 * 市场法数据操作状态(没有添加到操作列表的数据)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */
public interface IPgt00305wDAO {

	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00302> LoadAll(Pgv00302 v00302) throws Exception;

	/**
	 * 执行添加操作（市场法数据操作状态）
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public Boolean GetExecTJ(Pgv00302 v00302) throws Exception;

	/**
	 * 执行全部添加操作（市场法数据操作状态）
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public Boolean GetExecTJAll(Pgv00302 v00302) throws Exception;
}
