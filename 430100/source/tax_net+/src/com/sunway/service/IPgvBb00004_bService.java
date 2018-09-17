package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.PgvBb00004_b;

/**
 * 报表4
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public interface IPgvBb00004_bService {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<PgvBb00004_b> LoadAll(PgvBb00004_b bb00004_b) throws Exception;
}
