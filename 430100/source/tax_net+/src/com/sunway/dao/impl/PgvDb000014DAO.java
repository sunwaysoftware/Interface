package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgvDb000014DAO;
import com.sunway.vo.PgvDb000014;

/**
 * 现行税率行业对比分析
 * @category 数据对比分析
 * @author Lee
 * @version 1.0
 */
public class PgvDb000014DAO extends BaseDAO implements IPgvDb000014DAO {

	private static final String cd00002Pssd = "CD_00002_PSSD";
	private static final String cd12001Fcse = "CD_12001_FCSE";
	private static final String cd12001Tdse = "CD_12001_TDSE";
	private static final String cd12002Syqmj = "CD_12002_SYQMJ";
	private static final String cd12002Ysmj = "CD_12002_YSMJ";
	private static final String cd12002Msmj = "CD_12002_MSMJ";
	private static final String cd12002Count = "CD_12002_COUNT";
	private static final String cd12003Zjzmj = "CD_12003_ZJZMJ";
	private static final String cd12003Fcyz = "CD_12003_FCYZ";
	private static final String cd12003Count = "CD_12003_COUNT";
	private static final String cd12004Bytjzmj = "CD_12004_BYTJZMJ";
	private static final String cd12004Mytjzmj = "CD_12004_MYTJZMJ";
	private static final String cd00001Hy = "CD_00001_HY";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String cd12001Count = "CD_12001_COUNT";
	private static final String cbpgjg = "CBPGJG";
	private static final String hy = "HY";
	private static final String gghsl = "GGHSL";
	private static final String sezjed = "SEZJED";
	private static final String sezjbs = "SEZJBS";
	private static final String sumCd12001Fcse = "SUM_CD_12001_FCSE";
	private static final String sumCd12001Tdse = "SUM_CD_12001_TDSE";
	private static final String sumCd12002Syqmj = "SUM_CD_12002_SYQMJ";
	private static final String sumCd12002Ysmj = "SUM_CD_12002_YSMJ";
	private static final String sumCd12002Msmj = "SUM_CD_12002_MSMJ";
	private static final String sumCd12002Count = "SUM_CD_12002_COUNT";
	private static final String sumCd12003Zjzmj = "SUM_CD_12003_ZJZMJ";
	private static final String sumCd12003Fcyz = "SUM_CD_12003_FCYZ";
	private static final String sumCd12004Bytjzmj = "SUM_CD_12004_BYTJZMJ";
	private static final String sumCd12004Mytjzmj = "SUM_CD_12004_MYTJZMJ";
	private static final String sumCd12003Count = "SUM_CD_12003_COUNT";
	private static final String sumCd12001Count = "SUM_CD_12001_COUNT";
	private static final String sumCbpgjg = "SUM_CBPGJG";
	private static final String sumGghsl = "SUM_GGHSL";
	private static final String sumSezjed = "SUM_SEZJED";
	private static final String sumSezjbs = "SUM_SEZJBS";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgvDb000014DAO#LoadAll(com.sunway.vo.PgvDb000014)
	 */
	
	@Override
	public PgvDb000014 LoadAll(PgvDb000014 db000014) throws Exception {
		PgvDb000014 listResult = new PgvDb000014();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DB_000014(?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(3, db000014.getCd00002Pssd());
			call.setString(4, db000014.getCd00001Ssgx());
			call.setDouble(5, db000014.getJsbl());
			call.setDouble(6, db000014.getSl());
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
				listResult.setSumCd12004Bytjzmj(rsSum.getDouble(sumCd12004Bytjzmj));
				listResult.setSumCd12004Mytjzmj(rsSum.getDouble(sumCd12004Mytjzmj));
				listResult.setSumCd12003Count(rsSum.getShort(sumCd12003Count));
				listResult.setSumCd12001Count(rsSum.getShort(sumCd12001Count));
				listResult.setSumCbpgjg(rsSum.getDouble(sumCbpgjg));
				listResult.setSumGghsl(rsSum.getDouble(sumGghsl));
				listResult.setSumSezjed(rsSum.getDouble(sumSezjed));
				listResult.setSumSezjbs(rsSum.getDouble(sumSezjbs));
			}
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.getDb000014List().add(SetVParameters(rs));
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
	 * @see com.sunway.dao.IPgvDb000014DAO#GetInsertCommand(com.sunway.vo.PgvDb000014)
	 */
	
	@Override
	public boolean GetInsertCommand(PgvDb000014 db000014) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT100404(?,?,?)}");
			// 传入输入参数
			call.setString(1, db000014.getCd00002Pssd());
			call.setString(2, db000014.getCd00001Ssgx());
			call.setString(3, db000014.getCd00002Czr());
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

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected PgvDb000014 SetVParameters(ResultSet rs) throws Exception {
		PgvDb000014 e = new PgvDb000014();
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setCd12001Fcse(rs.getDouble(cd12001Fcse));
		e.setCd12001Tdse(rs.getDouble(cd12001Tdse));
		e.setCd12002Syqmj(rs.getDouble(cd12002Syqmj));
		e.setCd12002Ysmj(rs.getDouble(cd12002Ysmj));
		e.setCd12002Msmj(rs.getDouble(cd12002Msmj));
		e.setCd12002Count(rs.getShort(cd12002Count));
		e.setCd12003Zjzmj(rs.getDouble(cd12003Zjzmj));
		e.setCd12003Fcyz(rs.getDouble(cd12003Fcyz));
		e.setCd12003Count(rs.getShort(cd12003Count));
		e.setCd12004Bytjzmj(rs.getDouble(cd12004Bytjzmj));
		e.setCd12004Mytjzmj(rs.getDouble(cd12004Mytjzmj));
		e.setCd00001Hy(rs.getString(cd00001Hy));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setCd12001Count(rs.getShort(cd12001Count));
		e.setCbpgjg(rs.getDouble(cbpgjg));
		e.setHy(rs.getString(hy));
		e.setGghsl(rs.getDouble(gghsl));
		e.setSezjed(rs.getDouble(sezjed));
		e.setSezjbs(rs.getDouble(sezjbs));
		return e;
	}
}
