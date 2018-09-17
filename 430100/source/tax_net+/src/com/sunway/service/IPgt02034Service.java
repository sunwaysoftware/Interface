/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt02034;

/**
 * 
 * 市场法参与评税的实例库
 * @author Andy.Gao
 *
 */
public interface IPgt02034Service {
	/**
	 * 进行数据提取操作
	 * @param bean 评税的房產编码[FCID], 评税时点[PSSD]
	 * @return 數據列表
	 * @throws Exception
	 */
	public ArrayList<Pgt02034> LoadAll(Pgt02034 bean) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @param bean 评税的房產编码[FCID], 评税时点[PSSD]
	 * @return 數據列表
	 * @throws Exception
	 */
	public ArrayList<Pgt02034> LoadAll_B(Pgt02034 bean) throws Exception;
}
