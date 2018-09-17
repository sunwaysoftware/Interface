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

import com.sunway.dao.IPg20001DAO;
import com.sunway.vo.Pgv02002;

/**
 *
 * 未評估[市場法]
 * @author Andy.Gao
 * @category 評估
 * @version 1.0
 *
 */
public class Pg20001DAO extends BaseDAO implements IPg20001DAO {
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPg30001DAO#GetExecPG(com.sunway.vo.Pgv02002)
	 */
	
	@Override
	public Pgv02002 GetExecPG(Pgv02002 bean) throws Exception {
		//boolean bResult = false;
		Pgv02002 listResult = new Pgv02002();
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02031(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			//传入输入参数
			call.setString(2, bean.getFcid());
			call.setString(3, bean.getPgCzr());
			call.execute();
			tran.commit();
			if(call.getInt(1)==0)
				//bResult = true;
				listResult.setbResult(1);
			else
				listResult.setbResult(0);
		} catch (Exception e) {
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return listResult;
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPg30001DAO#LoadPg(com.sunway.vo.Pgv02002)
	 */
	
	@Override
	public ArrayList<Pgv02002> LoadPg(Pgv02002 bean) throws Exception {
		ArrayList<Pgv02002> listResult = new ArrayList<Pgv02002>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020311(?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getZjhm());
			call.setString(5, bean.getNsrmc());
			call.setString(6, bean.getCd00001Ssgx());
			call.setString(7, bean.getFcslh());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				listResult.add(SetVPgParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPg30001DAO#LoadPgMxNgList(com.sunway.vo.Pgv02002)
	 */
	
	@Override
	public ArrayList<Pgv02002> LoadPgMxNgList(Pgv02002 bean) throws Exception {
		ArrayList<Pgv02002> listResult = new ArrayList<Pgv02002>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02084(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getZjhm());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				listResult.add(SetV02002Parameters(rs));
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
	 * @see com.sunway.dao.IPg30001DAO#LoadPgList(com.sunway.vo.Pgv02002)
	 */
	
	@Override
	public ArrayList<Pgv02002> LoadPgList(Pgv02002 bean) throws Exception {
		ArrayList<Pgv02002> listResult = new ArrayList<Pgv02002>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT0203111(?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getZjhm());
			call.setString(3, bean.getNsrmc());
			call.setString(4, bean.getFclsh());
			call.setString(5, bean.getCd00001Ssgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				Pgv02002 e = new Pgv02002();
				e.setFcid(rs.getString("FCID"));
				listResult.add(e);
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
	protected Pgv02002 SetVPgParameters(ResultSet rs) throws Exception {
		String total = "TOTAL";
		String pgCzr = "SYPGCZR";
		String isInfo = "ISINFO";
		String fcid = "FCID";
		String cd00001Fwlx = "CD_00001_FWLX";
		String cd00001Jylx = "CD_00001_JYLX";
		String cd00001Jzjg = "CD_00001_JZJG";
		String jzmj = "JZMJ";
//		String cd00001Fwcx = "CD_00001_FWCX";
//		String cd00001Cgzk = "CD_00001_CGZK";
		String szlc = "SZCS";
		String bwjfh = "BWJFH";
		String jyjg = "SBJG";
		String jysj = "JYSJ";
		String upddate = "UPDDATE";
		String cd00002Czr = "CD_00002_CZR";
		String note = "NOTE";
		String nsrmc = "ZRFMC";
		String cd00001Ssgx = "CD_00001_SSGX";
		String cd02050Xqdm = "CD_02050_XQDM";
		String cd00001Szqy = "CD_00001_SZQY";
		String zlc = "CS";
		String xqnm = "XQNM";
		String xqbm = "XQBM";
		String szqy = "SZQY";
		String fwlx = "FWLX";
		String jylx = "JYLX";
		String jzjg = "JZJG";
//		String fwcx = "FWCX";
//		String cgzk = "CGZK";
		String czr = "CZR";

		Pgv02002 e = new Pgv02002();
		e.setRecordCount(rs.getInt(total));
		e.setPgCzr(rs.getString(pgCzr));
		e.setIsInfo(rs.getBoolean(isInfo));
		e.setFcid(rs.getString(fcid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJzmj(rs.getDouble(jzmj));
//		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
//		e.setCd00001Cgzk(rs.getString(cd00001Cgzk));
		e.setSzlc(rs.getString(szlc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setJyjg(rs.getDouble(jyjg));
		e.setJysj(rs.getDate(jysj));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd02050Xqdm(rs.getString(cd02050Xqdm));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setZlc(rs.getString(zlc));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setFwlx(rs.getString(fwlx));
		e.setJylx(rs.getString(jylx));
		e.setJzjg(rs.getString(jzjg));
//		e.setFwcx(rs.getString(fwcx));
//		e.setCgzk(rs.getString(cgzk));
		e.setCzr(rs.getString(czr));
		e.setZjhm(rs.getString("ZRFZJHM"));
		return e;
	}

	/**
	 * View數據轉存
	 * @param rs 數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgv02002 SetV02002Parameters(ResultSet rs) throws Exception {
		String fcid = "FCID";
		String cd00001Fwlx = "CD_00001_FWLX";
		String cd00001Jylx = "CD_00001_JYLX";
		String cd00001Jzjg = "CD_00001_JZJG";
		String jzmj = "JZMJ";
//		String cd00001Fwcx = "CD_00001_FWCX";
//		String cd00001Cgzk = "CD_00001_CGZK";
		String szlc = "SZLC";
		String bwjfh = "BWJFH";
		String jyjg = "JYJG";
		//String dtgj = "DTGJ";
		String tdsyqmj = "TDSYQMJ";
		String rjl = "RJL";
		String jysj = "JYSJ";
		String fdcdat = "FDCDAT";
		String upddate = "UPDDATE";
		String cd00002Czr = "CD_00002_CZR";
		String note = "NOTE";
		String nsrmc = "NSRMC";
		String cd00001Ssgx = "CD_00001_SSGX";
		String cd02050Xqdm = "CD_02050_XQDM";
		String cd00001Szqy = "CD_00001_SZQY";
		String zlc = "ZLC";
		String fwtdzl = "FWTDZL";
		String xqnm = "XQNM";
		String xqbm = "XQBM";
		String szqy = "SZQY";
		String fwlx = "FWLX";
		String jylx = "JYLX";
		String jzjg = "JZJG";
//		String fwcx = "FWCX";
//		String cgzk = "CGZK";
		String czr = "CZR";

		Pgv02002 e = new Pgv02002();
		e.setFcid(rs.getString(fcid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJzmj(rs.getDouble(jzmj));
//		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
//		e.setCd00001Cgzk(rs.getString(cd00001Cgzk));
		e.setSzlc(rs.getString(szlc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setJyjg(rs.getDouble(jyjg));
		//e.setDtgj(rs.getDouble(dtgj));
		e.setTdsyqmj(rs.getDouble(tdsyqmj));
		e.setRjl(rs.getDouble(rjl));
		e.setJysj(rs.getDate(jysj));
		e.setFdcdat(rs.getString(fdcdat));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd02050Xqdm(rs.getString(cd02050Xqdm));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setZlc(rs.getString(zlc));
		e.setFwtdzl(rs.getString(fwtdzl));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setFwlx(rs.getString(fwlx));
		e.setJylx(rs.getString(jylx));
		e.setJzjg(rs.getString(jzjg));
//		e.setFwcx(rs.getString(fwcx));
//		e.setCgzk(rs.getString(cgzk));
		e.setCzr(rs.getString(czr));
		return e;
	}
}
