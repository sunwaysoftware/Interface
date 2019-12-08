package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.PgvBb00005;

/**
 * 报表5
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public interface IPgvBb00005Service {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<PgvBb00005> LoadAll(PgvBb00005 bb00005) throws Exception;
}
