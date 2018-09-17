package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt02070DAO;
import com.sunway.vo.Pgt02070;

/**
 * 税种
 * @author HuanWei
 *
 */
public class Pgt02070DAO extends BaseDAO implements IPgt02070DAO {
	
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
	public boolean GetInsertCommand(Pgt02070 t02070) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_ADDT02070(?,?,?,?,?)}");
			call.setString(1, t02070.getFcid());
			call.setString(2, t02070.getCd_00001_sz());
			call.setDouble(3, t02070.getSe());
			call.setString(4, t02070.getCd_00002_czr());
			call.setString(5, t02070.getNote());
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
	public boolean GetDeleteCommand(Pgt02070 t02070) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_DELT02070(?,?)}");
			call.setString(1, t02070.getFcid());
			call.setString(2, t02070.getCd_00001_sz());
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
	public boolean GetUpdateCommand(Pgt02070 t02070) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_UPDT02070(?,?,?,?,?,?,?)}");
			call.setString(1, t02070.getFcid());
			call.setString(2, t02070.getCd_00001_szlx());
			call.setString(3, t02070.getCd_00001_sz());
			call.setDouble(4, t02070.getSe());
			call.setString(5, t02070.getCd_00002_czr());
			call.setString(6, t02070.getNote());
			call.setString(7, t02070.getSsgx());
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
	public ArrayList<Pgt02070> LoadAll(Pgt02070 v02070) throws Exception {
		ArrayList<Pgt02070> listResult = new ArrayList<Pgt02070>();
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02070(?,?,?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(1, v02070.getPageIndex());
			call.setInt(2, v02070.getPageSize());
			call.setString(3, v02070.getFcid());
			call.setString(4, v02070.getCd_00001_szlx());
			call.setString(5, v02070.getCd_00001_sz());
			call.setDouble(6, v02070.getSe());
			call.setString(7, v02070.getCd_00002_czr());
			call.setString(8, v02070.getNote());
			call.setString(9, v02070.getSsgx());
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
	
	protected Pgt02070 SetVParameters(ResultSet rs)throws Exception {
		Pgt02070 e = new Pgt02070();
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
	public ArrayList<Pgt02070> LoadByPrimaryKey(Pgt02070 v02070) throws Exception {
		ArrayList<Pgt02070> listResult = new ArrayList<Pgt02070>();
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02070(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, v02070.getFcid());
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
	
	
	public ArrayList<Pgt02070> LoadByPrimaryKey_B(Pgt02070 v02070) throws Exception {
		ArrayList<Pgt02070> listResult = new ArrayList<Pgt02070>();
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		ResultSet rs = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02070_B(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, v02070.getFcid());
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
	
	protected Pgt02070 SetTParameters(ResultSet rs)throws Exception {
		Pgt02070 e = new Pgt02070();
		e.setFcid(rs.getString(FCID));
		e.setCd_00001_szlx(rs.getString(CD00001SZLX));
		e.setCd_00001_sz(rs.getString(CD00001SZ));
		e.setSe(rs.getDouble(SE));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd_00002_czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		return e;
	}

	
	/*@Override
	public boolean GetInsertCommandFPSP(Pgt02070 v02070) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Transaction tran = null;
		Session session = null;
		CallableStatement call = null;
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_ADDT020701(?,?,?,?,?,?)}");
			call.setString(1, v02070.getFcid());
			call.setString(2, v02070.getFpid());
			call.setString(3, v02070.getSpid());
			call.setString(4, v02070.getDfspid());
			call.setString(5, v02070.getCd_00002_czr());
			call.setString(6, v02070.getNote());
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
	}*/

}
