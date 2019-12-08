package com.sunway.service.impl;

import java.util.ArrayList;
import com.sunway.dao.IPgt02057DAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPgt02057Service;
import com.sunway.vo.Pgt02057;
import com.sunway.vo.Pgv02057;

/**
 * @category 收益法资本化率
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02057Service extends BaseDAO implements IPgt02057Service {

	private IPgt02057DAO t02057Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02057Service#GetDeleteCommand(com.sunway.vo.Pgt02057)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02057 zbhl) throws Exception {
		return t02057Dao.GetDeleteCommand(zbhl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02057Service#GetInsertCommand(com.sunway.vo.Pgt02057)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02057 zbhl) throws Exception {
		return t02057Dao.GetInsertCommand(zbhl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02057Service#GetUpdateCommand(com.sunway.vo.Pgt02057)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02057 zbhl) throws Exception {
		return t02057Dao.GetUpdateCommand(zbhl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02057Service#LoadAll(com.sunway.vo.Pgv02057)
	 */
	@Override
	public ArrayList<Pgv02057> LoadAll(Pgv02057 zbhl) throws Exception {
		return t02057Dao.LoadAll(zbhl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02057Service#LoadByPrimaryKey(com.sunway.vo.Pgt02057)
	 */
	@Override
	public Pgt02057 LoadByPrimaryKey(Pgt02057 zbhl) throws Exception {
		return t02057Dao.LoadByPrimaryKey(zbhl);
	}

	/**
	 * @return the t02057Dao
	 */
	public IPgt02057DAO getT02057Dao() {
		return t02057Dao;
	}

	/**
	 * @param t02057Dao the t02057Dao to set
	 */
	public void setT02057Dao(IPgt02057DAO t02057Dao) {
		this.t02057Dao = t02057Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02057Service#ExecuteParamCopy(com.sunway.vo.Pgt02057)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt02057 zbhl) throws Exception {
		return t02057Dao.ExecuteParamCopy(zbhl);
	}

}
