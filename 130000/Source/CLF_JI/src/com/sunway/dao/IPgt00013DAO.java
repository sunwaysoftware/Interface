package com.sunway.dao;

import java.util.ArrayList;
import com.sunway.vo.Pgt00013;
import com.sunway.vo.Pgv00013;


/**
 * @category 用户操作概要记录
 * @author Lee
 * @version 1.0
 */
public interface IPgt00013DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00013 operaRecord) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00013 operaRecord) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00013 operaRecord) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00013> LoadAll(Pgv00013 operaRecord) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00013 LoadByPrimaryKey(Pgt00013 operaRecord) throws Exception;
	
}
