package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt12054;
import com.sunway.vo.Pgv12054;

/**
 * 成本法、收益法土地等级
 * @author Lee
 * @version 1.0
 */
public interface IPgt12054DAO {

	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv12054> LoadAll(Pgv12054 v12054) throws Exception;

	/**
	 * 根据PK进行数据提取操作
	 * @param t12054
	 * @return
	 * @throws Exception
	 */
	public Pgt12054 LoadByPrimaryKey(Pgt12054 t12054) throws Exception;

	/**
	 * 进行数据增加操作
	 * @return 0失败；1成功
	 * @throws Exception
	 */
	public Integer GetInsertCommand(Pgt12054 t12054) throws Exception;

	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt12054 t12054) throws Exception;

	/**
	 * 进行数据更新操作
	 * @return 0失败；1成功
	 * @throws Exception
	 */
	public Integer GetUpdateCommand(Pgt12054 t12054) throws Exception;

	/**
	 * 取得数据列表
	 * @param t12054
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt12054> LoadNavigator(Pgt12054 t12054) throws Exception;

	/**
	 * 根据导航取得数据列表
	 * @param t12054
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt12054> LoadTreeList(Pgt12054 t12054) throws Exception;

	/**
	 * 取得土地等级简称
	 * @param tddjid 土地等级编码
	 * @return
	 * @throws Exception
	 */
	public String LoadNavStream(String tddjid) throws Exception;
}
