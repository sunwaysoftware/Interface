package com.sunway.service;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.Pgv02002;
import com.sunway.vo.Pgv02020;

/**
 * 全面评估市场法国土信息
 * @author Light
 *
 */
public interface IPgt02020Service {
	
	/**
	 * 读取数据
	 * @param t02020
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv02020> LoadAll(Pgv02020 v02020)throws Exception;
	
	public ArrayList<Pgv02020> LoadAll1(Pgv02020 v02020)throws Exception;
	
	/**
	 * 数据导入
	 * @param v02020List
	 * @return
	 * @throws Exception
	 */
	public Pgv02020 ImportExcelData(ArrayList<Pgv02020> v02020List) throws Exception;
	
	/**
	 * 執行評估操作
	 * @param bean 納稅人編碼[SWID], 評估操作人[PGCZR], 評稅時點[PSSD]
	 * @return T.成功; F.失敗
	 * @throws Exception
	 */
	public Boolean GetExecPG(Pgv02020 bean) throws Exception;
	
	/**
	 * 根据条件获取相应评估价格及信息
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Pgv02020 LoadPGJG(Pgv02020 bean) throws Exception;
	
	/**
	 * 取得座落地址（自动完成用）
	 * @param v00303
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> GetFwtdzl(Pgv02020 v02020) throws Exception;
	
	/**
	 * 读取评估数据列表
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv02020> LoadPGList(Pgv02020 bean)throws Exception;
	
	/**
	 * 根据主键读取信息
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Pgv02020 LoadByPrimaryKey(Pgv02020 bean) throws Exception;
	
	/**
	 * 读取价格列表
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv02020> LoadPriceList(Pgv02020 bean)throws Exception;
	
	/**
	 * 根据楼号、小区代码获取信息
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv02020> LoadByLhXqdm(Pgv02020 bean)throws Exception;
	
	/**
	 * 全面评估打印通知单
	 * @param v02020
	 * @return
	 * @throws Exception
	 */
	public String executeTZD(Pgv02002 bean)throws Exception;
	
	/**
	 * 删除数据操作
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgv02020 bean)throws Exception;
	
	/**
	 * 进行选择删除操作
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean GetSelDeleteCommand(Pgv02020 bean)throws Exception ;

	
	/**
	 * 数据更新操作
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgv02020 bean)throws Exception ;
		
	
	/**
	 * 全部删除
	 * @param v02020
	 * @return
	 * @throws Exception
	 */
	public boolean GetDeleteAllCommand(Pgv02020 v02020)throws Exception;
	
	/**
	 * 数据导出
	 * @param v02020
	 * @return
	 * @throws Exception
	 */
	public OutputStream ExportData(Pgv02020 v02020)throws Exception;
	
	/**
	 * 数据导入
	 * @param v02020List
	 * @return
	 * @throws Exception
	 */
	public Pgv02020 ImportExcelDataSimple(Pgv02020 v02020Bean) throws Exception;
}
