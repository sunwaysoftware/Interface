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

import com.sunway.dao.IPgt12003DAO;
import com.sunway.util.Common;
import com.sunway.vo.Pgt12003;
import com.sunway.vo.Pgv12003;

/**
 * 
 * 成本法、收益法房地产信息
 * @author Andy.Gao
 *
 */
public class Pgt12003DAO extends BaseDAO implements IPgt12003DAO {

	// property constants
	private static final String fcid = "FCID";					//"房产编码"
	private static final String cd12002Dcid = "CD_12002_DCID";	//地产编码
	private static final String cd12001Swid = "CD_12001_SWID";	//税务登记代码
	private static final String fdcmc = "FDCMC";				//房地产名称
	private static final String fwzldz = "FWZLDZ";				//房屋座落地址
	private static final String cd00001Qdfs = "CD_00001_QDFS";	//取得方式
	private static final String jcnf = "JCNF";					//建成年份
	private static final String fwzcs = "FWZCS";				//房屋总层数
	private static final String ds = "DS";						//地上
	private static final String dx = "DX";						//地下
	private static final String zjzmj = "ZJZMJ";				//总建筑面积(平方米) 
	private static final String fcyz = "FCYZ";					//房产原值(元)
	private static final String fwzjje = "FWZJJE";				//房屋租金收入(元)
	private static final String fczh = "FCZH";					//房产证号
	private static final String ysfcyz = "YSFCYZ";				//其中应税房产原值(元) 
	private static final String msfcyz = "MSFCYZ";				//其中免税房产原值(元) 
	private static final String qdsj = "QDSJ";					//房屋取得时间
	private static final String lrdate = "LRDATE";				//入库日期
	private static final String upddate = "UPDDATE";			//更新时间
	private static final String cd00002Czr = "CD_00002_CZR";	//录入人
	private static final String note = "NOTE";					//备注信息
	private static final String nsrmc = "NSRMC";
	private static final String czr = "CZR";
	private static final String qdfs = "QDFS";
	private static final String recordCount = "TOTAL";
	private static final String recordIndex = "RID";  
    private static final String sumZjzmj = "SUM_ZJZMJ";
    private static final String sumFcyz = "SUM_FCYZ";
    private static final String sumFwzjje = "SUM_FWZJJE";
    private static final String sumYsfcyz = "SUM_YSFCYZ";
    private static final String sumMsfcyz = "SUM_MSFCYZ";
    private static final String cd00001Ssgx = "CD_00001_SSGX";
    private static final String cd00001Szqy = "cd_00001_szqy";
    private static final String mxCount = "MXCount";
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
	 * @see com.sunway.dao.IPgt12003DAO#GetDeleteCommand(com.sunway.vo.Pgt12003)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt12003 t12003) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12003(?,?,?,?,?)}");
			call.setString(1, t12003.getFcid());
			call.setString(2, t12003.getCd00002Czr());
			call.setString(3, t12003.getSysSsgx());
			call.setDate(4, Common.converDate(t12003.getBgsj()));
			call.setInt(5, t12003.getBglx());
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
	 * @see com.sunway.dao.IPgt12003DAO#GetInsertCommand(com.sunway.vo.Pgt12003)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt12003 t12003) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT12003(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, t12003.getFcid());
			call.setString(2, t12003.getCd12002Dcid());
			call.setString(3, t12003.getCd12001Swid());
			call.setString(4, t12003.getFdcmc());
			call.setString(5, t12003.getFwzldz());
			call.setString(6, t12003.getCd00001Qdfs());
			call.setString(7, t12003.getJcnf());
			call.setShort(8, t12003.getFwzcs());
			call.setShort(9, t12003.getDs());
			call.setShort(10, t12003.getDx());
			call.setDouble(11, t12003.getZjzmj());
			call.setBigDecimal(12, t12003.getFcyz());
			call.setDouble(13, t12003.getFwzjje());
			call.setString(14, t12003.getFczh());
			call.setBigDecimal(15, t12003.getYsfcyz());
			call.setBigDecimal(16, t12003.getMsfcyz());
			call.setDate(17, Common.converDate(t12003.getQdsj()));
			call.setString(18, t12003.getCd00002Czr());
			call.setString(19, t12003.getNote());
			call.setString(20, t12003.getCd12006Czrzjh());
			call.setString(21, t12003.getCzrmc());
			call.setBoolean(22, t12003.getSfnsr());
			call.setDate(23, Common.converDate(t12003.getCzkssj()));
			call.setDate(24, Common.converDate(t12003.getCzjssj()));
			call.setString(25, t12003.getSysSsgx());
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
	 * @see com.sunway.dao.IPgt12003DAO#GetUpdateCommand(com.sunway.vo.Pgt12003)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt12003 t12003) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT12003(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, t12003.getFcid());
			call.setString(2, t12003.getCd12002Dcid());
			call.setString(3, t12003.getCd12001Swid());
			call.setString(4, t12003.getFdcmc());
			call.setString(5, t12003.getFwzldz());
			call.setString(6, t12003.getCd00001Qdfs());
			call.setString(7, t12003.getJcnf());
			call.setShort(8, t12003.getFwzcs());
			call.setShort(9, t12003.getDs());
			call.setShort(10, t12003.getDx());
			call.setDouble(11, t12003.getZjzmj());
			call.setBigDecimal(12, t12003.getFcyz());
			call.setDouble(13, t12003.getFwzjje());
			call.setString(14, t12003.getFczh());
			call.setBigDecimal(15, t12003.getYsfcyz());
			call.setBigDecimal(16, t12003.getMsfcyz());
			call.setDate(17, Common.converDate(t12003.getQdsj()));
			call.setString(18, t12003.getCd00002Czr());
			call.setString(19, t12003.getNote());
			call.setString(20, t12003.getSysSsgx());
			call.setDate(21, Common.converDate(t12003.getBgsj()));
			call.setInt(22, t12003.getBglx());
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
	 * @see com.sunway.dao.IPgt12003DAO#LoadAll(com.sunway.vo.Pgv12003)
	 */
	
