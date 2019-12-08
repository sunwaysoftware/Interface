/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv00041;

/**
 * 
 * 应纳税款计算表
 * @author Andy.Gao
 *
 */
public interface IPgt00041DAO {
	/**
	 * 查詢已算稅信息[成本法]
	 * @param bean 頁面序引[pageIndex], 頁面大小[pageSize], 評稅時點[PSSD], 稅務編碼[SWID], 納稅人名稱[NSRMC], 稅收管轄[SSGX], 評估類型[PGLX]
	 * @return 數據列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00041> LoadAllCB(Pgv00041 bean) throws Exception;
	
	/**
	 * 查詢已算稅信息[收益法]
	 * @param bean 頁面序引[pageIndex], 頁面大小[pageSize], 評稅時點[PSSD], 稅務編碼[SWID], 納稅人名稱[NSRMC], 稅收管轄[SSGX], 評估類型[PGLX]
	 * @return 數據列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00041> LoadAllSY(Pgv00041 bean) throws Exception;
	
	/**
	 * 查詢已算稅信息[市場法]
	 * @param bean 頁面序引[pageIndex], 頁面大小[pageSize], 評稅時點[PSSD], 稅務編碼[SWID], 納稅人名稱[NSRMC], 稅收管轄[SSGX], 評估類型[PGLX]
	 * @return 數據列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00041> LoadAllSC(Pgv00041 bean) throws Exception;
}
