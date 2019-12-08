/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv00358;

/**
 * 
 * 临时的实例库
 * @author Andy.Gao
 *
 */
public interface IPgt00358DAO {
	/**
	 * 临时的实例库
	 * @param bean 頁面索引[pageIndex], 頁面大小[pageSize], 房產編碼[FCID]
	 * @return 數據列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00358> LoadAll(Pgv00358 bean) throws Exception;
}
