package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt00006DAO;
import com.sunway.vo.Pgt00006;
import com.sunway.vo.Pgv00006;

/**
 * @author Lee
 *
 */
public class Pgt00006DAO extends BaseDAO implements IPgt00006DAO {

	private static final String CD00004RIGHTID = "cd_00004_rightid";
	private static final String CD00002CZR =  "cd_00002_czr";
	private static final String USERNM = "usernm";
	private static final String RIGHTNM = "rightnm";
	private static final String UPDDATE = "upddate";
	private static final String CD00002USERID = "cd_00002_userid";
	private static final String NOTE = "note";
	private static final String CZR = "czr";
	private static final String TOTAL = "total";
    private static final String RID = "rid"; 
    
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#GetDeleteCommand(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00006 userRight) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00006(?,?,?,?)}");
			//传入输入参数
			call.setString(1, userRight.getCd00002Userid());
			call.setString(2,userRight.getCd00004Rightid());
			call.setString(3, userRight.getCd00002Czr());
			call.setString(4, userRight.getCd00001Ssgx());
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

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#GetInsertCommand(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt00006 userRight) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00006(?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, userRight.getCd00002Userid());
			call.setString(2, userRight.getCd00004Rightid());
			call.setString(3, userRight.getCd00002Czr());
			call.setString(4, userRight.getNote());
			call.setString(5, userRight.getCd00001Ssgx());
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

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#GetUpdateCommand(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt00006 userRight) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00006(?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, userRight.getCd00002Userid());
			call.setString(2, userRight.getCd00004Rightid());
			call.setString(3, userRight.getCd00002Czr());
			call.setString(4, userRight.getNote());
			call.setString(5, userRight.getCd00001Ssgx());
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

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#LoadAll(com.sunway.vo.Pgv00004)
	 */
	
	@Override
	public ArrayList<Pgv00006> LoadAll(Pgv00006 userRight) throws Exception {
		ArrayList<Pgv00006> listResult = new ArrayList<Pgv00006>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00006(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setInt(2, userRight.getPageIndex());
			call.setInt(3, userRight.getPageSize());
			call.setString(4, userRight.getCd00002Userid());
			call.setString(5, userRight.getUsernm());
			call.setString(6, userRight.getRightnm());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetVParameters(rs));			
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00006 SetVParameters(ResultSet rs) throws Exception {
		Pgv00006 e = new Pgv00006();
		e.setCd00002Userid(rs.getString(CD00002USERID));
		e.setUsernm(rs.getString(USERNM));
		e.setRightnm(rs.getString(RIGHTNM));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		e.setNote(rs.getString(NOTE));
		e.setCzr(rs.getString(CZR));
		return e;
	}
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public Pgt00006 LoadByPrimaryKey(Pgt00006 userRight) throws Exception {
		ArrayList<Pgt00006> listResult = new ArrayList<Pgt00006>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00006(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, userRight.getCd00002Userid());
			call.setString(3, userRight.getCd00004Rightid());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetTParameters(rs));			
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return null;
	}

	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00006 SetTParameters(ResultSet rs) throws Exception {
		Pgt00006 e = new Pgt00006();
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setCd00004Rightid(rs.getString(CD00004RIGHTID));
		e.setCd00002Userid(rs.getString(CD00002USERID));
		e.setNote(rs.getString(NOTE));
		return e;
	}
}
