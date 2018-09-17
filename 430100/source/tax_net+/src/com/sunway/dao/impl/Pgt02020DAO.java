package com.sunway.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt02020DAO;
import com.sunway.office.ExcelUtil;
import com.sunway.util.ConvertUtil;
import com.sunway.util.Excel;
import com.sunway.vo.Pgv02020;
import com.sunway.vo.Pgv02002;

public class Pgt02020DAO extends BaseDAO implements IPgt02020DAO{
	
	private static final String SZQY = "szqy";
	private static final String FCID = "fcid";
	private static final String ZCDZL = "zcdzl";
	private static final String ZH = "zh";
	private static final String DYH = "dyh";
	private static final String CD02050XQDM = "cd_02050_xqdm";
	private static final String CD00001FWLX = "cd_00001_fwlx";
	private static final String JCNF = "jcnf";
	private static final String CD00001JZJG = "cd_00001_jzjg";
	private static final String JZMJ = "jzmj";
	private static final String XQNM = "xqnm";
	private static final String FWLX = "fwlx";
	private static final String JZJG = "jzjg";
	private static final String TOTAL = "total";
	private static final String JYSJ = "jysj";
	private static final String PGJG = "pgjg";
	private static final String ZHXZ = "zhxz";
	private static final String UPDDATE = "upddate";
	private static final String CD00002CZR = "cd_00002_czr";
	private static final String NOTE = "NOTE";
	private static final String XQDMHM = "XQDMHM";
	private static final String JS="js";
	private static final String MK="mk";
	private static final String CLH="CLH";
	private static final String BWJFH="bwjfh";
	private static final String CZR="czr";
	private static final String SZCS="szcs";
	private static final String CS="cs";

	
	@Override
	public ArrayList<Pgv02020> LoadAll(Pgv02020 v02020) throws Exception {
		ArrayList<Pgv02020> resultList = new ArrayList<Pgv02020>();
		CallableStatement call = null;
		Connection conn = null;
		ResultSet rs = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02020(?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v02020.getPageIndex());
			call.setInt(3, v02020.getPageSize());
			call.setString(4, v02020.getCd00001Szqy());			
			call.setString(5, v02020.getCd00001Ssgx());
			call.setString(6, v02020.getZcdzl());
			call.setString(7, v02020.getZh());
			call.setString(8, v02020.getDyh());
			call.setString(9, v02020.getBwjfh());
			call.setString(10, v02020.getXqnm());
			call.setString(11, v02020.getClh());
			call.setString(12, v02020.getCd00001Fwlx());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				resultList.add(SetVParameters(rs,true));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return resultList;
	}
	
	
	@Override
	public ArrayList<Pgv02020> LoadAll1(Pgv02020 v02020) throws Exception {
		ArrayList<Pgv02020> resultList = new ArrayList<Pgv02020>();
		CallableStatement call = null;
		Connection conn = null;
		ResultSet rs = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020201(?,?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v02020.getPageIndex());
			call.setInt(3, v02020.getPageSize());
			call.setString(4, v02020.getCd00001Szqy());			
			call.setString(5, v02020.getCd00001Ssgx());
			call.setString(6, v02020.getZcdzl());
			call.setString(7, v02020.getZh());
			call.setString(8, v02020.getDyh());
			call.setString(9, v02020.getBwjfh());
			call.setString(10, v02020.getXqnm());
			call.setString(11, v02020.getClh());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				resultList.add(SetVParameters(rs,true));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return resultList;
	}
	
