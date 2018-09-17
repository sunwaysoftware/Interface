/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IWBJH00DAO;
import com.sunway.service.IWBJH00Service;
import com.sunway.vo.WBJH00000;

/**
 * @author Amani
 *
 */
public class WBJH00Service implements IWBJH00Service {

	private IWBJH00DAO wbjh00Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IWBJH00Service#InsGT3WBJH(java.lang.String)
	 */
	@Override
	public Boolean InsGT3WBJH(String fcid) throws Exception {
		return wbjh00Dao.InsGT3WBJH(fcid);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IWBJH00Service#InsGT3WBJH(java.lang.String)
	 */
	@Override
	public Boolean InsGT3WBJHSY(String fcid) throws Exception {
		return wbjh00Dao.InsGT3WBJHSY(fcid);
	}	

	/* (non-Javadoc)
	 * @see com.sunway.service.IWBJH00Service#GetGT3WSXX(java.lang.String)
	 */
	@Override
	public ArrayList<WBJH00000> GetGT3WSXX(WBJH00000 gt3) throws Exception {
		return wbjh00Dao.GetGT3WSXX(gt3);
	}

	/**
	 * @return the wbjh00Dao
	 */
	public IWBJH00DAO getWbjh00Dao() {
		return wbjh00Dao;
	}

	/**
	 * @param wbjh00Dao the wbjh00Dao to set
	 */
	public void setWbjh00Dao(IWBJH00DAO wbjh00Dao) {
		this.wbjh00Dao = wbjh00Dao;
	}

	@Override
	public String FindCode(String root, String code) throws Exception {
		return wbjh00Dao.FindCode(root, code);
	}

	/**
	 * 根据纳税人识别号读取企业登记信息
	 * @param wbjh 纳税人识别号
	 * @return 企业信息数据集
	 * @throws Exception
	 */
	public ArrayList<WBJH00000> LoadQyxx(WBJH00000 wbjh) throws Exception {
		return wbjh00Dao.LoadQyxx(wbjh);
	}
	
}
