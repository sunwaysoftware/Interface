package com.sunway.service;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.Pgt00361;
import com.sunway.vo.Pgv00361;

/**
 * 建筑成新修正系统维护
 * @author HuanWei
 *
 */
public interface IPgt00361Service {

	/**
	 * 进行数据增加操作
	 * @return true成功；false失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00361 test361)throws Exception;
	
	
	
	/**
	 * 进行数据删除操作
	 * @return true成功；false失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00361 test361)throws Exception;
	
	
	/**
	 * 进行选择数据删除操作
	 * @param test361
	 * @return
	 * @throws Exception
	 */
	public boolean GetSelDeleteCommand(Pgt00361 test361) throws Exception;
	
	
	
	/**
	 * 进行数据更新操作
	 * @return true成功；false失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00361 test361)throws Exception;
	
	
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00361> LoadAll(Pgv00361 test361)throws Exception;
	
	
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00361 LoadByPrimaryKey(Pgt00361 test361)throws Exception;
	
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00361 LoadByPrimaryAddKey(Pgt00361 test361)throws Exception;
	
	
	
	/**
	 * 进行参数复制操作
	 * @return true成功；false失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt00361 test361)throws Exception;
	
	/**
	 * 信息导出
	 */
	public OutputStream ExportT00361(Pgv00361 v00361)throws Exception;
	
	/**
	 * 信息导入
	 */
	public Pgv00361 ImportExcelData(ArrayList<Pgv00361> v00361List)throws Exception;
	
}