	/**
	 * 装载数据
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	protected Pgv02020 SetVParameters(ResultSet rs,Boolean sign)throws Exception {
		Pgv02020 e = new Pgv02020();		
		e.setRecordCount(rs.getInt(TOTAL));	
		e.setZcdzl(rs.getString(ZCDZL));
		e.setFcid(rs.getString(FCID));
		e.setBwjfh(rs.getString(BWJFH));
		e.setZh(rs.getString(ZH));
		e.setDyh(rs.getString(DYH));
		e.setCd02050Xqdm(rs.getString(CD02050XQDM));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setCs(rs.getInt(CS));
		e.setSzcs(rs.getString(SZCS));
		e.setJcnf(rs.getString(JCNF));
		e.setCd00001Jzjg(rs.getString(CD00001JZJG));
		e.setXqnm(rs.getString(XQNM));
		e.setFwlx(rs.getString(FWLX));
		e.setJzjg(rs.getString(JZJG));
		e.setSzqy(rs.getString(SZQY));
		e.setCd00001Szqy(rs.getString("CD_00001_SZQY"));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
	    e.setCzr(rs.getString(CZR));
	    e.setMk(rs.getDouble(MK));
	    e.setJs(rs.getDouble(JS));
		e.setNote(rs.getString(NOTE));
		e.setXqdmh(rs.getString(XQDMHM));
		e.setXqdmh(rs.getString(XQDMHM));
		e.setClh(rs.getString(CLH));
		return e;
	}
	
	/**
	 * 装载数据
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	protected Pgv02020 SetParameters(ResultSet rs,Boolean sign)throws Exception {
		Pgv02020 e = new Pgv02020();			
		e.setZcdzl(rs.getString(ZCDZL));
		e.setFcid(rs.getString(FCID));
		e.setBwjfh(rs.getString(BWJFH));
		e.setZh(rs.getString(ZH));
		e.setDyh(rs.getString(DYH));
		e.setCd02050Xqdm(rs.getString(CD02050XQDM));
		e.setCd00001Fwlx(rs.getString(CD00001FWLX));
		e.setCs(rs.getInt(CS));
		e.setSzcs(rs.getString(SZCS));
		e.setJcnf(rs.getString(JCNF));
		e.setCd00001Jzjg(rs.getString(CD00001JZJG));
		e.setXqnm(rs.getString(XQNM));
		e.setFwlx(rs.getString(FWLX));
		e.setJzjg(rs.getString(JZJG));
		e.setSzqy(rs.getString(SZQY));
		e.setCd00001Szqy(rs.getString("CD_00001_SZQY"));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
	    e.setCzr(rs.getString(CZR));
	    e.setMk(rs.getDouble(MK));
	    e.setJs(rs.getDouble(JS));
	    e.setClh(rs.getString(CLH));
		e.setNote(rs.getString(NOTE));
		e.setXqdmh(rs.getString(XQDMHM));
		e.setZhxz(rs.getString(ZHXZ));
		return e;
	}

	
	@Override
	public Pgv02020 ImportExcelData(ArrayList<Pgv02020> v02020List)throws Exception {
		Pgv02020 v02020 = new Pgv02020();
		ArrayList<Pgv02020> tempList = new ArrayList<Pgv02020>();
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
			
			call = conn.prepareCall("{call PGSP_ADDT020201(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			for(int i = 0; i < v02020List.size();i++){
				
				Pgv02020 v02020Bean = v02020List.get(i);
				try{
					tran = session.beginTransaction();
					call.registerOutParameter(1, OracleTypes.CURSOR);
					call.setString(2, v02020Bean.getSzqy());
					call.setString(3, v02020Bean.getXqdmh());
					call.setString(4, v02020Bean.getXqnm());
					call.setString(5, v02020Bean.getZcdzl());
					call.setString(6, v02020Bean.getZh());
					call.setString(7, v02020Bean.getDyh());
					call.setString(8, v02020Bean.getBwjfh());
					call.setString(9, v02020Bean.getFwlx());					
					call.setString(10, v02020Bean.getJcnf());
					call.setString(11,v02020Bean.getJzjg());
					call.setInt(12,v02020Bean.getCs());
					call.setString(13, v02020Bean.getSzcs());
					call.setDouble(14, v02020Bean.getMk());
					call.setDouble(15, v02020Bean.getJs());
					call.setString(16, v02020Bean.getNote());
					call.setString(17, v02020Bean.getClh());
					call.setString(18, v02020Bean.getZhxz());
					call.setString(19, v02020Bean.getCd00001Ssgx());
					call.setString(20,v02020Bean.getCd00002Czr());
					call.execute();
					rs = (ResultSet)call.getObject(1);
				    if(null != rs && rs.next()){
				    	if(rs.getInt("flag") == 0){
				    		sResultCount++;
				    		v02020Bean.setCd02050Xqdm(rs.getString("TXQDM"));
				    		v02020Bean.setCd00001Szqy(rs.getString("TSZQY"));
				    		v02020Bean.setCd00001Fwlx(rs.getString("TFWLX"));
				    		v02020Bean.setCd00001Jzjg(rs.getString("TJZJG"));	
				    		v02020Bean.setZhxzId(rs.getString("QTXZIDS"));
				    		v02020Bean.setXqdmhId(rs.getString("TDMH"));
				    		v02020Bean.setImpErrorMsg("");
				    		tempList.add(v02020Bean);
				    		v02020.setOutList(tempList);
				    	}
				    }
				    tran.commit();
				}catch(Exception e){
					tran.rollback();
					sResultCount++;
					e.printStackTrace();
					v02020Bean.setImpErrorMsg(e.getMessage());
		    		tempList.add(v02020Bean);
		    		v02020.setOutList(tempList);
					continue;
				}finally{
					try{
						if(null!=rs) 
							rs.close();
					}catch (Exception e) {
						e.printStackTrace();
					}finally {
						rs = null;
					}
				}
			}
			
			
		}catch(Exception e){
			
			e.printStackTrace();			
		}finally{
			getFree(call, conn, session);
			if(sResultCount == 0){
				resultValue = 2;
//				WriteLogImp(v02020List.get(0).getCd00001Ssgx(), "PGT02020", v02020List.get(0).getCd00002Czr(), "全面评估录入导入成功");
			}else if(sResultCount > 0 && fResultCount == 0){
				resultValue = 1;
//				WriteLogImp(v02020List.get(0).getCd00001Ssgx(), "PGT02020", v02020List.get(0).getCd00002Czr(), "全面评估导入导入有异常");
			}
			v02020.setOutFlag(resultValue);
		}
		return v02020;
	}


	
	@Override
	public Boolean GetExecPG(Pgv02020 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02020(?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			//传入输入参数
			call.setString(2, bean.getFcid());
			call.setDate(3, ConvertUtil.toSqlDate(""));
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
	public Pgv02020 LoadPGJG(Pgv02020 bean) throws Exception {
		ArrayList<Pgv02020> resultList = new ArrayList<Pgv02020>();
		CallableStatement call = null;
		Connection conn = null;
		ResultSet rs = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT020201(?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, bean.getCd02050Xqdm());
			call.setString(3, bean.getZh());
			call.setString(4, bean.getDyh());
			call.setString(5, bean.getBwjfh());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				Pgv02020 e = SetParameters(rs,false);
				e.setPgjg(rs.getBigDecimal(PGJG));
				resultList.add(e);
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		if(null != resultList && resultList.size() > 0){
			return resultList.get(0);
		}else{
			return bean;
		}
		
	}

	
	@Override
	public ArrayList<Pgv02020> LoadPGList(Pgv02020 bean) throws Exception {
		ArrayList<Pgv02020> resultList = new ArrayList<Pgv02020>();
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020201(?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, bean.getCd00001Szqy());
			call.setString(3, bean.getXqnm());
			call.setString(4, bean.getCd00001Ssgx());
			call.setString(5, bean.getZcdzl());
			call.setString(6, bean.getFczh());
			call.setString(7, bean.getCd02050Xqdm());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				Pgv02020 e = new Pgv02020();
				e.setFcid(rs.getString(FCID));
				resultList.add(e);
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return resultList;
	}


	
	@Override
	public Pgv02020 LoadByPrimaryKey(Pgv02020 bean) throws Exception {
		ArrayList<Pgv02020> resultList = new ArrayList<Pgv02020>();
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02020(?,?)}");
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
			getFree(rs, call, conn, null);
		}
		if(null != resultList && resultList.size() > 0){
			return resultList.get(0);
		}else{
			return bean;
		}
	}

	
	@Override
	public ArrayList<Pgv02020> LoadPriceList(Pgv02020 bean) throws Exception {
		ArrayList<Pgv02020> resultList = new ArrayList<Pgv02020>();
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02020A(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, bean.getFcid());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				Pgv02020 e = new Pgv02020();
				e.setCd02020aId(rs.getString("ID"));
				e.setJysj(rs.getDate(JYSJ));
				e.setPgjg(rs.getBigDecimal(PGJG));
				e.setJzmj(rs.getDouble(JZMJ));
				if(e.getJzmj() > 0)
				{
					e.setPgdj(e.getPgjg().divide(BigDecimal.valueOf(e.getJzmj()), 2, BigDecimal.ROUND_HALF_UP));
				}else
				{
					e.setPgdj(BigDecimal.valueOf(0.0));
				}
				
				resultList.add(e);
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return resultList;
	}

	
	@Override
	public ArrayList<Pgv02020> LoadByLhXqdm(Pgv02020 bean) throws Exception {
		ArrayList<Pgv02020> resultList = new ArrayList<Pgv02020>();
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020202(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, bean.getFcid());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				resultList.add(SetParameters(rs,false));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return resultList;
	}

	
	@Override
	public String executeTZD(Pgv02002 bean) throws Exception {
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
			call = conn.prepareCall("{call PGSP_CZ_020201(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.INTEGER);
			call.registerOutParameter(2, OracleTypes.VARCHAR);
			call.setString(3, bean.getFcid());
			call.setString(4, bean.getFczh());
			call.setString(5, bean.getZjhm());
			call.setString(6, bean.getLxdh());
			call.setString(7, bean.getNsrmc());
			call.setString(8, bean.getCd00001Zjlx());
			call.setString(9, bean.getCd00001Csfzjlx());
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
	public boolean GetDeleteCommand(Pgv02020 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02020(?,?,?)}");
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
	public boolean GetSelDeleteCommand(Pgv02020 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT020201(?,?,?)}");
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
	public boolean GetUpdateCommand(Pgv02020 bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02020(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, bean.getFcid());
			call.setString(2, bean.getFczh());
			call.setString(3, bean.getZcdzl());
			call.setString(4, bean.getZh());
			call.setString(5, bean.getDyh());
			call.setString(6, bean.getCd02050Xqdm());
			call.setString(7, bean.getCd00001Fwlx());
			call.setInt(8, bean.getCs());
			call.setString(9, bean.getSzcs());
			call.setString(10, bean.getJcnf());
			call.setString(11, bean.getCd00001Jzjg());
			call.setDouble(12, bean.getJzmj());
			call.setString(14, bean.getCd00001Ssgx());
			call.setString(15, bean.getCd00002Czr());
			call.setString(16, bean.getZhxzId());
			call.setDouble(17, bean.getMk());
			call.setDouble(18, bean.getJs());
			call.setString(19, bean.getNote());
			call.setString(20, bean.getBwjfh());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			e.printStackTrace();
			tran.rollback();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return bResult;
	}	

	
	@Override
	public boolean GetDeleteAllCommand(Pgv02020 v02020) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT020202(?,?,?,?)}");
			call.setString(1, v02020.getCd00001Szqy());
			call.setString(2, v02020.getXqnm());
			call.setString(3, v02020.getCd00001Ssgx());
			call.setString(4, v02020.getCd00002Czr());
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
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt02020DAO#GetFwtdzl(com.sunway.vo.Pgv02020)
	 */
	
