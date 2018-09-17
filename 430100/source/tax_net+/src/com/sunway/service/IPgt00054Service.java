package com.sunway.service;

import java.util.ArrayList;
import com.sunway.vo.Pgt00054;
import com.sunway.vo.Pgv00054;

/**
 * 评税结果检验标准
 * @author Lee
 * @version 1.0
 */
public interface IPgt00054Service {

	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00054> LoadAll(Pgv00054 v00054) throws Exception;

	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00054> LoadAll000541(Pgv00054 v00054) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @param t00054
	 * @return
	 * @throws Exception
	 */
	public Pgt00054 LoadByPrimaryKey(Pgt00054 t00054) throws Exception;

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00054 t00054) throws Exception;

	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00054 t00054) throws Exception;

	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00054 t00054) throws Exception;

}
