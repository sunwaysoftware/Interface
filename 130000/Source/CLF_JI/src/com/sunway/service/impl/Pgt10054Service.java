package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt10054DAO;
import com.sunway.service.IPgt10054Service;
import com.sunway.vo.Pgt10054;
import com.sunway.vo.Pgv10054;

/**
 * @category 成本法容积率
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt10054Service implements IPgt10054Service {

	private IPgt10054DAO t10054Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10054Service#GetDeleteCommand(com.sunway.vo.Pgt10054)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt10054 rjl) throws Exception {
		return t10054Dao.GetDeleteCommand(rjl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10054Service#GetInsertCommand(com.sunway.vo.Pgt10054)
	 */
	@Override
	public boolean GetInsertCommand(Pgt10054 rjl) throws Exception {
		return t10054Dao.GetInsertCommand(rjl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10054Service#GetUpdateCommand(com.sunway.vo.Pgt10054)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt10054 rjl) throws Exception {
		return t10054Dao.GetUpdateCommand(rjl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10054Service#LoadAll(com.sunway.vo.Pgv10054)
	 */
	@Override
	public ArrayList<Pgv10054> LoadAll(Pgv10054 rjl) throws Exception {
		return t10054Dao.LoadAll(rjl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10054Service#LoadByPrimaryKey(com.sunway.vo.Pgt10054)
	 */
	@Override
	public Pgt10054 LoadByPrimaryKey(Pgt10054 rjl) throws Exception {
		return t10054Dao.LoadByPrimaryKey(rjl);
	}

	/**
	 * @return the t10054Dao
	 */
	public IPgt10054DAO getT10054Dao() {
		return t10054Dao;
	}

	/**
	 * @param t10054Dao the t10054Dao to set
	 */
	public void setT10054Dao(IPgt10054DAO t10054Dao) {
		this.t10054Dao = t10054Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10054Service#ExecuteParamCopy(com.sunway.vo.Pgt10054)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt10054 rjl) throws Exception {
		return t10054Dao.ExecuteParamCopy(rjl);
	}

}
