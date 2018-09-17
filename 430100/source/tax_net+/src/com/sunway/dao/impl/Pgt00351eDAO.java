package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgt00351eDAO;
import com.sunway.vo.Pgv00351e;

/**
 * 
 * 市场法标准实例库其它修正参数表
 * @author Lee
 *
 */
public class Pgt00351eDAO extends BaseDAO implements IPgt00351eDAO {

	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00351eDAO#LoadAll(com.sunway.vo.Pgv00351e)
	 */
	
	@Override
	public ArrayList<Pgv00351e> LoadAll(Pgv00351e v00351e) throws Exception {
		ArrayList<Pgv00351e> listResult = new ArrayList<Pgv00351e>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00351C(?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 注册输入参数
			call.setString(2, v00351e.getCd00351Slid());
			call.setString(3, v00351e.getCd00001Szqy());
			call.setString(4, v00351e.getCd00001Fwlx());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgv00351e e = new Pgv00351e();
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
