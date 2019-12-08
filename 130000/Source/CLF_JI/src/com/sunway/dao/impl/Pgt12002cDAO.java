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

import com.sunway.dao.IPgt12002cDAO;
import com.sunway.vo.Pgv12002c;

/**
 * @author Andy.Gao
 *
 */
public class Pgt12002cDAO extends BaseDAO implements IPgt12002cDAO {

	// property constants
	private static final String id = "ID";
	private static final String cd12002Dcid = "CD_12002_DCID";
	private static final String cd12006Czrzjh = "CD_12006_CZRZJH";
	private static final String sfnsr = "SFNSR";
	private static final String czkssj = "CZKSSJ";
	private static final String czjssj = "CZJSSJ";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String czr = "CZR";
	private static final String czrmc = "CZRMC";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12002cDAO#LoadAll(com.sunway.vo.Pgv12002c)
	 */
	
	@Override
	public ArrayList<Pgv12002c> LoadAll(Pgv12002c v12002c) throws Exception {
		ArrayList<Pgv12002c> listResult = new ArrayList<Pgv12002c>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12002C(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, v12002c.getCd12002Dcid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
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
	 * View數據轉存
	 * @param rs 數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgv12002c SetVParameters(ResultSet rs) throws Exception {
		Pgv12002c e = new Pgv12002c();
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setCd12002Dcid(rs.getString(cd12002Dcid));
		e.setCd12006Czrzjh(rs.getString(cd12006Czrzjh));
		e.setCzrmc(rs.getString(czrmc));
		e.setCzjssj(rs.getDate(czjssj));
		e.setCzkssj(rs.getDate(czkssj));
		e.setCzr(rs.getString(czr));
		e.setId(rs.getString(id));
		e.setNote(rs.getString(note));
		e.setSfnsr(rs.getBoolean(sfnsr));
		e.setUpddate(rs.getTimestamp(upddate));
		return e;
	}
	
}
