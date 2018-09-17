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

import com.sunway.dao.IPgt02060DAO;
import com.sunway.office.ExcelUtil;
import com.sunway.util.ConvertUtil;
import com.sunway.util.Excel;
import com.sunway.vo.Pgv02002;
import com.sunway.vo.Pgv02060;

public class Pgt02060DAO extends BaseDAO implements IPgt02060DAO{
	
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
	private static final String CLH="CLH";
	private static final String MK="mk";
	private static final String BWJFH="bwjfh";
	private static final String CZR="czr";
	private static final String SZCS="szcs";
	private static final String CS="cs";
	private static final String JYJG="JYJG";

	
	@Override
	public ArrayList<Pgv02060> LoadAll(Pgv02060 v02060) throws Exception {
		ArrayList<Pgv02060> resultList = new ArrayList<Pgv02060>();
		CallableStatement call = null;
		Connection conn = null;
		ResultSet rs = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02060(?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, v02060.getPageIndex());
			call.setInt(3, v02060.getPageSize());
			call.setString(4, v02060.getCd00001Szqy());			
			call.setString(5, v02060.getCd00001Ssgx());
			call.setString(6, v02060.getZcdzl());
			call.setString(7, v02060.getZh());
			call.setString(8, v02060.getDyh());
			call.setString(9, v02060.getBwjfh());
			call.setString(10, v02060.getXqnm());
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
	protected Pgv02060 SetVParameters(ResultSet rs,Boolean sign)throws Exception {
		Pgv02060 e = new Pgv02060();		
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
		e.setJysj(rs.getDate(JYSJ));
		e.setJyjg(rs.getBigDecimal(JYJG));
		return e;
	}
	
	/**
	 * 装载数据
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	protected Pgv02060 SetParameters(ResultSet rs,Boolean sign)throws Exception {
		Pgv02060 e = new Pgv02060();			
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
		e.setZhxz(rs.getString(ZHXZ));
		e.setJysj(rs.getDate(JYSJ));
		e.setJyjg(rs.getBigDecimal(JYJG));
		e.setClh(rs.getString(CLH));
		return e;
	}

	
	@Override
	public Pgv02060 ImportExcelData(ArrayList<Pgv02060> v02060List)throws Exception {
		Pgv02060 v02060 = new Pgv02060();
		ArrayList<Pgv02060> tempList = new ArrayList<Pgv02060>();
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
			
			call = conn.prepareCall("{call PGSP_ADDT020601(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			for(int i = 0; i < v02060List.size();i++){
				
				Pgv02060 v02060Bean = v02060List.get(i);
				try{
					tran = session.beginTransaction();
					call.registerOutParameter(1, OracleTypes.CURSOR);
					call.setString(2, v02060Bean.getSzqy());
					call.setString(3, v02060Bean.getXqdmh());
					call.setString(4, v02060Bean.getXqnm());
					call.setString(5, v02060Bean.getZcdzl());
					call.setString(6, v02060Bean.getZh());
					call.setString(7, v02060Bean.getDyh());
					call.setString(8, v02060Bean.getBwjfh());
					call.setString(9, v02060Bean.getFwlx());					
					call.setString(10, v02060Bean.getJcnf());
					call.setString(11,v02060Bean.getJzjg());
					call.setInt(12,v02060Bean.getCs());
					call.setString(13, v02060Bean.getSzcs());
					call.setDouble(14, v02060Bean.getMk());
					call.setDouble(15, v02060Bean.getJs());
					call.setDate(16, ConvertUtil.utilDateToSqlDate(v02060Bean.getJysj()));
					call.setBigDecimal(17, v02060Bean.getJyjg());
					call.setString(18, v02060Bean.getNote());
					call.setString(19, v02060Bean.getClh());
					call.setString(20, v02060Bean.getZhxz());
					call.setString(21, v02060Bean.getCd00001Ssgx());
					call.setString(22,v02060Bean.getCd00002Czr());
					call.execute();
					rs = (ResultSet)call.getObject(1);
				    if(null != rs && rs.next()){
				    	if(rs.getInt("flag") == 0){
				    		sResultCount++;
				    		v02060Bean.setCd02050Xqdm(rs.getString("TXQDM"));
				    		v02060Bean.setCd00001Szqy(rs.getString("TSZQY"));
				    		v02060Bean.setCd00001Fwlx(rs.getString("TFWLX"));
				    		v02060Bean.setCd00001Jzjg(rs.getString("TJZJG"));	
				    		v02060Bean.setZhxzId(rs.getString("QTXZIDS"));
				    		v02060Bean.setXqdmhId(rs.getString("TDMH"));
				    		v02060Bean.setImpErrorMsg("");
				    		tempList.add(v02060Bean);
				    		v02060.setOutList(tempList);
				    	}
				    }
				    tran.commit();
				}catch(Exception e){
					tran.rollback();
					sResultCount++;
					e.printStackTrace();
					v02060Bean.setImpErrorMsg(e.getMessage());
		    		tempList.add(v02060Bean);
		    		v02060.setOutList(tempList);
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
//				WriteLogImp(v02060List.get(0).getCd00001Ssgx(), "PGT02060", v02060List.get(0).getCd00002Czr(), "全面评估录入导入成功");
			}else if(sResultCount > 0 && fResultCount == 0){
				resultValue = 1;
//				WriteLogImp(v02060List.get(0).getCd00001Ssgx(), "PGT02060", v02060List.get(0).getCd00002Czr(), "全面评估导入导入有异常");
			}
			v02060.setOutFlag(resultValue);
		}
		return v02060;
	}


	
	@Override
	public Boolean GetExecPG(Pgv02060 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02060(?,?,?,?)}");
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
	public Pgv02060 LoadPGJG(Pgv02060 bean) throws Exception {
		ArrayList<Pgv02060> resultList = new ArrayList<Pgv02060>();
		CallableStatement call = null;
		Connection conn = null;
		ResultSet rs = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT020601(?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, bean.getCd02050Xqdm());
			call.setString(3, bean.getZh());
			call.setString(4, bean.getDyh());
			call.setString(5, bean.getBwjfh());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				Pgv02060 e = SetParameters(rs,false);
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
	public ArrayList<Pgv02060> LoadPGList(Pgv02060 bean) throws Exception {
		ArrayList<Pgv02060> resultList = new ArrayList<Pgv02060>();
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020601(?,?,?,?,?,?,?)}");
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
				Pgv02060 e = new Pgv02060();
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
	public Pgv02060 LoadByPrimaryKey(Pgv02060 bean) throws Exception {
		ArrayList<Pgv02060> resultList = new ArrayList<Pgv02060>();
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02060(?,?)}");
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
	public ArrayList<Pgv02060> LoadPriceList(Pgv02060 bean) throws Exception {
		ArrayList<Pgv02060> resultList = new ArrayList<Pgv02060>();
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02060A(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, bean.getFcid());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				Pgv02060 e = new Pgv02060();
				e.setCd02060aId(rs.getString("ID"));
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
	public ArrayList<Pgv02060> LoadByLhXqdm(Pgv02060 bean) throws Exception {
		ArrayList<Pgv02060> resultList = new ArrayList<Pgv02060>();
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020602(?,?)}");
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
			call = conn.prepareCall("{call PGSP_CZ_020601(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
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
	public boolean GetDeleteCommand(Pgv02060 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02060(?,?,?)}");
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
	public boolean GetSelDeleteCommand(Pgv02060 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT020601(?,?,?)}");
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
	public boolean GetUpdateCommand(Pgv02060 bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02060(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
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
	public boolean GetDeleteAllCommand(Pgv02060 v02060) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT020602(?,?,?,?)}");
			call.setString(1, v02060.getCd00001Szqy());
			call.setString(2, v02060.getXqnm());
			call.setString(3, v02060.getCd00001Ssgx());
			call.setString(4, v02060.getCd00002Czr());
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
	public OutputStream ExportData(Pgv02060 v02060) throws Exception {
		ByteArrayOutputStream result = null;
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		try
		{
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02060(?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setDouble(2, v02060.getExportS());
			call.setDouble(3, v02060.getExportE());
			call.setString(4, v02060.getCd00001Szqy());
			call.setString(5, v02060.getXqnm());
			call.setString(6, v02060.getCd00001Ssgx());
			call.setString(7, v02060.getZcdzl());
			call.setString(8, v02060.getFczh());
			call.setString(9, v02060.getCd02050Xqdm());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			result = ExcelUtil.expExcel(rs, Excel.excelPath(v02060.getExpFileName()), null);
			//填写导出日志
//			WriteLogExp(v02060.getCd00001Ssgx(), "PGT02060", v02060.getCd00002Czr(), "全面评估导出成功");
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
	 * @see com.sunway.dao.IPgt02060DAO#ImportExcelDataSimple(java.util.ArrayList)
	 */
	
	@Override
	public Pgv02060 ImportExcelDataSimple(Pgv02060 v02060Bean) throws Exception {
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		ResultSet rs = null;
		
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			
			call = conn.prepareCall("{call PGSP_ADDT020601(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, v02060Bean.getFczh());
			call.setString(4, v02060Bean.getParentnm());
			call.setString(5, v02060Bean.getSzqy());
			call.setString(6, v02060Bean.getXqdmh());
			call.setString(7, v02060Bean.getXqnm());
			call.setString(8, v02060Bean.getJcnf());
			call.setString(9, v02060Bean.getZcdzl());
			call.setDouble(10, v02060Bean.getJzmj());
			call.setString(11, v02060Bean.getZh());
			call.setString(12, v02060Bean.getBwjfh());
			call.setString(13, v02060Bean.getDyh());
			call.setString(14, v02060Bean.getFwlx());
			call.setInt(15,v02060Bean.getCs());
			call.setString(16, v02060Bean.getSzcs());
			call.setString(17, v02060Bean.getCd00001Ssgx());
			call.setString(18,v02060Bean.getCd00002Czr());
			call.setString(19, v02060Bean.getNote());
			call.setDouble(20, v02060Bean.getMk());
			call.setDouble(21, v02060Bean.getJs());
			call.setString(22,v02060Bean.getJzjg());
			call.setString(23, v02060Bean.getZhxz());
			
			call.execute();
			rs = (ResultSet)call.getObject(1);
		    if(null != rs && rs.next()){
		    	if(rs.getInt("flag") == 0){
		    		v02060Bean.setCd02050Xqdm(rs.getString("TXQDM"));
		    		v02060Bean.setCd00001Szqy(rs.getString("TSZQY"));
		    		v02060Bean.setCd00001Fwlx(rs.getString("TFWLX"));
		    		v02060Bean.setCd00001Jzjg(rs.getString("TJZJG"));	
		    		v02060Bean.setZhxzId(rs.getString("QTXZIDS"));
		    		v02060Bean.setXqdmhId(rs.getString("TDMH"));
		    		
		    		/*v02060Bean.setCd00001Dywz(rs.getString("TDYWZ"));
		    		v02060Bean.setCd00001Fqwz(rs.getString("TFQWZ"));
		    		v02060Bean.setCd00001Fwcx(rs.getString("TFWCX"));
		    		v02060Bean.settZcdzl(rs.getString("TZCDZL"));
		    		v02060Bean.settFczh(rs.getString("TFCZH"));*/
		    		v02060Bean.setImpErrorMsg("");
		    		v02060Bean.setOutFlag(1);
		    		return v02060Bean;
		    	}
		    }
		    tran.commit();
		    v02060Bean.setOutFlag(2);
		}catch(Exception e){
			tran.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return v02060Bean;
	}

}
