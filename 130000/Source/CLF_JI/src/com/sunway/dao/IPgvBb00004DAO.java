package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.PgvBb00004;

/**
 * 报表4
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public interface IPgvBb00004DAO {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<PgvBb00004> LoadAll(PgvBb00004 bb00004) throws Exception;
}
