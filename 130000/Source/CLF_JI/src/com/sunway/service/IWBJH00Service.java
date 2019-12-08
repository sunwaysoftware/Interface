/**
 * 
 */
package com.sunway.service;

import java.util.ArrayList;

import com.sunway.vo.Pgt00370;
import com.sunway.vo.WBJH00000;

/**
 * @author Amani
 *
 */
public interface IWBJH00Service {

	/**
	 * 将房产数据存入金税三期外部交换系统
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public Boolean InsGT3WBJH(String fcid) throws Exception;
	
	/**
	 * 读取金税三期完税信息
	 * @param fcid
	 * @return
	 * @throws Exception
	 */
	public Pgt00370 GetGT3WSXX(String fcid, WBJH00000 gt3) throws Exception;
	
	/**
	 * 将存量房代码转换为金三代码
	 * @param code 存量房代码
	 * @return 金三代码
	 * @throws Exception
	 */
	public String FindCode(String root, String code) throws Exception;
	
	/**
	 * 根据纳税人识别号读取企业登记信息
	 * @param wbjh 纳税人识别号
	 * @return 企业信息数据集
	 * @throws Exception
	 */
	public ArrayList<WBJH00000> LoadQyxx(WBJH00000 wbjh) throws Exception;
}
