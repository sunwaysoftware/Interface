package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv00004;
import com.sunway.vo.Pgt00004;

import java.io.OutputStream;

/**
 * 成本法容积率
 * @category 成本法容积率
 * @author Lee
 * @version 1.0
 */
public interface IPgt00004Service {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00004 rjl) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00004 rjl) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00004 rjl) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00004> LoadAll(Pgv00004 rjl) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00004 LoadByPrimaryKey(Pgt00004 rjl) throws Exception;
	/**
	 * 从excel中导入容积率数据
	 * @param RJLsjList
	 * @return
	 */
	public Pgv00004 ImportExcelData(ArrayList<Pgv00004> ebList) throws Exception;
	/**
	 * 容积率信息导出操作.
	 */
	public OutputStream ExportRJLxtwh(Pgv00004 v00004) throws Exception;
	/**
	 * 导入时删除重复数据
	 * @param eBean
	 * @return
	 * @throws Exception
	 */
	public boolean GetDeleteImpCommand(Pgv00004 eBean) throws Exception;
	/**
	 * 读取免税政策依据
	 */
   public ArrayList<Pgt00004> LoadAllMsZcYj()throws Exception;
}
