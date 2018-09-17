package com.sunway.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.hibernate.Session;
import org.hibernate.Transaction;

import oracle.jdbc.OracleTypes;

import com.sunway.dao.IPgtFc001DAO;
import com.sunway.util.Common;
import com.sunway.vo.PgtFc001;
import com.sunway.vo.PgtFc002;
import com.sunway.vo.PgtFc003;
import com.sunway.vo.PgvFc001;

public class PgtFc001DAO extends BaseDAO implements IPgtFc001DAO {
	private static final String SLID = "SLID";		
	private static final String JYSJ = "JYSJ";	
	private static final String ZRF_NAME = "ZRF_NAME";	
	private static final String CSF_NAME = "CSF_NAME";	
	private static final String LFDZ = "LFDZ";	//更改时间	
	private static final String RID = "rid";						//行号
	private static final String TOTAL = "total";					//总纪录数
	private static final String ZRF_ID="ZRF_ID";
	private static final String CSF_ID="CSF_ID";
	private static final String CLH="CLH";
	private static final String GHYT="GHYT";
	private static final String DYFH="DYFH";
	private static final String SSQY="SSQY";
	private static final String DEL_CZR="DEL_CZR";
	private static final String FCZH="FCZH";
	private static final String DJZ_YYS="DJZ_YYS";
	private static final String DJZ_CJS="DJZ_CJS";
	private static final String DJZ_DFJYS="DJZ_DFJYS";
	private static final String DJZ_GRSDS="DJZ_GRSDS";
	private static final String DJZ_QS="DJZ_QS";
	private static final String DJZ_YHS="DJZ_YHS";
	private static final String FZRQ="FZRQ";
	private static final String CQR="CQR";
	private static final String UPPDATE="UPDATETIME";
	private static final String ID="ID";
	private static final String FCZL="FCZL";
	private static final String TDZDMJ="TDZDMJ";
	private static final String TDZDH="TDZDH";
	private static final String TDYT="TDYT";
	private static final String TDSYQX2="TDSYQX2";
	private static final String TDSYQX1="TDSYQX1";
	private static final String TDSYQQDFS="TDSYQQDFS";
	private static final String TDSYQMJ="TDSYQMJ";
	private static final String TDQSXZ="TDQSXZ";
	private static final String QZFTMJ="QZFTMJ";
	private static final String QZDYMJ="QZDYMJ";
	private static final String FWZH="FWZH";
	private static final String FWZCS="FWZCS";
	private static final String FWJZMJ="FWJZMJ";
	private static final String FWTY="FWTY";
	private static final String FWJZLX="FWJZLX";
	private static final String FWDJRQ="FWDJRQ";
	private static final String FWBWH="FWBWH";
	private static final String FWJGRQ="FWJGRQ";
	private static final String FZDW="FZDW";
	private static final String REMARKS="REMARKS";
	//private static final String STATUS="STATUS";
	private static final String DEL_SIGN="DEL_SIGN";
	private static final String QSWSJS="QSWSJS";
	private static final String QSWSRQ="QSWSRQ";
	private static final String CG="CG";
	private static final String ZX="ZX";
	private static final String CX="CX";
	private static final String DF="DF";
	private static final String JG="JG";
	private static final String SFSYFC="SFSYFC";
	private static final String JCNF="JCNF";
	private static final String CSF_TEL="CSF_TEL";
	private static final String HTZJ="HTZJ";
	private static final String JZMJ="JZMJ";
	private static final String JYLX="JYLX";
	private static final String FWLX="FWLX";
	private static final String JZJG="JZJG";
	private static final String SZLC="SZLC";
	private static final String ZLC="ZLC";
	private static final String CSF_ZJLX="CSF_ZJLX";
	private static final String ZRF_TEL="ZRF_TEL";
	private static final String ZRF_ZJLX="ZRF_ZJLX";
	private static final String DEL_TIME="DEL_TIME";
	private static final String MS_ZCYJ="MS_ZCYJ";
	private static final String MS_SIGN="MS_SIGN";
	private static final String PGID="PGID";
	private static final String DFGSSPHM="DFGSSPHM";
	private static final String QSSPHM="QSSPHM";
	private static final String DJZ_TDZZS="DJZ_TDZZS";
	private static final String FPHM="FPHM";
	private static final String PGJG="PGJG";
	private static final String STATUS="STATUS";
	private static final String STATUS_SE="STATUS_SE";
	private static final String INFO="INFO";

