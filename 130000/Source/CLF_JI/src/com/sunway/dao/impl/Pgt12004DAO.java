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

import com.sunway.dao.IPgt12004DAO;
import com.sunway.util.Common;
import com.sunway.vo.Pgt12004;
import com.sunway.vo.Pgv12004;

/**
 * 
 * 成本法、收益法房产明细信息
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt12004DAO extends BaseDAO implements IPgt12004DAO {

	// property constants
	private static final String total = "TOTAL";
	private static final String rid = "RID";
	private static final String mxid = "MXID";					//明细编码
	private static final String cd12003Fcid = "CD_12003_FCID";	//房产编码
	private static final String cd12002Dcid = "CD_12002_DCID";	//地产编码
	private static final String cd12001Swid = "CD_12001_SWID";	//税务登记代码
	private static final String fdcmc = "FDCMC";				//房地产名称
	private static final String szcc = "SZCC";					//所在层次
	private static final String bwjfh = "BWJFH";				//部位及房号
	private static final String cd00001Jzjg = "CD_00001_JZJG";	//房屋结构
	private static final String cd00001Fwyt = "CD_00001_FWYT";	//房屋用途
	private static final String ytjzmj = "YTJZMJ";				//各用途建筑面积(平方米)
	private static final String fcyz = "FCYZ";					//房产原值(元)（评税）
	private static final String cd00001Xjbz = "CD_00001_XJBZ";	//星级标准
	private static final String cd00001Fwcx = "CD_00001_FWCX";	//房屋朝向
	private static final String lrdate = "LRDATE";				//入库日期
	private static final String upddate = "UPDDATE";			//更新时间
	private static final String cd00002Czr = "CD_00002_CZR";	//录入人
	private static final String note = "NOTE";					//备注
	private static final String cd12053Ddid = "CD_12053_DDID";	//地段编码
	private static final String gytzj = "GYTZJ";				//各用途租金收入明细(元)
	private static final String ddnm = "DDNM";
	private static final String nsrmc = "NSRMC";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String czr = "CZR";
	private static final String jzjg = "JZJG";
	private static final String xjbz = "XJBZ";
	private static final String fwcx = "FWCX";
	private static final String fwyt = "FWYT";
	private static final String sumYtjzmj = "SUM_YTJZMJ";
	private static final String sumFcyz = "SUM_FCYZ";
	private static final String sumGytzj = "SUM_GYTZJ";
	private static final String cd00001Szqy = "CD_00001_SZQY";
	private static final String fwzldz = "FWZLDZ";
	private static final String zpCount = "ZPCOUNT";
	//private static final String sfms = "SFMS";
	private static final String cd00001Mssz = "CD_00001_MSSZ";
	private static final String mssz = "MSSZ";
	private static final String fcpgjg = "FCPGJG";
	private static final String dcpgjg = "DCPGJG";
	private static final String cbpgjg = "CBPGJG";
	private static final String gbfcpgjg = "GBFCPGJG";
	private static final String gbdcpgjg = "GBDCPGJG";
	private static final String cbgbpgjg = "CBGBPGJG";
	private static final String sypgjg = "SYPGJG";
	private static final String sygbpgjg = "SYGBPGJG";
	private static final String cbjsze = "CBJSZE";
	private static final String cbynze = "CBYNZE";
	private static final String syjsze = "SYJSZE";
	private static final String syynze = "SYYNZE";
	private static final String sumFcpgjg = "SUM_FCPGJG";
	private static final String sumDcpgjg = "SUM_DCPGJG";
	private static final String sumCbpgjg = "SUM_CBPGJG";
	private static final String sumGbfcpgjg = "SUM_GBFCPGJG";
	private static final String sumGbdcpgjg = "SUM_GBDCPGJG";
	private static final String sumCbgbpgjg = "SUM_CBGBPGJG";
	private static final String sumSypgjg = "SUM_SYPGJG";
	private static final String sumSygbpgjg = "SUM_SYGBPGJG";
	private static final String sumCbjsze = "SUM_CBJSZE";
	private static final String sumCbynze = "SUM_CBYNZE";
	private static final String sumSyjsze = "SUM_SYJSZE";
	private static final String sumSyynze = "SUM_SYYNZE";
	private static final String cbzt = "CBZT";
	private static final String syzt = "SYZT";
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12004DAO#GetDeleteCommand(com.sunway.vo.Pgt12004)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt12004 t12004) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12004(?,?,?,?,?)}");
			call.setString(1, t12004.getMxid());
			call.setString(2, t12004.getCd00002Czr());
			call.setString(3, t12004.getSysSsgx());
			call.setDate(4, Common.converDate(t12004.getBgsj()));
			call.setInt(5, t12004.getBglx());
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
	 * @see com.sunway.dao.IPgt12004DAO#GetInsertCommand(com.sunway.vo.Pgt12004)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt12004 t12004) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT12004(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, t12004.getMxid());
			call.setString(2, t12004.getCd12003Fcid());
			call.setString(3, t12004.getCd12002Dcid());
			call.setString(4, t12004.getCd12001Swid());
			call.setString(5, t12004.getFdcmc());
			call.setString(6, t12004.getSzcc());
			call.setString(7, t12004.getBwjfh());
			call.setString(8, t12004.getCd00001Jzjg());
			call.setString(9, t12004.getCd00001Fwyt());
			call.setDouble(10, t12004.getYtjzmj());
			call.setBigDecimal(11, t12004.getFcyz());
			call.setString(12, t12004.getCd00001Xjbz());
			call.setString(13, t12004.getCd00001Fwcx());
			call.setString(14, t12004.getCd00002Czr());
			call.setString(15, t12004.getNote());
			call.setString(16, t12004.getCd12053Ddid());
			call.setBigDecimal(17, t12004.getGytzj());
			call.setString(18, t12004.getCd00001Fwss());
			call.setString(19, t12004.getCd12006Czrzjh());
			call.setString(20, t12004.getCzrmc());
			call.setBoolean(21, t12004.getSfnsr());
			call.setDate(22, Common.converDate(t12004.getCzkssj()));
			call.setDate(23, Common.converDate(t12004.getCzjssj()));
			call.setString(24, t12004.getQtxzCb());
			call.setString(25, t12004.getQtxzSy());
			call.setString(26, t12004.getSysSsgx());
			//call.setInt(27, t12004.getSfms());
			call.setString(27, t12004.getCd00001Mssz());
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
	 * @see com.sunway.dao.IPgt12004DAO#GetUpdateCommand(com.sunway.vo.Pgt12004)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt12004 t12004) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT12004(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, t12004.getMxid());
			call.setString(2, t12004.getCd12003Fcid());
			call.setString(3, t12004.getCd12002Dcid());
			call.setString(4, t12004.getCd12001Swid());
			call.setString(5, t12004.getFdcmc());
			call.setString(6, t12004.getSzcc());
			call.setString(7, t12004.getBwjfh());
			call.setString(8, t12004.getCd00001Jzjg());
			call.setString(9, t12004.getCd00001Fwyt());
			call.setDouble(10, t12004.getYtjzmj());
			call.setBigDecimal(11, t12004.getFcyz());
			call.setString(12, t12004.getCd00001Xjbz());
			call.setString(13, t12004.getCd00001Fwcx());
			call.setString(14, t12004.getCd00002Czr());
			call.setString(15, t12004.getNote());
			call.setString(16, t12004.getCd12053Ddid());
			call.setBigDecimal(17, t12004.getGytzj());
			call.setString(18, t12004.getCd00001Fwss());
			call.setString(19, t12004.getQtxzCb());
			call.setString(20, t12004.getQtxzSy());
			call.setString(21, t12004.getSysSsgx());
			call.setDate(22, Common.converDate(t12004.getBgsj()));
			call.setInt(23, t12004.getBglx());
			//call.setInt(24, t12004.getSfms());
			call.setString(24, t12004.getCd00001Mssz());
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
	 * @see com.sunway.dao.IPgt12004DAO#LoadAll(com.sunway.vo.Pgv12004)
	 */
	
	@Override
	public Pgv12004 LoadAll(Pgv12004 v12004) throws Exception {
		Pgv12004 listResult = new Pgv12004();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12004(?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(3, v12004.getPageIndex());
			call.setInt(4, v12004.getPageSize());
			call.setString(5, v12004.getCd12001Swid());
			call.setString(6, v12004.getNsrmc());
			call.setString(7, v12004.getMxid());
			call.setString(8, v12004.getSysSsgx());
			call.setString(9, v12004.getSysPssd());
			call.execute();
			//返回列合
			rsSum = (ResultSet) call.getObject(2); 
			while(null!=rsSum && rsSum.next()){
				listResult.setSumFcyz(rsSum.getDouble(sumFcyz));
				listResult.setSumGytzj(rsSum.getDouble(sumGytzj));
				listResult.setSumYtjzmj(rsSum.getDouble(sumYtjzmj));
			}
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.getV12004List().add(SetVParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rsSum, rsSum, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12004DAO#LoadByPrimaryKey(com.sunway.vo.Pgt12004)
	 */
	
	@Override
	public Pgt12004 LoadByPrimaryKey(Pgt12004 t12004) throws Exception {
		ArrayList<Pgt12004> listResult = new ArrayList<Pgt12004>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT12004(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, t12004.getMxid());
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
			return null;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12004DAO#LoadMaxMxId()
	 */
	
	@Override
	public String LoadMaxMxId() throws Exception {
		String resultValue = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{? = call fn_getmxid()}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			call.execute();
			//返回數據集
			resultValue = (String) call.getObject(1); 
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return resultValue;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt12004DAO#LoadDetail(com.sunway.vo.Pgv12004)
	 */
	
	@Override
	public Pgv12004 LoadDetail(Pgv12004 v12004) throws Exception {
		ArrayList<Pgv12004> listResult = new ArrayList<Pgv12004>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120040(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v12004.getMxid());
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
			return new Pgv12004();
		}
	}

	/**
	 * Table数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt12004 SetTParameters(ResultSet rs) throws Exception {
		Pgt12004 e = new Pgt12004();
		e.setBwjfh(rs.getString(bwjfh));
		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
		e.setCd00001Fwyt(rs.getString(cd00001Fwyt));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setCd00001Xjbz(rs.getString(cd00001Xjbz));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setCd12002Dcid(rs.getString(cd12002Dcid));
		e.setCd12003Fcid(rs.getString(cd12003Fcid));
		e.setCd12053Ddid(rs.getString(cd12053Ddid));
		e.setFcyz(rs.getBigDecimal(fcyz));
		e.setFdcmc(rs.getString(fdcmc));
		e.setGytzj(rs.getBigDecimal(gytzj));
		e.setMxid(rs.getString(mxid));
		e.setNote(rs.getString(note));
		e.setSzcc(rs.getString(szcc));
		e.setYtjzmj(rs.getDouble(ytjzmj));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setLrdate(rs.getTimestamp(lrdate));
		e.setJzjg(rs.getString(jzjg));
		e.setXjbz(rs.getString(xjbz));
		e.setFwcx(rs.getString(fwcx));
		e.setFwyt(rs.getString(fwyt));
		e.setNsrmc(rs.getString(nsrmc));
		e.setFwzldz(rs.getString(fwzldz));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setDdnm(rs.getString(ddnm));
		//e.setSfms(rs.getInt(sfms));
		e.setCd00001Mssz(rs.getString(cd00001Mssz));
		e.setMssz(rs.getString(mssz));
		return e;
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv12004 SetVParameters(ResultSet rs) throws Exception {
		Pgv12004 e = new Pgv12004();
		e.setBwjfh(rs.getString(bwjfh));
		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
		e.setCd00001Fwyt(rs.getString(cd00001Fwyt));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setCd00001Xjbz(rs.getString(cd00001Xjbz));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setCd12002Dcid(rs.getString(cd12002Dcid));
		e.setCd12003Fcid(rs.getString(cd12003Fcid));
		e.setCd12053Ddid(rs.getString(cd12053Ddid));
		e.setFcyz(rs.getDouble(fcyz));
		e.setFdcmc(rs.getString(fdcmc));
		e.setGytzj(rs.getDouble(gytzj));
		e.setMxid(rs.getString(mxid));
		e.setNote(rs.getString(note));
		e.setSzcc(rs.getString(szcc));
		e.setYtjzmj(rs.getDouble(ytjzmj));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setLrdate(rs.getTimestamp(lrdate));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCzr(rs.getString(czr));
		e.setJzjg(rs.getString(jzjg));
		e.setXjbz(rs.getString(xjbz));
		e.setFwcx(rs.getString(fwcx));
		e.setFwyt(rs.getString(fwyt));
		e.setRecordCount(rs.getInt(total));
		e.setRecordIndex(rs.getInt(rid));
		e.setDdnm(rs.getString(ddnm));
		e.setZpCount(rs.getInt(zpCount));
		return e;
	}

	/**
	 * Detail数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv12004 SetDParameters(ResultSet rs) throws Exception {
		Pgv12004 e = new Pgv12004();
		e.setMxid(rs.getString(mxid));
		e.setCd12003Fcid(rs.getString(cd12003Fcid));
		e.setCd12002Dcid(rs.getString(cd12002Dcid));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setFdcmc(rs.getString(fdcmc));
		e.setSzcc(rs.getString(szcc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setCd00001Fwyt(rs.getString(cd00001Fwyt));
		e.setYtjzmj(rs.getDouble(ytjzmj));
		e.setFcyz(rs.getDouble(fcyz));
		e.setCd00001Xjbz(rs.getString(cd00001Xjbz));
		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
		e.setLrdate(rs.getTimestamp(lrdate));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setCd12053Ddid(rs.getString(cd12053Ddid));
		e.setGytzj(rs.getDouble(gytzj));
		e.setDdnm(rs.getString(ddnm));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCzr(rs.getString(czr));
		e.setJzjg(rs.getString(jzjg));
		e.setFwyt(rs.getString(fwyt));
		e.setXjbz(rs.getString(xjbz));
		e.setFwcx(rs.getString(fwcx));
		e.setZpCount(rs.getInt(zpCount));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12004DAO#LoadDD(com.sunway.vo.Pgv12004)
	 */
	
	@Override
	public Pgv12004 LoadDD(Pgv12004 v12004) throws Exception {
		Pgv12004 listResult = new Pgv12004();
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_120041(?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			call.registerOutParameter(2, OracleTypes.VARCHAR);
			//傳入輸入參數
			call.setString(3, v12004.getCd00001Fwyt());
			call.setString(4, v12004.getFwzldz());
			call.setString(5, v12004.getCd00001Szqy());
			call.execute();
			//返回數據集
			listResult.setCd12053Ddid((String)call.getObject(1)); 
			listResult.setDdnm((String)call.getObject(2));
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt12004DAO#LoadPgv120045(com.sunway.vo.Pgv12004)
	 */
	
	@Override
	public Pgv12004 LoadPgv120045(Pgv12004 v12004) throws Exception {
		Pgv12004 listResult = new Pgv12004();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120045(?,?,?,?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(3, v12004.getPageIndex());
			call.setInt(4, v12004.getPageSize());
			call.setString(5, v12004.getCd12002Dcid());
			call.setString(6, v12004.getCd12001Swid());
			call.setString(7, v12004.getNsrmc());
			call.setString(8, v12004.getMxid());
			call.setString(9, v12004.getSysSsgx());
			call.setString(10, v12004.getSysPssd());
			call.setInt(11, v12004.getCbzt());
			call.setInt(12, v12004.getSyzt());
			call.execute();
			//返回列合
			rsSum = (ResultSet) call.getObject(2); 
			while(null!=rsSum && rsSum.next()){
				listResult.setSumFcyz(rsSum.getDouble(sumFcyz));
				listResult.setSumGytzj(rsSum.getDouble(sumGytzj));
				listResult.setSumYtjzmj(rsSum.getDouble(sumYtjzmj));
				listResult.setSumFcpgjg(rsSum.getDouble(sumFcpgjg));
				listResult.setSumDcpgjg(rsSum.getDouble(sumDcpgjg));
				listResult.setSumCbpgjg(rsSum.getDouble(sumCbpgjg));
				listResult.setSumGbfcpgjg(rsSum.getDouble(sumGbfcpgjg));
				listResult.setSumGbdcpgjg(rsSum.getDouble(sumGbdcpgjg));
				listResult.setSumCbgbpgjg(rsSum.getDouble(sumCbgbpgjg));
				listResult.setSumSypgjg(rsSum.getDouble(sumSypgjg));
				listResult.setSumSygbpgjg(rsSum.getDouble(sumSygbpgjg));
				listResult.setSumCbjsze(rsSum.getDouble(sumCbjsze));
				listResult.setSumCbynze(rsSum.getDouble(sumCbynze));
				listResult.setSumSyjsze(rsSum.getDouble(sumSyjsze));
				listResult.setSumSyynze(rsSum.getDouble(sumSyynze));
			}
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.getV12004List().add(SetV12004Parameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rsSum, rsSum, call, conn, session);
		}
		return listResult;
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv12004 SetV12004Parameters(ResultSet rs) throws Exception {
		Pgv12004 e = new Pgv12004();
		e.setBwjfh(rs.getString(bwjfh));
		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
		e.setCd00001Fwyt(rs.getString(cd00001Fwyt));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setCd00001Xjbz(rs.getString(cd00001Xjbz));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setCd12002Dcid(rs.getString(cd12002Dcid));
		e.setCd12003Fcid(rs.getString(cd12003Fcid));
		e.setCd12053Ddid(rs.getString(cd12053Ddid));
		e.setFcyz(rs.getDouble(fcyz));
		e.setFdcmc(rs.getString(fdcmc));
		e.setGytzj(rs.getDouble(gytzj));
		e.setMxid(rs.getString(mxid));
		e.setNote(rs.getString(note));
		e.setSzcc(rs.getString(szcc));
		e.setYtjzmj(rs.getDouble(ytjzmj));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setLrdate(rs.getTimestamp(lrdate));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCzr(rs.getString(czr));
		e.setJzjg(rs.getString(jzjg));
		e.setXjbz(rs.getString(xjbz));
		e.setFwcx(rs.getString(fwcx));
		e.setFwyt(rs.getString(fwyt));
		e.setRecordCount(rs.getInt(total));
		e.setRecordIndex(rs.getInt(rid));
		e.setDdnm(rs.getString(ddnm));
		e.setZpCount(rs.getInt(zpCount));
		e.setCbzt(rs.getInt(cbzt));
		e.setSyzt(rs.getInt(syzt));
		e.setFcpgjg(rs.getDouble(fcpgjg));
		e.setDcpgjg(rs.getDouble(dcpgjg));
		e.setCbpgjg(rs.getDouble(cbpgjg));
		e.setGbfcpgjg(rs.getDouble(gbfcpgjg));
		e.setGbdcpgjg(rs.getDouble(gbdcpgjg));
		e.setCbgbpgjg(rs.getDouble(cbgbpgjg));
		e.setSypgjg(rs.getDouble(sypgjg));
		e.setSygbpgjg(rs.getDouble(sygbpgjg));
		e.setCbjsze(rs.getDouble(cbjsze));
		e.setCbynze(rs.getDouble(cbynze));
		e.setSyjsze(rs.getDouble(syjsze));
		e.setSyynze(rs.getDouble(syynze));
		return e;
	}
}