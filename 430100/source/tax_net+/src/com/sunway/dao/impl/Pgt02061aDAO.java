package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IPgt02061aDAO;
import com.sunway.util.ConvertUtil;
import com.sunway.vo.Pgt02061a;
import com.sunway.vo.Pgv02061;
import com.sunway.vo.Pgv02061a;

/**
 * 市场法标准房价格维护交易价格
 * @category 系统维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02061aDAO extends BaseDAO implements IPgt02061aDAO {

	private static final String total = "TOTAL";
	private static final String slid = "SLID";
	private static final String cd02061Slid = "CD_02061_SLID";
	private static final String jysj = "JYSJ";
	private static final String pfmjg = "PFMJG";
	private static final String upddate = "UPDDATE";
	private static final String cd00002Czr = "CD_00002_CZR";
	private static final String note = "NOTE";
	private static final String cd00303Lfid = "CD_00303_LFID";
	private static final String cd00001Fwlx = "CD_00001_FWLX";
	private static final String cd00001Jylx = "CD_00001_JYLX";
	private static final String cd00001Jzjg = "CD_00001_JZJG";
	private static final String szlc = "SZLC";
	private static final String fwlx = "FWLX";
	private static final String jylx = "JYLX";
	private static final String jzjg = "JZJG";
	private static final String cd02050Xqdm = "CD_02050_XQDM";
	private static final String ywdt = "YWDT";
	private static final String zlc = "ZLC";
	private static final String xqnm = "XQNM";
	private static final String xqbm = "XQBM";
	private static final String szqy = "SZQY";
	private static final String cd00001Szqy = "CD_00001_SZQY";
	private static final String czr = "CZR";
//	private static final String fwlxSc = "FWLX_SC";
//	private static final String jylxSc = "JYLX_SC";
	//private static final String hxjg = "HXJG";
	//private static final String dypfmjg = "DYPFMJG";
	//private static final String zhxz = "ZHXZ";
	private static final String parentnm = "PARENTNM";
	//private static final String fwtdzl = "FWTDZL";
	
	private static final String cd00001Fwcx = "CD_00001_FWCX";
	private static final String cd00001Fqwz = "CD_00001_FQWZ";
	private static final String cd00001Dywz = "CD_00001_DYWZ";
	private static final String fwcx = "FWCX";
	private static final String dywz = "DYWZ";
	private static final String fqwz = "FQWZ";
	private static final String bwjfh = "BWJFH";
	private static final String qdh = "QDH";
	private static final String zh = "ZH";

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt02061aDAO#LoadAll(com.sunway.vo.Pgv02061a)
	 */
	
	@Override
	public ArrayList<Pgv02061a> LoadAll(Pgv02061a v02061a) throws Exception {
		ArrayList<Pgv02061a> listResult = new ArrayList<Pgv02061a>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02061A(?,?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setInt(2, v02061a.getPageIndex());
			call.setInt(3, v02061a.getPageSize());
			call.setString(4, v02061a.getCd02061Slid());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetVParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.IPgt02061aDAO#GetInsertCommand(com.sunway.vo.Pgt02061a)
	 */
	
	@Override
	public boolean GetInsertCommand(Pgt02061a t02061a) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_ADDT02061A(?,?,?,?,?)}");
			// 传入输入参数
			call.setString(1, t02061a.getCd02061Slid());
			call.setDate(2, ConvertUtil.utilDateToSqlDate(t02061a.getJysj()));
			call.setDouble(3, t02061a.getPfmjg());
			call.setString(4, t02061a.getCd00002Czr());
			call.setString(5, t02061a.getNote());
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
	 * @see com.sunway.dao.IPgt02061aDAO#GetDeleteCommand(com.sunway.vo.Pgt02061a)
	 */
	
	@Override
	public boolean GetDeleteCommand(Pgt02061a t02061a) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_DELT02061A(?)}");
			// 传入输入参数
			call.setString(1, t02061a.getSlid());
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

	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv02061a SetVParameters(ResultSet rs) throws Exception {
		Pgv02061a e = new Pgv02061a();
		e.setRecordCount(rs.getInt(total));
		e.setSlid(rs.getString(slid));
		e.setCd02061Slid(rs.getString(cd02061Slid));
		e.setJysj(rs.getDate(jysj));
		e.setPfmjg(rs.getDouble(pfmjg));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setCzr(rs.getString(czr));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02061aDAO#LoadByPrimaryKey(com.sunway.vo.Pgt02061a)
	 */
	
	@Override
	public Pgv02061 LoadBySlid(Pgt02061a t02061a) throws Exception {
		ArrayList<Pgv02061> listResult = new ArrayList<Pgv02061>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT02061A(?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, t02061a.getSlid());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetDParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, null);
		}
		if (listResult != null && listResult.size() > 0) {
			return listResult.get(0);
		} else {
			return new Pgv02061();
		}
	}
	
	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt02061a SetTParameters(ResultSet rs) throws Exception {
		Pgt02061a e = new Pgt02061a();
		e.setSlid(rs.getString(slid));
		e.setCd02061Slid(rs.getString(cd02061Slid));
		e.setJysj(rs.getDate(jysj));
		e.setPfmjg(rs.getDouble(pfmjg));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		return e;
	}
	
	/**
	 * View数据转存
	 * @param rs 数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgv02061 SetDParameters(ResultSet rs) throws Exception {
		Pgv02061 e = new Pgv02061();
		e.setSlid(rs.getString(slid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
//		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
//		e.setCd00001Cgzk(rs.getString(cd00001Cgzk));
		e.setSzlc(rs.getShort(szlc));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setNote(rs.getString(note));
		e.setFwlx(rs.getString(fwlx));
		e.setJylx(rs.getString(jylx));
		e.setJzjg(rs.getString(jzjg));
//		e.setFwcx(rs.getString(fwcx));
//		e.setCgzk(rs.getString(cgzk));
		e.setCd02050Xqdm(rs.getString(cd02050Xqdm));
		e.setYwdt(rs.getString(ywdt));
		e.setZlc(rs.getShort(zlc));
		e.setXqnm(rs.getString(xqnm));
		e.setParentnm(rs.getString(parentnm));
		e.setXqbm(rs.getString(xqbm));
		e.setSzqy(rs.getString(szqy));
		e.setCd00001Szqy(rs.getString(cd00001Szqy));
		e.setCzr(rs.getString(czr));
		//e.setZhxz(rs.getString(zhxz));
		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
		e.setCd00001Fqwz(rs.getString(cd00001Fqwz));
		e.setCd00001Dywz(rs.getString(cd00001Dywz));
		e.setFwcx(rs.getString(fwcx));
		e.setFqwz(rs.getString(fqwz));
		e.setDywz(rs.getString(dywz));
		e.setZh(rs.getString(zh));
		e.setBwjfh(rs.getString(bwjfh));
		e.setQdh(rs.getString(qdh));
		e.setPfmjg(rs.getDouble(pfmjg));
		e.setJysj(rs.getDate("jysj"));
		return e;
	}
}
