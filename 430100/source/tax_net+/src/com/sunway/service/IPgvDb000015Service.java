package com.sunway.service;

import com.sunway.vo.PgvDb000015;

/**
 * 现行税率经济类型对比分析
 * @category 数据对比分析
 * @author Lee
 * @version 1.0
 */
public interface IPgvDb000015Service {

	/**
	 * 进行数据提取操作
	 */
	public PgvDb000015 LoadAll(PgvDb000015 db000015) throws Exception;

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(PgvDb000015 db000015) throws Exception;
}
