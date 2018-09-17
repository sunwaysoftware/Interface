/**
 * 
 */
package com.sunway.dao;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.BFV00006;

/**
 * 
 * 统计：征收单位
 * @author Amani
 *
 */
public interface ITj00001DAO {

	/**
	 * 查询数据
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BFV00006> LoadAll(BFV00006 bean) throws Exception;
	
	public ArrayList<BFV00006> LoadAll02(BFV00006 bean) throws Exception;
	
	/**
	 * 导出数据
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public OutputStream ExportData(BFV00006 bean) throws Exception;
	
	public OutputStream ExportData02(BFV00006 bean) throws Exception;
	
}
