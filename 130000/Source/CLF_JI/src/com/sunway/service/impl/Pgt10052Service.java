package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt10052DAO;
import com.sunway.service.IPgt10052Service;
import com.sunway.vo.Pgt10052;
import com.sunway.vo.Pgv10052;

/**
 * @category 成本法建安造价标准
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt10052Service implements IPgt10052Service {

	private IPgt10052DAO t10052Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10052Service#GetDeleteCommand(com.sunway.vo.Pgt10052)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt10052 jazj) throws Exception {
		return t10052Dao.GetDeleteCommand(jazj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10052Service#GetInsertCommand(com.sunway.vo.Pgt10052)
	 */
	@Override
	public boolean GetInsertCommand(Pgt10052 jazj) throws Exception {
		return t10052Dao.GetInsertCommand(jazj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10052Service#GetUpdateCommand(com.sunway.vo.Pgt10052)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt10052 jazj) throws Exception {
		return t10052Dao.GetUpdateCommand(jazj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10052Service#LoadAll(com.sunway.vo.Pgv10052)
	 */
	@Override
	public ArrayList<Pgv10052> LoadAll(Pgv10052 jazj) throws Exception {
		return t10052Dao.LoadAll(jazj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10052Service#LoadByPrimaryKey(com.sunway.vo.Pgt10052)
	 */
	@Override
	public Pgt10052 LoadByPrimaryKey(Pgt10052 jazj) throws Exception {
		return t10052Dao.LoadByPrimaryKey(jazj);
	}

	/**
	 * @return the t10052Dao
	 */
	public IPgt10052DAO getT10052Dao() {
		return t10052Dao;
	}

	/**
	 * @param t10052Dao the t10052Dao to set
	 */
	public void setT10052Dao(IPgt10052DAO t10052Dao) {
		this.t10052Dao = t10052Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10052Service#ExecuteParamCopy(com.sunway.vo.Pgt10052)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt10052 jazj) throws Exception {
		return t10052Dao.ExecuteParamCopy(jazj);
	}

}
