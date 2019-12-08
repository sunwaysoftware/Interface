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

import com.sunway.dao.IPgt12003fDAO;
import com.sunway.vo.Pgt12003f;
import com.sunway.vo.Pgv12003f;

/**
 * 
 * 房产相关照片
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt12003fDAO extends BaseDAO implements IPgt12003fDAO {

	// property constants
	private String zpid = "ZPID";					//图片ID
	private String cd12003Fcid = "CD_12003_FCID";	//房产编码
	private String zplx = "ZPLX";					//照片类型
	private String zplj = "ZPLJ";					//照片路径
	private String upddate = "UPDDATE";				//更新时间
	private String cd00002Czr = "CD_00002_CZR";		//录入人
	private String note = "NOTE";					//备注信息
	private String zplxmc = "ZPLXMC";
	private String czr = "CZR";	
	private String zpljMin = "ZPLJ_MIN";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12003fDAO#GetDeleteCommand(com.sunway.vo.Pgt12003f)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt12003f t12003f) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12003F(?)}");
			call.setBigDecimal(1, t12003f.getZpid());
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
	 * @see com.sunway.dao.IPgt12003fDAO#GetInsertCommand(com.sunway.vo.Pgt12003f)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt12003f t12003f) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT12003F(?,?,?,?,?,?)}");
			call.setString(1, t12003f.getCd12003Fcid());
			call.setInt(2, t12003f.getZplx());
			call.setString(3, t12003f.getZplj());
			call.setString(4, t12003f.getCd00002Czr());
			call.setString(5, t12003f.getNote());
			call.setString(6, t12003f.getZpljMin());
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
	 * @see com.sunway.dao.IPgt12003fDAO#GetUpdateCommand(com.sunway.vo.Pgt12003f)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt12003f t12003f) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT12003F(?,?,?,?,?,?)}");
			call.setBigDecimal(1, t12003f.getZpid());
			call.setString(2, t12003f.getCd12003Fcid());
			call.setInt(3, t12003f.getZplx());
			call.setString(4, t12003f.getZplj());
			call.setString(5, t12003f.getCd00002Czr());
			call.setString(6, t12003f.getNote());
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
	 * @see com.sunway.dao.IPgt12003fDAO#LoadAll(com.sunway.vo.Pgt12003f)
	 */
	
	@Override
	public ArrayList<Pgv12003f> LoadAll(Pgt12003f t12003f) throws Exception {
		ArrayList<Pgv12003f> listResult = new ArrayList<Pgv12003f>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12003F(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, t12003f.getCd12003Fcid());
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
	 * @see com.sunway.dao.IPgt12003fDAO#LoadByPrimaryKey(com.sunway.vo.Pgt12003f)
	 */
	
	@Override
	public Pgt12003f LoadByPrimaryKey(Pgt12003f t12003f) throws Exception {
		ArrayList<Pgt12003f> listResult = new ArrayList<Pgt12003f>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT12003F(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setBigDecimal(2, t12003f.getZpid());
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

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12003fDAO#LoadZplxList()
	 */
	
	@Override
	public ArrayList<Pgv12003f> LoadZplxList() throws Exception {
		ArrayList<Pgv12003f> listResult = new ArrayList<Pgv12003f>();
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

	/**
	 * Table數據轉存
	 * @param rs 數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgt12003f SetTParameters(ResultSet rs) throws Exception {
		Pgt12003f e = new Pgt12003f();
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setCd12003Fcid(rs.getString(cd12003Fcid));
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
	protected Pgv12003f SetVParameters(ResultSet rs, Boolean bZp) throws Exception {
		Pgv12003f e = new Pgv12003f();

		if(bZp){
			e.setZplx(rs.getInt(zplx));
			e.setZplxmc(rs.getString(zplxmc));
		} else {
			e.setCd00002Czr(rs.getString(cd00002Czr));
			e.setCd12003Fcid(rs.getString(cd12003Fcid));
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
	
}
