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

import com.sunway.dao.ISs20000DAO;
import com.sunway.util.Common;
import com.sunway.vo.Pgv00041;
import com.sunway.vo.Pgv12001;
import com.sunway.vo.Ss00000;

/**
 * 
 * 收益法算稅處理
 * @author Andy.Gao
 * @category 算稅處理
 *
 */
public class Ss20000DAO extends BaseDAO implements ISs20000DAO {

	private static final String cd12301Swid = "CD_12301_SWID";
	private static final String nsrmc = "NSRMC";
	private static final String sumPgjg = "SUMPGJG";
	private static final String avgJsjz = "AVGJSJZ";
	private static final String avgSl = "AVGSL";
	private static final String sumYnze = "SUMYNZE";
	private static final String bm = "BM";
	private static final String dcid = "DCID";
	private static final String tdzl = "TDZL";
	private static final String syqmj = "SYQMJ";
	private static final String dcCount = "dcCount";
	private static final String zmj = "zmj";
	private static final String pgjg = "PGJG";

	/* (non-Javadoc)
	 * @see com.sunway.dao.ISs20000DAO#GetSsAgainAllCommand(com.sunway.vo.Pgv00041)
	 */
	
	@Override
	public Boolean GetSsAgainAllCommand(Pgv00041 bean) throws Exception {
		Boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_000415(?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getCd12301Swid());
			call.setString(2, bean.getNsrmc());
			call.setString(3, bean.getSsCzr());
			call.setDate(4, Common.converDate(bean.getSysPssdYMD()));
			call.setString(5, bean.getSysSsgx());
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
	 * @see com.sunway.dao.ISs20000DAO#GetSsAgainCommand(com.sunway.vo.Pgv00041)
	 */
	
	@Override
	public Boolean GetSsAgainCommand(Pgv00041 bean) throws Exception {
		Boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_0004151(?,?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getCd12301Swid());
			call.setString(2, bean.getSsCzr());
			call.setDate(3, Common.converDate(bean.getSysPssdYMD()));
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
	 * @see com.sunway.dao.ISs20000DAO#GetSsCommand(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public Boolean GetSsCommand(Pgv12001 bean) throws Exception {
		Boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_000412(?,?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getSwid());
			call.setString(2, bean.getSsCzr());
			call.setDate(3, Common.converDate(bean.getSysPssdYMD()));
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
	 * @see com.sunway.dao.ISs20000DAO#LoadSsSwid(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public ArrayList<Pgv12001> LoadSsSwid(Pgv12001 bean) throws Exception {
		ArrayList<Pgv12001> listResult = new ArrayList<Pgv12001>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT0203121(?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getSysPssd());
			call.setString(3, bean.getSwid());
			call.setString(4, bean.getNsrmc());
			call.setString(5, bean.getSysSsgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(new Pgv12001(rs.getString("SWID")));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.ISs20000DAO#LoadNotice(com.sunway.vo.Ss00000)
	 */
	
	@Override
	public Ss00000 LoadNotice(Ss00000 ss00000) throws Exception {
		Ss00000 listResult = new Ss00000();
		ResultSet rs = null;
		ResultSet rsBean = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		String ssgx = null;
		String note = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00044(?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			call.registerOutParameter(3, OracleTypes.VARCHAR);
			call.registerOutParameter(4, OracleTypes.VARCHAR);
			// 传入输入参数
			call.setString(5, ss00000.getCd12301Swid());
			call.setString(6, ss00000.getPssd());
			call.setString(7, ss00000.getCd00001Czr());
			call.setString(8, ss00000.getCd00001Ssgx());
			call.execute();
			// 返回数据
			note = (String) call.getObject(4);
			listResult.setNote(note);
			ssgx = (String) call.getObject(3);
			listResult.setSsgx(ssgx);
			rsBean = (ResultSet) call.getObject(2);
			while (null != rsBean && rsBean.next()) {
				listResult.setCd12301Swid(rsBean.getString(cd12301Swid));
				listResult.setNsrmc(rsBean.getString(nsrmc));
				listResult.setSumPgjg(rsBean.getDouble(sumPgjg));
				listResult.setAvgJsjz(rsBean.getDouble(avgJsjz));
				listResult.setAvgSl(rsBean.getDouble(avgSl));
				listResult.setSumYnze(rsBean.getDouble(sumYnze));
			}
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.getSs00000List().add(SetVParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rsBean, rs, call, conn, session);
		}
		return listResult;
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Ss00000 SetVParameters(ResultSet rs) throws Exception {
		Ss00000 e = new Ss00000();
		e.setBm(rs.getShort(bm));
		e.setDcid(rs.getString(dcid));
		e.setTdzl(rs.getString(tdzl));
		e.setSyqmj(rs.getDouble(syqmj));
		e.setDcCount(rs.getShort(dcCount));
		e.setZmj(rs.getDouble(zmj));
		e.setPgjg(rs.getDouble(pgjg));
		return e;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.ISs20000DAO#printcz(com.sunway.vo.Ss00000)
	 */
	
	@Override
	public Boolean printcz(Ss00000 ss00000) throws Exception {
		Boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_000441(?,?,?,?)}");
			//传入输入参数
			call.setString(1, ss00000.getCd12301Swid());
			call.setString(2, ss00000.getCd00002Pssd());
			call.setString(3, ss00000.getCd00001Czr());
			call.setString(4, ss00000.getCd00001Ssgx());
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
