/**
 * 
 */
package com.sunway.dao;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.Pgt02055;
import com.sunway.vo.Pgv02055;

/**
 * 
 * 
 * @author Andy
 *
 */
public interface IPgt02055DAO {

	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgt02055 bean) throws Exception;
	
	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommandA(Pgt02055 bean) throws Exception;
	
	/**
	 * 进行选择数据删除操作
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean GetSelDeleteCommand(Pgt02055 bean) throws Exception;

	
	/**
	 * 进行选择数据删除操作
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean GetSelDeleteCommandA(Pgt02055 bean) throws Exception;

	
	
	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt02055 bean) throws Exception;
	
	
	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommandA(Pgt02055 bean) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt02055 bean) throws Exception;
	
	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommandA(Pgt02055 bean) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgv02055> LoadAll(Pgv02055 bean) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgv02055> LoadAllA(Pgv02055 bean) throws Exception;
	
	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt02055 LoadByPrimaryKey(Pgt02055 bean) throws Exception;
	
	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt02055 LoadByPrimaryKeyA(Pgt02055 bean) throws Exception;
	
	
	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt02055 LoadByPrimaryAddKey(Pgt02055 bean) throws Exception;
	
	
	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt02055 LoadByPrimaryAddKeyA(Pgt02055 bean) throws Exception;
	
	
	/**
	 * 信息导出
	 */
	public OutputStream ExportT02055(Pgv02055 v02055) throws Exception;
	
	/**
	 * 信息导出
	 */
	public OutputStream ExportT02055A(Pgv02055 v02055) throws Exception;
	
	
	/**
	 * 信息导入
	 */
	public Pgv02055 ImportExcelData(ArrayList<Pgv02055> v02055List)throws Exception;
	
	/**
	 * 信息导入
	 */
	public Pgv02055 ImportExcelDataA(ArrayList<Pgv02055> v02055List)throws Exception;
}
