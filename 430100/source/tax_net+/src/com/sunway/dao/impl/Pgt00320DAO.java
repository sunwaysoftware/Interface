package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00320DAO;
import com.sunway.util.ConvertUtil;
import com.sunway.vo.Pgv00302;
import com.sunway.vo.Pgv00320;
import com.sunway.vo.Pgv00320e;

public class Pgt00320DAO extends BaseDAO implements IPgt00320DAO{
	
	private final static String FCID = "fcid";
	private final static String FCZH = "fczh";
	private final static String CLH = "clh";
	private final static String CD00352XQDM = "cd_00352_xqdm";
	private final static String XQNM = "xqnm";
	private final static String ZCDZL = "zcdzl";
	private final static String JZMJ = "jzmj";
	private final static String HDJG = "hdjg";
	private final static String ZLC = "zlc";
	private final static String SZLC = "szlc";
	private final static String CD00001FWLX = "cd_00001_fwlx";
	private final static String FWLX = "fwlx";
	private final static String CD00001JZJG = "cd_00001_jzjg";
	private final static String JZJG = "jzjg";
	private final static String CD00001GHYT = "cd_00001_ghyt";
	private final static String GHYT = "ghyt";
	private final static String CD00001JYLX = "CD_00001_JYLX";
	private final static String JYLX = "jylx";
	private final static String UPDDATE = "upddate";
	private final static String CD00002CZR = "cd_00002_czr";
	private final static String CZR = "czr";
	private final static String NOTE = "note";
	private final static String TOTAL = "total";
	private final static String FH = "fh";
	private final static String DYH = "dyh";
	private final static String ZH = "zh";
	private final static String JCNF = "jcnf";
	private final static String NSRMC = "nsrmc";
	private final static String CD00001ZJLX = "cd_00001_zjlx";
	private final static String ZJLX = "zjlx";
	private final static String LXDH = "lxdh";
	private final static String ZJHM = "zjhm";
	
	
	private final static String CD00001SZQY = "cd_00001_szqy";
	private final static String SZQY = "szqy";
	private final static String CD00001SSGX = "cd_00001_ssgx";
	private final static String SSGX = "ssgx";
	private final static String JYSJ = "jysj";
	private final static String PGJG = "pgjg";
	private final static String ZHXZ = "zhxz";
	private final static String CWXX = "cwxx";
	
