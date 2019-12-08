/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv02031;

/**
 * 
 * 收益法讀取个案评税數據列表
 * @author Andy.Gao
 *
 */
public interface IPg20001gDAO {
	/**
	 * 讀取个案评税數據列表
	 * @param bean 頁面索引[pageIndex], 頁面大小pageSize, 評稅時點[PSSD], 納稅人編碼[SWID], 納稅人名稱[NSRMC], 明細編碼[MXID], 稅收管轄[SSGX]
	 * @return 數據列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02031> LoadPgMx(Pgv02031 bean) throws Exception;
}
