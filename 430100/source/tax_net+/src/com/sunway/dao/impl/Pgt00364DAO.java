package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00364DAO;
import com.sunway.vo.Pgt00364;

public class Pgt00364DAO extends BaseDAO implements IPgt00364DAO {
	private static final String cd00001Szqy = "CD_00001_SZQY";		//所在区域
	private static final String szqy = "SZQY";
	private static final String xzxs = "XZXS" ;						//建筑面积修正
	private static final String pgxzxs = "PGXZXS" ;						//建筑面积修正
	private static final String upddate = "UPDDATE";				//更改时间
	private static final String cd00002Czr = "CD_00002_CZR";		//操作人字段
	private static final String note = "NOTE";						//备注信息
	private static final String czr = "CZR";
	private static final String total = "TOTAL";					//总纪录数


	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00364DAO#GetDeleteCommand(com.sunway.vo.Pgt00364)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00364 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;	
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00364(?)}");
			//傳入輸入參數
			call.setString(1, bean.getCd00352Xqdm());
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
	 * @see com.sunway.dao.IPgt00364DAO#GetDeleteCommand(com.sunway.vo.Pgt00364)
	 */
	
	@Override
	public boolean GetDeleteCommandA(Pgt00364 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;	
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00364A(?,?)}");
			//傳入輸入參數
			call.setString(1, bean.getCd00352Xqdm());
			call.setString(2, bean.getCd00001Szqy());
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
	 * @see com.sunway.dao.IPgt00364DAO#GetInsertCommand(com.sunway.vo.Pgt00364)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt00364 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00364(?,?,?,?,?)}");
			//傳入輸入參數
			call.setString(1, bean.getCd00001Szqy());
			call.setBigDecimal(2, bean.getXzxs());
			call.setString(3, bean.getCd00002Czr());
			call.setString(4, bean.getNote());
			call.setBigDecimal(5, bean.getPgxzxs());
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
	 * @see com.sunway.dao.IPgt00364DAO#GetInsertCommand(com.sunway.vo.Pgt00364)
	 */
	
	@Override
	public boolean GetInsertCommandA(Pgt00364 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00364A(?,?,?,?,?,?)}");
			//傳入輸入參數
			call.setString(1, bean.getCd00352Xqdm());
			call.setBigDecimal(2, bean.getXzxs());
			call.setString(3, bean.getCd00002Czr());
			call.setString(4, bean.getNote());
			call.setBigDecimal(5, bean.getPgxzxs());
			call.setString(6, bean.getCd00001Szqy());
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
	 * @see com.sunway.dao.IPgt00364DAO#GetUpdateCommand(com.sunway.vo.Pgt00364)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt00364 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00364(?,?,?,?,?)}");
			//傳入輸入參數
			call.setString(1, bean.getCd00001Szqy());
			call.setBigDecimal(2, bean.getXzxs());
			call.setString(3, bean.getCd00002Czr());
			call.setString(4, bean.getNote());
			call.setBigDecimal(5, bean.getPgxzxs());
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
	 * @see com.sunway.dao.IPgt00364DAO#GetUpdateCommand(com.sunway.vo.Pgt00364)
	 */
	
	@Override
	public boolean GetUpdateCommandA(Pgt00364 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00364A(?,?,?,?,?,?)}");
			//傳入輸入參數
			call.setString(1, bean.getCd00352Xqdm());
			call.setBigDecimal(2, bean.getXzxs());
			call.setString(3, bean.getCd00002Czr());
			call.setString(4, bean.getNote());
			call.setBigDecimal(5, bean.getPgxzxs());
			call.setString(6, bean.getCd00001Szqy());
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
	 * @see com.sunway.dao.IPgt00364DAO#LoadAll(com.sunway.vo.Pgt00364)
	 */
	
	@Override
	public ArrayList<Pgt00364> LoadAll(Pgt00364 bean) throws Exception {
		ArrayList<Pgt00364> listResult = new ArrayList<Pgt00364>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00364(?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getCd00001Szqy());
			call.setString(5, bean.getCd00001Ssgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetParameters(rs, true));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00364DAO#LoadAll(com.sunway.vo.Pgt00364)
	 */
	
	@Override
	public ArrayList<Pgt00364> LoadAllA(Pgt00364 bean) throws Exception {
		ArrayList<Pgt00364> listResult = new ArrayList<Pgt00364>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00364A(?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getCd00001Szqy());
			call.setString(5, bean.getCd00001Ssgx());
			call.setString(6, bean.getCd00352Xqdm());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetParametersA(rs, true));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00364DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00364)
	 */
	
	@Override
	public Pgt00364 LoadByPrimaryKey(Pgt00364 bean) throws Exception {
		Pgt00364 listResult = new Pgt00364();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00364(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd00001Szqy());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult = SetParameters(rs, false);
				break;
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00364DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00364)
	 */
	
	@Override
	public Pgt00364 LoadByPrimaryKeyA(Pgt00364 bean) throws Exception {
		Pgt00364 listResult = new Pgt00364();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00364A(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd00352Xqdm());
			call.setString(3, bean.getCd00001Szqy());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult = SetParametersA(rs, false);
				break;
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
	
	
	
	
	
	/**
	 * Table 数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00364 SetParameters(ResultSet rs, Boolean flag) throws Exception {
		Pgt00364 e = new Pgt00364();
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setXzxs(rs.getBigDecimal(xzxs));
		e.setPgxzxs(rs.getBigDecimal(pgxzxs));
		if(flag){
			e.setRecordCount(rs.getInt(total));
			e.setCzr(rs.getString(czr));
			e.setSzqy(rs.getString(szqy));
		}
		return e;
	}
	
	
	/**
	 * Table 数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00364 SetParametersA(ResultSet rs, Boolean flag) throws Exception {
		Pgt00364 e = new Pgt00364();
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setXzxs(rs.getBigDecimal(xzxs));
		e.setPgxzxs(rs.getBigDecimal(pgxzxs));
		e.setCd00352Xqdm(rs.getString("CD_00352_XQDM"));
		e.setXqnm(rs.getString("XQNM"));
		if(flag){
			e.setRecordCount(rs.getInt(total));
			e.setCzr(rs.getString(czr));
			e.setSzqy(rs.getString(szqy));
		}
		return e;
	}

}
