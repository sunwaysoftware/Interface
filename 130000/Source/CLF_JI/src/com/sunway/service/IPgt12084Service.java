/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv12084;

/**
 * 
 * 成本，收益审核和评税未过原因说明
 * @author Andy.Gao
 *
 */
public interface IPgt12084Service {
	/**
	 * 通过明细ID得到成本或收益法审核没有通过的说明列表
	 * @param bean 明細編碼[MXID], 評稅時點[PSSD], 审核类型[TYPE]
	 * @return 數據列表
	 * @throws Exception
	 */
	public ArrayList<Pgv12084> LoadAll(Pgv12084 bean) throws Exception;
}
