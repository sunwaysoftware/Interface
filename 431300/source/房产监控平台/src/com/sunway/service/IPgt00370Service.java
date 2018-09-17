package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv00370;

/**
 * 通知公告
 * @author Light
 *
 */
public interface IPgt00370Service {

	/**
	 * 读取数据
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00370> LoadAll(Pgv00370 bean)throws Exception;
	
	/**
	 * 根据主键获取数据
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Pgv00370 LoadByPrimaryKey(Pgv00370 bean)throws Exception;
	
	/**
	 * 数据插入操作
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgv00370 bean)throws Exception;
	
	/**
	 * 数据更新操作
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgv00370 bean)throws Exception;
	
	/**
	 * 数据删除操作 
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgv00370 bean)throws Exception;
	
	/**
	 * 读取公告
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00370> LoadAllByGQSJ(Pgv00370 bean)throws Exception;
	
	/**
	 * 读取工作状态
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00370> LoadWorkState(Pgv00370 bean)throws Exception;
	
	/**
	 * 读取漏采小区信息
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00370> LoadMissXQInfo(Pgv00370 bean)throws Exception ;
	
	/**
	 * 显示系统通知
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00370> LoadSysTz(Pgv00370 bean)throws Exception;
	
	/**
	 * 标识系统通知
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean execTzFlag(Pgv00370 bean)throws Exception;	
	
}
