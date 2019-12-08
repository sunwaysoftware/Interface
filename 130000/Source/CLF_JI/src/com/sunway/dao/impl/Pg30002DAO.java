/**
 * 
 */
package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPg30002DAO;
import com.sunway.vo.Pgv00302;
import com.sunway.vo.Pgv00331;

/**
 * 
 * 已評估[市場法]
 * @author Andy.Gao
 * @category 評估
 * @version 1.0
 *
 */
public class Pg30002DAO extends BaseDAO implements IPg30002DAO {

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPg30002DAO#GetExecPgAgain(com.sunway.vo.Pgv00302)
	 */
	
	@Override
	public Boolean GetExecPgAgain(Pgv00302 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;		
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00333(?,?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getFcid());
			call.setString(2, bean.getPgCzr());
			call.setString(3, bean.getSysPssd());
			call.setString(4, bean.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPg30002DAO#GetExecPgAgainAll(com.sunway.vo.Pgv00302)
	 */
	
	@Override
	public Boolean GetExecPgAgainAll(Pgv00302 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;		
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00334(?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getFcid());
			call.setString(2, bean.getCd00301Swid());
			call.setString(3, bean.getNsrmc());
			call.setString(4, bean.getCd00001Ssgx());
			call.setString(5, bean.getPgCzr());
			call.setString(6, bean.getSysPssd());
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
	 * @see com.sunway.dao.IPg30002DAO#LoadPgOK(com.sunway.vo.Pgv00301)
	 */
	
	@Override
	public ArrayList<Pgv00331> LoadPgOK(Pgv00331 bean) throws Exception {
		ArrayList<Pgv00331> listResult = new ArrayList<Pgv00331>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003312(?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getSysPssd());
			call.setString(5, bean.getCd00301Swid());
			call.setString(6, bean.getNsrmc());
			call.setString(7, bean.getSysSsgx());
			call.setString(8, bean.getFcslh());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetV00331Parameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/**
	 * View數據轉存
	 * @param rs 數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgv00331 SetV00331Parameters(ResultSet rs) throws Exception {
		String total = "TOTAL";
		String rid = "RID";
		String cd00301Swid = "CD_00301_SWID";
		String nsrmc = "NSRMC";
		String scpgczr = "SCPGCZR";
		String pgjg = "PGJG";
		String gbpgjg = "GBPGJG";
		String cd00302Fcid = "CD_00302_FCID";
		//String isCqts = "ISCQTS";
		String scpgjg = "SCPGJG";
		String zjhm = "zjhm";
		return new Pgv00331(rs.getString(cd00302Fcid),
							rs.getDouble(pgjg),
							rs.getString(cd00301Swid),
							rs.getString(nsrmc),
							rs.getDouble(gbpgjg),
							rs.getInt(total),
							rs.getInt(rid),
							rs.getString(scpgczr),
							//rs.getInt(isCqts),
							0,
							rs.getDouble(scpgjg),
							rs.getString(zjhm));
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPg30002DAO#ExecInfoBg(com.sunway.vo.Pgv00302)
	 */
	
	@Override
	public Boolean ExecInfoBg(Pgv00302 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;		
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_003031(?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getFcid());
			call.setString(2, bean.getPgCzr());
			call.setString(3, bean.getCd00001Ssgx());
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
