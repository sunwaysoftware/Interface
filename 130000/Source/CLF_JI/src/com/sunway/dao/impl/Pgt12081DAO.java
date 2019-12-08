package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt12081DAO;
import com.sunway.vo.Pgt12081;
import com.sunway.vo.Pgv12081;

/**
 * @category 审核平方米维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt12081DAO extends BaseDAO implements IPgt12081DAO {

	private static final String CD00001JZJGLX = "cd_00001_jzjglx";	//建筑结构类型
	private static final String CD00001JZJG = "cd_00001_jzjg";		//建筑结构编号
	private static final String JZJG = "jzjg";						//建筑结构
	private static final String CD00001SZQYLX = "cd_00001_szqylx";	//所在区域类型
	private static final String CD00001SZQY = "cd_00001_szqy";		//所在区域编号
	private static final String SZQY = "szqy";						//所在区域
	private static final String MINVALUE = "minvalue";				//最小值
	private static final String MAXVALUE = "maxvalue";				//最大值
	private static final String UPDDATE="upddate";					//更改时间
	private static final String CD00002CZR =  "cd_00002_czr";		//操作人编号	
	private static final String CZR = "czr";						//操作人
	private static final String NOTE = "note";						//备注信息
	private static final String RID = "rid";						//行号
	private static final String TOTAL = "total";					//总纪录数
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#GetDeleteCommand(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt12081 pfmdj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12081(?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, pfmdj.getCd00001Jzjg());
			call.setString(2, pfmdj.getCd00001Jzjglx());
			call.setString(3, pfmdj.getCd00001Szqy());
			call.setString(4, pfmdj.getCd00001Szqylx());
			call.setString(5, pfmdj.getCd00002Czr());
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
	public boolean GetInsertCommand(Pgt12081 pfmdj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT12081(?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, pfmdj.getCd00001Jzjg());
			call.setDouble(2, pfmdj.getMinvalue());
			call.setDouble(3, pfmdj.getMaxvalue());
			call.setString(4, pfmdj.getCd00002Czr());
			call.setString(5, pfmdj.getNote());
			call.setString(6, pfmdj.getCd00001Szqy());
			call.setString(7, pfmdj.getCd00001Ssgx());
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
	public boolean GetUpdateCommand(Pgt12081 pfmdj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT12081(?,?,?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, pfmdj.getCd00001Jzjglx());
			call.setString(2, pfmdj.getCd00001Jzjg());
			call.setDouble(3, pfmdj.getMinvalue());
			call.setDouble(4, pfmdj.getMaxvalue());
			call.setString(5, pfmdj.getCd00002Czr());
			call.setString(6, pfmdj.getNote());
			call.setString(7, pfmdj.getCd00001Szqy());
			call.setString(8, pfmdj.getCd00001Szqylx());
			call.setString(9, pfmdj.getCd00001Ssgx());
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
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12081DAO#LoadAll(com.sunway.vo.Pgv12081)
	 */
	
	@Override
	public ArrayList<Pgv12081> LoadAll(Pgv12081 pfmdj) throws Exception {
		ArrayList<Pgv12081> listResult = new ArrayList<Pgv12081>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12081(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setInt(2, pfmdj.getPageIndex());
			call.setInt(3, pfmdj.getPageSize());
			call.setString(4, pfmdj.getCd00001Jzjg());
			call.setString(5, pfmdj.getCd00001Szqy());
			call.setString(6, pfmdj.getCd00001Ssgx());
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
	protected Pgv12081 SetVParameters(ResultSet rs) throws Exception {
		Pgv12081 e = new Pgv12081();
		e.setCd00001Jzjglx(rs.getString(CD00001JZJGLX));
		e.setCd00001Jzjg(rs.getString(CD00001JZJG));
		e.setMaxvalue(rs.getDouble(MAXVALUE));
		e.setMinvalue(rs.getDouble(MINVALUE));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setJzjg(rs.getString(JZJG));
		e.setCzr(rs.getString(CZR));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setSzqy(rs.getString(SZQY));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public Pgt12081 LoadByPrimaryKey(Pgt12081 pfmdj) throws Exception {
		ArrayList<Pgt12081> listResult = new ArrayList<Pgt12081>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT12081(?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, pfmdj.getCd00001Jzjg());
			call.setString(3, pfmdj.getCd00001Jzjglx());
			call.setString(4, pfmdj.getCd00001Szqy());
			call.setString(5, pfmdj.getCd00001Szqylx());
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
			return new Pgt12081();
	}

	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt12081 SetTParameters(ResultSet rs) throws Exception {
		Pgt12081 e = new Pgt12081();
		e.setCd00001Jzjg(rs.getString(CD00001JZJG));
		e.setCd00001Jzjglx(rs.getString(CD00001JZJGLX));
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
