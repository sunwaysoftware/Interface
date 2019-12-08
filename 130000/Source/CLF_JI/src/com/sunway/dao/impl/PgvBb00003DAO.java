package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgvBb00003DAO;
import com.sunway.vo.PgvBb00003;

/**
 * 报表3
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public class PgvBb00003DAO extends BaseDAO implements IPgvBb00003DAO {

	private static final String cd00002Pssd = "CD_00002_PSSD";
	private static final String cd12001Count = "CD_12001_COUNT";
	private static final String cd10031Count = "CD_10031_COUNT";
	private static final String cd12002Syqmj = "CD_12002_SYQMJ";
	private static final String cd12001Tdse = "CD_12001_TDSE";
	private static final String cbdcpgjg = "CBDCPGJG";
	private static final String cd12003Zjzmj = "CD_12003_ZJZMJ";
	private static final String cd12001Fcse = "CD_12001_FCSE";
	private static final String cbfcpgjg = "CBFCPGJG";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String cd00001Jjlx = "CD_00001_JJLX";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String jjlx = "JJLX";
	private static final String bm = "BM";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgvBb00003DAO#LoadAll(com.sunway.vo.PgvBb00003)
	 */
	
	@Override
	public ArrayList<PgvBb00003> LoadAll(PgvBb00003 bb00003) throws Exception {
		ArrayList<PgvBb00003> listResult = new ArrayList<PgvBb00003>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BB_00003(?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, bb00003.getCd00001Ssgx());
			call.setString(3, bb00003.getCd00002Pssd());
			call.setString(4, bb00003.getCd00002Czr());
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
	protected PgvBb00003 SetVParameters(ResultSet rs) throws Exception {
		PgvBb00003 e = new PgvBb00003();
		e.setBm(rs.getInt(bm));
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setCd12001Count(rs.getShort(cd12001Count));
		e.setCd10031Count(rs.getShort(cd10031Count));
		e.setCd12002Syqmj(rs.getDouble(cd12002Syqmj));
		e.setCd12001Tdse(rs.getDouble(cd12001Tdse));
		e.setCbdcpgjg(rs.getDouble(cbdcpgjg));
		e.setCd12003Zjzmj(rs.getDouble(cd12003Zjzmj));
		e.setCd12001Fcse(rs.getDouble(cd12001Fcse));
		e.setCbfcpgjg(rs.getDouble(cbfcpgjg));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00001Jjlx(rs.getString(cd00001Jjlx));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setJjlx(rs.getString(jjlx));
		return e;
	}
}
