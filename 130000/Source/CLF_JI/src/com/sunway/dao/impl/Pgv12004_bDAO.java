package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgv12004_bDAO;
import com.sunway.vo.Pgv12004_b;

/**
 * 明细信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv12004_bDAO extends BaseDAO implements IPgv12004_bDAO {

	private static final String total = "TOTAL";
	private static final String rid = "RID";
	private static final String mxid = "MXID";
	private static final String cd12003BFcid = "CD_12003_B_FCID";
	private static final String cd12002BDcid = "CD_12002_B_DCID";
	private static final String cd12001BSwid = "CD_12001_B_SWID";
	private static final String fdcmc = "FDCMC";
	private static final String szcc = "SZCC";
	private static final String bwjfh = "BWJFH";
	private static final String cd00001Jzjg = "CD_00001_JZJG";
	private static final String cd00001Fwyt = "CD_00001_FWYT";
	private static final String ytjzmj = "YTJZMJ";
	private static final String fcyz = "FCYZ";
	private static final String cd00001Xjbz = "CD_00001_XJBZ";
	private static final String cd00001Fwcx = "CD_00001_FWCX";
	private static final String lrdate = "LRDATE";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String cd12053Ddid = "CD_12053_DDID";
	private static final String gytzj = "GYTZJ";
	private static final String cd00001Mssz = "CD_00001_MSSZ";
	private static final String cd00002Pssd = "CD_00002_PSSD";
	private static final String ddnm = "DDNM";
	private static final String nsrmc = "NSRMC";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String czr = "CZR";
	private static final String jzjg = "JZJG";
	private static final String xjbz = "XJBZ";
	private static final String fwcx = "FWCX";
	private static final String fwyt = "FWYT";
	private static final String mssz = "MSSZ";
	private static final String cbzt = "CBZT";
	private static final String syzt = "SYZT";
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
	private static final String sumYtjzmj = "SUM_YTJZMJ";
	private static final String sumFcyz = "SUM_FCYZ";
	private static final String sumGytzj = "SUM_GYTZJ";
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
	 * @see com.sunway.dao.IPgv12004_bDAO#LoadAll(com.sunway.vo.Pgv12004_b)
	 */
	
	@Override
	public Pgv12004_b LoadAll(Pgv12004_b v12004_b) throws Exception {
		Pgv12004_b listResult = new Pgv12004_b();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12004_B(?,?,?,?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(3, v12004_b.getPageIndex());
			call.setInt(4, v12004_b.getPageSize());
			call.setString(5, v12004_b.getCd12002BDcid());
			call.setString(6, v12004_b.getCd12001BSwid());
			call.setString(7, v12004_b.getNsrmc());
			call.setString(8, v12004_b.getMxid());
			call.setString(9, v12004_b.getCd00001Ssgx());
			call.setString(10, v12004_b.getCd00002Pssd());
			call.setInt(11, v12004_b.getCbzt());
			call.setInt(12, v12004_b.getSyzt());
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
				listResult.getV12004_bList().add(SetVParameters(rs));
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
	 * @see com.sunway.dao.IPgv12004_bDAO#LoadDetail(com.sunway.vo.Pgv12004_b)
	 */
	
	@Override
	public Pgv12004_b LoadDetail(Pgv12004_b v12004_b) throws Exception {
		ArrayList<Pgv12004_b> listResult = new ArrayList<Pgv12004_b>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12004_B0(?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v12004_b.getMxid());
			call.setString(3, v12004_b.getCd00002Pssd());
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
			return new Pgv12004_b();
		}
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv12004_b SetVParameters(ResultSet rs) throws Exception {
		Pgv12004_b e = new Pgv12004_b();
		e.setRecordCount(rs.getInt(total));
		e.setRecordIndex(rs.getInt(rid));
		e.setBwjfh(rs.getString(bwjfh));
		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
		e.setCd00001Fwyt(rs.getString(cd00001Fwyt));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setCd00001Xjbz(rs.getString(cd00001Xjbz));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setCd12001BSwid(rs.getString(cd12001BSwid));
		e.setCd12002BDcid(rs.getString(cd12002BDcid));
		e.setCd12003BFcid(rs.getString(cd12003BFcid));
		e.setCd12053Ddid(rs.getString(cd12053Ddid));
		e.setFcyz(rs.getDouble(fcyz));
		e.setFdcmc(rs.getString(fdcmc));
		e.setGytzj(rs.getDouble(gytzj));
		e.setCd00001Mssz(rs.getString(cd00001Mssz));
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
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
		e.setMssz(rs.getString(mssz));
		e.setDdnm(rs.getString(ddnm));
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
	protected Pgv12004_b SetDParameters(ResultSet rs) throws Exception {
		Pgv12004_b e = new Pgv12004_b();
		e.setMxid(rs.getString(mxid));
		e.setCd12003BFcid(rs.getString(cd12003BFcid));
		e.setCd12002BDcid(rs.getString(cd12002BDcid));
		e.setCd12001BSwid(rs.getString(cd12001BSwid));
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
}
