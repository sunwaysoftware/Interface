package com.sunway.service.impl;

import java.util.ArrayList;
import com.sunway.dao.IPgt10057DAO;
import com.sunway.service.IPgt10057Service;
import com.sunway.vo.Pgt10057;
import com.sunway.vo.Pgv10057;

/**
 * @category 成新率最小值设置
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt10057Service implements IPgt10057Service {

	private IPgt10057DAO t10057Dao;
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10057Service#GetDeleteCommand(com.sunway.vo.Pgt10057)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt10057 cxl) throws Exception {
		return t10057Dao.GetDeleteCommand(cxl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10057Service#GetInsertCommand(com.sunway.vo.Pgt10057)
	 */
	@Override
	public boolean GetInsertCommand(Pgt10057 cxl) throws Exception {
		return t10057Dao.GetInsertCommand(cxl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10057Service#GetUpdateCommand(com.sunway.vo.Pgt10057)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt10057 cxl) throws Exception {
		return t10057Dao.GetUpdateCommand(cxl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10057Service#LoadAll(com.sunway.vo.Pgv10057)
	 */
	@Override
	public ArrayList<Pgv10057> LoadAll(Pgv10057 cxl) throws Exception {
		return t10057Dao.LoadAll(cxl);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10057Service#LoadByPrimaryKey(com.sunway.vo.Pgt10057)
	 */
	@Override
	public Pgt10057 LoadByPrimaryKey(Pgt10057 cxl) throws Exception {
		return t10057Dao.LoadByPrimaryKey(cxl);
	}

	/**
	 * @return the t10057Dao
	 */
	public IPgt10057DAO getT10057Dao() {
		return t10057Dao;
	}

	/**
	 * @param t10057Dao the t10057Dao to set
	 */
	public void setT10057Dao(IPgt10057DAO t10057Dao) {
		this.t10057Dao = t10057Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt10057Service#ExecuteParamCopy(com.sunway.vo.Pgt10057)
	 */
	@Override
	public boolean ExecuteParamCopy(Pgt10057 cxl) throws Exception {
		return t10057Dao.ExecuteParamCopy(cxl);
	}

}
