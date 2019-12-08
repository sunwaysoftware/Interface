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

import com.sunway.dao.IPgt12002fDAO;
import com.sunway.vo.Pgt12002f;
import com.sunway.vo.Pgv12002f;

/**
 * 
 * 土地相关照片
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt12002fDAO extends BaseDAO implements IPgt12002fDAO {

	// property constants
	private String zpid = "ZPID";					//图片ID
	private String cd12002Dcid = "CD_12002_DCID";	//地产编码
	private String zplx = "ZPLX";					//照片类型
	private String zplj = "ZPLJ";					//照片路径
	private String upddate = "UPDDATE";				//更新时间
	private String cd00002Czr = "CD_00002_CZR";		//录入人
	private String note = "NOTE";					//备注信息
	private String zplxmc = "ZPLXMC";
	private String czr = "CZR";
	private String zpljMin = "ZPLJ_MIN";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12002fDAO#GetDeleteCommand(com.sunway.vo.Pgt12002f)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt12002f t12002f) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12002F(?)}");
			call.setBigDecimal(1, t12002f.getZpid());
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
	 * @see com.sunway.dao.IPgt12002fDAO#GetInsertCommand(com.sunway.vo.Pgt12002f)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt12002f t12002f) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT12002F(?,?,?,?,?,?)}");
			call.setString(1, t12002f.getCd12002Dcid());
			call.setInt(2, t12002f.getZplx());
			call.setString(3, t12002f.getZplj());
			call.setString(4, t12002f.getCd00002Czr());
			call.setString(5, t12002f.getNote());
			call.setString(6, t12002f.getZpljMin());
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
	 * @see com.sunway.dao.IPgt12002fDAO#GetUpdateCommand(com.sunway.vo.Pgt12002f)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt12002f t12002f) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT12002F(?,?,?,?,?,?)}");
			call.setBigDecimal(1, t12002f.getZpid());
			call.setString(2, t12002f.getCd12002Dcid());
			call.setInt(3, t12002f.getZplx());
			call.setString(4, t12002f.getZplj());
			call.setString(5, t12002f.getCd00002Czr());
			call.setString(6, t12002f.getNote());
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
	 * @see com.sunway.dao.IPgt12002fDAO#LoadAll(com.sunway.vo.Pgt12002f)
	 */
	
	@Override
	public ArrayList<Pgv12002f> LoadAll(Pgt12002f t12002f) throws Exception {
		ArrayList<Pgv12002f> listResult = new ArrayList<Pgv12002f>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12002F(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, t12002f.getCd12002Dcid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVParameters(rs, false));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12002fDAO#LoadByPrimaryKey(com.sunway.vo.Pgt12002f)
	 */
	
	@Override
	public Pgt12002f LoadByPrimaryKey(Pgt12002f t12002f) throws Exception {
		ArrayList<Pgt12002f> listResult = new ArrayList<Pgt12002f>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT12002F(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setBigDecimal(2, t12002f.getZpid());
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
	protected Pgt12002f SetTParameters(ResultSet rs) throws Exception {
		Pgt12002f e = new Pgt12002f();
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setCd12002Dcid(rs.getString(cd12002Dcid));
		e.setNote(rs.getString(note));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setZpid(rs.getBigDecimal(zpid));
		e.setZplj(rs.getString(zplj));
		e.setZplx(rs.getInt(zplx));
		e.setZpljMin(rs.getString(zpljMin));
		return e;
	}
	
	/**
	 * Table數據轉存
	 * @param rs 數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgv12002f SetVParameters(ResultSet rs, Boolean bZp) throws Exception {
		Pgv12002f e = new Pgv12002f();
		if(bZp){
			e.setZplx(rs.getInt(zplx));
			e.setZplxmc(rs.getString(zplxmc));
		} else {
			e.setCd00002Czr(rs.getString(cd00002Czr));
			e.setCd12002Dcid(rs.getString(cd12002Dcid));
			e.setNote(rs.getString(note));
			e.setUpddate(rs.getTimestamp(upddate));
			e.setZpid(rs.getBigDecimal(zpid));
			e.setZplj(rs.getString(zplj));
			e.setCzr(rs.getString(czr));
			e.setZplx(rs.getInt(zplx));
			e.setZplxmc(rs.getString(zplxmc));
			e.setZpljMin(rs.getString(zpljMin));
		}
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12002fDAO#LoadZplxList()
	 */
	
	@Override
	public ArrayList<Pgv12002f> LoadZplxList() throws Exception {
		ArrayList<Pgv12002f> listResult = new ArrayList<Pgv12002f>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call pgsp_getallcz00004(?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVParameters(rs, true));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
}
