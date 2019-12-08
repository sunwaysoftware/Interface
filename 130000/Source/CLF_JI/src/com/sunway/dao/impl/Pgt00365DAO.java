package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00365DAO;
import com.sunway.vo.Pgt00365;

public class Pgt00365DAO extends BaseDAO implements IPgt00365DAO {
	private static final String cd00001Szqy = "CD_00001_SZQY";		//所在区域
	private static final String szqy = "SZQY";
	private static final String xzxs = "XZXS" ;						//建筑面积修正				//建筑面积修正
	private static final String upddate = "UPDDATE";				//更改时间
	private static final String cd00002Czr = "CD_00002_CZR";		//操作人字段
	private static final String note = "NOTE";						//备注信息
	private static final String czr = "CZR";
	private static final String rid = "RID";						//行号
	private static final String total = "TOTAL";					//总纪录数
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00364DAO#GetDeleteCommand(com.sunway.vo.Pgt00364)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00365 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;	
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00365(?)}");
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
	 * @see com.sunway.dao.IPgt00364DAO#GetInsertCommand(com.sunway.vo.Pgt00364)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt00365 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00365(?,?,?,?)}");
			//傳入輸入參數
			call.setString(1, bean.getCd00352Xqdm());
			call.setInt(2, bean.getXzxs());
			call.setString(3, bean.getCd00002Czr());
			call.setString(4, bean.getNote());
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
	public boolean GetUpdateCommand(Pgt00365 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00365(?,?,?,?)}");
			//傳入輸入參數
			call.setString(1, bean.getCd00352Xqdm());
			call.setInt(2, bean.getXzxs());
			call.setString(3, bean.getCd00002Czr());
			call.setString(4, bean.getNote());
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
	public ArrayList<Pgt00365> LoadAll(Pgt00365 bean) throws Exception {
		ArrayList<Pgt00365> listResult = new ArrayList<Pgt00365>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00365(?,?,?,?,?,?)}");
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
	 * @see com.sunway.dao.IPgt00364DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00364)
	 */
	
	@Override
	public Pgt00365 LoadByPrimaryKey(Pgt00365 bean) throws Exception {
		Pgt00365 listResult = new Pgt00365();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00365(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd00352Xqdm());
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
	
	
	
	
	
	

	
	
	/**
	 * Table 数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00365 SetParameters(ResultSet rs, Boolean flag) throws Exception {
		Pgt00365 e = new Pgt00365();
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setXzxs(rs.getInt(xzxs));
		e.setCd00352Xqdm(rs.getString("CD_00352_XQDM"));
		e.setXqnm(rs.getString("XQNM"));
		if(flag){
			e.setRecordIndex(rs.getInt(rid));
			e.setRecordCount(rs.getInt(total));
			e.setCzr(rs.getString(czr));
			e.setSzqy(rs.getString(szqy));
		}
		return e;
	}
	
}
