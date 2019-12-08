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

import com.sunway.dao.IPgt10033DAO;
import com.sunway.vo.Pgt10033;

/**
 * 
 * 成本法个案评税其它修正参数表
 * @author Andy.Gao
 *
 */
public class Pgt10033DAO extends BaseDAO implements IPgt10033DAO {

	private static final String qtxzid = "QTXZID";				//对象编号
	private static final String cd12004Mxid = "CD_12004_MXID";	//房产明细编码
	private static final String cd00002Pssd = "CD_00002_PSSD";	//评税时点
	private static final String qtxznm = "QTXZNM";				//对象名称
	private static final String xzlx = "XZLX";					//修正类型（0：成本法土地其它修正，1：成本法房子其它修正。。）
	private static final String xzxs = "XZXS";					//修正值 必须要大于0
	private static final String upddate = "UPDDATE";			//更改时间
	private static final String cd00002Czr = "CD_00002_CZR";	//操作人字段
	private static final String note = "NOTE";					//备注信息
	private static final String xzmc = "XZMC";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10033DAO#GetDeleteCommand(com.sunway.vo.Pgt10033)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt10033 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT10033(?,?,?,?,?)}");
			call.setString(1, bean.getCd00002Pssd());
			call.setString(2, bean.getCd12004Mxid());
			call.setString(3, bean.getQtxzid());
			call.setString(4, bean.getCd00002Czr());
			call.setString(5, bean.getSysSsgx());
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
	 * @see com.sunway.dao.IPgt10033DAO#GetInsertCommand(com.sunway.vo.Pgt10033)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt10033 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT10033(?,?,?,?,?,?,?,?)}");
			call.setString(1, bean.getCd12004Mxid());
			call.setString(2, bean.getCd00002Pssd());
			call.setString(3, bean.getQtxznm());
			call.setInt(4, bean.getXzlx());
			call.setDouble(5, bean.getXzxs());
			call.setString(6, bean.getCd00002Czr());
			call.setString(7, bean.getNote());
			call.setString(8, bean.getSysSsgx());
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
	 * @see com.sunway.dao.IPgt10033DAO#GetUpdateCommand(com.sunway.vo.Pgt10033)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt10033 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT10033(?,?,?,?,?,?,?,?)}");
			call.setString(1, bean.getQtxzid());
			call.setString(2, bean.getCd12004Mxid());
			call.setString(3, bean.getCd00002Pssd());
			call.setString(4, bean.getQtxznm());
			call.setInt(5, bean.getXzlx());
			call.setDouble(6, bean.getXzxs());
			call.setString(7, bean.getCd00002Czr());
			call.setString(8, bean.getNote());
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
	 * @see com.sunway.dao.IPgt10033DAO#LoadAll(com.sunway.vo.Pgt10033)
	 */
	
	@Override
	public ArrayList<Pgt10033> LoadAll(Pgt10033 bean) throws Exception {
		ArrayList<Pgt10033> listResult = new ArrayList<Pgt10033>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT10033(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd12004Mxid());
			call.setString(3, bean.getCd00002Pssd());
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
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10033DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10033)
	 */
	
	@Override
	public Pgt10033 LoadByPrimaryKey(Pgt10033 bean) throws Exception {
		ArrayList<Pgt10033> listResult = new ArrayList<Pgt10033>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT10033(?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd00002Pssd());
			call.setString(3, bean.getCd12004Mxid());
			call.setString(4, bean.getQtxzid());
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
	protected Pgt10033 SetTParameters(ResultSet rs) throws Exception {
		return new Pgt10033(rs.getString(qtxzid),
							rs.getString(cd12004Mxid),
							rs.getString(cd00002Pssd),
							rs.getString(qtxznm),
							rs.getInt(xzlx),
							rs.getDouble(xzxs),
							rs.getTimestamp(upddate),
							rs.getString(cd00002Czr),
							rs.getString(note),
							rs.getString(xzmc));
	}	
	
}
