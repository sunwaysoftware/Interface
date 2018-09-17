package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt02061a;
import com.sunway.vo.Pgv02061;
import com.sunway.vo.Pgv02061a;

/**
 * 市场法标准房价格维护交易价格
 * @category 系统维护
 * @author Lee
 * @version 1.0
 *
 */
public interface IPgt02061aDAO {

	/**
	 * 进行数据提取操作
	 */
	public ArrayList<Pgv02061a> LoadAll(Pgv02061a v02061a) throws Exception;

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt02061a t02061a) throws Exception;

	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt02061a t02061a) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 */
	//public Pgt02061a LoadByPrimaryKey(Pgt02061a t02061a) throws Exception;

	public Pgv02061 LoadBySlid(Pgt02061a t02061a) throws Exception;
	
}
