

/**
 * @author sunxdd
 *
 */

package com.sunway.dao;
import java.util.ArrayList;
import com.sunway.vo.Pgv02010f;

public interface IPgt02010fDAO {

	/**
	 * 进行数据删除操作. 
	 */
	public boolean GetDeleteCommand(Pgv02010f b) throws Exception;

	/**
	 * 进行数据插入操作. 
	 */
	public boolean GetInsertCommand(Pgv02010f b) throws Exception;

	/**
	 * 进行数据更新操作. 
	 */
	public boolean GetUpdateCommand(Pgv02010f b) throws Exception;	
	
	/**
	 * 进行数据提取操作. 
	 */	 
	public ArrayList<Pgv02010f> LoadAll(Pgv02010f b) throws Exception;	
	
	/**
	 * 进行数据提取操作. 
	 */	 
	public ArrayList<Pgv02010f> LoadAllB(Pgv02010f b) throws Exception;

	/**
	 * 按PK进行数据提取. 
	 */
	public Pgv02010f LoadByPrimaryKey(Pgv02010f b) throws Exception;	
	
}
