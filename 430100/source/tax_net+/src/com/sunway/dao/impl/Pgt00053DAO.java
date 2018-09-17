package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00053DAO;
import com.sunway.vo.Pgt00053;
import com.sunway.vo.Pgv00053;

/**
 * 其它修正参数
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00053DAO extends BaseDAO implements IPgt00053DAO {

	private static final String xzlx =  "XZLX";
	private static final String xzmc =  "XZMC";
	private static final String qtxzid =  "QTXZID";
	private static final String cd00001Szqylx = "CD_00001_SZQYLX";
	private static final String cd00001Szqy = "CD_00001_SZQY";
	private static final String parentid =  "PARENTID";
	private static final String qtxznm =  "QTXZNM";
	private static final String xzxs =  "XZXS";
	private static final String vieworder = "VIEWORDER";
	private static final String upddate =  "UPDDATE";
	private static final String cd00002Czr =  "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String isdir = "ISDIR";
	private static final String szqy =  "SZQY";
	private static final String czr =  "CZR";
	private static final String parentnm =  "PARENTNM";
	private static final String level =  "level";
	private static final String total = "total";
	private static final String czlx = "CZLX";
	private static final String jglx = "JGLX";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00053DAO#LoadAllXzlx()
	 */
	
	@Override
	public ArrayList<Pgv00053> LoadAllXzlx() throws Exception{
		ArrayList<Pgv00053> listResult = new ArrayList<Pgv00053>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLCZ00003(?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				Pgv00053 e = new Pgv00053();
				e.setXzlx(rs.getShort(xzlx));
				e.setXzmc(rs.getString(xzmc));
				listResult.add(e);
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
	 * @see com.sunway.dao.IPgt00053DAO#LoadAll(com.sunway.vo.Pgv00053)
	 */
	
	@Override
	public ArrayList<Pgv00053> LoadAll(Pgv00053 v00053) throws Exception {
		ArrayList<Pgv00053> listResult = new ArrayList<Pgv00053>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00053(?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setInt(2, v00053.getPageIndex());
			call.setInt(3, v00053.getPageSize());
			call.setInt(4, v00053.getXzlx());
			call.setString(5, v00053.getQtxznm());
			call.setString(6, v00053.getCd00001Szqy());
			call.setString(7, v00053.getSsgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
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
	 * @see com.sunway.dao.IPgt00053DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00053)
	 */
	
	@Override
	public Pgt00053 LoadByPrimaryKey(Pgt00053 t00053) throws Exception {
		ArrayList<Pgt00053> listResult = new ArrayList<Pgt00053>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00053(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t00053.getQtxzid());
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
			return new Pgt00053();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00053DAO#GetInsertCommand(com.sunway.vo.Pgt00053)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt00053 t00053) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00053(?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 传入输入参数
			call.setString(1, t00053.getCd00001Szqy());
			call.setString(2, t00053.getParentid());
			call.setString(3, t00053.getQtxznm());
			call.setShort(4, t00053.getXzlx());
			call.setDouble(5, t00053.getXzxs());
			call.setShort(6, t00053.getVieworder());
			call.setString(7, t00053.getCd00002Czr());
			call.setString(8, t00053.getNote());
			call.setBoolean(9, t00053.getIsdir());
			call.setString(10, t00053.getSsgx());
			call.setInt(11, t00053.getCzlx());
			call.setInt(12, t00053.getJglx());
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
	 * @see com.sunway.dao.IPgt00053DAO#GetDeleteCommand(com.sunway.vo.Pgt00053)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00053 t00053) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00053(?,?,?)}");
			// 传入输入参数
			call.setString(1, t00053.getQtxzid());
			call.setString(2, t00053.getCd00002Czr());
			call.setString(3, t00053.getSsgx());
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
	 * @see com.sunway.dao.IPgt00053DAO#GetUpdateCommand(com.sunway.vo.Pgt00053)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt00053 t00053) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00053(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 传入输入参数
			call.setString(1, t00053.getQtxzid());
			call.setString(2, t00053.getCd00001Szqylx());
			call.setString(3, t00053.getCd00001Szqy());
			call.setString(4, t00053.getParentid());
			call.setString(5, t00053.getQtxznm());
			call.setShort(6, t00053.getXzlx());
			call.setDouble(7, t00053.getXzxs());
			call.setShort(8, t00053.getVieworder());
			call.setString(9, t00053.getCd00002Czr());
			call.setString(10, t00053.getNote());
			call.setBoolean(11, t00053.getIsdir());
			call.setString(12, t00053.getSsgx());
			call.setInt(13, t00053.getCzlx());
			call.setInt(14, t00053.getJglx());
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
	 * @see com.sunway.dao.IPgt00053DAO#LoadNavigator(com.sunway.vo.Pgt00053)
	 */
	
	@Override
	public ArrayList<Pgt00053> LoadNavigator(Pgt00053 t00053) throws Exception {
		ArrayList<Pgt00053> listResult = new ArrayList<Pgt00053>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000532(?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 傳入輸入參數
			call.setString(2, t00053.getQtxzid());
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
	 * @see com.sunway.dao.IPgt00053DAO#LoadTreeList(com.sunway.vo.Pgt00053)
	 */
	
	@Override
	public ArrayList<Pgt00053> LoadTreeList(Pgt00053 t00053) throws Exception {
		ArrayList<Pgt00053> listResult = new ArrayList<Pgt00053>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000533(?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 傳入輸入參數
			call.setString(2, t00053.getCd00001Szqy());
			call.setShort(3, t00053.getXzlx());
			call.setString(4, t00053.getQtxzid());
			call.setString(5, t00053.getNoqtxzid());
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

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00053 SetVParameters(ResultSet rs) throws Exception {
		Pgv00053 e = new Pgv00053();
		e.setRecordCount(rs.getInt(total));
		e.setQtxzid(rs.getString(qtxzid));
		e.setCd00001Szqylx(rs.getString(cd00001Szqylx));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setParentid(rs.getString(parentid));
		e.setQtxznm(rs.getString(qtxznm));
		e.setXzlx(rs.getShort(xzlx));
		e.setXzxs(rs.getDouble(xzxs));
		e.setVieworder(rs.getShort(vieworder));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setIsdir(rs.getBoolean(isdir));
		e.setXzmc(rs.getString(xzmc));
		e.setSzqy(rs.getString(szqy));
		e.setCzr(rs.getString(czr));
		e.setParentnm(rs.getString(parentnm));
		e.setCzlx(rs.getInt(czlx));
		e.setJglx(rs.getInt(jglx));
		return e;
	}

	/**
	 * Edit数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00053 SetTParameters(ResultSet rs) throws Exception {
		Pgt00053 e = new Pgt00053();
		e.setQtxzid(rs.getString(qtxzid));
		e.setCd00001Szqylx(rs.getString(cd00001Szqylx));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setParentid(rs.getString(parentid));
		e.setQtxznm(rs.getString(qtxznm));
		e.setXzlx(rs.getShort(xzlx));
		e.setXzxs(rs.getDouble(xzxs));
		e.setVieworder(rs.getShort(vieworder));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setIsdir(rs.getBoolean(isdir));
		e.setCzlx(rs.getInt(czlx));
		e.setJglx(rs.getInt(jglx));
		return e;
	}

	/**
	 * Tree数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00053 SetNParameters(ResultSet rs) throws Exception {
		Pgt00053 e = new Pgt00053();
		e.setQtxzid(rs.getString(qtxzid));
		e.setCd00001Szqylx(rs.getString(cd00001Szqylx));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setParentid(rs.getString(parentid));
		e.setQtxznm(rs.getString(qtxznm));
		e.setXzlx(rs.getShort(xzlx));
		e.setXzxs(rs.getDouble(xzxs));
		e.setVieworder(rs.getShort(vieworder));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setIsdir(rs.getBoolean(isdir));
		e.setLevel(rs.getString(level));
		return e;
	}
}
