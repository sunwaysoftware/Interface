/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv12003c;

/**
 * @author Andy.Gao
 *
 */
public interface IPgt12003cService {

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgv12003c> LoadAll(Pgv12003c v12003c) throws Exception;
	
}
