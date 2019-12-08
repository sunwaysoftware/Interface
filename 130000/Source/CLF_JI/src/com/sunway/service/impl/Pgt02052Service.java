/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;
import com.sunway.dao.IPgt02052DAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPgt02052Service;
import com.sunway.vo.Pgt02052;
import com.sunway.vo.Pgv02052;

/**
 * @category 收益法楼层修正
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02052Service extends BaseDAO implements IPgt02052Service {

	private IPgt02052DAO t02052Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02052Service#GetDeleteCommand(com.sunway.vo.Pgt02052)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02052 lc) throws Exception {
		return t02052Dao.GetDeleteCommand(lc);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02052Service#GetInsertCommand(com.sunway.vo.Pgt02052)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02052 lc) throws Exception {
		return t02052Dao.GetInsertCommand(lc);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02052Service#GetUpdateCommand(com.sunway.vo.Pgt02052)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02052 lc) throws Exception {
		return t02052Dao.GetUpdateCommand(lc);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02052Service#LoadAll(com.sunway.vo.Pgv02052)
	 */
	@Override
	public ArrayList<Pgv02052> LoadAll(Pgv02052 lc) throws Exception {
		return t02052Dao.LoadAll(lc);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02052Service#LoadByPrimaryKey(com.sunway.vo.Pgt02052)
	 */
	@Override
	public Pgt02052 LoadByPrimaryKey(Pgt02052 lc) throws Exception {
		return t02052Dao.LoadByPrimaryKey(lc);
	}

	/**
	 * @return the t02052Dao
	 */
	public IPgt02052DAO getT02052Dao() {
		return t02052Dao;
	}

	/**
	 * @param t02052Dao the t02052Dao to set
	 */
	public void setT02052Dao(IPgt02052DAO t02052Dao) {
		this.t02052Dao = t02052Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02052Service#ExecuteParamCopy(com.sunway.vo.Pgt02052)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt02052 lc) throws Exception {
		return t02052Dao.ExecuteParamCopy(lc);
	}

}
