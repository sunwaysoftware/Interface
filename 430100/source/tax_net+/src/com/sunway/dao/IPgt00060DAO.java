package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt00060;
import com.sunway.vo.Pgv00062;

/**
 * 通用选择控件
 * @author Light
 *
 */
public interface IPgt00060DAO {

	/**
	 * 获取数据
	 * @param t00001
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt00060> LoadAll(Pgt00060 t00060)throws Exception;
	
	/**
	 * 获取导入数据信息
	 * @param t00060
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt00060> LoadAllImp(Pgt00060 t00060)throws Exception;
	
	/**
	 * 获取导入模板数据信息
	 * @param t00060
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt00060> LoadAllImpModel(Pgt00060 t00060)throws Exception;
	
	/**
	 * 插入导入日志
	 * @param t00062
	 * @return
	 * @throws Exception
	 */
	public Boolean GetInsertImpDaily(Pgv00062 v00062)throws Exception;
	
	/**
	 * 查询导入日志信息
	 * @param t00062
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00062> LoadAllDaily(Pgv00062 v00062)throws Exception;
	
	/**
	 * 删除导入日志信息
	 * @param t00062
	 * @return
	 * @throws Exception
	 */
	public Boolean GetDeleteByPrimaryDaily(Pgv00062 v00062)throws Exception;
	
	/**
	 * 根据主键获取导入日志信息
	 * @param t00062
	 * @return
	 * @throws Exception
	 */
	public Pgv00062 LoadByPrimaryDaily(Pgv00062 v00062)throws Exception;
}
