package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.PgvBb00008;

/**
 * 报表8
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public interface IPgvBb00008Service {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<PgvBb00008> LoadAll(PgvBb00008 bb00008) throws Exception;
}
