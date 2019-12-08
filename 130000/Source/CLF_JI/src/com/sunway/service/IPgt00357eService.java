package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv00357e;

/**
 * 
 * 市场法土地其它评税参数表
 * @category 系统维护
 * @author Lee
 * @version 1.0
 *
 */
public interface IPgt00357eService {

	/**
	 * 市场法土地其它评税参数表
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00357e> LoadAll(Pgv00357e v00357e) throws Exception;
}
