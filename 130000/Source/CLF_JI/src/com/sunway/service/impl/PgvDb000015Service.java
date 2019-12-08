package com.sunway.service.impl;

import com.sunway.dao.IPgvDb000015DAO;
import com.sunway.service.IPgvDb000015Service;
import com.sunway.vo.PgvDb000015;

/**
 * 现行税率经济类型对比分析
 * @category 数据对比分析
 * @author Lee
 * @version 1.0
 */
public class PgvDb000015Service implements IPgvDb000015Service {

	private IPgvDb000015DAO db000015DAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IDb000015Service#LoadAll(com.sunway.vo.Db000015)
	 */
	public PgvDb000015 LoadAll(PgvDb000015 db000015) throws Exception {
		return db000015DAO.LoadAll(db000015);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvDb000015Service#GetInsertCommand(com.sunway.vo.PgvDb000015)
	 */
	public boolean GetInsertCommand(PgvDb000015 db000015) throws Exception {
		return db000015DAO.GetInsertCommand(db000015);
	}

	/**
	 * @return the db000015DAO
	 */
	public IPgvDb000015DAO getDb000015DAO() {
		return db000015DAO;
	}
	/**
	 * @param db000015dao the db000015DAO to set
	 */
	public void setDb000015DAO(IPgvDb000015DAO db000015dao) {
		db000015DAO = db000015dao;
	}
}
