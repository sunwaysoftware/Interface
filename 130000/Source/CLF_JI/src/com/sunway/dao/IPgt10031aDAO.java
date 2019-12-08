/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt10031a;
import com.sunway.vo.Pgv10031a1;

/**
 * 
 * 成本法评税其它修正参数表
 * @author Andy.Gao
 *
 */
public interface IPgt10031aDAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt10031a bean) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt10031a bean) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt10031a bean) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgt10031a> LoadAll(Pgt10031a bean) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt10031a LoadByPrimaryKey(Pgt10031a bean) throws Exception;
	
	/**
	 * 成本法评税房產其它修正参数表
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv10031a1> LoadQtxzFC(Pgv10031a1 bean) throws Exception;
	
	/**
	 * 成本法评税地產其它修正参数表
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv10031a1> LoadQtxzDC(Pgv10031a1 bean) throws Exception;
}
