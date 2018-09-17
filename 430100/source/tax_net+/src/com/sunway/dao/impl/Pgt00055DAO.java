package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt00055DAO;
import com.sunway.vo.Pgt00055;

/**
 * @category 评税结果检验标准维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00055DAO extends BaseDAO implements IPgt00055DAO {

	private static final String CD00001ZJLXLX = "cd_00001_zjlxlx";	//证件类型类型
	private static final String CD00001ZJLX = "cd_00001_zjlx";;		//证件类型
	private static final String ZJLX =  "zjlx";						//有效位数
	private static final String YXWS =  "yxws";						//有效位数
	private static final String UPDDATE="upddate";					//更改时间
	private static final String CD00002CZR = "cd_00002_czr";		//操作人编号	
	private static final String NOTE = "note";						//备注信息
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00055 bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00055(?,?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getCd00001Zjlx());
			call.setString(2, bean.getCd00001Zjlxlx());
			call.setString(3, bean.getCd00002Czr());
			call.setString(4, bean.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt10051DAO#GetInsertCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt00055 bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00055(?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getCd00001Zjlx());
			call.setByte(2, bean.getYxws());
			call.setString(3, bean.getCd00002Czr());
			call.setString(4, bean.getNote());
			call.setString(5, bean.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt10051DAO#GetUpdateCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt00055 bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00055(?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getCd00001Zjlxlx());
			call.setString(2, bean.getCd00001Zjlx());
			call.setByte(3, bean.getYxws());
			call.setString(4, bean.getCd00002Czr());
			call.setString(5, bean.getNote());
			call.setString(6, bean.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt10051DAO#LoadAll(com.sunway.vo.Pgv10051)
	 */
	
	@Override
	public ArrayList<Pgt00055> LoadAll() throws Exception {
		ArrayList<Pgt00055> listResult = new ArrayList<Pgt00055>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00055(?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.execute();
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
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00055 SetVParameters(ResultSet rs) throws Exception {
		Pgt00055 e = new Pgt00055();
		e.setCd00001Zjlxlx(rs.getString(CD00001ZJLXLX));
		e.setCd00001Zjlx(rs.getString(CD00001ZJLX));
		e.setZjlx(rs.getString(ZJLX));
		e.setYxws(rs.getByte(YXWS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt00055 LoadByPrimaryKey(Pgt00055 bean) throws Exception {
		ArrayList<Pgt00055> listResult = new ArrayList<Pgt00055>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00055(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd00001Zjlx());
			call.setString(3, bean.getCd00001Zjlxlx());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetTParameters(rs));			
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return bean;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00055 SetTParameters(ResultSet rs) throws Exception {
		Pgt00055 e = new Pgt00055();
		e.setCd00001Zjlxlx(rs.getString(CD00001ZJLXLX));
		e.setCd00001Zjlx(rs.getString(CD00001ZJLX));
		e.setZjlx(rs.getString(ZJLX));
		e.setYxws(rs.getByte(YXWS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00055DAO#validateZjlx(com.sunway.vo.Pgt00055)
	 */
	
	@Override
	public boolean validateZjlx(Pgt00055 bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00055(?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			//传入输入参数
			call.setString(2, bean.getCd00001Zjlx());
			call.setString(3, bean.getCd00001Zjlxlx());
			call.setByte(4, bean.getYxws());
			call.execute();
			tran.commit();
			if (call.getInt(1)==1 ) {
				bResult = true;
			}
			
		} catch (Exception e) {
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

}