	@Override
	public Pgv12003 LoadAll(Pgv12003 v12003) throws Exception {
		Pgv12003 listResult = new Pgv12003();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12003(?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(3, v12003.getPageIndex());
			call.setInt(4, v12003.getPageSize());
			call.setString(5, v12003.getFcid());
			call.setString(6, v12003.getCd12001Swid());
			call.setString(7, v12003.getNsrmc());
			call.setString(8, v12003.getSysSsgx());
			call.setString(9, v12003.getSysPssd());
			call.execute();
			//返回列合
			rsSum = (ResultSet) call.getObject(2); 
			while(null!=rsSum && rsSum.next()){
				listResult.setSumFcyz(rsSum.getDouble(sumFcyz));
				listResult.setSumFwzjje(rsSum.getDouble(sumFwzjje));
				listResult.setSumMsfcyz(rsSum.getDouble(sumMsfcyz));
				listResult.setSumYsfcyz(rsSum.getDouble(sumYsfcyz));
				listResult.setSumZjzmj(rsSum.getDouble(sumZjzmj));
			}
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.getV12003List().add(SetVParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rsSum, rsSum, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12003DAO#LoadByPrimaryKey(com.sunway.vo.Pgt12003)
	 */
	
	@Override
	public Pgt12003 LoadByPrimaryKey(Pgt12003 t12003) throws Exception {
		ArrayList<Pgt12003> listResult = new ArrayList<Pgt12003>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT12003(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, t12003.getFcid());
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
	 * @see com.sunway.dao.IPgt12003DAO#LoadMaxFcId()
	 */
	
	@Override
	public String LoadMaxFcId() throws Exception {
		String resultValue = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{? = call fn_getfcid()}");
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
	 * @see com.sunway.dao.IPgt12003DAO#LoadDetail(com.sunway.vo.Pgv12003)
	 */
	
	@Override
	public Pgv12003 LoadDetail(Pgv12003 v12003) throws Exception {
		ArrayList<Pgv12003> listResult = new ArrayList<Pgv12003>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120030(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v12003.getFcid());
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
			return new Pgv12003();
		}
	}

	/**
	 * Table数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt12003 SetTParameters(ResultSet rs) throws Exception {
		Pgt12003 e = new Pgt12003();
		e.setCd00001Qdfs(rs.getString(cd00001Qdfs));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setCd12002Dcid(rs.getString(cd12002Dcid));
		e.setDs(rs.getShort(ds));
		e.setDx(rs.getShort(dx));
		e.setFcid(rs.getString(fcid));
		e.setFcyz(rs.getBigDecimal(fcyz));
		e.setFczh(rs.getString(fczh));
		e.setFdcmc(rs.getString(fdcmc));
		e.setFwzcs(rs.getShort(fwzcs));
		e.setFwzjje(rs.getDouble(fwzjje));
		e.setFwzldz(rs.getString(fwzldz));
		e.setJcnf(rs.getString(jcnf));
		e.setLrdate(rs.getTimestamp(lrdate));
		e.setMsfcyz(rs.getBigDecimal(msfcyz));
		e.setNote(rs.getString(note));
		e.setQdsj(rs.getDate(qdsj));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setYsfcyz(rs.getBigDecimal(ysfcyz));
		e.setZjzmj(rs.getDouble(zjzmj));
		e.setQdfs(rs.getString(qdfs));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCountMX(rs.getInt(mxCount));  
		return e;
	}	

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv12003 SetVParameters(ResultSet rs) throws Exception {
		Pgv12003 e = new Pgv12003();
		e.setCd00001Qdfs(rs.getString(cd00001Qdfs));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setCd12002Dcid(rs.getString(cd12002Dcid));
		e.setCzr(rs.getString(czr));
		e.setDs(rs.getShort(ds));
		e.setDx(rs.getShort(dx));
		e.setFcid(rs.getString(fcid));
		e.setFcyz(rs.getDouble(fcyz));
		e.setFczh(rs.getString(fczh));
		e.setFdcmc(rs.getString(fdcmc));
		e.setFwzcs(rs.getShort(fwzcs));
		e.setFwzjje(rs.getDouble(fwzjje));
		e.setFwzldz(rs.getString(fwzldz));
		e.setJcnf(rs.getString(jcnf));
		e.setLrdate(rs.getTimestamp(lrdate));
		e.setMsfcyz(rs.getDouble(msfcyz));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setQdfs(rs.getString(qdfs));
		e.setQdsj(rs.getDate(qdsj));
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setYsfcyz(rs.getDouble(ysfcyz));
		e.setZjzmj(rs.getDouble(zjzmj));
		e.setZpCount(rs.getInt(zpCount));
		return e;
	}

	/**
	 * Detail数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv12003 SetDParameters(ResultSet rs) throws Exception {
		Pgv12003 e = new Pgv12003();
		e.setFcid(rs.getString(fcid));
		e.setCd12002Dcid(rs.getString(cd12002Dcid));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setFdcmc(rs.getString(fdcmc));
		e.setFwzldz(rs.getString(fwzldz));
		e.setCd00001Qdfs(rs.getString(cd00001Qdfs));
		e.setJcnf(rs.getString(jcnf));
		e.setFwzcs(rs.getShort(fwzcs));
		e.setDs(rs.getShort(ds));
		e.setDx(rs.getShort(dx));
		e.setZjzmj(rs.getDouble(zjzmj));
		e.setFcyz(rs.getDouble(fcyz));
		e.setFwzjje(rs.getDouble(fwzjje));
		e.setFczh(rs.getString(fczh));
		e.setYsfcyz(rs.getDouble(ysfcyz));
		e.setMsfcyz(rs.getDouble(msfcyz));
		e.setQdsj(rs.getDate(qdsj));
		e.setLrdate(rs.getTimestamp(lrdate));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCzr(rs.getString(czr));
		e.setQdfs(rs.getString(qdfs));
		e.setZpCount(rs.getInt(zpCount));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12003DAO#GetFczhByFcid(com.sunway.vo.Pgt12002)
	 */
	
	@Override
	public Boolean GetFczhByFcid(Pgt12003 t12003) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_120032(?,?,?)}");
			call.registerOutParameter(1, OracleTypes.INTEGER);
			call.setString(2, t12003.getFcid());
			call.setString(3, t12003.getFczh());
			call.execute();
			if(call.getInt(1)>0)
				bResult = true;
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12003DAO#LoadFWZLDZ(com.sunway.vo.Pgv12003)
	 */
	
	@Override
	public ArrayList<String> LoadFWZLDZ(Pgv12003 v12003) throws Exception {
		ArrayList<String> listResult = new ArrayList<String>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120031(?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, v12003.getPageIndex());
			call.setInt(3, v12003.getPageSize());
			call.setString(4, v12003.getFwzldz());
			call.setString(5, v12003.getCd00001Szqy());
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

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt12003DAO#LoadPgv120035(com.sunway.vo.Pgv12003)
	 */
	
	@Override
	public Pgv12003 LoadPgv120035(Pgv12003 v12003) throws Exception {
		Pgv12003 listResult = new Pgv12003();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120035(?,?,?,?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(3, v12003.getPageIndex());
			call.setInt(4, v12003.getPageSize());
			call.setString(5, v12003.getCd12002Dcid());
			call.setString(6, v12003.getFcid());
			call.setString(7, v12003.getCd12001Swid());
			call.setString(8, v12003.getNsrmc());
			call.setString(9, v12003.getSysSsgx());
			call.setString(10, v12003.getSysPssd());
			call.setInt(11, v12003.getCbzt());
			call.setInt(12, v12003.getSyzt());
			call.execute();
			//返回列合
			rsSum = (ResultSet) call.getObject(2); 
			while(null!=rsSum && rsSum.next()){
				listResult.setSumFcyz(rsSum.getDouble(sumFcyz));
				listResult.setSumFwzjje(rsSum.getDouble(sumFwzjje));
				listResult.setSumMsfcyz(rsSum.getDouble(sumMsfcyz));
				listResult.setSumYsfcyz(rsSum.getDouble(sumYsfcyz));
				listResult.setSumZjzmj(rsSum.getDouble(sumZjzmj));
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
				listResult.getV12003List().add(SetV12003Parameters(rs));
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
	protected Pgv12003 SetV12003Parameters(ResultSet rs) throws Exception {
		Pgv12003 e = new Pgv12003();
		e.setCd00001Qdfs(rs.getString(cd00001Qdfs));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setCd12001Swid(rs.getString(cd12001Swid));
		e.setCd12002Dcid(rs.getString(cd12002Dcid));
		e.setCzr(rs.getString(czr));
		e.setDs(rs.getShort(ds));
		e.setDx(rs.getShort(dx));
		e.setFcid(rs.getString(fcid));
		e.setFcyz(rs.getDouble(fcyz));
		e.setFczh(rs.getString(fczh));
		e.setFdcmc(rs.getString(fdcmc));
		e.setFwzcs(rs.getShort(fwzcs));
		e.setFwzjje(rs.getDouble(fwzjje));
		e.setFwzldz(rs.getString(fwzldz));
		e.setJcnf(rs.getString(jcnf));
		e.setLrdate(rs.getTimestamp(lrdate));
		e.setMsfcyz(rs.getDouble(msfcyz));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setQdfs(rs.getString(qdfs));
		e.setQdsj(rs.getDate(qdsj));
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setYsfcyz(rs.getDouble(ysfcyz));
		e.setZjzmj(rs.getDouble(zjzmj));
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
