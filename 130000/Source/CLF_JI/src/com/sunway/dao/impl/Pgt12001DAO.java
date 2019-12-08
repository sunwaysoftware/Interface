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

import com.sunway.dao.IPgt12001DAO;
import com.sunway.util.Common;
import com.sunway.vo.Pgt12001;
import com.sunway.vo.Pgv12001;

/**
 * 
 * 成本、收益法登记信息
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt12001DAO extends BaseDAO implements IPgt12001DAO {

	// property constants
	private static final String swid = "SWID";					//税务登记代码
	private static final String nsrmc = "NSRMC";				//纳税人名称
	private static final String cd00001Ssgx = "CD_00001_SSGX";	//税收管辖
	private static final String lxdh = "LXDH";					//联系电话
	private static final String zgy = "ZGY";					//专管员
	private static final String cd00001Hy = "CD_00001_HY";		//行业
	private static final String cd00001Jjlx = "CD_00001_JJLX";	//经济类型
	//private static final String zyywsr = "ZYYWSR";				//上年度主营业务收入(元)
	//private static final String lrze = "LRZE";					//上年利润总额(元)
	private static final String fcse = "FCSE";					//年应纳房产税税额(元)
	private static final String tdse = "TDSE";					//年应纳土地使用税税额(元)
	private static final String cd00001Mssz = "CD_00001_MSSZ";	//免税设置
	private static final String bh = "BH";						//表号
	private static final String cd00001Xz = "CD_00001_XZ";		//性质
	private static final String lrdate = "LRDATE";				//入库日期
	private static final String upddate = "UPDDATE";			//更新时间
	private static final String cd00002Czr = "CD_00002_CZR";	//录入人
	private static final String note = "NOTE";					//备注信息
	private static final String ssgx = "SSGX";
	private static final String hy = "HY";
	private static final String jjlx = "JJLX";
	private static final String mssz = "MSSZ";
	private static final String xz = "XZ";
	private static final String czr = "CZR";
	private static final String recordCount = "TOTAL";
	private static final String recordIndex = "RID";
	private static final String sumFcse = "SUM_FCSE";
	private static final String sumTdse = "SUM_TDSE";
	private static final String dcCount = "DCCount";
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
	 * @see com.sunway.dao.IPgt12001DAO#GetDeleteCommand(com.sunway.vo.Pgt12001)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt12001 t12001) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT12001(?,?,?,?,?)}");
			call.setString(1, t12001.getSwid());
			call.setString(2, t12001.getCd00002Czr());
			call.setString(3, t12001.getSsgx());
			call.setDate(4, Common.converDate(t12001.getBgsj()));
			call.setInt(5, t12001.getBglx());
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
	 * @see com.sunway.dao.IPgt12001DAO#GetInsertCommand(com.sunway.vo.Pgt12001)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt12001 t12001) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT12001(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, t12001.getSwid());
			call.setString(2, t12001.getNsrmc());
			call.setString(3, t12001.getCd00001Ssgx());
			call.setString(4, t12001.getLxdh());
			call.setString(5, t12001.getZgy());
			call.setString(6, t12001.getCd00001Hy());
			call.setString(7, t12001.getCd00001Jjlx());
			call.setDouble(8, t12001.getZyywsr());
			call.setDouble(9, t12001.getLrze());
			call.setBigDecimal(10, t12001.getFcse());
			call.setBigDecimal(11, t12001.getTdse());
			call.setString(12, t12001.getCd00001Mssz());
			call.setString(13, t12001.getBh());
			call.setString(14, t12001.getCd00001Xz());
			call.setString(15, t12001.getCd00002Czr());
			call.setString(16, t12001.getNote());
			call.setString(17, t12001.getSysPssd());
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
	 * @see com.sunway.dao.IPgt12001DAO#GetUpdateCommand(com.sunway.vo.Pgt12001)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt12001 t12001) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT12001(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, t12001.getSwidOld());
			call.setString(2, t12001.getNsrmc());
			call.setString(3, t12001.getCd00001Ssgx());
			call.setString(4, t12001.getLxdh());
			call.setString(5, t12001.getZgy());
			call.setString(6, t12001.getCd00001Hy());
			call.setString(7, t12001.getCd00001Jjlx());
			call.setDouble(8, t12001.getZyywsr());
			call.setDouble(9, t12001.getLrze());
			call.setBigDecimal(10, t12001.getFcse());
			call.setBigDecimal(11, t12001.getTdse());
			call.setString(12, t12001.getCd00001Mssz());
			call.setString(13, t12001.getBh());
			call.setString(14, t12001.getCd00001Xz());
			call.setString(15, t12001.getCd00002Czr());
			call.setString(16, t12001.getNote());
			call.setDate(17, Common.converDate(t12001.getBgsj()));
			call.setInt(18, t12001.getBglx());
			call.setString(19, t12001.getSwid());
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
	 * @see com.sunway.dao.IPgt12001DAO#LoadAll(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public Pgv12001 LoadAll(Pgv12001 v12001) throws Exception {
		Pgv12001 listResult = new Pgv12001();
		ResultSet rs = null;
		ResultSet rsSum = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12001(?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(3, v12001.getPageIndex());
			call.setInt(4, v12001.getPageSize());
			call.setString(5, v12001.getSwid());
			call.setString(6, v12001.getNsrmc());
			call.setString(7, v12001.getSysSsgx());
			call.setString(8, v12001.getBh());
			call.setString(9, v12001.getSysPssd());
			call.execute();
			//返回列合
			rsSum = (ResultSet) call.getObject(2); 
			while(null!=rsSum && rsSum.next()){
				listResult.setSumFcse(rsSum.getDouble(sumFcse));
				listResult.setSumTdse(rsSum.getDouble(sumTdse));
			}
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.getV12001List().add(SetVParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rsSum, rs, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12001DAO#LoadByPrimaryKey(com.sunway.vo.Pgt12001)
	 */
	
	@Override
	public Pgt12001 LoadByPrimaryKey(Pgt12001 t12001) throws Exception {
		ArrayList<Pgt12001> listResult = new ArrayList<Pgt12001>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT12001(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, t12001.getSwid());
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
	 * @see com.sunway.dao.IPgt12001DAO#LoadDetail(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public Pgv12001 LoadDetail(Pgv12001 v12001) throws Exception {
		ArrayList<Pgv12001> listResult = new ArrayList<Pgv12001>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120010(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v12001.getSwid());
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
			return new Pgv12001();
		}
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv12001 SetVParameters(ResultSet rs) throws Exception {
		Pgv12001 e = new Pgv12001();
		e.setBh(rs.getString(bh));
		e.setCd00001Hy(rs.getString(cd00001Hy));
		e.setCd00001Jjlx(rs.getString(cd00001Jjlx));
		e.setCd00001Mssz(rs.getString(cd00001Mssz));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00001Xz(rs.getString(cd00001Xz));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setCzr(rs.getString(czr));
		e.setFcse(rs.getDouble(fcse));
		e.setHy(rs.getString(hy));
		e.setJjlx(rs.getString(jjlx));
		e.setLrdate(rs.getTimestamp(lrdate));
		//e.setLrze(rs.getDouble(lrze));
		e.setLxdh(rs.getString(lxdh));
		e.setMssz(rs.getString(mssz));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		e.setSsgx(rs.getString(ssgx));
		e.setSwid(rs.getString(swid));
		e.setTdse(rs.getDouble(tdse));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setXz(rs.getString(xz));
		e.setZgy(rs.getString(zgy));
		//e.setZyywsr(rs.getDouble(zyywsr));
		return e;
	}
	
	/**
	 * Table数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt12001 SetTParameters(ResultSet rs) throws Exception {
		Pgt12001 e = new Pgt12001();
		e.setBh(rs.getString(bh));
		e.setCd00001Hy(rs.getString(cd00001Hy));
		e.setCd00001Jjlx(rs.getString(cd00001Jjlx));
		e.setCd00001Mssz(rs.getString(cd00001Mssz));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00001Xz(rs.getString(cd00001Xz));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setFcse(rs.getBigDecimal(fcse));
		e.setLrdate(rs.getTimestamp(lrdate));
		//e.setLrze(rs.getDouble(lrze));
		e.setLxdh(rs.getString(lxdh));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setSwid(rs.getString(swid));
		e.setTdse(rs.getBigDecimal(tdse));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setZgy(rs.getString(zgy));
		//e.setZyywsr(rs.getDouble(zyywsr));
		e.setSsgx(rs.getString(ssgx));
		e.setHy(rs.getString(hy));
		e.setJjlx(rs.getString(jjlx));
		e.setMssz(rs.getString(mssz));
		e.setXz(rs.getString(xz));
		e.setCountDC(rs.getInt(dcCount));
		return e;
	}

	/**
	 * Detail数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv12001 SetDParameters(ResultSet rs) throws Exception {
		Pgv12001 e = new Pgv12001();
		e.setSwid(rs.getString(swid));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setLxdh(rs.getString(lxdh));
		e.setZgy(rs.getString(zgy));
		e.setCd00001Hy(rs.getString(cd00001Hy));
		e.setCd00001Jjlx(rs.getString(cd00001Jjlx));
//		e.setZyywsr(rs.getDouble(zyywsr));
//		e.setLrze(rs.getDouble(lrze));
		e.setFcse(rs.getDouble(fcse));
		e.setTdse(rs.getDouble(tdse));
		e.setCd00001Mssz(rs.getString(cd00001Mssz));
		e.setBh(rs.getString(bh));
		e.setCd00001Xz(rs.getString(cd00001Xz));
		e.setLrdate(rs.getTimestamp(lrdate));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setSsgx(rs.getString(ssgx));
		e.setHy(rs.getString(hy));
		e.setJjlx(rs.getString(jjlx));
		e.setMssz(rs.getString(mssz));
		e.setXz(rs.getString(xz));
		e.setCzr(rs.getString(czr));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12001DAO#LoadCount(com.sunway.vo.Pgt12001)
	 */
	
	@Override
	public Pgt12001 LoadCount(Pgt12001 t12001) throws Exception {
		Pgt12001 listResult = new Pgt12001();
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_120011(?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.INTEGER);
			call.registerOutParameter(2, OracleTypes.INTEGER);
			call.registerOutParameter(3, OracleTypes.INTEGER);
			//輸入參數
			call.setString(4, t12001.getSwid());
			call.execute();
			//返回數據集
			listResult.setCountDC((Integer) call.getObject(1)); 
			listResult.setCountFC((Integer) call.getObject(2));
			listResult.setCountMX((Integer) call.getObject(3));
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt12001DAO#LoadPgv120015(com.sunway.vo.Pgv12001)
	 */
	
	@Override
	public Pgv12001 LoadPgv120015(Pgv12001 v12001) throws Exception {
		Pgv12001 listResult = new Pgv12001();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT120015(?,?,?,?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(3, v12001.getPageIndex());
			call.setInt(4, v12001.getPageSize());
			call.setString(5, v12001.getCd12002Dcid());
			call.setString(6, v12001.getSysPssd());
			call.setString(7, v12001.getSwid());
			call.setString(8, v12001.getNsrmc());
			call.setString(9, v12001.getSysSsgx());
			call.setInt(10, v12001.getCbzt());
			call.setInt(11, v12001.getSyzt());
			call.execute();
			//返回列合
			rsSum = (ResultSet) call.getObject(2); 
			while(null!=rsSum && rsSum.next()){
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
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.getV12001List().add(SetV120015Parameters(rs));
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
	protected Pgv12001 SetV120015Parameters(ResultSet rs) throws Exception {
		Pgv12001 e = new Pgv12001();
		e.setBh(rs.getString(bh));
		e.setCd00001Hy(rs.getString(cd00001Hy));
		e.setCd00001Jjlx(rs.getString(cd00001Jjlx));
		e.setCd00001Mssz(rs.getString(cd00001Mssz));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00001Xz(rs.getString(cd00001Xz));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setCzr(rs.getString(czr));
		e.setFcse(rs.getDouble(fcse));
		e.setHy(rs.getString(hy));
		e.setJjlx(rs.getString(jjlx));
		e.setLrdate(rs.getTimestamp(lrdate));
		e.setLxdh(rs.getString(lxdh));
		e.setMssz(rs.getString(mssz));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		e.setSsgx(rs.getString(ssgx));
		e.setSwid(rs.getString(swid));
		e.setTdse(rs.getDouble(tdse));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setXz(rs.getString(xz));
		e.setZgy(rs.getString(zgy));
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
