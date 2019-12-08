/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.BF00003;

/**
 * 
 * 价格走势分析图
 * @author Lee
 *
 */
public interface IBB00003DAO {

	/**
	 * 价格走势分析图
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BF00003> LoadAll(BF00003 bean) throws Exception;
	
}