package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgv12003ADAO;
import com.sunway.vo.Pgv12003A;

/**
 * 房产信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv12003ADAO extends BaseDAO implements IPgv12003ADAO {

	private static final String fcid = "FCID";
	private static final String cd12002aDcid = "CD_12002A_DCID";
	private static final String cd12001aSwid = "CD_12001A_SWID";
	private static final String fdcmc = "FDCMC";
	private static final String fwzldz = "FWZLDZ";
	private static final String cd00001Qdfs = "CD_00001_QDFS";
	private static final String jcnf = "JCNF";
	private static final String fwzcs = "FWZCS";
	private static final String ds = "DS";
	private static final String dx = "DX";
	private static final String zjzmj = "ZJZMJ";
	private static final String fcyz = "FCYZ";
	private static final String fwzjje = "FWZJJE";
	private static final String fczh = "FCZH";
	private static final String ysfcyz = "YSFCYZ";
	private static final String msfcyz = "MSFCYZ";
	private static final String qdsj = "QDSJ";
	private static final String lrdate = "LRDATE";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String czh = "CZH";
	private static final String bgsj = "BGSJ";
	private static final String sfbg = "SFBG";
	private static final String bglx = "BGLX";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String nsrmc = "NSRMC";
	private static final String bgczr = "BGCZR";
	private static final String qdfs = "QDFS";
	private static final String bgmc = "BGMC";
	private static final String czr = "CZR";
	private static final String recordCount = "TOTAL";
	private static final String recordIndex = "RID";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgv12003ADAO#LoadAll(com.sunway.vo.Pgv12003A)
	 */
	
	@Override
	public ArrayList<Pgv12003A> LoadAll(Pgv12003A v12003A) throws Exception {
		ArrayList<Pgv12003A> listResult = new ArrayList<Pgv12003A>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12003A(?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v12003A.getPageIndex());
			call.setInt(3, v12003A.getPageSize());
			call.setString(4, v12003A.getFcid());
			call.setString(5, v12003A.getCd12001aSwid());
			call.setString(6, v12003A.getNsrmc());
			call.setString(7, v12003A.getCd00001Ssgx());
			call.setString(8, v12003A.getCzh());
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
	protected Pgv12003A SetVParameters(ResultSet rs) throws Exception {
		Pgv12003A e = new Pgv12003A();
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		e.setFcid(rs.getString(fcid));
		e.setCd12002aDcid(rs.getString(cd12002aDcid));
		e.setCd12001aSwid(rs.getString(cd12001aSwid));
		e.setFdcmc(rs.getString(fdcmc));
		e.setFwzldz(rs.getString(fwzldz));
		e.setCd00001Qdfs(rs.getString(cd00001Qdfs));
		e.setJcnf(rs.getString(jcnf));
		e.setFwzcs(rs.getShort(fwzcs));
		e.setDs(rs.getShort(ds));
		e.setDx(rs.getShort(dx));
		e.setZjzmj(rs.getDouble(zjzmj));
		e.setFcyz(rs.getDouble(fcyz));
		e.setFwzjje(rs.getDouble(fwzjje));
		e.setFczh(rs.getString(fczh));
		e.setYsfcyz(rs.getDouble(ysfcyz));
		e.setMsfcyz(rs.getDouble(msfcyz));
		e.setQdsj(rs.getDate(qdsj));
		e.setLrdate(rs.getTimestamp(lrdate));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setCzh(rs.getString(czh));
		e.setBgsj(rs.getDate(bgsj));
		e.setSfbg(rs.getBoolean(sfbg));
		e.setBglx(rs.getBoolean(bglx));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setNsrmc(rs.getString(nsrmc));
		e.setBgczr(rs.getString(bgczr));
		e.setQdfs(rs.getString(qdfs));
		e.setBgmc(rs.getString(bgmc));
		e.setCzr(rs.getString(czr));
		return e;
	}
}
