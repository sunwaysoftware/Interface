package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.IPgv12003_bDAO;
import com.sunway.vo.Pgv12003_b;

/**
 * 房产信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */
public class Pgv12003_bDAO extends BaseDAO implements IPgv12003_bDAO {

	private static final String recordCount = "TOTAL";
	private static final String recordIndex = "RID";
	private static final String fcid = "FCID";
	private static final String cd12002BDcid = "CD_12002_B_DCID";
	private static final String cd12001BSwid = "CD_12001_B_SWID";
	private static final String fdcmc = "FDCMC";
	private static final String fwzldz = "FWZLDZ";
	private static final String cd00001Qdfs = "CD_00001_QDFS";
	private static final String jcnf = "JCNF";
	private static final String fwzcs = "FWZCS";
	private static final String ds = "DS";
	private static final String dx = "DX";
	private static final String zjzmj = "ZJZMJ";
	private static final String fcyz = "FCYZ";
	private static final String fwzjje = "FWZJJE";
	private static final String fczh = "FCZH";
	private static final String ysfcyz = "YSFCYZ";
	private static final String msfcyz = "MSFCYZ";
	private static final String qdsj = "QDSJ";
	private static final String lrdate = "LRDATE";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String cd00002Pssd = "CD_00002_PSSD";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String nsrmc = "NSRMC";
	private static final String czr = "CZR";
	private static final String qdfs = "QDFS";
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
	private static final String sumZjzmj = "SUM_ZJZMJ";
	private static final String sumFcyz = "SUM_FCYZ";
	private static final String sumFwzjje = "SUM_FWZJJE";
	private static final String sumYsfcyz = "SUM_YSFCYZ";
	private static final String sumMsfcyz = "SUM_MSFCYZ";
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
	 * @see com.sunway.dao.IPgv12003_bDAO#LoadAll(com.sunway.vo.Pgv12003_b)
	 */
	
	@Override
	public Pgv12003_b LoadAll(Pgv12003_b v12003_b) throws Exception {
		Pgv12003_b listResult = new Pgv12003_b();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12003_B(?,?,?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(3, v12003_b.getPageIndex());
			call.setInt(4, v12003_b.getPageSize());
			call.setString(5, v12003_b.getFcid());
			call.setString(6, v12003_b.getCd12001BSwid());
			call.setString(7, v12003_b.getNsrmc());
			call.setString(8, v12003_b.getCd00001Ssgx());
			call.setString(9, v12003_b.getCd00002Pssd());
			call.setInt(10, v12003_b.getCbzt());
			call.setInt(11, v12003_b.getSyzt());
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
				listResult.getV12003_bList().add(SetVParameters(rs));
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
	 * @see com.sunway.dao.IPgv12003_bDAO#LoadDetail(com.sunway.vo.Pgv12003_b)
	 */
	
	@Override
	public Pgv12003_b LoadDetail(Pgv12003_b v12003_b) throws Exception {
		ArrayList<Pgv12003_b> listResult = new ArrayList<Pgv12003_b>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12003_B0(?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v12003_b.getFcid());
			call.setString(3, v12003_b.getCd00002Pssd());
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
			return new Pgv12003_b();
		}
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv12003_b SetVParameters(ResultSet rs) throws Exception {
		Pgv12003_b e = new Pgv12003_b();
		e.setRecordCount(rs.getInt(recordCount));
		e.setRecordIndex(rs.getInt(recordIndex));
		e.setCd00001Qdfs(rs.getString(cd00001Qdfs));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setCd12001BSwid(rs.getString(cd12001BSwid));
		e.setCd12002BDcid(rs.getString(cd12002BDcid));
		e.setCzr(rs.getString(czr));
		e.setDs(rs.getInt(ds));
		e.setDx(rs.getInt(dx));
		e.setFcid(rs.getString(fcid));
		e.setFcyz(rs.getDouble(fcyz));
		e.setFczh(rs.getString(fczh));
		e.setFdcmc(rs.getString(fdcmc));
		e.setFwzcs(rs.getInt(fwzcs));
		e.setFwzjje(rs.getDouble(fwzjje));
		e.setFwzldz(rs.getString(fwzldz));
		e.setJcnf(rs.getString(jcnf));
		e.setLrdate(rs.getTimestamp(lrdate));
		e.setMsfcyz(rs.getDouble(msfcyz));
		e.setNote(rs.getString(note));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00002Pssd(rs.getString(cd00002Pssd));
		e.setNsrmc(rs.getString(nsrmc));
		e.setQdfs(rs.getString(qdfs));
		e.setQdsj(rs.getDate(qdsj));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setYsfcyz(rs.getDouble(ysfcyz));
		e.setZjzmj(rs.getDouble(zjzmj));
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
	protected Pgv12003_b SetDParameters(ResultSet rs) throws Exception {
		Pgv12003_b e = new Pgv12003_b();
		e.setFcid(rs.getString(fcid));
		e.setCd12002BDcid(rs.getString(cd12002BDcid));
		e.setCd12001BSwid(rs.getString(cd12001BSwid));
		e.setFdcmc(rs.getString(fdcmc));
		e.setFwzldz(rs.getString(fwzldz));
		e.setCd00001Qdfs(rs.getString(cd00001Qdfs));
		e.setJcnf(rs.getString(jcnf));
		e.setFwzcs(rs.getInt(fwzcs));
		e.setDs(rs.getInt(ds));
		e.setDx(rs.getInt(dx));
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
}
