package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.PgvBb00009;

/**
 * 报表9
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public interface IPgvBb00009DAO {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<PgvBb00009> LoadAll(PgvBb00009 bb00009) throws Exception;
}
