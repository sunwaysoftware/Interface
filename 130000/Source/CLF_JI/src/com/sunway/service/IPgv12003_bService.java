package com.sunway.service;

import com.sunway.vo.Pgv12003_b;

/**
 * 房产信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */
public interface IPgv12003_bService {

	/**
	 * 进行数据提取操作
	 */
	public Pgv12003_b LoadAll(Pgv12003_b v12003_b) throws Exception;

	/**
	 * 取得详细信息
	 */
	public Pgv12003_b LoadDetail(Pgv12003_b v12003_b) throws Exception;
}
