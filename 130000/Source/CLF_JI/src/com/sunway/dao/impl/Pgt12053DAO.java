package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt12053DAO;
import com.sunway.vo.Pgt12053;
import com.sunway.vo.Pgv12053;

/**
 * 成本法、收益法地段基准
 * @author Lee
 * @version 1.0
 */
public class Pgt12053DAO extends BaseDAO implements IPgt12053DAO {

	private static final String ddid =  "DDID";
	private static final String parentid =  "PARENTID";
	private static final String ddnm =  "DDNM";
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
	 * @see com.sunway.dao.IPgt12053DAO#LoadAll(com.sunway.vo.Pgv12053)
	 */
	
	@Override
	public ArrayList<Pgv12053> LoadAll(Pgv12053 v12053) throws Exception {
		ArrayList<Pgv12053> listResult = new ArrayList<Pgv12053>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12053(?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v12053.getPageIndex());
			call.setInt(3, v12053.getPageSize());
			call.setString(4, v12053.getDdnm());
			call.setString(5, v12053.getCd00001Szqy());
			call.setString(6, v12053.getSsgx());
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
	 * @see com.sunway.dao.IPgt12053DAO#LoadByPrimaryKey(com.sunway.vo.Pgt12053)
	 */
	
	@Override
	public Pgt12053 LoadByPrimaryKey(Pgt12053 t12053) throws Exception {
		ArrayList<Pgt12053> listResult = new ArrayList<Pgt12053>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT12053(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t12053.getDdid());
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
			return new Pgt12053();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt12053DAO#GetInsertCommand(com.sunway.vo.Pgt12053)
	 */
	
	@Override
	public Integer GetInsertCommand(Pgt12053 t12053) throws Exception {
		Integer bResult = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT12053(?,?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			// 传入输入参数
			call.setString(2, t12053.getParentid());
			call.setString(3, t12053.getDdnm());
			call.setString(4, t12053.getCd00001Szqy());
			call.setString(5, t12053.getCd00002Czr());
			call.setString(6, t12053.getNote());
			call.setBoolean(7, t12053.getIsdir());
			call.setShort(8, t12053.getVieworder());
			call.setString(9, t12053.getSsgx());
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
	 * @see com.sunway.dao.IPgt12053DAO#GetDeleteCommand(com.sunway.vo.Pgt12053)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt12053 t12053) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12053(?,?,?)}");
			// 传入输入参数
			call.setString(1, t12053.getDdid());
			call.setString(2, t12053.getCd00002Czr());
			call.setString(3, t12053.getSsgx());
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
	 * @see com.sunway.dao.IPgt12053DAO#GetUpdateCommand(com.sunway.vo.Pgt12053)
	 */
	
	@Override
	public Integer GetUpdateCommand(Pgt12053 t12053) throws Exception {
		Integer bResult = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT12053(?,?,?,?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			// 传入输入参数
			call.setString(2, t12053.getDdid());
			call.setString(3, t12053.getParentid());
			call.setString(4, t12053.getDdnm());
			call.setString(5, t12053.getCd00001Szqylx());
			call.setString(6, t12053.getCd00001Szqy());
			call.setString(7, t12053.getCd00002Czr());
			call.setString(8, t12053.getNote());
			call.setBoolean(9, t12053.getIsdir());
			call.setShort(10, t12053.getVieworder());
			call.setString(11, t12053.getSsgx());
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
	 * @see com.sunway.dao.IPgt12053DAO#LoadNavigator(com.sunway.vo.Pgt12053)
	 */
	
	@Override
	public ArrayList<Pgt12053> LoadNavigator(Pgt12053 t12053) throws Exception {
		ArrayList<Pgt12053> listResult = new ArrayList<Pgt12053>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120532(?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 傳入輸入參數
			call.setString(2, t12053.getDdid());
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
	 * @see com.sunway.dao.IPgt12053DAO#LoadTreeList(com.sunway.vo.Pgt12053)
	 */
	
	@Override
	public ArrayList<Pgt12053> LoadTreeList(Pgt12053 t12053) throws Exception {
		ArrayList<Pgt12053> listResult = new ArrayList<Pgt12053>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120533(?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 傳入輸入參數
			call.setString(2, t12053.getCd00001Szqy());
			call.setString(3, t12053.getDdid());
			call.setString(4, t12053.getNoddid());
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
	 * @see com.sunway.dao.IPgt12053DAO#LoadNavStream(java.lang.String)
	 */
	
	@Override
	public String LoadNavStream(String ddid) throws Exception {
		String resultValue = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{? = call FN_GETDDNM(?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			// 注册输入参数
			call.setString(2, ddid);
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
	protected Pgv12053 SetVParameters(ResultSet rs) throws Exception {
		Pgv12053 e = new Pgv12053();
		e.setRecordCount(rs.getInt(total));
		e.setRecordIndex(rs.getInt(rid));
		e.setDdid(rs.getString(ddid));
		e.setParentid(rs.getString(parentid));
		e.setDdnm(rs.getString(ddnm));
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
	protected Pgt12053 SetTParameters(ResultSet rs) throws Exception {
		Pgt12053 e = new Pgt12053();
		e.setDdid(rs.getString(ddid));
		e.setParentid(rs.getString(parentid));
		e.setDdnm(rs.getString(ddnm));
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
	protected Pgt12053 SetNParameters(ResultSet rs) throws Exception {
		Pgt12053 e = new Pgt12053();
		e.setDdid(rs.getString(ddid));
		e.setParentid(rs.getString(parentid));
		e.setDdnm(rs.getString(ddnm));
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
