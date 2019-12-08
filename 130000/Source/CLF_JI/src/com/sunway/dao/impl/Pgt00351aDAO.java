package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00351aDAO;
import com.sunway.util.Common;
import com.sunway.vo.Pgt00351a;
import com.sunway.vo.Pgv00351a;

/**
 * 市场法标准房价格维护交易价格
 * @category 系统维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00351aDAO extends BaseDAO implements IPgt00351aDAO {

	private static final String total = "TOTAL";
	private static final String rid = "RID";
	private static final String slid = "SLID";
	private static final String cd00351Slid = "CD_00351_SLID";
	private static final String jysj = "JYSJ";
	private static final String pfmjg = "PFMJG";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String czr = "CZR";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00351aDAO#LoadAll(com.sunway.vo.Pgv00351a)
	 */
	
	@Override
	public ArrayList<Pgv00351a> LoadAll(Pgv00351a v00351a) throws Exception {
		ArrayList<Pgv00351a> listResult = new ArrayList<Pgv00351a>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00351A(?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v00351a.getPageIndex());
			call.setInt(3, v00351a.getPageSize());
			call.setString(4, v00351a.getCd00351Slid());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetVParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00351aDAO#GetInsertCommand(com.sunway.vo.Pgt00351a)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt00351a t00351a) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00351A(?,?,?,?,?)}");
			// 传入输入参数
			call.setString(1, t00351a.getCd00351Slid());
			call.setDate(2, Common.converDate(t00351a.getJysj()));
			call.setDouble(3, t00351a.getPfmjg());
			call.setString(4, t00351a.getCd00002Czr());
			call.setString(5, t00351a.getNote());
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
	 * @see com.sunway.dao.IPgt00351aDAO#GetDeleteCommand(com.sunway.vo.Pgt00351a)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00351a t00351a) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00351A(?)}");
			// 传入输入参数
			call.setString(1, t00351a.getSlid());
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

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00351a SetVParameters(ResultSet rs) throws Exception {
		Pgv00351a e = new Pgv00351a();
		e.setRecordCount(rs.getInt(total));
		e.setRecordIndex(rs.getInt(rid));
		e.setSlid(rs.getString(slid));
		e.setCd00351Slid(rs.getString(cd00351Slid));
		e.setJysj(rs.getDate(jysj));
		e.setPfmjg(rs.getDouble(pfmjg));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setCzr(rs.getString(czr));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00351aDAO#LoadByPrimaryKey(com.sunway.vo.Pgt00351a)
	 */
	
	@Override
	public ArrayList<Pgv00351a> LoadByPrimaryKey(Pgt00351a t00351a) throws Exception {
		ArrayList<Pgv00351a> listResult = new ArrayList<Pgv00351a>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00351A(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t00351a.getSlid());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		//if (listResult != null && listResult.size() > 0) {
		return listResult;
		//} else {
		//	return new Pgt00351a();
		//}
	}
	
	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00351a SetTParameters(ResultSet rs) throws Exception {
		Pgv00351a e = new Pgv00351a();
		e.setSlid(rs.getString(slid));
		e.setCd00351Slid(rs.getString(cd00351Slid));
		e.setJysj(rs.getDate(jysj));
		e.setPfmjg(rs.getDouble(pfmjg));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		return e;
	}
}
