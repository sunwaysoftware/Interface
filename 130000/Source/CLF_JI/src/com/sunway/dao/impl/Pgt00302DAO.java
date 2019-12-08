package com.sunway.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt00302DAO;
import com.sunway.util.Common;
import com.sunway.vo.BF00000;
import com.sunway.vo.Pgt00302;
import com.sunway.vo.Pgt00352xml;
import com.sunway.vo.Pgv00302;
import com.sunway.vo.Pgv00357;
import com.sunway.vo.Pgv00372;

/**
 *
 * 市场法房地产信息
 * @category 数据采集
 * @author Lee[create]
 * @author Andy.Gao[fix]
 * @version 1.1
 *
 */
public class Pgt00302DAO extends BaseDAO implements IPgt00302DAO {

	private static final String total = "TOTAL";
	private static final String rid = "RID";
	private static final String fcid = "FCID";
	private static final String cd00301Swid = "CD_00301_SWID";
	private static final String cd00303Lfid = "CD_00303_LFID";
	private static final String cd00001Fwlx = "CD_00001_FWLX";
	private static final String cd00001Jylx = "CD_00001_JYLX";
	private static final String cd00001Jzjg = "CD_00001_JZJG";
	private static final String jzmj = "JZMJ";
	private static final String szlc = "SZLC";
	private static final String bwjfh = "BWJFH";
	private static final String jyjg = "JYJG";
	private static final String tdsyqmj = "TDSYQMJ";
	private static final String rjl = "RJL";
	private static final String jysj = "JYSJ";
	private static final String fdcdat = "FDCDAT";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String nsrmc = "NSRMC";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String cd00352Xqdm = "CD_00352_XQDM";
	private static final String cd00001Szqy = "CD_00001_SZQY";
	private static final String ywdt = "YWDT";
	private static final String zlc = "ZLC";
	private static final String xqnm = "XQNM";
	private static final String xqbm = "XQBM";
	private static final String szqy = "SZQY";
	private static final String fwlx = "FWLX";
	private static final String jylx = "JYLX";
	private static final String jzjg = "JZJG";
	private static final String czr = "CZR";
	private static final String sumJzmj = "SUM_JZMJ";
	private static final String sumJyjg = "SUM_JYJG";
	private static final String sumTdsyqmj = "SUM_TDSYQMJ";
	private static final String avgRjl = "AVG_RJL";
	private static final String fwlxSc = "FWLX_SC";
	private static final String jylxSc = "JYLX_SC";
	private static final String pgjg = "PGJG";
	private static final String gbpgjg = "GBPGJG";
//	private static final String jsze = "JSZE";
//	private static final String ynze = "YNZE";
	private static final String sumPgjg = "SUM_PGJG";
	private static final String sumGbpgjg = "SUM_GBPGJG";
	private static final String sumScpgjg = "SUM_SCPGJG";
	private static final String sczt = "SCZT";
	private static final String fczh = "FCZH";
	private static final String qdh = "QDH";
	private static final String cb = "CB";
	private static final String ghyt = "GHYT";
	private static final String hxjg = "HXJG";
	private static final String jcsj = "JCSJ";
	private static final String djrq = "DJRQ";
	private static final String fwtdzl = "FWTDZL";
	private static final String zcdzbm = "ZCDZBM";
	private static final String zcdzl = "ZCDZL";
	private static final String zjlx = "ZJLX";
	private static final String cd00001Zjlx = "CD_00001_ZJLX";
	private static final String lxdh = "LXDH";
	private static final String parentdm = "PARENTDM";
	private static final String zjhm = "ZJHM";
	private static final String scpgjg = "SCPGJG";
	private static final String zhxz = "ZHXZ";
	private static final String clh = "CLH";
	private static final String ywjkc="YWJKC";
	private static final String cd00001csfzjlx= "CD_00001_CSFZJLX";
	private static final String csfzjlx="CSFZJLX";
	private static final String csfnsrmc= "CSFNSRMC";
	private static final String csfzjhm= "CSFZJHM";
	private static final String fcslh="FCSLH";
	private static final String yjg = "YJG";
	private static final String sbpgjg = "SBPGJG";
	private static final String fpid = "FPID";
	private static final String ssgx = "SSGX";
	private static final String spid = "SPID";
	private static final String dfspid = "dfspid";
	private static final String ownroomid = "OWNROOMID";
	private static final String sfsyfc = "SFSYFC";
	private static final String sfsyfcdm = "SFSYFCDM";
	private static final String CD00001FWLX = "CD_00001_FWLX";
	private static final String CD00001JYLX = "CD_00001_JYLX";
	private static final String CD00001JZJG = "CD_00001_JZJG";
	private static final String CD00001ZRFSFLX = "CD_00001_ZRFSFLX";
	private static final String CD00001CSFSFLX = "CD_00001_CSFSFLX";
	private static final String CD00001SJYT = "CD_00001_SJYT";
	private static final String OINSID = "OINSID";
	private static final String ROOMID = "ROOMID";
	private static final String INFOMSG = "infomsg";
	private static final String lh="LH";
	private static final String dyh="DYH";
	private static final String wsrq = "QSWSRQ";
	private static final String wsjs = "QSWSJS";
	
	private static final String qs = "QS";
	private static final String yys = "YYS";
	private static final String cjs = "CJS";
	private static final String jyfj = "JYFJ";
	private static final String gs = "GS";
	private static final String yhs = "YHS";
	private static final String tdzzs = "TDZZS";
	private static final String jyffj = "JYFFJ";
	private static final String mfgjdm = "mfgjdm";
	private static final String gmfgjdm = "gmfgjdm";
	private static final String cd00001MFGJDM = "cd_00001_MFGJDM";
	private static final String cd00001GMFGJDM = "cd_00001_GMFGJDM";
	private static final String sbhzr = "sbh_zr";
	private static final String sbhcs = "sbh_cs";
	private static final String nsrLxZr = "nsrLx_Zr";
	private static final String nsrLxCs = "nsrLx_Cs";
	private static final String zrfTel = "ZRFTEL";
	private static final String csfTel = "CSFTEL";
	private static final String gaNote = "GANOTE";
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00302DAO#LoadAll(com.sunway.vo.Pgv00302)
	 */
	
