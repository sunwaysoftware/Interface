package com.sunway.service.impl;

import com.sunway.dao.IPgvDb000016DAO;
import com.sunway.service.IPgvDb000016Service;
import com.sunway.vo.PgvDb000016;

/**
 * 现行税率免税设置对比分析
 * @category 数据对比分析
 * @author Lee
 * @version 1.0
 */
public class PgvDb000016Service implements IPgvDb000016Service {

	private IPgvDb000016DAO db000016DAO;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IDb000016Service#LoadAll(com.sunway.vo.Db000016)
	 */
	public PgvDb000016 LoadAll(PgvDb000016 db000016) throws Exception {
		return db000016DAO.LoadAll(db000016);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgvDb000016Service#GetInsertCommand(com.sunway.vo.PgvDb000016)
	 */
	public boolean GetInsertCommand(PgvDb000016 db000016) throws Exception {
		return db000016DAO.GetInsertCommand(db000016);
	}

	/**
	 * @return the db000016DAO
	 */
	public IPgvDb000016DAO getDb000016DAO() {
		return db000016DAO;
	}
	/**
	 * @param db000016dao the db000016DAO to set
	 */
	public void setDb000016DAO(IPgvDb000016DAO db000016dao) {
		db000016DAO = db000016dao;
	}
}
