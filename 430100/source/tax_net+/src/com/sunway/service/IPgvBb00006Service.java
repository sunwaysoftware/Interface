package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.PgvBb00006;

/**
 * 报表6
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public interface IPgvBb00006Service {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<PgvBb00006> LoadAll(PgvBb00006 bb00006) throws Exception;
}
