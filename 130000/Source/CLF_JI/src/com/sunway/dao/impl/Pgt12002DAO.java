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

import com.sunway.dao.IPgt12002DAO;
import com.sunway.util.Common;
import com.sunway.vo.Pgt12002;
import com.sunway.vo.Pgv12002;

/**
 * 
 * 成本、收益法地產信息
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt12002DAO extends BaseDAO implements IPgt12002DAO {

	// property constants
	private static final String dcid = "DCID";							//地产编码
	private static final String cd12001Swid = "CD_12001_SWID";			//税务登记代码
	private static final String tdsyqbm = "TDSYQBM";					//土地使用权证书号
	private static final String cd00001Tdyt = "CD_00001_TDYT";			//土地用途
	private static final String cd00001Syqlx = "CD_00001_SYQLX";		//土地使用权类型
	private static final String syqmj = "SYQMJ";						//土地使用权面积(平方米)
	private static final String cd00001Tdsyqlx = "CD_00001_TDSYQLX";	//土地所有权类型
	private static final String cd00001Tddj = "CD_12054_TDDJID";		//土地等级
	private static final String cd00001Szqy = "CD_00001_SZQY";			//所有区域
	private static final String tdzl = "TDZL";							//土地座落地址
	private static final String gbrjl = "GBRJL";						//个别容积率
	private static final String ysmj = "YSMJ";							//应税面积(平方米)
	private static final String msmj = "MSMJ";							//免税面积(平方米)
	private static final String tdpfmse = "TDPFMSE";					//单宗土地每平方米税额(元)
	private static final String x = "X";								//地理坐标X
	private static final String y = "Y";								//地理坐标Y
	private static final String cd00002Czr = "CD_00002_CZR";			//录入人
	private static final String note = "NOTE";							//备注信息
	private static final String sykssj = "SYKSSJ";						//土地使用开始日期
	private static final String syjssj = "SYJSSJ";						//土地使用结束日期
	private static final String upddate = "UPDDATE";					//更新时间
	private static final String nsrmc = "NSRMC";
	private static final String tdsyqlx= "TDSYQLX";
	private static final String tdyt = "TDYT";
	private static final String syqlx = "SYQLX";
	private static final String tddj = "TDDJ";
	private static final String szqy = "SZQY";
	private static final String czr = "CZR";
    private static final String sumSyqmj = "SUM_SYQMJ";
    private static final String sumYsmj = "SUM_YSMJ";
    private static final String sumMsmj = "SUM_MSMJ";  
    private static final String avgGbrjl = "AVG_GBRJL";
    private static final String avgTdpfmse = "AVG_TDPFMSE";
	private static final String recordCount = "TOTAL";
	private static final String recordIndex = "RID";
	private static final String lrdate = "LRDATE";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String fcCount = "FCCount";
	private static final String zpCount = "ZPCOUNT";
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
	 * @see com.sunway.dao.IPgt12002DAO#GetDeleteCommand(com.sunway.vo.Pgt12002)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt12002 t12002) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12002(?,?,?,?,?)}");
			call.setString(1, t12002.getDcid());
			call.setString(2, t12002.getCd00002Czr());
			call.setString(3, t12002.getSysSsgx());
			call.setDate(4, Common.converDate(t12002.getBgsj()));
			call.setInt(5, t12002.getBglx());
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
	 * @see com.sunway.dao.IPgt12002DAO#GetInsertCommand(com.sunway.vo.Pgt12002)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt12002 t12002) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT12002(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, t12002.getDcid());
			call.setString(2, t12002.getCd12001Swid());
			call.setString(3, t12002.getTdsyqbm());
			call.setString(4, t12002.getCd00001Tdyt());
			call.setString(5, t12002.getCd00001Syqlx());
			call.setDouble(6, t12002.getSyqmj());
			call.setString(7, t12002.getCd00001Tdsyqlx());
			call.setString(8, t12002.getCd00001Tddj());
			call.setString(9, t12002.getCd00001Szqy());
			call.setString(10, t12002.getTdzl());
			call.setDouble(11, t12002.getGbrjl());
			call.setDouble(12, t12002.getYsmj());
			call.setDouble(13, t12002.getMsmj());
			call.setDouble(14, t12002.getTdpfmse());
			call.setDouble(15, t12002.getX());
			call.setDouble(16, t12002.getY());
			call.setString(17, t12002.getCd00002Czr());
			call.setString(18, t12002.getNote());
			call.setDate(19, Common.converDate(t12002.getSykssj()));
			call.setDate(20, Common.converDate(t12002.getSyjssj()));
			call.setString(21, t12002.getCd12006Czrzjh());
			call.setString(22, t12002.getCzrmc());
			call.setBoolean(23, t12002.getSfnsr());
			call.setDate(24, Common.converDate(t12002.getCzkssj()));
			call.setDate(25, Common.converDate(t12002.getCzjssj()));
			call.setString(26, t12002.getCd00053QtxzId());
			call.setString(27, t12002.getSysSsgx());
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
	 * @see com.sunway.dao.IPgt12002DAO#GetUpdateCommand(com.sunway.vo.Pgt12002)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt12002 t12002) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT12002(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, t12002.getDcid());
			call.setString(2, t12002.getCd12001Swid());
			call.setString(3, t12002.getTdsyqbm());
			call.setString(4, t12002.getCd00001Tdyt());
			call.setString(5, t12002.getCd00001Syqlx());
			call.setDouble(6, t12002.getSyqmj());
			call.setString(7, t12002.getCd00001Tdsyqlx());
			call.setString(8, t12002.getCd00001Tddj());
			call.setString(9, t12002.getCd00001Szqy());
			call.setString(10, t12002.getTdzl());
			call.setDouble(11, t12002.getGbrjl());
			call.setDouble(12, t12002.getYsmj());
			call.setDouble(13, t12002.getMsmj());
			call.setDouble(14, t12002.getTdpfmse());
			call.setDouble(15, t12002.getX());
			call.setDouble(16, t12002.getY());
			call.setString(17, t12002.getCd00002Czr());
			call.setString(18, t12002.getNote());
			call.setDate(19, Common.converDate(t12002.getSykssj()));
			call.setDate(20, Common.converDate(t12002.getSyjssj()));
			call.setString(21, t12002.getCd00053QtxzId());
			call.setString(22, t12002.getSysSsgx());
			call.setDate(23, Common.converDate(t12002.getBgsj()));
			call.setInt(24, t12002.getBglx());
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
	 * @see com.sunway.dao.IPgt12002DAO#LoadAll(com.sunway.vo.Pgv12002)
	 */
	
	@Override
	public Pgv12002 LoadAll(Pgv12002 v12002) throws Exception {
		Pgv12002 listResult = new Pgv12002();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12002(?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(3, v12002.getPageIndex());
			call.setInt(4, v12002.getPageSize());
			call.setString(5, v12002.getDcid());
			call.setString(6, v12002.getCd12001Swid());
			call.setString(7, v12002.getNsrmc());
			call.setString(8, v12002.getSysSsgx());
			call.setString(9, v12002.getSysPssd());
			call.execute();
			//返回列合
			rsSum = (ResultSet) call.getObject(2); 
			while(null!=rsSum && rsSum.next()){
				listResult.setSumMsmj(rsSum.getDouble(sumMsmj));
				listResult.setSumSyqmj(rsSum.getDouble(sumSyqmj));
				listResult.setSumYsmj(rsSum.getDouble(sumYsmj));
				listResult.setAvgGbrjl(rsSum.getDouble(avgGbrjl));
				listResult.setAvgTdpfmse(rsSum.getDouble(avgTdpfmse));
			}
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.getV12002List().add(SetVParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rsSum, rsSum, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12002DAO#LoadByPrimaryKey(com.sunway.vo.Pgt12002)
	 */
	
	@Override
	public Pgt12002 LoadByPrimaryKey(Pgt12002 t12002) throws Exception {
		ArrayList<Pgt12002> listResult = new ArrayList<Pgt12002>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT12002(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, t12002.getDcid());
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

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt12002DAO#LoadDetail(com.sunway.vo.Pgv12002)
	 */
	
	@Override
	public Pgv12002 LoadDetail(Pgv12002 v12002) throws Exception {
		ArrayList<Pgv12002> listResult = new ArrayList<Pgv12002>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120020(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v12002.getDcid());
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
			return new Pgv12002();
		}
	}

	/**
	 * Table数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt12002 SetTParameters(ResultSet rs) throws Exception {
		Pgt12002 e = new Pgt12002();
		e.setDcid(rs.getString(dcid));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setTdsyqbm(rs.getString(tdsyqbm));
		e.setCd00001Tdyt(rs.getString(cd00001Tdyt));
		e.setCd00001Syqlx(rs.getString(cd00001Syqlx));
		e.setSyqmj(rs.getDouble(syqmj));
		e.setCd00001Tdsyqlx(rs.getString(cd00001Tdsyqlx));
		e.setCd00001Tddj(rs.getString(cd00001Tddj));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setTdzl(rs.getString(tdzl));
		e.setGbrjl(rs.getDouble(gbrjl));
		e.setYsmj(rs.getDouble(ysmj));
		e.setMsmj(rs.getDouble(msmj));
		e.setTdpfmse(rs.getDouble(tdpfmse));
		e.setX(rs.getDouble(x));
		e.setY(rs.getDouble(y));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setSykssj(rs.getDate(sykssj));
		e.setSyjssj(rs.getDate(syjssj));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setTdyt(rs.getString(tdyt));
		e.setSyqlx(rs.getString(syqlx));
		e.setTdsyqlx(rs.getString(tdsyqlx));
		e.setTddj(rs.getString(tddj));
		e.setSzqy(rs.getString(szqy));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCountFC(rs.getInt(fcCount));
		return e;
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv12002 SetVParameters(ResultSet rs) throws Exception {
		Pgv12002 e = new Pgv12002();
		e.setDcid(rs.getString(dcid));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setTdsyqbm(rs.getString(tdsyqbm));
		e.setCd00001Tdyt(rs.getString(cd00001Tdyt));
		e.setCd00001Syqlx(rs.getString(cd00001Syqlx));
		e.setSyqmj(rs.getDouble(syqmj));
		e.setCd00001Tdsyqlx(rs.getString(cd00001Tdsyqlx));
		e.setCd00001Tddj(rs.getString(cd00001Tddj));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setTdzl(rs.getString(tdzl));
		e.setGbrjl(rs.getDouble(gbrjl));
		e.setYsmj(rs.getDouble(ysmj));
		e.setMsmj(rs.getDouble(msmj));
		e.setTdpfmse(rs.getDouble(tdpfmse));
		e.setX(rs.getDouble(x));
		e.setY(rs.getDouble(y));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setSykssj(rs.getDate(sykssj));
		e.setSyjssj(rs.getDate(syjssj));
		e.setNsrmc(rs.getString(nsrmc));
		e.setTdsyqlx(rs.getString(tdsyqlx));
		e.setTdyt(rs.getString(tdyt));
		e.setSyqlx(rs.getString(syqlx));
		e.setTddj(rs.getString(tddj));
		e.setSzqy(rs.getString(szqy));
		e.setCzr(rs.getString(czr));
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setZpCount(rs.getInt(zpCount));
		return e;
	}

	/**
	 * Detail数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv12002 SetDParameters(ResultSet rs) throws Exception {
		Pgv12002 e = new Pgv12002();
		e.setDcid(rs.getString(dcid));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setTdsyqbm(rs.getString(tdsyqbm));
		e.setCd00001Tdyt(rs.getString(cd00001Tdyt));
		e.setCd00001Syqlx(rs.getString(cd00001Syqlx));
		e.setSyqmj(rs.getDouble(syqmj));
		e.setCd00001Tdsyqlx(rs.getString(cd00001Tdsyqlx));
		e.setCd00001Tddj(rs.getString(cd00001Tddj));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setTdzl(rs.getString(tdzl));
		e.setGbrjl(rs.getDouble(gbrjl));
		e.setYsmj(rs.getDouble(ysmj));
		e.setMsmj(rs.getDouble(msmj));
		e.setTdpfmse(rs.getDouble(tdpfmse));
		e.setX(rs.getDouble(x));
		e.setY(rs.getDouble(y));
		e.setLrdate(rs.getTimestamp(lrdate));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setSykssj(rs.getDate(sykssj));
		e.setSyjssj(rs.getDate(syjssj));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setNsrmc(rs.getString(nsrmc));
		e.setTdyt(rs.getString(tdyt));
		e.setSyqlx(rs.getString(syqlx));
		e.setTdsyqlx(rs.getString(tdsyqlx));
		e.setTddj(rs.getString(tddj));
		e.setSzqy(rs.getString(szqy));
		e.setCzr(rs.getString(czr));
		e.setZpCount(rs.getInt(zpCount));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12002DAO#LoadMaxDcId()
	 */
	
	@Override
	public String LoadMaxDcId() throws Exception {
		String resultValue = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{? = call fn_getdcid()}");
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

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12002DAO#GetTdsyqbmByDcid(com.sunway.vo.Pgt12002)
	 */
	
	@Override
	public Boolean GetTdsyqbmByDcid(Pgt12002 t12002) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_120022(?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			// 注册输入参数
			call.setString(2, t12002.getDcid());
			call.setString(3, t12002.getTdsyqbm());
			call.execute();
			if((Integer)call.getObject(1)>0) bResult = true;
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12002DAO#LoadTDZL(com.sunway.vo.Pgv12002)
	 */
	
	@Override
	public ArrayList<String> LoadTDZL(Pgv12002 v12002) throws Exception {
		ArrayList<String> listResult = new ArrayList<String>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120021(?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, v12002.getPageIndex());
			call.setInt(3, v12002.getPageSize());
			call.setString(4, v12002.getCd00001Tdyt());
			call.setString(5, v12002.getTdzl());
			call.setString(6, v12002.getCd00001Szqy());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(rs.getString(1));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12002DAO#LoadTDDJ(com.sunway.vo.Pgv12002)
	 */
	
	@Override
	public Pgv12002 LoadTDDJ(Pgv12002 v12002) throws Exception {
		Pgv12002 listResult = new Pgv12002();
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_120021(?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			call.registerOutParameter(2, OracleTypes.VARCHAR);
			//傳入輸入參數
			call.setString(3, v12002.getCd00001Tdyt());
			call.setString(4, v12002.getTdzl());
			call.setString(5, v12002.getCd00001Szqy());
			call.execute();
			//返回數據集
			listResult.setCd00001Tddj((String)call.getObject(1)); 
			listResult.setTddj((String)call.getObject(2));
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt12002DAO#LoadPgv120025(com.sunway.vo.Pgv12002)
	 */
	
	@Override
	public Pgv12002 LoadPgv120025(Pgv12002 v12002) throws Exception {
		Pgv12002 listResult = new Pgv12002();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120025(?,?,?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(3, v12002.getPageIndex());
			call.setInt(4, v12002.getPageSize());
			call.setString(5, v12002.getDcid());
			call.setString(6, v12002.getCd12001Swid());
			call.setString(7, v12002.getNsrmc());
			call.setString(8, v12002.getSysSsgx());
			call.setString(9, v12002.getSysPssd());
			call.setInt(10, v12002.getCbzt());
			call.setInt(11, v12002.getSyzt());
			call.execute();
			//返回列合
			rsSum = (ResultSet) call.getObject(2); 
			while(null!=rsSum && rsSum.next()){
				listResult.setSumMsmj(rsSum.getDouble(sumMsmj));
				listResult.setSumSyqmj(rsSum.getDouble(sumSyqmj));
				listResult.setSumYsmj(rsSum.getDouble(sumYsmj));
				listResult.setAvgGbrjl(rsSum.getDouble(avgGbrjl));
				listResult.setAvgTdpfmse(rsSum.getDouble(avgTdpfmse));
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
				listResult.getV12002List().add(SetV12002Parameters(rs));
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
	protected Pgv12002 SetV12002Parameters(ResultSet rs) throws Exception {
		Pgv12002 e = new Pgv12002();
		e.setDcid(rs.getString(dcid));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setTdsyqbm(rs.getString(tdsyqbm));
		e.setCd00001Tdyt(rs.getString(cd00001Tdyt));
		e.setCd00001Syqlx(rs.getString(cd00001Syqlx));
		e.setSyqmj(rs.getDouble(syqmj));
		e.setCd00001Tdsyqlx(rs.getString(cd00001Tdsyqlx));
		e.setCd00001Tddj(rs.getString(cd00001Tddj));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setTdzl(rs.getString(tdzl));
		e.setGbrjl(rs.getDouble(gbrjl));
		e.setYsmj(rs.getDouble(ysmj));
		e.setMsmj(rs.getDouble(msmj));
		e.setTdpfmse(rs.getDouble(tdpfmse));
		e.setX(rs.getDouble(x));
		e.setY(rs.getDouble(y));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setSykssj(rs.getDate(sykssj));
		e.setSyjssj(rs.getDate(syjssj));
		e.setNsrmc(rs.getString(nsrmc));
		e.setTdsyqlx(rs.getString(tdsyqlx));
		e.setTdyt(rs.getString(tdyt));
		e.setSyqlx(rs.getString(syqlx));
		e.setTddj(rs.getString(tddj));
		e.setSzqy(rs.getString(szqy));
		e.setCzr(rs.getString(czr));
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		e.setUpddate(rs.getTimestamp(upddate));
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
