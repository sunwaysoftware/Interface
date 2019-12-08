/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv00302;

/**
 * 
 * 通過审核操作[市場法]
 * @author Andy.Gao
 * @category 數據審核[市場法]
 *
 */
public interface ISh30002DAO {
	/**
	 * 市場审核通过，但还没有评税的数据信息
	 * @param bean 頁面索引[pageIndex], 頁面大小[pageSize], 評稅時點[PSSD], 納稅人編碼[SWID], 納稅人名稱[NSRMC], 稅收管轄[SSGX]
	 * @return 數據列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00302> LoadShOK(Pgv00302 bean) throws Exception;
	
	/**
	 * 市場法选择重新审核
	 * @param bean 納稅人編碼[SWID], 審核操作人[SHCZR], 評稅時點[PSSD]
	 * @return T.成功; F.失敗
	 * @throws Exception
	 */
	public Boolean GetExecShAgain(Pgv00302 bean) throws Exception;
	
	/**
	 * 市場法全部重新审核: 当前税收管辖区里，当前评税时点下的未评税的数据。
	 * @param bean 稅收管轄[SSGX], 審核操作人[SHCZR], 評稅時點[PSSD]
	 * @return T.成功; F.失敗
	 * @throws Exception
	 */
	public Boolean GetExecShAgainAll(Pgv00302 bean) throws Exception;
}
