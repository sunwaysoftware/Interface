package com.sunway.dao;

import com.sunway.vo.Pgv12002_b;

/**
 * 地产信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */
public interface IPgv12002_bDAO {

	/**
	 * 进行数据提取操作
	 */
	public Pgv12002_b LoadAll(Pgv12002_b v12002_b) throws Exception;

	/**
	 * 取得详细信息
	 */
	public Pgv12002_b LoadDetail(Pgv12002_b v12002_b) throws Exception;
}
