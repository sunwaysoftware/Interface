package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgt00302eDAO;
import com.sunway.vo.Pgv00302e;

/**
 * 
 * 市场法房产其它修正参数表
 * @author Lee
 *
 */
public class Pgt00302eDAO extends BaseDAO implements IPgt00302eDAO {

//	private static final String qtxzId = "CD_00053_QTXZID";
//	private static final String qtxzNm = "QTXZNM";
//	private static final String parentId = "parentid";
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00302eDAO#LoadAll(com.sunway.vo.Pgv00302e)
	 */
	
	@Override
	public ArrayList<Pgv00302e> LoadAll(Pgv00302e v00302e) throws Exception {
		ArrayList<Pgv00302e> listResult = new ArrayList<Pgv00302e>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00302C(?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 注册输入参数
			call.setString(2, v00302e.getCd00302Fcid());
			// 注册输入参数
			call.setString(3, v00302e.getCd00001Szqy());
			call.setString(4, v00302e.getCd00001Fwlx());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgv00302e e = new Pgv00302e();
				e.setCd00053Qtxzid(rs.getString("infoid"));
				e.setQtxznm(rs.getString("infonm"));
				e.setParentId(rs.getString("parentid"));
				e.setIsDir(rs.getBoolean("ISDIR"));
				e.setIsId(rs.getBoolean("ISID"));
				listResult.add(e);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	
	@Override
	public ArrayList<Pgv00302e> LoadAllQM(Pgv00302e v00302e) throws Exception {
		ArrayList<Pgv00302e> listResult = new ArrayList<Pgv00302e>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00320C(?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 注册输入参数
			call.setString(2, v00302e.getCd00302Fcid());
			// 注册输入参数
			call.setString(3, v00302e.getCd00001Szqy());
			call.setString(4, v00302e.getCd00001Fwlx());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgv00302e e = new Pgv00302e();
				e.setCd00053Qtxzid(rs.getString("infoid"));
				e.setQtxznm(rs.getString("infonm"));
				e.setParentId(rs.getString("parentid"));
				e.setIsDir(rs.getBoolean("ISDIR"));
				e.setIsId(rs.getBoolean("ISID"));
				listResult.add(e);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
}
