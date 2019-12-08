package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt00005DAO;
import com.sunway.vo.Pgt00005;
import com.sunway.vo.Pgv00005;

/**
 * @author Lee
 *
 */
public class Pgt00005DAO extends BaseDAO implements IPgt00005DAO {

	private static final String CD00003ROLEID = "cd_00003_roleid";
	private static final String CD00004RIGHTID = "cd_00004_rightid";
	private static final String ROLENM = "rolenm";
	private static final String RIGHTNM = "rightnm";
	private static final String UPDDATE = "upddate";
	private static final String CD00002CZR =  "cd_00002_czr";
	private static final String NOTE = "note";
	private static final String CZR = "czr";
	private static final String TOTAL = "total";
    private static final String RID = "rid"; 
    
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#GetDeleteCommand(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00005 roleRight) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00005(?,?,?,?)}");
			//传入输入参数
			call.setString(1, roleRight.getCd00003Roleid());
			call.setString(2,roleRight.getCd00004Rightid());
			call.setString(3, roleRight.getCd00002Czr());
			call.setString(4, roleRight.getCd00001Ssgx());
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
	public boolean GetInsertCommand(Pgt00005 roleRight) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00005(?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, roleRight.getCd00003Roleid());
			call.setString(2, roleRight.getCd00004Rightid());
			call.setString(3, roleRight.getCd00002Czr());
			call.setString(4, roleRight.getNote());
			call.setString(5, roleRight.getCd00001Ssgx());
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
	public boolean GetUpdateCommand(Pgt00005 roleRight) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00005(?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, roleRight.getCd00003Roleid());
			call.setString(2, roleRight.getCd00004Rightid());
			call.setString(3, roleRight.getCd00002Czr());
			call.setString(4, roleRight.getNote());
			call.setString(5, roleRight.getCd00001Ssgx());
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
	public ArrayList<Pgv00005> LoadAll(Pgv00005 roleRight) throws Exception {
		ArrayList<Pgv00005> listResult = new ArrayList<Pgv00005>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00005(?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setInt(2, roleRight.getPageIndex());
			call.setInt(3, roleRight.getPageSize());
			call.setString(4, roleRight.getRolenm());
			call.setString(5, roleRight.getRightnm());
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
	protected Pgv00005 SetVParameters(ResultSet rs) throws Exception {
		Pgv00005 e = new Pgv00005();
		e.setCd00003Roleid(rs.getString(CD00003ROLEID));
		e.setCd00004Rightid(rs.getString(CD00004RIGHTID));
		e.setRolenm(rs.getString(ROLENM));
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
	public Pgt00005 LoadByPrimaryKey(Pgt00005 roleRight) throws Exception {
		ArrayList<Pgt00005> listResult = new ArrayList<Pgt00005>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00005(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, roleRight.getCd00003Roleid());
			call.setString(3, roleRight.getCd00004Rightid());
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
	protected Pgt00005 SetTParameters(ResultSet rs) throws Exception {
		Pgt00005 e = new Pgt00005();
		e.setCd00003Roleid(rs.getString(CD00003ROLEID));
		e.setCd00004Rightid(rs.getString(CD00004RIGHTID));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		return e;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00005DAO#LoadT000052(com.sunway.vo.Pgv00005)
	 */
	
	@Override
	public ArrayList<Pgv00005> LoadT000052(Pgv00005 v00005) throws Exception {
		ArrayList<Pgv00005> listResult = new ArrayList<Pgv00005>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000052(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v00005.getCd00003Roleid());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgv00005 e = new Pgv00005();
				e.setRightnm(rs.getString(RIGHTNM));
				listResult.add(e);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
}
