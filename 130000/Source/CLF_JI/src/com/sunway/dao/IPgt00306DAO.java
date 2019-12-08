package com.sunway.dao;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.Pgv00306;

/**
 * 楼房信息
 * @author LiuYang
 *
 */
public interface IPgt00306DAO {

	/**
	 * 读取数据
	 * @param v00306
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00306> LoadAll(Pgv00306 v00306)throws Exception;
	
	
	/**
	 * 根据主键获取数据
	 * @param v00306
	 * @return
	 * @throws Exception
	 */
	public Pgv00306 LoadByPrimaryKey(Pgv00306 v00306)throws Exception;
	/**
	 * 进行数据增加操作
	 * @return true成功；false失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgv00306 v00306)throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgv00306 v00306) throws Exception;
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgv00306 v00306) throws Exception;
	/**
	 * 信息导出
	 */
	public OutputStream ExportT00306(Pgv00306 v00306) throws Exception;
	
	/**
	 * 信息导入
	 */
	public Pgv00306 ImportExcelData(ArrayList<Pgv00306> v00306List)throws Exception;
	
	/**
	 * 根据所在区域与房屋坐落获取信息
	 * @param v00306
	 * @return
	 * @throws Exception
	 */
	public Pgv00306 LoadByZCDZL(Pgv00306 v00306)throws Exception;
}
