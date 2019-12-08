/**
 * 
 */
package com.sunway.dao;

import com.sunway.vo.Pgt12001;
import com.sunway.vo.Pgv12001;

/**
 * 
 * 成本、收益法登记信息
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public interface IPgt12001DAO {

	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgt12001 t12001) throws Exception;

	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt12001 t12001) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt12001 t12001) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public Pgv12001 LoadAll(Pgv12001 v12001) throws Exception;

	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt12001 LoadByPrimaryKey(Pgt12001 t12001) throws Exception;

	/**
	 * 按PK取得详细信息 
	 */
	public Pgv12001 LoadDetail(Pgv12001 v12001) throws Exception;
	
	/**
	 * 根据企业ID得到该企业一共有多少个土地。多少个房子。多少个明细。
	 * @param t12001 企業編碼[SWID]
	 * @return 地產個數[DCCount],　房產個數[FCCount], 明細個數[MXCount]
	 * @throws Exception
	 */
	public Pgt12001 LoadCount(Pgt12001 t12001) throws Exception;

	/**
	 * 纳税人查询
	 * @category 数据查询
	 */
	public Pgv12001 LoadPgv120015(Pgv12001 v12001) throws Exception;
}
