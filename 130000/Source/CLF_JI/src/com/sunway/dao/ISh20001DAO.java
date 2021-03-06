/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv12001;
import com.sunway.vo.Pgv12004;

/**
 * 
 * 未审核操作[收益法]
 * @author Andy.Gao
 *
 */
public interface ISh20001DAO {
	/**
	 * 收益未审核的数据信息
	 * @param bean PSSD,SWID,NSRMC,SSGX
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv12001> LoadSh(Pgv12001 bean) throws Exception;

	/**
	 * 通过企业ID得到审核未通过的明细列表
	 * @param bean 企业ID
	 * @return 审核未通过明细列表
	 * @throws Exception
	 */
	public ArrayList<Pgv12004> LoadShMxNgList(Pgv12004 bean) throws Exception;
	
	/**
	 * 執行收益法審核操作
	 * @param bean SWID,CBSHCZR,PSSD
	 * @return T.成功; F.失敗
	 * @throws Exception
	 */
	public Boolean GetExecSH(Pgv12001 bean) throws Exception;
	
	/**
	 * 取得審核數據的SWID列表
	 * @param bean PSSD,SWID,NSRMC,SSGX
	 * @return SWID列表
	 * @throws Exception
	 */
	public ArrayList<Pgv12001> LoadShSwidList(Pgv12001 bean) throws Exception;
	
	/**
	 * 收益法強制審核操作
	 * @param bean SWID,CBSHCZR,PSSD
	 * @return T.成功; F.失敗
	 * @throws Exception
	 */
	public Boolean GetExecForceSH(Pgv12001 bean) throws Exception;
}
