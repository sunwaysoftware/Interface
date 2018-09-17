package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt00354DAO;
import com.sunway.vo.Pgt00354;
import com.sunway.vo.Pgv00354;

/**
 * @category 市场法房屋朝向修正系数
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt00354DAO extends BaseDAO implements IPgt00354DAO {

	private static final String CD00001FWCXLX = "cd_00001_fwcxlx";	//房屋朝向类型编码
	private static final String CD00001FWCX = "cd_00001_fwcx";		//房屋朝向编码
	private static final String FWCX = "fwcx";						//房屋朝向名称
	private static final String CD00001SZQYLX = "cd_00001_szqylx";	//所在区域类型
	private static final String CD00001SZQY = "cd_00001_szqy";;		//所在区域编码
	private static final String SZQY =  "szqy";						//所在区域名称
	private static final String CD00002PSSD = "cd_00002_pssd";		//评税时点
	private static final String XZXS = "xzxs";						//修正系数
	private static final String UPDDATE="upddate";					//更改时间
	private static final String CD00002CZR = "cd_00002_czr";		//操作人编号	
	private static final String CZR = "czr";						//操作人
	private static final String NOTE = "note";						//备注信息
	private static final String TOTAL = "total";					//总纪录数
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#GetDeleteCommand(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00354 fwcx) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00354(?,?,?,?,?,?,?)}");
			call.setString(1, fwcx.getCd00001Fwcx());
			call.setString(2, fwcx.getCd00001Fwcxlx());
			call.setString(3, fwcx.getCd00001Szqy());
			call.setString(4, fwcx.getCd00001Szqylx());
			call.setString(5, fwcx.getCd00002Pssd());
			call.setString(6, fwcx.getCd00002Czr());
			call.setString(7, fwcx.getCd00001Ssgx());
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
	public boolean GetInsertCommand(Pgt00354 fwcx) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00354(?,?,?,?,?,?,?)}");
			call.setString(1, fwcx.getCd00001Fwcx());
			call.setString(2, fwcx.getCd00001Szqy());
			call.setString(3, fwcx.getCd00002Pssd());
			call.setDouble(4, fwcx.getXzxs());
			call.setString(5, fwcx.getCd00002Czr());
			call.setString(6, fwcx.getNote());
			call.setString(7, fwcx.getCd00001Ssgx());
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
	public boolean GetUpdateCommand(Pgt00354 fwcx) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00354(?,?,?,?,?,?,?,?,?)}");
			call.setString(1, fwcx.getCd00001Fwcxlx());
			call.setString(2, fwcx.getCd00001Fwcx());
			call.setString(3, fwcx.getCd00001Szqylx());
			call.setString(4, fwcx.getCd00001Szqy());
			call.setString(5, fwcx.getCd00002Pssd());
			call.setDouble(6, fwcx.getXzxs());
			call.setString(7, fwcx.getCd00002Czr());
			call.setString(8, fwcx.getNote());		
			call.setString(9, fwcx.getCd00001Ssgx());
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
	public ArrayList<Pgv00354> LoadAll(Pgv00354 fwcx) throws Exception {
		ArrayList<Pgv00354> listResult = new ArrayList<Pgv00354>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00354(?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, fwcx.getPageIndex());
			call.setInt(3, fwcx.getPageSize());
			call.setString(4, fwcx.getCd00001Fwcx());
			call.setString(5, fwcx.getCd00001Szqy());
			call.setString(6, fwcx.getCd00002Pssd());
			call.setString(7, fwcx.getCd00001Ssgx());
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
	protected Pgv00354 SetVParameters(ResultSet rs) throws Exception {
		Pgv00354 e = new Pgv00354();
		e.setCd00001Fwcxlx(rs.getString(CD00001FWCXLX));
		e.setCd00001Fwcx(rs.getString(CD00001FWCX));
		e.setFwcx(rs.getString(FWCX));
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
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt00354 LoadByPrimaryKey(Pgt00354 fwcx) throws Exception {
		ArrayList<Pgt00354> listResult = new ArrayList<Pgt00354>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00354(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, fwcx.getCd00001Fwcx());
			call.setString(3, fwcx.getCd00001Fwcxlx());
			call.setString(4, fwcx.getCd00001Szqy());
			call.setString(5, fwcx.getCd00001Szqylx());
			call.setString(6, fwcx.getCd00002Pssd());
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
			return fwcx;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00354 SetTParameters(ResultSet rs) throws Exception {
		Pgt00354 e = new Pgt00354();
		e.setCd00001Fwcxlx(rs.getString(CD00001FWCXLX));
		e.setCd00001Fwcx(rs.getString(CD00001FWCX));
		e.setFwcx(rs.getString(FWCX));
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
	public boolean ExecuteParamCopy(Pgt00354 fwcx) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {	
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00354(?,?,?,?,?)}");
			call.setString(1, fwcx.getSpssd());
			call.setString(2, fwcx.getTpssd());
			call.setString(3, fwcx.getCd00001Szqy());
			call.setString(4, fwcx.getCd00002Czr());
			call.setString(5, fwcx.getCd00001Ssgx());
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
