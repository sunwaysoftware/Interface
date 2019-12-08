/**
 * 
 */
package com.sunway.service;

import com.sunway.vo.Pgt12004;
import com.sunway.vo.Pgv12004;

/**
 * 
 * 成本法、收益法房产明细信息
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public interface IPgt12004Service {
	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgt12004 t12004) throws Exception;

	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt12004 t12004) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt12004 t12004) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public Pgv12004 LoadAll(Pgv12004 v12004) throws Exception;

	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt12004 LoadByPrimaryKey(Pgt12004 t12004) throws Exception;
	
	/**
	 * 自動採番地產ID
	 * @return 地產ID
	 * @throws Exception
	 */
	public String LoadMaxMxId() throws Exception;

	/**
	 * 按PK取得详细信息 
	 */
	public Pgv12004 LoadDetail(Pgv12004 v12004) throws Exception;
	
	/**
	 * 獲得地段等级
	 * @param v12004 房屋用途[FWYT], 房屋坐落地址[FWZLDZ], 所在區域[SZQY]
	 * @return 地段編碼[DDID], 地段名稱[DDNM]
	 * @throws Exception
	 */
	public Pgv12004 LoadDD(Pgv12004 v12004) throws Exception;

	/**
	 * 房产明细查询
	 * @category 数据查询
	 */
	public Pgv12004 LoadPgv120045(Pgv12004 v12004) throws Exception;
}
