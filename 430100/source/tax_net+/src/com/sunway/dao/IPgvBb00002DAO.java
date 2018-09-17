package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.PgvBb00002;

/**
 * 报表2
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public interface IPgvBb00002DAO {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<PgvBb00002> LoadAll(PgvBb00002 bb00002) throws Exception;
}
