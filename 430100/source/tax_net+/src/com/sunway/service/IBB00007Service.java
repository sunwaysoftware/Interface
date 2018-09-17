package com.sunway.service;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.BF00007;

/**
 * 年度湘潭市存量房交易纳税评估已开票完税统计表
 * @author Light
 *
 */
public interface IBB00007Service {

	/**
	 * 数据查询
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BF00007> LoadAll(BF00007 bean)throws Exception;
	
	/**
	 * 数据导出
	 * @param bean
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public OutputStream ExportData(BF00007 bean, String fileName)throws Exception;
}
