/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv02084;

/**
 * 
 * 市場审核和评税未过原因说明
 * @author Andy.Gao
 *
 */
public interface IPgt02084Service {
	/**
	 * 通过明细ID得到市場法审核没有通过的说明列表
	 * @param bean 房產編碼[FCID], 評稅時點[PSSD]
	 * @return 數據列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02084> LoadAll(Pgv02084 bean) throws Exception;
	
	/**
	 * 调出【到市場法审核没有通过的说明列表】
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv02084> LoadYY(Pgv02084 bean) throws Exception;
	
	/**
	 * 读取全面评估估价待办
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv02084> LoadQMPG(Pgv02084 bean)throws Exception;
}
