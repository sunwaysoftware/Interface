

/**
 * @author sunxdd
 *
 */

package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.IPgt02010DAO;
import com.sunway.service.IPgt02010Service;
import com.sunway.vo.Pgv02010;

public class Pgt02010Service implements IPgt02010Service {

	private IPgt02010DAO t02010Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010Service#GetDeleteCommand(com.sunway.vo.Pgv02010)
	 */
	@Override
	public boolean GetDeleteCommand(Pgv02010 b) throws Exception {
		return t02010Dao.GetDeleteCommand(b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010Service#GetInsertCommand(com.sunway.vo.Pgv02010)
	 */
	@Override
	public boolean GetInsertCommand(Pgv02010 b) throws Exception {
		return t02010Dao.GetInsertCommand(b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010Service#GetUpdateCommand(com.sunway.vo.Pgv02010)
	 */
	@Override
	public boolean GetUpdateCommand(Pgv02010 b) throws Exception {
		return t02010Dao.GetUpdateCommand(b);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010Service#GetUpdateCommand(com.sunway.vo.Pgv02010)
	 */
	@Override
	public boolean GetUpdateCommand1(Pgv02010 b) throws Exception {
		return t02010Dao.GetUpdateCommand1(b);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010Service#GetUpdateCommand(com.sunway.vo.Pgv02010)
	 */
	@Override
	public boolean GetUpdateCommand2(Pgv02010 b) throws Exception {
		return t02010Dao.GetUpdateCommand2(b);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010Service#GetUpdateCommand(com.sunway.vo.Pgv02010)
	 */
	@Override
	public boolean GetUpdateCommand3(Pgv02010 b) throws Exception {
		return t02010Dao.GetUpdateCommand3(b);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010Service#GetUpdateCommand(com.sunway.vo.Pgv02010)
	 */
	@Override
	public boolean GetUpdateCommand4(Pgv02010 b) throws Exception {
		return t02010Dao.GetUpdateCommand4(b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010Service#LoadAll(com.sunway.vo.Pgv02010)
	 */
	@Override
	public ArrayList<Pgv02010> LoadAll(Pgv02010 b) throws Exception {
		return t02010Dao.LoadAll(b);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010Service#LoadAll(com.sunway.vo.Pgv02010)
	 */
	@Override
	public ArrayList<Pgv02010> LoadAllV(Pgv02010 b) throws Exception {
		return t02010Dao.LoadAllV(b);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010Service#LoadAll(com.sunway.vo.Pgv02010)
	 */
	@Override
	public ArrayList<Pgv02010> LoadAllB(Pgv02010 b) throws Exception {
		return t02010Dao.LoadAllB(b);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010Service#LoadAll(com.sunway.vo.Pgv02010)
	 */
	@Override
	public ArrayList<Pgv02010> LoadDCYJ() throws Exception {
		return t02010Dao.LoadDCYJ();
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010Service#LoadAll(com.sunway.vo.Pgv02010)
	 */
	@Override
	public ArrayList<String> LoadSLSY(Pgv02010 b) throws Exception {
		return t02010Dao.LoadSLSY(b);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010Service#LoadAll(com.sunway.vo.Pgv02010)
	 */
	@Override
	public String InfoMsg(Pgv02010 b) throws Exception {
		return t02010Dao.InfoMsg(b);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010Service#LoadByPrimaryKey(com.sunway.vo.Pgv02010)
	 */
	@Override
	public Pgv02010 LoadByPrimaryKey(Pgv02010 b) throws Exception {
		return t02010Dao.LoadByPrimaryKey(b);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010Service#LoadByPrimaryKey(com.sunway.vo.Pgv02010)
	 */
	@Override
	public Pgv02010 LoadByPrimaryKeyB(Pgv02010 b) throws Exception {
		return t02010Dao.LoadByPrimaryKeyB(b);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgv02010Service#LoadByPrimaryKey(com.sunway.vo.Pgv02010)
	 */
	@Override
	public Pgv02010 JdsPrint(Pgv02010 b) throws Exception {
		return t02010Dao.JdsPrint(b);
	}

	public IPgt02010DAO getT02010Dao() {
		return t02010Dao;
	}

	public void setT02010Dao(IPgt02010DAO t02010Dao) {
		this.t02010Dao = t02010Dao;
	}
	

	
}
