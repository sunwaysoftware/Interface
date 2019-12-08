/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt10031DAO;
import com.sunway.service.IPgt10031Service;
import com.sunway.vo.Pgt10031;
import com.sunway.vo.Pgv10031;

/**
 * 
 * 成本法评税结果
 * @author Andy.Gao
 *
 */
public class Pgt10031Service implements IPgt10031Service {

	private IPgt10031DAO t10031Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10031Service#LoadByPrimaryKey(com.sunway.vo.Pgt10031)
	 */
	@Override
	public Pgt10031 LoadByPrimaryKey(Pgt10031 bean) throws Exception {
		return t10031Dao.LoadByPrimaryKey(bean);
	}

	/**
	 * @param t10031Dao the t10031Dao to set
	 */
	public void setT10031Dao(IPgt10031DAO t10031Dao) {
		this.t10031Dao = t10031Dao;
	}

	/**
	 * @return the t10031Dao
	 */
	public IPgt10031DAO getT10031Dao() {
		return t10031Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10031Service#LoadBySwid(com.sunway.vo.Pgv10031)
	 */
	@Override
	public ArrayList<Pgv10031> LoadBySwid(Pgv10031 bean) throws Exception {
		return t10031Dao.LoadBySwid(bean);
	}

}
