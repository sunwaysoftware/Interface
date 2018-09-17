package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.PgvBb00001_b;

/**
 * 报表1
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public interface IPgvBb00001_bDAO {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<PgvBb00001_b> LoadAll(PgvBb00001_b bb00001_b) throws Exception;
}