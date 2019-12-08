package com.sunway.service.impl;

import java.util.ArrayList;
import com.sunway.dao.IPgt10055DAO;
import com.sunway.service.IPgt10055Service;
import com.sunway.vo.Pgt10055;
import com.sunway.vo.Pgv10055;

/**
 * @category 成本法土地基准地价
 * @author Lee
 * @version 1.0	
 *
 */
public class Pgt10055Service implements IPgt10055Service {

	private IPgt10055DAO t10055Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10055Service#GetDeleteCommand(com.sunway.vo.Pgt10055)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt10055 tdjzdj) throws Exception {
		return t10055Dao.GetDeleteCommand(tdjzdj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10055Service#GetInsertCommand(com.sunway.vo.Pgt10055)
	 */
	@Override
	public boolean GetInsertCommand(Pgt10055 tdjzdj) throws Exception {
		return t10055Dao.GetInsertCommand(tdjzdj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10055Service#GetUpdateCommand(com.sunway.vo.Pgt10055)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt10055 tdjzdj) throws Exception {
		return t10055Dao.GetUpdateCommand(tdjzdj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10055Service#LoadAll(com.sunway.vo.Pgv10055)
	 */
	@Override
	public ArrayList<Pgv10055> LoadAll(Pgv10055 tdjzdj) throws Exception {
		return t10055Dao.LoadAll(tdjzdj);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10055Service#LoadByPrimaryKey(com.sunway.vo.Pgt10055)
	 */
	@Override
	public Pgt10055 LoadByPrimaryKey(Pgt10055 tdjzdj) throws Exception {
		return t10055Dao.LoadByPrimaryKey(tdjzdj);
	}

	/**
	 * @return the t10055Dao
	 */
	public IPgt10055DAO getT10055Dao() {
		return t10055Dao;
	}

	/**
	 * @param t10055Dao the t10055Dao to set
	 */
	public void setT10055Dao(IPgt10055DAO t10055Dao) {
		this.t10055Dao = t10055Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10055Service#ExecuteParamCopy(com.sunway.vo.Pgt10055)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt10055 tdjzdj) throws Exception {
		return t10055Dao.ExecuteParamCopy(tdjzdj);
	}

}
