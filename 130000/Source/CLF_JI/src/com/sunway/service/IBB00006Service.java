package com.sunway.service;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.vo.BF00006;

/**
 * 交易纳税评估数量统计表
 * @author Light
 *
 */
public interface IBB00006Service {

	/**
	 * 数据查询
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BF00006> LoadAll(BF00006 bean)throws Exception;
	
	/**
	 * 数据导出
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public OutputStream ExportData(BF00006 bean, String fileName)throws Exception;
}
