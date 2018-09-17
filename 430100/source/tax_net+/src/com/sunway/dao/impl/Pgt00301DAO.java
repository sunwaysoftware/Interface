/**
 * 
 */
package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00301DAO;
import com.sunway.util.ConvertUtil;
import com.sunway.vo.Pgt00301;
import com.sunway.vo.Pgv00301;

/**
 * 
 * 市场法登记信息
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt00301DAO extends BaseDAO implements IPgt00301DAO {

	// property constants
	private static final String swid = "SWID";					//税务编码/证件号码
	private static final String nsrmc = "NSRMC";				//姓名
	private static final String cd00001Zjlx = "CD_00001_ZJLX";	//证件类型
	private static final String zz = "ZZ";						//住址
	private static final String lxdh = "LXDH";					//联系电话
	//private static final String yddh = "YDDH";					//移动电话
	private static final String cd00001Ssgx = "CD_00001_SSGX";	//税收管辖
	private static final String upddate = "UPDDATE";			//更新时间
	private static final String cd00002Czr = "CD_00002_CZR";	//录入人
	private static final String note = "NOTE";					//备注信息
	private static final String total = "TOTAL";
	private static final String zjlx = "ZJLX";
	private static final String ssgx = "SSGX";
	private static final String czr = "CZR";
	private static final String fcCount = "FCCount";
	private static final String pgjg = "PGJG";
	private static final String gbpgjg = "GBPGJG";
	private static final String jsze = "JSZE";
	private static final String ynze = "YNZE";
	private static final String sumPgjg = "SUM_PGJG";
	private static final String sumGbpgjg = "SUM_GBPGJG";
	private static final String sumJsze = "SUM_JSZE";
	private static final String sumYnze = "SUM_YNZE";
	private static final String sczt = "SCZT";
	private static final String zjhm = "ZJHM";
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00301DAO#GetDeleteCommand(com.sunway.vo.Pgt00301)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00301 t00301) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00301(?,?,?,?,?)}");
			call.setString(1, t00301.getSwid());
			call.setString(2, t00301.getCd00002Czr());
			call.setString(3, t00301.getCd00001Ssgx());
			call.setDate(4, ConvertUtil.utilDateToSqlDate(t00301.getBgsj()));
			call.setInt(5, t00301.getBglx());
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
	 * @see com.sunway.dao.IPgt00301DAO#GetInsertCommand(com.sunway.vo.Pgt00301)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt00301 t00301) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00301(?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, t00301.getSwid());
			call.setString(2, t00301.getNsrmc());
			call.setString(3, t00301.getCd00001Zjlx());
			call.setString(4, t00301.getZz());
			call.setString(5, t00301.getLxdh());
			call.setString(6, t00301.getYddh());
			call.setString(7, t00301.getCd00001Ssgx());
			call.setString(8, t00301.getCd00002Czr());
			call.setString(9, t00301.getNote());
			call.setString(10, t00301.getPssd());
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
	 * @see com.sunway.dao.IPgt00301DAO#GetUpdateCommand(com.sunway.vo.Pgt00301)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt00301 t00301) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00301(?,?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, t00301.getSwid());
			call.setString(2, t00301.getNsrmc());
			call.setString(3, t00301.getCd00001Zjlx());
			call.setString(4, t00301.getZz());
			call.setString(5, t00301.getLxdh());
			//call.setString(6, t00301.getYddh());
			call.setString(6, t00301.getCd00001Ssgx());
			call.setString(7, t00301.getCd00002Czr());
			call.setString(8, t00301.getNote());
			call.setDate(9, ConvertUtil.utilDateToSqlDate(t00301.getBgsj()));
			call.setInt(10, t00301.getBglx());
			call.setString(11, t00301.getZjhm());
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
	 * @see com.sunway.dao.IPgt00301DAO#LoadAll(com.sunway.vo.Pgt00301)
	 */
	
	@Override
	public ArrayList<Pgv00301> LoadAll(Pgv00301 v00301) throws Exception {
		ArrayList<Pgv00301> listResult = new ArrayList<Pgv00301>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00301(?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, v00301.getPageIndex());
			call.setInt(3, v00301.getPageSize());
			call.setString(4, v00301.getSwid());
			call.setString(5, v00301.getNsrmc());
			call.setString(6, v00301.getSysSsgx());
			call.setString(7, v00301.getPssd());
			call.execute();
			//返回數據集
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

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00301DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00301)
	 */
	
	@Override
	public Pgt00301 LoadByPrimaryKey(Pgt00301 t00301) throws Exception {
		ArrayList<Pgt00301> listResult = new ArrayList<Pgt00301>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00301(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, t00301.getSwid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return new Pgt00301();
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00301DAO#LoadDetail(com.sunway.vo.Pgv00301)
	 */
	
	@Override
	public Pgv00301 LoadDetail(Pgv00301 v00301) throws Exception {
		ArrayList<Pgv00301> listResult = new ArrayList<Pgv00301>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003010(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v00301.getSwid());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetDParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		if (listResult != null && listResult.size() > 0) {
			return listResult.get(0);
		} else {
			return new Pgv00301();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00301DAO#LoadDetail(com.sunway.vo.Pgv00301)
	 */
	
	@Override
	public Pgv00301 LoadDetail_B(Pgv00301 v00301) throws Exception {
		ArrayList<Pgv00301> listResult = new ArrayList<Pgv00301>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003010_B(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v00301.getSwid());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetDParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		if (listResult != null && listResult.size() > 0) {
			return listResult.get(0);
		} else {
			return new Pgv00301();
		}
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00301 SetVParameters(ResultSet rs) throws Exception {
		Pgv00301 e = new Pgv00301();
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00001Zjlx(rs.getString(cd00001Zjlx));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setCzr(rs.getString(czr));
		e.setLxdh(rs.getString(lxdh));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setRecordCount(rs.getInt(total));
		e.setSsgx(rs.getString(ssgx));
		e.setSwid(rs.getString(swid));
		e.setUpddate(rs.getTimestamp(upddate));
		//e.setYddh(rs.getString(yddh));
		e.setZjlx(rs.getString(zjlx));
		e.setZz(rs.getString(zz));
		return e;
	}

	/**
	 * Table数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00301 SetTParameters(ResultSet rs) throws Exception {
		Pgt00301 e = new Pgt00301();
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00001Zjlx(rs.getString(cd00001Zjlx));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setLxdh(rs.getString(lxdh));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setSwid(rs.getString(swid));
		e.setUpddate(rs.getTimestamp(upddate));
		//e.setYddh(rs.getString(yddh));
		e.setZz(rs.getString(zz));
		e.setZjlx(rs.getString(zjlx));
		e.setCountFC(rs.getInt(fcCount));
		e.setZjhm(rs.getString(zjhm));
		return e;
	}

	/**
	 * Detail数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00301 SetDParameters(ResultSet rs) throws Exception {
		Pgv00301 e = new Pgv00301();
		e.setSwid(rs.getString(swid));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Zjlx(rs.getString(cd00001Zjlx));
		e.setZz(rs.getString(zz));
		e.setLxdh(rs.getString(lxdh));
		//e.setYddh(rs.getString(yddh));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setZjlx(rs.getString(zjlx));
		e.setSsgx(rs.getString(ssgx));
		e.setCzr(rs.getString(czr));
		e.setZjhm(rs.getString(zjhm));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00301DAO#LoadCount(com.sunway.vo.Pgt00301)
	 */
	
	@Override
	public Pgt00301 LoadCount(Pgt00301 t00301) throws Exception {
		Pgt00301 listResult = new Pgt00301();
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_003011(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.INTEGER);
			//輸入參數
			call.setString(2, t00301.getSwid());
			call.execute();
			//返回數據集
			listResult.setCountFC((Integer) call.getObject(1));
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00301DAO#GetZz(com.sunway.vo.Pgv00301)
	 */
	
	@Override
	public ArrayList<String> GetZz(Pgv00301 v00301) throws Exception {
		ArrayList<String> listResult = new ArrayList<String>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003013(?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v00301.getPageIndex());
			call.setInt(3, v00301.getPageSize());
			call.setString(4, v00301.getZz());
			call.setString(5, v00301.getSsgx());
			call.execute();
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(rs.getString(zz));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00301DAO#LoadPgv003015(com.sunway.vo.Pgv00301)
	 */
	
	@Override
	public Pgv00301 LoadPgv003015(Pgv00301 v00301) throws Exception {
		Pgv00301 listResult = new Pgv00301();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003015(?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(3, v00301.getPageIndex());
			call.setInt(4, v00301.getPageSize());
			call.setString(5, v00301.getSwid());
			call.setString(6, v00301.getNsrmc());
			call.setString(7, v00301.getSysSsgx());
			call.setString(8, v00301.getSysPssd());
			call.setInt(9, v00301.getSczt());
			call.execute();
			//返回列合
			rsSum = (ResultSet) call.getObject(2); 
			while(null!=rsSum && rsSum.next()){
				listResult.setSumPgjg(rsSum.getDouble(sumPgjg));
				listResult.setSumGbpgjg(rsSum.getDouble(sumGbpgjg));
				listResult.setSumJsze(rsSum.getDouble(sumJsze));
				listResult.setSumYnze(rsSum.getDouble(sumYnze));
			}
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.getV00301List().add(SetV003015Parameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rsSum, rs, call, conn, session);
		}
		return listResult;
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00301 SetV003015Parameters(ResultSet rs) throws Exception {
		Pgv00301 e = new Pgv00301();
		e.setRecordCount(rs.getInt(total));
		e.setSwid(rs.getString(swid));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Zjlx(rs.getString(cd00001Zjlx));
		e.setZz(rs.getString(zz));
		e.setLxdh(rs.getString(lxdh));
		//e.setYddh(rs.getString(yddh));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setZjlx(rs.getString(zjlx));
		e.setSsgx(rs.getString(ssgx));
		e.setCzr(rs.getString(czr));
		e.setSczt(rs.getInt(sczt));
		e.setPgjg(rs.getDouble(pgjg));
		e.setGbpgjg(rs.getDouble(gbpgjg));
		e.setJsze(rs.getDouble(jsze));
		e.setYnze(rs.getDouble(ynze));
		return e;
	}
}
