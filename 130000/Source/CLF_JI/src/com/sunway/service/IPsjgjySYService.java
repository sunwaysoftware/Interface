package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv020314;
import com.sunway.vo.Pgv120102;
import com.sunway.vo.Pgv12010a2;


/**
 * 评税结果检验（收益法）
 * @category 评税结果检验
 * @author Lee
 * @version 1.0
 */
public interface IPsjgjySYService {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsert120102Command(Pgv120102 sypsjgjy) throws Exception;
	
	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public Integer GetInsert12010A2Command(Pgv12010a2 sypsjgjy) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv020314> LoadAll020314 (Pgv020314 sypsjgjy) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv120102> LoadAll120102 (Pgv120102 sypsjgjy) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv12010a2> LoadAll12010A2 (Pgv12010a2 sypsjgjy) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean DeleteAllCommand() throws Exception;
	
}
