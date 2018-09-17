package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt00010DAO;
import com.sunway.vo.Pgt00010;
import com.sunway.vo.Pgv00010;

/**
 * @author Lee
 *
 */
public class Pgt00010DAO extends BaseDAO implements IPgt00010DAO {
	
	private static final String CD00002USERID = "cd_00002_userid";
	private static final String CD00003ROLEID = "cd_00003_roleid";
	private static final String UPDDATE = "upddate";
	private static final String CD00002USERID1 = "cd_00002_userid1";
	private static final String NOTE = "note";
    
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#GetDeleteCommand(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00010 userRole) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00010(?,?,?)}");
			//传入输入参数
			call.setString(1, userRole.getCd00002Userid());
			call.setString(2, userRole.getCd00003Roleid());
			call.setString(3, userRole.getCd00002Czr());
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
	public boolean GetInsertCommand(Pgt00010 userRole) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00010(?,?,?,?)}");
			//传入输入参数
			call.setString(1, userRole.getCd00002Userid());
			call.setString(2, userRole.getCd00003Roleid());
			call.setString(3, userRole.getCd00002Czr());
			call.setString(4, userRole.getNote());
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
	public boolean GetUpdateCommand(Pgt00010 userRole) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00010(?,?,?,?)}");
			//传入输入参数
			call.setString(1, userRole.getCd00002Userid());
			call.setString(2, userRole.getCd00003Roleid());
			call.setString(3, userRole.getCd00002Czr());
			call.setString(4, userRole.getNote());
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
	public ArrayList<Pgv00010> LoadAll(Pgv00010 userRole) throws Exception {
		ArrayList<Pgv00010> listResult = new ArrayList<Pgv00010>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00010(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, userRole.getPageIndex());
			call.setInt(3, userRole.getPageSize());
			call.setString(4, userRole.getCd00002Userid());
			call.setString(5, userRole.getCd00003Roleid());
			call.setString(6, userRole.getSsgx());
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
	protected Pgv00010 SetVParameters(ResultSet rs) throws Exception {
		Pgv00010 e = new Pgv00010();
		e.setCd00002Userid(rs.getString(CD00002USERID));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00003Roleid(CD00003ROLEID);
		e.setCd00002Userid1(rs.getString(CD00002USERID1));
		e.setNote(rs.getString(NOTE));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public Pgt00010 LoadByPrimaryKey(Pgt00010 userRole) throws Exception {
		ArrayList<Pgt00010> listResult = new ArrayList<Pgt00010>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00010(?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, userRole.getCd00002Userid());
			call.setString(3, userRole.getCd00003Roleid());
			call.setString(4, userRole.getSsgx());
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
	protected Pgt00010 SetTParameters(ResultSet rs) throws Exception {
		Pgt00010 e = new Pgt00010();
		e.setCd00002Userid(rs.getString(CD00002USERID));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00003Roleid(CD00003ROLEID);
		e.setCd00002Czr(rs.getString(CD00002USERID1));
		e.setNote(rs.getString(NOTE));
		return e;
	}

	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00010DAO#GetBatchInsCommand(com.sunway.vo.Pgt00010)
	 */
	
	@Override
	public boolean GetBatchInsCommand(Pgt00010 userRole) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT000101(?,?,?,?)}");
			//传入输入参数
			call.setString(1, userRole.getCd00003Roleid());
			call.setString(2, userRole.getUserIds());
			call.setString(3, userRole.getCd00002Czr());
			call.setString(4, userRole.getSsgx());
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
}
