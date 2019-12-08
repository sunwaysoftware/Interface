package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt12052DAO;
import com.sunway.vo.Pgt12052;
import com.sunway.vo.Pgv12052;
import com.sunway.vo.Pssd;

/**
 * @category 成本法、收益法经济耐用年限指标
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt12052DAO extends BaseDAO implements IPgt12052DAO {

	private static final String CD00001FWYTLX = "cd_00001_fwytlx";	//房屋用途类型编号
	private static final String CD00001FWYT = "cd_00001_fwyt";		//房屋用途编号
	private static final String FWYT = "fwyt";						//房屋用途名称
	private static final String CD00001JZJGLX = "cd_00001_jzjglx";	//建筑结构类型
	private static final String CD00001JZJG = "cd_00001_jzjg";		//建筑结构编号
	private static final String JZJG = "jzjg";						//建筑结构
	private static final String CD00002PSSD = "cd_00002_pssd";		//评税时点
	private static final String NXZB = "nxzb";						//耐用年限(年)
	private static final String UPDDATE="upddate";					//更改时间
	private static final String CD00002CZR = "cd_00002_czr";		//操作人编号	
	private static final String CZR = "czr";						//操作人
	private static final String NOTE = "note";						//备注信息
	private static final String RID = "rid";						//行号
	private static final String TOTAL = "total";					//总纪录数
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12052DAO#GetDeleteCommand(com.sunway.vo.Pgt12052)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt12052 jjnynx) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12052(?,?,?,?,?,?,?)}");
			call.setString(1, jjnynx.getCd00001Fwyt());
			call.setString(2, jjnynx.getCd00001Fwytlx());
			call.setString(3, jjnynx.getCd00001Jzjg());
			call.setString(4, jjnynx.getCd00001Jzjglx());
			call.setString(5, jjnynx.getCd00002Pssd());
			call.setString(6, jjnynx.getCd00002Czr());
			call.setString(7, jjnynx.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt12052DAO#GetInsertCommand(com.sunway.vo.Pgt12052)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt12052 jjnynx) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT12052(?,?,?,?,?,?,?)}");
			call.setString(1, jjnynx.getCd00001Fwyt());
			call.setString(2, jjnynx.getCd00001Jzjg());
			call.setString(3, jjnynx.getCd00002Pssd());
			call.setShort(4, jjnynx.getNxzb());
			call.setString(5, jjnynx.getCd00002Czr());
			call.setString(6, jjnynx.getNote());
			call.setString(7, jjnynx.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt12052DAO#GetUpdateCommand(com.sunway.vo.Pgt12052)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt12052 jjnynx) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT12052(?,?,?,?,?,?,?,?,?)}");
			call.setString(1, jjnynx.getCd00001Fwytlx());
			call.setString(2, jjnynx.getCd00001Fwyt());
			call.setString(3, jjnynx.getCd00001Jzjglx());
			call.setString(4, jjnynx.getCd00001Jzjg());
			call.setString(5, jjnynx.getCd00002Pssd());
			call.setShort(6, jjnynx.getNxzb());
			call.setString(7, jjnynx.getCd00002Czr());
			call.setString(8, jjnynx.getNote());
			call.setString(9, jjnynx.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt12052DAO#LoadAll(com.sunway.vo.Pgv12052)
	 */
	
	@Override
	public ArrayList<Pgv12052> LoadAll(Pgv12052 jjnynx) throws Exception {
		ArrayList<Pgv12052> listResult = new ArrayList<Pgv12052>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12052(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, jjnynx.getPageIndex());
			call.setInt(3, jjnynx.getPageSize());
			call.setString(4, jjnynx.getCd00002Pssd());
			call.setString(5, jjnynx.getCd00001Fwyt());
			call.setString(6, jjnynx.getCd00001Jzjg());
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
	protected Pgv12052 SetVParameters(ResultSet rs) throws Exception {
		Pgv12052 e = new Pgv12052();
		e.setCd00001Jzjglx(rs.getString(CD00001JZJGLX));
		e.setCd00001Jzjg(rs.getString(CD00001JZJG));
		e.setJzjg(rs.getString(JZJG));
		e.setCd00001Fwytlx(rs.getString(CD00001FWYTLX));
		e.setCd00001Fwyt(rs.getString(CD00001FWYT));
		e.setFwyt(rs.getString(FWYT));
		e.setNxzb(rs.getShort(NXZB));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setCzr(rs.getString(CZR));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12052DAO#LoadByPrimaryKey(com.sunway.vo.Pgt12052)
	 */
	
	@Override
	public Pgt12052 LoadByPrimaryKey(Pgt12052 jjnynx) throws Exception {
		ArrayList<Pgt12052> listResult = new ArrayList<Pgt12052>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT12052(?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, jjnynx.getCd00001Fwyt());
			call.setString(3, jjnynx.getCd00001Fwytlx());
			call.setString(4, jjnynx.getCd00001Jzjg());
			call.setString(5, jjnynx.getCd00001Jzjglx());
			call.setString(6, jjnynx.getCd00002Pssd());
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
			return jjnynx;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt12052 SetTParameters(ResultSet rs) throws Exception {
		Pgt12052 e = new Pgt12052();
		e.setCd00001Jzjglx(rs.getString(CD00001JZJGLX));
		e.setCd00001Jzjg(rs.getString(CD00001JZJG));
		e.setCd00001Fwytlx(rs.getString(CD00001FWYTLX));
		e.setCd00001Fwyt(rs.getString(CD00001FWYT));
		e.setNxzb(rs.getShort(NXZB));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExecuteParamCopy(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean ExecuteParamCopy(Pgt12052 jjnynx) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {	
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_12052(?,?,?,?)}");
			call.setString(1, jjnynx.getSpssd());
			call.setString(2, jjnynx.getTpssd());
			call.setString(3, jjnynx.getCd00002Czr());
			call.setString(4, jjnynx.getCd00001Ssgx());
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
	
	
	/**
	 * 通用类，读取参数复制功能所需评税时点
	 * 
	 */
	
	public ArrayList<Pssd> LoadAllPssd(Pssd pssd) throws Exception {
		ArrayList<Pssd> listResult = new ArrayList<Pssd>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120529(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setString(2, pssd.getCurrentPssd());
			call.execute();
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				Pssd bean = new Pssd();
				bean.setPssds(rs.getString("CD_00002_PSSD"));
				listResult.add(bean);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	
}
