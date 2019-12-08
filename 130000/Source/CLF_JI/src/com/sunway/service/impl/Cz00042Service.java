package com.sunway.service.impl;

import com.sunway.dao.ICz00042DAO;
import com.sunway.service.ICz00042Service;
import com.sunway.vo.Cz00042;

/**
 * 税率测算
 * @category 评税结果处理
 * @author Lee
 * @version 1.0
 *
 */
public class Cz00042Service implements ICz00042Service {

	private ICz00042DAO cz00042Dao;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.ICz00042Service#LoadAll(com.sunway.vo.Cz00042)
	 */
	@Override
	public Cz00042 LoadAll(Cz00042 cz00042) throws Exception {
		return cz00042Dao.LoadAll(cz00042);
	}

	/**
	 * @return the cz00042Dao
	 */
	public ICz00042DAO getCz00042Dao() {
		return cz00042Dao;
	}
	/**
	 * @param cz00042Dao the cz00042Dao to set
	 */
	public void setCz00042Dao(ICz00042DAO cz00042Dao) {
		this.cz00042Dao = cz00042Dao;
	}
}
