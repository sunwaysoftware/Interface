package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv00302e;

/**
 * 
 * 市场法国土其它修正参数表
 * @author Lee
 *
 */
public interface IPgt00302eDAO {

	/**
	 * 取得市场法国土其它修正参数表
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00302e> LoadAll(Pgv00302e v00302e) throws Exception;

	/**
	 * 取得市场法全面评估国土其它修正参数表
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00302e> LoadAllQM(Pgv00302e v00302e) throws Exception;
}
