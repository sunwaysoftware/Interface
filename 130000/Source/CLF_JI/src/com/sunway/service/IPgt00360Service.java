/**
 * 
 */
package com.sunway.service;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.Pgt00360;

/**
 * @author Andy
 *
 */
public interface IPgt00360Service {

	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgt00360 bean) throws Exception;

	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt00360 bean) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt00360 bean) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgt00360> LoadAll(Pgt00360 bean) throws Exception;

	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt00360 LoadByPrimaryKey(Pgt00360 bean) throws Exception;
	/**
	 * 参数复制
	 */
	public boolean ExecuteParamCopy(Pgt00360 bean) throws Exception;
	
	/**
	 * 选择删除
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean SelDeleteCommand(Pgt00360 bean) throws Exception;
	
	/**
	 * 数据导出
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public OutputStream ExportT00360(Pgt00360 bean) throws Exception;
	
	/**
	 * 将模板数据整理成list
	 * @param file Excel导入文件
	 * @param userId
	 * @param ssgx
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgt00360> ImportData(String file, String userId, String ssgx)throws Exception;
	
	/**
	 * 数据导入DB
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Pgt00360 GetImportCommand(ArrayList<Pgt00360> list) throws Exception;	
	
	/**
	 * 导出模板中错误的数据
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public OutputStream ExportT00360Error(ArrayList<Pgt00360> list) throws Exception; 
	
}
