package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt12052DAO;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.service.IPgt12052Service;
import com.sunway.vo.Pgt12052;
import com.sunway.vo.Pgv12052;

/**
 * @category 成本法、收益法经济耐用年限指标
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt12052Service extends BaseDAO implements IPgt12052Service {

	private IPgt12052DAO t12052Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12052Service#GetDeleteCommand(com.sunway.vo.Pgt12052)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt12052 jjnynx) throws Exception {
		return t12052Dao.GetDeleteCommand(jjnynx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12052Service#GetInsertCommand(com.sunway.vo.Pgt12052)
	 */
	@Override
	public boolean GetInsertCommand(Pgt12052 jjnynx) throws Exception {
		return t12052Dao.GetInsertCommand(jjnynx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12052Service#GetUpdateCommand(com.sunway.vo.Pgt12052)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt12052 jjnynx) throws Exception {
		return t12052Dao.GetUpdateCommand(jjnynx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12052Service#LoadAll(com.sunway.vo.Pgv12052)
	 */
	@Override
	public ArrayList<Pgv12052> LoadAll(Pgv12052 jjnynx) throws Exception {
		return t12052Dao.LoadAll(jjnynx);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12052Service#LoadByPrimaryKey(com.sunway.vo.Pgt12052)
	 */
	@Override
	public Pgt12052 LoadByPrimaryKey(Pgt12052 jjnynx) throws Exception {
		return t12052Dao.LoadByPrimaryKey(jjnynx);
	}

	/**
	 * @return the t12052Dao
	 */
	public IPgt12052DAO getT12052Dao() {
		return t12052Dao;
	}

	/**
	 * @param t12052Dao the t12052Dao to set
	 */
	public void setT12052Dao(IPgt12052DAO t12052Dao) {
		this.t12052Dao = t12052Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12052Service#ExecuteParamCopy(com.sunway.vo.Pgt12052)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt12052 jjnynx) throws Exception {
		return t12052Dao.ExecuteParamCopy(jjnynx);
	}

}
