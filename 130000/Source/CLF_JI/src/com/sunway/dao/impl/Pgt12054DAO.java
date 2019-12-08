package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt12054DAO;
import com.sunway.vo.Pgt12054;
import com.sunway.vo.Pgv12054;

/**
 * 成本法、收益法土地等级
 * @author Lee
 * @version 1.0
 */
public class Pgt12054DAO extends BaseDAO implements IPgt12054DAO {

	private static final String tddjid =  "TDDJID";
	private static final String parentid =  "PARENTID";
	private static final String tddjnm =  "TDDJNM";
	private static final String cd00001Szqylx = "CD_00001_SZQYLX";
	private static final String cd00001Szqy = "CD_00001_SZQY";
	private static final String vieworder = "VIEWORDER";
	private static final String upddate =  "UPDDATE";
	private static final String cd00002Czr =  "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String isdir = "ISDIR";
	private static final String szqy =  "SZQY";
	private static final String czr =  "CZR";
	private static final String parentnm =  "PARENTNM";
	private static final String total = "total";
	private static final String rid = "RID";
	private static final String level =  "level";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt12054DAO#LoadAll(com.sunway.vo.Pgv12054)
	 */
	
	@Override
	public ArrayList<Pgv12054> LoadAll(Pgv12054 v12054) throws Exception {
		ArrayList<Pgv12054> listResult = new ArrayList<Pgv12054>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12054(?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v12054.getPageIndex());
			call.setInt(3, v12054.getPageSize());
			call.setString(4, v12054.getTddjnm());
			call.setString(5, v12054.getCd00001Szqy());
			call.setString(6, v12054.getSsgx());
			call.execute();
			// 返回數據集
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
	 * @see com.sunway.dao.IPgt12054DAO#LoadByPrimaryKey(com.sunway.vo.Pgt12054)
	 */
	
	@Override
	public Pgt12054 LoadByPrimaryKey(Pgt12054 t12054) throws Exception {
		ArrayList<Pgt12054> listResult = new ArrayList<Pgt12054>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT12054(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t12054.getTddjid());
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
		if (listResult != null && listResult.size() > 0) {
			return listResult.get(0);
		} else {
			return new Pgt12054();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt12054DAO#GetInsertCommand(com.sunway.vo.Pgt12054)
	 */
	
	@Override
	public Integer GetInsertCommand(Pgt12054 t12054) throws Exception {
		Integer bResult = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT12054(?,?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			// 传入输入参数
			call.setString(2, t12054.getParentid());
			call.setString(3, t12054.getTddjnm());
			call.setString(4, t12054.getCd00001Szqy());
			call.setString(5, t12054.getCd00002Czr());
			call.setString(6, t12054.getNote());
			call.setBoolean(7, t12054.getIsdir());
			call.setShort(8, t12054.getVieworder());
			call.setString(9, t12054.getSsgx());
			call.execute();
			// 返回数据
			bResult=(Integer) call.getObject(1);
			if (bResult == 1) {
				tran.commit();
			}
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
	 * @see com.sunway.dao.IPgt12054DAO#GetDeleteCommand(com.sunway.vo.Pgt12054)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt12054 t12054) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12054(?,?,?)}");
			// 传入输入参数
			call.setString(1, t12054.getTddjid());
			call.setString(2, t12054.getCd00002Czr());
			call.setString(3, t12054.getSsgx());
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
	 * @see com.sunway.dao.IPgt12054DAO#GetUpdateCommand(com.sunway.vo.Pgt12054)
	 */
	
	@Override
	public Integer GetUpdateCommand(Pgt12054 t12054) throws Exception {
		Integer bResult = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT12054(?,?,?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			// 传入输入参数
			call.setString(2, t12054.getTddjid());
			call.setString(3, t12054.getParentid());
			call.setString(4, t12054.getTddjnm());
			call.setString(5, t12054.getCd00001Szqy());
			call.setString(6, t12054.getCd00002Czr());
			call.setString(7, t12054.getNote());
			call.setBoolean(8, t12054.getIsdir());
			call.setShort(9, t12054.getVieworder());
			call.setString(10, t12054.getSsgx());
			call.execute();
			// 返回数据
			bResult=(Integer) call.getObject(1);
			if (bResult == 1) {
				tran.commit();
			}
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
	 * @see com.sunway.dao.IPgt12054DAO#LoadNavigator(com.sunway.vo.Pgt12054)
	 */
	
	@Override
	public ArrayList<Pgt12054> LoadNavigator(Pgt12054 t12054) throws Exception {
		ArrayList<Pgt12054> listResult = new ArrayList<Pgt12054>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120542(?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 傳入輸入參數
			call.setString(2, t12054.getTddjid());
			call.execute();
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetNParameters(rs));
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
	 * @see com.sunway.dao.IPgt12054DAO#LoadTreeList(com.sunway.vo.Pgt12054)
	 */
	
	@Override
	public ArrayList<Pgt12054> LoadTreeList(Pgt12054 t12054) throws Exception {
		ArrayList<Pgt12054> listResult = new ArrayList<Pgt12054>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120543(?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 傳入輸入參數
			call.setString(2, t12054.getCd00001Szqy());
			call.setString(3, t12054.getTddjid());
			call.setString(4, t12054.getNotddjid());
			call.execute();
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetNParameters(rs));
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
	 * @see com.sunway.dao.IPgt12054DAO#LoadNavStream(java.lang.String)
	 */
	
	@Override
	public String LoadNavStream(String tddjid) throws Exception {
		String resultValue = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{? = call FN_GETTDDJNM(?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			// 注册输入参数
			call.setString(2, tddjid);
			call.execute();
			// 返回数据集
			resultValue = (String) call.getObject(1);
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return resultValue;
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv12054 SetVParameters(ResultSet rs) throws Exception {
		Pgv12054 e = new Pgv12054();
		e.setRecordCount(rs.getInt(total));
		e.setRecordIndex(rs.getInt(rid));
		e.setTddjid(rs.getString(tddjid));
		e.setParentid(rs.getString(parentid));
		e.setTddjnm(rs.getString(tddjnm));
		e.setCd00001Szqylx(rs.getString(cd00001Szqylx));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setVieworder(rs.getShort(vieworder));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setIsdir(rs.getBoolean(isdir));
		e.setSzqy(rs.getString(szqy));
		e.setCzr(rs.getString(czr));
		e.setParentnm(rs.getString(parentnm));
		return e;
	}

	/**
	 * Edit数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt12054 SetTParameters(ResultSet rs) throws Exception {
		Pgt12054 e = new Pgt12054();
		e.setTddjid(rs.getString(tddjid));
		e.setParentid(rs.getString(parentid));
		e.setTddjnm(rs.getString(tddjnm));
		e.setCd00001Szqylx(rs.getString(cd00001Szqylx));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setVieworder(rs.getShort(vieworder));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setIsdir(rs.getBoolean(isdir));
		return e;
	}

	/**
	 * Tree数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt12054 SetNParameters(ResultSet rs) throws Exception {
		Pgt12054 e = new Pgt12054();
		e.setTddjid(rs.getString(tddjid));
		e.setParentid(rs.getString(parentid));
		e.setTddjnm(rs.getString(tddjnm));
		e.setCd00001Szqylx(rs.getString(cd00001Szqylx));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setVieworder(rs.getShort(vieworder));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setIsdir(rs.getBoolean(isdir));
		e.setLevel(rs.getString(level));
		return e;
	}
}
