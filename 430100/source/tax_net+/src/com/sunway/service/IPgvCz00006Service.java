/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.PgvCz00006;

/**
 * 
 * 变更类型
 * @author Andy.Gao
 *
 */
public interface IPgvCz00006Service {

	/**
	 * 读取[变更类型]修改
	 * @return
	 * @throws Exception
	 */
	public ArrayList<PgvCz00006> LoadByUpdate() throws Exception;
	
	/**
	 * 读取[变更类型]删除
	 * @return
	 * @throws Exception
	 */
	public ArrayList<PgvCz00006> LoadByDelete() throws Exception;
}
