package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt10056DAO;
import com.sunway.vo.Pgt10056;
import com.sunway.vo.Pgv10056;

/**
 * @category 成本法评税时点修正
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt10056DAO extends BaseDAO implements IPgt10056DAO {

	

	private static final String CD00001SZQYLX = "cd_00001_szqylx";	//所在区域类型
	private static final String CD00001SZQY = "cd_00001_szqy";;		//所在区域编码
	private static final String SZQY =  "szqy";						//所在区域名称
	private static final String CD00002PSSD = "cd_00002_pssd";		//评税时点
	private static final String TDZS = "tdzs";						//评税时点土地价格指数
	private static final String JZTDZS = "jztdzs";					//基准地价基准土地价格指数
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
	public boolean GetDeleteCommand(Pgt10056 pssdxz) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT10056(?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, pssdxz.getCd00001Szqy());
			call.setString(2, pssdxz.getCd00001Szqylx());
			call.setString(3, pssdxz.getCd00002Pssd());
			call.setString(4, pssdxz.getCd00002Czr());
			call.setString(5, pssdxz.getCd00001Ssgx());
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
	public boolean GetInsertCommand(Pgt10056 pssdxz) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT10056(?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, pssdxz.getCd00001Szqy());
			call.setString(2, pssdxz.getCd00002Pssd());
			call.setDouble(3, pssdxz.getTdzs());
			call.setDouble(4, pssdxz.getJztdzs());
			call.setString(5, pssdxz.getCd00002Czr());
			call.setString(6, pssdxz.getNote());
			call.setString(7, pssdxz.getCd00001Ssgx());
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
	public boolean GetUpdateCommand(Pgt10056 pssdxz) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT10056(?,?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, pssdxz.getCd00001Szqylx());
			call.setString(2, pssdxz.getCd00001Szqy());
			call.setString(3, pssdxz.getCd00002Pssd());
			call.setDouble(4, pssdxz.getTdzs());
			call.setDouble(5, pssdxz.getJztdzs());
			call.setString(6, pssdxz.getCd00002Czr());
			call.setString(7, pssdxz.getNote());
			call.setString(8, pssdxz.getCd00001Ssgx());
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
	public ArrayList<Pgv10056> LoadAll(Pgv10056 pssdxz) throws Exception {
		ArrayList<Pgv10056> listResult = new ArrayList<Pgv10056>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT10056(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setInt(2, pssdxz.getPageIndex());
			call.setInt(3, pssdxz.getPageSize());
			call.setString(4, pssdxz.getCd00001Szqy());
			call.setString(5, pssdxz.getCd00002Pssd());
			call.setString(6, pssdxz.getCd00001Ssgx());
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
	protected Pgv10056 SetVParameters(ResultSet rs) throws Exception {
		Pgv10056 e = new Pgv10056();
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setJztdzs(rs.getDouble(JZTDZS));
		e.setTdzs(rs.getDouble(TDZS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setSzqy(rs.getString(SZQY));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		e.setCzr(rs.getString(CZR));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt10056 LoadByPrimaryKey(Pgt10056 pssdxz) throws Exception {
		ArrayList<Pgt10056> listResult = new ArrayList<Pgt10056>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT10056(?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, pssdxz.getCd00001Szqy());
			call.setString(3, pssdxz.getCd00001Szqylx());
			call.setString(4, pssdxz.getCd00002Pssd());
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
			return pssdxz;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt10056 SetTParameters(ResultSet rs) throws Exception {
		Pgt10056 e = new Pgt10056();
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setJztdzs(rs.getDouble(JZTDZS));
		e.setTdzs(rs.getDouble(TDZS));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExecuteParamCopy(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean ExecuteParamCopy(Pgt10056 pssdxz) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {	
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_10056(?,?,?,?,?)}");
			call.setString(1, pssdxz.getSpssd());
			call.setString(2, pssdxz.getTpssd());
			call.setString(3, pssdxz.getCd00001Szqy());
			call.setString(4, pssdxz.getCd00002Czr());
			call.setString(5, pssdxz.getCd00001Ssgx());
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
