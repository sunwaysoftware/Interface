package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.PgvBb00003_b;

/**
 * 报表3
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public interface IPgvBb00003_bService {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<PgvBb00003_b> LoadAll(PgvBb00003_b bb00003_b) throws Exception;
}
