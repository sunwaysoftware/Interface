package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv00302e;

/**
 * 
 * 市场法国土其它修正参数表
 * @author Lee
 *
 */
public interface IPgt00302eService {

	/**
	 * 取得市场法国土其它修正参数表
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00302e> LoadAll(Pgv00302e v00302e) throws Exception;

	/**
	 * 全面评估过国土其它修正参数表
	 * @param v00302e
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00302e> LoadAllQM(Pgv00302e v00302e)throws Exception;
}
