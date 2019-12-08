/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.BFV00006;

/**
 * 
 * 统计：征收单位
 * @author Amani
 *
 */
public interface ITj00001Service {


	/**
	 * 查询数据
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BFV00006> LoadAll(BFV00006 bean) throws Exception;
	
	/**
	 * 导出数据
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BFV00006> ExportData(BFV00006 bean) throws Exception;
	
}
