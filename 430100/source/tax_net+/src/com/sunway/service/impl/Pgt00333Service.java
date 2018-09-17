/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00333DAO;
import com.sunway.service.IPgt00333Service;
import com.sunway.vo.Pgt00333;

/**
 * 
 * 市場法个案评税其它修正参数表
 * @author Andy.Gao
 *
 */
public class Pgt00333Service implements IPgt00333Service {

	private IPgt00333DAO t00333Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00333Service#GetDeleteCommand(com.sunway.vo.Pgt00333)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00333 bean) throws Exception {
		return t00333Dao.GetDeleteCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00333Service#GetInsertCommand(com.sunway.vo.Pgt00333)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00333 bean) throws Exception {
		return t00333Dao.GetInsertCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00333Service#GetUpdateCommand(com.sunway.vo.Pgt00333)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00333 bean) throws Exception {
		return t00333Dao.GetUpdateCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00333Service#LoadAll(com.sunway.vo.Pgt00333)
	 */
	@Override
	public ArrayList<Pgt00333> LoadAll(Pgt00333 bean) throws Exception {
		return t00333Dao.LoadAll(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00333Service#LoadByPrimaryKey(com.sunway.vo.Pgt00333)
	 */
	@Override
	public Pgt00333 LoadByPrimaryKey(Pgt00333 bean) throws Exception {
		return t00333Dao.LoadByPrimaryKey(bean);
	}

	/**
	 * @param t00333Dao the t00333Dao to set
	 */
	public void setT00333Dao(IPgt00333DAO t00333Dao) {
		this.t00333Dao = t00333Dao;
	}

	/**
	 * @return the t00333Dao
	 */
	public IPgt00333DAO getT00333Dao() {
		return t00333Dao;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00333Service#GetModifyCommand(com.sunway.vo.Pgt00333)
	 */
	@Override
	public boolean GetModifyCommand(Pgt00333 bean) throws Exception {
		return t00333Dao.GetModifyCommand(bean);
	}

}
