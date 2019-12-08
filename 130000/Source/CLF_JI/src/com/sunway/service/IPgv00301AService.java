package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv00301A;

/**
 * 住宅登记信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */
public interface IPgv00301AService {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<Pgv00301A> LoadAll(Pgv00301A v00301A) throws Exception;
}
