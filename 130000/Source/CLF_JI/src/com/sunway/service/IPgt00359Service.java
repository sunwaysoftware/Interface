package com.sunway.service;

import java.util.ArrayList;
import com.sunway.vo.Pgt00359;
import com.sunway.vo.Pgv00359;

/**
 * 所在区域下的参数类型配置
 * @category 所在区域下的参数类型配置
 * @author Lee
 * @version 1.0
 */
public interface IPgt00359Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00359 bean) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00359 bean) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00359> LoadAll(Pgv00359 bean) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00359 LoadByPrimaryKey(Pgt00359 bean) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00359 bean) throws Exception;
	
	/**
	 * 根据所在区域读取综合修正父节点字符串
	 * @return 数据列表
	 * @throws Exception
	 */
	public String LoadParentIdsBySzqy(Pgt00359 bean) throws Exception;
}
