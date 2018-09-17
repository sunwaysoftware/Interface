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

import com.sunway.dao.IPgt00352m1DAO;
import com.sunway.vo.Pgt00352m1;

/**
 * 
 * 所在区域的地图范围
 * 
 * @category 数据采集
 * @version 1.0
 * 
 */
public class Pgt00352m1DAO extends BaseDAO implements IPgt00352m1DAO {
	private static final String CD00002CZR = "CD_00002_CZR";
	private static final String UPDDATE = "UPDDATE";
	private static final String XMIN = "XMIN";
	private static final String YMIN = "YMIN";
	private static final String XMAX = "XMAX";
	private static final String YMAX = "YMAX";
	private static final String CD00001SZQY = "CD_00001_SZQY";
	private static final String CD00001SZQYLX = "CD_00001_SZQYLX";
	private static final String WKID = "WKID";

	// private static final String CZR = "CZR";
	// private static final String ID = "ID";
	// private static final String XQNM = "XQNM";
	// private static final String VIEWORDER="VIEWORDER";

	@Override
	public boolean GetInsertCommand(Pgt00352m1 t00352m1) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		// Integer rs = 0;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00352m1(?,?,?,?,?,?,?)}");
			call.setString(1, t00352m1.getCd00001Szqy());
			call.setDouble(2, t00352m1.getxMin());
			call.setDouble(3, t00352m1.getyMin());
			call.setDouble(4, t00352m1.getxMax());
			call.setDouble(5, t00352m1.getyMax());
			call.setString(6, t00352m1.getWkid());
			call.setString(7, t00352m1.getCd00002Czr());
			call.execute();			
			tran.commit();			
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
	 * com.sunway.dao.IPgt00352m1DAO#GetUpdateCommand(com.sunway.vo.Pgt00352m1)
	 */

	@Override
	public boolean GetUpdateCommand(Pgt00352m1 t00352m1) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00352m1(?,?,?,?,?,?)}");

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
	 * @see com.sunway.dao.IPgt00352m1DAO#LoadAll(com.sunway.vo.Pgt00352m1)
	 */

	@Override
	public ArrayList<Pgt00352m1> LoadAll(Pgt00352m1 t00352m1) throws Exception {
		ArrayList<Pgt00352m1> listResult = new ArrayList<Pgt00352m1>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00352M1(?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 傳入輸入參數
			call.setString(2, t00352m1.getCd00001Szqy());
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

	protected Pgt00352m1 SetVParameters(ResultSet rs) throws Exception {
		Pgt00352m1 e = new Pgt00352m1();
		// e.setId(rs.getString(ID));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setxMin(rs.getDouble(XMIN));
		e.setyMin(rs.getDouble(YMIN));
		e.setxMax(rs.getDouble(XMAX));
		e.setyMax(rs.getDouble(YMAX));
		e.setUpddate(rs.getDate(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		// e.setCzr(rs.getString(CZR));
		// e.setXqnm(rs.getString(XQNM));
		e.setWkid(rs.getString(WKID));
		// e.setVieworder(rs.getDouble(VIEWORDER));
		return e;
	}

	@Override
	public boolean GetDeleteAllCommand(Pgt00352m1 t00352m1) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00352M1(?)}");
			call.setString(1, t00352m1.getCd00001Szqy());
			call.execute();
			tran.commit();
			bResult = true;
		} catch (Exception e) {
			tran.rollback();
			e.printStackTrace();
			bResult = false;
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	@Override
	public boolean GetDeleteCommand(Pgt00352m1 t00352m1) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
