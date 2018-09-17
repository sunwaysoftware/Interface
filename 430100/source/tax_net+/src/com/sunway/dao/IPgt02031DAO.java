/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgv02031;

/**
 * 
 * 市场法评税结果
 * @author Andy.Gao
 *
 */
public interface IPgt02031DAO {
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgv02031 LoadByPrimaryKey(Pgv02031 bean) throws Exception;
	
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgv02031 LoadByPrimaryKey_B(Pgv02031 bean) throws Exception;
	
	/**
	 * 根據SWID讀取評估結果列表 
	 * @param bean 頁面序引[pageIndex], 頁面大小[pageSize], 稅務編碼[SWID], 評稅時點[PSSD]
	 * @return 評估結果列表
	 * @throws Exception
	 */
	public ArrayList<Pgv02031> LoadBySwid(Pgv02031 bean) throws Exception;
}
