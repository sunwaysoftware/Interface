package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.PgvBb00002_b;

/**
 * 报表2
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public interface IPgvBb00002_bDAO {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<PgvBb00002_b> LoadAll(PgvBb00002_b bb00002_b) throws Exception;
}