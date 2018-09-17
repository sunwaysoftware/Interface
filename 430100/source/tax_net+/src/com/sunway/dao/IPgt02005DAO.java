package com.sunway.dao;

import com.sunway.vo.Pgv02005;

/**
 * 收益法国土状态
 * @author Light
 *
 */
public interface IPgt02005DAO {

	/**
	 * 读取国土状态
	 * @return
	 * @throws Exception
	 */
	public Pgv02005 LoadDetailZT(Pgv02005 bean)throws Exception;
}
