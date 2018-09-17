package com.sunway.service;

import java.util.ArrayList;
import com.sunway.vo.Pgt00055;

/**
 * 证件类型有效位数验证
 * @author Lee
 * @version 1.0
 */
public interface IPgt00055Service {

	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgt00055> LoadAll() throws Exception;

	/**
	 * 根据PK进行数据提取操作
	 * @param t00055
	 * @return
	 * @throws Exception
	 */
	public Pgt00055 LoadByPrimaryKey(Pgt00055 t00055) throws Exception;

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00055 t00055) throws Exception;

	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00055 t00055) throws Exception;

	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00055 t00055) throws Exception;
	
	/**
	 * 根据证件类型判断位数
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean validateZjlx(Pgt00055 t00055) throws Exception;

}
