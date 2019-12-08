/**
 * 
 */
package com.sunway.dao;

import com.sunway.vo.Pgt02032;

/**
 * 
 * 收益法个案评税结果表
 * @author Andy.Gao
 *
 */
public interface IPgt02032DAO {
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02032 LoadByPrimaryKey(Pgt02032 bean) throws Exception;
}
