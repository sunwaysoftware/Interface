/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv00301;
import com.sunway.vo.Pgv00302;

/**
 * 
 * 未审核操作[市場法]
 * @author Andy.Gao
 *
 */
public interface ISh30001DAO {
	
	/**
	 * 執行市場法審核操作
	 * @param bean SWID,CBSHCZR,PSSD
	 * @return T.成功; F.失敗
	 * @throws Exception
	 */
	public Boolean GetExecSH(Pgv00302 bean) throws Exception;
	
	/**
	 * 市場未审核的数据信息
	 * @param bean PSSD, SWID, NSRMC, SSGX, pageindex, pagesize
	 * @return 未审核的数据集
	 * @throws Exception
	 */
	public ArrayList<Pgv00302> LoadSh(Pgv00302 bean) throws Exception;
	
	/**
	 * 通过企业ID得到审核未通过的明细列表
	 * @param bean 企业ID
	 * @return 审核未通过明细列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00302> LoadShMxNgList(Pgv00302 bean) throws Exception;
	
	/**
	 * 取得審核數據的FCID列表
	 * @param bean PSSD,SWID,NSRMC,SSGX
	 * @return FCID列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00302> LoadShList(Pgv00302 bean) throws Exception;

	/**
	 * 未录入全数据列表
	 */
	public ArrayList<Pgv00301> LoadSh0030112(Pgv00301 bean) throws Exception;
}