	@Override
	public ArrayList<String> GetFwtdzl(Pgv02020 v02020) throws Exception {
		ArrayList<String> listResult = new ArrayList<String>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_AUTO_02020A(?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v02020.getSzqy());
			call.setString(3, v02020.getZcdzl());
			call.setString(4, v02020.getCd00001Ssgx());
			call.execute();
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(rs.getString(1));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}


	
	@Override
	public OutputStream ExportData(Pgv02020 v02020) throws Exception {
		ByteArrayOutputStream result = null;
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try
		{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02020(?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v02020.getPageIndex());
			call.setInt(3, v02020.getPageSize());
			call.setString(4, v02020.getCd00001Szqy());			
			call.setString(5, v02020.getCd00001Ssgx());
			call.setString(6, v02020.getZcdzl());
			call.setString(7, v02020.getZh());
			call.setString(8, v02020.getDyh());
			call.setString(9, v02020.getBwjfh());
			call.setString(10, v02020.getXqnm());
			call.setString(11, v02020.getClh());
			call.setString(12, v02020.getCd00001Fwlx());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			result = ExcelUtil.expExcel(rs, Excel.excelPath(v02020.getExpFileName()), null);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}finally{
			getFree(rs, call, conn, null);
		}
		return result;
	}


	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02020DAO#ImportExcelDataSimple(java.util.ArrayList)
	 */
	
