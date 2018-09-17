package com.sunway.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt00302DAO;
import com.sunway.service.IPgt00302Service;
import com.sunway.util.CheckUtil;
import com.sunway.vo.BF00000;
import com.sunway.vo.Pgt00302;
import com.sunway.vo.Pgt00352xml;
import com.sunway.vo.Pgv00302;
import com.sunway.vo.Pgv00357;

/**
 * 市场法房地产信息
 * @author Lee
 * @version 1.0
 */
public class Pgt00302Service implements IPgt00302Service {

	private IPgt00302DAO t00302Dao;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00302Service#LoadAll(com.sunway.vo.Pgv00302)
	 */
	@Override
	public Pgv00302 LoadAll(Pgv00302 v00302) throws Exception {
		return t00302Dao.LoadAll(v00302);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00302Service#LoadAll(com.sunway.vo.Pgv00302)
	 */
	@Override
	public ArrayList<Pgv00302> LoadAllE(Pgv00302 v00302) throws Exception {
		return t00302Dao.LoadAllE(v00302);
	}	
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00302Service#LoadAll(com.sunway.vo.Pgv00302)
	 */
	@Override
	public ArrayList<Pgv00302> LoadAllE_B(Pgv00302 v00302) throws Exception {
		return t00302Dao.LoadAllE_B(v00302);
	}	

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00302Service#LoadByPrimaryKey(com.sunway.vo.Pgt00302)
	 */
	@Override
	public Pgt00302 LoadByPrimaryKey(Pgt00302 t00302) throws Exception {
		return t00302Dao.LoadByPrimaryKey(t00302);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00302Service#LoadByPrimaryKey(com.sunway.vo.Pgt00302)
	 */
	@Override
	public Pgt00302 LoadByPrimaryKey_B(Pgt00302 t00302) throws Exception {
		return t00302Dao.LoadByPrimaryKey_B(t00302);
	}


	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00302Service#GetInsertCommand(com.sunway.vo.Pgt00302)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00302 t00302) throws Exception {
		if (CheckUtil.chkEmpty(t00302.getFcid()))
			t00302.setFcid(t00302Dao.LoadMaxFcId(t00302.getCd00001Ssgx()));
		return t00302Dao.GetInsertCommand(t00302);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00302Service#GetInsertCommand(com.sunway.vo.Pgt00302)
	 */
	@Override
	public boolean GetInsertCommandBySFZ(Pgt00302 t00302) throws Exception {		
		return t00302Dao.GetInsertCommandBySFZ(t00302);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00302Service#GetUpdateCommand(com.sunway.vo.Pgt00302)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00302 t00302) throws Exception {
		return t00302Dao.GetUpdateCommand(t00302);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00302Service#GetDeleteCommand(com.sunway.vo.Pgt00302)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00302 t00302) throws Exception {
		return t00302Dao.GetDeleteCommand(t00302);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00302Service#LoadDetail(com.sunway.vo.Pgv00302)
	 */
	@Override
	public Pgv00302 LoadDetail(Pgv00302 v00302) throws Exception {
		return t00302Dao.LoadDetail(v00302);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00302Service#LoadDetail(com.sunway.vo.Pgv00302)
	 */
	@Override
	public Pgv00302 LoadDetail_B(Pgv00302 v00302) throws Exception {
		return t00302Dao.LoadDetail_B(v00302);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00302Service#GetFdcdatByFcid(com.sunway.vo.Pgt00302)
	 */
	@Override
	public Boolean GetFdcdatByFcid(Pgt00302 t00302) throws Exception {
		return t00302Dao.GetFdcdatByFcid(t00302);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00302Service#LoadPgv003025(com.sunway.vo.Pgv00302)
	 */
	@Override
	public Pgv00302 LoadPgv003025(Pgv00302 v00302) throws Exception {
		return t00302Dao.LoadPgv003025(v00302);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00302Service#LoadPgv003025(com.sunway.vo.Pgv00302)
	 */
	@Override
	public Pgv00302 LoadPgv003025_B(Pgv00302 v00302) throws Exception {
		return t00302Dao.LoadPgv003025_B(v00302);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00302Service#LoadPgv003025(com.sunway.vo.Pgv00302)
	 */
	@Override
	public ArrayList<Pgv00302> LoadPgv003025_B1(Pgv00302 v00302) throws Exception {
		return t00302Dao.LoadPgv003025_B1(v00302);
	}
	
	/**
	 * @return the t00302Dao
	 */
	public IPgt00302DAO getT00302Dao() {
		return t00302Dao;
	}
	/**
	 * @param t00302Dao the t00302Dao to set
	 */
	public void setT00302Dao(IPgt00302DAO t00302Dao) {
		this.t00302Dao = t00302Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00302Service#GetInsertCommandWs(com.sunway.vo.Pgt00302)
	 */
	@Override
	public boolean GetInsertCommandWs(Pgt00302 t00302) throws Exception {
		return t00302Dao.GetInsertCommandWs(t00302);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00302Service#LoadByFczh(com.sunway.vo.Pgt00302)
	 */
	@Override
	public Pgv00302 LoadByFczh(Pgt00302 t00302) throws Exception {
		return t00302Dao.LoadByFczh(t00302);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt003025Service#ExportDjxxSjcx(com.sunway.vo.Pgv003025)
	 */
	@Override
	public OutputStream ExportCXSjcx(Pgv00302 v00302) throws Exception {
		return t00302Dao.ExportCXSjcx(v00302);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt003025Service#ExportDjxxSjcx(com.sunway.vo.Pgv003025)
	 */
	@Override
	public OutputStream ExportCXSjcx_B(Pgv00302 v00302) throws Exception {
		return t00302Dao.ExportCXSjcx_B(v00302);
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00302Service#ImportExcelData(java.util.ArrayList)
	 */
	@Override
	public Pgv00357 ImportExcelData(ArrayList<Pgv00357> kbslkList)
			throws Exception {
		
		return t00302Dao.ImportExcelData(kbslkList);
	}
	

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00302Service#GetUpdateCommandXML(com.sunway.vo.Pgt00352xml)
	 */
	@Override
	public boolean GetUpdateCommandXML(Pgt00352xml pgt00352xml) throws Exception {
		return t00302Dao.GetUpdateCommandXML(pgt00352xml);
		
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00302Service#LoadByPrimaryKeyXML(com.sunway.vo.Pgt00352xml)
	 */
	@Override
	public Pgt00352xml LoadByPrimaryKeyXML(Pgt00352xml pgt00352xml) throws Exception {
		return t00302Dao.LoadByPrimaryKeyXML(pgt00352xml);
		
	}

	@Override
	public Pgt00352xml LoadAllXML(Pgt00352xml t00352xml) throws Exception {
		// TODO Auto-generated method stub
		return t00302Dao.LoadAllXML(t00352xml);
	}

	@Override
	public boolean GetDeleteCommandXML(Pgt00352xml pgt00352xml) throws Exception {
		return t00302Dao.GetDeleteCommandXML(pgt00352xml);
	
		
	}

	@Override
	public boolean GetInsertCommandXML(ArrayList<Pgt00352xml> xmlList)
			throws Exception {

		return t00302Dao.GetInsertCommandXML(xmlList);
	}

	@Override
	public Integer JCXML(Pgt00352xml pgt00352xml) throws Exception {
		
		return t00302Dao.JCXML(pgt00352xml);
	}

	@Override
	public boolean GetUpdateCommand371(Pgt00352xml pgt00352xml)
			throws Exception {
		
		return t00302Dao.GetUpdateCommand371(pgt00352xml);
	}

	@Override
	public Pgv00302 GetXMLI(Pgv00302 v00302) throws Exception {
		
		return t00302Dao.GetXMLI(v00302);
	}
    
	@Override
    public  BF00000 GetDJZPsjgXML(BF00000 bf00000)throws Exception{
		
		return t00302Dao.GetDJZPsjgXML(bf00000);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.ICL00390Service#execRD(com.sunway.vo.Pgv00331)
	 */
	@Override
	public Boolean execFS(Pgt00302 bean) throws Exception {
		return t00302Dao.execFS(bean);
	}

	@Override
	public Boolean GetInsertCommand3711(Pgt00352xml pgt00352xml)
			throws Exception {
		
		return t00302Dao.GetInsertCommand3711(pgt00352xml);
	}

	@Override
	public Pgt00352xml LoadAll3711(Pgt00352xml t00352xml) throws Exception {
		
		return t00302Dao.LoadAll3711(t00352xml);
	}

	@Override
	public Boolean GetDeleteCommand3711(Pgt00352xml t00352xml) throws Exception {
		
		return t00302Dao.GetDeleteCommand3711(t00352xml);
	}

	@Override
	public Pgt00352xml LoadByPrimaryKey3711(Pgt00352xml t00352xml)throws Exception {
		
		return t00302Dao.LoadByPrimaryKey3711(t00352xml);
	}

	@Override
	public ArrayList<Pgt00352xml> LoadByFCSLH372(Pgt00352xml t00352xml) throws Exception {
		return t00302Dao.LoadByFCSLH372(t00352xml);
	}

}
