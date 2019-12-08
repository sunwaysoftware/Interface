package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.PgvBb00001;

/**
 * 报表1
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public interface IPgvBb00001Service {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<PgvBb00001> LoadAll(PgvBb00001 bb00001) throws Exception;
}
