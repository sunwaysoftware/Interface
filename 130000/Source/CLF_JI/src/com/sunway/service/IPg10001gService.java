/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv10031;

/**
 * 
 * 个案评税[成本法]
 * @author Andy.Gao
 * @category 个案评税
 *
 */
public interface IPg10001gService {
	/**
	 * 讀取个案评税數據列表
	 * @param bean 頁面索引[pageIndex], 頁面大小pageSize, 評稅時點[PSSD], 納稅人編碼[SWID], 納稅人名稱[NSRMC], 明細編碼[MXID], 稅收管轄[SSGX]
	 * @return 數據列表
	 * @throws Exception
	 */
	public ArrayList<Pgv10031> LoadPgMx(Pgv10031 bean) throws Exception;
}
