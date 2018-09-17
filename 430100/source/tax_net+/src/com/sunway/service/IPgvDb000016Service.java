package com.sunway.service;

import com.sunway.vo.PgvDb000016;

/**
 * 现行税率免税设置对比分析
 * @category 数据对比分析
 * @author Lee
 * @version 1.0
 */
public interface IPgvDb000016Service {

	/**
	 * 进行数据提取操作
	 */
	public PgvDb000016 LoadAll(PgvDb000016 db000016) throws Exception;

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(PgvDb000016 db000016) throws Exception;
}
