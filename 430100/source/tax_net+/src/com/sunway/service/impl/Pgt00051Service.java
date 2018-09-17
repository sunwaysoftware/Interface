package com.sunway.service.impl;

import java.util.ArrayList;
import com.sunway.dao.IPgt00051DAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPgt00051Service;
import com.sunway.vo.Pgt00051;
import com.sunway.vo.Pgv00051;

/**
 * @category 税率指数
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00051Service extends BaseDAO implements IPgt00051Service {

	private IPgt00051DAO t00051Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00051Service#GetDeleteCommand(com.sunway.vo.Pgt00051)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00051 slzs) throws Exception {
		return t00051Dao.GetDeleteCommand(slzs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00051Service#GetInsertCommand(com.sunway.vo.Pgt00051)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00051 slzs) throws Exception {
		return t00051Dao.GetInsertCommand(slzs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00051Service#GetUpdateCommand(com.sunway.vo.Pgt00051)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00051 slzs) throws Exception {
		return t00051Dao.GetUpdateCommand(slzs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00051Service#LoadAll()
	 */
	@Override
	public ArrayList<Pgv00051> LoadAll(Pgv00051 slzs) throws Exception {
		return t00051Dao.LoadAll(slzs);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00051Service#LoadByPrimaryKey(com.sunway.vo.Pgt00051)
	 */
	@Override
	public Pgt00051 LoadByPrimaryKey(Pgt00051 slzs) throws Exception {
		return t00051Dao.LoadByPrimaryKey(slzs);
	}

	/**
	 * @return the t00051Dao
	 */
	public IPgt00051DAO getT00051Dao() {
		return t00051Dao;
	}

	/**
	 * @param t00051Dao the t00051Dao to set
	 */
	public void setT00051Dao(IPgt00051DAO t00051Dao) {
		this.t00051Dao = t00051Dao;
	}

}
