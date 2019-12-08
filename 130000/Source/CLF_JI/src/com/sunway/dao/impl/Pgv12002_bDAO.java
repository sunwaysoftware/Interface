package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgv12002_bDAO;
import com.sunway.vo.Pgv12002_b;

/**
 * 地产信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv12002_bDAO extends BaseDAO implements IPgv12002_bDAO {

	private static final String recordCount = "TOTAL";
	private static final String recordIndex = "RID";
	private static final String dcid="DCID";
	private static final String cd12001BSwid="CD_12001_B_SWID";
	private static final String tdsyqbm="TDSYQBM";
	private static final String cd00001Tdyt="CD_00001_TDYT";
	private static final String cd00001Syqlx="CD_00001_SYQLX";
	private static final String syqmj="SYQMJ";
	private static final String cd00001Tdsyqlx="CD_00001_TDSYQLX";
	private static final String cd12054Tddjid="CD_12054_TDDJID";
	private static final String cd00001Szqy="CD_00001_SZQY";
	private static final String tdzl="TDZL";
	private static final String gbrjl="GBRJL";
	private static final String ysmj="YSMJ";
	private static final String msmj="MSMJ";
	private static final String tdpfmse="TDPFMSE";
	private static final String x="X";
	private static final String y="Y";
	private static final String lrdate="LRDATE";
	private static final String upddate="UPDDATE";
	private static final String cd00002Czr="CD_00002_CZR";
	private static final String note="NOTE";
	private static final String sykssj="SYKSSJ";
	private static final String syjssj="SYJSSJ";
	private static final String cd00002Pssd="CD_00002_PSSD";
	private static final String cd00001Ssgx="CD_00001_SSGX";
	private static final String nsrmc="NSRMC";
	private static final String tdsyqlx="TDSYQLX";
	private static final String tdyt="TDYT";
	private static final String syqlx="SYQLX";
	private static final String tddj="TDDJ";
	private static final String szqy="SZQY";
	private static final String czr="CZR";
	private static final String cbzt = "CBZT";
	private static final String syzt = "SYZT";
	private static final String zpCount="ZPCOUNT";
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
	private static final String sumSyqmj="SUM_SYQMJ";
	private static final String avgGbrjl="AVG_GBRJL";
	private static final String sumYsmj="SUM_YSMJ";
	private static final String sumMsmj="SUM_MSMJ";
	private static final String avgTdpfmse="AVG_TDPFMSE";
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
	 * @see com.sunway.dao.IPgv12002_bDAO#LoadAll(com.sunway.vo.Pgv12002_b)
	 */
	
	@Override
	public Pgv12002_b LoadAll(Pgv12002_b v12002_b) throws Exception {
		Pgv12002_b listResult = new Pgv12002_b();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12002_B(?,?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(3, v12002_b.getPageIndex());
			call.setInt(4, v12002_b.getPageSize());
			call.setString(5, v12002_b.getCd12001BSwid());
			call.setString(6, v12002_b.getNsrmc());
			call.setString(7, v12002_b.getCd00001Ssgx());
			call.setString(8, v12002_b.getCd00002Pssd());
			call.setInt(9, v12002_b.getCbzt());
			call.setInt(10, v12002_b.getSyzt());
			call.execute();
			//返回列合
			rsSum = (ResultSet) call.getObject(2); 
			while(null!=rsSum && rsSum.next()){
				listResult.setSumSyqmj(rsSum.getDouble(sumSyqmj));
				listResult.setAvgGbrjl(rsSum.getDouble(avgGbrjl));
				listResult.setSumYsmj(rsSum.getDouble(sumYsmj));
				listResult.setSumMsmj(rsSum.getDouble(sumMsmj));
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
				listResult.getV12002_bList().add(SetVParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rsSum, rsSum, call, conn, session);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgv12002_bDAO#LoadDetail(com.sunway.vo.Pgv12002_b)
	 */
	
	@Override
	public Pgv12002_b LoadDetail(Pgv12002_b v12002_b) throws Exception {
		ArrayList<Pgv12002_b> listResult = new ArrayList<Pgv12002_b>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12002_B0(?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v12002_b.getDcid());
			call.setString(3, v12002_b.getCd00002Pssd());
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
			return new Pgv12002_b();
		}
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv12002_b SetVParameters(ResultSet rs) throws Exception {
		Pgv12002_b e = new Pgv12002_b();
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		e.setDcid(rs.getString(dcid));
		e.setCd12001BSwid(rs.getString(cd12001BSwid));
		e.setTdsyqbm(rs.getString(tdsyqbm));
		e.setCd00001Tdyt(rs.getString(cd00001Tdyt));
		e.setCd00001Syqlx(rs.getString(cd00001Syqlx));
		e.setSyqmj(rs.getDouble(syqmj));
		e.setCd00001Tdsyqlx(rs.getString(cd00001Tdsyqlx));
		e.setCd12054Tddjid(rs.getString(cd12054Tddjid));
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
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setNsrmc(rs.getString(nsrmc));
		e.setTdsyqlx(rs.getString(tdsyqlx));
		e.setTdyt(rs.getString(tdyt));
		e.setSyqlx(rs.getString(syqlx));
		e.setTddj(rs.getString(tddj));
		e.setSzqy(rs.getString(szqy));
		e.setCzr(rs.getString(czr));
		e.setCbzt(rs.getInt(cbzt));
		e.setSyzt(rs.getInt(syzt));
		e.setZpCount(rs.getInt(zpCount));
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
	protected Pgv12002_b SetDParameters(ResultSet rs) throws Exception {
		Pgv12002_b e = new Pgv12002_b();
		e.setDcid(rs.getString(dcid));
		e.setCd12001BSwid(rs.getString(cd12001BSwid));
		e.setTdsyqbm(rs.getString(tdsyqbm));
		e.setCd00001Tdyt(rs.getString(cd00001Tdyt));
		e.setCd00001Syqlx(rs.getString(cd00001Syqlx));
		e.setSyqmj(rs.getDouble(syqmj));
		e.setCd00001Tdsyqlx(rs.getString(cd00001Tdsyqlx));
		e.setCd12054Tddjid(rs.getString(cd12054Tddjid));
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
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
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
}
