package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt10051DAO;
import com.sunway.vo.Pgt10051;
import com.sunway.vo.Pgv10051;
import com.sunway.vo.Pssd;

/**
 * @category 成本法残值率
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt10051DAO extends BaseDAO implements IPgt10051DAO {

	private static final String CD00001JZJGLX = "cd_00001_jzjglx";	//建筑结构类型
	private static final String CD00001JZJG = "cd_00001_jzjg";		//建筑结构编号
	private static final String JZJG = "jzjg";						//建筑结构
	private static final String CD00002PSSD = "cd_00002_pssd";		//评税时点
	private static final String CZL = "czl";						//残值率
	private static final String UPDDATE="upddate";					//更改时间
	private static final String CD00002CZR = "cd_00002_czr";		//操作人编号	
	private static final String CZR = "czr";						//操作人
	private static final String NOTE = "note";						//备注信息
	private static final String RID = "rid";						//行号
	private static final String TOTAL = "total";					//总纪录数
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt10051 czl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT10051(?,?,?,?,?)}");
			call.setString(1, czl.getCd00001Jzjg());
			call.setString(2, czl.getCd00001Jzjglx());
			call.setString(3, czl.getCd00002Pssd());
			call.setString(4, czl.getCd00002Czr());
			call.setString(5, czl.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt10051DAO#GetInsertCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt10051 czl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT10051(?,?,?,?,?,?)}");
			call.setString(1, czl.getCd00001Jzjg());
			call.setString(2, czl.getCd00002Pssd());
			call.setDouble(3, czl.getCzl());
			call.setString(4, czl.getCd00002Czr());
			call.setString(5, czl.getNote());
			call.setString(6, czl.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt10051DAO#GetUpdateCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt10051 czl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT10051(?,?,?,?,?,?,?)}");
			call.setString(1, czl.getCd00001Jzjglx());
			call.setString(2, czl.getCd00001Jzjg());
			call.setString(3, czl.getCd00002Pssd());
			call.setDouble(4, czl.getCzl());
			call.setString(5, czl.getCd00002Czr());
			call.setString(6, czl.getNote());
			call.setString(7, czl.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt10051DAO#LoadAll(com.sunway.vo.Pgv10051)
	 */
	
	@Override
	public ArrayList<Pgv10051> LoadAll(Pgv10051 czl) throws Exception {
		ArrayList<Pgv10051> listResult = new ArrayList<Pgv10051>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT10051(?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, czl.getPageIndex());
			call.setInt(3, czl.getPageSize());
			call.setString(4, czl.getCd00001Jzjg());
			call.setString(5, czl.getCd00002Pssd());
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
	protected Pgv10051 SetVParameters(ResultSet rs) throws Exception {
		Pgv10051 e = new Pgv10051();
		e.setCd00001Jzjglx(rs.getString(CD00001JZJGLX));
		e.setCd00001Jzjg(rs.getString(CD00001JZJG));
		e.setJzjg(rs.getString(JZJG));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setCzl(rs.getDouble(CZL));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		e.setCzr(rs.getString(CZR));
		
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt10051 LoadByPrimaryKey(Pgt10051 czl) throws Exception {
		ArrayList<Pgt10051> listResult = new ArrayList<Pgt10051>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT10051(?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, czl.getCd00001Jzjg());
			call.setString(3, czl.getCd00001Jzjglx());
			call.setString(4, czl.getCd00002Pssd());
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
			return czl;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt10051 SetTParameters(ResultSet rs) throws Exception {
		Pgt10051 e = new Pgt10051();
		e.setCd00001Jzjglx(rs.getString(CD00001JZJGLX));
		e.setCd00001Jzjg(rs.getString(CD00001JZJG));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setCzl(rs.getDouble(CZL));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setJzjg(rs.getString(JZJG));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExecuteParamCopy(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean ExecuteParamCopy(Pgt10051 czl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {	
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_10051(?,?,?,?)}");
			call.setString(1, czl.getSpssd());
			call.setString(2, czl.getTpssd());
			call.setString(3, czl.getCd00002Czr());
			call.setString(4, czl.getCd00001Ssgx());
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

	/**
	 * 通用类，读取参数复制功能所需评税时点
	 * 
	 */
	
	public ArrayList<Pssd> LoadAllPssd(Pssd pssd) throws Exception {
		ArrayList<Pssd> listResult = new ArrayList<Pssd>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT100519(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setString(2, pssd.getCurrentPssd());
			call.execute();
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				Pssd bean = new Pssd();
				bean.setPssds(rs.getString("CD_00002_PSSD"));
				listResult.add(bean);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
}
