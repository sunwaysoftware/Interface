package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00004DAO;
import com.sunway.vo.Pgt00002;
import com.sunway.vo.Pgt00003;
import com.sunway.vo.Pgt00004;
import com.sunway.vo.Pgv00004;

/**
 * @category 功能权限维护
 * @author Lee
 * @version 1.0
 */
public class Pgt00004DAO extends BaseDAO implements IPgt00004DAO {

	private static final String RIGHTID = "rightid";				//权限编码
	private static final String RIGHTNM = "rightnm";				//权限名称
    private static final String ISRIGHT = "isright";				//是否选择
	private static final String UPDDATE="upddate";					//更改时间
	private static final String CD00002CZR =  "cd_00002_czr";		//操作人编号	
	private static final String CZR = "czr";						//操作人
	private static final String NOTE = "note";						//备注信息
	private static final String RID = "rid";						//行号
	private static final String TOTAL = "total";					//总纪录数
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#GetDeleteCommand(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00004 right) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00004(?,?,?)}");
			//传入输入参数
			call.setString(1, right.getRightid());
			call.setString(2, right.getCd00002Czr());
			call.setString(3, right.getCd00001Ssgx());	
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
	public boolean GetInsertCommand(Pgt00004 right) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00004(?,?,?,?,?,?,?)}");
			//傳入輸入參數
			call.setString(1, right.getRightid());
			call.setString(2, right.getRightnm());
			call.setString(3, right.getCd00002Czr());
			call.setString(4, right.getNote());
			call.setString(5, right.getRoleids());
			call.setString(6, right.getUserids());
			call.setString(7, right.getCd00001Ssgx());
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
	public boolean GetUpdateCommand(Pgt00004 right) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00004(?,?,?,?,?,?,?)}");
			//傳入輸入參數
			call.setString(1, right.getRightid());
			call.setString(2, right.getRightnm());
			call.setString(3, right.getCd00002Czr());
			call.setString(4, right.getNote());
			call.setString(5, right.getRoleids());
			call.setString(6, right.getUserids());
			call.setString(7, right.getCd00001Ssgx());
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
	public ArrayList<Pgv00004> LoadAll(Pgv00004 right) throws Exception {
		ArrayList<Pgv00004> listResult = new ArrayList<Pgv00004>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00004(?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setInt(2, right.getPageIndex());
			call.setInt(3, right.getPageSize());
			call.setString(4, right.getRightid());
			call.setString(5, right.getRightnm());
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
	protected Pgv00004 SetVParameters(ResultSet rs) throws Exception {
		Pgv00004 e = new Pgv00004();
		e.setRightid(rs.getString(RIGHTID));
		e.setRightnm(rs.getString(RIGHTNM));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		e.setCzr(rs.getString(CZR));
		e.setNote(rs.getString(NOTE));
		return e;
	}
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public Pgt00004 LoadByPrimaryKey(Pgt00004 right) throws Exception {
		ArrayList<Pgt00004> listResult = new ArrayList<Pgt00004>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00004(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, right.getRightid());
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
			return new Pgt00004();
	}

	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00004 SetTParameters(ResultSet rs) throws Exception {
		Pgt00004 e = new Pgt00004();
		e.setRightid(rs.getString(RIGHTID));
		e.setRightnm(rs.getString(RIGHTNM));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#LoadRightByUserID(com.sunway.vo.Pgt00002)
	 */
	
	@Override
	public ArrayList<Pgv00004> LoadRightByUserID(Pgt00002 user) throws Exception {
		ArrayList<Pgv00004> listResult = new ArrayList<Pgv00004>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000041(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, user.getUserid());
			call.setString(3, user.getCd00001Ssgx());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetOParameters(rs));			
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
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00004 SetOParameters(ResultSet rs) throws Exception {
		Pgv00004 e = new Pgv00004();
		e.setRightid(rs.getString(RIGHTID));
		e.setRightnm(rs.getString(RIGHTNM));
		e.setIsright(rs.getBoolean(ISRIGHT));
		e.setNote(rs.getString(NOTE));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#LoadRightByUserID(com.sunway.vo.Pgt00003)
	 */
	
	@Override
	public ArrayList<Pgv00004> LoadRightByRoleID(Pgt00003 role) throws Exception {
		ArrayList<Pgv00004> listResult = new ArrayList<Pgv00004>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000042(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, role.getRoleid());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetOParameters(rs));			
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
}