	@Override
	public Pgv00302 LoadAll(Pgv00302 v00302) throws Exception {
		Pgv00302 listResult = new Pgv00302();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00302(?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(3, v00302.getPageIndex());
			call.setInt(4, v00302.getPageSize());
			call.setString(5, v00302.getFcid());
			call.setString(6, v00302.getCd00301Swid());
			call.setString(7, v00302.getNsrmc());
			call.setString(8, v00302.getFwtdzl());
			call.setString(9, v00302.getCd00352Xqdm());
			call.setString(10, v00302.getCd00001Szqy());
			call.setString(11, v00302.getCd00001Ssgx());
			call.setString(12, v00302.getFcslh());
			call.execute();
			//返回列合
			rsSum = (ResultSet) call.getObject(2);
			while(null!=rsSum && rsSum.next()){
				listResult.setSumJzmj(rsSum.getDouble(sumJzmj));
				listResult.setSumJyjg(rsSum.getDouble(sumJyjg));
				//listResult.setSumDtgj(rsSum.getDouble(sumDtgj));
				listResult.setSumTdsyqmj(rsSum.getDouble(sumTdsyqmj));
				listResult.setAvgRjl(rsSum.getDouble(avgRjl));
			}
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.getV00302List().add(SetVParameters(rs));
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
	 * @see com.sunway.dao.IPgt00302DAO#LoadByPrimaryKey(com.sunway.vo.Pgt00302)
	 */
	
	@Override
	public Pgt00302 LoadByPrimaryKey(Pgt00302 t00302) throws Exception {
		ArrayList<Pgt00302> listResult = new ArrayList<Pgt00302>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00302(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t00302.getFcid());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		if (listResult != null && listResult.size() > 0) {
			return listResult.get(0);
		} else {
			return new Pgt00302();
		}
	}
	
	
	public Pgt00302 LoadByPrimaryKey_B(Pgt00302 t00302) throws Exception {
		ArrayList<Pgt00302> listResult = new ArrayList<Pgt00302>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00302_B(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t00302.getFcid());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		if (listResult != null && listResult.size() > 0) {
			return listResult.get(0);
		} else {
			return new Pgt00302();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00302DAO#LoadMaxFcId()
	 */
	
	@Override
	public String LoadMaxFcId(String t00302) throws Exception {
		String resultValue = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{? = call fn_getfcid_sc()}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			call.execute();
			// 返回数据集
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
	 * @see com.sunway.dao.IPgt00302DAO#GetInsertCommand(com.sunway.vo.Pgt00302)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt00302 t00302) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT003020(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			                                               
			// 传入输入参数
			call.setString(1, t00302.getFcid());
			call.setString(2, t00302.getCd00301Swid());
			call.setString(3, t00302.getNsrmc());
			call.setString(4, t00302.getCd00001Zjlx());
			call.setString(5, t00302.getZz());
			call.setString(6, t00302.getLxdh());
			call.setString(7, t00302.getNote2());
			call.setString(8, t00302.getCd00303Lfid());
			call.setString(9, t00302.getCd00001Fwlx());
			call.setString(10, t00302.getCd00001Jylx());
			call.setString(11, t00302.getCd00001Jzjg());
			call.setBigDecimal(12, Common.checkNull(t00302.getJzmj()));
			call.setShort(13, Common.checkNull(t00302.getSzlc()));
			call.setString(14, t00302.getBwjfh());
			call.setBigDecimal(15, Common.checkNull(t00302.getJyjg()));
			call.setDouble(16, Common.checkNull(t00302.getTdsyqmj()));
			call.setDouble(17, Common.checkNull(t00302.getRjl()));
			call.setTimestamp(18, t00302.getJysj());
			call.setString(19, t00302.getFdcdat());
			call.setString(20, t00302.getCd00002Czr());
			call.setString(21, t00302.getNote());
			call.setString(22, t00302.getFczh());
			call.setString(23, t00302.getQdh());
			call.setString(24, t00302.getCb());
			call.setString(25, t00302.getGhyt());
			call.setString(26, t00302.getHxjg());
			call.setString(27, t00302.getJcsj());
			call.setDate(28, Common.converDate(t00302.getDjrq()));
			call.setString(29, t00302.getShr());
			call.setString(30, t00302.getCd00352Xqdm());
			call.setString(31, t00302.getCd00001Jzjg1());
			call.setBoolean(32, Common.checkNull(t00302.getYwdt()));
			call.setShort(33, Common.checkNull(t00302.getZlc()));
			call.setString(34, t00302.getNote1());
			call.setString(35, t00302.getZcdzl());
			call.setString(36, t00302.getZcdzbm());
			call.setString(37, t00302.getCd00053Qtxzid());
			call.setString(38, t00302.getCd00001Ssgx());
			call.setByte(39, t00302.getCd00352Xqzt());
			call.setString(40, t00302.getCd00001Szqy());
			call.setString(41, t00302.getCd00352Parentdm());
			call.setString(42, t00302.getCd00352Xqnm());
			call.setString(43, t00302.getZhxz());
			call.setString(44, t00302.getClh());
			call.setBoolean(45, Common.checkNull(t00302.getYwjkc()));
			call.setString(46,t00302.getTxtCSFZJLX());
			call.setString(47,t00302.getTxtCSFNSRMC());
			call.setString(48,t00302.getTxtCSFZJHM());
			call.setString(49,t00302.getTxtFCSLH());
			call.setInt(50, Common.checkNull(t00302.getOinsid()));
			call.setDouble(51, Common.checkNull(t00302.getYjg()));
			call.setDouble(52, Common.checkNull(t00302.getSbpgjg()));
			call.setString(53, t00302.getRoomid());
			call.setString(54, t00302.getOwnRoomid());
			call.setInt(55, Common.checkNull(t00302.getSfsyfc()));
			call.setString(56, t00302.getLh());
			call.setString(57, t00302.getDyh());
			call.setInt(58, Common.checkNull(t00302.getIsExistQmpg()));
			call.setString(59, t00302.getCsflxdh());
			call.setDate(60, Common.converDate(t00302.getWsrq()));
			call.setDouble(61, Common.checkNull(t00302.getWsjs()));
			call.setString(62, t00302.getCd00001Mfgjdm());
			call.setString(63, t00302.getCd00001Gmfgjdm());
			call.setString(64, t00302.getSbh_zr());
			call.setString(65, t00302.getSbh_cs());
			call.setInt(66, Common.checkNull(t00302.getNsrLx_zr()));
			call.setInt(67, Common.checkNull(t00302.getNsrLx_cs()));
			call.setString(68, t00302.getHtbh());
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

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00302DAO#GetUpdateCommand(com.sunway.vo.Pgt00302)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt00302 t00302) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT00302(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 传入输入参数
			call.setString(1, t00302.getFcid());
			call.setString(2, t00302.getCd00301Swid());
			call.setString(3, t00302.getCd00303Lfid());
			call.setString(4, t00302.getCd00001Fwlx());
			call.setString(5, t00302.getCd00001Jylx());
			call.setString(6, t00302.getCd00001Jzjg());
			call.setBigDecimal(7, Common.checkNull(t00302.getJzmj()));
//			call.setString(8, t00302.getCd00001Fwcx());
//			call.setString(9, t00302.getCd00001Cgzk());
			call.setShort(8, Common.checkNull(t00302.getSzlc()));
			call.setString(9, t00302.getBwjfh());
			call.setBigDecimal(10, Common.checkNull(t00302.getJyjg()));
			call.setDouble(11, Common.checkNull(t00302.getTdsyqmj()));
			call.setDouble(12, Common.checkNull(t00302.getRjl()));
			call.setTimestamp(13, t00302.getJysj());
			call.setString(14, t00302.getFdcdat());
			call.setString(15, t00302.getCd00002Czr());
			call.setString(16, t00302.getNote());
			call.setString(17, t00302.getFczh());
			call.setString(18, t00302.getQdh());
			call.setString(19, t00302.getCb());
			call.setString(20, t00302.getGhyt());
			call.setString(21, t00302.getHxjg());
			call.setString(22, t00302.getJcsj());
			call.setDate(23, Common.converDate(t00302.getDjrq()));
			call.setString(24, t00302.getShr());
//			call.setString(27, t00302.getCd00001Jtzk());
//			call.setString(28, t00302.getCd00001Wyzk());
//			call.setString(29, t00302.getCd00001Zxzk());
			call.setString(25, t00302.getCd00352Xqdm());
			call.setString(26, t00302.getCd00001Jzjg1());
			call.setBoolean(27, Common.checkNull(t00302.getYwdt()));
			call.setShort(28, Common.checkNull(t00302.getZlc()));
			call.setString(29, t00302.getNote1());
			call.setString(30, t00302.getZcdzl());
			call.setString(31, t00302.getZcdzbm());
			call.setString(32, t00302.getCd00053Qtxzid());
			call.setString(33, t00302.getCd00001Ssgx());
			call.setDate(34, Common.converDate(t00302.getBgsj()));
			call.setInt(35, Common.checkNull(t00302.getBglx()));
			call.setString(36, t00302.getZhxz());
			call.setString(37, t00302.getClh());
			call.setBoolean(38, Common.checkNull(t00302.getYwjkc()));
			call.setString(39,t00302.getTxtCSFZJLX());
			call.setString(40,t00302.getTxtCSFNSRMC());
			call.setString(41,t00302.getTxtCSFZJHM());
			call.setString(42,t00302.getTxtFCSLH());
			call.setDouble(43, Common.checkNull(t00302.getYjg()));
			call.setDouble(44, Common.checkNull(t00302.getSbpgjg()));
			call.setString(45,t00302.getLh());
			call.setString(46,t00302.getDyh());
			call.setInt(47, Common.checkNull(t00302.getIsExistQmpg()));
			call.setInt(48, Common.checkNull(t00302.getSfsyfc()));
			call.setString(49, t00302.getCsflxdh());
			call.setDate(50, Common.converDate(t00302.getWsrq()));
			call.setDouble(51, Common.checkNull(t00302.getWsjs()));
			call.setString(52, t00302.getCd00001Mfgjdm());
			call.setString(53, t00302.getCd00001Gmfgjdm());
			call.setString(54, t00302.getSbh_zr());
			call.setString(55, t00302.getSbh_cs());
			call.setInt(56, Common.checkNull(t00302.getNsrLx_zr()));
			call.setInt(57, Common.checkNull(t00302.getNsrLx_cs()));
			call.setString(58, t00302.getHtbh());
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

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00302DAO#GetDeleteCommand(com.sunway.vo.Pgt00302)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt00302 t00302) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00302(?,?,?,?,?)}");
			// 传入输入参数
			call.setString(1, t00302.getFcid());
			call.setString(2, t00302.getCd00002Czr());
			call.setString(3, t00302.getCd00001Ssgx());
			call.setDate(4, Common.converDate(t00302.getBgsj()));
			call.setInt(5, t00302.getBglx());
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

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00302DAO#LoadDetail(com.sunway.vo.Pgv00302)
	 */
	
	@Override
	public Pgv00302 LoadDetail(Pgv00302 v00302) throws Exception {
		ArrayList<Pgv00302> listResult = new ArrayList<Pgv00302>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003020(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v00302.getFcid());
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
			return new Pgv00302();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00302DAO#LoadDetail(com.sunway.vo.Pgv00302)
	 */
	
	@Override
	public Pgv00302 LoadDetail_B(Pgv00302 v00302) throws Exception {
		ArrayList<Pgv00302> listResult = new ArrayList<Pgv00302>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003020_B(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v00302.getFcid());
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
			return new Pgv00302();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00302DAO#GetFdcdatByFcid(com.sunway.vo.Pgt00302)
	 */
	
	@Override
	public Boolean GetFdcdatByFcid(Pgt00302 t00302) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_003022(?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			// 注册输入参数
			call.setString(2, t00302.getFcid());
			call.setString(3, t00302.getFdcdat());
			call.execute();
			if((Integer)call.getObject(1)>0) bResult = true;
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00302DAO#LoadPgv003025(com.sunway.vo.Pgv00302)
	 */
	
	@Override
	public Pgv00302 LoadPgv003025(Pgv00302 v00302) throws Exception {
		Pgv00302 listResult = new Pgv00302();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003025(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(3, v00302.getPageIndex());
			call.setInt(4, v00302.getPageSize());
			call.setString(5, v00302.getFcid());
			call.setString(6, v00302.getCd00301Swid());
			call.setString(7, v00302.getNsrmc());
			call.setString(8, v00302.getXqnm());
			call.setString(9, v00302.getZcdzl());
			call.setString(10, v00302.getCd00001Szqy());
			call.setString(11, v00302.getCd00001Ssgx());
			call.setInt(12, v00302.getSczt());
			call.setString(13, v00302.getZcdzbm());
			call.setString(14, v00302.getFczh());
			call.setString(15, v00302.getCd00001Jzjg());
			call.setShort(16, v00302.getSzlc());
			call.setString(17, v00302.getCd00001Jylx());
			call.setDouble(18, v00302.getJzmj_min());
			call.setDouble(19, v00302.getJzmj_max());
			call.setString(20, v00302.getCd00001Fwlx());
			call.setDouble(21, v00302.getJyjg_min());
			call.setDouble(22, v00302.getJyjg_max());
			call.setDate(23, Common.converDate(v00302.getDjrq()));
			call.setDate(24, Common.converDate(v00302.getJysj_min()));
			call.setDate(25, Common.converDate(v00302.getJysj_max()));
			call.setString(26, v00302.getCd00002Czr());
			call.setDate(27, Common.converDate(v00302.getUpddateS()));
			call.setDate(28, Common.converDate(v00302.getUpddateE()));
			call.setString(29, v00302.getFcslh());
			call.execute();
			//返回列合
			rsSum = (ResultSet) call.getObject(2);
			while(null!=rsSum && rsSum.next()){
				listResult.setSumJzmj(rsSum.getDouble(sumJzmj));
				listResult.setSumJyjg(rsSum.getDouble(sumJyjg));
				listResult.setSumTdsyqmj(rsSum.getDouble(sumTdsyqmj));
				listResult.setAvgRjl(rsSum.getDouble(avgRjl));
				listResult.setSumPgjg(rsSum.getDouble(sumPgjg));
				listResult.setSumGbpgjg(rsSum.getDouble(sumGbpgjg));
				listResult.setSumScpgjg(rsSum.getDouble(sumScpgjg));
			}
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.getV00302List().add(SetV003025Parameters(rs));
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
	 * @see com.sunway.dao.IPgt00302DAO#LoadPgv003025(com.sunway.vo.Pgv00302)
	 */
	
	@Override
	public Pgv00302 LoadPgv003025_B(Pgv00302 v00302) throws Exception {
		Pgv00302 listResult = new Pgv00302();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00302_B(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(3, v00302.getPageIndex());
			call.setInt(4, v00302.getPageSize());
			call.setString(5, v00302.getFcid());
			call.setString(6, v00302.getCd00301Swid());
			call.setString(7, v00302.getNsrmc());
			call.setString(8, v00302.getXqnm());
			call.setString(9, v00302.getZcdzl());
			call.setString(10, v00302.getCd00001Szqy());
			call.setString(11, v00302.getCd00001Ssgx());
			call.setInt(12, v00302.getSczt());
			call.setString(13, v00302.getZcdzbm());
			call.setString(14, v00302.getFczh());
			call.setString(15, v00302.getCd00001Jzjg());
			call.setShort(16, v00302.getSzlc());
			call.setString(17, v00302.getCd00001Jylx());
			call.setDouble(18, v00302.getJzmj_min());
			call.setDouble(19, v00302.getJzmj_max());
			call.setString(20, v00302.getCd00001Fwlx());
			call.setDouble(21, v00302.getJyjg_min());
			call.setDouble(22, v00302.getJyjg_max());
			call.setDate(23, Common.converDate(v00302.getDjrq()));
			call.setDate(24, Common.converDate(v00302.getJysj_min()));
			call.setDate(25, Common.converDate(v00302.getJysj_max()));
			call.setString(26, v00302.getCd00002Czr());
			call.setDate(27, Common.converDate(v00302.getUpddateS()));
			call.setDate(28, Common.converDate(v00302.getUpddateE()));
			call.setString(29, v00302.getFcslh());
			call.setDate(30, Common.converDate(v00302.getUpddateSRD()));
			call.setDate(31, Common.converDate(v00302.getUpddateERD()));
			call.execute();
			//返回列合
			rsSum = (ResultSet) call.getObject(2);
			while(null!=rsSum && rsSum.next()){
				listResult.setSumJzmj(rsSum.getDouble(sumJzmj));
				listResult.setSumJyjg(rsSum.getDouble(sumJyjg));
				listResult.setSumTdsyqmj(rsSum.getDouble(sumTdsyqmj));
				listResult.setAvgRjl(rsSum.getDouble(avgRjl));
				listResult.setSumPgjg(rsSum.getDouble(sumPgjg));
				listResult.setSumGbpgjg(rsSum.getDouble(sumGbpgjg));
				listResult.setSumScpgjg(rsSum.getDouble(sumScpgjg));
			}
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.getV00302List().add(SetV003025Parameters(rs));
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
	protected Pgv00302 SetVParameters(ResultSet rs) throws Exception {
		Pgv00302 e = new Pgv00302();
		e.setRecordCount(rs.getInt(total));
		e.setRecordIndex(rs.getInt(rid));
		e.setFcid(rs.getString(fcid));
		e.setCd00301Swid(rs.getString(cd00301Swid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJzmj(rs.getDouble(jzmj));
//		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
//		e.setCd00001Cgzk(rs.getString(cd00001Cgzk));
		e.setSzlc(rs.getShort(szlc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setJyjg(rs.getDouble(jyjg));
		e.setFwtdzl(rs.getString(fwtdzl));
		e.setTdsyqmj(rs.getDouble(tdsyqmj));
		e.setRjl(rs.getDouble(rjl));
		e.setJysj(rs.getDate(jysj));
		e.setFdcdat(rs.getString(fdcdat));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00352Xqdm(rs.getString(cd00352Xqdm));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setYwdt(rs.getString(ywdt));
		e.setZlc(rs.getString(zlc));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setFwlx(rs.getString(fwlx));
		e.setJylx(rs.getString(jylx));
		e.setJzjg(rs.getString(jzjg));
//		e.setFwcx(rs.getString(fwcx));
//		e.setCgzk(rs.getString(cgzk));
		e.setCzr(rs.getString(czr));
		e.setZjhm(rs.getString(zjhm));
		e.setClh(rs.getString(clh));
		e.setYwjkc(rs.getBoolean(ywjkc));
	    e.setCsfnsrmc(rs.getString(csfnsrmc));
	    e.setCsfzjhm(rs.getString(csfzjhm));
	    e.setFcslh(rs.getString(fcslh));
	    e.setCsfZjlx(rs.getString(csfzjlx));
		return e;
	}
	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00352xml SetXMLParameters(ResultSet rs,boolean sign) throws Exception {
		Pgt00352xml e=new Pgt00352xml();
		e.setRecordCount(rs.getInt(total));
		e.setRecordIndex(rs.getInt(rid));
		e.setFcid(rs.getString(fcid));
		e.setFCSLH(rs.getString("FCSLH"));
		e.setYFCZH(rs.getString("YFCZH"));
		e.setZRFSFLX(rs.getString("ZRFSFLX"));
		e.setZRFSFID(rs.getString("ZRFSFID"));
		e.setZRFMC(rs.getString("ZRFMC"));
		e.setCSFSFLX(rs.getString("CSFSFLX"));
		e.setCSFSFID(rs.getString("CSFSFID"));
		e.setCSFMC(rs.getString("CSFMC"));
		e.setCLH(rs.getString("CLH"));
		e.setSJYT(rs.getString("SJYT"));
		e.setLFDZ(rs.getString("LFDZ"));
		e.setDYFH(rs.getString("DYFH"));
		e.setSZLC(rs.getString("SZLC"));
		e.setZLC(rs.getString("ZLC"));
		e.setJZJG(rs.getString("JZJG"));
		e.setFWLX(rs.getString("FWLX"));
		e.setJYLX(rs.getString("JYLX"));
		e.setJZMJ(rs.getDouble("JZMJ"));
		e.setHTZJ(rs.getDouble("HTZJ"));
		e.setJYSJ(rs.getDate("JYSJ"));
		e.setFZRQ(rs.getDate("FZRQ"));
		e.setDF(rs.getString("DF"));
		e.setCzzt(0);
		e.setCG(rs.getString("CG"));
		e.setCX(rs.getString("CX"));
		e.setOINSID(rs.getString("OINSID"));
		e.setOwnRoomid(rs.getString("OWNROOMID"));
		e.setSfsyfcmc(rs.getString("SFSYFC"));
		e.setYJG(rs.getDouble("YJG"));
		e.setPGJG(rs.getDouble("PGJG"));
		e.setNote(rs.getString("NOTE"));
		if(sign){
			e.setInfoMsg(rs.getString(INFOMSG));
		}
		return e;
	}
	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00352xml SetXMLDParameters(ResultSet rs,boolean sign) throws Exception {
		Pgt00352xml e=new Pgt00352xml();
//		e.setRecordCount(rs.getInt(total));
//		e.setRecordIndex(rs.getInt(rid));
		e.setFcid(rs.getString(fcid));
		e.setFCSLH(rs.getString("FCSLH"));
		e.setYFCZH(rs.getString("YFCZH"));
		e.setZRFSFLX(rs.getString("ZRFSFLX"));
		e.setZRFSFID(rs.getString("ZRFSFID"));
		e.setZRFMC(rs.getString("ZRFMC"));
		e.setCSFSFLX(rs.getString("CSFSFLX"));
		e.setCSFSFID(rs.getString("CSFSFID"));
		e.setCSFMC(rs.getString("CSFMC"));
		e.setCLH(rs.getString("CLH"));
		e.setSJYT(rs.getString("SJYT"));
		e.setLFDZ(rs.getString("LFDZ"));
		e.setDYFH(rs.getString("DYFH"));
		e.setSZLC(rs.getString("SZLC"));
		e.setZLC(rs.getString("ZLC"));
		e.setJZJG(rs.getString("JZJG"));
		e.setFWLX(rs.getString("FWLX"));
		e.setJYLX(rs.getString("JYLX"));
		e.setJZMJ(rs.getDouble("JZMJ"));
		e.setHTZJ(rs.getDouble("HTZJ"));
		e.setJYSJ(rs.getDate("JYSJ"));
		e.setFZRQ(rs.getDate("FZRQ"));
		e.setDF(rs.getString("DF"));
		e.setCzzt(0);
		//e.setJysj(rs.getDate("JYSJ"));
		//e.setDjrq(rs.getDate("FZRQ"));
		e.setCG(Common.checkNull(rs.getString("CG")));
		e.setCX(rs.getString("CX"));
		e.setOINSID(rs.getString("OINSID"));
		//e.setJyjg(Common.convertToDouble(e.getHTZJ()));
		e.setYJG(rs.getDouble("YJG"));
		e.setPGJG(rs.getDouble("PGJG"));
//		e.setYjgView(Common.convertToDouble(e.getYJG()));
//		e.setPgjgView(Common.convertToDouble(e.getPGJG()));
		e.setROOMID(rs.getString("ROOMID"));
		e.setOwnRoomid(rs.getString(ownroomid));
		e.setSfsyfcmc(rs.getString(sfsyfc));
		e.setSfsyfc(rs.getInt(sfsyfcdm));
		e.setCd00001csfsflx(rs.getString(CD00001CSFSFLX));
		e.setCd00001fwlx(rs.getString(CD00001FWLX));
		e.setCd00001jylx(rs.getString(CD00001JYLX));
		e.setCd00001jzjg(rs.getString(CD00001JZJG));
		e.setCd00001sjyt(rs.getString(CD00001SJYT));
		e.setCd00001zrfsflx(rs.getString(CD00001ZRFSFLX));
		e.setXqdm(rs.getString(xqbm));
		e.setXqnm(rs.getString(xqnm));
		e.setSzqy(rs.getString(cd00001Szqy));
		e.setJcsj(rs.getString(jcsj));
		e.setWsjs(rs.getDouble(wsjs));
		e.setWsrq(rs.getDate(wsrq));
		e.setZrfTel(rs.getString(zrfTel));
		e.setCsfTel(rs.getString(csfTel));		
		if(sign){
			e.setInfoMsg(rs.getString(INFOMSG));
		}
		return e;
	}
	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00302 SetAParameters(ResultSet rs) throws Exception {
		Pgv00302 e = new Pgv00302();
		e.setFcid(rs.getString(fcid));
		e.setCd00301Swid(rs.getString(cd00301Swid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setCd00001Zjlx(rs.getString(cd00001Zjlx));
		e.setJzmj(rs.getDouble(jzmj));
		e.setSzlc(rs.getShort(szlc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setJyjg(rs.getDouble(jyjg));
		e.setFwtdzl(rs.getString(fwtdzl));
		e.setLxdh(rs.getString(lxdh));
		e.setTdsyqmj(rs.getDouble(tdsyqmj));
		e.setRjl(rs.getDouble(rjl));
		e.setJysj(rs.getDate(jysj));
		e.setFdcdat(rs.getString(fdcdat));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00352Xqdm(rs.getString(cd00352Xqdm));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setYwdt(rs.getString(ywdt));
		e.setZlc(rs.getString(zlc));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setFwlx(rs.getString(fwlx));
		e.setJylx(rs.getString(jylx));
		e.setJzjg(rs.getString(jzjg));
		e.setCzr(rs.getString(czr));
		e.setZjhm(rs.getString(zjhm));
		e.setZjlx(rs.getString(zjlx));
		e.setDjrq(rs.getDate(djrq));
		e.setClh(rs.getString(clh));
		e.setYwjkc(rs.getBoolean(ywjkc));
		e.setCd00001csfzjlx(rs.getString(cd00001csfzjlx));
		e.setCsfnsrmc(rs.getString(csfnsrmc));
		e.setCsfzjhm(rs.getString(csfzjhm));
		e.setFcslh(rs.getString(fcslh));
		
		return e;
	}

	
	/**
	 * Edit数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00302 SetTParameters(ResultSet rs) throws Exception {
		Pgt00302 e = new Pgt00302();
		e.setFcid(rs.getString(fcid));
		e.setCd00301Swid(rs.getString(cd00301Swid));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJzmj(rs.getBigDecimal(jzmj));
//		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
//		e.setCd00001Cgzk(rs.getString(cd00001Cgzk));
		e.setSzlc(rs.getShort(szlc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setZlc(rs.getShort(zlc));
		e.setJyjg(rs.getBigDecimal(jyjg));
		e.setTdsyqmj(rs.getDouble(tdsyqmj));
		e.setRjl(rs.getDouble(rjl));
		e.setJysj(rs.getTimestamp(jysj));
		e.setFdcdat(rs.getString(fdcdat));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setFwlxSc(rs.getString(fwlxSc));
		e.setJylxSc(rs.getString(jylxSc));
//		e.setCgzkSc(rs.getString(cgzkSc));
		e.setFczh(rs.getString(fczh));
		e.setQdh(rs.getString(qdh));
		e.setCb(rs.getString(cb));
		e.setGhyt(rs.getString("ghytt"));
		e.setCd00001Ghyt(rs.getString(ghyt));
		e.setHxjg(rs.getString(hxjg));
		e.setJcsj(rs.getString(jcsj));
		e.setDjrq(rs.getDate(djrq));
		e.setCd00001Mfgjdm(rs.getString(cd00001MFGJDM));
		e.setCd00001Gmfgjdm(rs.getString(cd00001GMFGJDM));
//		e.setCd00001Wyzk(rs.getString(cd00001Wyzk));
//		e.setCd00001Zxzk(rs.getString(cd00001Zxzk));
		e.setMfgjdm(rs.getString(mfgjdm));
		e.setGmfgjdm(rs.getString(gmfgjdm));
//		e.setWyzk(rs.getString(wyzk));
//		e.setZxzk(rs.getString(zxzk));
//		e.setFwcx(rs.getString(fwcx));
		e.setJzjg(rs.getString(jzjg));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setClh(rs.getString(clh));
		e.setZcdzl(rs.getString("FWTDZL"));
		e.setYwjkc(rs.getBoolean(ywjkc));
		e.setCd00001csfzjlx(rs.getString(cd00001csfzjlx));
		e.setTxtCSFZJLX(rs.getString("CSFZJLX"));
		e.setTxtCSFNSRMC(rs.getString(csfnsrmc));
		e.setTxtCSFZJHM(rs.getString(csfzjhm));
		e.setTxtFCSLH(rs.getString(fcslh));
		e.setYjg(rs.getDouble("yjg"));
		e.setSbpgjg(rs.getDouble("sbpgjg"));
		e.setFpid(rs.getString(fpid));
		e.setSpid(rs.getString(spid));
		e.setDfspid(rs.getString(dfspid));
		e.setSfsyfc(rs.getInt("sfsyfc"));
		e.setLh(rs.getString(lh));
		e.setDyh(rs.getString(dyh));
		e.setIsExistQmpg(rs.getInt("IS320"));
		e.setCsflxdh(rs.getString("csflxdh"));
		e.setWsrq(rs.getDate(wsrq));
		e.setWsjs(rs.getDouble(wsjs));
		e.setSbh_zr(rs.getString(sbhzr));
		e.setSbh_cs(rs.getString(sbhcs));
		e.setNsrLx_zr(rs.getInt(nsrLxZr));
		e.setNsrLx_cs(rs.getInt(nsrLxCs));
		e.setHtbh(rs.getString("HTBH"));
		return e;
	}

	/**
	 * Detail数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00302 SetDParameters(ResultSet rs) throws Exception {
		Pgv00302 e = new Pgv00302();
		e.setFcid(rs.getString(fcid));
		e.setCd00301Swid(rs.getString(cd00301Swid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJzmj(rs.getDouble(jzmj));
//		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
//		e.setCd00001Cgzk(rs.getString(cd00001Cgzk));
		e.setSzlc(rs.getShort(szlc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setJyjg(rs.getDouble(jyjg));
		e.setFwtdzl(rs.getString(fwtdzl));
		e.setTdsyqmj(rs.getDouble(tdsyqmj));
		e.setRjl(rs.getDouble(rjl));
		e.setJysj(rs.getDate(jysj));
		e.setFdcdat(rs.getString(fdcdat));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setZjlx(rs.getString(zjlx));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00352Xqdm(rs.getString(cd00352Xqdm));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setYwdt(rs.getString(ywdt));
		e.setZlc(rs.getString(zlc));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setFwlx(rs.getString(fwlx));
		e.setJylx(rs.getString(jylx));
		e.setJzjg(rs.getString(jzjg));
		e.setZjhm(rs.getString(zjhm));
		e.setFczh(rs.getString(fczh));
//		e.setFwcx(rs.getString(fwcx));
//		e.setCgzk(rs.getString(cgzk));
		e.setCzr(rs.getString(czr));
//		e.setJtzk(rs.getString(jtzk));
//		e.setWyzk(rs.getString(wyzk));
//		e.setZxzk(rs.getString(zxzk));
		e.setZhxz(rs.getString(zhxz));
		e.setClh(rs.getString(clh));
		e.setYwjkc(rs.getBoolean(ywjkc));
		e.setCd00001csfzjlx(rs.getString(cd00001csfzjlx));
		e.setCsfnsrmc(rs.getString(csfnsrmc));
		e.setCsfzjhm(rs.getString(csfzjhm));
		e.setFcslh(rs.getString(fcslh));
		e.setCsfZjlx(rs.getString(csfzjlx));
		e.setYjg(rs.getDouble(yjg));
		e.setSbpgjg(rs.getDouble(sbpgjg));
		e.setFpid(rs.getString(fpid));
		e.setSpid(rs.getString(spid));
		e.setDfspid(rs.getString(dfspid));
		e.setLh(rs.getString(lh));
		e.setDyh(rs.getString(dyh));
		e.setDjrq(rs.getDate(djrq));
		e.setJcsj(rs.getString("jcsj"));
		e.setSbh_zr(rs.getString(sbhzr));
		e.setSbh_cs(rs.getString(sbhcs));
		e.setSsgx(rs.getString(ssgx));
		e.setHtbh(rs.getString("HTBH"));
		return e;
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv00302 SetV003025Parameters(ResultSet rs) throws Exception {
		Pgv00302 e = new Pgv00302();
		e.setRecordCount(rs.getInt(total));
		e.setRecordIndex(rs.getInt(rid));
		e.setFcid(rs.getString(fcid));
		e.setCd00301Swid(rs.getString(cd00301Swid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJzmj(rs.getDouble(jzmj));
		e.setSzlc(rs.getShort(szlc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setJyjg(rs.getDouble(jyjg));
		e.setTdsyqmj(rs.getDouble(tdsyqmj));
		e.setRjl(rs.getDouble(rjl));
		e.setJysj(rs.getDate(jysj));
		e.setFdcdat(rs.getString(fdcdat));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setFczh(rs.getString(fczh));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setLxdh(rs.getString(lxdh));
		e.setCd00001Zjlx(rs.getString(cd00001Zjlx));
		e.setZjlx(rs.getString(zjlx));
		e.setCd00352Xqdm(rs.getString(cd00352Xqdm));
		e.setParentdm(rs.getString(parentdm));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setYwdt(rs.getString(ywdt));
		e.setZlc(rs.getString(zlc));
		e.setXqnm(rs.getString(xqnm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		//e.setZcdzl(rs.getString(zcdzl));
		e.setZcdzbm(rs.getString(zcdzbm));
		e.setFwtdzl(rs.getString(fwtdzl));
		e.setFwlx(rs.getString(fwlx));
		e.setJylx(rs.getString(jylx));
		e.setJzjg(rs.getString(jzjg));
		e.setCzr(rs.getString(czr));
		e.setSczt(rs.getInt(sczt));
		e.setPgjg(rs.getDouble(pgjg));
		e.setGbpgjg(rs.getDouble(gbpgjg));
		//e.setJsze(rs.getDouble(jsze));
		//e.setYnze(rs.getDouble(ynze));
		e.setDjrq(rs.getDate(djrq));
		e.setZjhm(rs.getString(zjhm));
		e.setScpgjg(rs.getDouble(scpgjg));
		e.setSsgx(rs.getString(ssgx));
		e.setSzxx("点击查看缴税信息");
		//e.setZhxz(rs.getString(zhxz));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00302DAO#GetInsertCommandWs(com.sunway.vo.Pgt00302)
	 */
	
	@Override
	public boolean GetInsertCommandWs(Pgt00302 t00302) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT003021(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			call.registerOutParameter(2, OracleTypes.VARCHAR);	
			call.registerOutParameter(3, OracleTypes.NUMBER);
			// 传入输入参数
			call.setString(4, t00302.getFcid());
			call.setString(5, t00302.getCd00301Swid());
			call.setString(6, t00302.getNsrmc());
			call.setString(7, t00302.getCd00001Zjlx());
			call.setString(8, t00302.getZz());
			call.setString(9, t00302.getLxdh());
			call.setString(10, t00302.getNote2());
			call.setString(11, t00302.getCd00303Lfid());
			call.setString(12, t00302.getCd00001Fwlx());
			call.setString(13, t00302.getCd00001Jylx());
			call.setString(14, t00302.getCd00001Jzjg());
			call.setBigDecimal(15, t00302.getJzmj());
//			call.setString(16, t00302.getCd00001Fwcx());
//			call.setString(17, t00302.getCd00001Cgzk());
			call.setShort(16, t00302.getSzlc());
			call.setString(17, t00302.getBwjfh());
			call.setBigDecimal(18, t00302.getJyjg());
			call.setDouble(19, t00302.getTdsyqmj());
			call.setDouble(20, t00302.getRjl());
			call.setDate(21, Common.converDate(t00302.getJysj()));
			call.setString(22, t00302.getFdcdat());
			call.setString(23, t00302.getCd00002Czr());
			call.setString(24, t00302.getNote());
			call.setString(25, t00302.getFczh());
			call.setString(26, t00302.getQdh());
			call.setString(27, t00302.getCb());
			call.setString(28, t00302.getGhyt());
			call.setString(29, t00302.getHxjg());
			call.setString(30, t00302.getJcsj());
			call.setDate(31, Common.converDate(t00302.getDjrq()));
			call.setString(32, t00302.getShr());
//			call.setString(35, t00302.getCd00001Jtzk());
//			call.setString(36, t00302.getCd00001Wyzk());
//			call.setString(37, t00302.getCd00001Zxzk());
			call.setString(33, t00302.getCd00352Xqdm());
			call.setString(34, t00302.getCd00001Jzjg1());
			call.setBoolean(35, Common.checkNull(t00302.getYwdt()));
			call.setShort(36, t00302.getZlc());
			call.setString(37, t00302.getNote1());
			call.setString(38, t00302.getZcdzl());
			call.setString(39, t00302.getZcdzbm());
			call.setString(40, t00302.getCd00053Qtxzid());
			call.setString(41, t00302.getCd00001Ssgx());
			call.setString(42, t00302.getLh());
			call.setString(43, t00302.getZhxz());
			call.setBoolean(44, Common.checkNull(t00302.getYwjkc()));
			call.execute();
			tran.commit();
			//返回值
			if ((Integer)call.getObject(1)>0)
				t00302.setWsIsPg(true);
			else
				t00302.setWsIsPg(false);
			t00302.setWsPgMsg((String)call.getObject(2));
			t00302.setWsPgValue((Double)call.getDouble(3));
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
	 * @see com.sunway.dao.IPgt00302DAO#LoadByFczh(com.sunway.vo.Pgt00302)
	 */
	
	@Override
	public Pgv00302 LoadByFczh(Pgt00302 t00302) throws Exception {
		ArrayList<Pgv00302> listResult = new ArrayList<Pgv00302>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT003021(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t00302.getFczh());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetAParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		if (listResult != null && listResult.size() > 0) {
			return listResult.get(0);
		} else {
			return new Pgv00302();
		}
	}
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExportDjxxSjcx(com.sunway.vo.Pgv10051)
	 */
	
	@Override
	public OutputStream ExportCXSjcx(Pgv00302 v00302) throws Exception {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
		//Pgv00302 listResult = new Pgv00302();
		ResultSet rs = null;
		//ResultSet rsSum = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT0030251(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(3, v00302.getPageIndex());
			call.setInt(4, v00302.getPageSize());
			call.setString(5, v00302.getFcid());
			call.setString(6, v00302.getCd00301Swid());
			call.setString(7, v00302.getNsrmc());
			call.setString(8, v00302.getXqnm());
			call.setString(9, v00302.getZcdzl());
			call.setString(10, v00302.getCd00001Szqy());
			call.setString(11, v00302.getCd00001Ssgx());
			call.setInt(12, Common.checkNull(v00302.getSczt()));
			call.setString(13, v00302.getZcdzbm());
			call.setString(14, v00302.getFczh());
			call.setString(15, v00302.getCd00001Jzjg());
			call.setShort(16, v00302.getSzlc());
			call.setString(17, v00302.getCd00001Jylx());
			call.setDouble(18, v00302.getJzmj_min());
			call.setDouble(19, v00302.getJzmj_max());
			call.setString(20, v00302.getCd00001Fwlx());
			call.setDouble(21, v00302.getJyjg_min());
			call.setDouble(22, v00302.getJyjg_max());
			call.setDate(23, Common.converDate(v00302.getDjrq()));
			call.setDate(24, Common.converDate(v00302.getJysj_min()));
			call.setDate(25, Common.converDate(v00302.getJysj_max()));
			call.setString(26, v00302.getCd00002Czr());
			call.setDate(27, Common.converDate(v00302.getUpddateS()));
			call.setDate(28, Common.converDate(v00302.getUpddateE()));
			call.setString(29, v00302.getFcslh());
			call.execute();

			//返回数据集
			rs = (ResultSet) call.getObject(1);
			Integer j = 0;
			if(rs!=null){
				// 创建excel对象
		        Label label;   
		        Number number;
		        WritableWorkbook workbook; 
	            workbook = Workbook.createWorkbook(strBufResult);   
	            WritableSheet sheet = workbook.createSheet("查询信息", 0);
	            // 写入标头	      
	            label = new Label(j++, 0, "市场状态");
				sheet.addCell(label);
	            label = new Label(j++, 0, "产权人");
	            sheet.addCell(label);	
	            label = new Label(j++, 0, "产权人证件号码");
	            sheet.addCell(label);
	            label = new Label(j++, 0, "税收管辖");
	            sheet.addCell(label);
	            label = new Label(j++, 0, "楼房地址");
	            sheet.addCell(label);
	            label = new Label(j++, 0, "单元及房号");
	            sheet.addCell(label);
				label = new Label(j++, 0, "所在区域");
				sheet.addCell(label);	
				label = new Label(j++, 0, "小区名称");
				sheet.addCell(label);
				label = new Label(j++, 0, "总楼层");
				sheet.addCell(label);
				label = new Label(j++, 0, "所在楼层");
				sheet.addCell(label);
				label = new Label(j++, 0, "房产证号");
				sheet.addCell(label);
				label = new Label(j++, 0, "交易类型");
				sheet.addCell(label);
				label = new Label(j++, 0, "房屋类别");
				sheet.addCell(label);
				label = new Label(j++, 0, "建筑结构");
				sheet.addCell(label);				
				label = new Label(j++, 0, "建筑面积(平方米)");
				sheet.addCell(label);
				label = new Label(j++, 0, "交易时间");
				sheet.addCell(label);
				label = new Label(j++, 0, "合同总价(元)");
				sheet.addCell(label);
				label = new Label(j++, 0, "估价结果(元)");
				sheet.addCell(label);
				label = new Label(j++, 0, "个案评估结果(元)");
				sheet.addCell(label);
				label = new Label(j++, 0, "核定价格(元)");
				sheet.addCell(label);
				label = new Label(j++, 0, "原价格(元)");
				sheet.addCell(label);
				label = new Label(j++, 0, "申报评估价格(元)");
				sheet.addCell(label);				
				label = new Label(j++, 0, "综合修正");
				sheet.addCell(label);	          
				label = new Label(j++, 0, "发证日期");
				sheet.addCell(label);
				label = new Label(j++, 0, "更新日期");
				sheet.addCell(label);
//				label = new Label(j++, 0, "契税(元)");
//				sheet.addCell(label);
//				label = new Label(j++, 0, "营业税(元)");
//				sheet.addCell(label);
//				label = new Label(j++, 0, "城市维护建设税(元)");
//				sheet.addCell(label);
//				label = new Label(j++, 0, "教育费附加、地方教育附加(元)");
//				sheet.addCell(label);
//				label = new Label(j++, 0, "个人所得税(元)");
//				sheet.addCell(label);
//				label = new Label(j++, 0, "印花税(元)");
//				sheet.addCell(label);
//				label = new Label(j++, 0, "土地增值税(元)");
//				sheet.addCell(label);				
//				label = new Label(j++, 0, "发票号码");
//				sheet.addCell(label);
//				label = new Label(j++, 0,"契税税票号码");
//				sheet.addCell(label);
//				label = new Label(j++, 0,"地方各税税票号码");
//				sheet.addCell(label);
				label = new Label(j++, 0,"是否私有房产");
				sheet.addCell(label);
				label = new Label(j++, 0,"承受方证件类型");
				sheet.addCell(label);
				label = new Label(j++, 0,"承受方姓名");
				sheet.addCell(label);
				label = new Label(j++, 0,"承受方证件号码");
				sheet.addCell(label);
				label = new Label(j++, 0,"房产受理号");
				sheet.addCell(label);
				   // 写入数据
				while(null!=rs && rs.next()){
					Integer rowIndex = rs.getRow();	
					j=0;
					label = new Label(j++, rowIndex, readSCZT(rs.getInt(sczt)));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(nsrmc));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(zjhm));
					sheet.addCell(label);	
					label = new Label(j++, rowIndex, rs.getString(ssgx));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(zcdzl));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(bwjfh));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(szqy));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(xqnm));
					sheet.addCell(label);		
					label = new Label(j++, rowIndex, rs.getString(zlc));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(szlc));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(fczh));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(jylx));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(fwlx));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(jzjg));
					sheet.addCell(label);							
					number = new Number(j++, rowIndex, rs.getDouble(jzmj));
					sheet.addCell(number);
					label = new Label(j++, rowIndex, Common.formatToYYYYMMDD(rs.getDate(jysj)));
					sheet.addCell(label);
					number = new Number(j++, rowIndex, rs.getDouble(jyjg));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(pgjg));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(gbpgjg));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(scpgjg));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble("YJG"));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble("SBPGJG"));
					sheet.addCell(number);
					label = new Label(j++, rowIndex, rs.getString(zhxz));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, Common.formatToYYYYMMDD(rs.getDate(djrq)));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, Common.formatToYYYYMMDD(rs.getDate(upddate)));
					sheet.addCell(label);
//					number = new Number(j++, rowIndex, rs.getDouble("QS"));
//					sheet.addCell(number);
//					number = new Number(j++, rowIndex, rs.getDouble("YYS"));
//					sheet.addCell(number);
//					number = new Number(j++, rowIndex, rs.getDouble("CJS"));
//					sheet.addCell(number);
//					number = new Number(j++, rowIndex, rs.getDouble("JYS"));
//					sheet.addCell(number);
//					number = new Number(j++, rowIndex, rs.getDouble("SDS"));
//					sheet.addCell(number);
//					number = new Number(j++, rowIndex, rs.getDouble("YHS"));
//					sheet.addCell(number);
//					number = new Number(j++, rowIndex, rs.getDouble("ZZS"));
//					sheet.addCell(number);					
//					label = new Label(j++, rowIndex, rs.getString(fpid));
//					sheet.addCell(label);
//					label = new Label(j++, rowIndex, rs.getString(spid));
//					sheet.addCell(label);
//					label = new Label(j++, rowIndex, rs.getString(dfspid));
//					sheet.addCell(label);
					if(rs.getInt(sfsyfc)==1){
						label = new Label(j++, rowIndex, "是");
					}else{
						label = new Label(j++, rowIndex, "否");
					}
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(csfzjlx));
					sheet.addCell(label);					
					label =new Label(j++, rowIndex,rs.getString(csfnsrmc));
					sheet.addCell(label);
					label =new Label(j++,rowIndex,rs.getString(csfzjhm));
                    sheet.addCell(label);
                    label =new Label(j++,rowIndex,rs.getString(fcslh));
                    sheet.addCell(label);
				}
	            workbook.write();   
	            workbook.close();  }
				
		}catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return strBufResult;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExportDjxxSjcx(com.sunway.vo.Pgv10051)
	 */
	
	@Override
	public OutputStream ExportCXSjcx_B(Pgv00302 v00302) throws Exception {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
		//Pgv00302 listResult = new Pgv00302();
		ResultSet rs = null;
		//ResultSet rsSum = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00302_B(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(3, v00302.getPageIndex());
			call.setInt(4, v00302.getPageSize());
			call.setString(5, v00302.getFcid());
			call.setString(6, v00302.getCd00301Swid());
			call.setString(7, v00302.getNsrmc());
			call.setString(8, v00302.getXqnm());
			call.setString(9, v00302.getZcdzl());
			call.setString(10, v00302.getCd00001Szqy());
			call.setString(11, v00302.getCd00001Ssgx());
			call.setInt(12, Common.checkNull(v00302.getSczt()));
			call.setString(13, v00302.getZcdzbm());
			call.setString(14, v00302.getFczh());
			call.setString(15, v00302.getCd00001Jzjg());
			call.setShort(16, v00302.getSzlc());
			call.setString(17, v00302.getCd00001Jylx());
			call.setDouble(18, v00302.getJzmj_min());
			call.setDouble(19, v00302.getJzmj_max());
			call.setString(20, v00302.getCd00001Fwlx());
			call.setDouble(21, v00302.getJyjg_min());
			call.setDouble(22, v00302.getJyjg_max());
			call.setDate(23, Common.converDate(v00302.getDjrq()));
			call.setDate(24, Common.converDate(v00302.getJysj_min()));
			call.setDate(25, Common.converDate(v00302.getJysj_max()));
			call.setString(26, v00302.getCd00002Czr());
			call.setDate(27, Common.converDate(v00302.getUpddateS()));
			call.setDate(28, Common.converDate(v00302.getUpddateE()));
			call.setString(29, v00302.getFcslh());
			call.setDate(30, Common.converDate(v00302.getUpddateSRD()));
			call.setDate(31, Common.converDate(v00302.getUpddateERD()));
			call.execute();

			//返回数据集
			rs = (ResultSet) call.getObject(1);
			Integer j = 0;
			if(rs!=null){
				// 创建excel对象
		        Label label;   
		        Number number;
		        WritableWorkbook workbook; 
	            workbook = Workbook.createWorkbook(strBufResult);   
	            WritableSheet sheet = workbook.createSheet("查询信息", 0);
	            // 写入标头	      
	            label = new Label(j++, 0, "市场状态");
				sheet.addCell(label);
	            label = new Label(j++, 0, "产权人");
	            sheet.addCell(label);	
	            label = new Label(j++, 0, "产权人证件号码");
	            sheet.addCell(label);
	            label = new Label(j++, 0, "税收管辖");
	            sheet.addCell(label);
//	            label = new Label(j++, 0, "楼房地址");
//	            sheet.addCell(label);
	            label = new Label(j++, 0, "单元及房号");
	            sheet.addCell(label);
				label = new Label(j++, 0, "所在区域");
				sheet.addCell(label);	
				label = new Label(j++, 0, "小区名称");
				sheet.addCell(label);
				label = new Label(j++, 0, "总楼层");
				sheet.addCell(label);
				label = new Label(j++, 0, "所在楼层");
				sheet.addCell(label);
				label = new Label(j++, 0, "房产证号");
				sheet.addCell(label);
				label = new Label(j++, 0, "交易类型");
				sheet.addCell(label);
				label = new Label(j++, 0, "房屋类别");
				sheet.addCell(label);
				label = new Label(j++, 0, "建筑结构");
				sheet.addCell(label);				
				label = new Label(j++, 0, "建筑面积(平方米)");
				sheet.addCell(label);
				label = new Label(j++, 0, "交易时间");
				sheet.addCell(label);
				label = new Label(j++, 0, "合同总价(元)");
				sheet.addCell(label);
				label = new Label(j++, 0, "估价结果(元)");
				sheet.addCell(label);
				label = new Label(j++, 0, "个案评估结果(元)");
				sheet.addCell(label);
				label = new Label(j++, 0, "核定价格(元)");
				sheet.addCell(label);
				label = new Label(j++, 0, "原价格(元)");
				sheet.addCell(label);
				label = new Label(j++, 0, "申报评估价格(元)");
				sheet.addCell(label);				
				label = new Label(j++, 0, "综合修正");
				sheet.addCell(label);	          
				label = new Label(j++, 0, "发证日期");
				sheet.addCell(label);
				label = new Label(j++, 0, "更新日期");
				sheet.addCell(label);		
//				label = new Label(j++, 0, "发票号码");
//				sheet.addCell(label);
//				label = new Label(j++, 0,"契税税票号码");
//				sheet.addCell(label);
//				label = new Label(j++, 0,"地方各税税票号码");
//				sheet.addCell(label);
				label = new Label(j++, 0,"是否私有房产");
				sheet.addCell(label);
				label = new Label(j++, 0,"承受方证件类型");
				sheet.addCell(label);
				label = new Label(j++, 0,"承受方姓名");
				sheet.addCell(label);
				label = new Label(j++, 0,"承受方证件号码");
				sheet.addCell(label);
				label = new Label(j++, 0,"房产受理号");
				sheet.addCell(label);
				label = new Label(j++, 0,"契税");
				sheet.addCell(label);				
				label = new Label(j++, 0,"营业税");
				sheet.addCell(label);					
				label = new Label(j++, 0,"城建税");
				sheet.addCell(label);					
				label = new Label(j++, 0,"地方教育费附加");
				sheet.addCell(label);					
				label = new Label(j++, 0,"个人所得税");
				sheet.addCell(label);					
				label = new Label(j++, 0,"印花税");
				sheet.addCell(label);					
				label = new Label(j++, 0,"土地增值税");
				sheet.addCell(label);					
				label = new Label(j++, 0,"教育费附加");				
				sheet.addCell(label);
				label = new Label(j++, 0,"备注");
				sheet.addCell(label);		
				label = new Label(j++, 0,"个案原因");
				sheet.addCell(label);					
				// 写入数据
				while(null!=rs && rs.next()){
					Integer rowIndex = rs.getRow();	
					j=0;
					label = new Label(j++, rowIndex, readSCZT(rs.getInt(sczt)));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(nsrmc));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(zjhm));
					sheet.addCell(label);	
					label = new Label(j++, rowIndex, rs.getString(ssgx));
					sheet.addCell(label);
//					label = new Label(j++, rowIndex, rs.getString(zcdzl));
//					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(bwjfh));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(szqy));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(xqnm));
					sheet.addCell(label);		
					label = new Label(j++, rowIndex, rs.getString(zlc));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(szlc));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(fczh));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(jylx));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(fwlx));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(jzjg));
					sheet.addCell(label);							
					number = new Number(j++, rowIndex, rs.getDouble(jzmj));
					sheet.addCell(number);
					label = new Label(j++, rowIndex, Common.formatToYYYYMMDD(rs.getDate(jysj)));
					sheet.addCell(label);
					number = new Number(j++, rowIndex, rs.getDouble(jyjg));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(pgjg));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(gbpgjg));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(scpgjg));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble("YJG"));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble("SBPGJG"));
					sheet.addCell(number);
					label = new Label(j++, rowIndex, rs.getString(zhxz));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, Common.formatToYYYYMMDD(rs.getDate(djrq)));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, Common.formatToYYYYMMDD(rs.getDate(upddate)));
					sheet.addCell(label);				
