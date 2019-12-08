package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt12082DAO;
import com.sunway.vo.Pgt12082;
import com.sunway.vo.Pgv12082;

/**
 * @category 审核容积率维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt12082DAO extends BaseDAO implements IPgt12082DAO {

	private static final String CD00001TDYTLX = "cd_00001_tdytlx";		//土地用途类型	
	private static final String CD00001TDYT = "cd_00001_tdyt";			//土地用途编号
	private static final String TDYT = "tdyt";							//土地用途
	private static final String CD00001SZQYLX = "cd_00001_szqylx";		//所在区域类型
	private static final String CD00001SZQY = "cd_00001_szqy";			//所在区域编号
	private static final String SZQY = "szqy";							//所在区域
	private static final String MINVALUE = "minvalue";					//最小值
	private static final String MAXVALUE = "maxvalue";					//最大值
	private static final String UPDDATE="upddate";						//更改时间
	private static final String CD00002CZR =  "cd_00002_czr";			//操作人编号	
	private static final String CZR = "czr";							//操作人
	private static final String NOTE = "note";							//备注信息
	private static final String RID = "rid";							//行号
	private static final String TOTAL = "total";						//总纪录数
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#GetDeleteCommand(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt12082 rjl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12082(?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, rjl.getCd00001Tdyt());
			call.setString(2, rjl.getCd00001Tdytlx());
			call.setString(3, rjl.getCd00001Szqy());
			call.setString(4, rjl.getCd00001Szqylx());
			call.setString(5, rjl.getCd00002Czr());
			call.setString(6, rjl.getCd00001Ssgx());
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
	public boolean GetInsertCommand(Pgt12082 rjl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT12082(?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, rjl.getCd00001Tdyt());
			call.setDouble(2, rjl.getMinvalue());
			call.setDouble(3, rjl.getMaxvalue());
			call.setString(4, rjl.getCd00002Czr());
			call.setString(5, rjl.getNote());
			call.setString(6, rjl.getCd00001Szqy());
			call.setString(7, rjl.getCd00001Ssgx());
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
	public boolean GetUpdateCommand(Pgt12082 rjl) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT12082(?,?,?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, rjl.getCd00001Tdytlx());
			call.setString(2, rjl.getCd00001Tdyt());
			call.setDouble(3, rjl.getMinvalue());
			call.setDouble(4, rjl.getMaxvalue());
			call.setString(5, rjl.getCd00002Czr());
			call.setString(6, rjl.getNote());
			call.setString(7, rjl.getCd00001Szqy());
			call.setString(8, rjl.getCd00001Szqylx());
			call.setString(9, rjl.getCd00001Ssgx());
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
	public ArrayList<Pgv12082> LoadAll(Pgv12082 rjl) throws Exception {
		ArrayList<Pgv12082> listResult = new ArrayList<Pgv12082>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12082(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setInt(2, rjl.getPageIndex());
			call.setInt(3, rjl.getPageSize());
			call.setString(4, rjl.getCd00001Tdyt());
			call.setString(5, rjl.getCd00001Szqy());
			call.setString(6, rjl.getCd00001Ssgx());
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
	protected Pgv12082 SetVParameters(ResultSet rs) throws Exception {
		Pgv12082 e = new Pgv12082();
		e.setCd00001Tdyt(rs.getString(CD00001TDYT));
		e.setCd00001Tdytlx(rs.getString(CD00001TDYTLX));
		e.setTdyt(rs.getString(TDYT));
		e.setMaxvalue(rs.getDouble(MAXVALUE));
		e.setMinvalue(rs.getDouble(MINVALUE));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setCzr(rs.getString(CZR));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setSzqy(rs.getString(SZQY));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public Pgt12082 LoadByPrimaryKey(Pgt12082 rjl) throws Exception {
		ArrayList<Pgt12082> listResult = new ArrayList<Pgt12082>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT12082(?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, rjl.getCd00001Tdyt());
			call.setString(3, rjl.getCd00001Tdytlx());
			call.setString(4, rjl.getCd00001Szqy());
			call.setString(5, rjl.getCd00001Szqylx());
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
			return new Pgt12082();
	}

	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt12082 SetTParameters(ResultSet rs) throws Exception {
		Pgt12082 e = new Pgt12082();
		e.setCd00001Tdyt(rs.getString(CD00001TDYT));
		e.setCd00001Tdytlx(rs.getString(CD00001TDYTLX));
		e.setMaxvalue(rs.getDouble(MAXVALUE));
		e.setMinvalue(rs.getDouble(MINVALUE));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		return e;
	}
}
