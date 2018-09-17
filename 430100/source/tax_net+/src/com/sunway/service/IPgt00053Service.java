package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt00053;
import com.sunway.vo.Pgv00053;

/**
 * 其它修正参数
 * @author Lee
 * @version 1.0
 *
 */
public interface IPgt00053Service {

	/**
	 * 取得修正类型列表
	 * @return 修正类型List
	 * @throws Exception
	 */
	public ArrayList<Pgv00053> LoadAllXzlx() throws Exception;

	/**
	 * 进行数据提取操作
	 * @param v00053 检索条件
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00053> LoadAll(Pgv00053 v00053) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @param t00053
	 * @return
	 * @throws Exception
	 */
	public Pgt00053 LoadByPrimaryKey(Pgt00053 t00053) throws Exception;

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00053 t00053) throws Exception;

	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00053 t00053) throws Exception;

	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00053 t00053) throws Exception;

	/**
	 * 取得数据列表
	 * @param t00053
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt00053> LoadNavigator(Pgt00053 t00053) throws Exception;

	/**
	 * 根据导航取得数据列表
	 * @param t00053
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt00053> LoadTreeList(Pgt00053 t00053) throws Exception;
}
