/**
 * 
 */
package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.hibernate.Session;

import oracle.jdbc.OracleTypes;
import com.sunway.dao.IPgt02002cDAO;
import com.sunway.vo.Pgv02002c;

/**
 * 
 * 收益法商品房房屋信息综合修正
 * @author Andy
 *
 */
public class Pgt02002cDAO extends BaseDAO implements IPgt02002cDAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02002cDAO#LoadAll(com.sunway.vo.Pgv02002c)
	 */
	
	@Override
	public ArrayList<Pgv02002c> LoadAll(Pgv02002c bean) throws Exception {
		ArrayList<Pgv02002c> listResult = new ArrayList<Pgv02002c>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02002C(?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 注册输入参数
			call.setString(2, bean.getCd02002Fcid());
			call.setString(3, bean.getCd00001Szqy());
			call.setString(4, bean.getCd00001Fwlx());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgv02002c e = new Pgv02002c();
				e.setCd00053Qtxzid(rs.getString("infoid"));
				e.setQtxznm(rs.getString("infonm"));
				e.setParentId(rs.getString("parentid"));
				e.setIsDir(rs.getBoolean("ISDIR"));
				e.setIsId(rs.getBoolean("ISID"));
				e.setIsMr(rs.getBoolean("ISMR"));
				listResult.add(e);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	@Override
	public ArrayList<Pgv02002c> LoadAllQM(Pgv02002c v02002c) throws Exception {
		ArrayList<Pgv02002c> listResult = new ArrayList<Pgv02002c>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02020C(?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 注册输入参数
			call.setString(2, v02002c.getCd02002Fcid());
			// 注册输入参数
			call.setString(3, v02002c.getCd00001Szqy());
			call.setString(4, v02002c.getCd00001Fwlx());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgv02002c e = new Pgv02002c();
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
