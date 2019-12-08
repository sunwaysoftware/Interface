package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgv12001_bDAO;
import com.sunway.vo.Pgv12001_b;
import com.sunway.vo.PgvCzPssd;

/**
 * 登记信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv12001_bDAO extends BaseDAO implements IPgv12001_bDAO {

	private static final String recordCount = "TOTAL";
	private static final String recordIndex = "RID";
	private static final String swid = "SWID";
	private static final String nsrmc = "NSRMC";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String lxdh = "LXDH";
	private static final String zgy = "ZGY";
	private static final String cd00001Hy = "CD_00001_HY";
	private static final String cd00001Jjlx = "CD_00001_JJLX";
	private static final String fcse = "FCSE";
	private static final String tdse = "TDSE";
	private static final String cd00001Mssz = "CD_00001_MSSZ";
	private static final String bh = "BH";
	private static final String cd00001Xz = "CD_00001_XZ";
	private static final String lrdate = "LRDATE";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String cd00002Pssd = "CD_00002_PSSD";
	private static final String ssgx = "SSGX";
	private static final String hy = "HY";
	private static final String jjlx = "JJLX";
	private static final String mssz = "MSSZ";
	private static final String xz = "XZ";
	private static final String czr = "CZR";
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
	private static final String cbzt = "CBZT";
	private static final String syzt = "SYZT";
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

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgv12001_bDAO#LoadAll(com.sunway.vo.Pgv12001_b)
	 */
	
	@Override
	public Pgv12001_b LoadAll(Pgv12001_b v12001_b) throws Exception {
		Pgv12001_b listResult = new Pgv12001_b();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12001_B(?,?,?,?,?,?,?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(3, v12001_b.getPageIndex());
			call.setInt(4, v12001_b.getPageSize());
			call.setString(5, v12001_b.getCd00002Pssd());
			call.setString(6, v12001_b.getSwid());
			call.setString(7, v12001_b.getNsrmc());
			call.setString(8, v12001_b.getCd00001Ssgx());
			call.setInt(9, v12001_b.getCbzt());
			call.setInt(10, v12001_b.getSyzt());
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
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.getV12001_bList().add(SetVParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rsSum, rs, call, conn, session);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgv12001_bDAO#LoadPssd()
	 */
	
	@Override
	public ArrayList<PgvCzPssd> LoadPssd() throws Exception {
		ArrayList<PgvCzPssd> listResult = new ArrayList<PgvCzPssd>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_12000_B(?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				PgvCzPssd e = new PgvCzPssd();
				e.setCd00002Pssd(rs.getString(cd00002Pssd));
				listResult.add(e);
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
	 * @see com.sunway.dao.IPgv12001_bDAO#LoadDetail(com.sunway.vo.Pgv12001_b)
	 */
	
	@Override
	public Pgv12001_b LoadDetail(Pgv12001_b v12001_b) throws Exception {
		ArrayList<Pgv12001_b> listResult = new ArrayList<Pgv12001_b>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12001_B0(?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v12001_b.getSwid());
			call.setString(3, v12001_b.getCd00002Pssd());
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
			return new Pgv12001_b();
		}
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv12001_b SetVParameters(ResultSet rs) throws Exception {
		Pgv12001_b e = new Pgv12001_b();
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		e.setSwid(rs.getString(swid));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setLxdh(rs.getString(lxdh));
		e.setZgy(rs.getString(zgy));
		e.setCd00001Hy(rs.getString(cd00001Hy));
		e.setCd00001Jjlx(rs.getString(cd00001Jjlx));
		e.setFcse(rs.getDouble(fcse));
		e.setTdse(rs.getDouble(tdse));
		e.setCd00001Mssz(rs.getString(cd00001Mssz));
		e.setBh(rs.getString(bh));
		e.setCd00001Xz(rs.getString(cd00001Xz));
		e.setLrdate(rs.getTimestamp(lrdate));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setSsgx(rs.getString(ssgx));
		e.setHy(rs.getString(hy));
		e.setJjlx(rs.getString(jjlx));
		e.setMssz(rs.getString(mssz));
		e.setXz(rs.getString(xz));
		e.setCzr(rs.getString(czr));
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

	/**
	 * Detail数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv12001_b SetDParameters(ResultSet rs) throws Exception {
		Pgv12001_b e = new Pgv12001_b();
		e.setSwid(rs.getString(swid));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setLxdh(rs.getString(lxdh));
		e.setZgy(rs.getString(zgy));
		e.setCd00001Hy(rs.getString(cd00001Hy));
		e.setCd00001Jjlx(rs.getString(cd00001Jjlx));
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
}
