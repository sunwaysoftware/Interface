package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt12083DAO;
import com.sunway.vo.Pgt12083;
import com.sunway.vo.Pgv12083;

/**
 * @category 审核土地面积维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt12083DAO extends BaseDAO implements IPgt12083DAO {

	private static final String CD00001SZQYLX = "cd_00001_szqylx";		//所在区域类型
	private static final String CD00001SZQY = "cd_00001_szqy";			//所在区域编号
	private static final String SZQY = "szqy";							//所在区域
	private static final String MINVALUE = "minvalue";					//最小值
	private static final String MAXVALUE = "maxvalue";					//最大值
	private static final String UPDDATE="upddate";						//更改时间
	private static final String CD00002CZR =  "cd_00002_czr";			//操作人编号	
	private static final String CZR = "czr";							//操作人
	private static final String NOTE = "note";							//备注信息
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#GetDeleteCommand(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt12083 tdmj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12083(?,?,?,?)}");
			//传入输入参数
			call.setString(1, tdmj.getCd00001Szqy());
			call.setString(2, tdmj.getCd00001Szqylx());
			call.setString(3, tdmj.getCd00002Czr());
			call.setString(4, tdmj.getCd00001Ssgx());
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
	public boolean GetInsertCommand(Pgt12083 tdmj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT12083(?,?,?,?,?,?)}");
			//传入输入参数
			call.setDouble(1, tdmj.getMinvalue());
			call.setDouble(2, tdmj.getMaxvalue());
			call.setString(3, tdmj.getCd00002Czr());
			call.setString(4, tdmj.getNote());
			call.setString(5, tdmj.getCd00001Szqy());
			call.setString(6, tdmj.getCd00001Ssgx());
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
	public boolean GetUpdateCommand(Pgt12083 tdmj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT12083(?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setDouble(1, tdmj.getMinvalue());
			call.setDouble(2, tdmj.getMaxvalue());
			call.setString(3, tdmj.getCd00002Czr());
			call.setString(4, tdmj.getNote());
			call.setString(5, tdmj.getCd00001Szqy());
			call.setString(6, tdmj.getCd00001Szqylx());
			call.setString(7, tdmj.getCd00001Ssgx());
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
	public ArrayList<Pgv12083> LoadAll(Pgv12083 tdmj) throws Exception {
		ArrayList<Pgv12083> listResult = new ArrayList<Pgv12083>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12083(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, tdmj.getCd00001Szqy());
			call.setString(3, tdmj.getCd00001Ssgx());
			//传入输入参数
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
	protected Pgv12083 SetVParameters(ResultSet rs) throws Exception {
		Pgv12083 e = new Pgv12083();
		e.setMaxvalue(rs.getDouble(MAXVALUE));
		e.setMinvalue(rs.getDouble(MINVALUE));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setSzqy(rs.getString(SZQY));
		e.setNote(rs.getString(NOTE));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCzr(rs.getString(CZR));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00004DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00004)
	 */
	
	@Override
	public Pgt12083 LoadByPrimaryKey(Pgt12083 tdmj) throws Exception {
		ArrayList<Pgt12083> listResult = new ArrayList<Pgt12083>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT12083(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, tdmj.getCd00001Szqy());
			call.setString(3, tdmj.getCd00001Szqylx());
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
			return new Pgt12083();
	}

	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt12083 SetTParameters(ResultSet rs) throws Exception {
		Pgt12083 e = new Pgt12083();
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
