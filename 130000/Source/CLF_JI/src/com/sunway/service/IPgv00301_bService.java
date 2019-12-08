package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv00301_b;
import com.sunway.vo.PgvCzPssd;

/**
 * 住宅登记信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */
public interface IPgv00301_bService {

	/**
	 * 进行数据提取操作
	 */
	public Pgv00301_b LoadAll(Pgv00301_b v00301_b) throws Exception;

	/**
	 * 取得评税时点
	 */
	public ArrayList<PgvCzPssd> LoadPssd() throws Exception;

	/**
	 * 取得详细信息
	 */
	public Pgv00301_b LoadDetail(Pgv00301_b v00301_b) throws Exception;
}
