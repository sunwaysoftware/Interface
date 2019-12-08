package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv12001A;

/**
 * 登记信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */
public interface IPgv12001ADAO {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<Pgv12001A> LoadAll(Pgv12001A v12001A) throws Exception;
}