	@Override
	public Pgv02020 ImportExcelDataSimple(Pgv02020 v02020Bean) throws Exception {
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		ResultSet rs = null;
		
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			
			call = conn.prepareCall("{call PGSP_ADDT020201(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, v02020Bean.getFczh());
			call.setString(4, v02020Bean.getParentnm());
			call.setString(5, v02020Bean.getSzqy());
			call.setString(6, v02020Bean.getXqdmh());
			call.setString(7, v02020Bean.getXqnm());
			call.setString(8, v02020Bean.getJcnf());
			call.setString(9, v02020Bean.getZcdzl());
			call.setDouble(10, v02020Bean.getJzmj());
			call.setString(11, v02020Bean.getZh());
			call.setString(12, v02020Bean.getBwjfh());
			call.setString(13, v02020Bean.getDyh());
			call.setString(14, v02020Bean.getFwlx());
			call.setInt(15,v02020Bean.getCs());
			call.setString(16, v02020Bean.getSzcs());
			call.setString(17, v02020Bean.getCd00001Ssgx());
			call.setString(18,v02020Bean.getCd00002Czr());
			call.setString(19, v02020Bean.getNote());
			call.setDouble(20, v02020Bean.getMk());
			call.setDouble(21, v02020Bean.getJs());
			call.setString(22,v02020Bean.getJzjg());
			call.setString(23, v02020Bean.getZhxz());
			
			call.execute();
			rs = (ResultSet)call.getObject(1);
		    if(null != rs && rs.next()){
		    	if(rs.getInt("flag") == 0){
		    		v02020Bean.setCd02050Xqdm(rs.getString("TXQDM"));
		    		v02020Bean.setCd00001Szqy(rs.getString("TSZQY"));
		    		v02020Bean.setCd00001Fwlx(rs.getString("TFWLX"));
		    		v02020Bean.setCd00001Jzjg(rs.getString("TJZJG"));	
		    		v02020Bean.setZhxzId(rs.getString("QTXZIDS"));
		    		v02020Bean.setXqdmhId(rs.getString("TDMH"));
		    		
		    		/*v02020Bean.setCd00001Dywz(rs.getString("TDYWZ"));
		    		v02020Bean.setCd00001Fqwz(rs.getString("TFQWZ"));
		    		v02020Bean.setCd00001Fwcx(rs.getString("TFWCX"));
		    		v02020Bean.settZcdzl(rs.getString("TZCDZL"));
		    		v02020Bean.settFczh(rs.getString("TFCZH"));*/
		    		v02020Bean.setImpErrorMsg("");
		    		v02020Bean.setOutFlag(1);
		    		return v02020Bean;
		    	}
		    }
		    tran.commit();
		    v02020Bean.setOutFlag(2);
		}catch(Exception e){
			tran.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return v02020Bean;
	}

}
