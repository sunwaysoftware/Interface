/**
 * 
 */
package com.sunway.service;

import com.sunway.vo.Pgt10032;

/**
 * 
 * 成本法个案评税结果表
 * @author Andy.Gao
 *
 */
public interface IPgt10032Service {
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt10032 LoadByPrimaryKey(Pgt10032 bean) throws Exception;
	
}
