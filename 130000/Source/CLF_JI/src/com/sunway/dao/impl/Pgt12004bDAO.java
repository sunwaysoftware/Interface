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
import org.hibernate.Transaction;

import com.sunway.dao.IPgt12004bDAO;
import com.sunway.util.Common;
import com.sunway.vo.Pgt12004b;
import com.sunway.vo.Pgv12004b;

/**
 * 
 * 房产明细当前承租人表
 * @author Andy.Gao
 *
 */
public class Pgt12004bDAO extends BaseDAO implements IPgt12004bDAO {

	// property constants
	private String cd12004Mxid = "CD_12004_MXID";		//明細编码
	private String cd12006Czrzjh = "CD_12006_CZRZJH";	//出租人证件号码
	private String sfnsr = "SFNSR";						//是否是纳税人：0为不是纳税人，1为是纳税人
	private String czkssj = "CZKSSJ";					//出租开始日期
	private String czjssj = "CZJSSJ";					//出租结束日期
	private String upddate = "UPDDATE";					//更新时间
	private String cd00002Czr = "CD_00002_CZR";			//录入人
	private String note = "NOTE";						//备注信息
	private String czrmc = "CZRMC";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12004bDAO#GetDeleteCommand(com.sunway.vo.Pgt12004b)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt12004b t12004b) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12004B(?)}");
			call.setString(1, t12004b.getCd12004Mxid());
			call.execute();
			tran.commit();
			bResult = true;
		} catch (Exception e) {
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12004bDAO#GetInsertCommand(com.sunway.vo.Pgt12004b)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt12004b t12004b) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT12004B(?,?,?,?,?,?,?,?,?)}");
			call.setString(1, t12004b.getCd12004Mxid());
			call.setString(2, t12004b.getCd12006Czrzjh());
			call.setString(3, t12004b.getCzrmc());
			call.setBoolean(4, t12004b.getSfnsr());
			call.setDate(5, Common.converDate(t12004b.getCzkssj()));
			call.setDate(6, Common.converDate(t12004b.getCzjssj()));
			call.setString(7, t12004b.getCd00002Czr());
			call.setString(8, t12004b.getNote());
			call.setString(9, t12004b.getSysSsgx());
			call.execute();
			tran.commit();
			bResult = true;
		} catch (Exception e) {
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12004bDAO#GetUpdateCommand(com.sunway.vo.Pgt12004b)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt12004b t12004b) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT12004B(?,?,?,?,?,?,?,?,?)}");
			call.setString(1, t12004b.getCd12004Mxid());
			call.setString(2, t12004b.getCd12006Czrzjh());
			call.setString(3, t12004b.getCzrmc());
			call.setBoolean(4, t12004b.getSfnsr());
			call.setDate(5, Common.converDate(t12004b.getCzkssj()));
			call.setDate(6, Common.converDate(t12004b.getCzjssj()));
			call.setString(7, t12004b.getCd00002Czr());
			call.setString(8, t12004b.getNote());
			call.setString(9, t12004b.getSysSsgx());
			call.execute();
			tran.commit();
			bResult = true;
		} catch (Exception e) {
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12004bDAO#LoadAll(com.sunway.vo.Pgv12004b)
	 */
	
	@Override
	public Pgv12004b LoadAll(Pgv12004b v12004b) throws Exception {
		ArrayList<Pgv12004b> listResult = new ArrayList<Pgv12004b>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12004B(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, v12004b.getCd12004Mxid());
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
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return null;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12004bDAO#LoadByPrimaryKey(com.sunway.vo.Pgt12004b)
	 */
	
	@Override
	public Pgt12004b LoadByPrimaryKey(Pgt12004b t12004b) throws Exception {
		ArrayList<Pgt12004b> listResult = new ArrayList<Pgt12004b>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT12004B(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, t12004b.getCd12004Mxid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return null;
	}

	/**
	 * Table數據轉存
	 * @param rs 數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgt12004b SetTParameters(ResultSet rs) throws Exception {
		Pgt12004b e = new Pgt12004b();
		e.setCd12004Mxid(rs.getString(cd12004Mxid));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setCd12006Czrzjh(rs.getString(cd12006Czrzjh));
		e.setCzjssj(rs.getDate(czjssj));
		e.setCzkssj(rs.getDate(czkssj));
		e.setSfnsr(rs.getBoolean(sfnsr));
		e.setNote(rs.getString(note));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCzrmc(rs.getString(czrmc));
		return e;
	}
	
	/**
	 * View數據轉存
	 * @param rs 數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgv12004b SetVParameters(ResultSet rs) throws Exception {
		Pgv12004b e = new Pgv12004b();
		e.setCd12004Mxid(rs.getString(cd12004Mxid));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setCd12006Czrzjh(rs.getString(cd12006Czrzjh));
		e.setCzjssj(rs.getDate(czjssj));
		e.setCzkssj(rs.getDate(czkssj));
		e.setSfnsr(rs.getBoolean(sfnsr));
		e.setNote(rs.getString(note));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCzrmc(rs.getString(czrmc));
		return e;
	}
	
}
