/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt00335;

/**
 * @author Andy.Gao
 *
 */
public interface IPgt00335Service {
	/**
	 * 进行数据提取操作
	 * @param bean 评税的房產编码[FCID], 评税时点[PSSD]
	 * @return 數據列表
	 * @throws Exception
	 */
	public ArrayList<Pgt00335> LoadAll(Pgt00335 bean) throws Exception;
}
