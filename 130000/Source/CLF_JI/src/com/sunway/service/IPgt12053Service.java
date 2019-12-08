package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt12053;
import com.sunway.vo.Pgv12053;

/**
 * 成本法、收益法地段基准
 * @author Lee
 * @version 1.0
 */
public interface IPgt12053Service {

	/**
	 * 进行数据提取操作
	 * @param v12053 检索条件
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv12053> LoadAll(Pgv12053 v12053) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @param t12053
	 * @return
	 * @throws Exception
	 */
	public Pgt12053 LoadByPrimaryKey(Pgt12053 t12053) throws Exception;

	/**
	 * 进行数据增加操作
	 * @return 0失败；1成功
	 * @throws Exception
	 */
	public Integer GetInsertCommand(Pgt12053 t12053) throws Exception;

	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt12053 t12053) throws Exception;

	/**
	 * 进行数据更新操作
	 * @return 0失败；1成功
	 * @throws Exception
	 */
	public Integer GetUpdateCommand(Pgt12053 t12053) throws Exception;

	/**
	 * 取得数据列表
	 * @param t12053
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt12053> LoadNavigator(Pgt12053 t12053) throws Exception;

	/**
	 * 根据导航取得数据列表
	 * @param t12053
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt12053> LoadTreeList(Pgt12053 t12053) throws Exception;

	/**
	 * 取得地段名称
	 * @param ddid 地段代码
	 * @return
	 * @throws Exception
	 */
	public String LoadNavStream(String ddid) throws Exception;
}
