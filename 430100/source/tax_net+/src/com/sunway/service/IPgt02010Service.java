

/**
 * @author sunxdd
 *
 */

package com.sunway.service;
import java.util.ArrayList;

import com.sunway.vo.Pgv02010;

public interface IPgt02010Service {
	
	/**
	 * 进行数据刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgv02010 b) throws Exception;

	/**
	 * 进行数据插入操作. 
	 */
	public boolean GetInsertCommand(Pgv02010 b) throws Exception;

	/**
	 * 进行数据更新操作. 
	 */
	public boolean GetUpdateCommand(Pgv02010 b) throws Exception;
	
	/**
	 * 进行数据更新操作. 
	 */
	public boolean GetUpdateCommand1(Pgv02010 b) throws Exception;
	
	/**
	 * 进行数据更新操作. 
	 */
	public boolean GetUpdateCommand2(Pgv02010 b) throws Exception;
	
	/**
	 * 进行数据更新操作. 
	 */
	public boolean GetUpdateCommand3(Pgv02010 b) throws Exception;
	
	/**
	 * 进行数据更新操作. 
	 */
	public boolean GetUpdateCommand4(Pgv02010 b) throws Exception;

	/**
	 * 进行数据提取操作. 
	 */	 
	public ArrayList<Pgv02010> LoadAll(Pgv02010 b) throws Exception;	
	
	/**
	 * 进行数据提取操作. 
	 */	 
	public ArrayList<Pgv02010> LoadAllV(Pgv02010 b) throws Exception;	
	
	/**
	 * 进行数据提取操作. 
	 */	 
	public ArrayList<Pgv02010> LoadAllB(Pgv02010 b) throws Exception;	
	
	/**
	 * 进行数据提取操作. 
	 */	 
	public ArrayList<Pgv02010> LoadDCYJ() throws Exception;

	public ArrayList<String> LoadSLSY(Pgv02010 b) throws Exception;	
	
	public String InfoMsg(Pgv02010 b) throws Exception;

	/**
	 * 按PK进行数据提取. 
	 */
	public Pgv02010 LoadByPrimaryKey(Pgv02010 b) throws Exception;	
	
	public Pgv02010 LoadByPrimaryKeyB(Pgv02010 b) throws Exception;
	
	/**
	 * 按PK进行数据提取. 
	 */
	public Pgv02010 JdsPrint(Pgv02010 b) throws Exception;
	
	
}