//					label = new Label(j++, rowIndex, rs.getString(fpid));
//					sheet.addCell(label);
//					label = new Label(j++, rowIndex, rs.getString(spid));
//					sheet.addCell(label);
//					label = new Label(j++, rowIndex, rs.getString(dfspid));
//					sheet.addCell(label);
					if(rs.getInt(sfsyfc)==1){
						label = new Label(j++, rowIndex, "是");
					}else{
						label = new Label(j++, rowIndex, "否");
					}
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(csfzjlx));
					sheet.addCell(label);					
					label =new Label(j++, rowIndex,rs.getString(csfnsrmc));
					sheet.addCell(label);
					label =new Label(j++,rowIndex,rs.getString(csfzjhm));
                    sheet.addCell(label);
                    label =new Label(j++,rowIndex,rs.getString(fcslh));
                    sheet.addCell(label);
					number = new Number(j++, rowIndex, rs.getDouble(qs));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(yys));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(cjs));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(jyfj));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(gs));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(yhs));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(tdzzs)); 
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(jyffj)); 
					sheet.addCell(number);					
                    label =new Label(j++,rowIndex,rs.getString(note));
                    sheet.addCell(label);
                    label =new Label(j++,rowIndex,rs.getString(gaNote));
                    sheet.addCell(label);                    
				}
	            workbook.write();   
	            workbook.close();  }
				
		}catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return strBufResult;
	}
	
	/**
	 * 读取市场状态
	 * @param sczt
	 * @return
	 */
	private String readSCZT(int sczt){
		String result = "";
		try {
			switch (sczt) {
			case 2:
				result = "已估价";
				break;
			case 21:
				result = "估价未通过";
				break;
			case 22:
				result = "已个案估价";
				break;
			case 3:
				result = "打印完成";
				break;
			case 4:
				result = "已交税";
				break;
			default:
				result = "未操作";
				break;
			}
		} catch (Exception e) {
//			LOG.error(e.getMessage());
		}
		return result;
	}

	
	@Override
	public Pgv00357 ImportExcelData(ArrayList<Pgv00357> kbslkList)
			throws Exception {
		
		Pgv00357 v00357 = new Pgv00357();
		Integer resultValue = 0;
		Integer sResultCount = 0;
		ResultSet rs = null;
		Session session = null;
		Connection conn = null;
		CallableStatement call = null;
		Transaction tran = null;
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_ADDT003022(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			for(int i=0; i<kbslkList.size(); i++){
				Pgv00357 kbslk = kbslkList.get(i);
				try {
					call.registerOutParameter(1, OracleTypes.CURSOR);
					
					// 传入输入参数
					call.setString(2, kbslk.getCd00301Swid());
					call.setString(3, kbslk.getNsrmc());
					call.setString(4, kbslk.getCd00303Lfid());
					call.setString(5, kbslk.getFwlx());
					call.setString(6, kbslk.getJylx());
					call.setString(7, kbslk.getJzjg());
					call.setDouble(8, kbslk.getJzmj());
//					call.setString(9, kbslk.getFwcx());
//					call.setString(10, kbslk.getCgzk());
					call.setShort(9, kbslk.getSzlc());
					call.setString(10, kbslk.getBwjfh());
					call.setDouble(11, kbslk.getPgjg());
					call.setDate(12, Common.converDate(kbslk.getJysj()));
					call.setString(13, kbslk.getFdcdat());
					call.setString(14, kbslk.getCd00002Czr());
					call.setString(15, kbslk.getNote());
					call.setString(16, kbslk.getXqnm());
					call.setString(17, kbslk.getCd00001Jzjg());
					call.setBoolean(18, Common.checkNull(kbslk.getYwdt()));
					call.setShort(19, Common.convertToShort(kbslk.getZlc()));
					call.setString(20, kbslk.getNote());
					call.setString(21, kbslk.getZcdzl());
					call.setString(22, kbslk.getZcdzbm());
					call.setString(23, kbslk.getJgzk());
					call.setString(24, kbslk.getCd00001Ssgx());//.getSsgx());
					call.setString(25, kbslk.getFczh());
					call.setString(26, kbslk.getZhxz());
					call.setString(27, kbslk.getClh());
					call.setBoolean(28, Common.checkNull(kbslk.getYwjkc()));
					call.setString(29, kbslk.getSzqy());
					call.setDate(30, Common.converDate(kbslk.getDjrq()));
					call.setString(31, kbslk.getCsfsflx());
					call.setString(32, kbslk.getCsfmc());
					call.setString(33, kbslk.getCsfsfid());
					call.setString(34, kbslk.getFcslh());
					call.setInt(35, kbslk.getOinsid());
					call.setDouble(36, kbslk.getYjg());
					call.setDouble(37, kbslk.getSbpgjg());
					call.setString(38, kbslk.getRoomid());
					call.setString(39, kbslk.getOwnRoomid());
					call.setInt(40, kbslk.getSfsyfc());
					call.execute();
					
					rs = (ResultSet) call.getObject(1); 
					if (null!=rs && rs.next()) {
						if (rs.getInt("flag") == 0) {
							sResultCount++;
							//标记哪一列字段错误
							kbslk.setCd00352Xqdm(rs.getString("TXQDM"));
							kbslk.setCd00001Fwlx(rs.getString("TFWLX"));
							kbslk.setCd00001Jylx(rs.getString("TJYLX"));
							kbslk.setCd00001Jzjg(rs.getString("TJZJG"));
							kbslk.setCd00001Szqy(rs.getString("TSZQY"));
							//kbslk.setCd00001Cgzk(rs.getString("TCGZK"));
							kbslk.setJgzkId(rs.getString("QTXZIDS"));
							kbslk.setZhxzId(rs.getString("ZHXZS"));
							kbslk.setNote("");
							//将数据封装到list
							v00357.getOutList().add(kbslk);
						}
						rs.close();
					}
				} catch (Exception e) {
					sResultCount++;
//					LOG.error(e.getMessage());
					kbslk.setNote(e.getMessage());
					//将数据封装到list
					v00357.getOutList().add(kbslk);
					continue;
				}	
			}
			tran.commit();
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(rs, call, conn, session);
			if(sResultCount == 0)
				resultValue = 2;
			else if(sResultCount > 0)
				resultValue = 1;
			v00357.setOutFlag(resultValue);
		}
		return v00357;
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00302DAO#GetInsertCommandXML(com.sunway.vo.Pgt00352xml)
	 */
	
	@Override
	public boolean GetInsertCommandXML(ArrayList<Pgt00352xml> pgt00352xml) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			for(int i = 0; i < pgt00352xml.size();i++){
				Pgt00352xml t00352xml = pgt00352xml.get(i);
				if(!" ".equals(t00352xml.getSfsyfcmc())){
					if("私有房产".equals(t00352xml.getSfsyfcmc()))
						t00352xml.setSfsyfc(1);
					else
						t00352xml.setSfsyfc(0);
				}else{
					t00352xml.setSfsyfc(2);
				}
				call = conn.prepareCall("{call PGSP_ADDT00371(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				call.setInt(1, 0);
				call.setString(2, t00352xml.getFCSLH());
				call.setString(3, t00352xml.getYFCZH());
				call.setString(4, t00352xml.getZRFSFLX());
				call.setString(5, t00352xml.getZRFSFID());
				call.setString(6, t00352xml.getZRFMC());
				call.setString(7, t00352xml.getCSFSFLX());
				call.setString(8, t00352xml.getCSFSFID());
				call.setString(9, t00352xml.getCSFMC());
				call.setString(10, t00352xml.getCLH());
				call.setString(11, t00352xml.getSJYT());
				call.setString(12, t00352xml.getLFDZ());
				call.setString(13, t00352xml.getDYFH());
				call.setString(14, t00352xml.getSZLC());
				call.setString(15, t00352xml.getZLC());
				call.setString(16, t00352xml.getJZJG());
				call.setString(17, t00352xml.getFWLX());
				call.setString(18, t00352xml.getJYLX());
				call.setDouble(19,t00352xml.getJZMJ());
				call.setDouble(20,t00352xml.getHTZJ());
				call.setDate(21, Common.converDate(t00352xml.getJYSJ()));
				call.setDate(22, Common.converDate(t00352xml.getFZRQ()));
				call.setString(23, t00352xml.getDF());
				call.setString(24, t00352xml.getCX());
				call.setString(25, t00352xml.getCG());
				call.setInt(26, Common.convertToInteger(t00352xml.getOINSID()));
				call.setDouble(27,t00352xml.getYJG());
				call.setDouble(28, t00352xml.getPGJG());
				call.setString(29, t00352xml.getROOMID());
				call.setString(30, t00352xml.getCzr());
				call.setString(31, t00352xml.getOwnRoomid());
				call.setString(32, t00352xml.getSfsyfcmc());
				call.setString(33, t00352xml.getSsgx());
				call.setString(34, t00352xml.getXqdm());
				call.setDate(35, Common.converDate(t00352xml.getWsrq()));
				call.setDouble(36, t00352xml.getWsjs());
				call.setString(37, t00352xml.getJcsj());
				call.setString(38, t00352xml.getZrfTel());
				call.setString(39, t00352xml.getCsfTel());
				call.execute();
			}
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


	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00302DAO#LoadByPrimaryKeyXML(com.sunway.vo.Pgt00352xml)
	 */
	
	@Override
	public Pgt00352xml LoadByPrimaryKeyXML(Pgt00352xml pgt00352xml) throws Exception {
		ArrayList<Pgt00352xml> listResult = new ArrayList<Pgt00352xml>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT00371(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, pgt00352xml.getFcid());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetXMLDParameters(rs,false));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		if (listResult != null && listResult.size() > 0) {
			return listResult.get(0);
		} else {
			return null;
		}
		
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00302DAO#LoadAllXML(com.sunway.vo.Pgt00352xml)
	 */
	
	@Override
	public Pgt00352xml LoadAllXML(Pgt00352xml t00352xml) throws Exception {
		Pgt00352xml listResult = new Pgt00352xml();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00371(?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//输入参数
			call.setInt(2,t00352xml.getPageIndex());
			call.setInt(3, t00352xml.getPageSize());
			call.setString(4, t00352xml.getFCSLH());
			call.setString(5, t00352xml.getCLH());
			call.setString(6, t00352xml.getDYFH());
			call.setString(7, t00352xml.getCzr());
			call.execute();
			//返回列合
//			rsSum = (ResultSet) call.getObject(2);
//			while(null!=rsSum && rsSum.next()){
////				listResult.setSumJzmj(rsSum.getDouble(sumJzmj));
////				listResult.setSumJyjg(rsSum.getDouble(sumJyjg));
////				//listResult.setSumDtgj(rsSum.getDouble(sumDtgj));
////				listResult.setSumTdsyqmj(rsSum.getDouble(sumTdsyqmj));
////				listResult.setAvgRjl(rsSum.getDouble(avgRjl));
//			}
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.getPgt00352xmllist().add(SetXMLParameters(rs,false));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rsSum, rs, call, conn, session);
		}
		return listResult;
	}

	
	@Override
	public boolean GetUpdateCommandXML(Pgt00352xml pgt00352xml)
			throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		CallableStatement call = null;
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_ADDT003023(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, pgt00352xml.getFcid());
			call.setString(2, pgt00352xml.getZRFSFID());
			call.setString(3, pgt00352xml.getZRFMC());
			call.setString(4, pgt00352xml.getZRFSFLX());
			call.setString(5, pgt00352xml.getLFDZ());
			call.setString(6, pgt00352xml.getLxdh());
			call.setString(7, pgt00352xml.getNote());
			call.setString(8, pgt00352xml.getFWLX());
			call.setString(9, pgt00352xml.getJYLX());
			call.setString(10, pgt00352xml.getJZJG());
			call.setDouble(11, pgt00352xml.getJZMJ());
			call.setInt(12, Common.convertToInteger(pgt00352xml.getSZLC()));
			call.setString(13, pgt00352xml.getDYFH());
			call.setDouble(14, pgt00352xml.getHTZJ());
			call.setDouble(15, pgt00352xml.getTdsyqmj());//pgt00352xml.getTdsyqmj() 土地使用面积
			call.setDouble(16, pgt00352xml.getRjl());//pgt00352xml.getRjl()容积率
			call.setDate(17, Common.converDate(pgt00352xml.getJYSJ()));
			call.setString(18, pgt00352xml.getFdcdat());
			call.setString(19, pgt00352xml.getCzr());
			call.setString(20, pgt00352xml.getNote());
			call.setString(21, pgt00352xml.getYFCZH());
			call.setString(22, pgt00352xml.getQdh());
			call.setString(23, pgt00352xml.getCb());
			call.setString(24, pgt00352xml.getSJYT());
			call.setString(25, pgt00352xml.getHxjg());
			call.setString(26, pgt00352xml.getJcsj());
			call.setDate(27, Common.converDate(pgt00352xml.getFZRQ()));
			call.setString(28, pgt00352xml.getShr());
			call.setString(29, pgt00352xml.getXqdm());
			call.setString(30, pgt00352xml.getJZJG());
			call.setInt(31, Common.convertToInteger(pgt00352xml.getYwdt()));
			call.setInt(32, Common.convertToInteger(pgt00352xml.getZLC()));
			call.setString(33, pgt00352xml.getNote());
			call.setString(34, pgt00352xml.getLFDZ());
			call.setString(35, pgt00352xml.getLFDZ());
			call.setString(36, pgt00352xml.getCd00053Qtxzid());
			call.setString(37, pgt00352xml.getSsgx());
			call.setInt(38, Common.convertToInteger(pgt00352xml.getXqzt()));
			call.setString(39, pgt00352xml.getSzqy());
			call.setString(40, pgt00352xml.getParentdm());
			call.setString(41, pgt00352xml.getXqnm());
			call.setString(42, pgt00352xml.getZhxz());
			call.setString(43, pgt00352xml.getCLH());
			call.setInt(44, Common.convertToInteger(pgt00352xml.getYwjkc()));
			call.setString(45, pgt00352xml.getCSFSFLX());
			call.setString(46, pgt00352xml.getCSFMC());
			call.setString(47, pgt00352xml.getCSFSFID());
			call.setString(48, pgt00352xml.getFCSLH());
			call.setInt(49, Common.convertToInteger(pgt00352xml.getOINSID()));
			call.setDouble(50, pgt00352xml.getYJG());
			call.setDouble(51, pgt00352xml.getPGJG());
			call.setString(52, pgt00352xml.getROOMID());
			call.setString(53, pgt00352xml.getOwnRoomid());
			call.setInt(54, pgt00352xml.getSfsyfc());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call,conn,session);
		}
		return bResult;
	}
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt00302DAO#GetDeleteCommandXML(com.sunway.vo.Pgt00352xml)
	 */
	
	@Override
	public boolean GetDeleteCommandXML(Pgt00352xml pgt00352xml) throws Exception {
	
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT00371(?)}");
			// 传入输入参数
			call.setString(1, pgt00352xml.getFCSLH());
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
	 * @see com.sunway.dao.ICL00390DAO#execRD(com.sunway.vo.Pgv00331)
	 */
	
	public Integer JCXML(Pgt00352xml bean) throws Exception {
		Integer bResult = 0;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;		
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00371(?,?)}");
			//输出参数
			call.registerOutParameter(1, OracleTypes.NUMBER);
			//传入输入参数
			call.setString(2, bean.getFCSLH());	
			call.execute();
			tran.commit();
			bResult = call.getInt(1);
		} catch (Exception e) {
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}

	
	@Override
	public boolean GetUpdateCommand371(Pgt00352xml pgt00352xml)
			throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try{
			session = getSession();
			conn = super.getConnection();
			tran = session.beginTransaction();
			call = conn.prepareCall("{call PGSP_UPDT00371(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, pgt00352xml.getFcid());
			call.setString(2, pgt00352xml.getFCSLH());
			call.setString(3, pgt00352xml.getYFCZH());
			call.setString(4, pgt00352xml.getZRFSFLX());
			call.setString(5, pgt00352xml.getZRFSFID());
			call.setString(6, pgt00352xml.getZRFMC());
			call.setString(7, pgt00352xml.getCSFSFLX());
			call.setString(8, pgt00352xml.getCSFSFID());
			call.setString(9, pgt00352xml.getCSFMC());
			call.setString(10, pgt00352xml.getCLH());
			call.setString(11, pgt00352xml.getSJYT());
			call.setString(12, pgt00352xml.getLFDZ());
			call.setString(13, pgt00352xml.getDYFH());
			call.setString(14, pgt00352xml.getSZLC());
			call.setString(15, pgt00352xml.getZLC());
			call.setString(16, pgt00352xml.getJZJG());
			call.setString(17, pgt00352xml.getFWLX());
			call.setString(18, pgt00352xml.getJYLX());
			call.setDouble(19, pgt00352xml.getJZMJ());
			call.setDouble(20, pgt00352xml.getHTZJ());
			call.setDate(21, Common.converDate(pgt00352xml.getJYSJ()));
			call.setDate(22, Common.converDate(pgt00352xml.getFZRQ()));
			call.setString(23, pgt00352xml.getDF());
			call.setString(24, pgt00352xml.getCX());
			call.setString(25, pgt00352xml.getCG());
			call.setDouble(26, pgt00352xml.getYJG());
			call.setDouble(27, pgt00352xml.getPGJG());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call,conn,session);
		}
		return bResult;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.ICL00390DAO#execRD(com.sunway.vo.Pgv00331)
	 */
	
	@Override
	public Boolean execFS(Pgt00302 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;		
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT003051(?,?)}");
			//传入输入参数
			call.setString(1, bean.getFcid());
			call.setString(2, bean.getCd00002Czr());
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
	public Pgv00302 GetXMLI(Pgv00302 v00302) throws Exception {
		Pgv00302 bean = new Pgv00302() ;
		CallableStatement call = null;
		Connection conn = null;
		ResultSet rs = null;
		Session session = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT003022(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, v00302.getFcid());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			if(null != rs && rs.next()){
				bean = SetSendXMLI(rs);
				bean.setFclsh(v00302.getFclsh());
				bean.setDjz_channel_pwd(v00302.getDjz_channel_pwd());
				bean.setDjz_channel_acc(v00302.getDjz_channel_acc());
				bean.setDjz_channel_code(v00302.getDjz_channel_code());
				bean.setDjz_wbmbm(v00302.getDjz_wbmbm());
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return bean;
	}
	
	protected Pgv00302 SetSendXMLI(ResultSet rs)throws Exception {
		Pgv00302 e = new Pgv00302();
		e.setFcid(rs.getString(fcid));
		e.setFcslh(rs.getString(fcslh));
		e.setFczh(rs.getString(fczh));
		e.setClh(rs.getString(clh));
		e.setGhyt(rs.getString("sjyt"));
		e.setFwtdzl(rs.getString(zcdzl));
		e.setXqnm(rs.getString(xqnm));
		e.setBwjfh(rs.getString(bwjfh));
		e.setSzlc(rs.getShort(szlc));
		e.setZlc(rs.getString(zlc));
		e.setJzjg(rs.getString(jzjg));
		e.setFwlx(rs.getString(fwlx));
		e.setJylx(rs.getString(jylx));
		e.setJzmj(rs.getDouble(jzmj));
		e.setJyjg(rs.getDouble(jyjg));
		e.setJysj(rs.getDate(jysj));
		e.setDjrq(rs.getDate(djrq));
		e.setDf(rs.getString("DF"));
		e.setCx(rs.getString("CX"));
		e.setCg(rs.getString("CG"));
		e.setYjg(rs.getDouble(yjg));
		e.setSbpgjg(rs.getDouble(sbpgjg));
		e.setSfsyfc(rs.getInt("SFSYFC"));
		e.setNsrmc(rs.getString(nsrmc));
		e.setZjlx(rs.getString(zjlx));
		e.setZjhm(rs.getString(zjhm));
		e.setCsfnsrmc(rs.getString(csfnsrmc));
		e.setCsfZjlx(rs.getString(csfzjlx));
		e.setCsfzjhm(rs.getString(csfzjhm));
		e.setScpgjg(rs.getDouble(scpgjg));
		e.setOINSID(rs.getString(OINSID));
		e.setROOMID(rs.getString(ROOMID));
		e.setOwnRoomid(rs.getString(ownroomid));
		e.setWsjs(rs.getDouble(wsjs));
		e.setWsrq(rs.getDate(wsrq));
		e.setNote(rs.getString(note));
		return e;
	}
	
	public BF00000 GetDJZPsjgXML(BF00000 bf00000) throws Exception{
		//ArrayList<BF00000> listResult=new ArrayList<BF00000>();
		BF00000 bean =new BF00000();
		CallableStatement call=null;
		Connection conn=null;
		ResultSet rs = null;
		Session session = null;
		try{
			session=getSession();
			conn=super.getConnection();
			call = conn.prepareCall("call PGSP_BF_00000(?,?,?,?)");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入的参数
			call.setString(2,bf00000.getFcid());
			call.setString(3,bf00000.getCzr());
			call.setString(4,bf00000.getSysSsgx());
			call.execute();
			//返回数据
			rs =(ResultSet)call.getObject(1);
			while(rs!=null && rs.next()){
				bean.setFcid(rs.getString("FCID"));
				bean.setPgjg(rs.getBigDecimal("pgjg"));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call,conn,session);
		}
		return bean;
	}

	
	@Override
	public Boolean GetInsertCommand3711(Pgt00352xml pgt00352xml) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT003711(?,?)}");
			call.setString(1, pgt00352xml.getFcid());
			call.setString(2, pgt00352xml.getInfoMsg());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			throw e;
		}finally{
			getFree(call,conn,session);
		}
		return bResult;
	}

	
	@Override
	public Pgt00352xml LoadAll3711(Pgt00352xml t00352xml) throws Exception {
		Pgt00352xml listResult = new Pgt00352xml();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003711(?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//输入参数
			call.setInt(2,t00352xml.getPageIndex());
			call.setInt(3, t00352xml.getPageSize());
			call.setString(4, t00352xml.getZRFMC());
			call.setString(5, t00352xml.getZRFSFID());
			
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.getPgt00352xmllist().add(SetXMLParameters(rs,true));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rsSum, rs, call, conn, session);
		}
		return listResult;
	}

	
	@Override
	public boolean GetDeleteCommand3711(Pgt00352xml t00352xml) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		Transaction tran = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT003711(?)}");
			call.setString(1, t00352xml.getFcid());
			call.execute();
			tran.commit();
			bResult = true;
		}catch(Exception e){
			throw e;
		}finally{
			getFree(call,conn,session);
		}
		return bResult;
	}

	
	@Override
	public Pgt00352xml LoadByPrimaryKey3711(Pgt00352xml t00352xml)throws Exception {
		ArrayList<Pgt00352xml> listResult = new ArrayList<Pgt00352xml>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT003711(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t00352xml.getFcid());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetXMLDParameters(rs,true));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		if (listResult != null && listResult.size() > 0) {
			return listResult.get(0);
		} else {
			return null;
		}
	}

	
	@Override
	public ArrayList<Pgt00352xml> LoadByFCSLH372(Pgt00352xml t00352xml) throws Exception {
		ArrayList<Pgt00352xml> resultList = new ArrayList<Pgt00352xml>();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT003721(?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, t00352xml.getFCSLH());
			call.setString(3, t00352xml.getSsgx());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				Pgt00352xml e = SetVParametersXML(rs);
				e.setSsgx(t00352xml.getSsgx());
				e.setCzr(t00352xml.getCzr());
				resultList.add(e);
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return resultList;
	} 
	
	/**
	 * 装载372数据
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	protected Pgv00372 SetVParameters372(ResultSet rs)throws Exception{
		Pgv00372 e = new Pgv00372();
		e.setFcid(rs.getString("FCID"));
		e.setFcslh(rs.getString("FCSLH"));
		e.setYfczh(rs.getString("YFCZH"));
		e.setZrfsflx(rs.getString("ZRFSFLX"));
		e.setZrfsfid(rs.getString("ZRFSFID"));
		e.setZrfmc(rs.getString("ZRFMC"));
		e.setCsfsflx(rs.getString("CSFSFLX"));
		e.setCsfsfid(rs.getString("CSFSFID"));
		e.setCsfmc(rs.getString("CSFMC"));
		e.setClh(rs.getString("CLH"));
		e.setSjyt(rs.getString("SJYT"));
		e.setLfdz(rs.getString("LFDZ"));
		e.setDyfh(rs.getString("DYFH"));
		e.setSzlc(rs.getString("SZLC"));
		e.setZlc(rs.getString("ZLC"));
		e.setJzjg(rs.getString("JZJG"));
		e.setFwlx(rs.getString("FWLX"));
		e.setJylx(rs.getString("JYLX"));
		e.setJzmj(rs.getDouble("JZMJ"));
		e.setHtzj(rs.getDouble("HTZJ"));
		e.setJysj(rs.getTimestamp("JYSJ"));
		e.setFzrq(rs.getTimestamp("FZRQ"));
		e.setDf(rs.getString("DF"));
		e.setCx(rs.getString("CX"));
		e.setCg(rs.getString("CG"));
		e.setOinsid(rs.getInt("OINSID"));
		e.setYjg(rs.getDouble("YJG"));
		e.setPgjg(rs.getDouble("PGJG"));
		e.setRoomid(rs.getString("ROOMID"));
		e.setOwnRoomid(rs.getString("OWNROOMID"));
		e.setSfsyfc(rs.getString("SFSYFC"));
		e.setSsqy(rs.getString("SSQY"));
		e.setNote(rs.getString("NOTE"));
		return e;
	}
	
	/**
	 * 装载372数据
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	protected Pgt00352xml SetVParametersXML(ResultSet rs)throws Exception{
		Pgt00352xml e = new Pgt00352xml();
		e.setFcid(rs.getString("FCID"));
		e.setFCSLH(rs.getString("FCSLH"));
		e.setYFCZH(rs.getString("YFCZH"));
		e.setZRFSFLX(rs.getString("ZRFSFLX"));
		e.setZRFSFID(rs.getString("ZRFSFID"));
		e.setZRFMC(rs.getString("ZRFMC"));
		e.setCSFSFLX(rs.getString("CSFSFLX"));
		e.setCSFSFID(rs.getString("CSFSFID"));
		e.setCSFMC(rs.getString("CSFMC"));
		e.setCLH(rs.getString("CLH"));
		e.setSJYT(rs.getString("SJYT"));
		e.setLFDZ(rs.getString("LFDZ"));
		e.setDYFH(rs.getString("DYFH"));
		e.setSZLC(rs.getString("SZLC"));
		e.setZLC(rs.getString("ZLC"));
		e.setJZJG(rs.getString("JZJG"));
		e.setFWLX(rs.getString("FWLX"));
		e.setJYLX(rs.getString("JYLX"));
		e.setJZMJ(rs.getDouble("JZMJ"));
		e.setHTZJ(rs.getDouble("HTZJ"));
		e.setJYSJ(rs.getTimestamp("JYSJ"));
		e.setFZRQ(rs.getTimestamp("FZRQ"));
		e.setDF(rs.getString("DF"));
		e.setCX(rs.getString("CX"));
		e.setCG(rs.getString("CG"));
		e.setOINSID(rs.getString("OINSID"));
		e.setYJG(rs.getDouble("YJG"));
		e.setPGJG(rs.getDouble("PGJG"));
		e.setROOMID(rs.getString("ROOMID"));
		e.setOwnRoomid(rs.getString("OWNROOMID"));
		e.setSfsyfcmc(rs.getString("SFSYFC"));
		//e.setSsqy(rs.getString("SSQY"));
		e.setNote(rs.getString("NOTE"));
		return e;
	}
          
}
