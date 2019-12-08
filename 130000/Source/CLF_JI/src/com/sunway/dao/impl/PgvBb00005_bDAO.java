package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgvBb00005_bDAO;
import com.sunway.vo.PgvBb00005_b;

/**
 * 报表5
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */
public class PgvBb00005_bDAO extends BaseDAO implements IPgvBb00005_bDAO {

	private static final String cd00002Pssd = "CD_00002_PSSD";
	private static final String cd12003Fcyz = "CD_12003_FCYZ";
	private static final String cbpgjg = "CBPGJG";
	private static final String cbfcpgjg = "CBFCPGJG";
	private static final String cbdcpgjg = "CBDCPGJG";
	private static final String cbdcypgjg = "CBDCYPGJG";
	private static final String cd00001Jjlx = "CD_00001_JJLX";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String zje1 = "ZJE1";
	private static final String zjl1 = "ZJL1";
	private static final String zje2 = "ZJE2";
	private static final String zjl2 = "ZJL2";
	private static final String pgjgY = "PGJG_Y";
	private static final String zje3 = "ZJE3";
	private static final String zjl3 = "ZJL3";
	private static final String jjlx = "JJLX";
	private static final String bm = "BM";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgvBb00005_bDAO#LoadAll(com.sunway.vo.PgvBb00005_b)
	 */
	
	@Override
	public ArrayList<PgvBb00005_b> LoadAll(PgvBb00005_b bb00005_b) throws Exception {
		ArrayList<PgvBb00005_b> listResult = new ArrayList<PgvBb00005_b>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BB_00005_B(?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, bb00005_b.getCd00001Ssgx());
			call.setString(3, bb00005_b.getCd00002Pssd());
			call.setBoolean(4, bb00005_b.getSfssgx());
			call.setString(5, bb00005_b.getCd00002Czr());
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
	protected PgvBb00005_b SetVParameters(ResultSet rs) throws Exception {
		PgvBb00005_b e = new PgvBb00005_b();
		e.setBm(rs.getInt(bm));
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setCd12003Fcyz(rs.getDouble(cd12003Fcyz));
		e.setCbpgjg(rs.getDouble(cbpgjg));
		e.setCbfcpgjg(rs.getDouble(cbfcpgjg));
		e.setCbdcpgjg(rs.getDouble(cbdcpgjg));
		e.setCbdcypgjg(rs.getDouble(cbdcypgjg));
		e.setCd00001Jjlx(rs.getString(cd00001Jjlx));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setZje1(rs.getDouble(zje1));
		e.setZjl1(rs.getDouble(zjl1));
		e.setZje2(rs.getDouble(zje2));
		e.setZjl2(rs.getDouble(zjl2));
		e.setPgjgY(rs.getDouble(pgjgY));
		e.setZje3(rs.getDouble(zje3));
		e.setZjl3(rs.getDouble(zjl3));
		e.setJjlx(rs.getString(jjlx));
		return e;
	}
}
