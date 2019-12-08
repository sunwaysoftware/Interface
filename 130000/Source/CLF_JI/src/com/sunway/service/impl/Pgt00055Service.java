/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;
import com.sunway.dao.IPgt00055DAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPgt00055Service;
import com.sunway.vo.Pgt00055;

/**
 * @author Lee
 *
 */
public class Pgt00055Service extends BaseDAO implements IPgt00055Service {

	private IPgt00055DAO t00055Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00055Service#GetDeleteCommand(com.sunway.vo.Pgt00055)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00055 t00055) throws Exception {
		return t00055Dao.GetDeleteCommand(t00055);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00055Service#GetInsertCommand(com.sunway.vo.Pgt00055)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00055 t00055) throws Exception {
		return t00055Dao.GetInsertCommand(t00055);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00055Service#GetUpdateCommand(com.sunway.vo.Pgt00055)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00055 t00055) throws Exception {
		return t00055Dao.GetUpdateCommand(t00055);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00055Service#LoadAll(com.sunway.vo.Pgv00055)
	 */
	@Override
	public ArrayList<Pgt00055> LoadAll() throws Exception {
		return t00055Dao.LoadAll();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00055Service#LoadByPrimaryKey(com.sunway.vo.Pgt00055)
	 */
	@Override
	public Pgt00055 LoadByPrimaryKey(Pgt00055 t00055) throws Exception {
		return t00055Dao.LoadByPrimaryKey(t00055);
	}

	/**
	 * @return the t00055Dao
	 */
	public IPgt00055DAO getT00055Dao() {
		return t00055Dao;
	}

	/**
	 * @param t00055Dao the t00055Dao to set
	 */
	public void setT00055Dao(IPgt00055DAO t00055Dao) {
		this.t00055Dao = t00055Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00055Service#validateZjlx(com.sunway.vo.Pgt00055)
	 */
	@Override
	public boolean validateZjlx(Pgt00055 t00055) throws Exception {
		return t00055Dao.validateZjlx(t00055);
	}

}
