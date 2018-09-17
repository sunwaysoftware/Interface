package com.sunway.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt02002DAO;
import com.sunway.service.IPgt02002Service;
import com.sunway.util.CheckUtil;
import com.sunway.vo.BF00000;
import com.sunway.vo.Pgt02002;
import com.sunway.vo.Pgt02052xml;
import com.sunway.vo.Pgv02002;

/**
 * 市场法房地产信息
 * @author Andy
 * @version 1.0
 */
public class Pgt02002Service implements IPgt02002Service {

	private IPgt02002DAO t02002Dao;

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02002Service#LoadAll(com.sunway.vo.Pgv02002)
	 */
	@Override
	public Pgv02002 LoadAll(Pgv02002 v02002) throws Exception {
		return t02002Dao.LoadAll(v02002);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02002Service#LoadAll(com.sunway.vo.Pgv02002)
	 */
	@Override
	public ArrayList<Pgv02002> LoadAllE(Pgv02002 v02002) throws Exception {
		return t02002Dao.LoadAllE(v02002);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02002Service#LoadAll(com.sunway.vo.Pgv02002)
	 */
	@Override
	public ArrayList<Pgv02002> LoadAllE_B(Pgv02002 v02002) throws Exception {
		return t02002Dao.LoadAllE_B(v02002);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02002Service#LoadByPrimaryKey(com.sunway.vo.Pgt02002)
	 */
	@Override
	public Pgt02002 LoadByPrimaryKey(Pgt02002 t02002) throws Exception {
		return t02002Dao.LoadByPrimaryKey(t02002);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02002Service#LoadByPrimaryKey(com.sunway.vo.Pgt02002)
	 */
	@Override
	public Pgt02002 LoadByPrimaryKey_B(Pgt02002 t02002) throws Exception {
		return t02002Dao.LoadByPrimaryKey_B(t02002);
	}


	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02002Service#GetInsertCommand(com.sunway.vo.Pgt02002)
	 */
	@Override
	public boolean GetInsertCommand(Pgt02002 t02002) throws Exception {
		if (CheckUtil.chkEmpty(t02002.getFcid()))
			t02002.setFcid(t02002Dao.LoadMaxFcId(t02002.getCd00001Ssgx()));
		return t02002Dao.GetInsertCommand(t02002);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02002Service#GetInsertCommand(com.sunway.vo.Pgt02002)
	 */
	@Override
	public boolean GetInsertCommandBySFZ(Pgt02002 t02002) throws Exception {		
		return t02002Dao.GetInsertCommandBySFZ(t02002);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02002Service#GetUpdateCommand(com.sunway.vo.Pgt02002)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt02002 t02002) throws Exception {
		return t02002Dao.GetUpdateCommand(t02002);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02002Service#GetDeleteCommand(com.sunway.vo.Pgt02002)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt02002 t02002) throws Exception {
		return t02002Dao.GetDeleteCommand(t02002);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02002Service#LoadDetail(com.sunway.vo.Pgv02002)
	 */
	@Override
	public Pgv02002 LoadDetail(Pgv02002 v02002) throws Exception {
		return t02002Dao.LoadDetail(v02002);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02002Service#LoadDetail(com.sunway.vo.Pgv02002)
	 */
	@Override
	public Pgv02002 LoadDetail_B(Pgv02002 v02002) throws Exception {
		return t02002Dao.LoadDetail_B(v02002);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02002Service#GetFdcdatByFcid(com.sunway.vo.Pgt02002)
	 */
	@Override
	public Boolean GetFdcdatByFcid(Pgt02002 t02002) throws Exception {
		return t02002Dao.GetFdcdatByFcid(t02002);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02002Service#LoadPgv020025(com.sunway.vo.Pgv02002)
	 */
	@Override
	public Pgv02002 LoadPgv020025(Pgv02002 v02002) throws Exception {
		return t02002Dao.LoadPgv020025(v02002);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02002Service#LoadPgv020025(com.sunway.vo.Pgv02002)
	 */
	@Override
	public Pgv02002 LoadPgv020025_B(Pgv02002 v02002) throws Exception {
		return t02002Dao.LoadPgv020025_B(v02002);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt02002Service#LoadPgv020025(com.sunway.vo.Pgv02002)
	 */
	@Override
	public ArrayList<Pgv02002> LoadPgv020025_B1(Pgv02002 v02002) throws Exception {
		return t02002Dao.LoadPgv020025_B1(v02002);
	}
	
	/**
	 * @return the t02002Dao
	 */
	public IPgt02002DAO getT02002Dao() {
		return t02002Dao;
	}
	/**
	 * @param t02002Dao the t02002Dao to set
	 */
	public void setT02002Dao(IPgt02002DAO t02002Dao) {
		this.t02002Dao = t02002Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02002Service#GetInsertCommandWs(com.sunway.vo.Pgt02002)
	 */
	@Override
	public boolean GetInsertCommandWs(Pgt02002 t02002) throws Exception {
		return t02002Dao.GetInsertCommandWs(t02002);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt02002Service#LoadByFczh(com.sunway.vo.Pgt02002)
	 */
	@Override
	public Pgv02002 LoadByFczh(Pgt02002 t02002) throws Exception {
		return t02002Dao.LoadByFczh(t02002);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt020025Service#ExportDjxxSjcx(com.sunway.vo.Pgv020025)
	 */
	@Override
	public OutputStream ExportCXSjcx(Pgv02002 v02002) throws Exception {
		return t02002Dao.ExportCXSjcx(v02002);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt020025Service#ExportDjxxSjcx(com.sunway.vo.Pgv020025)
	 */
	@Override
	public OutputStream ExportCXSjcx_B(Pgv02002 v02002) throws Exception {
		return t02002Dao.ExportCXSjcx_B(v02002);
	}

	@Override
	public Pgv02002 GetXMLI(Pgv02002 v02002) throws Exception {
		
		return t02002Dao.GetXMLI(v02002);
	}
    
	@Override
    public  BF00000 GetDJZPsjgXML(BF00000 bf00000)throws Exception{
		
		return t02002Dao.GetDJZPsjgXML(bf00000);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.ICL00390Service#execRD(com.sunway.vo.Pgv00331)
	 */
	@Override
	public Boolean execFS(Pgt02002 bean) throws Exception {
		return t02002Dao.execFS(bean);
	}

	@Override
	public Pgt02052xml LoadAllXML(Pgt02052xml t02052xml) throws Exception {
		return t02002Dao.LoadAllXML(t02052xml);
	}

	@Override
	public Integer JCXML(Pgt02052xml pgt02052xml) throws Exception {
		return t02002Dao.JCXML(pgt02052xml);
	}

	@Override
	public boolean GetDeleteCommandXML(Pgt02052xml pgt02052xml) throws Exception {
		return t02002Dao.GetDeleteCommandXML(pgt02052xml);
	}

	@Override
	public boolean GetInsertCommandXML(ArrayList<Pgt02052xml> xmlList) throws Exception {
		return t02002Dao.GetInsertCommandXML(xmlList);
	}

	@Override
	public ArrayList<Pgt02052xml> LoadByFCSLH02072(Pgt02052xml bean) throws Exception {
		return t02002Dao.LoadByFCSLH02072(bean);
	}

	@Override
	public Pgt02052xml LoadByPrimaryKeyXML(Pgt02052xml pgt02052xml) throws Exception {
		return t02002Dao.LoadByPrimaryKeyXML(pgt02052xml);
	}

}
