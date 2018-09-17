package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt00009DAO;
import com.sunway.vo.Pgt00009;
import com.sunway.vo.Pgv00009;

/**
 * @author Lee
 *
 */
public class Pgt00009DAO extends BaseDAO implements IPgt00009DAO {
	
	private static final String CD00001SSGXLX = "cd_00001_Ssgxlx";					//税收管辖类型编号
    private static final String CD00001SSGX = "cd_00001_Ssgx";						//税收管辖编号
	private static final String UPDDATE = "upddate";								//更改时间
	private static final String CD00002USERID = "cd_00002_userid";					//人员编码
	private static final String CD00002CZR =  "cd_00002_czr";						//操作人
	private static final String SSGX =  "ssgx";										//税收管辖名称
	private static final String NOTE = "note";										//备注
	private static final String TOTAL = "total";									//总纪录数
	private static final String CZR = "czr";										//操作人
	private static final String USERNM="usernm";                   				    //人员名称
	private static final String ISDEFAULT="isdefault";             				    //是否是默认税收管辖

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#GetDeleteCommand(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00009 ssgx) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00009(?,?,?)}");
			//传入输入参数
			call.setString(1, ssgx.getCd00001Ssgx());
			call.setString(2, ssgx.getCd00002Userid());
			call.setString(3, ssgx.getCd00002Czr());
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
	public boolean GetInsertCommand(Pgt00009 ssgx) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT000091(?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, ssgx.getCd00002Userid());
			call.setString(2, ssgx.getCd00001Ssgx());
			call.setString(3, ssgx.getCd00002Czr());
			call.setString(4, ssgx.getNote());
			call.setString(5, ssgx.getRoleids());
			call.setString(6, ssgx.getRightids());
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
	public boolean GetUpdateCommand(Pgt00009 ssgx) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT000091(?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, ssgx.getCd00002Userid());
			call.setString(2, ssgx.getCd00001Ssgx());
			call.setString(3, ssgx.getCd00002Czr());
			call.setString(4, ssgx.getNote());
			call.setString(5, ssgx.getRoleids());
			call.setString(6, ssgx.getRightids());
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
	public ArrayList<Pgv00009> LoadAll(Pgv00009 ssgx) throws Exception {
		ArrayList<Pgv00009> listResult = new ArrayList<Pgv00009>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00009(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, ssgx.getPageIndex());
			call.setInt(3, ssgx.getPageSize());
			call.setString(4, ssgx.getCd00002Userid());
			call.setString(5, ssgx.getUsernm());
			call.setString(6, ssgx.getCd00001Ssgx());
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
	protected Pgv00009 SetVParameters(ResultSet rs) throws Exception {
		Pgv00009 e = new Pgv00009();
		e.setCd00002Userid(rs.getString(CD00002USERID));
		e.setCd00001Ssgxlx(rs.getString(CD00001SSGXLX));
		e.setCd00001Ssgx(rs.getString(CD00001SSGX));
		e.setSsgx(rs.getString(SSGX));
		e.setUsernm(rs.getString(USERNM));
		e.setCzr(rs.getString(CZR));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setIsdefault(rs.getInt(ISDEFAULT));
		return e;
	}
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public Pgt00009 LoadByPrimaryKey(Pgt00009 ssgx) throws Exception {
		ArrayList<Pgt00009> listResult = new ArrayList<Pgt00009>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00009(?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, ssgx.getCd00001Ssgx());
			call.setString(3, ssgx.getCd00001Ssgxlx());
			call.setString(4, ssgx.getCd00002Userid());
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
			return ssgx;
	}

	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00009 SetTParameters(ResultSet rs) throws Exception {
		Pgt00009 e = new Pgt00009();
		e.setCd00002Userid(rs.getString(CD00002USERID));
		e.setCd00001Ssgx(rs.getString(CD00001SSGX));
		e.setSsgx(rs.getString(SSGX));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		return e;
	}

	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00009 SetOParameters(ResultSet rs) throws Exception {
		Pgv00009 e = new Pgv00009();
		e.setCd00001Ssgxlx(rs.getString(CD00001SSGXLX));
		e.setCd00001Ssgx(rs.getString(CD00001SSGX));		
		e.setSsgx(rs.getString(SSGX));
		e.setIsdefault(rs.getInt(ISDEFAULT));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00009DAO#LoadByUser(com.sunway.vo.Pgt00002)
	 */
	
	@Override
	public ArrayList<Pgv00009> LoadAllSSGX(String userID) throws Exception {
		ArrayList<Pgv00009> listResult = new ArrayList<Pgv00009>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000092(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, userID);
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetOParameters(rs));			
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00009DAO#GetUpdDef(com.sunway.vo.Pgt00009)
	 */
	
	@Override
	public boolean GetUpdDef(Pgt00009 t00009) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT000092(?,?)}");
			//传入输入参数
			call.setString(1, t00009.getCd00002Userid());
			call.setString(2, t00009.getCd00001Ssgx());
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
