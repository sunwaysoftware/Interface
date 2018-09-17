package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.PgvBb00010;

/**
 * 报表10
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public interface IPgvBb00010DAO {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<PgvBb00010> LoadAll(PgvBb00010 bb00010) throws Exception;
}
