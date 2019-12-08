package com.sunway.service.impl;
import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt00306DAO;
import com.sunway.service.IPgt00306Service;
import com.sunway.vo.Pgv00306;

public class Pgt00306Service implements IPgt00306Service{
	private IPgt00306DAO t00306Dao;

	

	@Override
	public ArrayList<Pgv00306> LoadAll(Pgv00306 v00306) throws Exception {
		return t00306Dao.LoadAll(v00306);
	}

	
	
	
	
	@Override
	public Pgv00306 LoadByPrimaryKey(Pgv00306 v00306) throws Exception {
		return t00306Dao.LoadByPrimaryKey(v00306);
	}

	@Override
	public boolean GetInsertCommand(Pgv00306 v00306) throws Exception {
		
		return t00306Dao.GetInsertCommand(v00306);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#GetUpdateCommand(com.sunway.vo.Pgt00355)
	 */
	@Override
	public boolean GetUpdateCommand(Pgv00306 v00306) throws Exception {
		return t00306Dao.GetUpdateCommand(v00306);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00355Service#GetDeleteCommand(com.sunway.vo.Pgt00355)
	 */
	@Override
	public boolean GetDeleteCommand(Pgv00306 v00306) throws Exception {
		return t00306Dao.GetDeleteCommand(v00306);
	}

	@Override
	public OutputStream ExportT00306(Pgv00306 v00306) throws Exception {
		
		return t00306Dao.ExportT00306(v00306);
	}

	
	@Override
	public Pgv00306 ImportExcelData(ArrayList<Pgv00306> v00306List)
			throws Exception {
		
		return t00306Dao.ImportExcelData(v00306List);
	}

	public IPgt00306DAO getT00306Dao() {
		return t00306Dao;
	}

	public void setT00306Dao(IPgt00306DAO t00306Dao) {
		this.t00306Dao = t00306Dao;
	}





	@Override
	public Pgv00306 LoadByZCDZL(Pgv00306 v00306) throws Exception {
		return t00306Dao.LoadByZCDZL(v00306);
	}
}
