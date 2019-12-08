package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv12005;


/**
 * 成本，收益法数据操作状态
 * @category 成本，收益法数据操作状态
 * @author Lee
 * @version 1.0
 */
public interface IPgt12005yDAO {

	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv12005> LoadAll(Pgv12005 v12005) throws Exception;

	/**
	 * 执行重新添加操作（成本、收益法数据操作状态）
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public Boolean GetExecRTJ(Pgv12005 v12005) throws Exception;

	/**
	 * 执行全部重新添加操作（成本、收益法数据操作状态）
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public Boolean GetExecRTJAll(Pgv12005 v12005) throws Exception;

	/**
	 * 执行备份操作（成本、收益法数据操作状态）
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public Boolean GetBackup(Pgv12005 v12005) throws Exception;
}
