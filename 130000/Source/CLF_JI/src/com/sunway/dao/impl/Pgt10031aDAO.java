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

import com.sunway.dao.IPgt10031aDAO;
import com.sunway.vo.Pgt10031a;
import com.sunway.vo.Pgv10031a1;

/**
 * 
 * 成本法评税其它修正参数表
 * @author Andy.Gao
 *
 */
public class Pgt10031aDAO extends BaseDAO implements IPgt10031aDAO {

	private static final String qtxzid = "QTXZID";				//对象编号
	private static final String cd12004Mxid = "CD_12004_MXID";	//房产明细编码
	private static final String cd00002Pssd = "CD_00002_PSSD";	//评税时点
	private static final String xzxs = "XZXS";					//修正值 必须要大于0
	private static final String upddate = "UPDDATE";			//更改时间
	private static final String cd00002Czr = "CD_00002_CZR";	//操作人字段
	private static final String note = "NOTE";					//备注信息
	private static final String xzmc = "XZMC";
	private static final String xzlx = "XZLX";
	private static final String czr = "CZR";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10031aDAO#GetDeleteCommand(com.sunway.vo.Pgt10031a)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt10031a bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT10031A(?,?,?)}");
			call.setString(1, bean.getcd00002Pssd());
			call.setString(2, bean.getCd12004Mxid());
			call.setString(3, bean.getQtxzid());
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
	 * @see com.sunway.dao.IPgt10031aDAO#GetInsertCommand(com.sunway.vo.Pgt10031a)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt10031a bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT10031A(?,?,?,?,?,?)}");
			call.setString(1, bean.getQtxzid());
			call.setString(2, bean.getCd12004Mxid());
			call.setString(3, bean.getcd00002Pssd());
			call.setDouble(4, bean.getXzxs());
			call.setString(5, bean.getCd00002Czr());
			call.setString(6, bean.getNote());
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
	 * @see com.sunway.dao.IPgt10031aDAO#GetUpdateCommand(com.sunway.vo.Pgt10031a)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt10031a bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT10031A(?,?,?,?,?,?)}");
			call.setString(1, bean.getQtxzid());
			call.setString(2, bean.getCd12004Mxid());
			call.setString(3, bean.getcd00002Pssd());
			call.setDouble(4, bean.getXzxs());
			call.setString(5, bean.getCd00002Czr());
			call.setString(6, bean.getNote());
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
	 * @see com.sunway.dao.IPgt10031aDAO#LoadAll(com.sunway.vo.Pgt10031a)
	 */
	
	@Override
	public ArrayList<Pgt10031a> LoadAll(Pgt10031a bean) throws Exception {
		ArrayList<Pgt10031a> listResult = new ArrayList<Pgt10031a>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT10031A(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd12004Mxid());
			call.setString(3, bean.getcd00002Pssd());
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
	 * @see com.sunway.dao.IPgt10031aDAO#LoadByPrimaryKey(com.sunway.vo.Pgt10031a)
	 */
	
	@Override
	public Pgt10031a LoadByPrimaryKey(Pgt10031a bean) throws Exception {
		ArrayList<Pgt10031a> listResult = new ArrayList<Pgt10031a>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT10031A(?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getcd00002Pssd());
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
	protected Pgt10031a SetTParameters(ResultSet rs) throws Exception {
		return new Pgt10031a(rs.getString(cd00002Czr),
							 rs.getString(cd00002Pssd),
							 rs.getString(cd12004Mxid),
							 rs.getString(note),
							 rs.getString(qtxzid),
							 rs.getTimestamp(upddate),
							 rs.getDouble(xzxs));
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10031aDAO#LoadQtxzDC(com.sunway.vo.Pgv10031a1)
	 */
	
	@Override
	public ArrayList<Pgv10031a1> LoadQtxzDC(Pgv10031a1 bean) throws Exception {
		ArrayList<Pgv10031a1> listResult = new ArrayList<Pgv10031a1>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT10031A1(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd12004Mxid());
			call.setString(3, bean.getCd00002Pssd());
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

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10031aDAO#LoadQtxzFC(com.sunway.vo.Pgv10031a1)
	 */
	
	@Override
	public ArrayList<Pgv10031a1> LoadQtxzFC(Pgv10031a1 bean) throws Exception {
		ArrayList<Pgv10031a1> listResult = new ArrayList<Pgv10031a1>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT10031A2(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd12004Mxid());
			call.setString(3, bean.getCd00002Pssd());
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
	protected Pgv10031a1 SetVParameters(ResultSet rs) throws Exception {
		return new Pgv10031a1(rs.getString(qtxzid),
							  rs.getString(cd12004Mxid),
							  rs.getString(cd00002Pssd),
							  rs.getDouble(xzxs),
							  rs.getTimestamp(upddate),
							  rs.getString(cd00002Czr),
							  rs.getString(note),
							  rs.getString(xzmc),
							  rs.getInt(xzlx),
							  rs.getString(czr));
	}
}
