/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Pssd;

/**
 * 
 * 所在区域PSSD
 * @author lEE
 *
 */
public interface IPssd9DAO {

	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pssd> LoadAllPssd(Pssd pssd) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return 数据列表
	 * @throws Exception
	 */
	public ArrayList<Pssd> LoadAllPssdNoSzqy(Pssd pssd) throws Exception;
	
}
