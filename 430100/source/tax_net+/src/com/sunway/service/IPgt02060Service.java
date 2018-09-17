package com.sunway.service;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.Pgv02002;
import com.sunway.vo.Pgv02060;

/**
 * 全面评估市场法国土信息
 * @author Light
 *
 */
public interface IPgt02060Service {
	
	/**
	 * 读取数据
	 * @param t02060
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv02060> LoadAll(Pgv02060 v02060)throws Exception;
	
	/**
	 * 数据导入
	 * @param v02060List
	 * @return
	 * @throws Exception
	 */
	public Pgv02060 ImportExcelData(ArrayList<Pgv02060> v02060List) throws Exception;
	
	/**
	 * 執行評估操作
	 * @param bean 納稅人編碼[SWID], 評估操作人[PGCZR], 評稅時點[PSSD]
	 * @return T.成功; F.失敗
	 * @throws Exception
	 */
	public Boolean GetExecPG(Pgv02060 bean) throws Exception;
	
	/**
	 * 根据条件获取相应评估价格及信息
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Pgv02060 LoadPGJG(Pgv02060 bean) throws Exception;
	
	/**
	 * 读取评估数据列表
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv02060> LoadPGList(Pgv02060 bean)throws Exception;
	
	/**
	 * 根据主键读取信息
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Pgv02060 LoadByPrimaryKey(Pgv02060 bean) throws Exception;
	
	/**
	 * 读取价格列表
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv02060> LoadPriceList(Pgv02060 bean)throws Exception;
	
	/**
	 * 根据楼号、小区代码获取信息
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv02060> LoadByLhXqdm(Pgv02060 bean)throws Exception;
	
	/**
	 * 全面评估打印通知单
	 * @param v02060
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
	public boolean GetDeleteCommand(Pgv02060 bean)throws Exception;
	
	/**
	 * 进行选择删除操作
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean GetSelDeleteCommand(Pgv02060 bean)throws Exception ;

	
	/**
	 * 数据更新操作
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgv02060 bean)throws Exception ;	
	
	/**
	 * 全部删除
	 * @param v02060
	 * @return
	 * @throws Exception
	 */
	public boolean GetDeleteAllCommand(Pgv02060 v02060)throws Exception;
	
	/**
	 * 数据导出
	 * @param v02060
	 * @return
	 * @throws Exception
	 */
	public OutputStream ExportData(Pgv02060 v02060)throws Exception;
	
	/**
	 * 数据导入
	 * @param v02060List
	 * @return
	 * @throws Exception
	 */
	public Pgv02060 ImportExcelDataSimple(Pgv02060 v02060Bean) throws Exception;
}
