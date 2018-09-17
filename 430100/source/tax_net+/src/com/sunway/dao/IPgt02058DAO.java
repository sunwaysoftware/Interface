package com.sunway.dao;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.Pgt02058;
import com.sunway.vo.Pgv02058;


/**
 * 商业法分区交易日修正系数
 * @category 物价指数修正
 * @author LeiJia
 * @version 1.0
 */
public interface IPgt02058DAO {

	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt02058 wjzs) throws Exception;
	
	/**
	 * 进行数据增加操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetInsertCommandA(Pgt02058 wjzs) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt02058 wjzs) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetDeleteCommandA(Pgt02058 wjzs) throws Exception;
	
	/**
	 * 进行选择数据删除操作
	 * @param wjzs
	 * @return
	 * @throws Exception
	 */
	public boolean GetSelDeleteCommand(Pgt02058 wjzs) throws Exception;
	
	
	/**
	 * 进行选择数据删除操作
	 * @param wjzs
	 * @return
	 * @throws Exception
	 */
	public boolean GetSelDeleteCommandA(Pgt02058 wjzs) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt02058 wjzs) throws Exception;
	
	
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommandA(Pgt02058 wjzs) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02058> LoadAll(Pgv02058 wjzs) throws Exception;
	
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02058> LoadAllA(Pgv02058 wjzs) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02058 LoadByPrimaryKey(Pgt02058 wjzs) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt02058 LoadByPrimaryKeyA(Pgt02058 wjzs) throws Exception;
	
	/**
	 * 进行参数复制操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean ExecuteParamCopy(Pgt02058 wjzs) throws Exception;
	
	/**
	 * 根据交易日期进行测算系数
	 * @return True 成功；False失败
	 * @throws Exception
	 */
	public Pgt02058 FormulaVal(Pgt02058 wjzs) throws Exception;
	
	/**
	 * 根据评税时点测算系数[加权]
	 * @return
	 * @throws Exception
	 */
	public Pgt02058 FormulaVal_JQ(Pgt02058 wjzs) throws Exception;		
	
	/**
	 * 根据交易日期进行测算系数
	 * @return True 成功；False失败
	 * @throws Exception
	 */
	public Pgt02058 FormulaVal_XQ(Pgt02058 wjzs) throws Exception;
	
	/**
	 * 根据评税时点测算系数[加权]
	 * @return
	 * @throws Exception
	 */
	public Pgt02058 FormulaVal_JQ_XQ(Pgt02058 wjzs) throws Exception;		
	
	/**
	 * 信息导出
	 */
	public OutputStream ExportJYSJ(Pgv02058 v02058)throws Exception;
	
	/**
	 * 信息导出
	 */
	public OutputStream ExportJYSJA(Pgv02058 v02058)throws Exception;
	
	/**
	 * 信息导入
	 */
	public Pgv02058 ImportExcelData(ArrayList<Pgv02058> v02058List)throws Exception ;
	/**
	 * 信息导入
	 */
	public Pgv02058 ImportExcelDataA(ArrayList<Pgv02058> v02058List)throws Exception ;
	
	/**
	 * AJAX查询数据
	 * @param v02058
	 * @return
	 * @throws Exception
	 */
	public Pgt02058 createByAjax(Pgt02058 v02058)throws Exception;
	
	/**
	 * AJAX查询数据
	 * @param v02058
	 * @return
	 * @throws Exception
	 */
	public Pgt02058 createByAjaxA(Pgt02058 v02058)throws Exception;
	
	/**
	 * 根据评税时点测算系数[测算]
	 * @return
	 * @throws Exception
	 */
	public Pgt02058 FormulaVal_CS(Pgt02058 wjzs) throws Exception;	
	
	/**
	 * 根据评税时点测算系数[测算小区]
	 * @return
	 * @throws Exception
	 */
	public Pgt02058 FormulaVal_CS_XQ(Pgt02058 wjzs) throws Exception;	

}
