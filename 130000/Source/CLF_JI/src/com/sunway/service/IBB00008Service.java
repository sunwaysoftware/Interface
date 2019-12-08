package com.sunway.service;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.BF00008;

/**
 * 交易纳税评估分区域统计表
 * @author Light
 *
 */
public interface IBB00008Service {

	/**
	 * 数据查询
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BF00008> LoadAll(BF00008 bean)throws Exception;
	
	/**
	 * 数据导出
	 * @param bean
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public OutputStream ExportData(BF00008 bean, String fileName)throws Exception;
}
