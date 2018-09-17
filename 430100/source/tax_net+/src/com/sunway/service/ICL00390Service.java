/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.BF00000;
import com.sunway.vo.Pgv00331;

/**
 * @author Andy.Gao
 *
 */
public interface ICL00390Service {

	/**
	 * 读取申报表处理数据列表
	 * @param bean SWID, NSRMC
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00331> LoadSb(Pgv00331 bean) throws Exception;
	
	/**
	 * 读取交税处理数据列表
	 * @param bean SWID, NSRMC
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00331> LoadJs(Pgv00331 bean) throws Exception;
	
	/**
	 * 交税标识认定
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Boolean execRD(Pgv00331 bean) throws Exception;
	
	/**
	 * 打印通知书
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BF00000> execTzs(BF00000 bean) throws Exception;

}
