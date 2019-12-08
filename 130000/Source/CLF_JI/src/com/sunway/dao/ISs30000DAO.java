/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv00041;
import com.sunway.vo.Pgv00302;
import com.sunway.vo.Ss00000;
import com.sunway.vo.Ss30000;

/**
 * 
 * 市場法算稅處理
 * @author Andy.Gao
 * @category 算稅處理
 *
 */
public interface ISs30000DAO {
	/**
	 * 全部重新算稅
	 * @param bean
	 * @throws Exception
	 */
	public Boolean GetSsAgainAllCommand(Pgv00041 bean) throws Exception;
	
	/**
	 * 重新算稅
	 * @param bean
	 * @throws Exception
	 */
	public Boolean GetSsAgainCommand(Pgv00041 bean) throws Exception;
	
	/**
	 * 成本法应纳税款计算
	 * @param bean 稅務編碼[SWID], 算稅操作人[CBSKCZR], 評稅時點[PSSD], 管收管轄[SSGX]
	 * @throws Exception
	 */
	public Boolean GetSsCommand(Pgv00302 bean) throws Exception;
	
	/**
	 * 取得審核數據的FCID列表
	 * @param bean PSSD,SWID,NSRMC,SSGX
	 * @return FCID列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00302> LoadSsList(Pgv00302 bean) throws Exception;

	/**
	 * 市场法打印通知单
	 * @param ss30000
	 * @return
	 * @throws Exception
	 */
	public Ss30000 LoadNotice(Ss30000 ss30000) throws Exception;

	/**
	 * 市场法打印通知单执行
	 */
	public Boolean printcz(Ss00000 ss00000) throws Exception;
}
