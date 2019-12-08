/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgv00041;
import com.sunway.vo.Pgv12001;
import com.sunway.vo.Ss00000;

/**
 * 
 * 成本法算稅處理
 * @author Andy.Gao
 * @category 算稅處理
 *
 */
public interface ISs10000Service {
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
	public Boolean GetSsCommand(Pgv12001 bean) throws Exception;
	
	/**
	 * 取得審核數據的SWID列表
	 * @param bean PSSD,SWID,NSRMC,SSGX
	 * @return SWID列表
	 * @throws Exception
	 */
	public ArrayList<Pgv12001> LoadShSwidList(Pgv12001 bean) throws Exception;

	/**
	 * 成本法打印通知单
	 * @param ss00000
	 * @return
	 * @throws Exception
	 */
	public Ss00000 LoadNotice(Ss00000 ss00000) throws Exception;

	/**
	 * 成本法打印通知单执行
	 */
	public Boolean printcz(Ss00000 ss00000) throws Exception;
}
