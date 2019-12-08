package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt00003DAO;
import com.sunway.vo.Pgt00002;
import com.sunway.vo.Pgt00003;
import com.sunway.vo.Pgt00004;
import com.sunway.vo.Pgv00003;

/**
 * @category 用户组维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00003DAO extends BaseDAO implements IPgt00003DAO {

	private static final String ROLEID =  "roleid";					//权限组ID
	private static final String ROLENM =  "rolenm";					//权限组名称
    private static final String ISROLE = "isrole";					//是否选择
	private static final String UPDDATE="upddate";					//更改时间
	private static final String CD00002CZR =  "cd_00002_czr";		//操作人编号	
	private static final String CZR = "czr";						//操作人
	private static final String NOTE = "note";						//备注信息
	private static final String RID = "rid";						//行号
	private static final String TOTAL = "total";					//总纪录数
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00003DAO#GetDeleteCommand(com.sunway.vo.Pgt00003)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00003 role) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00003(?,?,?)}");
			//传入输入参数
			call.setString(1, role.getRoleid());
			call.setString(2, role.getCd00002Czr());
			call.setString(3, role.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt00003DAO#GetInsertCommand(com.sunway.vo.Pgt00003)
	 */
	
	@Override
	public Integer GetInsertCommand(Pgt00003 role) throws Exception {
		Integer bResult;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00003(?,?,?,?,?,?,?)}");
			// 输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			//传入输入参数
			call.setString(2, role.getRolenm());
			call.setString(3, role.getCd00002Czr());
			call.setString(4, role.getNote());
			call.setString(5, role.getRightids());
			call.setString(6, role.getUserids());
			call.setString(7, role.getCd00001Ssgx());
			call.execute();
			tran.commit();
			bResult = call.getInt(1);
		} catch (Exception e) {
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00003DAO#GetUpdateCommand(com.sunway.vo.Pgt00003)
	 */
	
	@Override
	public Integer GetUpdateCommand(Pgt00003 role) throws Exception {
		Integer bResult;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00003(?,?,?,?,?,?,?,?)}");
			// 输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			//传入输入参数
			call.setString(2, role.getRoleid());
			call.setString(3, role.getRolenm());
			call.setString(4, role.getCd00002Czr());
			call.setString(5, role.getNote());
			call.setString(6, role.getRightids());
			call.setString(7, role.getUserids());
			call.setString(8, role.getCd00001Ssgx());
			call.execute();
			tran.commit();
			bResult = call.getInt(1);
		} catch (Exception e) {
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00003DAO#LoadAll(com.sunway.vo.Pgv00003)
	 */
	
	@Override
	public ArrayList<Pgv00003> LoadAll(Pgv00003 role) throws Exception {
		ArrayList<Pgv00003> listResult = new ArrayList<Pgv00003>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00003(?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setInt(2, role.getPageIndex());
			call.setInt(3, role.getPageSize());
			call.setString(4, role.getRoleid());
			call.setString(5, role.getRolenm());
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
	protected Pgv00003 SetVParameters(ResultSet rs) throws Exception {
		Pgv00003 e = new Pgv00003();
		e.setRoleid(rs.getString(ROLEID));
		e.setRolenm(rs.getString(ROLENM));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		e.setCzr(rs.getString(CZR));
		return e;
	}
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00003DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00003)
	 */
	
	@Override
	public Pgt00003 LoadByPrimaryKey(Pgt00003 role) throws Exception {
		ArrayList<Pgt00003> listResult = new ArrayList<Pgt00003>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00003(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, role.getRoleid());
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
			return new Pgt00003();
	}
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00003 SetTParameters(ResultSet rs) throws Exception {
		Pgt00003 e = new Pgt00003();
		e.setRoleid(rs.getString(ROLEID));
		e.setRolenm(rs.getString(ROLENM));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00003DAO#LoadRoleByUserID(com.sunway.vo.Pgt00002)
	 */
	
	@Override
	public ArrayList<Pgv00003> LoadRoleByUserID(Pgt00002 user) throws Exception {
		ArrayList<Pgv00003> listResult = new ArrayList<Pgv00003>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000031(?,?,?)}");
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
	protected Pgv00003 SetOParameters(ResultSet rs) throws Exception {
		Pgv00003 e = new Pgv00003();
		e.setRoleid(rs.getString(ROLEID));
		e.setRolenm(rs.getString(ROLENM));
		e.setIsrole(rs.getBoolean(ISROLE));
		e.setNote(rs.getString(NOTE));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00003DAO#LoadRoleByRightID(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public ArrayList<Pgv00003> LoadRoleByRightID(Pgt00004 right) throws Exception {
		ArrayList<Pgv00003> listResult = new ArrayList<Pgv00003>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000032(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, right.getRightid());
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
}
