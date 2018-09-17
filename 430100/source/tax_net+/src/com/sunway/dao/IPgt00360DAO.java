/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;
import com.sunway.vo.Pgt00360;

/**
 * 
 * 
 * @author Andy
 *
 */
public interface IPgt00360DAO {

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
	public boolean ExecuteParamCopy(Pgt00360 lcxz) throws Exception;
	
	/**
	 * 选择删除
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean SelDeleteCommand(Pgt00360 bean) throws Exception;
	
	/**
	 * 数据导入
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Pgt00360 GetImportCommand(ArrayList<Pgt00360> list) throws Exception;
	
}
