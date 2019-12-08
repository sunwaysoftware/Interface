package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.PgvBb00007_b;

/**
 * 报表7
 * @category 数据备份
 * @author Lee
 * @version 1.0
 */
public interface IPgvBb00007_bDAO {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<PgvBb00007_b> LoadAll(PgvBb00007_b bb00007_b) throws Exception;
}
