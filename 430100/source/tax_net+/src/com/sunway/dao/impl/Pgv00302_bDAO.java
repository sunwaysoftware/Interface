package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgv00302_bDAO;
import com.sunway.vo.Pgv00302_b;

/**
 * 住宅国土信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv00302_bDAO extends BaseDAO implements IPgv00302_bDAO {

	private static final String recordCount = "TOTAL";
	private static final String fcid="FCID";
	private static final String cd00301BSwid="CD_00301_B_SWID";
	private static final String cd00303Lfid="CD_00303_LFID";
	private static final String cd00001Fwlx="CD_00001_FWLX";
	private static final String cd00001Jylx="CD_00001_JYLX";
	private static final String cd00001Jzjg="CD_00001_JZJG";
	private static final String jzmj="JZMJ";
	private static final String cd00001Fwcx="CD_00001_FWCX";
	private static final String cd00001Cgzk="CD_00001_CGZK";
	private static final String szlc="SZLC";
	private static final String bwjfh="BWJFH";
	private static final String jyjg="JYJG";
	private static final String dtgj="DTGJ";
	private static final String tdsyqmj="TDSYQMJ";
	private static final String rjl="RJL";
	private static final String jysj="JYSJ";
	private static final String fdcdat="FDCDAT";
	private static final String upddate="UPDDATE";
	private static final String cd00002Czr="CD_00002_CZR";
	private static final String note="NOTE";
	private static final String cd00002Pssd="CD_00002_PSSD";
	private static final String nsrmc="NSRMC";
	private static final String cd00001Ssgx="CD_00001_SSGX";
	private static final String cd00352Xqdm="CD_00352_XQDM";
	private static final String cd00001Szqy="CD_00001_SZQY";
	private static final String ywdt="YWDT";
	private static final String zlc="ZLC";
	private static final String fwtdzl="FWTDZL";
	private static final String xqnm="XQNM";
	private static final String xqbm="XQBM";
	private static final String szqy="SZQY";
	private static final String fwlx="FWLX";
	private static final String jylx="JYLX";
	private static final String jzjg="JZJG";
	private static final String fwcx="FWCX";
	private static final String cgzk="CGZK";
	private static final String czr="CZR";
	private static final String sczt = "SCZT";
	private static final String pgjg = "PGJG";
	private static final String gbpgjg = "GBPGJG";
	private static final String jsze = "JSZE";
	private static final String ynze = "YNZE";
	private static final String sumJzmj="SUM_JZMJ";
	private static final String sumJyjg="SUM_JYJG";
	private static final String sumDtgj="SUM_DTGJ";
	private static final String sumTdsyqmj="SUM_TDSYQMJ";
	private static final String avgRjl="AVG_RJL";
	private static final String sumPgjg = "SUM_PGJG";
	private static final String sumGbpgjg = "SUM_GBPGJG";
	private static final String sumJsze = "SUM_JSZE";
	private static final String sumYnze = "SUM_YNZE";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgv00302_bDAO#LoadAll(com.sunway.vo.Pgv00302_b)
	 */
	
	@Override
	public Pgv00302_b LoadAll(Pgv00302_b v00302_b) throws Exception {
		Pgv00302_b listResult = new Pgv00302_b();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00302_B(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(3, v00302_b.getPageIndex());
			call.setInt(4, v00302_b.getPageSize());
			call.setString(5, v00302_b.getFcid());
			call.setString(6, v00302_b.getCd00301BSwid());
			call.setString(7, v00302_b.getNsrmc());
			call.setString(8, v00302_b.getFdcdat());
			call.setString(9, v00302_b.getXqnm());
			call.setString(10, v00302_b.getFwtdzl());
			call.setString(11, v00302_b.getCd00001Szqy());
			call.setString(12, v00302_b.getCd00001Ssgx());
			call.setString(13, v00302_b.getCd00002Pssd());
			call.setInt(14, v00302_b.getSczt());
			call.execute();
			//返回列合
			rsSum = (ResultSet) call.getObject(2); 
			while(null!=rsSum && rsSum.next()){
				listResult.setSumJzmj(rsSum.getDouble(sumJzmj));
				listResult.setSumJyjg(rsSum.getDouble(sumJyjg));
				listResult.setSumDtgj(rsSum.getDouble(sumDtgj));
				listResult.setSumTdsyqmj(rsSum.getDouble(sumTdsyqmj));
				listResult.setAvgRjl(rsSum.getDouble(avgRjl));
				listResult.setSumPgjg(rsSum.getDouble(sumPgjg));
				listResult.setSumGbpgjg(rsSum.getDouble(sumGbpgjg));
				listResult.setSumJsze(rsSum.getDouble(sumJsze));
				listResult.setSumYnze(rsSum.getDouble(sumYnze));
			}
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.getV00302_bList().add(SetVParameters(rs));
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
	 * @see com.sunway.dao.IPgv00302_bDAO#LoadDetail(com.sunway.vo.Pgv00302_b)
	 */
	
	@Override
	public Pgv00302_b LoadDetail(Pgv00302_b v00302_b) throws Exception {
		ArrayList<Pgv00302_b> listResult = new ArrayList<Pgv00302_b>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00302_B0(?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v00302_b.getFcid());
			call.setString(3, v00302_b.getCd00002Pssd());
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
			return new Pgv00302_b();
		}
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00302_b SetVParameters(ResultSet rs) throws Exception {
		Pgv00302_b e = new Pgv00302_b();
		e.setRecordCount(rs.getInt(recordCount));
		e.setFcid(rs.getString(fcid));
		e.setCd00301BSwid(rs.getString(cd00301BSwid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJzmj(rs.getDouble(jzmj));
		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
		e.setCd00001Cgzk(rs.getString(cd00001Cgzk));
		e.setSzlc(rs.getShort(szlc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setJyjg(rs.getDouble(jyjg));
		e.setDtgj(rs.getDouble(dtgj));
		e.setTdsyqmj(rs.getDouble(tdsyqmj));
		e.setRjl(rs.getDouble(rjl));
		e.setJysj(rs.getDate(jysj));
		e.setFdcdat(rs.getString(fdcdat));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00352Xqdm(rs.getString(cd00352Xqdm));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setYwdt(rs.getBoolean(ywdt));
		e.setZlc(rs.getShort(zlc));
		e.setFwtdzl(rs.getString(fwtdzl));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setFwlx(rs.getString(fwlx));
		e.setJylx(rs.getString(jylx));
		e.setJzjg(rs.getString(jzjg));
		e.setFwcx(rs.getString(fwcx));
		e.setCgzk(rs.getString(cgzk));
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
	protected Pgv00302_b SetDParameters(ResultSet rs) throws Exception {
		Pgv00302_b e = new Pgv00302_b();
		e.setFcid(rs.getString(fcid));
		e.setCd00301BSwid(rs.getString(cd00301BSwid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJzmj(rs.getDouble(jzmj));
		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
		e.setCd00001Cgzk(rs.getString(cd00001Cgzk));
		e.setSzlc(rs.getShort(szlc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setJyjg(rs.getDouble(jyjg));
		e.setDtgj(rs.getDouble(dtgj));
		e.setTdsyqmj(rs.getDouble(tdsyqmj));
		e.setRjl(rs.getDouble(rjl));
		e.setJysj(rs.getDate(jysj));
		e.setFdcdat(rs.getString(fdcdat));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00352Xqdm(rs.getString(cd00352Xqdm));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setYwdt(rs.getBoolean(ywdt));
		e.setZlc(rs.getShort(zlc));
		e.setFwtdzl(rs.getString(fwtdzl));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setFwlx(rs.getString(fwlx));
		e.setJylx(rs.getString(jylx));
		e.setJzjg(rs.getString(jzjg));
		e.setFwcx(rs.getString(fwcx));
		e.setCgzk(rs.getString(cgzk));
		e.setCzr(rs.getString(czr));
		return e;
	}
}
