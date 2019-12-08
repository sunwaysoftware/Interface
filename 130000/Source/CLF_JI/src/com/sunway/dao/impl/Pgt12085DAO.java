package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt12085DAO;
import com.sunway.vo.Pgt12085;
import com.sunway.vo.Pgv12085;

/**
 * @category 各地区审核类型
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt12085DAO extends BaseDAO implements IPgt12085DAO {
	
	private static final String CD00001SZQYLX = "cd_00001_szqylx";	//所在区域类型
	private static final String CD00001SZQY = "cd_00001_szqy";;		//所在区域编码
//	private static final String SZQY = "szqy";						//所在区域
	private static final String SHLX = "shlx";						//审核类型
	private static final String CZR = "czr";						//操作人
	private static final String SHLXMC = "shlxmc";					//审核类型名称
	private static final String SFSH = "sfsh";						//是否审核
	private static final String UPDDATE="upddate";					//更改时间
	private static final String CD00002CZR = "cd_00002_czr";		//操作人编号	
	private static final String NOTE = "note";						//备注信息
//	private static final String RID = "rid";						//行号
//	private static final String TOTAL = "total";					//总纪录数
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt12085 shlx) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12085(?,?,?)}");
			call.setString(1, shlx.getCd00001Szqy());
			call.setString(2, shlx.getCd00001Szqylx());
			call.setShort(3, shlx.getShlx());
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
	public boolean GetInsertCommand(Pgt12085 shlx) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT12085(?,?,?,?,?,?)}");
			call.setString(1, shlx.getCd00001Szqy());
			call.setShort(2, shlx.getShlx());
			call.setBoolean(3, shlx.getSfsh());
			call.setString(4, shlx.getCd00002Czr());
			call.setString(5, shlx.getNote());
			call.setString(6, shlx.getCd00001Ssgx());
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
	public boolean GetUpdateCommand(Pgt12085 shlx) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT12085(?,?,?,?,?)}");
			call.setString(1, shlx.getCd00001Szqy());
			call.setString(2, shlx.getShlxs());
			call.setString(3, shlx.getCd00002Czr());
			call.setString(4, shlx.getNote());
			call.setString(5, shlx.getCd00001Ssgx());
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
	public ArrayList<Pgv12085> LoadAll(Pgv12085 shlx) throws Exception {
		ArrayList<Pgv12085> listResult = new ArrayList<Pgv12085>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12085(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setString(2, shlx.getCd00001Szqy());
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
	protected Pgv12085 SetVParameters(ResultSet rs) throws Exception {
		Pgv12085 e = new Pgv12085();
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setShlx(rs.getInt(SHLX));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setSfsh(rs.getString(SFSH));
		e.setCzr(rs.getString(CZR));
		e.setShlxmc(rs.getString(SHLXMC));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt12085 LoadByPrimaryKey(Pgt12085 shlx) throws Exception {
		ArrayList<Pgt12085> listResult = new ArrayList<Pgt12085>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT12085(?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, shlx.getCd00001Szqy());
			call.setString(3, shlx.getCd00001Szqylx());
			call.setShort(4, shlx.getShlx());
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
			return new Pgt12085();
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt12085 SetTParameters(ResultSet rs) throws Exception {
		Pgt12085 e = new Pgt12085();
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setShlx(rs.getShort(SHLX));
		e.setSfsh(rs.getBoolean(SFSH));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		return e;
	}

}
