package com.sunway.dao;

import java.util.ArrayList;
import com.sunway.vo.Pgv100314;
import com.sunway.vo.Pgv120101;
import com.sunway.vo.Pgv12010a1;


/**
 * 评税结果检验（成本法）
 * @category 评税结果检验
 * @author Lee
 * @version 1.0
 */
public interface IPsjgjyCBDAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsert120101Command(Pgv120101 cbpsjgjy) throws Exception;
	
	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public Integer GetInsert12010A1Command(Pgv12010a1 cbpsjgjy) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv100314> LoadAll100314 (Pgv100314 cbpsjgjy) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv120101> LoadAll120101 (Pgv120101 cbpsjgjy) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv12010a1> LoadAll12010A1 (Pgv12010a1 cbpsjgjy) throws Exception;
	
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
	public Pgv12010a1 LoadByPrimaryKey (String cjid) throws Exception;
	
	
}
