package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt02056DAO;
import com.sunway.vo.Pgt02056;
import com.sunway.vo.Pgv02056;

/**
 * @category 星级标准修正
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02056DAO extends BaseDAO implements IPgt02056DAO {

	private static final String CD00001XJBZLX = "cd_00001_xjbzlx";	//星级标准类型编号
	private static final String CD00001XJBZ = "cd_00001_xjbz";		//星级标准编号
	private static final String XJBZ = "xjbz";						//星级标准名称
	private static final String CD00001SZQYLX = "cd_00001_szqylx";	//所在区域类型
	private static final String CD00001SZQY = "cd_00001_szqy";;		//所在区域编码
	private static final String SZQY =  "szqy";						//所在区域名称
	private static final String CD00002PSSD = "cd_00002_pssd";		//评税时点
	private static final String XZXS = "xzxs";						//修正系数
	private static final String UPDDATE="upddate";					//更改时间
	private static final String CD00002CZR = "cd_00002_czr";		//操作人编号	
	private static final String CZR = "czr";						//操作人
	private static final String NOTE = "note";						//备注信息
	private static final String RID = "rid";						//行号
	private static final String TOTAL = "total";					//总纪录数
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt02056 xjbz) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02056(?,?,?,?,?,?,?)}");
			call.setString(1, xjbz.getCd00001Szqy());
			call.setString(2, xjbz.getCd00001Szqylx());
			call.setString(3, xjbz.getCd00001Xjbz());
			call.setString(4, xjbz.getCd00001Xjbzlx());
			call.setString(5, xjbz.getCd00002Pssd());
			call.setString(6, xjbz.getCd00002Czr());
			call.setString(7, xjbz.getCd00001Ssgx());
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
	public boolean GetInsertCommand(Pgt02056 xjbz) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02056(?,?,?,?,?,?,?)}");
			call.setString(1, xjbz.getCd00001Xjbz());
			call.setString(2, xjbz.getCd00001Szqy());
			call.setString(3, xjbz.getCd00002Pssd());
			call.setDouble(4, xjbz.getXzxs());
			call.setString(5, xjbz.getCd00002Czr());
			call.setString(6, xjbz.getNote());
			call.setString(7, xjbz.getCd00001Ssgx());
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
	public boolean GetUpdateCommand(Pgt02056 xjbz) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02056(?,?,?,?,?,?,?,?,?)}");
			call.setString(1, xjbz.getCd00001Xjbzlx());
			call.setString(2, xjbz.getCd00001Xjbz());
			call.setString(3, xjbz.getCd00001Szqylx());
			call.setString(4, xjbz.getCd00001Szqy());
			call.setString(5, xjbz.getCd00002Pssd());
			call.setDouble(6, xjbz.getXzxs());
			call.setString(7, xjbz.getCd00002Czr());
			call.setString(8, xjbz.getNote());
			call.setString(9, xjbz.getCd00001Ssgx());
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
	public ArrayList<Pgv02056> LoadAll(Pgv02056 xjbz) throws Exception {
		ArrayList<Pgv02056> listResult = new ArrayList<Pgv02056>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02056(?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, xjbz.getPageIndex());
			call.setInt(3, xjbz.getPageSize());
			call.setString(4, xjbz.getCd00001Xjbz());
			call.setString(5, xjbz.getCd00001Szqy());
			call.setString(6, xjbz.getCd00002Pssd());
			call.setString(7, xjbz.getCd00001Ssgx());
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
	protected Pgv02056 SetVParameters(ResultSet rs) throws Exception {
		Pgv02056 e = new Pgv02056();
		e.setCd00001Xjbzlx(rs.getString(CD00001XJBZLX));
		e.setCd00001Xjbz(rs.getString(CD00001XJBZ));
		e.setXjbz(rs.getString(XJBZ));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setSzqy(rs.getString(SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setXzxs(rs.getDouble(XZXS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		e.setCzr(rs.getString(CZR));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt02056 LoadByPrimaryKey(Pgt02056 xjbz) throws Exception {
		ArrayList<Pgt02056> listResult = new ArrayList<Pgt02056>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02056(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, xjbz.getCd00001Szqy());
			call.setString(3, xjbz.getCd00001Szqylx());
			call.setString(4, xjbz.getCd00001Xjbz());
			call.setString(5, xjbz.getCd00001Xjbzlx());
			call.setString(6, xjbz.getCd00002Pssd());
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
			return xjbz;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt02056 SetTParameters(ResultSet rs) throws Exception {
		Pgt02056 e = new Pgt02056();
		e.setCd00001Xjbzlx(rs.getString(CD00001XJBZLX));
		e.setCd00001Xjbz(rs.getString(CD00001XJBZ));
		e.setXjbz(rs.getString(XJBZ));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setXzxs(rs.getDouble(XZXS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setNote(rs.getString(NOTE));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExecuteParamCopy(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean ExecuteParamCopy(Pgt02056 xjbz) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {	
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02056(?,?,?,?,?)}");
			call.setString(1, xjbz.getSpssd());
			call.setString(2, xjbz.getTpssd());
			call.setString(3, xjbz.getCd00001Szqy());
			call.setString(4, xjbz.getCd00002Czr());
			call.setString(5, xjbz.getCd00001Ssgx());
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
}
