/**
 * 
 */
package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.ITj00001DAO;
import com.sunway.util.Common;
import com.sunway.vo.BFV00006;

/**
 * @author Amani
 *
 */
public class Tj00001DAO extends BaseDAO implements ITj00001DAO {

	@Override
	public ArrayList<BFV00006> LoadAll(BFV00006 bean) throws Exception {
		ArrayList<BFV00006> listResult = new ArrayList<BFV00006>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_00006(?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setDate(2, Common.converDate(bean.getRdsjBgn()));
			call.setDate(3, Common.converDate(bean.getRdsjEnd()));
			call.setString(4, bean.getCd00001Ssgx());
			call.setString(5, bean.getCd00002Czr());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;		
	}
	
	@Override
	public ArrayList<BFV00006> ExportData(BFV00006 bean) throws Exception {
		ArrayList<BFV00006> listResult = new ArrayList<BFV00006>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003406(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd00001Ssgx());
			call.setString(3, bean.getCd00002Czr());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;	
	}
	
	private BFV00006 SetParameters(ResultSet rs) throws SQLException {
		BFV00006 e = new BFV00006();
		e.setCd00001Ssgx(rs.getString("CD_00001_SSGX"));
		e.setHs(rs.getDouble("hs"));
		e.setSbjg(rs.getDouble("sbjg"));
		e.setPgjg(rs.getDouble("pgjg"));
		e.setHdjg(rs.getDouble("hdjg"));
		e.setPgsbZje(rs.getDouble("Pgsb_Zje"));
		e.setPgsbZf(rs.getDouble("Pgsb_Zf"));
		e.setSkGrsds(rs.getDouble("Sk_Grsds"));
		e.setSkQs(rs.getDouble("Sk_Qs"));
		e.setSkSum(rs.getDouble("sk_Sum"));
		e.setSkYhs(rs.getDouble("sk_Yhs"));
		e.setSkYys(rs.getDouble("sk_Yys"));
		e.setTsskje(rs.getDouble("tsskje"));
		e.setGapgCnt(rs.getDouble("gapg_Cnt"));
		e.setSfl(rs.getDouble("sfl"));
		e.setCd00002Czr(rs.getString("CD_00002_CZR"));
		e.setCd00001Ssgx1(rs.getString("CD_00001_SSGX1"));
		e.setSsgx(rs.getString("SSGX"));
		return e;
	}
}
