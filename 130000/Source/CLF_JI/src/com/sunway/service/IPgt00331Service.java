/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt00331;
import com.sunway.vo.Pgv00331;

/**
 * 
 * 市场法评税结果
 * @author Andy.Gao
 *
 */
public interface IPgt00331Service {
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00331 LoadByPrimaryKey(Pgt00331 bean) throws Exception;
	
	
	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt00331 LoadByPrimaryKey_B(Pgt00331 bean) throws Exception;
	
	/**
	 * 根據SWID讀取評估結果列表 
	 * @param bean 頁面序引[pageIndex], 頁面大小[pageSize], 稅務編碼[SWID], 評稅時點[PSSD]
	 * @return 評估結果列表
	 * @throws Exception
	 */
	public ArrayList<Pgv00331> LoadBySwid(Pgv00331 bean) throws Exception;
}
