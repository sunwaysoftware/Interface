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

import com.sunway.dao.IPgt02002DAO;
import com.sunway.util.CheckUtil;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FormatUtil;
import com.sunway.vo.BF00000;
import com.sunway.vo.Pgt02002;
import com.sunway.vo.Pgt02052xml;
import com.sunway.vo.Pgv02002;
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
public class Pgt02002DAO extends BaseDAO implements IPgt02002DAO {

	private static final String total = "TOTAL";
	private static final String fcid = "FCID";
	private static final String cd00001Fwlx = "CD_00001_FWLX";
	private static final String cd00001Jylx = "CD_00001_JYLX";
	private static final String cd00001Jzjg = "CD_00001_JZJG";
	private static final String jzmj = "JZMJ";
	private static final String szlc = "SZCS";
	private static final String bwjfh = "BWJFH";
	private static final String jyjg = "SBJG";
	private static final String jysj = "JYSJ";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String nsrmc = "ZRFMC";
	private static final String cd00001Ssgx = "CD_00001_SSGX";
	private static final String cd02050Xqdm = "CD_02050_XQDM";
	private static final String cd00001Szqy = "CD_00001_SZQY";
	private static final String zlc = "CS";
	private static final String xqnm = "XQNM";
	//private static final String xqbm = "XQBM";
	private static final String szqy = "SZQY";
	private static final String fwlx = "FWLX";
	private static final String jylx = "JYLX";
	private static final String jzjg = "JZJG";
	private static final String czr = "CZR";
	private static final String htqdsj = "htqdsj";
	private static final String sumJzmj = "SUM_JZMJ";
	private static final String sumJyjg = "SUM_JYJG";
	private static final String sumTdsyqmj = "SUM_TDSYQMJ";
	private static final String avgRjl = "AVG_RJL";
	private static final String pgjg = "PGJG";
	private static final String gbpgjg = "GBPGJG";
	private static final String xqdmhm = "XQDMHM";
//	private static final String jsze = "JSZE";
//	private static final String ynze = "YNZE";
	private static final String sumPgjg = "SUM_PGJG";
	private static final String sumGbpgjg = "SUM_GBPGJG";
	private static final String sumScpgjg = "SUM_SCPGJG";
	private static final String sczt = "SYZT";
	private static final String fczh = "FCZH";
	private static final String cd00001ghyt = "CD_00001_GHYT";
	private static final String ghyt = "GHYT";
	private static final String jcsj = "JCNF";
	private static final String djrq = "DJRQ";
	private static final String zcdzl = "ZCDZL";
	private static final String zjlx = "ZRFZJLX";
	private static final String cd00001Zjlx = "CD_00001_ZRFZJLX";
	private static final String lxdh = "ZRFLXDH";
	//private static final String parentdm = "PARENTDM";
	private static final String zjhm = "ZRFZJHM";
	private static final String scpgjg = "SYPGJG";
	private static final String zhxz = "ZHXZ";
	private static final String clh = "CLH";
	private static final String ywjkc="YWJKC";
	private static final String cd00001csfzjlx= "CD_00001_SRFZJLX";
	private static final String csfzjlx="SRFZJLX";
	private static final String csfnsrmc= "SRFMC";
	private static final String csfzjhm= "SRFZJHM";
	private static final String csflxdh= "SRFLXDH";
	private static final String fcslh="FCSLH";
	private static final String yjg = "YJG";
	private static final String sbpgjg = "SBPGJG";
	private static final String ssgx = "SSGX";
	private static final String ownroomid = "OWNROOMID";
	private static final String sfsyfc = "SFSYFC";
	private static final String sfsyfcdm = "SFSYFCDM";
	private static final String CD00001FWLX = "CD_00001_FWLX";
	private static final String CD00001JYLX = "CD_00001_JYLX";
	private static final String CD00001JZJG = "CD_00001_JZJG";
	private static final String CD00001ZRFSFLX = "CD_00001_ZRFSFLX";
	private static final String CD00001CSFSFLX = "CD_00001_CSFSFLX";
	private static final String CD00001SJYT = "CD_00001_SJYT";
	//private static final String sjyt = "SJYT";
	private static final String OINSID = "OINSID";
	private static final String ROOMID = "ROOMID";
	private static final String INFOMSG = "infomsg";
	private static final String lh="ZH";
	private static final String dyh="DYH";
	private static final String wsrq = "QSWSRQ";
	private static final String wsjs = "QSWSJS";
	private static final String rdsj = "rdsj";	
	private static final String mfgjdm = "mfgjdm";
	private static final String gmfgjdm = "gmfgjdm";
	private static final String cd00001MFGJDM = "cd_00001_MFGJDM";
	private static final String cd00001GMFGJDM = "cd_00001_GMFGJDM";
	private static final String sbhzr = "sbh_zr";
	private static final String sbhcs = "sbh_cs";
	private static final String nsrLxZr = "nsrLx_Zr";
	private static final String nsrLxCs = "nsrLx_Cs";
	private static final String mk = "MK";
	private static final String js = "JS";
	private static final String cd02020fcid = "CD_02020_FCID";
	private static final String isbg = "isbg";
	
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt02002DAO#LoadAll(com.sunway.vo.Pgv02002)
	 */
	
