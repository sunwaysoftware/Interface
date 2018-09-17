/**
 * 
 */
package com.sunway.service;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.Pgt02054;
import com.sunway.vo.Pgv02054;

/**
 * @author Andy
 *
 */
public interface IPgt02054Service {

	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgt02054 bean) throws Exception;
	
	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommandA(Pgt02054 bean) throws Exception;
	
	
	/**
	 * 进行选择数据删除操作
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean GetSelDeleteCommand(Pgt02054 bean) throws Exception;
	
	/**
	 * 进行选择数据删除操作
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean GetSelDeleteCommandA(Pgt02054 bean) throws Exception;

	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt02054 bean) throws Exception;
	
	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommandA(Pgt02054 bean) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt02054 bean) throws Exception;

	
	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommandA(Pgt02054 bean) throws Exception;
	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgv02054> LoadAll(Pgv02054 bean) throws Exception;
	
	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgv02054> LoadAllA(Pgv02054 bean) throws Exception;

	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt02054 LoadByPrimaryKey(Pgt02054 bean) throws Exception;
	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt02054 LoadByPrimaryKeyA(Pgt02054 bean) throws Exception;
	
	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt02054 LoadByPrimaryAddKey(Pgt02054 bean) throws Exception;
	
	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt02054 LoadByPrimaryAddKeyA(Pgt02054 bean) throws Exception;
	
	
	/**
	 * 信息导出
	 */
	public OutputStream ExportT02054(Pgv02054 v02054) throws Exception;
	
	

	/**
	 * 信息导出
	 */
	public OutputStream ExportT02054A(Pgv02054 v02054) throws Exception;
	
	/**
	 * 信息导入
	 */
	public Pgv02054 ImportExcelData(ArrayList<Pgv02054> v02054List)throws Exception;
	
	/**
	 * 信息导入
	 */
	public Pgv02054 ImportExcelDataA(ArrayList<Pgv02054> v02054List)throws Exception;
}
