/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.BF00004;

/**
 * @author Andy.Gao
 *
 */
public interface IBB00004Service {

	/**
	 * 交易量走势图
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BF00004> LoadAll(BF00004 bean) throws Exception;
	
}
