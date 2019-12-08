package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgvBb00002DAO;
import com.sunway.vo.PgvBb00002;

/**
 * 报表2
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public class PgvBb00002DAO extends BaseDAO implements IPgvBb00002DAO {

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
	private static final String cd00001Hy = "CD_00001_HY";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String hy = "HY";
	private static final String bm = "BM";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgvBb00002DAO#LoadAll(com.sunway.vo.PgvBb00002)
	 */
	
	@Override
	public ArrayList<PgvBb00002> LoadAll(PgvBb00002 bb00002) throws Exception {
		ArrayList<PgvBb00002> listResult = new ArrayList<PgvBb00002>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BB_00002(?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, bb00002.getCd00001Ssgx());
			call.setString(3, bb00002.getCd00002Pssd());
			call.setString(4, bb00002.getCd00002Czr());
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
	protected PgvBb00002 SetVParameters(ResultSet rs) throws Exception {
		PgvBb00002 e = new PgvBb00002();
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
		e.setCd00001Hy(rs.getString(cd00001Hy));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setHy(rs.getString(hy));
		return e;
	}
}
