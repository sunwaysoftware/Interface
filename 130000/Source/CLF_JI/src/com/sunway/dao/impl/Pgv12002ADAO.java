package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgv12002ADAO;
import com.sunway.vo.Pgv12002A;

/**
 * 地产信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv12002ADAO extends BaseDAO implements IPgv12002ADAO {

	private static final String dcid = "DCID";
	private static final String cd12001aSwid = "CD_12001A_SWID";
	private static final String tdsyqbm = "TDSYQBM";
	private static final String cd00001Tdyt = "CD_00001_TDYT";
	private static final String cd00001Syqlx = "CD_00001_SYQLX";
	private static final String syqmj = "SYQMJ";
	private static final String cd00001Tdsyqlx = "CD_00001_TDSYQLX";
	private static final String cd12054Tddjid = "CD_12054_TDDJID";
	private static final String cd00001Szqy = "CD_00001_SZQY";
	private static final String tdzl = "TDZL";
	private static final String gbrjl = "GBRJL";
	private static final String ysmj = "YSMJ";
	private static final String msmj = "MSMJ";
	private static final String tdpfmse = "TDPFMSE";
	private static final String x = "X";
	private static final String y = "Y";
	private static final String lrdate = "LRDATE";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String sykssj = "SYKSSJ";
	private static final String syjssj = "SYJSSJ";
	private static final String czh = "CZH";
	private static final String bgsj = "BGSJ";
	private static final String sfbg = "SFBG";
	private static final String bglx = "BGLX";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String nsrmc = "NSRMC";
	private static final String tdsyqlx = "TDSYQLX";
	private static final String tdyt = "TDYT";
	private static final String syqlx = "SYQLX";
	private static final String tddj = "TDDJ";
	private static final String szqy = "SZQY";
	private static final String bgczr = "BGCZR";
	private static final String bgmc = "BGMC";
	private static final String czr = "CZR";
	private static final String recordCount = "TOTAL";
	private static final String recordIndex = "RID";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgv12002ADAO#LoadAll(com.sunway.vo.Pgv12002A)
	 */
	
	@Override
	public ArrayList<Pgv12002A> LoadAll(Pgv12002A v12002A) throws Exception {
		ArrayList<Pgv12002A> listResult = new ArrayList<Pgv12002A>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12002A(?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v12002A.getPageIndex());
			call.setInt(3, v12002A.getPageSize());
			call.setString(4, v12002A.getDcid());
			call.setString(5, v12002A.getCd12001aSwid());
			call.setString(6, v12002A.getNsrmc());
			call.setString(7, v12002A.getCd00001Ssgx());
			call.setString(8, v12002A.getCzh());
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
	protected Pgv12002A SetVParameters(ResultSet rs) throws Exception {
		Pgv12002A e = new Pgv12002A();
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		e.setDcid(rs.getString(dcid));
		e.setCd12001aSwid(rs.getString(cd12001aSwid));
		e.setTdsyqbm(rs.getString(tdsyqbm));
		e.setCd00001Tdyt(rs.getString(cd00001Tdyt));
		e.setCd00001Syqlx(rs.getString(cd00001Syqlx));
		e.setSyqmj(rs.getDouble(syqmj));
		e.setCd00001Tdsyqlx(rs.getString(cd00001Tdsyqlx));
		e.setCd12054Tddjid(rs.getString(cd12054Tddjid));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setTdzl(rs.getString(tdzl));
		e.setGbrjl(rs.getDouble(gbrjl));
		e.setYsmj(rs.getDouble(ysmj));
		e.setMsmj(rs.getDouble(msmj));
		e.setTdpfmse(rs.getDouble(tdpfmse));
		e.setX(rs.getDouble(x));
		e.setY(rs.getDouble(y));
		e.setLrdate(rs.getTimestamp(lrdate));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setSykssj(rs.getDate(sykssj));
		e.setSyjssj(rs.getDate(syjssj));
		e.setCzh(rs.getString(czh));
		e.setBgsj(rs.getDate(bgsj));
		e.setSfbg(rs.getBoolean(sfbg));
		e.setBglx(rs.getBoolean(bglx));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setNsrmc(rs.getString(nsrmc));
		e.setTdsyqlx(rs.getString(tdsyqlx));
		e.setTdyt(rs.getString(tdyt));
		e.setSyqlx(rs.getString(syqlx));
		e.setTddj(rs.getString(tddj));
		e.setSzqy(rs.getString(szqy));
		e.setBgczr(rs.getString(bgczr));
		e.setBgmc(rs.getString(bgmc));
		e.setCzr(rs.getString(czr));
		return e;
	}
}
