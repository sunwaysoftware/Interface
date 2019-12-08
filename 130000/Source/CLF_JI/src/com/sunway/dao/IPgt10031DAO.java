/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt10031;
import com.sunway.vo.Pgv10031;

/**
 * 
 * 成本法评税结果
 * @author Andy.Gao
 *
 */
public interface IPgt10031DAO {

	/**
	 * 根据PK进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public Pgt10031 LoadByPrimaryKey(Pgt10031 bean) throws Exception;
	
	/**
	 * 根據SWID讀取評估結果列表 
	 * @param bean 頁面序引[pageIndex], 頁面大小[pageSize], 稅務編碼[SWID], 評稅時點[PSSD]
	 * @return 評估結果列表
	 * @throws Exception
	 */
	public ArrayList<Pgv10031> LoadBySwid(Pgv10031 bean) throws Exception;
}
