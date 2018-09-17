/**
 * 
 */
package com.sunway.service;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.BF00001;

/**
 * 
 * 正常评估查询
 * @author Lee
 *
 */
public interface IBB00001Service {

	/**
	 * 正常评估查询
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BF00001> LoadAll(BF00001 bean) throws Exception;
	
	public OutputStream ExportData(BF00001 bean) throws Exception;
	
	public ArrayList<BF00001> LoadAll02(BF00001 bean) throws Exception;
	
	public OutputStream ExportData02(BF00001 bean) throws Exception;
	
}
