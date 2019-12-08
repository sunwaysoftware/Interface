package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv12002A;

/**
 * 地产信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */
public interface IPgv12002AService {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<Pgv12002A> LoadAll(Pgv12002A v12002A) throws Exception;
}
