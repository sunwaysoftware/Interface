package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgv00301_bDAO;
import com.sunway.vo.Pgv00301_b;
import com.sunway.vo.PgvCzPssd;

/**
 * 住宅登记信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv00301_bDAO extends BaseDAO implements IPgv00301_bDAO {

	private static final String recordCount = "TOTAL";
	private static final String swid="SWID";
	private static final String nsrmc="NSRMC";
	private static final String cd00001Zjlx="CD_00001_ZJLX";
	private static final String zz="ZZ";
	private static final String lxdh="LXDH";
	private static final String yddh="YDDH";
	private static final String cd00001Ssgx="CD_00001_SSGX";
	private static final String upddate="UPDDATE";
	private static final String cd00002Czr="CD_00002_CZR";
	private static final String note="NOTE";
	private static final String cd00002Pssd="CD_00002_PSSD";
	private static final String zjlx="ZJLX";
	private static final String ssgx="SSGX";
	private static final String czr="CZR";
	private static final String sczt = "SCZT";
	private static final String pgjg = "PGJG";
	private static final String gbpgjg = "GBPGJG";
	private static final String jsze = "JSZE";
	private static final String ynze = "YNZE";
	private static final String sumPgjg = "SUM_PGJG";
	private static final String sumGbpgjg = "SUM_GBPGJG";
	private static final String sumJsze = "SUM_JSZE";
	private static final String sumYnze = "SUM_YNZE";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgv00301_bDAO#LoadAll(com.sunway.vo.Pgv00301_b)
	 */
	
	@Override
	public Pgv00301_b LoadAll(Pgv00301_b v00301_b) throws Exception {
		Pgv00301_b listResult = new Pgv00301_b();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00301_B(?,?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(3, v00301_b.getPageIndex());
			call.setInt(4, v00301_b.getPageSize());
			call.setString(5, v00301_b.getSwid());
			call.setString(6, v00301_b.getNsrmc());
			call.setString(7, v00301_b.getCd00001Ssgx());
			call.setString(8, v00301_b.getCd00002Pssd());
			call.setInt(9, v00301_b.getSczt());
			call.execute();
			//返回列合
			rsSum = (ResultSet) call.getObject(2); 
			while(null!=rsSum && rsSum.next()){
				listResult.setSumPgjg(rsSum.getDouble(sumPgjg));
				listResult.setSumGbpgjg(rsSum.getDouble(sumGbpgjg));
				listResult.setSumJsze(rsSum.getDouble(sumJsze));
				listResult.setSumYnze(rsSum.getDouble(sumYnze));
			}
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.getV00301_bList().add(SetVParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rsSum, rs, call, conn, session);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgv00301_bDAO#LoadPssd()
	 */
	
	@Override
	public ArrayList<PgvCzPssd> LoadPssd() throws Exception {
		ArrayList<PgvCzPssd> listResult = new ArrayList<PgvCzPssd>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00300_B(?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				PgvCzPssd e = new PgvCzPssd();
				e.setCd00002Pssd(rs.getString(cd00002Pssd));
				listResult.add(e);
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
	 * @see com.sunway.dao.IPgv00301_bDAO#LoadDetail(com.sunway.vo.Pgv00301_b)
	 */
	
	@Override
	public Pgv00301_b LoadDetail(Pgv00301_b v00301_b) throws Exception {
		ArrayList<Pgv00301_b> listResult = new ArrayList<Pgv00301_b>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00301_B0(?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v00301_b.getSwid());
			call.setString(3, v00301_b.getCd00002Pssd());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetDParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		if (listResult != null && listResult.size() > 0) {
			return listResult.get(0);
		} else {
			return new Pgv00301_b();
		}
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00301_b SetVParameters(ResultSet rs) throws Exception {
		Pgv00301_b e = new Pgv00301_b();
		e.setRecordCount(rs.getInt(recordCount));
		e.setSwid(rs.getString(swid));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Zjlx(rs.getString(cd00001Zjlx));
		e.setZz(rs.getString(zz));
		e.setLxdh(rs.getString(lxdh));
		e.setYddh(rs.getString(yddh));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setZjlx(rs.getString(zjlx));
		e.setSsgx(rs.getString(ssgx));
		e.setCzr(rs.getString(czr));
		e.setSczt(rs.getInt(sczt));
		e.setPgjg(rs.getDouble(pgjg));
		e.setGbpgjg(rs.getDouble(gbpgjg));
		e.setJsze(rs.getDouble(jsze));
		e.setYnze(rs.getDouble(ynze));
		return e;
	}

	/**
	 * Detail数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00301_b SetDParameters(ResultSet rs) throws Exception {
		Pgv00301_b e = new Pgv00301_b();
		e.setSwid(rs.getString(swid));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Zjlx(rs.getString(cd00001Zjlx));
		e.setZz(rs.getString(zz));
		e.setLxdh(rs.getString(lxdh));
		e.setYddh(rs.getString(yddh));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setZjlx(rs.getString(zjlx));
		e.setSsgx(rs.getString(ssgx));
		e.setCzr(rs.getString(czr));
		return e;
	}
}
