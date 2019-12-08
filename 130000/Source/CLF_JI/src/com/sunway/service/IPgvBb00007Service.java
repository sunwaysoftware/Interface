package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.PgvBb00007;

/**
 * 报表7
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public interface IPgvBb00007Service {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<PgvBb00007> LoadAll(PgvBb00007 bb00007) throws Exception;
}
