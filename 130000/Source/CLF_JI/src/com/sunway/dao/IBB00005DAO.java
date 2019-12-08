/**
 * 
 */
package com.sunway.dao;

import com.sunway.vo.BF00005;

/**
 * 
 * 评估个数对比图
 * @author Lee
 *
 */
public interface IBB00005DAO {

	/**
	 * 评估个数对比图
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public BF00005 LoadAll(BF00005 bean) throws Exception;
	
}
