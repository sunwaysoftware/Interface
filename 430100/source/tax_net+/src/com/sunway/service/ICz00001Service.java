/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.CZ00001;

/**
 * 
 * 操作类型
 * @author Andy.Gao
 *
 */
public interface ICz00001Service {
	/**
	 * 返回操作类型
	 * @return
	 * @throws Exception
	 */
	public ArrayList<CZ00001> LoadAll() throws Exception;
}
