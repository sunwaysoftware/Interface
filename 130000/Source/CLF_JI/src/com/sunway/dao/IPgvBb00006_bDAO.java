package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.PgvBb00006_b;

/**
 * 报表6
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public interface IPgvBb00006_bDAO {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<PgvBb00006_b> LoadAll(PgvBb00006_b bb00006_b) throws Exception;
}
