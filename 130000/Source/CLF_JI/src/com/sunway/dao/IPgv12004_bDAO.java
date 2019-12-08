package com.sunway.dao;

import com.sunway.vo.Pgv12004_b;

/**
 * 明细信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */
public interface IPgv12004_bDAO {

	/**
	 * 进行数据提取操作
	 */
	public Pgv12004_b LoadAll(Pgv12004_b v12004_b) throws Exception;

	/**
	 * 取得详细信息
	 */
	public Pgv12004_b LoadDetail(Pgv12004_b v12004_b) throws Exception;
}
