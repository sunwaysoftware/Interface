/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.ICz00001DAO;
import com.sunway.service.ICz00001Service;
import com.sunway.vo.CZ00001;

/**
 * 
 * 操作类型
 * @author Andy.Gao
 *
 */
public class Cz00001Service implements ICz00001Service {

	private ICz00001DAO cz00001Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.ICz00001Service#LoadAll()
	 */
	@Override
	public ArrayList<CZ00001> LoadAll() throws Exception {
		return cz00001Dao.LoadAll();
	}

	/**
	 * @param cz00001Dao the cz00001Dao to set
	 */
	public void setCz00001Dao(ICz00001DAO cz00001Dao) {
		this.cz00001Dao = cz00001Dao;
	}

	/**
	 * @return the cz00001Dao
	 */
	public ICz00001DAO getCz00001Dao() {
		return cz00001Dao;
	}

}
