package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv00302A;

/**
 * 住宅房产信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */
public interface IPgv00302ADAO {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<Pgv00302A> LoadAll(Pgv00302A v00302A) throws Exception;
}
