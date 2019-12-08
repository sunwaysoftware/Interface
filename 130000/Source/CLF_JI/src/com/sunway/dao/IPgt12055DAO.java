package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt12055;
import com.sunway.vo.Pgv12055;


/**
 * @category 成本法、收益法评税分类
 * @author Lee
 * @version 1.0
 */
public interface IPgt12055DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt12055 pgfl) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt12055 pgfl) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt12055 pgfl) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv12055> LoadAll(Pgv12055 pgfl) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt12055 LoadByPrimaryKey(Pgt12055 pgfl) throws Exception;
	
}
