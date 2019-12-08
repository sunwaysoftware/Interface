package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv00310;
import com.sunway.vo.Pgv00310A;
import com.sunway.vo.Pgv003314;


/**
 * 评税结果检验（市场法）
 * @category 评税结果检验
 * @author Lee
 * @version 1.0
 */
public interface IPsjgjySCDAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsert003101Command(Pgv00310 scpsjgjy) throws Exception;
	
	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public Integer GetInsert00310A1Command(Pgv00310A scpsjgjy) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv003314> LoadAll003314 (Pgv003314 scpsjgjy) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00310> LoadAll00310 (Pgv00310 scpsjgjy) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00310A> LoadAll00310A (Pgv00310A scpsjgjy) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(String cjid) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean DeleteAllCommand() throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgv00310A LoadByPrimaryKey (String cjid) throws Exception;
}
