package com.sunway.service;

import com.sunway.vo.Pgv02005;

/**
 * 收益法国土状态
 * @author Light
 *
 */
public interface IPgt02005Service {

	/**
	 * 读取收益法国土详细信息状态数据
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Pgv02005 LoadDetailZT(Pgv02005 bean)throws Exception;
}
