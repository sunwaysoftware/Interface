package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv02002c;

/**
 * 
 * 市场法国土其它修正参数表
 * @author Lee
 *
 */
public interface IPgt02002cService {

	/**
	 * 取得市场法国土其它修正参数表
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv02002c> LoadAll(Pgv02002c v02002c) throws Exception;

	/**
	 * 全面评估过国土其它修正参数表
	 * @param v02002c
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv02002c> LoadAllQM(Pgv02002c v02002c)throws Exception;
}
