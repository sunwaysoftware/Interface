package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.PgvBb00010_b;

/**
 * 报表10
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public interface IPgvBb00010_bService {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<PgvBb00010_b> LoadAll(PgvBb00010_b bb00010_b) throws Exception;
}
