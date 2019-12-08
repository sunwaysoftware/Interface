package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv12001_b;
import com.sunway.vo.PgvCzPssd;

/**
 * 登记信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */
public interface IPgv12001_bDAO {

	/**
	 * 进行数据提取操作
	 */
	public Pgv12001_b LoadAll(Pgv12001_b v12001_b) throws Exception;

	/**
	 * 取得评税时点
	 */
	public ArrayList<PgvCzPssd> LoadPssd() throws Exception;

	/**
	 * 取得详细信息
	 */
	public Pgv12001_b LoadDetail(Pgv12001_b v12001_b) throws Exception;
}
