package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00365DAO;
import com.sunway.service.IPgt00365Service;
import com.sunway.vo.Pgt00365;

public class Pgt00365Service implements IPgt00365Service {
	private IPgt00365DAO t00365Dao;

	public IPgt00365DAO getT00365Dao() {
		return t00365Dao;
	}

	public void setT00365Dao(IPgt00365DAO t00365Dao) {
		this.t00365Dao = t00365Dao;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00364Service#GetDeleteCommand(com.sunway.vo.Pgt00364)
	 */
	public boolean GetDeleteCommand(Pgt00365 bean) throws Exception {
		return t00365Dao.GetDeleteCommand(bean);
	}


	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00364Service#GetInsertCommand(com.sunway.vo.Pgt00364)
	 */
	public boolean GetInsertCommand(Pgt00365 bean) throws Exception {
		return t00365Dao.GetInsertCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00364Service#GetUpdateCommand(com.sunway.vo.Pgt00364)
	 */
	public boolean GetUpdateCommand(Pgt00365 bean) throws Exception {
		return t00365Dao.GetUpdateCommand(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00364Service#LoadAll(com.sunway.vo.Pgt00364)
	 */
	public ArrayList<Pgt00365> LoadAll(Pgt00365 bean) throws Exception {
		return t00365Dao.LoadAll(bean);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00364Service#LoadByPrimaryKey(com.sunway.vo.Pgt00364)
	 */
	public Pgt00365 LoadByPrimaryKey(Pgt00365 bean) throws Exception {
		return t00365Dao.LoadByPrimaryKey(bean);
	}

	
	
	
}
