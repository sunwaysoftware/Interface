package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv00305;

/**
 * 市场法数据操作状态表
 * @category 市场法数据操作状态表
 * @author Lee
 * @version 1.0
 */
public interface IPgt00305yService {

	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00305> LoadAll(Pgv00305 v00305) throws Exception;

	/**
	 * 执行重新添加操作（市场法数据操作状态）
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public Boolean GetExecRTJ(Pgv00305 v00305) throws Exception;

	/**
	 * 执行全部重新添加操作（市场法数据操作状态）
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public Boolean GetExecRTJAll(Pgv00305 v00305) throws Exception;

	/**
	 * 执行备份操作（市场法数据操作状态）
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public Boolean GetBackup(Pgv00305 v00305) throws Exception;
}
