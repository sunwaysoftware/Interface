package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt02053DAO;
import com.sunway.vo.Pgt02053;
import com.sunway.vo.Pgv02053;

/**
 * @category 收益法面积修正
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02053DAO extends BaseDAO implements IPgt02053DAO {
	
	private static final String CD00001SZQYLX = "cd_00001_szqylx";	//所在区域类型
	private static final String CD00001SZQY = "cd_00001_szqy";;		//所在区域编码
	private static final String SZQY =  "szqy";						//所在区域名称
	private static final String CD00002PSSD = "cd_00002_pssd";		//评税时点
	private static final String MINVALUE =  "minvalue";				//最小面积(平方米)
	private static final String MAXVALUE =  "maxvalue";				//最大面积(平方米)
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
	public boolean GetDeleteCommand(Pgt02053 mj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02053(?,?,?,?,?,?,?)}");
			call.setString(1, mj.getCd00001Szqy());
			call.setString(2, mj.getCd00001Szqylx());
			call.setString(3, mj.getCd00002Pssd());
			call.setDouble(4, mj.getMaxvalue());
			call.setDouble(5, mj.getMinvalue());
			call.setString(6, mj.getCd00002Czr());
			call.setString(7, mj.getCd00001Ssgx());
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
	public boolean GetInsertCommand(Pgt02053 mj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02053(?,?,?,?,?,?,?,?)}");
			call.setDouble(1, mj.getMinvalue());
			call.setDouble(2, mj.getMaxvalue());
			call.setString(3, mj.getCd00001Szqy());
			call.setString(4, mj.getCd00002Pssd());
			call.setDouble(5, mj.getXzxs());
			call.setString(6, mj.getCd00002Czr());
			call.setString(7, mj.getNote());
			call.setString(8, mj.getCd00001Ssgx());
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
	public boolean GetUpdateCommand(Pgt02053 mj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02053(?,?,?,?,?,?,?,?,?)}");
			call.setDouble(1, mj.getMinvalue());
			call.setDouble(2, mj.getMaxvalue());
			call.setString(3, mj.getCd00001Szqylx());
			call.setString(4, mj.getCd00001Szqy());
			call.setString(5, mj.getCd00002Pssd());
			call.setDouble(6, mj.getXzxs());
			call.setString(7, mj.getCd00002Czr());
			call.setString(8, mj.getNote());
			call.setString(9, mj.getCd00001Ssgx());
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
	public ArrayList<Pgv02053> LoadAll(Pgv02053 mj) throws Exception {
		ArrayList<Pgv02053> listResult = new ArrayList<Pgv02053>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02053(?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, mj.getPageIndex());
			call.setInt(3, mj.getPageSize());
			call.setDouble(4, mj.getIvalue());
			call.setString(5, mj.getCd00001Szqy());
			call.setString(6, mj.getCd00002Pssd());
			call.setString(7, mj.getCd00001Ssgx());
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
	protected Pgv02053 SetVParameters(ResultSet rs) throws Exception {
		Pgv02053 e = new Pgv02053();
		e.setMaxvalue(rs.getDouble(MAXVALUE));
		e.setMinvalue(rs.getDouble(MINVALUE));
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
	public Pgt02053 LoadByPrimaryKey(Pgt02053 mj) throws Exception {
		ArrayList<Pgt02053> listResult = new ArrayList<Pgt02053>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02053(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, mj.getCd00001Szqy());
			call.setString(3, mj.getCd00001Szqylx());
			call.setString(4, mj.getCd00002Pssd());
			call.setDouble(5,mj.getMaxvalue());
			call.setDouble(6,mj.getMinvalue());
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
			return mj;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt02053 SetTParameters(ResultSet rs) throws Exception {
		Pgt02053 e = new Pgt02053();
		e.setMaxvalue(rs.getDouble(MAXVALUE));
		e.setMinvalue(rs.getDouble(MINVALUE));
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
	public boolean ExecuteParamCopy(Pgt02053 mj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {	
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_02053(?,?,?,?,?)}");
			call.setString(1, mj.getSpssd());
			call.setString(2, mj.getTpssd());
			call.setString(3, mj.getCd00001Szqy());
			call.setString(4, mj.getCd00002Czr());
			call.setString(5, mj.getCd00001Ssgx());
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