	@Override
	public Pgv02002 LoadAll(Pgv02002 v02002) throws Exception {
		Pgv02002 listResult = new Pgv02002();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02002(?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(3, v02002.getPageIndex());
			call.setInt(4, v02002.getPageSize());
			call.setString(5, v02002.getFcid());
			call.setString(6, v02002.getZjhm());
			call.setString(7, v02002.getNsrmc());
			call.setString(8, v02002.getFwtdzl());
			call.setString(9, v02002.getCd02050Xqdm());
			call.setString(10, v02002.getCd00001Szqy());
			call.setString(11, v02002.getCd00001Ssgx());
			call.setString(12, v02002.getFcslh());
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
				listResult.getV02002List().add(SetVParameters(rs));
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
	 * @see com.sunway.dao.IPgt02002DAO#LoadAll(com.sunway.vo.Pgv02002)
	 */
	
	@Override
	public ArrayList<Pgv02002> LoadAllE(Pgv02002 v02002) throws Exception {
		ArrayList<Pgv02002> listResult = new ArrayList<Pgv02002>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02002E(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v02002.getFcid());
			call.execute();
			
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgv02002 e = new Pgv02002();
				e.setNote(rs.getString(note));
				e.setLx(rs.getShort("lx"));
				e.setOldData(rs.getString("olddata"));
				e.setNewData(rs.getString("newdata"));
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
	 * @see com.sunway.dao.IPgt02002DAO#LoadAll(com.sunway.vo.Pgv02002)
	 */
	
	@Override
	public ArrayList<Pgv02002> LoadAllE_B(Pgv02002 v02002) throws Exception {
		ArrayList<Pgv02002> listResult = new ArrayList<Pgv02002>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02002E_B(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v02002.getFcid());
			call.execute();
			
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgv02002 e = new Pgv02002();
				e.setNote(rs.getString(note));
				e.setLx(rs.getShort("lx"));
				e.setOldData(rs.getString("olddata"));
				e.setNewData(rs.getString("newdata"));
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
	 * @see com.sunway.dao.IPgt02002DAO#LoadByPrimaryKey(com.sunway.vo.Pgt02002)
	 */
	
	@Override
	public Pgt02002 LoadByPrimaryKey(Pgt02002 t02002) throws Exception {
		ArrayList<Pgt02002> listResult = new ArrayList<Pgt02002>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02002(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t02002.getFcid());
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
			return new Pgt02002();
		}
	}
	
	
	public Pgt02002 LoadByPrimaryKey_B(Pgt02002 t02002) throws Exception {
		ArrayList<Pgt02002> listResult = new ArrayList<Pgt02002>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02002_B(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t02002.getFcid());
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
			return new Pgt02002();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt02002DAO#LoadMaxFcId()
	 */
	
	@Override
	public String LoadMaxFcId(String t02002) throws Exception {
		String resultValue = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{? = call FN_GETFCID_SY()}");
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
	 * @see com.sunway.dao.IPgt02002DAO#GetInsertCommand(com.sunway.vo.Pgt02002)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt02002 t02002) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02002(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			int i = 1;                                               
			// 传入输入参数
			call.setString(i++, t02002.getFcid());
			call.setString(i++, t02002.getNsrmc());
			call.setString(i++, t02002.getCd00001Zjlx());
			call.setString(i++, t02002.getZjhm());
			call.setString(i++, t02002.getLxdh());
			call.setString(i++,t02002.getCsfnsrmc());
			call.setString(i++,t02002.getCsfzjlx());			
			call.setString(i++,t02002.getCsfzjhm());
			call.setString(i++, t02002.getCsflxdh());
			call.setString(i++, t02002.getFczh());
			call.setString(i++, t02002.getClh());
			call.setString(i++, t02002.getCd02050Xqdm());
			call.setString(i++, t02002.getJcsj());
			call.setString(i++, t02002.getZcdzl());
			call.setBigDecimal(i++, t02002.getJzmj());			
			call.setString(i++, t02002.getLh());			
			call.setString(i++, t02002.getBwjfh());
			call.setString(i++, t02002.getDyh());
			call.setString(i++, t02002.getCd00001Fwlx());
			call.setShort(i++, t02002.getZlc());
			call.setString(i++, t02002.getSzlc());
			call.setBigDecimal(i++, t02002.getJyjg());
			call.setString(i++, t02002.getCd00001Ssgx());
			call.setString(i++, t02002.getCd00002Czr());
			call.setString(i++, t02002.getNote());
			call.setTimestamp(i++, t02002.getJysj());
			call.setDouble(i++, t02002.getMk());
			call.setDouble(i++, t02002.getJs());
			call.setString(i++, t02002.getCd00001Jzjg());
			call.setString(i++, t02002.getCd00001Jylx());
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(t02002.getDjrq()));
			call.setString(i++,t02002.getFcslh());
			call.setInt(i++, t02002.getOinsid());
			call.setString(i++, t02002.getRoomid());
			call.setString(i++, t02002.getOwnRoomid());
			call.setInt(i++, t02002.getSfsyfc());
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(t02002.getWsrq()));
			call.setDouble(i++, t02002.getWsjs());
			call.setString(i++, t02002.getGhyt());
			call.setString(i++, t02002.getCd00001Mfgjdm());
			call.setString(i++, t02002.getCd00001Gmfgjdm());
			call.setString(i++, t02002.getSbh_zr());
			call.setString(i++, t02002.getSbh_cs());
			call.setInt(i++, t02002.getNsrLx_zr());
			call.setInt(i++, t02002.getNsrLx_cs());
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(t02002.getHtqdsj()));
			call.setDouble(i++, t02002.getYjg());
			call.setString(i++, t02002.getCd02020Fcid());
			call.setDouble(i++, t02002.getSbpgjg());
			call.setString(i++, t02002.getZhxz());		
			call.setString(i++, t02002.getId());
			call.setString(i++, t02002.getHtbh());
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
	 * @see com.sunway.dao.IPgt00302DAO#GetInsertCommand(com.sunway.vo.Pgt00302)
	 */
	
	@Override
	public boolean GetInsertCommandBySFZ(Pgt02002 t02002) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT00371A_TEMP1(?)}");
			                                               
			// 传入输入参数
			call.setString(1, t02002.getFcid());
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
	 * @see com.sunway.dao.IPgt02002DAO#GetUpdateCommand(com.sunway.vo.Pgt02002)
	 */
	
	@Override
	public boolean GetUpdateCommand(Pgt02002 t02002) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_UPDT02002(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			int i = 1;                                               
			// 传入输入参数
			call.setString(i++, t02002.getFcid());
			call.setString(i++, t02002.getNsrmc());
			call.setString(i++, t02002.getCd00001Zjlx());
			call.setString(i++, t02002.getZjhm());
			call.setString(i++, t02002.getLxdh());
			call.setString(i++,t02002.getCsfnsrmc());
			call.setString(i++,t02002.getCsfzjlx());			
			call.setString(i++,t02002.getCsfzjhm());
			call.setString(i++, t02002.getCsflxdh());
			call.setString(i++, t02002.getFczh());
			call.setString(i++, t02002.getClh());
			call.setString(i++, t02002.getCd02050Xqdm());
			call.setString(i++, t02002.getJcsj());
			call.setString(i++, t02002.getZcdzl());
			call.setBigDecimal(i++, t02002.getJzmj());			
			call.setString(i++, t02002.getLh());			
			call.setString(i++, t02002.getBwjfh());
			call.setString(i++, t02002.getDyh());
			call.setString(i++, t02002.getCd00001Fwlx());
			call.setShort(i++, t02002.getZlc());
			call.setString(i++, t02002.getSzlc());
			call.setBigDecimal(i++, t02002.getJyjg());
			call.setString(i++, t02002.getCd00001Ssgx());
			call.setString(i++, t02002.getCd00002Czr());
			call.setString(i++, t02002.getNote());
			call.setTimestamp(i++, t02002.getJysj());
			call.setDouble(i++, t02002.getMk());
			call.setDouble(i++, t02002.getJs());
			call.setString(i++, t02002.getCd00001Jzjg());
			call.setString(i++, t02002.getCd00001Jylx());
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(t02002.getDjrq()));
			call.setString(i++,t02002.getFcslh());
			call.setInt(i++, t02002.getOinsid());
			call.setString(i++, t02002.getRoomid());
			call.setString(i++, t02002.getOwnRoomid());
			call.setInt(i++, t02002.getSfsyfc());
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(t02002.getWsrq()));
			call.setDouble(i++, t02002.getWsjs());
			call.setString(i++, t02002.getGhyt());
			call.setString(i++, t02002.getCd00001Mfgjdm());
			call.setString(i++, t02002.getCd00001Gmfgjdm());
			call.setString(i++, t02002.getSbh_zr());
			call.setString(i++, t02002.getSbh_cs());
			call.setInt(i++, t02002.getNsrLx_zr());
			call.setInt(i++, t02002.getNsrLx_cs());
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(t02002.getHtqdsj()));
			call.setDouble(i++, t02002.getYjg());
			call.setString(i++, t02002.getCd02020Fcid());
			call.setDouble(i++, t02002.getSbpgjg());
			call.setString(i++, t02002.getZhxz());
			call.setString(i++, t02002.getHtbh());
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
	 * @see com.sunway.dao.IPgt02002DAO#GetDeleteCommand(com.sunway.vo.Pgt02002)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt02002 t02002) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02002(?,?,?)}");
			// 传入输入参数
			call.setString(1, t02002.getFcid());
			call.setString(2, t02002.getCd00002Czr());
			call.setString(3, t02002.getCd00001Ssgx());
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
	 * @see com.sunway.dao.IPgt02002DAO#LoadDetail(com.sunway.vo.Pgv02002)
	 */
	
	@Override
	public Pgv02002 LoadDetail(Pgv02002 v02002) throws Exception {
		ArrayList<Pgv02002> listResult = new ArrayList<Pgv02002>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020020(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v02002.getFcid());
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
			return new Pgv02002();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt02002DAO#LoadDetail(com.sunway.vo.Pgv02002)
	 */
	
	@Override
	public Pgv02002 LoadDetail_B(Pgv02002 v02002) throws Exception {
		ArrayList<Pgv02002> listResult = new ArrayList<Pgv02002>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020020_B(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, v02002.getFcid());
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
			return new Pgv02002();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt02002DAO#GetFdcdatByFcid(com.sunway.vo.Pgt02002)
	 */
	
	@Override
	public Boolean GetFdcdatByFcid(Pgt02002 t02002) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_020022(?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			// 注册输入参数
			call.setString(2, t02002.getFcid());
			call.setString(3, t02002.getFdcdat());
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
	 * @see com.sunway.dao.IPgt02002DAO#LoadPgv020025(com.sunway.vo.Pgv02002)
	 */
	
	@Override
	public Pgv02002 LoadPgv020025(Pgv02002 v02002) throws Exception {
		Pgv02002 listResult = new Pgv02002();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020025(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			int i = 1;
			// 注册输出参数
			call.registerOutParameter(i++, OracleTypes.CURSOR);
			call.registerOutParameter(i++, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(i++, v02002.getPageIndex());
			call.setInt(i++, v02002.getPageSize());
			call.setString(i++, v02002.getFcid());
			call.setString(i++, v02002.getZjhm());
			call.setString(i++, v02002.getNsrmc());
			call.setString(i++, v02002.getXqnm());
			call.setString(i++, v02002.getZcdzl());
			call.setString(i++, v02002.getCd00001Szqy());
			call.setString(i++, v02002.getCd00001Ssgx());
			call.setInt(i++, v02002.getSyzt());
			call.setString(i++, v02002.getFczh());
			call.setString(i++, v02002.getCd00001Jzjg());
			call.setString(i++, v02002.getSzlc());
			call.setString(i++, v02002.getCd00001Jylx());
			call.setDouble(i++, v02002.getJzmj_min());
			call.setDouble(i++, v02002.getJzmj_max());
			call.setString(i++, v02002.getCd00001Fwlx());
			call.setDouble(i++, v02002.getJyjg_min());
			call.setDouble(i++, v02002.getJyjg_max());
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getDjrq()));
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getJysj_min()));
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getJysj_max()));
			call.setString(i++, v02002.getCd00002Czr());
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getUpddateS()));
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getUpddateE()));
			call.setString(i++, v02002.getFcslh());
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
				listResult.getV02002List().add(SetV020025Parameters(rs));
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
	 * @see com.sunway.dao.IPgt02002DAO#LoadPgv020025(com.sunway.vo.Pgv02002)
	 */
	
	@Override
	public Pgv02002 LoadPgv020025_B(Pgv02002 v02002) throws Exception {
		Pgv02002 listResult = new Pgv02002();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02002_B(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			int i = 1;
			call.registerOutParameter(i++, OracleTypes.CURSOR);
			call.registerOutParameter(i++, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(i++, v02002.getPageIndex());
			call.setInt(i++, v02002.getPageSize());
			call.setString(i++, v02002.getFcid());
			call.setString(i++, v02002.getZjhm());
			call.setString(i++, v02002.getNsrmc());
			call.setString(i++, v02002.getXqnm());
			call.setString(i++, v02002.getZcdzl());
			call.setString(i++, v02002.getCd00001Szqy());
			call.setString(i++, v02002.getCd00001Ssgx());
			call.setInt(i++, v02002.getSyzt());
			call.setString(i++, v02002.getFczh());
			call.setString(i++, v02002.getCd00001Jzjg());
			call.setString(i++, v02002.getSzlc());
			call.setString(i++, v02002.getCd00001Jylx());
			call.setDouble(i++, v02002.getJzmj_min());
			call.setDouble(i++, v02002.getJzmj_max());
			call.setString(i++, v02002.getCd00001Fwlx());
			call.setDouble(i++, v02002.getJyjg_min());
			call.setDouble(i++, v02002.getJyjg_max());
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getDjrq()));
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getJysj_min()));
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getJysj_max()));
			call.setString(i++, v02002.getCd00002Czr());
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getUpddateS()));
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getUpddateE()));
			call.setString(i++, v02002.getFcslh());
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getUpddateSRD()));
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getUpddateERD()));
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
				listResult.getV02002List().add(SetV020025Parameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rsSum, rs, call, conn, session);
		}
		return listResult;
	}
	
	@Override
	public ArrayList<Pgv02002> LoadPgv020025_B1(Pgv02002 v02002) throws Exception {
		ArrayList<Pgv02002> listResult = new ArrayList<Pgv02002>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02002_B2(?,?,?,?,?,?,?)}");
			// 注册输出参数
			int i = 1;
			call.registerOutParameter(i++, OracleTypes.CURSOR);
			//传入输入参数
			call.setInt(i++, v02002.getPageIndex());
			call.setInt(i++, v02002.getPageSize());
			call.setString(i++, v02002.getOrder());
			call.setString(i++, v02002.getSort());
			call.setString(i++, v02002.getSqlData());
			call.setString(i++, v02002.getCd00001Ssgx());
			call.execute();
			
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetV020025Parameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree( rs, call, conn, session);
		}
		return listResult;
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv02002 SetVParameters(ResultSet rs) throws Exception {
		Pgv02002 e = new Pgv02002();
		e.setRecordCount(rs.getInt(total));
		e.setFcid(rs.getString(fcid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJzmj(rs.getDouble(jzmj));
//		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
//		e.setCd00001Cgzk(rs.getString(cd00001Cgzk));
		e.setSzlc(rs.getString(szlc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setJyjg(rs.getDouble(jyjg));
		e.setFwtdzl(rs.getString(zcdzl));
		e.setJysj(rs.getDate(jysj));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd02050Xqdm(rs.getString(cd02050Xqdm));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setZlc(rs.getString(zlc));
		e.setXqnm(rs.getString(xqnm));
		e.setSbpgjg(rs.getDouble(sbpgjg));
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
	protected Pgt02052xml SetXMLParameters(ResultSet rs,boolean sign) throws Exception {
		Pgt02052xml e=new Pgt02052xml();
		e.setRecordCount(rs.getInt(total));
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
		e.setSJYT(rs.getString(ghyt));
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
		e.setSfsyfcmc(rs.getString(sfsyfc));
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
	protected Pgt02052xml SetXMLDParameters(ResultSet rs,boolean sign) throws Exception {
		Pgt02052xml e=new Pgt02052xml();
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
		e.setSJYT(rs.getString(ghyt));
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
		e.setCG(CheckUtil.chkNull(rs.getString("CG")));
		e.setCX(rs.getString("CX"));
		e.setOINSID(rs.getString("OINSID"));
		//e.setJyjg(ConvertUtil.toDouble(e.getHTZJ()));
		e.setYJG(rs.getDouble("YJG"));
		e.setPGJG(rs.getDouble("PGJG"));
//		e.setYjgView(ConvertUtil.toDouble(e.getYJG()));
//		e.setPgjgView(ConvertUtil.toDouble(e.getPGJG()));
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
		//e.setXqdm(rs.getString(xqbm));
		e.setXqnm(rs.getString(xqnm));
		e.setSzqy(rs.getString(cd00001Szqy));
		e.setJcsj(rs.getString(jcsj));
		e.setWsjs(rs.getDouble(wsjs));
		e.setWsrq(rs.getDate(wsrq));
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
	protected Pgv02002 SetAParameters(ResultSet rs) throws Exception {
		Pgv02002 e = new Pgv02002();
		e.setFcid(rs.getString(fcid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setCd00001Zjlx(rs.getString(cd00001Zjlx));
		e.setJzmj(rs.getDouble(jzmj));
		e.setSzlc(rs.getString(szlc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setJyjg(rs.getDouble(jyjg));
		e.setFwtdzl(rs.getString(zcdzl));
		e.setLxdh(rs.getString(lxdh));
		e.setJysj(rs.getDate(jysj));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd02050Xqdm(rs.getString(cd02050Xqdm));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setZlc(rs.getString(zlc));
		e.setXqnm(rs.getString(xqnm));
		//e.setXqbm(rs.getString(xqbm));
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
	protected Pgt02002 SetTParameters(ResultSet rs) throws Exception {
		Pgt02002 e = new Pgt02002();
		e.setFcid(rs.getString(fcid));
		e.setNsrmc(rs.getString(nsrmc));
		e.setZjhm(rs.getString(zjhm));
		e.setCd00001Zjlx(rs.getString(cd00001Zjlx));
		e.setZjlx(rs.getString(zjlx));
		e.setLxdh(rs.getString(lxdh));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setSzqy(rs.getString(szqy));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJzmj(rs.getBigDecimal(jzmj));
//		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
//		e.setCd00001Cgzk(rs.getString(cd00001Cgzk));
		e.setSzlc(rs.getString(szlc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setZlc(rs.getShort(zlc));
		e.setJyjg(rs.getBigDecimal(jyjg));
		e.setJysj(rs.getTimestamp(jysj));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setFwlx(rs.getString(fwlx));
		e.setJylx(rs.getString(jylx));
//		e.setCgzkSc(rs.getString(cgzkSc));
		e.setFczh(rs.getString(fczh));
		e.setGhyt(rs.getString(ghyt));
		e.setCd00001Ghyt(rs.getString(cd00001ghyt));
		e.setJcsj(rs.getString(jcsj));
		e.setDjrq(rs.getDate(djrq));
		e.setCd00001Mfgjdm(rs.getString(cd00001MFGJDM));
		e.setCd00001Gmfgjdm(rs.getString(cd00001GMFGJDM));
		e.setMfgjdm(rs.getString(mfgjdm));
		e.setGmfgjdm(rs.getString(gmfgjdm));
		e.setJzjg(rs.getString(jzjg));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setClh(rs.getString(clh));
		e.setZcdzl(rs.getString(zcdzl));
		e.setCd02050Xqdm(rs.getString(cd02050Xqdm));
		e.setXqnm(rs.getString(xqnm));
		e.setCd00001csfzjlx(rs.getString(cd00001csfzjlx));
		e.setCsfzjlx(rs.getString(csfzjlx));
		e.setCsfnsrmc(rs.getString(csfnsrmc));
		e.setCsfzjhm(rs.getString(csfzjhm));
		e.setCsflxdh(rs.getString(csflxdh));
		e.setFcslh(rs.getString(fcslh));
		e.setYjg(rs.getDouble(yjg));
		e.setSbpgjg(rs.getDouble(sbpgjg));
		e.setSfsyfc(rs.getInt(sfsyfc));
		e.setLh(rs.getString(lh));
		e.setDyh(rs.getString(dyh));
		e.setWsrq(rs.getDate(wsrq));
		e.setHtqdsj(rs.getDate(htqdsj));
		e.setWsjs(rs.getDouble(wsjs));
		e.setSbh_zr(rs.getString(sbhzr));
		e.setSbh_cs(rs.getString(sbhcs));
		e.setNsrLx_zr(rs.getInt(nsrLxZr));
		e.setNsrLx_cs(rs.getInt(nsrLxCs));
		e.setMk(rs.getDouble(mk));
		e.setJs(rs.getDouble(js));
		e.setCd02020Fcid(rs.getString(cd02020fcid));
		e.setHtbh(rs.getString("HTBH"));
		return e;
	}

	/**
	 * Detail数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv02002 SetDParameters(ResultSet rs) throws Exception {
		Pgv02002 e = new Pgv02002();
		e.setFcid(rs.getString(fcid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJzmj(rs.getDouble(jzmj));
//		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
//		e.setCd00001Cgzk(rs.getString(cd00001Cgzk));
		e.setSzlc(rs.getString(szlc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setJyjg(rs.getDouble(jyjg));
		e.setFwtdzl(rs.getString(zcdzl));
		e.setJysj(rs.getDate(jysj));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setZjlx(rs.getString(zjlx));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd02050Xqdm(rs.getString(cd02050Xqdm));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setZlc(rs.getString(zlc));
		e.setXqnm(rs.getString(xqnm));
		//e.setXqbm(rs.getString(xqbm));
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
		e.setSbpgjg(rs.getDouble(sbpgjg));
		e.setZhxz(rs.getString(zhxz));
		e.setClh(rs.getString(clh));
		e.setCd00001csfzjlx(rs.getString(cd00001csfzjlx));
		e.setCsfnsrmc(rs.getString(csfnsrmc));
		e.setCsfzjhm(rs.getString(csfzjhm));
		e.setFcslh(rs.getString(fcslh));
		e.setCsfZjlx(rs.getString(csfzjlx));
		e.setYjg(rs.getDouble(yjg));
		e.setLh(rs.getString(lh));
		e.setDyh(rs.getString(dyh));
		e.setDjrq(rs.getDate(djrq));
		e.setJcsj(rs.getString(jcsj));
		e.setSbh_zr(rs.getString(sbhzr));
		e.setSbh_cs(rs.getString(sbhcs));
		e.setNsrLx_zr(rs.getInt(nsrLxZr));
		e.setNsrLx_cs(rs.getInt(nsrLxCs));
		e.setMk(rs.getDouble(mk));
		e.setJs(rs.getDouble(js));
		e.setXqdmhm(rs.getString(xqdmhm));
		e.setSsgx(rs.getString(ssgx));
		e.setCd02020Fcid(rs.getString(cd02020fcid));
		e.setHtbh(rs.getString("HTBH"));
		return e;
	}

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv02002 SetV020025Parameters(ResultSet rs) throws Exception {
		Pgv02002 e = new Pgv02002();
		e.setRecordCount(rs.getInt(total));
		e.setFcid(rs.getString(fcid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJzmj(rs.getDouble(jzmj));
		e.setSzlc(rs.getString(szlc));
		e.setBwjfh(rs.getString(bwjfh));
		e.setJyjg(rs.getDouble(jyjg));
		e.setJysj(rs.getDate(jysj));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setFczh(rs.getString(fczh));
		e.setNsrmc(rs.getString(nsrmc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setLxdh(rs.getString(lxdh));
		e.setCd00001Zjlx(rs.getString(cd00001Zjlx));
		e.setZjlx(rs.getString(zjlx));
		e.setCd02050Xqdm(rs.getString(cd02050Xqdm));
		//e.setParentdm(rs.getString(parentdm));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setZlc(rs.getString(zlc));
		e.setXqnm(rs.getString(xqnm));
		//e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		//e.setZcdzl(rs.getString(zcdzl));
		e.setFwtdzl(rs.getString(zcdzl));
		e.setFwlx(rs.getString(fwlx));
		e.setJylx(rs.getString(jylx));
		e.setJzjg(rs.getString(jzjg));
		e.setCzr(rs.getString(czr));
		e.setSyzt(rs.getInt(sczt));
		e.setPgjg(rs.getDouble(pgjg));
		e.setGbpgjg(rs.getDouble(gbpgjg));
		//e.setJsze(rs.getDouble(jsze));
		//e.setYnze(rs.getDouble(ynze));
		e.setDjrq(rs.getDate(djrq));
		e.setZjhm(rs.getString(zjhm));
		e.setSypgjg(rs.getDouble(scpgjg));
		e.setSsgx(rs.getString(ssgx));
		e.setIsbg(rs.getShort(isbg));
		e.setSzxx("点击查看缴税信息");
		//e.setZhxz(rs.getString(zhxz));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02002DAO#GetInsertCommandWs(com.sunway.vo.Pgt02002)
	 */
	
	@Override
	public boolean GetInsertCommandWs(Pgt02002 t02002) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT020021(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			call.registerOutParameter(2, OracleTypes.VARCHAR);	
			call.registerOutParameter(3, OracleTypes.NUMBER);
			// 传入输入参数
			call.setString(4, t02002.getFcid());
			call.setString(5, t02002.getZjhm());
			call.setString(6, t02002.getNsrmc());
			call.setString(7, t02002.getCd00001Zjlx());
			call.setString(8, t02002.getZz());
			call.setString(9, t02002.getLxdh());
			call.setString(10, t02002.getNote2());
			call.setString(12, t02002.getCd00001Fwlx());
			call.setString(13, t02002.getCd00001Jylx());
			call.setString(14, t02002.getCd00001Jzjg());
			call.setBigDecimal(15, t02002.getJzmj());
//			call.setString(16, t02002.getCd00001Fwcx());
//			call.setString(17, t02002.getCd00001Cgzk());
			call.setString(16, t02002.getSzlc());
			call.setString(17, t02002.getBwjfh());
			call.setBigDecimal(18, t02002.getJyjg());
			call.setDouble(19, t02002.getTdsyqmj());
			call.setDouble(20, t02002.getRjl());
			call.setDate(21, ConvertUtil.utilDateToSqlDate(t02002.getJysj()));
			call.setString(22, t02002.getFdcdat());
			call.setString(23, t02002.getCd00002Czr());
			call.setString(24, t02002.getNote());
			call.setString(25, t02002.getFczh());
			call.setString(26, t02002.getQdh());
			call.setString(27, t02002.getCb());
			call.setString(28, t02002.getGhyt());
			call.setString(29, t02002.getHxjg());
			call.setString(30, t02002.getJcsj());
			call.setDate(31, ConvertUtil.utilDateToSqlDate(t02002.getDjrq()));
			call.setString(32, t02002.getShr());
//			call.setString(35, t02002.getCd00001Jtzk());
//			call.setString(36, t02002.getCd00001Wyzk());
//			call.setString(37, t02002.getCd00001Zxzk());
			call.setString(33, t02002.getCd02050Xqdm());
			call.setString(34, t02002.getCd00001Jzjg1());
			call.setBoolean(35, CheckUtil.chkNull(t02002.getYwdt()));
			call.setShort(36, t02002.getZlc());
			call.setString(37, t02002.getNote1());
			call.setString(38, t02002.getZcdzl());
			call.setString(39, t02002.getZcdzbm());
			call.setString(40, t02002.getCd00053Qtxzid());
			call.setString(41, t02002.getCd00001Ssgx());
			call.setString(42, t02002.getLh());
			call.setString(43, t02002.getZhxz());
			call.execute();
			tran.commit();
			//返回值
			if ((Integer)call.getObject(1)>0)
				t02002.setWsIsPg(true);
			else
				t02002.setWsIsPg(false);
			t02002.setWsPgMsg((String)call.getObject(2));
			t02002.setWsPgValue((Double)call.getDouble(3));
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
	 * @see com.sunway.dao.IPgt02002DAO#LoadByFczh(com.sunway.vo.Pgt02002)
	 */
	
	@Override
	public Pgv02002 LoadByFczh(Pgt02002 t02002) throws Exception {
		ArrayList<Pgv02002> listResult = new ArrayList<Pgv02002>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT020021(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t02002.getFczh());
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
			return new Pgv02002();
		}
	}
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt10051DAO#ExportDjxxSjcx(com.sunway.vo.Pgv10051)
	 */
	
	@Override
	public OutputStream ExportCXSjcx(Pgv02002 v02002) throws Exception {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
		//Pgv02002 listResult = new Pgv02002();
		ResultSet rs = null;
		//ResultSet rsSum = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT0200251(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			int i = 1;
			call.registerOutParameter(i++, OracleTypes.CURSOR);
			call.registerOutParameter(i++, OracleTypes.CURSOR);
			// 传入输入参数			
			call.setInt(i++, v02002.getPageIndex());
			call.setInt(i++, v02002.getPageSize());
			call.setString(i++, v02002.getFcid());
			call.setString(i++, v02002.getZjhm());
			call.setString(i++, v02002.getNsrmc());
			call.setString(i++, v02002.getXqnm());
			call.setString(i++, v02002.getZcdzl());
			call.setString(i++, v02002.getCd00001Szqy());
			call.setString(i++, v02002.getCd00001Ssgx());
			call.setInt(i++, CheckUtil.chkNull(v02002.getSyzt()));
			call.setString(i++, v02002.getFczh());
			call.setString(i++, v02002.getCd00001Jzjg());
			call.setString(i++, v02002.getSzlc());
			call.setString(i++, v02002.getCd00001Jylx());
			call.setDouble(i++, v02002.getJzmj_min());
			call.setDouble(i++, v02002.getJzmj_max());
			call.setString(i++, v02002.getCd00001Fwlx());
			call.setDouble(i++, v02002.getJyjg_min());
			call.setDouble(i++, v02002.getJyjg_max());
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getDjrq()));
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getJysj_min()));
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getJysj_max()));
			call.setString(i++, v02002.getCd00002Czr());
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getUpddateS()));
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getUpddateE()));
			call.setString(i++, v02002.getFcslh());
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
	            label = new Label(j++, 0, "状态");
				sheet.addCell(label);
	            label = new Label(j++, 0, "转让方");
	            sheet.addCell(label);	
	            label = new Label(j++, 0, "证件号码(转)");
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
				label = new Label(j++, 0, "国土证号");
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
				/*sheet.addCell(label);
				label = new Label(j++, 0, "申报评估价格(元)");*/
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
				label = new Label(j++, 0,"是否私有国土");
				sheet.addCell(label);
				label = new Label(j++, 0,"承受方证件类型");
				sheet.addCell(label);
				label = new Label(j++, 0,"承受方姓名");
				sheet.addCell(label);
				label = new Label(j++, 0,"承受方证件号码");
				sheet.addCell(label);
				label = new Label(j++, 0,"国土受理号");
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
					label = new Label(j++, rowIndex, FormatUtil.toYYYYMMDD(rs.getDate(jysj)));
					sheet.addCell(label);
					number = new Number(j++, rowIndex, rs.getDouble(jyjg));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(pgjg));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(gbpgjg));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(scpgjg));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(yjg));
					/*sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble("SBPGJG"));*/
					sheet.addCell(number);
					label = new Label(j++, rowIndex, rs.getString(zhxz));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, FormatUtil.toYYYYMMDD(rs.getDate(djrq)));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, FormatUtil.toYMDHMS(rs.getTimestamp(upddate)));
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
	            workbook.close();  
	        }
				
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
	public OutputStream ExportCXSjcx_B(Pgv02002 v02002) throws Exception {
		ByteArrayOutputStream strBufResult = new ByteArrayOutputStream(); 
		//Pgv02002 listResult = new Pgv02002();
		ResultSet rs = null;
		//ResultSet rsSum = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02002_B(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// 注册输出参数
			int i = 1;
			call.registerOutParameter(i++, OracleTypes.CURSOR);
			call.registerOutParameter(i++, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(i++, v02002.getPageIndex());
			call.setInt(i++, v02002.getPageSize());
			call.setString(i++, v02002.getFcid());
			call.setString(i++, v02002.getZjhm());
			call.setString(i++, v02002.getNsrmc());
			call.setString(i++, v02002.getXqnm());
			call.setString(i++, v02002.getZcdzl());
			call.setString(i++, v02002.getCd00001Szqy());
			call.setString(i++, v02002.getCd00001Ssgx());
			call.setInt(i++, CheckUtil.chkNull(v02002.getSyzt()));
			call.setString(i++, v02002.getFczh());
			call.setString(i++, v02002.getCd00001Jzjg());
			call.setString(i++, v02002.getSzlc());
			call.setString(i++, v02002.getCd00001Jylx());
			call.setDouble(i++, v02002.getJzmj_min());
			call.setDouble(i++, v02002.getJzmj_max());
			call.setString(i++, v02002.getCd00001Fwlx());
			call.setDouble(i++, v02002.getJyjg_min());
			call.setDouble(i++, v02002.getJyjg_max());
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getDjrq()));
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getJysj_min()));
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getJysj_max()));
			call.setString(i++, v02002.getCd00002Czr());
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getUpddateS()));
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getUpddateE()));
			call.setString(i++, v02002.getFcslh());
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getUpddateSRD()));
			call.setDate(i++, ConvertUtil.utilDateToSqlDate(v02002.getUpddateERD()));
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
	            label = new Label(j++, 0, "转让方");
	            sheet.addCell(label);	
	            label = new Label(j++, 0, "证件号码(转)");
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
				label = new Label(j++, 0, "国土证号");
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
				/*sheet.addCell(label);
				label = new Label(j++, 0, "申报评估价格(元)");*/
				sheet.addCell(label);				
				label = new Label(j++, 0, "综合修正");
				sheet.addCell(label);	          
				label = new Label(j++, 0, "发证日期");
				sheet.addCell(label);
				label = new Label(j++, 0, "认定日期");
				sheet.addCell(label);
				label = new Label(j++, 0, "更新日期");
				sheet.addCell(label);
				label = new Label(j++, 0, "操作人");
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
				label = new Label(j++, 0,"是否私有国土");
				sheet.addCell(label);
				label = new Label(j++, 0,"承受方证件类型");
				sheet.addCell(label);
				label = new Label(j++, 0,"承受方姓名");
				sheet.addCell(label);
				label = new Label(j++, 0,"承受方证件号码");
				sheet.addCell(label);
				label = new Label(j++, 0,"国土受理号");
				sheet.addCell(label);
				   // 写入数据
				while(null!=rs && rs.next()){
					Integer rowIndex = rs.getRow();	
					j=0;					
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
					label = new Label(j++, rowIndex, FormatUtil.toYYYYMMDD(rs.getDate(jysj)));
					sheet.addCell(label);
					number = new Number(j++, rowIndex, rs.getDouble(jyjg));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(pgjg));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(gbpgjg));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(scpgjg));
					sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble(yjg));
					/*sheet.addCell(number);
					number = new Number(j++, rowIndex, rs.getDouble("SBPGJG"));*/
					sheet.addCell(number);
					label = new Label(j++, rowIndex, rs.getString(zhxz));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, FormatUtil.toYYYYMMDD(rs.getDate(djrq)));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, FormatUtil.toYMDHMS(rs.getTimestamp(rdsj)));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, FormatUtil.toYMDHMS(rs.getTimestamp(upddate)));
					sheet.addCell(label);
					label = new Label(j++, rowIndex, rs.getString(czr));
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
	            workbook.close();  
	        }
				
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

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt02002DAO#GetInsertCommandXML(com.sunway.vo.Pgt02052xml)
	 */
	
	@Override
	public boolean GetInsertCommandXML(ArrayList<Pgt02052xml> Pgt02052xml) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			for(int i = 0; i < Pgt02052xml.size();i++){
				Pgt02052xml t02050xml = Pgt02052xml.get(i);
				if(!" ".equals(t02050xml.getSfsyfcmc())){
					if("私有国土".equals(t02050xml.getSfsyfcmc()))
						t02050xml.setSfsyfc(1);
					else
						t02050xml.setSfsyfc(0);
				}else{
					t02050xml.setSfsyfc(2);
				}
				call = conn.prepareCall("{call PGSP_ADDT00371(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				call.setInt(1, 0);
				call.setString(2, t02050xml.getFCSLH());
				call.setString(3, t02050xml.getYFCZH());
				call.setString(4, t02050xml.getZRFSFLX());
				call.setString(5, t02050xml.getZRFSFID());
				call.setString(6, t02050xml.getZRFMC());
				call.setString(7, t02050xml.getCSFSFLX());
				call.setString(8, t02050xml.getCSFSFID());
				call.setString(9, t02050xml.getCSFMC());
				call.setString(10, t02050xml.getCLH());
				call.setString(11, t02050xml.getSJYT());
				call.setString(12, t02050xml.getLFDZ());
				call.setString(13, t02050xml.getDYFH());
				call.setString(14, t02050xml.getSZLC());
				call.setString(15, t02050xml.getZLC());
				call.setString(16, t02050xml.getJZJG());
				call.setString(17, t02050xml.getFWLX());
				call.setString(18, t02050xml.getJYLX());
				call.setDouble(19,t02050xml.getJZMJ());
				call.setDouble(20,t02050xml.getHTZJ());
				call.setDate(21, ConvertUtil.utilDateToSqlDate(t02050xml.getJYSJ()));
				call.setDate(22, ConvertUtil.utilDateToSqlDate(t02050xml.getFZRQ()));
				call.setString(23, t02050xml.getDF());
				call.setString(24, t02050xml.getCX());
				call.setString(25, t02050xml.getCG());
				call.setInt(26, ConvertUtil.toInteger(t02050xml.getOINSID()));
				call.setDouble(27,t02050xml.getYJG());
				call.setDouble(28, t02050xml.getPGJG());
				call.setString(29, t02050xml.getROOMID());
				call.setString(30, t02050xml.getCzr());
				call.setString(31, t02050xml.getOwnRoomid());
				call.setString(32, t02050xml.getSfsyfcmc());
				call.setString(33, t02050xml.getSsgx());
				call.setString(34, t02050xml.getXqdm());
				call.setDate(35, ConvertUtil.utilDateToSqlDate(t02050xml.getWsrq()));
				call.setDouble(36, t02050xml.getWsjs());
				call.setString(37, t02050xml.getJcsj());
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
	 * @see com.sunway.dao.IPgt02002DAO#LoadByPrimaryKeyXML(com.sunway.vo.Pgt02052xml)
	 */
	
	@Override
	public Pgt02052xml LoadByPrimaryKeyXML(Pgt02052xml Pgt02052xml) throws Exception {
		ArrayList<Pgt02052xml> listResult = new ArrayList<Pgt02052xml>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02071(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, Pgt02052xml.getFcid());
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
	 * @see com.sunway.dao.IPgt02002DAO#LoadAllXML(com.sunway.vo.Pgt02052xml)
	 */
	
	@Override
	public Pgt02052xml LoadAllXML(Pgt02052xml t02050xml) throws Exception {
		Pgt02052xml listResult = new Pgt02052xml();
		ResultSet rs = null;
		ResultSet rsSum = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02071(?,?,?,?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//输入参数
			call.setInt(2,t02050xml.getPageIndex());
			call.setInt(3, t02050xml.getPageSize());
			call.setString(4, t02050xml.getFCSLH());
			call.setString(5, t02050xml.getCLH());
			call.setString(6, t02050xml.getDYFH());
			call.setString(7, t02050xml.getCzr());
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
				listResult.getPgt02052XmlList().add(SetXMLParameters(rs,false));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rsSum, rs, call, conn, session);
		}
		return listResult;
	}

	
	@Override
	public boolean GetUpdateCommandXML(Pgt02052xml Pgt02052xml)
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
			call = conn.prepareCall("{call PGSP_ADDT020023(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			call.setString(1, Pgt02052xml.getFcid());
			call.setString(2, Pgt02052xml.getZRFSFID());
			call.setString(3, Pgt02052xml.getZRFMC());
			call.setString(4, Pgt02052xml.getZRFSFLX());
			call.setString(5, Pgt02052xml.getLFDZ());
			call.setString(6, Pgt02052xml.getLxdh());
			call.setString(7, Pgt02052xml.getNote());
			call.setString(8, Pgt02052xml.getFWLX());
			call.setString(9, Pgt02052xml.getJYLX());
			call.setString(10, Pgt02052xml.getJZJG());
			call.setDouble(11, Pgt02052xml.getJZMJ());
			call.setInt(12, ConvertUtil.toInteger(Pgt02052xml.getSZLC()));
			call.setString(13, Pgt02052xml.getDYFH());
			call.setDouble(14, Pgt02052xml.getHTZJ());
			call.setDouble(15, Pgt02052xml.getTdsyqmj());//Pgt02052xml.getTdsyqmj() 土地使用面积
			call.setDouble(16, Pgt02052xml.getRjl());//Pgt02052xml.getRjl()容积率
			call.setDate(17, ConvertUtil.utilDateToSqlDate(Pgt02052xml.getJYSJ()));
			call.setString(18, Pgt02052xml.getFdcdat());
			call.setString(19, Pgt02052xml.getCzr());
			call.setString(20, Pgt02052xml.getNote());
			call.setString(21, Pgt02052xml.getYFCZH());
			call.setString(22, Pgt02052xml.getQdh());
			call.setString(23, Pgt02052xml.getCb());
			call.setString(24, Pgt02052xml.getSJYT());
			call.setString(25, Pgt02052xml.getHxjg());
			call.setString(26, Pgt02052xml.getJcsj());
			call.setDate(27, ConvertUtil.utilDateToSqlDate(Pgt02052xml.getFZRQ()));
			call.setString(28, Pgt02052xml.getShr());
			call.setString(29, Pgt02052xml.getXqdm());
			call.setString(30, Pgt02052xml.getJZJG());
			call.setInt(31, ConvertUtil.toInteger(Pgt02052xml.getYwdt()));
			call.setInt(32, ConvertUtil.toInteger(Pgt02052xml.getZLC()));
			call.setString(33, Pgt02052xml.getNote());
			call.setString(34, Pgt02052xml.getLFDZ());
			call.setString(35, Pgt02052xml.getLFDZ());
			call.setString(36, Pgt02052xml.getCd00053Qtxzid());
			call.setString(37, Pgt02052xml.getSsgx());
			call.setInt(38, ConvertUtil.toInteger(Pgt02052xml.getXqzt()));
			call.setString(39, Pgt02052xml.getSzqy());
			call.setString(40, Pgt02052xml.getParentdm());
			call.setString(41, Pgt02052xml.getXqnm());
			call.setString(42, Pgt02052xml.getZhxz());
			call.setString(43, Pgt02052xml.getCLH());
			call.setInt(44, ConvertUtil.toInteger(Pgt02052xml.getYwjkc()));
			call.setString(45, Pgt02052xml.getCSFSFLX());
			call.setString(46, Pgt02052xml.getCSFMC());
			call.setString(47, Pgt02052xml.getCSFSFID());
			call.setString(48, Pgt02052xml.getFCSLH());
			call.setInt(49, ConvertUtil.toInteger(Pgt02052xml.getOINSID()));
			call.setDouble(50, Pgt02052xml.getYJG());
			call.setDouble(51, Pgt02052xml.getPGJG());
			call.setString(52, Pgt02052xml.getROOMID());
			call.setString(53, Pgt02052xml.getOwnRoomid());
			call.setInt(54, Pgt02052xml.getSfsyfc());
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
	 * @see com.sunway.dao.IPgt02002DAO#GetDeleteCommandXML(com.sunway.vo.Pgt02052xml)
	 */
	
	@Override
	public boolean GetDeleteCommandXML(Pgt02052xml Pgt02052xml) throws Exception {
	
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
			call.setString(1, Pgt02052xml.getFCSLH());
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
	
	public Integer JCXML(Pgt02052xml bean) throws Exception {
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
	public boolean GetUpdateCommand371(Pgt02052xml Pgt02052xml)
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
			call.setString(1, Pgt02052xml.getFcid());
			call.setString(2, Pgt02052xml.getFCSLH());
			call.setString(3, Pgt02052xml.getYFCZH());
			call.setString(4, Pgt02052xml.getZRFSFLX());
			call.setString(5, Pgt02052xml.getZRFSFID());
			call.setString(6, Pgt02052xml.getZRFMC());
			call.setString(7, Pgt02052xml.getCSFSFLX());
			call.setString(8, Pgt02052xml.getCSFSFID());
			call.setString(9, Pgt02052xml.getCSFMC());
			call.setString(10, Pgt02052xml.getCLH());
			call.setString(11, Pgt02052xml.getSJYT());
			call.setString(12, Pgt02052xml.getLFDZ());
			call.setString(13, Pgt02052xml.getDYFH());
			call.setString(14, Pgt02052xml.getSZLC());
			call.setString(15, Pgt02052xml.getZLC());
			call.setString(16, Pgt02052xml.getJZJG());
			call.setString(17, Pgt02052xml.getFWLX());
			call.setString(18, Pgt02052xml.getJYLX());
			call.setDouble(19, Pgt02052xml.getJZMJ());
			call.setDouble(20, Pgt02052xml.getHTZJ());
			call.setDate(21, ConvertUtil.utilDateToSqlDate(Pgt02052xml.getJYSJ()));
			call.setDate(22, ConvertUtil.utilDateToSqlDate(Pgt02052xml.getFZRQ()));
			call.setString(23, Pgt02052xml.getDF());
			call.setString(24, Pgt02052xml.getCX());
			call.setString(25, Pgt02052xml.getCG());
			call.setDouble(26, Pgt02052xml.getYJG());
			call.setDouble(27, Pgt02052xml.getPGJG());
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
	public Boolean execFS(Pgt02002 bean) throws Exception {
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
	public Pgv02002 GetXMLI(Pgv02002 v02002) throws Exception {
		Pgv02002 bean = new Pgv02002() ;
		CallableStatement call = null;
		Connection conn = null;
		ResultSet rs = null;
		Session session = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT020022(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, v02002.getFcid());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			if(null != rs && rs.next()){
				bean = SetSendXMLI(rs);
				bean.setFclsh(v02002.getFclsh());
				bean.setDjz_channel_pwd(v02002.getDjz_channel_pwd());
				bean.setDjz_channel_acc(v02002.getDjz_channel_acc());
				bean.setDjz_channel_code(v02002.getDjz_channel_code());
				bean.setDjz_wbmbm(v02002.getDjz_wbmbm());
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		return bean;
	}
	
	protected Pgv02002 SetSendXMLI(ResultSet rs)throws Exception {
		Pgv02002 e = new Pgv02002();
		e.setFcid(rs.getString(fcid));
		e.setFcslh(rs.getString(fcslh));
		e.setFczh(rs.getString(fczh));
		e.setClh(rs.getString(clh));
		e.setGhyt(rs.getString(ghyt));
		e.setFwtdzl(rs.getString(zcdzl));
		e.setXqnm(rs.getString(xqnm));
		e.setBwjfh(rs.getString(bwjfh));
		e.setSzlc(rs.getString(szlc));
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
		e.setSfsyfc(rs.getInt(sfsyfc));
		e.setNsrmc(rs.getString(nsrmc));
		e.setZjlx(rs.getString(zjlx));
		e.setZjhm(rs.getString(zjhm));
		e.setCsfnsrmc(rs.getString(csfnsrmc));
		e.setCsfZjlx(rs.getString(csfzjlx));
		e.setCsfzjhm(rs.getString(csfzjhm));
		e.setSypgjg(rs.getDouble(scpgjg));
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
			call = conn.prepareCall("call PGSP_BF_02000(?,?,?,?)");
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
	public Boolean GetInsertCommand3711(Pgt02052xml Pgt02052xml) throws Exception {
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
			call.setString(1, Pgt02052xml.getFcid());
			call.setString(2, Pgt02052xml.getInfoMsg());
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
	public Pgt02052xml LoadAll3711(Pgt02052xml t02050xml) throws Exception {
		Pgt02052xml listResult = new Pgt02052xml();
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
			call.setInt(2,t02050xml.getPageIndex());
			call.setInt(3, t02050xml.getPageSize());
			call.setString(4, t02050xml.getZRFMC());
			call.setString(5, t02050xml.getZRFSFID());
			
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.getPgt02052XmlList().add(SetXMLParameters(rs,true));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rsSum, rs, call, conn, session);
		}
		return listResult;
	}

	
	@Override
	public boolean GetDeleteCommand3711(Pgt02052xml t02050xml) throws Exception {
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
			call.setString(1, t02050xml.getFcid());
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
	public Pgt02052xml LoadByPrimaryKey3711(Pgt02052xml t02050xml)throws Exception {
		ArrayList<Pgt02052xml> listResult = new ArrayList<Pgt02052xml>();
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
			call.setString(2, t02050xml.getFcid());
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
	public ArrayList<Pgt02052xml> LoadByFCSLH02072(Pgt02052xml t02050xml) throws Exception {
		ArrayList<Pgt02052xml> resultList = new ArrayList<Pgt02052xml>();
		ResultSet rs = null;
		Connection conn = null;
		Session session = null;
		CallableStatement call = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT003721(?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, t02050xml.getFCSLH());
			call.setString(3, t02050xml.getSsgx());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				Pgt02052xml e = SetVParametersXML(rs);
				e.setSsgx(t02050xml.getSsgx());
				e.setCzr(t02050xml.getCzr());
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
	protected Pgt02052xml SetVParametersXML(ResultSet rs)throws Exception{
		Pgt02052xml e = new Pgt02052xml();
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
