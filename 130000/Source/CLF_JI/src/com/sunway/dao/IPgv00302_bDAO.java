package com.sunway.dao;

import com.sunway.vo.Pgv00302_b;

/**
 * 住宅房产信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */
public interface IPgv00302_bDAO {

	/**
	 * 进行数据提取操作
	 */
	public Pgv00302_b LoadAll(Pgv00302_b v00302_b) throws Exception;

	/**
	 * 取得详细信息
	 */
	public Pgv00302_b LoadDetail(Pgv00302_b v00302_b) throws Exception;
}