	@Override
	public ArrayList<Pgv00320> LoadAll(Pgv00320 v00320) throws Exception {
		ArrayList<Pgv00320> resultList = new ArrayList<Pgv00320>();
		Session session = null;
		CallableStatement call = null;
		Connection conn = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00320(?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v00320.getPageIndex());
			call.setInt(3, v00320.getPageSize());
			call.setString(4, v00320.getCd00001Szqy());
			call.setString(5, v00320.getCd00001Ssgx());
			call.setDate(6, ConvertUtil.utilDateToSqlDate(v00320.getJysj()));
			call.setInt(7, v00320.getIsPgjg());
			call.setString(8, v00320.getZcdzl());
			call.setString(9, v00320.getZh());
			call.setString(10, v00320.getDyh());
			call.setString(11, v00320.getFh());
			call.setString(12, v00320.getXqnm());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				resultList.add(SetParameters(rs,true));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs,call,conn,session);
		}
		return resultList;
	}
	
	/**
	 * 装载数据
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	protected Pgv00320 SetParameters(ResultSet rs,Boolean sign)throws Exception {
		Pgv00320 e = new Pgv00320();
		if(sign){
			e.setRecordCount(rs.getInt(TOTAL));
			e.setCwxx(rs.getInt(CWXX));
		}
		e.setFcid(rs.getString(FCID));
		e.setFczh(rs.getString(FCZH));
		e.setClh(rs.getString(CLH));
		e.setCd00352Xqdm(rs.getString(CD00352XQDM));
		e.setXqnm(rs.getString(XQNM));
		e.setZcdzl(rs.getString(ZCDZL));
		e.setJzmj(rs.getDouble(JZMJ));
		e.setHdjg(rs.getDouble(HDJG));
		e.setZlc(rs.getInt(ZLC));
		e.setSzlc(rs.getInt(SZLC));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setFwlx(rs.getString(FWLX));
		e.setCd00001Jzjg(rs.getString(CD00001JZJG));
		e.setJzjg(rs.getString(JZJG));
		e.setCd00001Ghyt(rs.getString(CD00001GHYT));
		e.setGhyt(rs.getString(GHYT));
		e.setCd00001jylx(rs.getString(CD00001JYLX));
		e.setJylx(rs.getString(JYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setSzqy(rs.getString(SZQY));
		e.setCd00001Ssgx(rs.getString(CD00001SSGX));
		e.setSsgx(rs.getString(SSGX));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setCzr(rs.getString(CZR));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setZhxz(rs.getString(ZHXZ));
		e.setNote(rs.getString(NOTE));
		e.setZh(rs.getString(ZH));
		e.setDyh(rs.getString(DYH));
		e.setFh(rs.getString(FH));
		e.setJcnf(rs.getString(JCNF));
		e.setNsrmc(rs.getString(NSRMC));
		e.setCd00001Zjlx(rs.getString(CD00001ZJLX));
		e.setZjlx(rs.getString(ZJLX));
		e.setLxdh(rs.getString(LXDH));
		e.setZjhm(rs.getString(ZJHM));
		return e;
	}

	/**
	 * 转存全面评估数据
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	protected Pgv00320 SetQMPGParameters(ResultSet rs)throws Exception {
		Pgv00320 e = new Pgv00320();
		
		e.setFcid(rs.getString(FCID));
		e.setFczh(rs.getString(FCZH));
		e.setClh(rs.getString(CLH));
		e.setCd00352Xqdm(rs.getString(CD00352XQDM));
		e.setXqnm(rs.getString(XQNM));
		e.setZcdzl(rs.getString(ZCDZL));
		e.setJzmj(rs.getDouble(JZMJ));
		e.setHdjg(rs.getDouble(HDJG));
		e.setZlc(rs.getInt(ZLC));
		e.setSzlc(rs.getInt(SZLC));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setFwlx(rs.getString(FWLX));
		e.setCd00001Jzjg(rs.getString(CD00001JZJG));
		e.setJzjg(rs.getString(JZJG));
		e.setCd00001Ghyt(rs.getString(CD00001GHYT));
		e.setGhyt(rs.getString(GHYT));
		e.setCd00001jylx(rs.getString(CD00001JYLX));
		e.setJylx(rs.getString(JYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setSzqy(rs.getString(SZQY));
		e.setCd00001Ssgx(rs.getString(CD00001SSGX));
		e.setSsgx(rs.getString(SSGX));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setCzr(rs.getString(CZR));
		e.setUpddate(rs.getTimestamp(UPDDATE));
//		e.setZhxz(rs.getString(ZHXZ));
		e.setNote(rs.getString(NOTE));
		e.setNsrNm(rs.getString(NSRMC));
		e.setZjhm(rs.getString("ZJHM"));
		e.setLxdh(rs.getString("LXDH"));
		e.setJcnf(rs.getString("JCNF"));
		e.setZjlx(rs.getString("ZJLX"));
		e.setCd00001Zjlx(rs.getString("CD_00001_ZJLX"));
		e.setClh(rs.getString("CLH"));
		e.setPgjg(rs.getBigDecimal("pgjg"));
		e.setZh(rs.getString("ZH"));
		e.setDyh(rs.getString("DYH"));
		e.setFh(rs.getString("FH"));
		return e;
	}
	
	
	@Override
	public Pgv00320 ImportExcelData(ArrayList<Pgv00320> v00320List)throws Exception {
		Pgv00320 v00320 = new Pgv00320();
		ArrayList<Pgv00320> tempList = new ArrayList<Pgv00320>();
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		ResultSet rs = null;
		Integer sResultCount = 0;
		Integer fResultCount = 0;
		Integer resultValue = 0;
		
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			
			for(int i = 0; i < v00320List.size();i++){
				call = conn.prepareCall("{call PGSP_ADDT003201(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				Pgv00320 v00320Bean = v00320List.get(i);
				try{
					call.registerOutParameter(1, OracleTypes.CURSOR);
					call.setString(2, v00320Bean.getSzqy());
					call.setString(3, v00320Bean.getXqnm());
					call.setString(4, v00320Bean.getFczh());
					call.setString(5, v00320Bean.getClh());
					call.setString(6, v00320Bean.getZcdzl());
					call.setDouble(7, v00320Bean.getJzmj());
					call.setInt(8, v00320Bean.getZlc());
					call.setInt(9, v00320Bean.getSzlc());
					call.setString(10, v00320Bean.getFwlx());
					call.setString(11, v00320Bean.getJzjg());
					call.setString(12, v00320Bean.getGhyt());
					call.setString(13, v00320Bean.getJylx());
					call.setDouble(14, v00320Bean.getHdjg());
					call.setString(15, v00320Bean.getZhxz());
					call.setString(16, v00320Bean.getNote());
					call.setString(17, v00320Bean.getCd00001Ssgx());
					call.setString(18, v00320Bean.getCd00002Czr());
					call.setString(19, v00320Bean.getZh());
					call.setString(20, v00320Bean.getDyh());
					call.setString(21, v00320Bean.getFh());
					call.setString(22, v00320Bean.getJcnf());
					call.setString(23, v00320Bean.getNsrmc());
					call.setString(24, v00320Bean.getZjlx());
					call.setString(25, v00320Bean.getLxdh());
					call.setString(26, v00320Bean.getZjhm());
					call.execute();
					rs = (ResultSet)call.getObject(1);
				    if(null != rs && rs.next()){
				    	if(rs.getInt("flag") == 0){
				    		sResultCount++;
				    		v00320Bean.setCd00001Fwlx(rs.getString("TFWLX"));
				    		v00320Bean.setCd00001Szqy(rs.getString("SZQYID"));
				    		v00320Bean.setCd00001Jzjg(rs.getString("TJZJG"));
				    		v00320Bean.setCd00352Xqdm(rs.getString("TXQDM"));
				    		v00320Bean.setCd00001Ghyt(rs.getString("TGHYT"));
				    		v00320Bean.setCd00001jylx(rs.getString("TJYLX"));
				    		v00320Bean.setCd00001Zjlx(rs.getString("TZJLX"));
				    		v00320Bean.setZhxzId(rs.getString("TZHXZ"));
				    		v00320Bean.setImpErrorMsg("");
				    		tempList.add(v00320Bean);
				    		v00320.setOutList(tempList);
				    	}
				    }
				}catch(Exception e){
					sResultCount++;
					v00320Bean.setImpErrorMsg(e.getMessage());
		    		tempList.add(v00320Bean);
		    		v00320.setOutList(tempList);
					continue;
				}finally{
					if(null != call){
						call.close();
					}
					if(null != rs){
						rs.close();
					}
				}
			}
			tran.commit();
			
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(rs, call, conn, session);
			if(sResultCount == 0){
				resultValue = 2;
			}else if(sResultCount > 0 && fResultCount == 0){
				resultValue = 1;
			}
			v00320.setOutFlag(resultValue);
		}
		return v00320;
	}


	
	@Override
	public Boolean GetExecPG(Pgv00320 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00320(?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			//传入输入参数
			call.setString(2, bean.getFcid());
			call.setDate(3, ConvertUtil.toSqlDate(bean.getPssd()));
			call.setString(4, bean.getCd00002Czr());
			call.execute();
			tran.commit();
			if(call.getInt(1)==0)
				bResult = true;
		} catch (Exception e) {
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	
	@Override
	public ArrayList<Pgv00320> LoadPGList(Pgv00320 bean) throws Exception {
		ArrayList<Pgv00320> resultList = new ArrayList<Pgv00320>();
		Session session = null;
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003201(?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, bean.getCd00001Szqy());
			call.setString(3, bean.getCd00352Xqdm());
			call.setString(4, bean.getCd00001Ssgx());
			call.setDate(5, ConvertUtil.utilDateToSqlDate(bean.getJysj()));
			call.setInt(6, bean.getIsPgjg());
			call.setString(7, bean.getZcdzl());
			call.setString(8, bean.getZh());
			call.setString(9, bean.getDyh());
			call.setString(10, bean.getFh());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				Pgv00320 e = new Pgv00320();
				e.setFcid(rs.getString(FCID));
				resultList.add(e);
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return resultList;
	}


	
	@Override
	public Pgv00320 LoadByPrimaryKey(Pgv00320 bean) throws Exception {
		ArrayList<Pgv00320> resultList = new ArrayList<Pgv00320>();
		Session session = null;
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00320(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, bean.getFcid());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				resultList.add(SetParameters(rs, false));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		if(null != resultList && resultList.size() > 0){
			return resultList.get(0);
		}else{
			return bean;
		}
	}

	
	@Override
	public ArrayList<Pgv00320> LoadPriceList(Pgv00320 bean) throws Exception {
		ArrayList<Pgv00320> resultList = new ArrayList<Pgv00320>();
		Session session = null;
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00320A(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, bean.getFcid());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				Pgv00320 e = new Pgv00320();
				e.setJysj(rs.getDate(JYSJ));
				e.setPgjg(rs.getBigDecimal(PGJG));
				resultList.add(e);
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return resultList;
	}

	
	@Override
	public ArrayList<Pgv00320> LoadByLhXqdm(Pgv00320 bean) throws Exception {
		ArrayList<Pgv00320> resultList = new ArrayList<Pgv00320>();
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003202(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, bean.getCd00306Id());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				resultList.add(SetParameters(rs,false));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return resultList;
	}

	
	@Override
	public String executeTZD(Pgv00302 bean) throws Exception {
		int iResult = 0;
		String fcidResult = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		Transaction tran = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_003201(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.INTEGER);
			call.registerOutParameter(2, OracleTypes.VARCHAR);
			call.setString(3, bean.getFcid());
			call.setString(4, bean.getFczh());
			call.setString(5, bean.getZjhm());
			call.setString(6, bean.getLxdh());
			call.setString(7, bean.getNsrmc());
			call.setString(8, bean.getCd00001Zjlx());
			call.setString(9, bean.getCd00001csfzjlx());
			call.setString(10, bean.getCsfnsrmc());
			call.setString(11, bean.getCsfzjhm());
			call.setString(12, bean.getCd00001Jylx());
			call.setDate(13, ConvertUtil.utilDateToSqlDate(bean.getDjrq()));
			call.setString(14, bean.getNote());
			call.setString(15, bean.getCd00001Ssgx());
			call.setDate(16, ConvertUtil.utilDateToSqlDate(bean.getJysj()));
			call.setString(17, bean.getCd00002Czr());
			call.setDouble(18, bean.getJyjg());
			call.setString(19,bean.getCsflxdh());
			call.execute();
			iResult = call.getInt(1);
			if(1 == iResult){
				fcidResult = call.getString(2);
				tran.commit();
			}else{
				tran.rollback();
			}
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return fcidResult;
	}

	
	@Override
	public ArrayList<Pgv00320> LoadQMPGByFCXX(Pgv00320 v00320) throws Exception {
		ArrayList<Pgv00320> listResult = new ArrayList<Pgv00320>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT003200(?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v00320.getCd00001Szqy());
			call.setString(3, v00320.getZcdzl());
			call.setString(4, v00320.getZh());
			call.setString(5, v00320.getDyh());
			call.setString(6, v00320.getFh());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetQMPGParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		
		return listResult;
		
	}

	
	@Override
	public ArrayList<Pgv00320e> LoadQMPGZhxz(Pgv00320e v00320e)throws Exception {
		ArrayList<Pgv00320e> listResult = new ArrayList<Pgv00320e>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00320C(?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 注册输入参数
			call.setString(2, v00320e.getCd00320Fcid());
			// 注册输入参数
			call.setString(3, v00320e.getCd00001Szqy());
			call.setString(4, v00320e.getCd00001Fwlx());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgv00320e e = new Pgv00320e();
				e.setCd00053Qtxzid(rs.getString("infoid"));
				e.setQtxznm(rs.getString("infonm"));
				e.setParentId(rs.getString("parentid"));
				e.setIsDir(rs.getBoolean("ISDIR"));
				e.setIsId(rs.getBoolean("ISID"));
				listResult.add(e);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	
	@Override
	public boolean GetDeleteCommand(Pgv00320 bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00320(?,?,?)}");
			call.setString(1, bean.getFcid());
			call.setString(2, bean.getCd00002Czr());
			call.setString(3, bean.getCd00001Ssgx());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return bResult;
	}

	
	@Override
	public boolean GetSelDeleteCommand(Pgv00320 bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT003201(?,?,?)}");
			call.setString(1, bean.getChkDel());
			call.setString(2, bean.getCd00002Czr());
			call.setString(3, bean.getCd00001Ssgx());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return bResult;
	}

	
	@Override
	public boolean GetUpdateCommand(Pgv00320 bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00320(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, bean.getFcid());
			call.setString(2, bean.getFczh());
			call.setString(3, bean.getClh());
			call.setString(4, bean.getZcdzl());
			call.setDouble(5, bean.getJzmj());
			call.setDouble(6, bean.getHdjg());
			call.setString(7, bean.getCd00352Xqdm());
			call.setInt(8, bean.getZlc());
			call.setInt(9, bean.getSzlc());
			call.setString(10, bean.getCd00001Fwlx());
			call.setString(11, bean.getCd00001Jzjg());
			call.setString(12, bean.getCd00001Ghyt());
			call.setString(13, bean.getCd00001jylx());
			call.setString(14, bean.getCd00001Ssgx());
			call.setString(15, bean.getZh());
			call.setString(16, bean.getDyh());
			call.setString(17, bean.getFh());
			call.setString(18, bean.getJcnf());
			call.setString(19, bean.getNsrmc());
			call.setString(20, bean.getCd00001Zjlx());
			call.setString(21, bean.getZjhm());
			call.setString(22, bean.getLxdh());
			call.setString(23, bean.getZhxzId());
			call.setString(24, bean.getNote());
			call.setString(25, bean.getCd00002Czr());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return bResult;
	}

	
	@Override
	public ArrayList<Pgv00320> LoadAllDZ(Pgv00320 bean) throws Exception {
		ArrayList<Pgv00320> resultList = new ArrayList<Pgv00320>();
		Session session = null;
		CallableStatement call = null;
		Connection conn = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003202(?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getCd00001Szqy());
			call.setString(5, bean.getCd00001Ssgx());
			call.setString(6, bean.getZcdzl());
			call.setString(7, bean.getZh());
			call.setString(8, bean.getDyh());
			call.setString(9, bean.getFh());
			call.setString(10, bean.getXqnm());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				resultList.add(SetParameters(rs,true));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs,call,conn,session);
		}
		return resultList;
	}

}
