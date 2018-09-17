package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00013DAO;
import com.sunway.util.ConvertUtil;
import com.sunway.vo.Pgt00013;
import com.sunway.vo.Pgv00013;

/**
 * @category 用户操作概要记录
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00013DAO extends BaseDAO implements IPgt00013DAO {

	private static final String LOGID = "logid";					//日志ID
	private static final String LOGTYPE = "logtype";				//日志操作类型(1:添加。2:更新。3:删除。4:评税。5:个案评税..)
	private static final String TABLENAME = "tablename";			//用户操作的表的名称
	private static final String TABLEKEY = "tablekey";				//操作表的主键
	private static final String LOGTYPENAME = "logtypename";		//日志类型名称
	private static final String UPDDATE="upddate";					//更改时间
	private static final String CD00002CZR =  "cd_00002_czr";		//操作人编号	
	private static final String CZR = "czr";						//操作人
	private static final String NOTE = "note";						//备注信息
	private static final String TOTAL = "total";					//总纪录数
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#GetDeleteCommand(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00013 operaRecord) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00013(?,?,?,?,?,?)}");
			//传入输入参数
			call.setDate(1, ConvertUtil.utilDateToSqlDate(operaRecord.getStartdate()));
			call.setDate(2, ConvertUtil.utilDateToSqlDate(operaRecord.getStartdate()));
			call.setString(3, operaRecord.getCd00002Czr());
			call.setInt(4, operaRecord.getLogtype());
			call.setString(5, operaRecord.getTablename());
			call.setString(6, operaRecord.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt00004DAO#GetInsertCommand(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt00013 operaRecord) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00013(?,?,?,?,?)}");
			//传入输入参数
			call.setInt(1, operaRecord.getLogtype());
			call.setString(2, operaRecord.getTablename());
			call.setString(3, operaRecord.getCd00002Czr());
			call.setString(4, operaRecord.getNote());
			call.setString(5, operaRecord.getTablekey());
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
	 * @see com.sunway.dao.IPgt00004DAO#GetUpdateCommand(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt00013 operaRecord) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00013(?,?,?,?,?,?)}");
			//传入输入参数
			call.setLong(1, operaRecord.getLogid());
			call.setInt(2, operaRecord.getLogtype());
			call.setString(3, operaRecord.getTablename());
			call.setString(4, operaRecord.getCd00002Czr());
			call.setString(5, operaRecord.getNote());
			call.setString(6, operaRecord.getTablekey());
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
	 * @see com.sunway.dao.IPgt00004DAO#LoadAll(com.sunway.vo.Pgv00004)
	 */
	
	@Override
	public ArrayList<Pgv00013> LoadAll(Pgv00013 operaRecord) throws Exception {
		ArrayList<Pgv00013> listResult = new ArrayList<Pgv00013>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00013(?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setInt(2, operaRecord.getPageIndex());
			call.setInt(3, operaRecord.getPageSize());
			call.setInt(4, operaRecord.getLogtype());
			call.setString(5, operaRecord.getTablename());
			call.setString(6, operaRecord.getCd00002Czr());
			call.setString(7, operaRecord.getCd00001Ssgx());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetVParameters(rs));			
			}
		} catch (Exception e) {
			throw e;
		}finally{
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
	protected Pgv00013 SetVParameters(ResultSet rs) throws Exception {
		Pgv00013 e = new Pgv00013();
		e.setLogid(rs.getLong(LOGID));
		e.setLogtype(rs.getInt(LOGTYPE));
		e.setTablename(rs.getString(TABLENAME));
		e.setTablekey(rs.getString(TABLEKEY));
		e.setLogtypename(rs.getString(LOGTYPENAME));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCzr(rs.getString(CZR));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setRecordCount(rs.getInt(TOTAL));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public Pgt00013 LoadByPrimaryKey(Pgt00013 operaRecord) throws Exception {
		ArrayList<Pgt00013> listResult = new ArrayList<Pgt00013>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00013(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setLong(2, operaRecord.getLogid());
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
			return null;
	}

	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00013 SetTParameters(ResultSet rs) throws Exception {
		Pgt00013 e = new Pgt00013();
		e.setLogid(rs.getLong(LOGID));
		e.setLogtype(rs.getInt(LOGTYPE));
		e.setTablename(rs.getString(TABLENAME));
		e.setTablekey(rs.getString(TABLEKEY));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		return e;
	}
}
