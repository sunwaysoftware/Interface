package com.sunway.dao;

import com.sunway.vo.PgvDb000014;

/**
 * 现行税率行业对比分析
 * @category 数据对比分析
 * @author Lee
 * @version 1.0
 */
public interface IPgvDb000014DAO {

	/**
	 * 进行数据提取操作
	 */
	public PgvDb000014 LoadAll(PgvDb000014 db000014) throws Exception;

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(PgvDb000014 db000014) throws Exception;
}
