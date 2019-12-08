package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.PgvBb00003;

/**
 * 报表3
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public interface IPgvBb00003DAO {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<PgvBb00003> LoadAll(PgvBb00003 bb00003) throws Exception;
}
