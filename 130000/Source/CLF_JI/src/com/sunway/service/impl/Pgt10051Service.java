/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt10051DAO;
import com.sunway.service.IPgt10051Service;
import com.sunway.vo.Pgt10051;
import com.sunway.vo.Pgv10051;

/**
 * @category 成本法残值率
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt10051Service implements IPgt10051Service {

	private IPgt10051DAO t10051Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10051Service#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt10051 czl) throws Exception {
		return t10051Dao.GetDeleteCommand(czl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10051Service#GetInsertCommand(com.sunway.vo.Pgt10051)
	 */
	@Override
	public boolean GetInsertCommand(Pgt10051 czl) throws Exception {
		return t10051Dao.GetInsertCommand(czl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10051Service#GetUpdateCommand(com.sunway.vo.Pgt10051)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt10051 czl) throws Exception {
		return t10051Dao.GetUpdateCommand(czl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10051Service#LoadAll(com.sunway.vo.Pgv10051)
	 */
	@Override
	public ArrayList<Pgv10051> LoadAll(Pgv10051 czl) throws Exception {
		return t10051Dao.LoadAll(czl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10051Service#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	@Override
	public Pgt10051 LoadByPrimaryKey(Pgt10051 czl) throws Exception {
		return t10051Dao.LoadByPrimaryKey(czl);
	}

	/**
	 * @return the t10051Dao
	 */
	public IPgt10051DAO getT10051Dao() {
		return t10051Dao;
	}

	/**
	 * @param t10051Dao the t10051Dao to set
	 */
	public void setT10051Dao(IPgt10051DAO t10051Dao) {
		this.t10051Dao = t10051Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10051Service#ExecuteParamCopy(com.sunway.vo.Pgt10051)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt10051 czl) throws Exception {
		return t10051Dao.ExecuteParamCopy(czl);
	}

}
