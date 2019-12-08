package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgvDb000012DAO;
import com.sunway.vo.PgvDb000012;

/**
 * 经济类型对比分析
 * @category 数据对比分析
 * @author Lee
 * @version 1.0
 */
public class PgvDb000012DAO extends BaseDAO implements IPgvDb000012DAO {

	private static final String cd00002Pssd = "CD_00002_PSSD";
	private static final String cd12001Fcse = "CD_12001_FCSE";
	private static final String cd12001Tdse = "CD_12001_TDSE";
	private static final String cd12002Syqmj = "CD_12002_SYQMJ";
	private static final String cd12002Ysmj = "CD_12002_YSMJ";
	private static final String cd12002Msmj = "CD_12002_MSMJ";
	private static final String cd12002Count = "CD_12002_COUNT";
	private static final String cd12003Zjzmj = "CD_12003_ZJZMJ";
	private static final String cd12003Fcyz = "CD_12003_FCYZ";
	private static final String cd12003Ysfcyz = "CD_12003_YSFCYZ";
	private static final String cd12003Msfcyz = "CD_12003_MSFCYZ";
	private static final String cd12003Count = "CD_12003_COUNT";
	private static final String cd12004Ytjzmj = "CD_12004_YTJZMJ";
	private static final String cd12004Count = "CD_12004_COUNT";
	private static final String cd00001Jjlx = "CD_00001_JJLX";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String cd12001Count = "CD_12001_COUNT";
	private static final String cbpgjg = "CBPGJG";
	private static final String cbfcpgjg = "CBFCPGJG";
	private static final String cbdcpgjg = "CBDCPGJG";
	private static final String tdpjsebz = "TDPJSEBZ";
	private static final String jsyjzjed = "JSYJZJED";
	private static final String jjlx = "JJLX";
	private static final String sumCd12001Fcse = "SUM_CD_12001_FCSE";
	private static final String sumCd12001Tdse = "SUM_CD_12001_TDSE";
	private static final String sumCd12002Syqmj = "SUM_CD_12002_SYQMJ";
	private static final String sumCd12002Ysmj = "SUM_CD_12002_YSMJ";
	private static final String sumCd12002Msmj = "SUM_CD_12002_MSMJ";
	private static final String sumCd12002Count = "SUM_CD_12002_COUNT";
	private static final String sumCd12003Zjzmj = "SUM_CD_12003_ZJZMJ";
	private static final String sumCd12003Fcyz = "SUM_CD_12003_FCYZ";
	private static final String sumCd12003Ysfcyz = "SUM_CD_12003_YSFCYZ";
	private static final String sumCd12003Msfcyz = "SUM_CD_12003_MSFCYZ";
	private static final String sumCd12003Count = "SUM_CD_12003_COUNT";
	private static final String sumCd12004Ytjzmj = "SUM_CD_12004_YTJZMJ";
	private static final String sumCd12004Count = "SUM_CD_12004_COUNT";
	private static final String sumCd12001Count = "SUM_CD_12001_COUNT";
	private static final String sumCbpgjg = "SUM_CBPGJG";
	private static final String sumCbfcpgjg = "SUM_CBFCPGJG";
	private static final String sumCbdcpgjg = "SUM_CBDCPGJG";
	private static final String sumTdpjsebz = "SUM_TDPJSEBZ";
	private static final String sumJsyjzjed = "SUM_JSYJZJED";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgvDb000012DAO#LoadAll(com.sunway.vo.PgvDb000012)
	 */
	
	@Override
	public PgvDb000012 LoadAll(PgvDb000012 db000012) throws Exception {
		PgvDb000012 listResult = new PgvDb000012();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DB_000012(?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(3, db000012.getCd00002Pssd());
			call.setString(4, db000012.getCd00001Ssgx());
			call.setString(5, db000012.getCd00002Czr());
			call.execute();
			//返回列合
			rsSum = (ResultSet) call.getObject(2); 
			while(null!=rsSum && rsSum.next()){
				listResult.setSumCd12001Fcse(rsSum.getDouble(sumCd12001Fcse));
				listResult.setSumCd12001Tdse(rsSum.getDouble(sumCd12001Tdse));
				listResult.setSumCd12002Syqmj(rsSum.getDouble(sumCd12002Syqmj));
				listResult.setSumCd12002Ysmj(rsSum.getDouble(sumCd12002Ysmj));
				listResult.setSumCd12002Msmj(rsSum.getDouble(sumCd12002Msmj));
				listResult.setSumCd12002Count(rsSum.getShort(sumCd12002Count));
				listResult.setSumCd12003Zjzmj(rsSum.getDouble(sumCd12003Zjzmj));
				listResult.setSumCd12003Fcyz(rsSum.getDouble(sumCd12003Fcyz));
				listResult.setSumCd12003Ysfcyz(rsSum.getDouble(sumCd12003Ysfcyz));
				listResult.setSumCd12003Msfcyz(rsSum.getDouble(sumCd12003Msfcyz));
				listResult.setSumCd12003Count(rsSum.getShort(sumCd12003Count));
				listResult.setSumCd12004Ytjzmj(rsSum.getDouble(sumCd12004Ytjzmj));
				listResult.setSumCd12004Count(rsSum.getShort(sumCd12004Count));
				listResult.setSumCd12001Count(rsSum.getShort(sumCd12001Count));
				listResult.setSumCbpgjg(rsSum.getDouble(sumCbpgjg));
				listResult.setSumCbfcpgjg(rsSum.getDouble(sumCbfcpgjg));
				listResult.setSumCbdcpgjg(rsSum.getDouble(sumCbdcpgjg));
				listResult.setSumTdpjsebz(rsSum.getDouble(sumTdpjsebz));
				listResult.setSumJsyjzjed(rsSum.getDouble(sumJsyjzjed));
			}
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.getDb000012List().add(SetVParameters(rs));
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
	protected PgvDb000012 SetVParameters(ResultSet rs) throws Exception {
		PgvDb000012 e = new PgvDb000012();
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setCd12001Fcse(rs.getDouble(cd12001Fcse));
		e.setCd12001Tdse(rs.getDouble(cd12001Tdse));
		e.setCd12002Syqmj(rs.getDouble(cd12002Syqmj));
		e.setCd12002Ysmj(rs.getDouble(cd12002Ysmj));
		e.setCd12002Msmj(rs.getDouble(cd12002Msmj));
		e.setCd12002Count(rs.getShort(cd12002Count));
		e.setCd12003Zjzmj(rs.getDouble(cd12003Zjzmj));
		e.setCd12003Fcyz(rs.getDouble(cd12003Fcyz));
		e.setCd12003Ysfcyz(rs.getDouble(cd12003Ysfcyz));
		e.setCd12003Msfcyz(rs.getDouble(cd12003Msfcyz));
		e.setCd12003Count(rs.getShort(cd12003Count));
		e.setCd12004Ytjzmj(rs.getDouble(cd12004Ytjzmj));
		e.setCd12004Count(rs.getShort(cd12004Count));
		e.setCd00001Jjlx(rs.getString(cd00001Jjlx));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setCd12001Count(rs.getShort(cd12001Count));
		e.setCbpgjg(rs.getDouble(cbpgjg));
		e.setCbfcpgjg(rs.getDouble(cbfcpgjg));
		e.setCbdcpgjg(rs.getDouble(cbdcpgjg));
		e.setTdpjsebz(rs.getDouble(tdpjsebz));
		e.setJsyjzjed(rs.getDouble(jsyjzjed));
		e.setJjlx(rs.getString(jjlx));
		return e;
	}
}
