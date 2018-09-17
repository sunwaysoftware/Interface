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

import com.sunway.dao.IPgt00334cDAO;
import com.sunway.vo.Pgt00334c;

/**
 * @author Andy.Gao
 *
 */
public class Pgt00334cDAO extends BaseDAO implements IPgt00334cDAO {

	private static final String cd00302Fcid =  "CD_00302_FCID";
	private static final String cdSlid =  "CD_SLID";
	private static final String cd00001Rootid = "CD_00001_ROOTID";
	private static final String rootnm = "ROOTNM";
	private static final String infonm =  "INFONM";
	private static final String xzxs =  "XZXS";
	private static final String czlx =  "CZLX";

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00334cDAO#LoadAll(com.sunway.vo.Pgt00334c)
	 */
	
	@Override
	public ArrayList<Pgt00334c> LoadAll(Pgt00334c bean) throws Exception {
		ArrayList<Pgt00334c> listResult = new ArrayList<Pgt00334c>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00334C(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd00302Fcid());
			call.setString(3, bean.getCdSlid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				Pgt00334c e = new Pgt00334c();
				e.setCd00302Fcid(rs.getString(cd00302Fcid));
				e.setCdSlid(rs.getString(cdSlid));
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
	
	
	
	public ArrayList<Pgt00334c> LoadAll_B(Pgt00334c bean) throws Exception {
		ArrayList<Pgt00334c> listResult = new ArrayList<Pgt00334c>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00334C_B(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd00302Fcid());
			call.setString(3, bean.getCdSlid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				Pgt00334c e = new Pgt00334c();
				e.setCd00302Fcid(rs.getString(cd00302Fcid));
				e.setCdSlid(rs.getString(cdSlid));
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
