package com.sunway.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;

import com.sunway.dao.IPgt00001DAO;
import com.sunway.service.IPgt00001Service;
import com.sunway.vo.Pgt00001;
import com.sunway.vo.Pgt02056;
import com.sunway.vo.Pgv00001;

/**
 * @author Andy.Gao
 * @version1.0
 * 
 * @author Lee
 * @version2.0
 *
 */
public class Pgt00001Service implements IPgt00001Service {

	private IPgt00001DAO t00001Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgtInfoService#GetDeleteCommand(com.sunway.vo.PgtInfo)
	 */
	@Override
	public boolean GetDeleteCommand(Pgt00001 info) throws Exception {
		return getT00001Dao().GetDeleteCommand(info);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgtInfoService#GetInsertCommand(com.sunway.vo.PgtInfo)
	 */
	@Override
	public boolean GetInsertCommand(Pgt00001 info) throws Exception {
		return getT00001Dao().GetInsertCommand(info);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgtInfoService#GetUpdateCommand(com.sunway.vo.PgtInfo)
	 */
	@Override
	public boolean GetUpdateCommand(Pgt00001 info) throws Exception {
		return getT00001Dao().GetUpdateCommand(info);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgtInfoService#LoadAll(com.sunway.vo.PgtInfo)
	 */
	@Override
	public ArrayList<Pgv00001> LoadAll(Pgv00001 info) throws Exception {
		return getT00001Dao().LoadAll(info);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgtInfoService#LoadByPrimaryKey(com.sunway.vo.PgtInfo)
	 */
	@Override
	public Pgt00001 LoadByPrimaryKey(Pgt00001 info) throws Exception {
		return getT00001Dao().LoadByPrimaryKey(info);
	}

	
	public OutputStream ExportAll(Pgv00001 info) throws Exception {
		return getT00001Dao().ExportAll(info);
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#LoadAllByRoot(com.sunway.vo.Pgt00001)
	 */
	@Override
	public ArrayList<Pgt00001> LoadAllByRoot() throws Exception {
		return getT00001Dao().LoadAllByRoot();
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#LoadNavigator(com.sunway.vo.Pgv00001)
	 */
	@Override
	public ArrayList<Pgt00001> LoadNavigator(Pgt00001 info) throws Exception {
		return getT00001Dao().LoadNavigator(info);
	}

	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#LoadTreeList(com.sunway.vo.Pgt00001)
	 */
	@Override
	public ArrayList<Pgt00001> LoadTreeList(Pgt00001 info) throws Exception {
		return getT00001Dao().LoadTreeList(info);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoIdByRootId(com.sunway.vo.Pgt00001)
	 */
	@Override
	public String GetInfoIdByRootId(Pgt00001 info) throws Exception {
		return getT00001Dao().GetInfoIdByRootId(info);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoJZJG()
	 */
	@Override
	public String GetInfoJZJG() throws Exception {
		return t00001Dao.GetInfoJZJG();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfocdInfoSzqy()
	 */
	@Override
	public String GetInfoSzqy() throws Exception {
		return t00001Dao.GetInfoSzqy();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoCGZK_SC()
	 */
	@Override
	public String GetInfoCGZK_SC() throws Exception {
		return t00001Dao.GetInfoCGZK_SC();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoZJLX()
	 */
	@Override
	public String GetInfoZJLX() throws Exception {
		return t00001Dao.GetInfoZJLX();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoFWCX()
	 */
	@Override
	public String GetInfoFWCX() throws Exception {
		return t00001Dao.GetInfoFWCX();
	}

	@Override
	public String GetInfoTDDJ() throws Exception {
		return t00001Dao.GetInfoTDDJ();
	}
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoFWLX_SC()
	 */
	@Override
	public String GetInfoFWLX_SC() throws Exception {
		return t00001Dao.GetInfoFWLX_SC();
	}
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoFWLX_SC()
	 */
	@Override
	public String GetInfoBGLLX_SY() throws Exception {
		return t00001Dao.GetInfoBGLLX_SY();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoFWSS()
	 */
	@Override
	public String GetInfoFWSS() throws Exception {
		return t00001Dao.GetInfoFWSS();
	}


	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoFWYTZH()
	 */
	@Override
	public String GetInfoFWYT() throws Exception {
		return t00001Dao.GetInfoFWYT();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoHY()
	 */
	@Override
	public String GetInfoHY() throws Exception {
		return t00001Dao.GetInfoHY();
	}
//	/*
//	 * (non-Javadoc)
//	 * @see com.sunway.service.IPgt00001Service#GetInfoLX()
//	 */
//	@Override
//	public String GetInfoLX() throws Exception {
//		return t00001Dao.GetInfoLX();
//	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoJJLX()
	 */
	@Override
	public String GetInfoJJLX() throws Exception {
		return t00001Dao.GetInfoJJLX();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoJYLX_SC()
	 */
	@Override
	public String GetInfoJYLX_SC() throws Exception {
		return t00001Dao.GetInfoJYLX_SC();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoMSSZ()
	 */
	@Override
	public String GetInfoMSSZ() throws Exception {
		return t00001Dao.GetInfoMSSZ();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoQDFS()
	 */
	@Override
	public String GetInfoQDFS() throws Exception {
		return t00001Dao.GetInfoQDFS();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoSYQLX()
	 */
	@Override
	public String GetInfoSYQLX() throws Exception {
		return t00001Dao.GetInfoSYQLX();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoTDDJ()
	 */
//	@Override
//	public String GetInfoTDDJ() throws Exception {
//		return t00001Dao.GetInfoTDDJ();
//	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoTDSYQLX()
	 */
	@Override
	public String GetInfoTDSYQLX() throws Exception {
		return t00001Dao.GetInfoTDSYQLX();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoTDYT()
	 */
	@Override
	public String GetInfoTDYT() throws Exception {
		return t00001Dao.GetInfoTDYT();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoXJBZ()
	 */
	@Override
	public String GetInfoXJBZ() throws Exception {
		return t00001Dao.GetInfoXJBZ();
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoLC()
	 */
	@Override
	public String GetInfoLC() throws Exception {
		return t00001Dao.GetInfoLC();
	}
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoXZ()
	 */
	@Override
	public String GetInfoXZ() throws Exception {
		return t00001Dao.GetInfoXZ();
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoSSGX()
	 */
	@Override
	public String GetInfoSSGX() throws Exception {
		return t00001Dao.GetInfoSSGX();
	}

	/**
	 * @param t00001Dao the t00001Dao to set
	 */
	public void setT00001Dao(IPgt00001DAO t00001Dao) {
		this.t00001Dao = t00001Dao;
	}

	/**
	 * @return the t00001Dao
	 */
	public IPgt00001DAO getT00001Dao() {
		return t00001Dao;
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#LoadNavString(com.sunway.vo.Pgt00001)
	 */
	@Override
	public String LoadNavString(Pgt00001 info) throws Exception {
		return t00001Dao.LoadNavString(info);
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoJTZK()
	 */
	@Override
	public String GetInfoJTZK() throws Exception {
		return t00001Dao.GetInfoJTZK();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoWYZK()
	 */
	@Override
	public String GetInfoWYZK() throws Exception {
		return t00001Dao.GetInfoWYZK();
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#LoadAllXjbz()
	 */
	public ArrayList<Pgt00001> LoadAllXjbz(Pgt02056 xjbz) throws Exception {
		return t00001Dao.LoadAllXjbz(xjbz);
	}
	public String GetInfoZXZK() throws Exception {
		return t00001Dao.GetInfoZXZK();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#GetInfoZHXZ()
	 */
	@Override
	public String GetInfoZHXZ() throws Exception {
		return t00001Dao.GetInfoZHXZ();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#LoadAllZHXZ()
	 */
	@Override
	public ArrayList<Pgv00001> LoadAllZHXZ() throws Exception {
		return t00001Dao.LoadAllZHXZ();
	}

	/* (non-Javadoc)
	 * @see com.sunway.service.IPgt00001Service#LoadZhxzTreeList(com.sunway.vo.Pgt00001)
	 */
	@Override
	public ArrayList<Pgt00001> LoadZhxzTreeList(Pgt00001 info) throws Exception {
		return t00001Dao.LoadZhxzTreeList(info);
	}

	@Override
	public String GetXQDMByXQNM(String xqnm, String cd00001Ssgx)throws Exception {
		
		return t00001Dao.GetXQDMByXQNM(xqnm, cd00001Ssgx);
	}

	@Override
	public ArrayList<Pgt00001> GetINFOListByROOTID(String rootId, String cd00001Fwlx, String cd00352Szqy, String xqdm)throws Exception {
		return t00001Dao.GetINFOListByROOTID(rootId, cd00001Fwlx, cd00352Szqy, xqdm);
	}	

//	@Override
//	public String GetInfoGWHJ() throws Exception {
//		return t00001Dao.GetInfoGWHJ();
//	}

	@Override
	public ArrayList<Pgt00001> GetINFOListByFWLX(String type) throws Exception {
		return t00001Dao.GetINFOListByFWLX(type);
	}

	@Override
	public ArrayList<Pgt00001> GetINFOListBySYXQFWLX() throws Exception {
		return t00001Dao.GetINFOListBySYXQFWLX();
	}
	

//	@Override
//	public ArrayList<Pgt000011> GetZJLXINFOList(String rootId) throws Exception {
//		return t00001Dao.GetZJLXINFOList(rootId);
//	}

}
