package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgv00302ADAO;
import com.sunway.vo.Pgv00302A;

/**
 * 住宅国土信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv00302ADAO extends BaseDAO implements IPgv00302ADAO {

	private static final String fcid = "FCID";
	private static final String cd00301aSwid = "CD_00301A_SWID";
	private static final String cd00303Lfid = "CD_00303_LFID";
	private static final String cd00001Fwlx = "CD_00001_FWLX";
	private static final String cd00001Jylx = "CD_00001_JYLX";
	private static final String cd00001Jzjg = "CD_00001_JZJG";
	private static final String jzmj = "JZMJ";
	private static final String szlc = "SZLC";
	private static final String bwjfh = "BWJFH";
	private static final String jyjg = "JYJG";
	private static final String tdsyqmj = "TDSYQMJ";
	private static final String rjl = "RJL";
	private static final String jysj = "JYSJ";
	private static final String fdcdat = "FDCDAT";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String czh = "CZH";
	private static final String bgsj = "BGSJ";
	private static final String sfbg = "SFBG";
	private static final String bglx = "BGLX";
	private static final String nsrmc = "NSRMC";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String cd00352Xqdm = "CD_00352_XQDM";
	private static final String cd00001Szqy = "CD_00001_SZQY";
	private static final String ywdt = "YWDT";
	private static final String zlc = "ZLC";
	private static final String fwtdzl = "FWTDZL";
	private static final String xqnm = "XQNM";
	private static final String xqbm = "XQBM";
	private static final String szqy = "SZQY";
	private static final String fwlx = "FWLX";
	private static final String jylx = "JYLX";
	private static final String jzjg = "JZJG";
	private static final String czr = "CZR";
	private static final String bgmc = "BGMC";
	private static final String recordCount = "TOTAL";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgv00302ADAO#LoadAll(com.sunway.vo.Pgv00302A)
	 */
	
	@Override
	public ArrayList<Pgv00302A> LoadAll(Pgv00302A v00302A) throws Exception {
		ArrayList<Pgv00302A> listResult = new ArrayList<Pgv00302A>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00302A(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v00302A.getPageIndex());
			call.setInt(3, v00302A.getPageSize());
			call.setString(4, v00302A.getFcid());
			call.setString(5, v00302A.getCd00301aSwid());
			call.setString(6, v00302A.getNsrmc());
			call.setString(7, v00302A.getFdcdat());
			call.setString(8, v00302A.getCd00352Xqdm());
			call.setString(9, v00302A.getZcdzl());
			call.setString(10, v00302A.getZcdzbm());
			call.setString(11, v00302A.getCd00001Szqy());
			call.setString(12, v00302A.getCd00001Ssgx());
			call.setString(13, v00302A.getCzh());
			call.execute();
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
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
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00302A SetVParameters(ResultSet rs) throws Exception {
		Pgv00302A e = new Pgv00302A();
		e.setRecordCount(rs.getInt(recordCount));
		e.setFcid(rs.getString(fcid));
		e.setCd00301aSwid(rs.getString(cd00301aSwid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJzmj(rs.getDouble(jzmj));
//		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
//		e.setCd00001Cgzk(rs.getString(cd00001Cgzk));
		e.setSzlc(rs.getShort(szlc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setJyjg(rs.getDouble(jyjg));
		e.setTdsyqmj(rs.getDouble(tdsyqmj));
		e.setRjl(rs.getDouble(rjl));
		e.setJysj(rs.getDate(jysj));
		e.setFdcdat(rs.getString(fdcdat));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setCzh(rs.getString(czh));
		e.setBgsj(rs.getDate(bgsj));
		e.setSfbg(rs.getBoolean(sfbg));
		e.setBglx(rs.getBoolean(bglx));
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
//		e.setFwcx(rs.getString(fwcx));
//		e.setCgzk(rs.getString(cgzk));
		e.setCzr(rs.getString(czr));
		e.setBgmc(rs.getString(bgmc));
//		e.setJtzk(rs.getString(jtzk));
//		e.setWyzk(rs.getString(wyzk));
//		e.setZxzk(rs.getString(zxzk));
		return e;
	}
}
