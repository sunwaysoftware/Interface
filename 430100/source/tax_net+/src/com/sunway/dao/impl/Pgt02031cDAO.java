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

import com.sunway.dao.IPgt02031cDAO;
import com.sunway.vo.Pgt02031c;

/**
 * @author Andy.Gao
 *
 */
public class Pgt02031cDAO extends BaseDAO implements IPgt02031cDAO {

	private static final String cd02002Fcid =  "CD_02002_FCID";
	private static final String cd00001Rootid = "CD_00001_ROOTID";
	private static final String rootnm = "ROOTNM";
	private static final String infonm =  "INFONM";
	private static final String xzxs =  "XZXS";
	//private static final String czlx =  "CZLX";

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02031cDAO#LoadAll(com.sunway.vo.Pgt02031c)
	 */
	
	@Override
	public ArrayList<Pgt02031c> LoadAll(Pgt02031c bean) throws Exception {
		ArrayList<Pgt02031c> listResult = new ArrayList<Pgt02031c>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02031C(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd02002Fcid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				Pgt02031c e = new Pgt02031c();
				e.setCd02002Fcid(rs.getString(cd02002Fcid));
				e.setCd00001Rootid(rs.getString(cd00001Rootid));
				e.setRootnm(rs.getString(rootnm));
				e.setInfonm(rs.getString(infonm));
				e.setXzxs(rs.getDouble(xzxs));
				//e.setCzlx(rs.getInt(czlx));
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
	
	
	
	public ArrayList<Pgt02031c> LoadAll_B(Pgt02031c bean) throws Exception {
		ArrayList<Pgt02031c> listResult = new ArrayList<Pgt02031c>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02031C_B(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd02002Fcid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				Pgt02031c e = new Pgt02031c();
				e.setCd02002Fcid(rs.getString(cd02002Fcid));
				e.setCd00001Rootid(rs.getString(cd00001Rootid));
				e.setRootnm(rs.getString(rootnm));
				e.setInfonm(rs.getString(infonm));
				e.setXzxs(rs.getDouble(xzxs));
				//e.setCzlx(rs.getInt(czlx));
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
