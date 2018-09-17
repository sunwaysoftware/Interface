package com.sunway.service;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.Pgt00362;
import com.sunway.vo.Pgv00362;

/**
 * 建筑结构修正系统维护
 * @author HuanWei
 *
 */
public interface IPgt00362Service {

	/**
	 * 进行数据增加操作
	 * @return true成功 ；false 失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00362 t00362)throws Exception;
	
	
	
	/**
	 * 进行数据删除操作
	 * @return true成功 ；false 失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00362 t00362)throws Exception;
	
	
	
	
	/**
	 * 进行数据删除操作
	 * @return true成功 ；false 失败
	 * @throws Exception
	 */
	public boolean GetSelDeleteCommand(Pgt00362 t00362)throws Exception;
	
	
	/**
	 * 进行数据更新操作
	 * @return true成功 ；false 失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00362 t00362)throws Exception;
	
	
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00362> LoadAll(Pgv00362 v00362)throws Exception;
	
	
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00362 LoadByPrimaryKey(Pgt00362 t00362)throws Exception;
	
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00362 LoadByPrimaryAddKey(Pgt00362 t00362)throws Exception;
	
	
	
	/**
	 * 进行数据复制操作
	 * @return true成功 ；false失败
	 * @throws Exception 
	 */
	public boolean ExecuteParamCopy(Pgt00362 t00362)throws Exception;
	
	/**
	 * 信息导出
	 */
	public OutputStream ExportJZJG(Pgv00362 v00362)throws Exception;
	
	
	/**
	 * 信息导入
	 */
	public Pgv00362 ImportExcelData(ArrayList<Pgv00362> v00362List)throws Exception;
	
	
}
