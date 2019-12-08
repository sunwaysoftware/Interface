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

import com.sunway.dao.IPgt00041DAO;
import com.sunway.vo.Pgv00041;

/**
 * 
 * 应纳税款计算表
 * @author Andy.Gao
 *
 */
public class Pgt00041DAO extends BaseDAO implements IPgt00041DAO {

	private static final String cd123Id = "CD_123_ID";	//评税编码(成本法、市场法、收益法)
	private static final String cd12301Swid = "CD_12301_SWID";	//税务登记代码(成本法、市场法、收益法)
	private static final String nsrmc = "NSRMC";				//姓名
	private static final String pgjg = "PGJG";					//评税结果
	private static final String jsze = "JSZE";
	private static final String ynze = "YNZE";
	private static final String recordIndex = "RID";
	private static final String recordCount = "TOTAL";
	
	/**
	 * View數據轉換
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	protected Pgv00041 SetV00041Parameters(ResultSet rs) throws Exception {
		Pgv00041 e = new Pgv00041();
		e.setCd123Id(rs.getString(cd123Id));
		e.setCd12301Swid(rs.getString(cd12301Swid));
		e.setNsrmc(rs.getString(nsrmc));
		e.setPgjg(rs.getDouble(pgjg));
		e.setJsze(rs.getDouble(jsze));
		e.setYnze(rs.getDouble(ynze));
		e.setRecordIndex(rs.getInt(recordIndex));
		e.setRecordCount(rs.getInt(recordCount));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00041DAO#LoadAllCB(com.sunway.vo.Pgv00041)
	 */
	
	@Override
	public ArrayList<Pgv00041> LoadAllCB(Pgv00041 bean) throws Exception {
		ArrayList<Pgv00041> listResult = new ArrayList<Pgv00041>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000411(?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getSysPssd());
			call.setString(5, bean.getCd12301Swid());
			call.setString(6, bean.getNsrmc());
			call.setString(7, bean.getSysSsgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetV00041Parameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00041DAO#LoadAllSC(com.sunway.vo.Pgv00041)
	 */
	
	@Override
	public ArrayList<Pgv00041> LoadAllSC(Pgv00041 bean) throws Exception {
		ArrayList<Pgv00041> listResult = new ArrayList<Pgv00041>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000413(?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getSysPssd());
			call.setString(5, bean.getCd12301Swid());
			call.setString(6, bean.getNsrmc());
			call.setString(7, bean.getSysSsgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetV00041Parameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00041DAO#LoadAllSY(com.sunway.vo.Pgv00041)
	 */
	
	@Override
	public ArrayList<Pgv00041> LoadAllSY(Pgv00041 bean) throws Exception {
		ArrayList<Pgv00041> listResult = new ArrayList<Pgv00041>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000412(?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getSysPssd());
			call.setString(5, bean.getCd12301Swid());
			call.setString(6, bean.getNsrmc());
			call.setString(7, bean.getSysSsgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetV00041Parameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
}
