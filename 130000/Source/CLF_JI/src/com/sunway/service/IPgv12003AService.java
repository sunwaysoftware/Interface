package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv12003A;

/**
 * 房产信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */
public interface IPgv12003AService {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<Pgv12003A> LoadAll(Pgv12003A v12003A) throws Exception;
}
