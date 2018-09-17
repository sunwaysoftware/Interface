/**
 * 
 */
package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00352mDAO;
import com.sunway.vo.Pgt00352m;

/**
 * 
 * 土地相关照片
 * 
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 * 
 */
public class Pgt00352mDAO extends BaseDAO implements IPgt00352mDAO {
	private static final String CZR = "CZR";
	private static final String CD00002CZR = "CD_00002_CZR";
	private static final String UPDDATE = "UPDDATE";
	private static final String Y = "Y";
	private static final String X = "X";
	private static final String CD00001SZQY = "CD_00001_SZQY";
	private static final String CD00001SZQYLX = "CD_00001_SZQYLX";
	private static final String CD00352XQDMHM = "CD_00352_XQDMHM";
	private static final String ID = "ID";
	private static final String XQNM = "XQNM";
	private static final String WKID="WKID";
	private static final String VIEWORDER="VIEWORDER";
	private static final String XQDMHM="XQDMHM";
	private static final String CD00001FWLX="CD_00001_FWLX";
	private static final String PFMJG="PFMJG";

	@Override
	public boolean GetInsertCommand(Pgt00352m t00352m) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		//Integer rs = 0;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn
					.prepareCall("{call PGSP_ADDT00352M(?,?,?,?,?)}");
			//call.registerOutParameter(1, OracleTypes.INTEGER);
			call.setString(1, t00352m.getCd00001Szqy());
			call.setString(2, t00352m.getCd00352Xqdmhm());
			call.setString(3, t00352m.getXys());
			call.setString(4, t00352m.getWkid());
			call.setString(5, t00352m.getCd00002Czr());
			call.execute();
//			rs = call.getInt(1);
//			if (1 == rs) {
			tran.commit();
//				bResult = true;
//			} else {
//				tran.rollback();
//			}
			bResult = true;
		} catch (Exception e) {
			tran.rollback();
			bResult = false;
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sunway.dao.IPgt00352mDAO#GetUpdateCommand(com.sunway.vo.Pgt00352m)
	 */

	@Override
	public boolean GetUpdateCommand(Pgt00352m t00352m) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00352m(?,?,?,?,?,?)}");
			
			call.execute();
			tran.commit();
			bResult = true;
		} catch (Exception e) {
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunway.dao.IPgt00352mDAO#LoadAll(com.sunway.vo.Pgt00352m)
	 */

	@Override
	public ArrayList<Pgt00352m> LoadAll(Pgt00352m t00352m) throws Exception {
		ArrayList<Pgt00352m> listResult = new ArrayList<Pgt00352m>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00352M(?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 傳入輸入參數
			call.setString(2, t00352m.getCd00001Szqy());
			call.setString(3, t00352m.getCd00352Xqdmhm());
			call.execute();
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetVParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn,null);
		}
		return listResult;
	}
	@Override
	public ArrayList<Pgt00352m> LoadAll0(Pgt00352m t00352m) throws Exception {
		ArrayList<Pgt00352m> listResult = new ArrayList<Pgt00352m>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00352M0(?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 傳入輸入參數
			call.setString(2, t00352m.getCd00001Szqy());
			call.setString(3, t00352m.getCd00352Xqdmhm());
			call.execute();
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetV0Parameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn,null);
		}
		return listResult;
	}
	protected Pgt00352m SetV0Parameters(ResultSet rs) throws Exception {
		Pgt00352m e = new Pgt00352m();		
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setXqdmhm(rs.getString(XQDMHM));
		e.setXqnm(rs.getString(XQNM));
	    e.setCd00001Fwlx(rs.getString(CD00001FWLX));
	    e.setPfmjg(rs.getDouble(PFMJG));
	    e.setWcount(rs.getDouble("wcount"));
	    e.setYcount(rs.getDouble("ycount"));
		return e;
	}


	protected Pgt00352m SetVParameters(ResultSet rs) throws Exception {
		Pgt00352m e = new Pgt00352m();
		e.setId(rs.getString(ID));
		e.setCd00352Xqdmhm(rs.getString(CD00352XQDMHM));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setX(rs.getDouble(X));
		e.setY(rs.getDouble(Y));
		e.setUpddate(rs.getDate(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setCzr(rs.getString(CZR));
		e.setXqnm(rs.getString(XQNM));
		e.setWkid(rs.getString(WKID));
		e.setVieworder(rs.getDouble(VIEWORDER));
		return e;
	}

	
	@Override
	public boolean GetDeleteAllCommand(Pgt00352m t00352m) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00352M(?,?)}");
			call.setString(1, t00352m.getCd00001Szqy());
			call.setString(2, t00352m.getCd00352Xqdmhm());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			tran.rollback();
			e.printStackTrace();
			bResult = false;
			throw e;
		}finally{
			getFree(call, conn, session);
		}
		return bResult;
	}

	@Override
	public boolean GetDeleteCommand(Pgt00352m t00352m) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
