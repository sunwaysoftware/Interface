/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pgt00334;

/**
 * 
 * 市场法参与评税的实例库
 * @author Andy.Gao
 *
 */
public interface IPgt00334DAO {
	/**
	 * 进行数据提取操作
	 * @param bean 评税的房產编码[FCID], 评税时点[PSSD]
	 * @return 數據列表
	 * @throws Exception
	 */
	public ArrayList<Pgt00334> LoadAll(Pgt00334 bean) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @param bean 评税的房產编码[FCID], 评税时点[PSSD]
	 * @return 數據列表
	 * @throws Exception
	 */
	public ArrayList<Pgt00334> LoadAll_B(Pgt00334 bean) throws Exception;
	
}
