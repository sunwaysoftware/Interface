package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt00301;
import com.sunway.vo.Pgv00301;

/**
 * 
 * 市场法登记信息
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public interface IPgt00301DAO {
	
	/**
	 * 進行數據刪除操作. 
	 */
	public boolean GetDeleteCommand(Pgt00301 t00301) throws Exception;

	/**
	 * 進行數據插入操作. 
	 */
	public boolean GetInsertCommand(Pgt00301 t00301) throws Exception;

	/**
	 * 進行數據更新操作. 
	 */
	public boolean GetUpdateCommand(Pgt00301 t00301) throws Exception;

	/**
	 * 進行數據提取操作. 
	 */
	public ArrayList<Pgv00301> LoadAll(Pgv00301 v00301) throws Exception;

	/**
	 * 按PK進行數據提取. 
	 */
	public Pgt00301 LoadByPrimaryKey(Pgt00301 t00301) throws Exception;

	/**
	 * 按PK取得详细信息 
	 */
	public Pgv00301 LoadDetail(Pgv00301 v00301) throws Exception;
	
	/**
	 * 按PK取得详细信息 
	 */
	public Pgv00301 LoadDetail_B(Pgv00301 v00301) throws Exception;
	
	/**
	 * 根据企业ID得到该企业一共有多少个房子
	 * @param t00301 納稅人編碼[SWID]
	 * @return 房產個數[FCCount]
	 * @throws Exception
	 */
	public Pgt00301 LoadCount(Pgt00301 t00301) throws Exception;

	/**
	 * 自动完成住址
	 */
	public ArrayList<String> GetZz(Pgv00301 v00301) throws Exception;

	/**
	 * 住宅登记信息查询
	 * @category 数据查询
	 */
	public Pgv00301 LoadPgv003015(Pgv00301 v00301) throws Exception;
}
