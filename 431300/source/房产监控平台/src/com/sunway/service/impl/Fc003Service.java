/**
 * 
 */
package com.sunway.service.impl;

import java.io.InputStream;

import com.sunway.dao.IFc003DAO;
import com.sunway.service.IFc003Service;

/**
 * @author Amani
 *
 */
public class Fc003Service implements IFc003Service {

	private IFc003DAO fc003Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IFc003Service#insData(int, java.lang.String, java.lang.String, java.io.InputStream)
	 */
	@Override
	public boolean insData(int id, String slid, String ssqy, InputStream image)	throws Exception {
		return fc003Dao.insData(id, slid, ssqy, image);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IFc003Service#readData(int)
	 */
	@Override
	public InputStream readData(int id) throws Exception {
		return fc003Dao.readData(id);
	}

	/**
	 * @return the fc003Dao
	 */
	public IFc003DAO getFc003Dao() {
		return fc003Dao;
	}

	/**
	 * @param fc003Dao the fc003Dao to set
	 */
	public void setFc003Dao(IFc003DAO fc003Dao) {
		this.fc003Dao = fc003Dao;
	}

}
