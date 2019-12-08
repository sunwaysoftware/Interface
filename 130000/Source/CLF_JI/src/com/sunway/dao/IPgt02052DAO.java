package com.sunway.dao;

import java.util.ArrayList;
import com.sunway.vo.Pgt02052;
import com.sunway.vo.Pgv02052;


/**
 * 收益法楼层修正
 * @category 收益法楼层修正
 * @author Lee
 * @version 1.0
 */
public interface IPgt02052DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt02052 lc) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt02052 lc) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt02052 lc) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02052> LoadAll(Pgv02052 lc) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02052 LoadByPrimaryKey(Pgt02052 lc) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt02052 lc) throws Exception;
}
