package com.sunway.dao;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.PgtFc001;
import com.sunway.vo.PgtFc002;
import com.sunway.vo.PgtFc003;
import com.sunway.vo.PgvFc001;

public interface IPgtFc001DAO {
	/**
	 * 房产信息（房产原始资料）
	 * 
	 * @author LeiJia
	 * @version1.0
	 */

	/**
	 * 读取 办证处理所有房产信息
	 */	
	public ArrayList<PgvFc001> LoadAll(PgvFc001 fc001) throws Exception;
	/**
	 * 通过主键读取房产信息
	 */	
	public PgvFc001 LoadByPrimaryKey(PgtFc001 fc001)throws Exception;
	/**
	 *登记税额
	 */	
	public boolean RegistTax(PgtFc002 fc002)throws Exception;
	/**
	 * 读取中止业务处理所有房产信息
	 */	
	public ArrayList<PgvFc001> LoadAllZzYw(PgvFc001 fc001) throws Exception;
	
	/**
	 * 读取退税业务处理所有房产信息
	 */
	public ArrayList<PgvFc001> LoadAllTsYw(PgvFc001 fc001) throws Exception;

	/**
	 * 读取错误数据处理所有房产信息
	 */
	public ArrayList<PgvFc001> LoadAllCwSjCl(PgvFc001 fc001) throws Exception;
	/**
	 *中止业务
	 */	
	public boolean BreakService(PgtFc002 fc002)throws Exception;
	/**
	 *审核业务
	 */	
	public boolean AuditService(PgtFc002 fc002)throws Exception;
	/**
	 * 退税业务
	 */
	public boolean RebateTax(PgtFc002 fc002)throws Exception;
	/**
	 * 错误数据处理
	 */
	public boolean ProcesErrorData(PgtFc002 fc002)throws Exception;
	/**
	 * 超期未完税数据查询
	 */
	public ArrayList<PgvFc001> LoadAllOverodueTax(PgvFc001 fc001) throws Exception;	
	/**
	 * 超期未完税数据导出
	 */
	public OutputStream ExportOverodueTax(PgvFc001 fc001) throws Exception;
	/**
	 * 完税信息查询
	 */
	public ArrayList<PgvFc001> LoadAllPaymentInfo(PgvFc001 fc001) throws Exception;	
	/**
	 * 完税认定审核查询
	 */
	public ArrayList<PgvFc001> LoadAllTaxAuditedInfo(PgvFc001 fc001) throws Exception;
	/**
	 * 通过主键读取完税信息
	 */	
	public PgtFc002 LoadByPrimaryKey(PgtFc002 fc002)throws Exception;
	/**
	 * 完税信息查询导出
	 */
	public OutputStream ExportPaymentInfo(PgvFc001 fc001) throws Exception;
	/**
	 * 房产方房产证信息查询
	 */
	public ArrayList<PgvFc001> LoadAllHouseInfo(PgvFc001 fc001) throws Exception;	

	/**
	 * 通过主键读取房产证信息
	 */	
	public PgtFc003 LoadByPrimaryKey(PgtFc003 fc003)throws Exception;
	
	/**
	 *房产方房产证信导出
	 */
	public OutputStream ExportHouseInfo(PgvFc001 fc001) throws Exception;
	/**
	 *房产方办证但未完税记录查询
	 */
	public ArrayList<PgvFc001> LoadAllUnpaidRecord(PgvFc001 fc001) throws Exception;
	/**
	 * 房产方办证但未完税记录导出
	 */
	public OutputStream ExportUnpaidRecord(PgvFc001 fc001) throws Exception;
}
