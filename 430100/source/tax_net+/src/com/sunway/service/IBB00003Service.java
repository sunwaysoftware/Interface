/**
 * 
 */
package com.sunway.service;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.BF00003;

/**
 * 
 * 价格走势分析图
 * @author Lee
 *
 */
public interface IBB00003Service {

	/**
	 * 价格走势分析图
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BF00003> LoadAll(BF00003 bean) throws Exception;
	
	public OutputStream ExportData(BF00003 bean) throws Exception;
	
	public ArrayList<BF00003> LoadAll02(BF00003 bean) throws Exception;
	
	public OutputStream ExportData02(BF00003 bean) throws Exception;
	
}
