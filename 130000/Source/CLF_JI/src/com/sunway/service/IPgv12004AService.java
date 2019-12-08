package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv12004A;

/**
 * 明细信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */
public interface IPgv12004AService {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<Pgv12004A> LoadAll(Pgv12004A v12004A) throws Exception;
}
