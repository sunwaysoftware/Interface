/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;
import com.sunway.dao.IPgt02055DAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPgt02055Service;
import com.sunway.vo.Pgt02055;
import com.sunway.vo.Pgv02055;

/**
 * @category 收益年限维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02055Service extends BaseDAO implements IPgt02055Service {

	private IPgt02055DAO t02055Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02055Service#GetDeleteCommand(com.sunway.vo.Pgt02055)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02055 synx) throws Exception {
		return t02055Dao.GetDeleteCommand(synx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02055Service#GetInsertCommand(com.sunway.vo.Pgt02055)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02055 synx) throws Exception {
		return t02055Dao.GetInsertCommand(synx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02055Service#GetUpdateCommand(com.sunway.vo.Pgt02055)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02055 synx) throws Exception {
		return t02055Dao.GetUpdateCommand(synx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02055Service#LoadAll(com.sunway.vo.Pgv02055)
	 */
	@Override
	public ArrayList<Pgv02055> LoadAll(Pgv02055 synx) throws Exception {
		return t02055Dao.LoadAll(synx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02055Service#LoadByPrimaryKey(com.sunway.vo.Pgt02055)
	 */
	@Override
	public Pgt02055 LoadByPrimaryKey(Pgt02055 synx) throws Exception {
		return t02055Dao.LoadByPrimaryKey(synx);
	}

	/**
	 * @return the t02055Dao
	 */
	public IPgt02055DAO getT02055Dao() {
		return t02055Dao;
	}

	/**
	 * @param t02055Dao the t02055Dao to set
	 */
	public void setT02055Dao(IPgt02055DAO t02055Dao) {
		this.t02055Dao = t02055Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02055Service#ExecuteParamCopy(com.sunway.vo.Pgt02055)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt02055 synx) throws Exception {
		return t02055Dao.ExecuteParamCopy(synx);
	}

}
