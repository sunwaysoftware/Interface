package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12051DAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPgt12051Service;
import com.sunway.vo.Pgt12051;
import com.sunway.vo.Pgv12051;

/**
 * @category 免税比例维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt12051Service extends BaseDAO implements IPgt12051Service {

	private IPgt12051DAO t12051Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12051Service#GetDeleteCommand(com.sunway.vo.Pgt12051)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt12051 msbl) throws Exception {
		return t12051Dao.GetDeleteCommand(msbl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12051Service#GetInsertCommand(com.sunway.vo.Pgt12051)
	 */
	@Override
	public boolean GetInsertCommand(Pgt12051 msbl) throws Exception {
		return t12051Dao.GetInsertCommand(msbl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12051Service#GetUpdateCommand(com.sunway.vo.Pgt12051)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt12051 msbl) throws Exception {
		return t12051Dao.GetUpdateCommand(msbl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12051Service#LoadAll(com.sunway.vo.Pgv12051)
	 */
	@Override
	public ArrayList<Pgv12051> LoadAll(Pgv12051 msbl) throws Exception {
		return t12051Dao.LoadAll(msbl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12051Service#LoadByPrimaryKey(com.sunway.vo.Pgt12051)
	 */
	@Override
	public Pgt12051 LoadByPrimaryKey(Pgt12051 msbl) throws Exception {
		return t12051Dao.LoadByPrimaryKey(msbl);
	}

	/**
	 * @return the t12051Dao
	 */
	public IPgt12051DAO getT12051Dao() {
		return t12051Dao;
	}

	/**
	 * @param t12051Dao the t12051Dao to set
	 */
	public void setT12051Dao(IPgt12051DAO t12051Dao) {
		this.t12051Dao = t12051Dao;
	}

}
