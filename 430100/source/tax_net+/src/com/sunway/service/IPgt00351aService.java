package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt00351a;
import com.sunway.vo.Pgv00351a;

/**
 * 市场法标准房价格维护交易价格
 * @category 系统维护
 * @author Lee
 * @version 1.0
 *
 */
public interface IPgt00351aService {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<Pgv00351a> LoadAll(Pgv00351a v00351a) throws Exception;

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00351a t00351a) throws Exception;

	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00351a t00351a) throws Exception;
	
	
	/**
	 * 根据PK进行数据提取操作
	 */
	public ArrayList<Pgv00351a> LoadByPrimaryKey(Pgt00351a t00351a) throws Exception;
}
