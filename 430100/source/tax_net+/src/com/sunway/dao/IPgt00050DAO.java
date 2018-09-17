

/**
 * @author sunxdd
 *
 */

package com.sunway.dao;
import java.util.ArrayList;
import com.sunway.vo.Pgv00050;

public interface IPgt00050DAO {

	/**
	 * 进行数据删除操作. 
	 */
	public boolean GetDeleteCommand(Pgv00050 b) throws Exception;

	/**
	 * 进行数据插入操作. 
	 */
	public boolean GetInsertCommand(Pgv00050 b) throws Exception;

	/**
	 * 进行数据更新操作. 
	 */
	public boolean GetUpdateCommand(Pgv00050 b) throws Exception;	
	
	/**
	 * 进行数据提取操作. 
	 */	 
	public ArrayList<Pgv00050> LoadAll(Pgv00050 b) throws Exception;		

	/**
	 * 按PK进行数据提取. 
	 */
	public Pgv00050 LoadByPrimaryKey(Pgv00050 b) throws Exception;	
	
}
