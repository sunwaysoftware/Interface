/**
 *
 */
package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgt00331cDAO;
import com.sunway.vo.Pgt00331c;

/**
 * @author Andy.Gao
 *
 */
public class Pgt00331cDAO extends BaseDAO implements IPgt00331cDAO {

	private static final String cd00302Fcid =  "CD_00302_FCID";
	private static final String cd00001Rootid = "CD_00001_ROOTID";
	private static final String rootnm = "ROOTNM";
	private static final String infonm =  "INFONM";
	private static final String xzxs =  "XZXS";
	private static final String czlx =  "CZLX";

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00331cDAO#LoadAll(com.sunway.vo.Pgt00331c)
	 */
	
	@Override
	public ArrayList<Pgt00331c> LoadAll(Pgt00331c bean) throws Exception {
		ArrayList<Pgt00331c> listResult = new ArrayList<Pgt00331c>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00331C(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd00302Fcid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				Pgt00331c e = new Pgt00331c();
				e.setCd00302Fcid(rs.getString(cd00302Fcid));
				e.setCd00001Rootid(rs.getString(cd00001Rootid));
				e.setRootnm(rs.getString(rootnm));
				e.setInfonm(rs.getString(infonm));
				e.setXzxs(rs.getDouble(xzxs));
				e.setCzlx(rs.getInt(czlx));
				listResult.add(e);
				e = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	
	
	public ArrayList<Pgt00331c> LoadAll_B(Pgt00331c bean) throws Exception {
		ArrayList<Pgt00331c> listResult = new ArrayList<Pgt00331c>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00331C_B(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd00302Fcid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				Pgt00331c e = new Pgt00331c();
				e.setCd00302Fcid(rs.getString(cd00302Fcid));
				e.setCd00001Rootid(rs.getString(cd00001Rootid));
				e.setRootnm(rs.getString(rootnm));
				e.setInfonm(rs.getString(infonm));
				e.setXzxs(rs.getDouble(xzxs));
				e.setCzlx(rs.getInt(czlx));
				listResult.add(e);
				e = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

}
