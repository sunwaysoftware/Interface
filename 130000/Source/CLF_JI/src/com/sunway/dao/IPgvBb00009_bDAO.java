package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.PgvBb00009_b;

/**
 * 报表9
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public interface IPgvBb00009_bDAO {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<PgvBb00009_b> LoadAll(PgvBb00009_b bb00009_b) throws Exception;
}
