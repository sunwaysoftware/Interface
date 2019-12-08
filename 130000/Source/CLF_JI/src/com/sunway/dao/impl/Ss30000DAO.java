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

import com.sunway.dao.ISs30000DAO;
import com.sunway.util.Common;
import com.sunway.vo.Pgv00041;
import com.sunway.vo.Pgv00302;
import com.sunway.vo.Ss00000;
import com.sunway.vo.Ss30000;

/**
 * 
 * 市場法算稅處理
 * @author Andy.Gao
 * @category 算稅處理
 *
 */
public class Ss30000DAO extends BaseDAO implements ISs30000DAO {

	private static final String cd12301Swid = "CD_12301_SWID";
	private static final String nsrmc = "NSRMC";
	private static final String sumPgjg = "SUMPGJG";
	private static final String avgJsjz = "AVGJSJZ";
	private static final String avgSl = "AVGSL";
	private static final String sumYnze = "SUMYNZE";
	private static final String bm = "BM";
	private static final String fcid = "FCID";
	private static final String fwtdzl = "FWTDZL";
	private static final String jzmj = "JZMJ";
	private static final String pgjg = "PGJG";

	/* (non-Javadoc)
	 * @see com.sunway.dao.ISs30000DAO#GetSsAgainAllCommand(com.sunway.vo.Pgv00041)
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
			call = conn.prepareCall("{call PGSP_CZ_000416(?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getCd123Id());
			call.setString(2, bean.getCd12301Swid());
			call.setString(3, bean.getNsrmc());
			call.setString(4, bean.getSsCzr());
			call.setDate(5, Common.converDate(bean.getSysPssdYMD()));
			call.setString(6, bean.getSysSsgx());
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
	 * @see com.sunway.dao.ISs30000DAO#GetSsAgainCommand(com.sunway.vo.Pgv00041)
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
			call = conn.prepareCall("{call PGSP_CZ_0004161(?,?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getCd123Id());
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

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.ISs30000DAO#GetSsCommand(com.sunway.vo.Pgv00302)
	 */
	
	@Override
	public Boolean GetSsCommand(Pgv00302 bean) throws Exception {
		Boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_000413(?,?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getFcid());
			call.setString(2, bean.getSsCzr());
			call.setDate(3, Common.converDate(bean.getSysPssdYMD()));
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

	/* (non-Javadoc)
	 * @see com.sunway.dao.ISs30000DAO#LoadSsSwid(com.sunway.vo.Pgv00301)
	 */
	
	@Override
	public ArrayList<Pgv00302> LoadSsList(Pgv00302 bean) throws Exception {
		ArrayList<Pgv00302> listResult = new ArrayList<Pgv00302>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT0033121(?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getSysPssd());
			call.setString(3, bean.getCd00301Swid());
			call.setString(4, bean.getNsrmc());
			call.setString(5, bean.getCd00001Ssgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(new Pgv00302(rs.getString("FCID")));
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
	 * @see com.sunway.dao.ISs30000DAO#LoadNotice(com.sunway.vo.Ss30000)
	 */
	
	@Override
	public Ss30000 LoadNotice(Ss30000 ss30000) throws Exception {
		Ss30000 listResult = new Ss30000();
		ResultSet rs = null;
		ResultSet rsBean = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00045(?,?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			call.registerOutParameter(3, OracleTypes.VARCHAR);
			call.registerOutParameter(4, OracleTypes.VARCHAR);
			call.registerOutParameter(5, OracleTypes.VARCHAR);
			// 传入输入参数
			call.setString(6, ss30000.getCd12301Swid());
			call.setString(7, ss30000.getPssd());
			call.setString(8, ss30000.getCd00001Czr());
			call.setString(9, ss30000.getCd00001Ssgx());
			call.execute();
			// 返回数据
			listResult.setYymm((String) call.getObject(5));
			listResult.setNote((String) call.getObject(4));
			listResult.setSsgx((String) call.getObject(3));
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
				listResult.getSs30000List().add(SetVParameters(rs));
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
	protected Ss30000 SetVParameters(ResultSet rs) throws Exception {
		Ss30000 e = new Ss30000();
		e.setBm(rs.getShort(bm));
		e.setFcid(rs.getString(fcid));
		e.setFwtdzl(rs.getString(fwtdzl));
		e.setJzmj(rs.getDouble(jzmj));
		e.setPgjg(rs.getDouble(pgjg));
		return e;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.ISs30000DAO#printcz(com.sunway.vo.Ss00000)
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
			call = conn.prepareCall("{call PGSP_CZ_000451(?,?,?,?)}");
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