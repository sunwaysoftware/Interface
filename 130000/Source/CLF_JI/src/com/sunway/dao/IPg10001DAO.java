/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv12001;
import com.sunway.vo.Pgv12004;

/**
 * 
 * 未評估[成本法]
 * @author Andy.Gao
 * @category 評估
 * @version 1.0
 *
 */
public interface IPg10001DAO {

	/**
	 * 執行評估操作
	 * @param bean 納稅人編碼[SWID], 評估操作人[PGCZR], 評稅時點[PSSD]
	 * @return T.成功; F.失敗
	 * @throws Exception
	 */
	public Boolean GetExecPG(Pgv12001 bean) throws Exception;
	
	/**
	 * 讀取待评税数据
	 * @param bean 頁面索引[pageIndex], 頁面大小pageSize, 評稅時點[PSSD], 納稅人編碼[SWID], 納稅人名稱[NSRMC], 稅收管轄[SSGX]
	 * @return 納稅人數據集
	 * @throws Exception
	 */
	public ArrayList<Pgv12001> LoadPg(Pgv12001 bean) throws Exception;
	
	/**
	 * 取得評估數據的SWID列表
	 * @param bean 評稅時點[PSSD], 納稅人編碼[SWID], 納稅人名稱[NSRMC], 稅收管轄[SSGX]
	 * @return 納稅人編碼列表
	 * @throws Exception
	 */
	public ArrayList<Pgv12001> LoadPgSwidList(Pgv12001 bean) throws Exception;
	
	/**
	 * 通过企业ID得到評估未通过的明细列表
	 * @param bean 納稅人編碼[SWID]
	 * @return 評估未通过明细列表
	 * @throws Exception
	 */
	public ArrayList<Pgv12004> LoadPgMxNgList(Pgv12004 bean) throws Exception;
}