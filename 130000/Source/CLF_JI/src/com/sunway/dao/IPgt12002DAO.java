/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt12002;
import com.sunway.vo.Pgv12002;

/**
 * 
 * 成本、收益法地產信息
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public interface IPgt12002DAO {

	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgt12002 t12002) throws Exception;

	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt12002 t12002) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt12002 t12002) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public Pgv12002 LoadAll(Pgv12002 v12002) throws Exception;

	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt12002 LoadByPrimaryKey(Pgt12002 t12002) throws Exception;
	
	/**
	 * 自動採番地產ID
	 * @return 地產ID
	 * @throws Exception
	 */
	public String LoadMaxDcId() throws Exception;

	/**
	 * 按PK取得详细信息 
	 */
	public Pgv12002 LoadDetail(Pgv12002 v12002) throws Exception;
	
	/**
	 * 判断土地使用权证书号是否已经存在
	 * @param 土地使用权证书号[TDSYQBM], 地产编码[DCID]
	 * @return T.存在; F.不存在
	 * @throws Exception
	 */
	public Boolean GetTdsyqbmByDcid(Pgt12002 t12002) throws Exception;
	
	/**
	 * 成本法、收益法土地地址库自动提示
	 */
	public ArrayList<String> LoadTDZL(Pgv12002 v12002) throws Exception;
	
	/**
	 * 根据土地座落地址得到土地等级
	 * @param v12002 土地用途[TDYT], 土地座落[TDZL], 所在區域[SZQY]
	 * @return 土地等级 編碼[CD_TDDJ], 名稱[TDDJ]
	 * @throws Exception
	 */
	public Pgv12002 LoadTDDJ(Pgv12002 v12002) throws Exception;

	/**
	 * 地产信息查询
	 * @category 数据查询
	 */
	public Pgv12002 LoadPgv120025(Pgv12002 v12002) throws Exception;
}
