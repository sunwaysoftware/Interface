/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgvCz00006DAO;
import com.sunway.service.IPgvCz00006Service;
import com.sunway.vo.PgvCz00006;

/**
 * 
 * 变更类型
 * @author Andy.Gao
 *
 */
public class PgvCz00006Service implements IPgvCz00006Service {

	private IPgvCz00006DAO cz00006Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgvCz00006Service#LoadByUpdate()
	 */
	@Override
	public ArrayList<PgvCz00006> LoadByUpdate() throws Exception {
		return cz00006Dao.LoadByUpdate();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgvCz00006Service#LoadByDelete()
	 */
	@Override
	public ArrayList<PgvCz00006> LoadByDelete() throws Exception {
		return cz00006Dao.LoadByDelete();
	}
	
	/**
	 * @param cz00006Dao the cz00006Dao to set
	 */
	public void setCz00006Dao(IPgvCz00006DAO cz00006Dao) {
		this.cz00006Dao = cz00006Dao;
	}

	/**
	 * @return the cz00006Dao
	 */
	public IPgvCz00006DAO getCz00006Dao() {
		return cz00006Dao;
	}
}
