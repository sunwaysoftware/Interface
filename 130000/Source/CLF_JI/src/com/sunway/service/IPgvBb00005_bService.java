package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.PgvBb00005_b;

/**
 * 报表5
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public interface IPgvBb00005_bService {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<PgvBb00005_b> LoadAll(PgvBb00005_b bb00005_b) throws Exception;
}
