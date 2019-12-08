package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sunway.dao.IPgt10052DAO;
import com.sunway.vo.Pgt10052;
import com.sunway.vo.Pgv10052;

/**
 * @category 成本法建安造价标准
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt10052DAO extends BaseDAO implements IPgt10052DAO {

	
	private static final String CD00001FWYTLX = "cd_00001_fwytlx";	//房屋用途类型
	private static final String CD00001FWYT = "cd_00001_fwyt";		//房屋用途编码
	private static final String FWYT =  "fwyt";						//房屋用途名称
	private static final String CD00001SZQYLX = "cd_00001_szqylx";	//所在区域类型
	private static final String CD00001SZQY = "cd_00001_szqy";;		//所在区域编码
	private static final String SZQY =  "szqy";						//所在区域名称
	private static final String CD00002PSSD = "cd_00002_pssd";		//评税时点
	private static final String BZSZ = "bzsz";						//标准值(元)
	private static final String CD00001ROOTID = "cd_00001_rootid";	//建筑结构、星级标准类型编码
	private static final String CD00001INFOID = "cd_00001_infoid";	//建筑结构、星级标准编码
	private static final String INFONM =  "infonm";					//建筑结构、星级标准类型名称
	private static final String ROOTNM =  "rootnm";					//建筑结构、星级标准名称
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
	public boolean GetDeleteCommand(Pgt10052 jazj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT10052(?,?,?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, jazj.getCd00001Fwyt());
			call.setString(2, jazj.getCd00001Fwytlx());
			call.setString(3, jazj.getCd00001Infoid());
			call.setString(4, jazj.getCd00001Rootid());
			call.setString(5, jazj.getCd00001Szqy());
			call.setString(6, jazj.getCd00001Szqylx());
			call.setString(7, jazj.getCd00002Pssd());
			call.setString(8, jazj.getCd00002Czr());
			call.setString(9, jazj.getCd00001Ssgx());
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
	public boolean GetInsertCommand(Pgt10052 jazj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT10052(?,?,?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, jazj.getCd00001Fwyt());
			call.setString(2, jazj.getCd00001Rootid());
			call.setString(3, jazj.getCd00001Infoid());
			call.setString(4, jazj.getCd00001Szqy());
			call.setString(5, jazj.getCd00002Pssd());
			call.setDouble(6, jazj.getBzsz());
			call.setString(7, jazj.getCd00002Czr());
			call.setString(8, jazj.getNote());
			call.setString(9, jazj.getCd00001Ssgx());
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
	public boolean GetUpdateCommand(Pgt10052 jazj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT10052(?,?,?,?,?,?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, jazj.getCd00001Fwytlx());
			call.setString(2, jazj.getCd00001Fwyt());
			call.setString(3, jazj.getCd00001Rootid());
			call.setString(4, jazj.getCd00001Infoid());
			call.setString(5, jazj.getCd00001Szqylx());
			call.setString(6, jazj.getCd00001Szqy());
			call.setString(7, jazj.getCd00002Pssd());
			call.setDouble(8, jazj.getBzsz());
			call.setString(9, jazj.getCd00002Czr());
			call.setString(10, jazj.getNote());
			call.setString(11, jazj.getCd00001Ssgx());
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
	public ArrayList<Pgv10052> LoadAll(Pgv10052 jazj) throws Exception {
		ArrayList<Pgv10052> listResult = new ArrayList<Pgv10052>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT10052(?,?,?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setInt(2, jazj.getPageIndex());
			call.setInt(3, jazj.getPageSize());
			call.setString(4, jazj.getCd00001Szqy());
			call.setString(5, jazj.getCd00001Fwyt());
			call.setString(6, jazj.getCd00002Pssd());
			call.setString(7, jazj.getCd00001Rootid());
			call.setString(8, jazj.getCd00001Infoid());
			call.setString(9, jazj.getCd00001Ssgx());
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
	protected Pgv10052 SetVParameters(ResultSet rs) throws Exception {
		Pgv10052 e = new Pgv10052();
		e.setCd00001Fwytlx(rs.getString(CD00001FWYTLX));
		e.setCd00001Fwyt(rs.getString(CD00001FWYT));
		e.setCd00001Rootid(rs.getString(CD00001ROOTID));
		e.setCd00001Infoid(rs.getString(CD00001INFOID));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setBzsz(rs.getDouble(BZSZ));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setFwyt(rs.getString(FWYT));
		e.setInfonm(rs.getString(INFONM));
		e.setRootnm(rs.getString(ROOTNM));
		e.setSzqy(rs.getString(SZQY));
		e.setCzr(rs.getString(CZR));
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		return e;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#LoadByPrimaryKey(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public Pgt10052 LoadByPrimaryKey(Pgt10052 jazj) throws Exception {
		ArrayList<Pgt10052> listResult = new ArrayList<Pgt10052>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT10052(?,?,?,?,?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, jazj.getCd00001Fwyt());
			call.setString(3, jazj.getCd00001Fwytlx());
			call.setString(4, jazj.getCd00001Infoid());
			call.setString(5, jazj.getCd00001Rootid());
			call.setString(6, jazj.getCd00001Szqy());
			call.setString(7, jazj.getCd00001Szqylx());
			call.setString(8, jazj.getCd00002Pssd());
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
			return jazj;
	}
	
	/**
	 * View数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt10052 SetTParameters(ResultSet rs) throws Exception {
		Pgt10052 e = new Pgt10052();
		e.setCd00001Fwytlx(rs.getString(CD00001FWYTLX));
		e.setCd00001Fwyt(rs.getString(CD00001FWYT));
		e.setCd00001Rootid(rs.getString(CD00001ROOTID));
		e.setCd00001Infoid(rs.getString(CD00001INFOID));
		e.setCd00001Szqylx(rs.getString(CD00001SZQYLX));
		e.setCd00001Szqy(rs.getString(CD00001SZQY));
		e.setCd00002Pssd(rs.getString(CD00002PSSD));
		e.setBzsz(rs.getDouble(BZSZ));
		e.setUpddate(rs.getTimestamp(UPDDATE));
		e.setNote(rs.getString(NOTE));
		e.setCd00002Czr(rs.getString(CD00002CZR));
		e.setFwyt(rs.getString(FWYT));
		e.setInfonm(rs.getString(INFONM));
		e.setRootnm(rs.getString(ROOTNM));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExecuteParamCopy(com.sunway.vo.Pgt10051)
	 */
	
	@Override
	public boolean ExecuteParamCopy(Pgt10052 jazj) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {	
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_10052(?,?,?,?,?)}");
			call.setString(1, jazj.getSpssd());
			call.setString(2, jazj.getTpssd());
			call.setString(3, jazj.getCd00001Szqy());
			call.setString(4, jazj.getCd00002Czr());
			call.setString(5, jazj.getCd00001Ssgx());
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
