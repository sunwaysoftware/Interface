package com.sunway.dao;

import com.sunway.vo.PgvDb000013;

/**
 * 免税设计对比分析
 * @category 数据对比分析
 * @author Lee
 * @version 1.0
 */
public interface IPgvDb000013DAO {

	/**
	 * 进行数据提取操作
	 */
	public PgvDb000013 LoadAll(PgvDb000013 db000013) throws Exception;
}
