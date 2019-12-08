/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.BF00004;

/**
 * 
 * 交易量走势图
 * @author Andy.Gao
 *
 */
public interface IBB00004DAO {

	/**
	 * 交易量走势图
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BF00004> LoadAll(BF00004 bean) throws Exception;
	
}
