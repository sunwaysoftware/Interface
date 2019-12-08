package com.sunway.service;

import com.sunway.vo.PgvDb000011;

/**
 * 行业分析
 * @category 数据对比分析
 * @author Lee
 * @version 1.0
 */
public interface IPgvDb000011Service {

	/**
	 * 进行数据提取操作
	 */
	public PgvDb000011 LoadAll(PgvDb000011 db000011) throws Exception;
}
