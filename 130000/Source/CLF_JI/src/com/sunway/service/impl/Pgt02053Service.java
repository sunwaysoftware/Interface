package com.sunway.service.impl;

import java.util.ArrayList;
import com.sunway.dao.IPgt02053DAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPgt02053Service;
import com.sunway.vo.Pgt02053;
import com.sunway.vo.Pgv02053;

/**
 * @category 收益法面积修正
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02053Service extends BaseDAO implements IPgt02053Service {

	private IPgt02053DAO t02053Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02053Service#GetDeleteCommand(com.sunway.vo.Pgt02053)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02053 mj) throws Exception {
		return t02053Dao.GetDeleteCommand(mj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02053Service#GetInsertCommand(com.sunway.vo.Pgt02053)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02053 mj) throws Exception {
		return t02053Dao.GetInsertCommand(mj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02053Service#GetUpdateCommand(com.sunway.vo.Pgt02053)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02053 mj) throws Exception {
		return t02053Dao.GetUpdateCommand(mj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02053Service#LoadAll(com.sunway.vo.Pgv02053)
	 */
	@Override
	public ArrayList<Pgv02053> LoadAll(Pgv02053 mj) throws Exception {
		return t02053Dao.LoadAll(mj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02053Service#LoadByPrimaryKey(com.sunway.vo.Pgt02053)
	 */
	@Override
	public Pgt02053 LoadByPrimaryKey(Pgt02053 mj) throws Exception {
		return t02053Dao.LoadByPrimaryKey(mj);
	}

	/**
	 * @return the t02053Dao
	 */
	public IPgt02053DAO getT02053Dao() {
		return t02053Dao;
	}

	/**
	 * @param t02053Dao the t02053Dao to set
	 */
	public void setT02053Dao(IPgt02053DAO t02053Dao) {
		this.t02053Dao = t02053Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02053Service#ExecuteParamCopy(com.sunway.vo.Pgt02053)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt02053 mj) throws Exception {
		return t02053Dao.ExecuteParamCopy(mj);
	}

}
