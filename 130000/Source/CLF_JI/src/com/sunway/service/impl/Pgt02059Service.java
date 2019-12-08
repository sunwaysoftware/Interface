/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;
import com.sunway.dao.IPgt02059DAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPgt02059Service;
import com.sunway.vo.Pgt02059;
import com.sunway.vo.Pgv02059;

/**
 * @category 收益法租金标准
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02059Service extends BaseDAO implements IPgt02059Service {

	private IPgt02059DAO t02059Dao;
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02059Service#GetDeleteCommand(com.sunway.vo.Pgt02059)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02059 zjbz) throws Exception {
		return t02059Dao.GetDeleteCommand(zjbz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02059Service#GetInsertCommand(com.sunway.vo.Pgt02059)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02059 zjbz) throws Exception {
		return t02059Dao.GetInsertCommand(zjbz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02059Service#GetUpdateCommand(com.sunway.vo.Pgt02059)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02059 zjbz) throws Exception {
		return t02059Dao.GetUpdateCommand(zjbz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02059Service#LoadAll(com.sunway.vo.Pgv02059)
	 */
	@Override
	public ArrayList<Pgv02059> LoadAll(Pgv02059 zjbz) throws Exception {
		return t02059Dao.LoadAll(zjbz);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02059Service#LoadByPrimaryKey(com.sunway.vo.Pgt02059)
	 */
	@Override
	public Pgt02059 LoadByPrimaryKey(Pgt02059 zjbz) throws Exception {
		return t02059Dao.LoadByPrimaryKey(zjbz);
	}

	/**
	 * @return the t02059Dao
	 */
	public IPgt02059DAO getT02059Dao() {
		return t02059Dao;
	}

	/**
	 * @param t02059Dao the t02059Dao to set
	 */
	public void setT02059Dao(IPgt02059DAO t02059Dao) {
		this.t02059Dao = t02059Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02059Service#ExecuteParamCopy(com.sunway.vo.Pgt02059)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt02059 zjbz) throws Exception {
		return t02059Dao.ExecuteParamCopy(zjbz);
	}

}
