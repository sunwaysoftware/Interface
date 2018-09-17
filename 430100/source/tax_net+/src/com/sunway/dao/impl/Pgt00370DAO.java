package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00370DAO;
import com.sunway.vo.Pgt00370;
import com.sunway.vo.Pgv00370;

/**
 * 税种
 * @author HuanWei
 *
 */
public class Pgt00370DAO extends BaseDAO implements IPgt00370DAO {
	
	private static final String FCID = "fcid";					//国土编码
	private static final String CD00001SZLX = "cd_00001_szlx";	//税种类型
	private static final String CD00001SZ = "cd_00001_sz";		//税种
	private static final String SE = "se";						//税额
	private static final String UPDDATE = "upddate";				//更新时间
	private static final String CD00002CZR = "cd_00002_czr";		//操作人
	private static final String NOTE = "note";					//备注
	private static final String SZ = "sz";
//	private static final String RID = "rid";						//行号
//	private static final String TOTAL = "total";					//总记录数
	//private static final String FPID = "fpid";					//发票
	//private static final String SPID = "spid";					//税票
	

	
	@Override
	public boolean GetInsertCommand(Pgt00370 t00370) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_ADDT00370(?,?,?,?,?)}");
			call.setString(1, t00370.getFcid());
			call.setString(2, t00370.getCd_00001_sz());
			call.setDouble(3, t00370.getSe());
			call.setString(4, t00370.getCd_00002_czr());
			call.setString(5, t00370.getNote());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call,conn,session);
		}
		return bResult;
	}
	
	
	@Override
	public boolean GetDeleteCommand(Pgt00370 t00370) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_DELT00370(?,?)}");
			call.setString(1, t00370.getFcid());
			call.setString(2, t00370.getCd_00001_sz());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call,conn,session);
		}
		return bResult;
	}

	
	@Override
	public boolean GetUpdateCommand(Pgt00370 t00370) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_UPDT00370(?,?,?,?,?,?,?)}");
			call.setString(1, t00370.getFcid());
			call.setString(2, t00370.getCd_00001_szlx());
			call.setString(3, t00370.getCd_00001_sz());
			call.setDouble(4, t00370.getSe());
			call.setString(5, t00370.getCd_00002_czr());
			call.setString(6, t00370.getNote());
			call.setString(7, t00370.getSsgx());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call,conn,session);
		}
		return bResult;
	}

	
	@Override
	public ArrayList<Pgv00370> LoadAll(Pgv00370 v00370) throws Exception {
		ArrayList<Pgv00370> listResult = new ArrayList<Pgv00370>();
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00370(?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(1, v00370.getPageIndex());
			call.setInt(2, v00370.getPageSize());
			call.setString(3, v00370.getFcid());
			call.setString(4, v00370.getCd_00001_szlx());
			call.setString(5, v00370.getCd_00001_sz());
			call.setDouble(6, v00370.getSe());
			call.setString(7, v00370.getCd_00002_czr());
			call.setString(8, v00370.getNote());
			call.setString(9, v00370.getSsgx());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				listResult.add(SetVParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	protected Pgv00370 SetVParameters(ResultSet rs)throws Exception {
		Pgv00370 e = new Pgv00370();
		e.setFcid(rs.getString(FCID));
		e.setCd_00001_szlx(rs.getString(CD00001SZLX));
		e.setCd_00001_sz(rs.getString(CD00001SZ));
		e.setSe(rs.getDouble(SE));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd_00002_czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
//		e.setRecordIndex(rs.getInt(RID));
//		e.setRecordCount(rs.getInt(TOTAL));
		e.setSz(rs.getString(SZ));
//		e.setFpid(rs.getString(FPID));
//		e.setSpid(rs.getString(SPID));
		return e;
	}

	
	@Override
	public ArrayList<Pgv00370> LoadByPrimaryKey(Pgv00370 v00370) throws Exception {
		ArrayList<Pgv00370> listResult = new ArrayList<Pgv00370>();
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00370(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, v00370.getFcid());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				listResult.add(SetVParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	
	public ArrayList<Pgv00370> LoadByPrimaryKey_B(Pgv00370 v00370) throws Exception {
		ArrayList<Pgv00370> listResult = new ArrayList<Pgv00370>();
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00370_B(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, v00370.getFcid());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				listResult.add(SetVParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	protected Pgt00370 SetTParameters(ResultSet rs)throws Exception {
		Pgt00370 e = new Pgt00370();
		e.setFcid(rs.getString(FCID));
		e.setCd_00001_szlx(rs.getString(CD00001SZLX));
		e.setCd_00001_sz(rs.getString(CD00001SZ));
		e.setSe(rs.getDouble(SE));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd_00002_czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		return e;
	}

	
	@Override
	public boolean GetInsertCommandFPSP(Pgv00370 v00370) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Transaction tran = null;
		Session session = null;
		CallableStatement call = null;
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_ADDT003701(?,?,?,?,?,?)}");
			call.setString(1, v00370.getFcid());
			call.setString(2, v00370.getFpid());
			call.setString(3, v00370.getSpid());
			call.setString(4, v00370.getDfspid());
			call.setString(5, v00370.getCd_00002_czr());
			call.setString(6, v00370.getNote());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call,conn,session);
		}
		return bResult;
	}

}
