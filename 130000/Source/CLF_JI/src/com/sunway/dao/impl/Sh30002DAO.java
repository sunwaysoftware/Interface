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

import com.sunway.dao.ISh30002DAO;
import com.sunway.vo.Pgv00302;

/**
 *
 * 通過审核操作[市場法]
 * @author Andy.Gao
 * @category 數據審核[市場法]
 *
 */
public class Sh30002DAO extends BaseDAO implements ISh30002DAO {

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.ISh30002DAO#GetExecShAgain(com.sunway.vo.Pgv00302)
	 */
	
	@Override
	public Boolean GetExecShAgain(Pgv00302 bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00383(?,?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getFcid());
			call.setString(2, bean.getShCzr());
			call.setString(3, bean.getSysPssd());
			call.setString(4, bean.getCd00001Ssgx());
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
	 * @see com.sunway.dao.ISh30002DAO#GetExecShAgainAll(com.sunway.vo.Pgv00302)
	 */
	
	@Override
	public Boolean GetExecShAgainAll(Pgv00302 bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00384(?,?,?,?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getFcid());
			call.setString(2, bean.getCd00301Swid());
			call.setString(3, bean.getNsrmc());
			call.setString(4, bean.getCd00001Ssgx());
			call.setString(5, bean.getShCzr());
			call.setString(6, bean.getSysPssd());
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
	 * @see com.sunway.dao.ISh30002DAO#LoadShOK(com.sunway.vo.Pgv00302)
	 */
	
	@Override
	public ArrayList<Pgv00302> LoadShOK(Pgv00302 bean) throws Exception {
		ArrayList<Pgv00302> listResult = new ArrayList<Pgv00302>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003012(?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getCd00301Swid());
			call.setString(5, bean.getNsrmc());
			call.setString(6, bean.getCd00001Ssgx());
			call.setString(7, bean.getSysPssd());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				listResult.add(SetV00302Parameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/**
	 * View數據轉存
	 * @param rs 數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgv00302 SetV00302Parameters(ResultSet rs) throws Exception {
		String total = "TOTAL";
		String rid = "RID";
		String shCzr = "SCSHCZR";
		String fcid = "FCID";
		String cd00301Swid = "CD_00301_SWID";
		String cd00303Lfid = "CD_00303_LFID";
		String cd00001Fwlx = "CD_00001_FWLX";
		String cd00001Jylx = "CD_00001_JYLX";
		String cd00001Jzjg = "CD_00001_JZJG";
		String jzmj = "JZMJ";
		String cd00001Fwcx = "CD_00001_FWCX";
		String cd00001Cgzk = "CD_00001_CGZK";
		String szlc = "SZLC";
		String bwjfh = "BWJFH";
		String jyjg = "JYJG";
		String tdsyqmj = "TDSYQMJ";
		String rjl = "RJL";
		String jysj = "JYSJ";
		String fdcdat = "FDCDAT";
		String upddate = "UPDDATE";
		String cd00002Czr = "CD_00002_CZR";
		String note = "NOTE";
		String nsrmc = "NSRMC";
		String cd00001Ssgx = "CD_00001_SSGX";
		String cd00352Xqdm = "CD_00352_XQDM";
		String cd00001Szqy = "CD_00001_SZQY";
		String ywdt = "YWDT";
		String zlc = "ZLC";
		String xqnm = "XQNM";
		String xqbm = "XQBM";
		String szqy = "SZQY";
		String fwlx = "FWLX";
		String jylx = "JYLX";
		String jzjg = "JZJG";
		String fwcx = "FWCX";
		String cgzk = "CGZK";
		String czr = "CZR";

		Pgv00302 e = new Pgv00302();
		e.setRecordCount(rs.getInt(total));
		e.setRecordIndex(rs.getInt(rid));
		e.setShCzr(rs.getString(shCzr));
		e.setFcid(rs.getString(fcid));
		e.setCd00301Swid(rs.getString(cd00301Swid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		e.setCd00001Fwlx(rs.getString(cd00001Fwlx));
		e.setCd00001Jylx(rs.getString(cd00001Jylx));
		e.setCd00001Jzjg(rs.getString(cd00001Jzjg));
		e.setJzmj(rs.getDouble(jzmj));
		e.setCd00001Fwcx(rs.getString(cd00001Fwcx));
		e.setCd00001Cgzk(rs.getString(cd00001Cgzk));
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
		e.setFwcx(rs.getString(fwcx));
		e.setCgzk(rs.getString(cgzk));
		e.setCzr(rs.getString(czr));
		return e;
	}
}
