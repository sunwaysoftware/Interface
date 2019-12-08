/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv00302;
import com.sunway.vo.Pgv00331;

/**
 * 
 * 已評估[市場法]
 * @author Andy.Gao
 * @category 評估
 * @version 1.0
 *
 */
public interface IPg30002DAO {
	/**
	 * 选择重新評估
	 * @param bean 納稅人編碼[SWID], 評估操作人[PGCZR], 評稅時點[PSSD]
	 * @return T.成功; F.失敗
	 * @throws Exception
	 */
	public Boolean GetExecPgAgain(Pgv00302 bean) throws Exception;
	
	/**
	 * 全部重新評估
	 * @param bean 稅收管轄[SSGX], 評估操作人[PGCZR], 評稅時點[PSSD]
	 * @return T.成功; F.失敗
	 * @throws Exception
	 */
	public Boolean GetExecPgAgainAll(Pgv00302 bean) throws Exception;
	
	/**
	 * 讀取待评税数据
	 * @param bean 頁面索引[pageIndex], 頁面大小pageSize, 評稅時點[PSSD], 納稅人編碼[SWID], 納稅人名稱[NSRMC], 稅收管轄[SSGX]
	 * @return 納稅人數據集
	 * @throws Exception
	 */
	public ArrayList<Pgv00331> LoadPgOK(Pgv00331 bean) throws Exception;
	
	/**
	 * 估价后的数据，信息变更
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Boolean ExecInfoBg(Pgv00302 bean) throws Exception;
}
