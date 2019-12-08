/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt00335a;

/**
 * 
 * 市场法个案参与评估的实例库其它修正
 * @author Andy.Gao
 *
 */
public interface IPgt00335aDAO {
	/**
	 * 进行数据提取操作
	 * @param bean 评税的房產编码[FCID], 评税时点[PSSD]
	 * @return 數據列表
	 * @throws Exception
	 */
	public ArrayList<Pgt00335a> LoadAll(Pgt00335a bean) throws Exception;
}
