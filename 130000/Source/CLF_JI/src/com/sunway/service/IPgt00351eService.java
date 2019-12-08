package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv00351e;

/**
 * 
 * 市场法标准实例库其它修正参数表
 * @author Lee
 *
 */
public interface IPgt00351eService {

	/**
	 * 取得市场法标准实例库其它修正参数表
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00351e> LoadAll(Pgv00351e v00351e) throws Exception;
}
