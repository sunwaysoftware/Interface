package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv00302;
import com.sunway.vo.Pgv00320;
import com.sunway.vo.Pgv00320e;

/**
 * 全面评估市场法房产信息
 * @author Light
 *
 */
public interface IPgt00320Service {
	
	/**
	 * 读取数据
	 * @param t00320
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00320> LoadAll(Pgv00320 v00320)throws Exception;
	
	/**
	 * 数据导入
	 * @param v00320List
	 * @return
	 * @throws Exception
	 */
	public Pgv00320 ImportExcelData(ArrayList<Pgv00320> v00320List) throws Exception;
	
	/**
	 * 執行評估操作
	 * @param bean 納稅人編碼[SWID], 評估操作人[PGCZR], 評稅時點[PSSD]
	 * @return T.成功; F.失敗
	 * @throws Exception
	 */
	public Boolean GetExecPG(Pgv00320 bean) throws Exception;
	
	/**
	 * 读取评估数据列表
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00320> LoadPGList(Pgv00320 bean)throws Exception;
	
	/**
	 * 根据主键读取信息
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Pgv00320 LoadByPrimaryKey(Pgv00320 bean) throws Exception;
	
	/**
	 * 读取价格列表
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00320> LoadPriceList(Pgv00320 bean)throws Exception;
	
	/**
	 * 根据楼号、小区代码获取信息
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00320> LoadByLhXqdm(Pgv00320 bean)throws Exception;
	
	/**
	 * 全面评估打印通知单
	 * @param v00320
	 * @return
	 * @throws Exception
	 */
	public String executeTZD(Pgv00302 bean)throws Exception;
	/**
	 * 查询全面评估数据
	 * @param v00302
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00320> LoadQMPGByFCXX(Pgv00320 v00320)throws Exception;
	
	/**
	 * 获取全面评估数据综合修正
	 * @param v00320e
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00320e> LoadQMPGZhxz(Pgv00320e v00320e)throws Exception;
	
	/**
	 * 更新操作
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgv00320 bean)throws Exception;
	
	/**
	 * 删除操作
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgv00320 bean)throws Exception;
	
	/**
	 * 选择删除操作
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public boolean GetSelDeleteCommand(Pgv00320 bean)throws Exception;
	
	/**
	 * 全面评估重复数据的查询
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00320> LoadAllDZ(Pgv00320 bean)throws Exception;


}
