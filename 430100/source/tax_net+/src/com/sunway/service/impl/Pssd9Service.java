/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPssd9DAO;
import com.sunway.service.IPssd9Service;
import com.sunway.vo.Pssd;

/**
 * @author one
 *
 */
public class Pssd9Service implements IPssd9Service {

	private IPssd9DAO pssd9Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPssd9Service#LoadAllPssd(com.sunway.vo.Pssd)
	 */
	@Override
	public ArrayList<Pssd> LoadAllPssd(Pssd pssd) throws Exception {
		// TODO Auto-generated method stub
		return pssd9Dao.LoadAllPssd(pssd);
	}

	/**
	 * @return the pssd9Dao
	 */
	public IPssd9DAO getPssd9Dao() {
		return pssd9Dao;
	}

	/**
	 * @param pssd9Dao the pssd9Dao to set
	 */
	public void setPssd9Dao(IPssd9DAO pssd9Dao) {
		this.pssd9Dao = pssd9Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPssd9Service#LoadAllPssdNoSzqy(com.sunway.vo.Pssd)
	 */
	@Override
	public ArrayList<Pssd> LoadAllPssdNoSzqy(Pssd pssd) throws Exception {
		return pssd9Dao.LoadAllPssdNoSzqy(pssd);
	}

}
