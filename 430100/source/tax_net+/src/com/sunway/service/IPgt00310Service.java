

/**
 * @author sunxdd
 *
 */

package com.sunway.service;
import java.util.ArrayList;

import com.sunway.vo.Pgv00310;

public interface IPgt00310Service {
	
	/**
	 * 进行数据刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgv00310 b) throws Exception;

	/**
	 * 进行数据插入操作. 
	 */
	public boolean GetInsertCommand(Pgv00310 b) throws Exception;

	/**
	 * 进行数据更新操作. 
	 */
	public boolean GetUpdateCommand(Pgv00310 b) throws Exception;
	
	/**
	 * 进行数据更新操作. 
	 */
	public boolean GetUpdateCommand1(Pgv00310 b) throws Exception;
	
	/**
	 * 进行数据更新操作. 
	 */
	public boolean GetUpdateCommand2(Pgv00310 b) throws Exception;
	
	/**
	 * 进行数据更新操作. 
	 */
	public boolean GetUpdateCommand3(Pgv00310 b) throws Exception;
	
	/**
	 * 进行数据更新操作. 
	 */
	public boolean GetUpdateCommand4(Pgv00310 b) throws Exception;

	/**
	 * 进行数据提取操作. 
	 */	 
	public ArrayList<Pgv00310> LoadAll(Pgv00310 b) throws Exception;	
	
	/**
	 * 进行数据提取操作. 
	 */	 
	public ArrayList<Pgv00310> LoadAllV(Pgv00310 b) throws Exception;	
	
	/**
	 * 进行数据提取操作. 
	 */	 
	public ArrayList<Pgv00310> LoadAllB(Pgv00310 b) throws Exception;	
	
	/**
	 * 进行数据提取操作. 
	 */	 
	public ArrayList<Pgv00310> LoadDCYJ() throws Exception;

	public ArrayList<String> LoadSLSY(Pgv00310 b) throws Exception;	
	
	public String InfoMsg(Pgv00310 b) throws Exception;

	/**
	 * 按PK进行数据提取. 
	 */
	public Pgv00310 LoadByPrimaryKey(Pgv00310 b) throws Exception;	
	
	public Pgv00310 LoadByPrimaryKeyB(Pgv00310 b) throws Exception;
	
	/**
	 * 按PK进行数据提取. 
	 */
	public Pgv00310 JdsPrint(Pgv00310 b) throws Exception;
	
	
}
