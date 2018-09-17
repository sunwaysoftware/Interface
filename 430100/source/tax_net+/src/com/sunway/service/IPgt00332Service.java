/**
 * 
 */
package com.sunway.service;

import com.sunway.vo.Pgt00332;

/**
 * 
 * 市场法个案评税结果
 * @author Andy.Gao
 *
 */
public interface IPgt00332Service {
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00332 LoadByPrimaryKey(Pgt00332 bean) throws Exception;
}
