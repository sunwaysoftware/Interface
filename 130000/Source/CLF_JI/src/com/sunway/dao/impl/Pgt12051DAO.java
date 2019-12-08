package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt12051DAO;
import com.sunway.vo.Pgt12051;
import com.sunway.vo.Pgv12051;

/**
 * @category 免税比例维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt12051DAO extends BaseDAO implements IPgt12051DAO {

	private static final String CD00001MSSZLX = "cd_00001_msszlx";	//免税设置类型
	private static final String CD00001MSSZ = "cd_00001_mssz";		//免税设置编号
	private static final String MSSZ = "mssz";						//免税设置
	private static final String BLXS = "blxs";						//免税设置
	private static final String UPDDATE="upddate";					//更改时间
	private static final String CD00002CZR = "cd_00002_czr";		//操作人编号	
	private static final String CZR = "czr";						//操作人
	private static final String NOTE = "note";						//备注信息
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12051DAO#GetDeleteCommand(com.sunway.vo.Pgt12051)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt12051 msbl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12051(?,?,?,?)}");
			call.setString(1, msbl.getCd00001Mssz());
			call.setString(2, msbl.getCd00001Msszlx());
			call.setString(3, msbl.getCd00002Czr());
			call.setString(4, msbl.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt12051DAO#GetInsertCommand(com.sunway.vo.Pgt12051)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt12051 msbl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT12051(?,?,?,?,?)}");
			call.setString(1, msbl.getCd00001Mssz());
			call.setDouble(2, msbl.getBlxs());
			call.setString(3, msbl.getCd00002Czr());
			call.setString(4, msbl.getNote());
			call.setString(5, msbl.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt12051DAO#GetUpdateCommand(com.sunway.vo.Pgt12051)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt12051 msbl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT12051(?,?,?,?,?,?)}");
			call.setString(1, msbl.getCd00001Msszlx());
			call.setString(2, msbl.getCd00001Mssz());
			call.setDouble(3, msbl.getBlxs());
			call.setString(4, msbl.getCd00002Czr());
			call.setString(5, msbl.getNote());
			call.setString(6, msbl.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt12051DAO#LoadAll(com.sunway.vo.Pgv12051)
	 */
	
	@Override
	public ArrayList<Pgv12051> LoadAll(Pgv12051 msbl) throws Exception {
		ArrayList<Pgv12051> listResult = new ArrayList<Pgv12051>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12051(?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.execute();
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
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv12051 SetVParameters(ResultSet rs) throws Exception {
		Pgv12051 e = new Pgv12051();
		e.setCd00001Msszlx(rs.getString(CD00001MSSZLX));
		e.setCd00001Mssz(rs.getString(CD00001MSSZ));
		e.setMssz(rs.getString(MSSZ));
		e.setBlxs(rs.getDouble(BLXS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setCzr(rs.getString(CZR));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt12051)
	 */
	
	@Override
	public Pgt12051 LoadByPrimaryKey(Pgt12051 msbl) throws Exception {
		ArrayList<Pgt12051> listResult = new ArrayList<Pgt12051>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT12051(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, msbl.getCd00001Mssz());
			call.setString(3, msbl.getCd00001Msszlx());
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
			return new Pgt12051();
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt12051 SetTParameters(ResultSet rs) throws Exception {
		Pgt12051 e = new Pgt12051();
		e.setCd00001Msszlx(rs.getString(CD00001MSSZLX));
		e.setCd00001Mssz(rs.getString(CD00001MSSZ));
		e.setBlxs(rs.getDouble(BLXS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setMssz(rs.getString(MSSZ));
		return e;
	}

}
