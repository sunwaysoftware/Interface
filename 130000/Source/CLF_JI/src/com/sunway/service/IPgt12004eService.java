/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv12004e;

/**
 * 
 * 成本法明細其它评税参数表
 * @author Andy.Gao
 *
 */
public interface IPgt12004eService {
	/**
	 * 取得明細其它评税参数列表
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv12004e> LoadAll(Pgv12004e v12004e) throws Exception;
}
