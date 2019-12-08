package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.ICz00042DAO;
import com.sunway.vo.Cz00042;

/**
 * 税率测算
 * @category 评税结果处理
 * @author Lee
 * @version 1.0
 *
 */
public class Cz00042DAO extends BaseDAO implements ICz00042DAO {

	private static final String tdse = "TDSE";
	private static final String fcse = "FCSE";
	private static final String fcyz = "FCYZ";
	private static final String fcpgjg = "FCPGJG";
	private static final String dcpgjg = "DCPGJG";
	private static final String pgjg = "PGJG";
	private static final String se = "SE";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.ICz00042DAO#LoadAll(com.sunway.vo.Cz00042)
	 */
	
	@Override
	public Cz00042 LoadAll(Cz00042 cz00042) throws Exception {
		ArrayList<Cz00042> listResult = new ArrayList<Cz00042>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00042(?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, cz00042.getPssd());
			call.setString(3, cz00042.getQdfs());
			call.setString(4, cz00042.getSyqlx());
			call.setString(5, cz00042.getMssz());
			call.setString(6, cz00042.getSsgx());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetVParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		if (listResult != null && listResult.size() > 0) {
			return listResult.get(0);
		} else {
			return new Cz00042();
		}
	}

	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Cz00042 SetVParameters(ResultSet rs) throws Exception {
		Cz00042 e = new Cz00042();
		e.setTdse(rs.getDouble(tdse));
		e.setFcse(rs.getDouble(fcse));
		e.setFcyz(rs.getDouble(fcyz));
		e.setFcpgjg(rs.getDouble(fcpgjg));
		e.setDcpgjg(rs.getDouble(dcpgjg));
		e.setPgjg(rs.getDouble(pgjg));
		e.setSe(rs.getDouble(se));
		return e;
	}
}
