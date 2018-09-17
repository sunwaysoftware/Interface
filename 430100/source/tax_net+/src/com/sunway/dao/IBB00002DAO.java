/**
 * 
 */
package com.sunway.dao;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.BF00002;

/**
 * 
 * 正常评估查询
 * @author Lee
 *
 */
public interface IBB00002DAO {

	/**
	 * 正常评估查询
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BF00002> LoadAll(BF00002 bean) throws Exception;
	
	public OutputStream ExportData(BF00002 bean) throws Exception;
	
	public ArrayList<BF00002> LoadAll02(BF00002 bean) throws Exception;
	
	public OutputStream ExportData02(BF00002 bean) throws Exception;
	
}
