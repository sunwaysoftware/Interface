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

import com.sunway.dao.IPg20002DAO;
import com.sunway.vo.Pgv02031;
import com.sunway.vo.Pgv12001;

/**
 * 
 * 已評估[收益法]
 * @author Andy.Gao
 * @category 評估
 * @version 1.0
 *
 */
public class Pg20002DAO extends BaseDAO implements IPg20002DAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPg20002DAO#GetExecPgAgain(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public Boolean GetExecPgAgain(Pgv12001 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02033(?,?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getSwid());
			call.setString(2, bean.getPgCzr());
			call.setString(3, bean.getSysPssd());
			call.setString(4, bean.getSysSsgx());
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
	 * @see com.sunway.dao.IPg20002DAO#GetExecPgAgainAll(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public Boolean GetExecPgAgainAll(Pgv12001 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;		
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02034(?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getSwid());
			call.setString(2, bean.getNsrmc());
			call.setString(3, bean.getSysSsgx());
			call.setString(4, bean.getShCzr());
			call.setString(5, bean.getSysPssd());
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
	 * @see com.sunway.dao.IPg20002DAO#LoadPgOK(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public ArrayList<Pgv02031> LoadPgOK(Pgv02031 bean) throws Exception {
		ArrayList<Pgv02031> listResult = new ArrayList<Pgv02031>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020312(?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getSysPssd());
			call.setString(5, bean.getCd12001Swid());
			call.setString(6, bean.getNsrmc());
			call.setString(7, bean.getSysSsgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetV02031Parameters(rs));
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
	protected Pgv02031 SetV02031Parameters(ResultSet rs) throws Exception {
		String total = "TOTAL";
		String rid = "RID";
		String cd12001Swid = "CD_12001_SWID";
		String nsrmc = "NSRMC";
		String sypgczr = "SYPGCZR";
		String pgjg = "PGJG";
		String gbpgjg = "GBPGJG";
		return new Pgv02031(rs.getDouble(pgjg), 
							rs.getDouble(gbpgjg), 
							rs.getString(cd12001Swid),
							rs.getString(nsrmc), 
							rs.getInt(total), 
							rs.getInt(rid), 
							rs.getString(sypgczr));
	}
}
