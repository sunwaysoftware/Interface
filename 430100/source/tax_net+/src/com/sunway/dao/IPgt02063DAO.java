package com.sunway.dao;


import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import com.sunway.vo.Pgt02063;
import com.sunway.vo.Pgv02063;


/**
 * 评估方法权重比维护
 * @author LeiJia
 *
 */
public interface IPgt02063DAO {

	
	/**
	 * 进行数据增加操作
	 * @return true成功；false失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt02063 t02063)throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return true成功； false失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt02063 t02063)throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return true成功；false失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt02063 t02063)throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02063> LoadAll(Pgv02063 v02063)throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02063 LoadByPrimaryKey(Pgt02063 t02063)throws Exception;

	public Pgv02063 ImportExcelData(ArrayList<Pgv02063> pgv02063List)throws Exception;

	public ByteArrayOutputStream ExportQzb(Pgv02063 v02063)throws Exception;

}
