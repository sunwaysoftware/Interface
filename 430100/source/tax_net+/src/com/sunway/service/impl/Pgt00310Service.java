

/**
 * @author sunxdd
 *
 */

package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt00310DAO;
import com.sunway.service.IPgt00310Service;
import com.sunway.vo.Pgv00310;

public class Pgt00310Service implements IPgt00310Service {

	private IPgt00310DAO t00310Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310Service#GetDeleteCommand(com.sunway.vo.Pgv00310)
	 */
	@Override
	public boolean GetDeleteCommand(Pgv00310 b) throws Exception {
		return t00310Dao.GetDeleteCommand(b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310Service#GetInsertCommand(com.sunway.vo.Pgv00310)
	 */
	@Override
	public boolean GetInsertCommand(Pgv00310 b) throws Exception {
		return t00310Dao.GetInsertCommand(b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310Service#GetUpdateCommand(com.sunway.vo.Pgv00310)
	 */
	@Override
	public boolean GetUpdateCommand(Pgv00310 b) throws Exception {
		return t00310Dao.GetUpdateCommand(b);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310Service#GetUpdateCommand(com.sunway.vo.Pgv00310)
	 */
	@Override
	public boolean GetUpdateCommand1(Pgv00310 b) throws Exception {
		return t00310Dao.GetUpdateCommand1(b);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310Service#GetUpdateCommand(com.sunway.vo.Pgv00310)
	 */
	@Override
	public boolean GetUpdateCommand2(Pgv00310 b) throws Exception {
		return t00310Dao.GetUpdateCommand2(b);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310Service#GetUpdateCommand(com.sunway.vo.Pgv00310)
	 */
	@Override
	public boolean GetUpdateCommand3(Pgv00310 b) throws Exception {
		return t00310Dao.GetUpdateCommand3(b);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310Service#GetUpdateCommand(com.sunway.vo.Pgv00310)
	 */
	@Override
	public boolean GetUpdateCommand4(Pgv00310 b) throws Exception {
		return t00310Dao.GetUpdateCommand4(b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310Service#LoadAll(com.sunway.vo.Pgv00310)
	 */
	@Override
	public ArrayList<Pgv00310> LoadAll(Pgv00310 b) throws Exception {
		return t00310Dao.LoadAll(b);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310Service#LoadAll(com.sunway.vo.Pgv00310)
	 */
	@Override
	public ArrayList<Pgv00310> LoadAllV(Pgv00310 b) throws Exception {
		return t00310Dao.LoadAllV(b);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310Service#LoadAll(com.sunway.vo.Pgv00310)
	 */
	@Override
	public ArrayList<Pgv00310> LoadAllB(Pgv00310 b) throws Exception {
		return t00310Dao.LoadAllB(b);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310Service#LoadAll(com.sunway.vo.Pgv00310)
	 */
	@Override
	public ArrayList<Pgv00310> LoadDCYJ() throws Exception {
		return t00310Dao.LoadDCYJ();
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310Service#LoadAll(com.sunway.vo.Pgv00310)
	 */
	@Override
	public ArrayList<String> LoadSLSY(Pgv00310 b) throws Exception {
		return t00310Dao.LoadSLSY(b);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310Service#LoadAll(com.sunway.vo.Pgv00310)
	 */
	@Override
	public String InfoMsg(Pgv00310 b) throws Exception {
		return t00310Dao.InfoMsg(b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310Service#LoadByPrimaryKey(com.sunway.vo.Pgv00310)
	 */
	@Override
	public Pgv00310 LoadByPrimaryKey(Pgv00310 b) throws Exception {
		return t00310Dao.LoadByPrimaryKey(b);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310Service#LoadByPrimaryKey(com.sunway.vo.Pgv00310)
	 */
	@Override
	public Pgv00310 LoadByPrimaryKeyB(Pgv00310 b) throws Exception {
		return t00310Dao.LoadByPrimaryKeyB(b);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv00310Service#LoadByPrimaryKey(com.sunway.vo.Pgv00310)
	 */
	@Override
	public Pgv00310 JdsPrint(Pgv00310 b) throws Exception {
		return t00310Dao.JdsPrint(b);
	}

	public IPgt00310DAO getT00310Dao() {
		return t00310Dao;
	}

	public void setT00310Dao(IPgt00310DAO t00310Dao) {
		this.t00310Dao = t00310Dao;
	}
	

	
}
