/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00054DAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.vo.Pgt00054;
import com.sunway.vo.Pgv00054;

/**
 * @author Lee
 *
 */
public class Pgt00054Service extends BaseDAO implements
		com.sunway.service.IPgt00054Service {

	private IPgt00054DAO t00054Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00054Service#GetDeleteCommand(com.sunway.vo.Pgt00054)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00054 t00054) throws Exception {
		return t00054Dao.GetDeleteCommand(t00054);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00054Service#GetInsertCommand(com.sunway.vo.Pgt00054)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00054 t00054) throws Exception {
		return t00054Dao.GetInsertCommand(t00054);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00054Service#GetUpdateCommand(com.sunway.vo.Pgt00054)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00054 t00054) throws Exception {
		return t00054Dao.GetUpdateCommand(t00054);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00054Service#LoadAll(com.sunway.vo.Pgv00054)
	 */
	@Override
	public ArrayList<Pgv00054> LoadAll(Pgv00054 v00054) throws Exception {
		return t00054Dao.LoadAll(v00054);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00054Service#LoadByPrimaryKey(com.sunway.vo.Pgt00054)
	 */
	@Override
	public Pgt00054 LoadByPrimaryKey(Pgt00054 t00054) throws Exception {
		return t00054Dao.LoadByPrimaryKey(t00054);
	}

	/**
	 * @return the t00054Dao
	 */
	public IPgt00054DAO getT00054Dao() {
		return t00054Dao;
	}

	/**
	 * @param t00054Dao the t00054Dao to set
	 */
	public void setT00054Dao(IPgt00054DAO t00054Dao) {
		this.t00054Dao = t00054Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00054Service#LoadAll000541(com.sunway.vo.Pgv00054)
	 */
	@Override
	public ArrayList<Pgv00054> LoadAll000541(Pgv00054 v00054) throws Exception {
		return t00054Dao.LoadAll000541(v00054);
	}

}
