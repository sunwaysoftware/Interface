/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.BF00000;
import com.sunway.vo.Pgv02031;

/**
 * @author Andy.Gao
 *
 */
public interface ICL02090DAO {

	/**
	 * 读取申报表处理数据列表
	 * @param bean SWID, NSRMC
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv02031> LoadSb(Pgv02031 bean) throws Exception;
	
	/**
	 * 读取交税处理数据列表
	 * @param bean SWID, NSRMC
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv02031> LoadJs(Pgv02031 bean) throws Exception;
	
	/**
	 * 交税标识认定
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Boolean execRD(Pgv02031 bean) throws Exception;
	
	/**
	 * 打印通知书
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BF00000> execTzs(BF00000 bean) throws Exception;	
	
}
