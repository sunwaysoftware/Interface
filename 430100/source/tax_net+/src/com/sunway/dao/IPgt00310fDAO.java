

/**
 * @author sunxdd
 *
 */

package com.sunway.dao;
import java.util.ArrayList;
import com.sunway.vo.Pgv00310f;

public interface IPgt00310fDAO {

	/**
	 * 进行数据删除操作. 
	 */
	public boolean GetDeleteCommand(Pgv00310f b) throws Exception;

	/**
	 * 进行数据插入操作. 
	 */
	public boolean GetInsertCommand(Pgv00310f b) throws Exception;

	/**
	 * 进行数据更新操作. 
	 */
	public boolean GetUpdateCommand(Pgv00310f b) throws Exception;	
	
	/**
	 * 进行数据提取操作. 
	 */	 
	public ArrayList<Pgv00310f> LoadAll(Pgv00310f b) throws Exception;	
	
	/**
	 * 进行数据提取操作. 
	 */	 
	public ArrayList<Pgv00310f> LoadAllB(Pgv00310f b) throws Exception;

	/**
	 * 按PK进行数据提取. 
	 */
	public Pgv00310f LoadByPrimaryKey(Pgv00310f b) throws Exception;	
	
}
