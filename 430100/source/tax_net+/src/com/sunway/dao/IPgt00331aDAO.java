/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt00331a;

/**
 * @author Andy.Gao
 *
 */
public interface IPgt00331aDAO {
	/**
	 * 进行数据提取操作
	 * @param bean 评税的房產编码[FCID]
	 * @return 數據列表
	 * @throws Exception
	 */
	public ArrayList<Pgt00331a> LoadAll(Pgt00331a bean) throws Exception;
}
