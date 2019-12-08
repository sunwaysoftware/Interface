package com.sunway.dao;

import com.sunway.vo.PgvDb000012;

/**
 * 经济类型对比分析
 * @category 数据对比分析
 * @author Lee
 * @version 1.0
 */
public interface IPgvDb000012DAO {

	/**
	 * 进行数据提取操作
	 */
	public PgvDb000012 LoadAll(PgvDb000012 db000012) throws Exception;
}