	@Override
	public ArrayList<PgvFc001> LoadAll(PgvFc001 fc001) throws Exception {
		ArrayList<PgvFc001> listResult = new ArrayList<PgvFc001>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLFC001(?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, fc001.getPageIndex());
			call.setInt(3, fc001.getPageSize());
			call.setString(4, fc001.getSlid());
			call.setTimestamp(5, fc001.getJysj_min());
			call.setTimestamp(6, fc001.getJysj_max());
			call.setString(7, fc001.getZrf_name());
			call.setString(8, fc001.getCsf_name());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn);
		}
		return listResult;
	}
	protected PgvFc001 SetVParameters(ResultSet rs) throws Exception {
		PgvFc001 e = new PgvFc001();
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		e.setSlid(rs.getString(SLID));
		e.setSsqy(rs.getString(SSQY));
		e.setJysj(rs.getTimestamp(JYSJ));
		e.setZrf_name(rs.getString(ZRF_NAME));
		e.setCsf_name(rs.getString(CSF_NAME));
		e.setLfdz(rs.getString(LFDZ));
        e.setStatus(rs.getInt(STATUS));
		return e;
	}
	@Override
	public PgvFc001 LoadByPrimaryKey(PgtFc001 fc001) throws Exception {
		ArrayList<PgvFc001> listResult = new ArrayList<PgvFc001>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETTFC001(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, fc001.getSlid());
			call.setString(3, fc001.getSsqy());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return new PgvFc001();
	}
	/**
	 * Table数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected PgvFc001 SetTParameters(ResultSet rs) throws Exception {
		PgvFc001 e = new PgvFc001();
		e.setSlid(rs.getString(SLID));
		e.setSsqy(rs.getString(SSQY));
		e.setJysj(rs.getTimestamp(JYSJ));
		e.setZrf_name(rs.getString(ZRF_NAME));
		e.setCsf_name(rs.getString(CSF_NAME));
		e.setLfdz(rs.getString(LFDZ));
		e.setZrf_id(rs.getString(ZRF_ID));
		e.setCsf_id(rs.getString(CSF_ID));
		e.setClh(rs.getString(CLH));
		e.setGhyt(rs.getString(GHYT));
		e.setLfdz(rs.getString(LFDZ));
		e.setDyfh(rs.getString(DYFH));
		e.setZlc(rs.getInt(ZLC));
		e.setSzlc(rs.getInt(SZLC));
		e.setJzjg(rs.getString(JZJG));
		e.setFwlx(rs.getString(FWLX));
		e.setJylx(rs.getString(JYLX));
		e.setJzmj(rs.getDouble(JZMJ));
		e.setHtzj(rs.getDouble(HTZJ));
		e.setFzrq(rs.getTimestamp(FZRQ));
		e.setJcnf(rs.getString(JCNF));
		e.setJysj(rs.getTimestamp(JYSJ));
		e.setSfsyfc(rs.getString(SFSYFC));
		e.setCx(rs.getString(CX));
		e.setDf(rs.getString(DF));
	    e.setUpdate(rs.getTimestamp(UPPDATE));
	    e.setJg(rs.getString(JG));
	    e.setZx(rs.getString(ZX));
	    e.setCg(rs.getInt(CG));
	    e.setQswsrq(rs.getTimestamp(QSWSRQ));
	    e.setQswsjs(rs.getInt(QSWSJS));
	    e.setDel_czr(rs.getString(DEL_CZR));
	    e.setDel_time(rs.getTimestamp(DEL_TIME));
	    e.setDel_sign(rs.getInt(DEL_SIGN));
	    e.setStatus(rs.getInt(STATUS));
	    e.setRemarks(rs.getString(REMARKS));
	    e.setFczh(rs.getString(FCZH));
		return e;
	}
	
	@Override
	public boolean RegistTax(PgtFc002 fc002) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDTFC002(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			//傳入輸入參數
			call.setString(1, fc002.getSlid());
			call.setString(2, fc002.getSsqy());
			call.setDouble(3, fc002.getDjz_qs());
			call.setDouble(4, fc002.getDjz_yys());
			call.setDouble(5, fc002.getDjz_cjs());
			call.setDouble(6, fc002.getDjz_dfjys());
			call.setDouble(7, fc002.getDjz_grsds());
			call.setDouble(8, fc002.getDjz_yhs());
			call.setDouble(9, fc002.getDjz_tdzzs());
			call.setString(10, fc002.getFphm());
			call.setString(11, fc002.getQssphm());
			call.setString(12, fc002.getDfgssphm());
			call.setInt(13, fc002.getMs_sign());
			call.setString(14, fc002.getMs_zcyj());
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
	@Override
	public ArrayList<PgvFc001> LoadAllZzYw(PgvFc001 fc001) throws Exception {
		ArrayList<PgvFc001> listResult = new ArrayList<PgvFc001>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLFC0011(?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, fc001.getPageIndex());
			call.setInt(3, fc001.getPageSize());
			call.setString(4, fc001.getSlid());
			call.setTimestamp(5, fc001.getJysj_min());
			call.setTimestamp(6, fc001.getJysj_max());
			call.setString(7, fc001.getZrf_name());
			call.setString(8, fc001.getCsf_name());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetV1Parameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn);
		}
		return listResult;
	}
	protected PgvFc001 SetV1Parameters(ResultSet rs) throws Exception {
		PgvFc001 e = new PgvFc001();
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		e.setSlid(rs.getString(SLID));
		e.setSsqy(rs.getString(SSQY));
		e.setJysj(rs.getTimestamp(JYSJ));
		e.setZrf_name(rs.getString(ZRF_NAME));
		e.setCsf_name(rs.getString(CSF_NAME));
		e.setLfdz(rs.getString(LFDZ));		
		e.setInfo(rs.getInt(INFO));
        e.setStatus(rs.getInt("STATUS"));
        e.setStatus_se(rs.getInt("STATUS_SE"));
        e.setStatus_zz(rs.getInt("STATUS_ZZ"));
		return e;
	}
	@Override
	public ArrayList<PgvFc001> LoadAllTsYw(PgvFc001 fc001) throws Exception {
		ArrayList<PgvFc001> listResult = new ArrayList<PgvFc001>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLFC0012(?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, fc001.getPageIndex());
			call.setInt(3, fc001.getPageSize());
			call.setString(4, fc001.getSlid());
			call.setTimestamp(5, fc001.getJysj_min());
			call.setTimestamp(6, fc001.getJysj_max());
			call.setString(7, fc001.getZrf_name());
			call.setString(8, fc001.getCsf_name());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetV2Parameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn);
		}
		return listResult;
	}
	protected PgvFc001 SetV2Parameters(ResultSet rs) throws Exception {
		PgvFc001 e = new PgvFc001();
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		e.setSlid(rs.getString(SLID));
		e.setSsqy(rs.getString(SSQY));
		e.setJysj(rs.getTimestamp(JYSJ));
		e.setZrf_name(rs.getString(ZRF_NAME));
		e.setCsf_name(rs.getString(CSF_NAME));
		e.setLfdz(rs.getString(LFDZ));
		e.setDel_czr(rs.getString(DEL_CZR));
		e.setStatus(rs.getInt(STATUS));
		e.setStatus_se(rs.getInt(STATUS_SE));	   
		return e;
	}
	@Override
	public ArrayList<PgvFc001> LoadAllCwSjCl(PgvFc001 fc001) throws Exception {
		ArrayList<PgvFc001> listResult = new ArrayList<PgvFc001>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLFC0013(?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, fc001.getPageIndex());
			call.setInt(3, fc001.getPageSize());
			call.setString(4, fc001.getSlid());
			call.setTimestamp(5, fc001.getJysj_min());
			call.setTimestamp(6, fc001.getJysj_max());
			call.setString(7, fc001.getZrf_name());
			call.setString(8, fc001.getCsf_name());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetV3Parameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn);
		}
		return listResult;
	}
	protected PgvFc001 SetV3Parameters(ResultSet rs) throws Exception {
		PgvFc001 e = new PgvFc001();
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		e.setSlid(rs.getString(SLID));
		e.setSsqy(rs.getString(SSQY));
		e.setJysj(rs.getTimestamp(JYSJ));
		e.setZrf_name(rs.getString(ZRF_NAME));
		e.setCsf_name(rs.getString(CSF_NAME));
		e.setLfdz(rs.getString(LFDZ));
		e.setDel_czr(rs.getString(DEL_CZR));
		return e;
	}
	@Override
	public boolean BreakService(PgtFc002 fc002) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDTFC0011(?,?)}");
			//傳入輸入參數
			call.setString(1, fc002.getSlid());
			call.setString(2, fc002.getSsqy());
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
	@Override
	public boolean AuditService(PgtFc002 fc002) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDTFC0021(?,?)}");
			//傳入輸入參數
			call.setString(1, fc002.getSlid());
			call.setString(2, fc002.getSsqy());
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
	@Override
	public boolean RebateTax(PgtFc002 fc002) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDTFC0012(?,?,?,?,?,?,?,?,?,?,?)}");
			//傳入輸入參數
			call.setString(1, fc002.getSlid());
			call.setString(2, fc002.getSsqy());
			call.setString(3, fc002.getTs_czr());
			call.setDouble(4, fc002.getDjz_qs());
			call.setDouble(5, fc002.getDjz_yys());
			call.setDouble(6, fc002.getDjz_cjs());
			call.setDouble(7, fc002.getDjz_dfjys());
			call.setDouble(8, fc002.getDjz_grsds());
			call.setDouble(9, fc002.getDjz_yhs());
			call.setDouble(10, fc002.getDjz_tdzzs());
			call.setString(11, fc002.getMs_zcyj());
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
	@Override
	public boolean ProcesErrorData(PgtFc002 fc002) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDTFC0013(?,?,?,?)}");
			//傳入輸入參數
			call.setString(1, fc002.getSlid());
			call.setString(2, fc002.getSsqy());
			call.setString(3, fc002.getDel_czr());
			call.setString(4, fc002.getRemarks());
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
	@Override
	public ArrayList<PgvFc001> LoadAllOverodueTax(PgvFc001 fc001)
			throws Exception {
		ArrayList<PgvFc001> listResult = new ArrayList<PgvFc001>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BB_00001(?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, fc001.getPageIndex());
			call.setInt(3, fc001.getPageSize());
			call.setString(4, fc001.getZrf_name());
			call.setString(5, fc001.getCsf_name());
			call.setString(6, fc001.getSlid());
			call.setString(7, fc001.getLfdz());
			call.setTimestamp(8, fc001.getJysj_min());
			call.setTimestamp(9, fc001.getJysj_max());
			
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVOverodueTaxParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn);
		}
		return listResult;
	}
	protected PgvFc001 SetVOverodueTaxParameters(ResultSet rs) throws Exception {
		PgvFc001 e = new PgvFc001();
		e.setSlid(rs.getString(SLID));
		e.setSsqy(rs.getString(SSQY));
		e.setJysj(rs.getTimestamp(JYSJ));
		e.setZrf_name(rs.getString(ZRF_NAME));
		e.setCsf_name(rs.getString(CSF_NAME));
		e.setLfdz(rs.getString(LFDZ));
		e.setZrf_id(rs.getString(ZRF_ID));
		e.setCsf_id(rs.getString(CSF_ID));
		e.setClh(rs.getString(CLH));
		e.setGhyt(rs.getString(GHYT));
		e.setLfdz(rs.getString(LFDZ));
		e.setDyfh(rs.getString(DYFH));
		e.setZlc(rs.getInt(ZLC));
		e.setSzlc(rs.getInt(SZLC));
		e.setJzjg(rs.getString(JZJG));
		e.setFwlx(rs.getString(FWLX));
		e.setJylx(rs.getString(JYLX));
		e.setJzmj(rs.getDouble(JZMJ));
		e.setHtzj(rs.getDouble(HTZJ));
		e.setFzrq(rs.getTimestamp(FZRQ));
		e.setJcnf(rs.getString(JCNF));
		e.setJysj(rs.getTimestamp(JYSJ));
		e.setSfsyfc(rs.getString(SFSYFC));
		e.setCx(rs.getString(CX));
		e.setDf(rs.getString(DF));
	    e.setUpdate(rs.getTimestamp(UPPDATE));
	    e.setJg(rs.getString(JG));
	    e.setZx(rs.getString(ZX));
	    e.setCg(rs.getInt(CG));
	    e.setQswsrq(rs.getTimestamp(QSWSRQ));
	    e.setQswsjs(rs.getInt(QSWSJS));
	    e.setDel_czr(rs.getString(DEL_CZR));
	    e.setDel_time(rs.getTimestamp(DEL_TIME));
	    e.setDel_sign(rs.getInt(DEL_SIGN));
	    e.setStatus(rs.getInt(STATUS));
	    e.setRemarks(rs.getString(REMARKS));
	    e.setFczh(rs.getString(FCZH));
		return e;
	}
	@Override
	public ArrayList<PgvFc001> LoadAllPaymentInfo(PgvFc001 fc001)
			throws Exception {
		ArrayList<PgvFc001> listResult = new ArrayList<PgvFc001>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BB_00002(?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, fc001.getPageIndex());
			call.setInt(3, fc001.getPageSize());
			call.setString(4, fc001.getZrf_name());
			call.setString(5, fc001.getCsf_name());
			call.setString(6, fc001.getSlid());
			call.setString(7, fc001.getLfdz());
			call.setTimestamp(8, fc001.getUpdatetime_min());
			call.setTimestamp(9, fc001.getUpdatetime_max());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVPaymentInfoParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn);
		}
		return listResult;
	}
	protected PgvFc001 SetVPaymentInfoParameters(ResultSet rs) throws Exception {
		PgvFc001 e = new PgvFc001();
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		e.setSlid(rs.getString(SLID));
		e.setSsqy(rs.getString(SSQY));
		e.setUpdate(rs.getTimestamp(UPPDATE));
		e.setDjz_yys(rs.getDouble(DJZ_YYS));
		e.setDjz_cjs(rs.getDouble(DJZ_CJS));
		e.setDjz_dfjys(rs.getDouble(DJZ_DFJYS));
		e.setDjz_grsds(rs.getDouble(DJZ_GRSDS));
		e.setDjz_yys(rs.getDouble(DJZ_YYS));
		e.setDjz_qs(rs.getDouble(DJZ_QS));
		e.setDjz_yhs(rs.getDouble(DJZ_YHS));
		
		return e;
	}
	@Override
	public ArrayList<PgvFc001> LoadAllTaxAuditedInfo(PgvFc001 fc001)
			throws Exception {
		ArrayList<PgvFc001> listResult = new ArrayList<PgvFc001>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call  PGSP_GETALLFC0015(?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, fc001.getPageIndex());
			call.setInt(3, fc001.getPageSize());
			call.setString(4, fc001.getSlid());
			call.setTimestamp(5, fc001.getUpdatetime_min());
			call.setTimestamp(6, fc001.getUpdatetime_max());
			call.setString(7, fc001.getZrf_name());
			call.setString(8, fc001.getCsf_name());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVLoadAllTaxAuditedInfoParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn);
		}
		return listResult;
	}
	protected PgvFc001 SetVLoadAllTaxAuditedInfoParameters(ResultSet rs) throws Exception {
		PgvFc001 e = new PgvFc001();
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		e.setSlid(rs.getString(SLID));
		e.setSsqy(rs.getString(SSQY));
		e.setJysj(rs.getTimestamp(JYSJ));
		e.setZrf_name(rs.getString(ZRF_NAME));
		e.setCsf_name(rs.getString(CSF_NAME));
		e.setLfdz(rs.getString(LFDZ));		
		//e.setInfo(rs.getInt(INFO));
        e.setStatus(rs.getInt("STATUS"));
        e.setStatus_se(rs.getInt("STATUS_SE"));
        e.setStatus_zz(rs.getInt("STATUS_ZZ"));
		
		return e;
	}
	@Override
	public ArrayList<PgvFc001> LoadAllHouseInfo(PgvFc001 fc001)
			throws Exception {
		ArrayList<PgvFc001> listResult = new ArrayList<PgvFc001>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BB_00003(?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, fc001.getPageIndex());
			call.setInt(3, fc001.getPageSize());
			call.setString(4, fc001.getCqr());
			call.setString(5, fc001.getFczh());
			call.setTimestamp(6, fc001.getFzrq_min());
			call.setTimestamp(7, fc001.getFzrq_max());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVHouseInfoParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn);
		}
		return listResult;
	}
	protected PgvFc001 SetVHouseInfoParameters(ResultSet rs) throws Exception {
		PgvFc001 e = new PgvFc001();
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		e.setSlid(rs.getString(SLID));
		e.setSsqy(rs.getString(SSQY));
		//e.setJysj(rs.getTimestamp(JYSJ));
		e.setFzrq(rs.getTimestamp(FZRQ));
		e.setCqr(rs.getString(CQR));
		e.setFczh(rs.getString(FCZH));
		e.setFczl(rs.getString(FCZL));
		e.setId(rs.getInt(ID));
		return e;
	}
	@Override
	public ArrayList<PgvFc001> LoadAllUnpaidRecord(PgvFc001 fc001)
			throws Exception {
		ArrayList<PgvFc001> listResult = new ArrayList<PgvFc001>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BB_00004(?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, fc001.getPageIndex());
			call.setInt(3, fc001.getPageSize());
			call.setString(4, fc001.getCqr());
			call.setString(5, fc001.getFczh());
			call.setTimestamp(6, fc001.getFzrq_min());
			call.setTimestamp(7, fc001.getFzrq_max());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetVUnpaidRecordParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn);
		}
		return listResult;
	}
	protected PgvFc001 SetVUnpaidRecordParameters(ResultSet rs) throws Exception {
		PgvFc001 e = new PgvFc001();
		e.setRecordCount(rs.getInt(TOTAL));
		e.setRecordIndex(rs.getInt(RID));
		e.setSlid(rs.getString(SLID));
		e.setSsqy(rs.getString(SSQY));
		//e.setJysj(rs.getTimestamp(JYSJ));
		e.setFzrq(rs.getTimestamp(FZRQ));
		e.setCqr(rs.getString(CQR));
		e.setFczh(rs.getString(FCZH));
		e.setFczl(rs.getString(FCZL));
		e.setId(rs.getInt(ID));
		return e;
	}
	@Override
	public OutputStream ExportOverodueTax(PgvFc001 fc001) throws Exception {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		int m=-1;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BB_00001(?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, fc001.getPageIndex());
			call.setInt(3, fc001.getPageSize());
			call.setString(4, fc001.getZrf_name());
			call.setString(5, fc001.getCsf_name());
			call.setString(6, fc001.getSlid());
			call.setString(7, fc001.getLfdz());
			call.setTimestamp(8, fc001.getJysj_min());
			call.setTimestamp(9, fc001.getJysj_max());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			if(null!=rs){			
				// 创建excel对象
		        Label label;   
		        WritableWorkbook workbook; 
	            workbook = Workbook.createWorkbook(strBufResult);   
	            WritableSheet sheet = workbook.createSheet("超期未完税数据查询", 0);
	            // 写入标头
	            label = new Label(++m, 0, "房产受理号");
				sheet.addCell(label);
	            label = new Label(++m, 0, "所属区域");
				sheet.addCell(label);	
				label = new Label(++m, 0, "房产证号");
				sheet.addCell(label);		            
				label = new Label(++m, 0, "转让方名称");
				sheet.addCell(label);
				label = new Label(++m, 0, "转让方证件号");
				sheet.addCell(label);
				label = new Label(++m, 0, "转让方证件类型");
				sheet.addCell(label);
				label = new Label(++m, 0, "转让方联系电话");
				sheet.addCell(label);
				label = new Label(++m, 0, "承受方姓名");
				sheet.addCell(label);
				label = new Label(++m, 0, "承受方证件号");
				sheet.addCell(label);	
				label = new Label(++m, 0, "承受方证件类型");
				sheet.addCell(label);
				label = new Label(++m, 0, "承受方联系电话");
				sheet.addCell(label);
				label = new Label(++m, 0, "测量号");
				sheet.addCell(label);	
				label = new Label(++m, 0, "规划用途");
				sheet.addCell(label);	
				label = new Label(++m, 0, "楼房地址");
				sheet.addCell(label);	
				label = new Label(++m, 0, "单元房号");
				sheet.addCell(label);	
				label = new Label(++m, 0, "总楼层");
				sheet.addCell(label);	
				label = new Label(++m, 0, "所在楼层");
				sheet.addCell(label);	
				label = new Label(++m, 0, "建筑结构");
				sheet.addCell(label);
				label = new Label(++m, 0, "房屋类型");
				sheet.addCell(label);	
				label = new Label(++m, 0, "交易类型");
				sheet.addCell(label);
				label = new Label(++m, 0, "建筑面积");
				sheet.addCell(label);
				label = new Label(++m, 0, "合同总价");
				sheet.addCell(label);
				label = new Label(++m, 0, "发证日期");
				sheet.addCell(label);
				label = new Label(++m, 0, "建成年份");
				sheet.addCell(label);
				label = new Label(++m, 0, "交易时间");
				sheet.addCell(label);
				label = new Label(++m, 0, "是否私有房产");
				sheet.addCell(label);				
				label = new Label(++m, 0, "朝向");
				sheet.addCell(label);
				label = new Label(++m, 0, "端房");
				sheet.addCell(label);
				label = new Label(++m, 0, "更新时间");
				sheet.addCell(label);
				label = new Label(++m, 0, "景观(保留)");
				sheet.addCell(label);				
				label = new Label(++m, 0, "装修(保留)");
				sheet.addCell(label);
				label = new Label(++m, 0, "层高");
				sheet.addCell(label);
				label = new Label(++m, 0, "契税完税日期");
				sheet.addCell(label);
				label = new Label(++m, 0, "契税完税基数");
				sheet.addCell(label);
//				label = new Label(++m, 0, "撤销时间");
//				sheet.addCell(label);
				label = new Label(++m, 0, "备注");
				sheet.addCell(label);
	            // 写入数据
				while(null!=rs && rs.next()){
					m=-1;
					Integer rowIndex = rs.getRow();
					label = new Label(++m, rowIndex, rs.getString(SLID));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(SSQY));
					sheet.addCell(label);		
					label = new Label(++m, rowIndex,  rs.getString(FCZH));
					sheet.addCell(label);						
					label = new Label(++m, rowIndex, rs.getString(ZRF_NAME));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(ZRF_ID));
					sheet.addCell(label);	
					label = new Label(++m, rowIndex, rs.getString(ZRF_ZJLX));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(ZRF_TEL));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(CSF_NAME));
					sheet.addCell(label);	
					label = new Label(++m, rowIndex,rs.getString(CSF_ID));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(CSF_ZJLX));
					sheet.addCell(label);	
					label = new Label(++m, rowIndex,rs.getString(CSF_TEL));
					sheet.addCell(label);
					label = new Label(++m, rowIndex,rs.getString(CLH));
					sheet.addCell(label);
					label = new Label(++m, rowIndex,rs.getString(GHYT));
					sheet.addCell(label);
					label = new Label(++m, rowIndex,rs.getString(LFDZ));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(DYFH));
					sheet.addCell(label);	
					label = new Label(++m, rowIndex,rs.getString(ZLC));
					sheet.addCell(label);
					label = new Label(++m, rowIndex,rs.getString(SZLC));
					sheet.addCell(label);
					label = new Label(++m, rowIndex,rs.getString(JZJG));
					sheet.addCell(label);
					label = new Label(++m, rowIndex,rs.getString(FWLX));
					sheet.addCell(label);
					label = new Label(++m, rowIndex,rs.getString(JYLX));
					sheet.addCell(label);
					label = new Label(++m, rowIndex,String.valueOf(rs.getDouble(JZMJ)));
					sheet.addCell(label);
					label = new Label(++m, rowIndex,rs.getString(HTZJ));
					sheet.addCell(label);
					label = new Label(++m, rowIndex,rs.getDate(FZRQ).toString());
					sheet.addCell(label);
					label = new Label(++m, rowIndex,rs.getString(JCNF));
					sheet.addCell(label);
					label = new Label(++m, rowIndex,rs.getDate(JYSJ).toString());
					sheet.addCell(label);
					label = new Label(++m, rowIndex,rs.getString(SFSYFC));
					sheet.addCell(label);
					label = new Label(++m, rowIndex,rs.getString(CX));
					sheet.addCell(label);
					label = new Label(++m, rowIndex,rs.getString(DF));
					sheet.addCell(label);
					label = new Label(++m, rowIndex,Common.convertTimestampToString(rs.getTimestamp(UPPDATE)));
					sheet.addCell(label);
					label = new Label(++m, rowIndex,rs.getString(JG));
					sheet.addCell(label);
					label = new Label(++m, rowIndex,rs.getString(ZX));
					sheet.addCell(label);
					label = new Label(++m, rowIndex,rs.getString(CG));
					sheet.addCell(label);
					label = new Label(++m, rowIndex,rs.getDate(QSWSRQ).toString());
					sheet.addCell(label);
					label = new Label(++m, rowIndex,String.valueOf(rs.getDouble(QSWSJS)));
					sheet.addCell(label);
//					label = new Label(++m, rowIndex, Common.convertTimestampToString(rs.getTimestamp(DEL_TIME)));
//					sheet.addCell(label);
					label = new Label(++m, rowIndex,rs.getString(REMARKS));
					sheet.addCell(label);	
					
				}
	            workbook.write(); 
	            workbook.close();  
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn);
		}
		return strBufResult;
	}
	@Override
	public OutputStream ExportPaymentInfo(PgvFc001 fc001) throws Exception {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BB_00002(?,?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, fc001.getPageIndex());
			call.setInt(3, fc001.getPageSize());
			call.setString(4, fc001.getZrf_name());
			call.setString(5, fc001.getCsf_name());
			call.setString(6, fc001.getSlid());
			call.setString(7, fc001.getLfdz());
			call.setTimestamp(8, fc001.getUpdatetime_min());
			call.setTimestamp(9, fc001.getUpdatetime_max());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			int m=-1;
			if(null!=rs){
				// 创建excel对象
		        Label label;   
		        WritableWorkbook workbook; 
	            workbook = Workbook.createWorkbook(strBufResult);   
	            WritableSheet sheet = workbook.createSheet("完税信息查询", 0);
	            // 写入标头
	            label = new Label(++m, 0, "房产受理号");
				sheet.addCell(label);
	            label = new Label(++m, 0, "所属区域");
				sheet.addCell(label);	
				label = new Label(++m, 0, "契税");
				sheet.addCell(label);		            
				label = new Label(++m, 0, "营业税");
				sheet.addCell(label);				
				 label = new Label(++m, 0, "城市维护建设税");
				sheet.addCell(label);
	            label = new Label(++m, 0, "教育费附加、地方教育附加");
				sheet.addCell(label);	
				label = new Label(++m, 0, "个人所得税");
				sheet.addCell(label);	
				label = new Label(++m, 0, "印花税");
				sheet.addCell(label);	
				label = new Label(++m, 0, "土地增值税");
				sheet.addCell(label);	
				label = new Label(++m, 0, "发票号码");
				sheet.addCell(label);	
				label = new Label(++m, 0, "契税税票号码");
				sheet.addCell(label);	
				label = new Label(++m, 0, "地方各税税票号码");
				sheet.addCell(label);	
				label = new Label(++m, 0, "契税完税日期");
				sheet.addCell(label);	
				label = new Label(++m, 0, "评估业务号");
				sheet.addCell(label);	
				label = new Label(++m, 0, "评估结果");
				sheet.addCell(label);	
//				label = new Label(++m, 0, "删除时间");
//				sheet.addCell(label);	
				label = new Label(++m, 0, "免税标识");
				sheet.addCell(label);	
				label = new Label(++m, 0, "政策依据");
				sheet.addCell(label);
	            // 写入数据
				while(null!=rs && rs.next()){
					m=-1;
					Integer rowIndex = rs.getRow();
					label = new Label(++m, rowIndex, rs.getString(SLID));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(SSQY));
					sheet.addCell(label);		
					label = new Label(++m, rowIndex, String.valueOf(rs.getDouble(DJZ_QS)));
					sheet.addCell(label);	
					label = new Label(++m, rowIndex, String.valueOf(rs.getDouble(DJZ_YYS)));
					sheet.addCell(label);	
					label = new Label(++m, rowIndex, String.valueOf(rs.getDouble(DJZ_CJS)));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, String.valueOf(rs.getDouble(DJZ_DFJYS)));
					sheet.addCell(label);	
					label = new Label(++m, rowIndex, String.valueOf(rs.getDouble(DJZ_GRSDS)));
					sheet.addCell(label);	
					label = new Label(++m, rowIndex, String.valueOf(rs.getDouble(DJZ_YHS)));
					sheet.addCell(label);	
					label = new Label(++m, rowIndex, String.valueOf(rs.getDouble(DJZ_TDZZS)));
					sheet.addCell(label);	
					label = new Label(++m, rowIndex, rs.getString(FPHM));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(QSSPHM));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(DFGSSPHM));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getDate(UPPDATE).toString());
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(PGID));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, String.valueOf(rs.getDouble(PGJG)));
					sheet.addCell(label);	
//					label = new Label(++m, rowIndex, Common.convertTimestampToString( rs.getTimestamp(DEL_TIME)));
//					sheet.addCell(label);	
					label = new Label(++m, rowIndex,rs.getInt(MS_SIGN)==0?"正常":"免税");
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(MS_ZCYJ));
					sheet.addCell(label);		
					
				}
	            workbook.write();   
	            workbook.close();  
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn);
		}
		return strBufResult;
	}
	@Override
	public OutputStream ExportHouseInfo(PgvFc001 fc001) throws Exception {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BB_00003(?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, fc001.getPageIndex());
			call.setInt(3, fc001.getPageSize());
			call.setString(4, fc001.getCqr());
			call.setString(5, fc001.getFczh());
			call.setTimestamp(6, fc001.getFzrq_min());
			call.setTimestamp(7, fc001.getFzrq_max());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			int m=-1;
			if(null!=rs){
				// 创建excel对象
		        Label label;   
		        WritableWorkbook workbook; 
	            workbook = Workbook.createWorkbook(strBufResult);   
	            WritableSheet sheet = workbook.createSheet("房产方--房产证信息查询", 0);
	            // 写入标头
	            label = new Label(++m, 0, "房产受理号");
				sheet.addCell(label);
	            label = new Label(++m, 0, "所属区域");
				sheet.addCell(label);	
				label = new Label(++m, 0, "房产证号");
				sheet.addCell(label);	            
				label = new Label(++m, 0, "产权人");
				sheet.addCell(label);
	            label = new Label(++m, 0, "房屋坐落");
				sheet.addCell(label);
				label = new Label(++m, 0, "土地权属性质");
				sheet.addCell(label);
				label = new Label(++m, 0, "土地使用权取得方式");
				sheet.addCell(label);
				label = new Label(++m, 0, "土地用途");
				sheet.addCell(label);
				label = new Label(++m, 0, "土地宗地号");
				sheet.addCell(label);
				label = new Label(++m, 0, "土地宗地面积");
				sheet.addCell(label);
				label = new Label(++m, 0, "土地使用权面积");
				sheet.addCell(label);
				label = new Label(++m, 0, "其中独用面积");
				sheet.addCell(label);
				label = new Label(++m, 0, "其中分摊面积");
				sheet.addCell(label);
				label = new Label(++m, 0, "土地使用期限（开始）");
				sheet.addCell(label);
				label = new Label(++m, 0, "土地使用期限（结束）");
				sheet.addCell(label);
				label = new Label(++m, 0, "房屋登记日期");
				sheet.addCell(label);
				label = new Label(++m, 0, "房屋幢号");
				sheet.addCell(label);
				label = new Label(++m, 0, "房屋部位号");
				sheet.addCell(label);
				label = new Label(++m, 0, "房屋建筑面积");
				sheet.addCell(label);
				label = new Label(++m, 0, "房屋建筑类型");
				sheet.addCell(label);
				label = new Label(++m, 0, "房屋用途");
				sheet.addCell(label);
				label = new Label(++m, 0, "房屋总层数");
				sheet.addCell(label);
				label = new Label(++m, 0, "房屋竣工日期");
				sheet.addCell(label);
				label = new Label(++m, 0, "发证单位");
				sheet.addCell(label);
				label = new Label(++m, 0, "发证日期");
				sheet.addCell(label);					
							
					
	            // 写入数据
				while(null!=rs && rs.next()){
					 m=-1;
					Integer rowIndex = rs.getRow();
					label = new Label(++m, rowIndex, rs.getString(SLID));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(SSQY));
					sheet.addCell(label);		
					label = new Label(++m, rowIndex,  rs.getString(FCZH));
					sheet.addCell(label);						
					label = new Label(++m, rowIndex, rs.getString(CQR));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(FCZL));
					sheet.addCell(label);	
					label = new Label(++m, rowIndex, rs.getString(TDQSXZ));
					sheet.addCell(label);	
					label = new Label(++m, rowIndex,rs.getString(TDSYQQDFS));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(TDYT));
					sheet.addCell(label);	
					label = new Label(++m, rowIndex, rs.getString(TDZDH));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, String.valueOf(rs.getDouble(TDZDMJ)));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, String.valueOf(rs.getDouble(TDSYQMJ)));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, String.valueOf(rs.getDouble(QZDYMJ)));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, String.valueOf(rs.getDouble(QZFTMJ)));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getDate(TDSYQX1).toString());
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getDate(TDSYQX2).toString());
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getDate(FWDJRQ).toString());
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(FWZH));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(FWBWH));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, String.valueOf(rs.getDouble(FWJZMJ)));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(FWJZLX));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(FWTY));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, String.valueOf(rs.getDouble(FWZCS)));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getDate(FWJGRQ).toString());
					sheet.addCell(label);	
					label = new Label(++m, rowIndex, rs.getString(FZDW));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getDate(FZRQ).toString());
					sheet.addCell(label);		
					
				}
	            workbook.write();   
	            workbook.close();  
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn);
		}
		return strBufResult;
	}
	@Override
	public OutputStream ExportUnpaidRecord(PgvFc001 fc001) throws Exception {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BB_00004(?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, fc001.getPageIndex());
			call.setInt(3, fc001.getPageSize());
			call.setString(4, fc001.getCqr());
			call.setString(5, fc001.getFczh());
			call.setTimestamp(6, fc001.getFzrq_min());
			call.setTimestamp(7, fc001.getFzrq_max());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			int m=-1;
			if(null!=rs){
				// 创建excel对象
		        Label label;   
		        WritableWorkbook workbook; 
	            workbook = Workbook.createWorkbook(strBufResult);   
	            WritableSheet sheet = workbook.createSheet("房产方--房产证信息查询", 0);
	            // 写入标头
	            label = new Label(++m, 0, "房产受理号");
				sheet.addCell(label);
	            label = new Label(++m, 0, "所属区域");
				sheet.addCell(label);	
				label = new Label(++m, 0, "房产证号");
				sheet.addCell(label);	            
				label = new Label(++m, 0, "产权人");
				sheet.addCell(label);
	            label = new Label(++m, 0, "房屋坐落");
				sheet.addCell(label);
				label = new Label(++m, 0, "土地权属性质");
				sheet.addCell(label);
				label = new Label(++m, 0, "土地使用权取得方式");
				sheet.addCell(label);
				label = new Label(++m, 0, "土地用途");
				sheet.addCell(label);
				label = new Label(++m, 0, "土地宗地号");
				sheet.addCell(label);
				label = new Label(++m, 0, "土地宗地面积");
				sheet.addCell(label);
				label = new Label(++m, 0, "土地使用权面积");
				sheet.addCell(label);
				label = new Label(++m, 0, "其中独用面积");
				sheet.addCell(label);
				label = new Label(++m, 0, "其中分摊面积");
				sheet.addCell(label);
				label = new Label(++m, 0, "土地使用期限（开始）");
				sheet.addCell(label);
				label = new Label(++m, 0, "土地使用期限（结束）");
				sheet.addCell(label);
				label = new Label(++m, 0, "房屋登记日期");
				sheet.addCell(label);
				label = new Label(++m, 0, "房屋幢号");
				sheet.addCell(label);
				label = new Label(++m, 0, "房屋部位号");
				sheet.addCell(label);
				label = new Label(++m, 0, "房屋建筑面积");
				sheet.addCell(label);
				label = new Label(++m, 0, "房屋建筑类型");
				sheet.addCell(label);
				label = new Label(++m, 0, "房屋用途");
				sheet.addCell(label);
				label = new Label(++m, 0, "房屋总层数");
				sheet.addCell(label);
				label = new Label(++m, 0, "房屋竣工日期");
				sheet.addCell(label);
				label = new Label(++m, 0, "发证单位");
				sheet.addCell(label);
				label = new Label(++m, 0, "发证日期");
				sheet.addCell(label);					
							
					
	            // 写入数据
				while(null!=rs && rs.next()){
					 m=-1;
					Integer rowIndex = rs.getRow();
					label = new Label(++m, rowIndex, rs.getString(SLID));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(SSQY));
					sheet.addCell(label);		
					label = new Label(++m, rowIndex,  rs.getString(FCZH));
					sheet.addCell(label);						
					label = new Label(++m, rowIndex, rs.getString(CQR));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(FCZL));
					sheet.addCell(label);	
					label = new Label(++m, rowIndex, rs.getString(TDQSXZ));
					sheet.addCell(label);	
					label = new Label(++m, rowIndex,rs.getString(TDSYQQDFS));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(TDYT));
					sheet.addCell(label);	
					label = new Label(++m, rowIndex, rs.getString(TDZDH));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, String.valueOf(rs.getDouble(TDZDMJ)));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, String.valueOf(rs.getDouble(TDSYQMJ)));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, String.valueOf(rs.getDouble(QZDYMJ)));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, String.valueOf(rs.getDouble(QZFTMJ)));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getDate(TDSYQX1).toString());
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getDate(TDSYQX2).toString());
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getDate(FWDJRQ).toString());
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(FWZH));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(FWBWH));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, String.valueOf(rs.getDouble(FWJZMJ)));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(FWJZLX));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getString(FWTY));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, String.valueOf(rs.getDouble(FWZCS)));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getDate(FWJGRQ).toString());
					sheet.addCell(label);	
					label = new Label(++m, rowIndex, rs.getString(FZDW));
					sheet.addCell(label);
					label = new Label(++m, rowIndex, rs.getDate(FZRQ).toString());
					sheet.addCell(label);		
					
				}
	            workbook.write();   
	            workbook.close();  
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn);
		}
		return strBufResult;
	}
	@Override
	public PgtFc003 LoadByPrimaryKey(PgtFc003 fc003) throws Exception {
		ArrayList<PgtFc003> listResult = new ArrayList<PgtFc003>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETTFC003(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, fc003.getId());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetTFCZParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return new PgtFc003();
	}
	/**
	 * Table数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected PgtFc003 SetTFCZParameters(ResultSet rs) throws Exception {
		PgtFc003 e = new PgtFc003();
		e.setSlid(rs.getString(SLID));
		e.setSsqy(rs.getString(SSQY));
		e.setCqr(rs.getString(CQR));
		e.setFczh(rs.getString(FCZH));
		e.setFczl(rs.getString(FCZL));
		e.setFwbwh(rs.getString(FWBWH));
		e.setFwdjrq(rs.getTimestamp(FWDJRQ));
		e.setFwjgrq(rs.getTimestamp(FWJGRQ));
		e.setFzrq(rs.getTimestamp(FZRQ));
		e.setFwjzlx(rs.getString(FWJZLX));
		e.setFwjzmj(rs.getDouble(FWJZMJ));
		e.setFwty(rs.getString(FWTY));
		e.setFwzcs(rs.getDouble(FWZCS));
		e.setFwzh(rs.getString(FWZH));
		e.setFzdw(rs.getString(FZDW));
		e.setId(rs.getInt(ID));
		e.setQzdymj(rs.getDouble(QZDYMJ));
		e.setQzftmj(rs.getDouble(QZFTMJ));
		e.setSlid(rs.getString(SLID));
		e.setSsqy(rs.getString(SSQY));
		e.setTdqsxz(rs.getString(TDQSXZ));
		e.setTdsyqmj(rs.getDouble(TDSYQMJ));
		e.setTdsyqqdfs(rs.getString(TDSYQQDFS));
		e.setTdsyqx1(rs.getTimestamp(TDSYQX1));
		e.setTdsyqx2(rs.getTimestamp(TDSYQX2));
		e.setTdyt(rs.getString(TDYT));
		e.setTdzdh(rs.getString(TDZDH));
		e.setTdzdmj(rs.getDouble(TDZDMJ));
		return e;
	}
	@Override
	public PgtFc002 LoadByPrimaryKey(PgtFc002 fc002) throws Exception {
		ArrayList<PgtFc002> listResult = new ArrayList<PgtFc002>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETTFC002(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, fc002.getSlid());
			call.setString(3, fc002.getSsqy());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetTFC002Parameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return new PgtFc002();
	}
	/**
	 * Table数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected PgtFc002 SetTFC002Parameters(ResultSet rs) throws Exception {
		PgtFc002 e = new PgtFc002();
		e.setSlid(rs.getString(SLID));
		e.setSsqy(rs.getString(SSQY));
		e.setDjz_qs(rs.getDouble(DJZ_QS));
		e.setDjz_yys(rs.getDouble(DJZ_YYS));
		e.setDjz_cjs(rs.getDouble(DJZ_CJS));
		e.setDjz_dfjys(rs.getDouble(DJZ_DFJYS));
		e.setDjz_grsds(rs.getDouble(DJZ_GRSDS));
		e.setDjz_yhs(rs.getDouble(DJZ_YHS));
		e.setDjz_tdzzs(rs.getDouble(DJZ_TDZZS));
		e.setFphm(rs.getString(FPHM));
		e.setQssphm(rs.getString(QSSPHM));
		e.setDfgssphm(rs.getString(DFGSSPHM));
		e.setUpdatetime(rs.getTimestamp(UPPDATE));
		e.setPgid(rs.getString(PGID));
		e.setPgjg(rs.getDouble(PGJG));
//		e.setDel_czr(rs.getString(DEL_CZR));
//		e.setDel_sign(rs.getInt(DEL_SIGN));
//		e.setDel_time(rs.getTimestamp(DEL_TIME));
//	    e.setDel_czr(rs.getString(DEL_CZR));
//	    e.setDel_time(rs.getTimestamp(DEL_TIME));
	    e.setMs_sign(rs.getInt(MS_SIGN));
	    e.setMs_zcyj(rs.getString(MS_ZCYJ));
		return e;
	}
	
}
