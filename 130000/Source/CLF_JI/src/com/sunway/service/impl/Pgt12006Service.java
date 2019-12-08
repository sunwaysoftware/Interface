package com.sunway.service.impl;

import java.util.ArrayList;
import com.sunway.dao.IPgt12006DAO;
import com.sunway.service.IPgt12006Service;
import com.sunway.vo.Pgt12006;

/**
 * 登记人或承租人信息表(可以给登记提供自动提示功能)
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt12006Service implements IPgt12006Service {

	private IPgt12006DAO t12006Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12006Service#LoadNmById(java.lang.String)
	 */
	@Override
	public String LoadNmById(String id) throws Exception {
		return t12006Dao.LoadNmById(id);
	}

	/**
	 * @param t12006Dao the t12006Dao to set
	 */
	public void setT12006Dao(IPgt12006DAO t12006Dao) {
		this.t12006Dao = t12006Dao;
	}

	/**
	 * @return the t12006Dao
	 */
	public IPgt12006DAO getT12006Dao() {
		return t12006Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12006Service#GetDeleteCommand(com.sunway.vo.Pgt12006)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt12006 auto) throws Exception {
		return t12006Dao.GetDeleteCommand(auto);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12006Service#GetInsertCommand(com.sunway.vo.Pgt12006)
	 */
	@Override
	public boolean GetInsertCommand(Pgt12006 auto) throws Exception {
		return t12006Dao.GetInsertCommand(auto);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12006Service#GetUpdateCommand(com.sunway.vo.Pgt12006)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt12006 auto) throws Exception {
		return t12006Dao.GetUpdateCommand(auto);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12006Service#LoadAll()
	 */
	@Override
	public ArrayList<Pgt12006> LoadAll(Pgt12006 auto) throws Exception {
		return t12006Dao.LoadAll(auto);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12006Service#LoadByPrimaryKey(com.sunway.vo.Pgt12006)
	 */
	@Override
	public Pgt12006 LoadByPrimaryKey(Pgt12006 auto) throws Exception {
		return t12006Dao.LoadByPrimaryKey(auto);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt12006Service#ImportExcelData(java.util.ArrayList)
	 */
	@Override
	public Boolean ImportExcelData(Pgt12006 bean) throws Exception {
		return t12006Dao.ImportExcelData(bean);
	}

}
