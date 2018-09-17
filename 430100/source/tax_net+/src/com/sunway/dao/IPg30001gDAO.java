/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv00331;

/**
 * 
 * 市場法讀取个案评税數據列表
 * @author Andy.Gao
 *
 */
public interface IPg30001gDAO {
	/**
	 * 讀取个案评税數據列表
	 * @param bean 頁面索引[pageIndex], 頁面大小pageSize, 評稅時點[PSSD], 納稅人編碼[SWID], 納稅人名稱[NSRMC], 明細編碼[MXID], 稅收管轄[SSGX]
	 * @return 數據列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00331> LoadPgMx(Pgv00331 bean) throws Exception;
	
	/**
	 * 個案評估
	 * @param bean 實例編碼[SLID], 評估操作人[SCPGCZR], 房產編碼[FCID], 評稅時點[PSSD]
	 * @return T.成功; F.失敗
	 * @throws Exception
	 */
	public Boolean GetPgCommand(Pgv00331 bean) throws Exception;
}
