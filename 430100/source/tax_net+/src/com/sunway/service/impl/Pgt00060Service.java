package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00060DAO;
import com.sunway.service.IPgt00060Service;
import com.sunway.vo.Pgt00060;
import com.sunway.vo.Pgv00062;

/**
 * 通用选择控件
 * @author Light
 *
 */
public class Pgt00060Service implements IPgt00060Service{

	private IPgt00060DAO t00060Dao;
	
	@Override
	public ArrayList<Pgt00060> LoadAll(Pgt00060 t00060) throws Exception {
		return t00060Dao.LoadAll(t00060);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00060Service#GetInsertImpDaily(com.sunway.vo.Pgt00062)
	 */
	@Override
	public Boolean GetInsertImpDaily(Pgv00062 v00062) throws Exception {
		return t00060Dao.GetInsertImpDaily(v00062);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00060Service#LoadAllDaily(com.sunway.vo.Pgv00062)
	 */
	@Override
	public ArrayList<Pgv00062> LoadAllDaily(Pgv00062 v00062) throws Exception {
		return t00060Dao.LoadAllDaily(v00062);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00060Service#GetDeleteByPrimaryDaily(com.sunway.vo.Pgt00062)
	 */
	@Override
	public Boolean GetDeleteByPrimaryDaily(Pgv00062 v00062) throws Exception {
		return t00060Dao.GetDeleteByPrimaryDaily(v00062);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00060Service#LoadByPrimaryDaily(com.sunway.vo.Pgv00062)
	 */
	@Override
	public Pgv00062 LoadByPrimaryDaily(Pgv00062 v00062) throws Exception {
		return t00060Dao.LoadByPrimaryDaily(v00062);
	}

	/**
	 * @return the t00060Dao
	 */
	public IPgt00060DAO getT00060Dao() {
		return t00060Dao;
	}

	/**
	 * @param t00060Dao the t00060Dao to set
	 */
	public void setT00060Dao(IPgt00060DAO t00060Dao) {
		this.t00060Dao = t00060Dao;
	}

}
