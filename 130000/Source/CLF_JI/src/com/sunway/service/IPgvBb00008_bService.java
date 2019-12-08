package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.PgvBb00008_b;

/**
 * 报表8
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public interface IPgvBb00008_bService {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<PgvBb00008_b> LoadAll(PgvBb00008_b bb00008_b) throws Exception;
}
