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

import com.sunway.dao.IPgt12003bDAO;
import com.sunway.util.Common;
import com.sunway.vo.Pgt12003b;
import com.sunway.vo.Pgv12003b;

/**
 * 
 * 房产当前承租人表
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt12003bDAO extends BaseDAO implements IPgt12003bDAO {

	// property constants
	private String cd12003Fcid = "CD_12003_FCID";		//房地产编码
	private String cd12006Czrzjh = "CD_12006_CZRZJH";	//出租人证件号码
	private String sfnsr = "SFNSR";						//是否是纳税人：0为不是纳税人，1为是纳税人
	private String czkssj = "CZKSSJ";					//出租开始日期
	private String czjssj = "CZJSSJ";					//出租结束日期
	private String upddate = "UPDDATE";					//更新时间
	private String cd00002Czr = "CD_00002_CZR";			//录入人
	private String note = "NOTE";						//备注信息
	private String czrmc = "CZRMC";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12003bDAO#GetDeleteCommand(com.sunway.vo.Pgt12003b)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt12003b t12003b) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12003B(?)}");
			call.setString(1, t12003b.getCd12003Fcid());
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
	 * @see com.sunway.dao.IPgt12003bDAO#GetInsertCommand(com.sunway.vo.Pgt12003b)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt12003b t12003b) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT12002B(?,?,?,?,?,?,?,?,?)}");
			call.setString(1, t12003b.getCd12003Fcid());
			call.setString(2, t12003b.getCd12006Czrzjh());
			call.setString(3, t12003b.getCzrmc());
			call.setBoolean(4, t12003b.getSfnsr());
			call.setDate(5, Common.converDate(t12003b.getCzkssj()));
			call.setDate(6, Common.converDate(t12003b.getCzjssj()));
			call.setString(7, t12003b.getCd00002Czr());
			call.setString(8, t12003b.getNote());
			call.setString(9, t12003b.getSysSsgx());
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
	 * @see com.sunway.dao.IPgt12003bDAO#GetUpdateCommand(com.sunway.vo.Pgt12003b)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt12003b t12003b) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT12003B(?,?,?,?,?,?,?,?,?)}");
			call.setString(1, t12003b.getCd12003Fcid());
			call.setString(2, t12003b.getCd12006Czrzjh());
			call.setString(3, t12003b.getCzrmc());
			call.setBoolean(4, t12003b.getSfnsr());
			call.setDate(5, Common.converDate(t12003b.getCzkssj()));
			call.setDate(6, Common.converDate(t12003b.getCzjssj()));
			call.setString(7, t12003b.getCd00002Czr());
			call.setString(8, t12003b.getNote());
			call.setString(9, t12003b.getSysSsgx());
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
	 * @see com.sunway.dao.IPgt12003bDAO#LoadAll(com.sunway.vo.Pgv12003b)
	 */
	
	@Override
	public Pgv12003b LoadAll(Pgv12003b v12003b) throws Exception {
		ArrayList<Pgv12003b> listResult = new ArrayList<Pgv12003b>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12003B(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, v12003b.getCd12003Fcid());
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
	 * @see com.sunway.dao.IPgt12003bDAO#LoadByPrimaryKey(com.sunway.vo.Pgt12003b)
	 */
	
	@Override
	public Pgt12003b LoadByPrimaryKey(Pgt12003b t12003b) throws Exception {
		ArrayList<Pgt12003b> listResult = new ArrayList<Pgt12003b>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT12003B(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, t12003b.getCd12003Fcid());
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
	protected Pgt12003b SetTParameters(ResultSet rs) throws Exception {
		Pgt12003b e = new Pgt12003b();
		e.setCd12003Fcid(rs.getString(cd12003Fcid));
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
	protected Pgv12003b SetVParameters(ResultSet rs) throws Exception {
		Pgv12003b e = new Pgv12003b();
		e.setCd12003Fcid(rs.getString(cd12003Fcid));
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
