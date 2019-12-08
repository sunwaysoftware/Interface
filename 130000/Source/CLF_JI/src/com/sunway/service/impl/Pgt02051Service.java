/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt02051DAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPgt02051Service;
import com.sunway.vo.Pgt02051;
import com.sunway.vo.Pgv02051;

/**
 * @category 收益法房屋朝向修正
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02051Service extends BaseDAO implements IPgt02051Service {

	private IPgt02051DAO t02051Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02051Service#GetDeleteCommand(com.sunway.vo.Pgt02051)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02051 fwcx) throws Exception {
		return t02051Dao.GetDeleteCommand(fwcx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02051Service#GetInsertCommand(com.sunway.vo.Pgt02051)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02051 fwcx) throws Exception {
		return t02051Dao.GetInsertCommand(fwcx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02051Service#GetUpdateCommand(com.sunway.vo.Pgt02051)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02051 fwcx) throws Exception {
		return t02051Dao.GetUpdateCommand(fwcx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02051Service#LoadAll(com.sunway.vo.Pgv02051)
	 */
	@Override
	public ArrayList<Pgv02051> LoadAll(Pgv02051 fwcx) throws Exception {
		return t02051Dao.LoadAll(fwcx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02051Service#LoadByPrimaryKey(com.sunway.vo.Pgt02051)
	 */
	@Override
	public Pgt02051 LoadByPrimaryKey(Pgt02051 fwcx) throws Exception {
		return t02051Dao.LoadByPrimaryKey(fwcx);
	}

	/**
	 * @return the t02051Dao
	 */
	public IPgt02051DAO getT02051Dao() {
		return t02051Dao;
	}

	/**
	 * @param t02051Dao the t02051Dao to set
	 */
	public void setT02051Dao(IPgt02051DAO t02051Dao) {
		this.t02051Dao = t02051Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02051Service#ExecuteParamCopy(com.sunway.vo.Pgt02051)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt02051 fwcx) throws Exception {
		return t02051Dao.ExecuteParamCopy(fwcx);
	}

}
