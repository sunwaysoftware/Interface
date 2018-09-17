package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgvBb00007DAO;
import com.sunway.vo.PgvBb00007;

/**
 * 报表7
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */
public class PgvBb00007DAO extends BaseDAO implements IPgvBb00007DAO {

	private static final String cd00002Pssd = "CD_00002_PSSD";
	private static final String se = "SE";
	private static final String cbpgjg = "CBPGJG";
	private static final String cbdcypgjg = "CBDCYPGJG";
	private static final String cd00001Jjlx = "CD_00001_JJLX";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String cbsl = "CBSL";
	private static final String dcpg = "DCPG";
	private static final String dcsl = "DCSL";
	private static final String jjlx = "JJLX";
	private static final String bm = "BM";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgvBb00007DAO#LoadAll(com.sunway.vo.PgvBb00007)
	 */
	
	@Override
	public ArrayList<PgvBb00007> LoadAll(PgvBb00007 bb00007) throws Exception {
		ArrayList<PgvBb00007> listResult = new ArrayList<PgvBb00007>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BB_00007(?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, bb00007.getCd00001Ssgx());
			call.setString(3, bb00007.getCd00002Pssd());
			call.setDouble(4, bb00007.getSl());
			call.setDouble(5, bb00007.getJsbl());
			call.setString(6, bb00007.getCd00002Czr());
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
	protected PgvBb00007 SetVParameters(ResultSet rs) throws Exception {
		PgvBb00007 e = new PgvBb00007();
		e.setBm(rs.getInt(bm));
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setSe(rs.getDouble(se));
		e.setCbpgjg(rs.getDouble(cbpgjg));
		e.setCbdcypgjg(rs.getDouble(cbdcypgjg));
		e.setCd00001Jjlx(rs.getString(cd00001Jjlx));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setCbsl(rs.getDouble(cbsl));
		e.setDcpg(rs.getDouble(dcpg));
		e.setDcsl(rs.getDouble(dcsl));
		e.setJjlx(rs.getString(jjlx));
		return e;
	}
}
