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

import com.sunway.dao.IPg30001gDAO;
import com.sunway.vo.Pgv00331;

/**
 *
 * 市場法讀取个案评税數據列表
 * @author Andy.Gao
 *
 */
public class Pg30001gDAO extends BaseDAO implements IPg30001gDAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPg30001gDAO#LoadPgMx(com.sunway.vo.Pgv00331)
	 */
	
	@Override
	public ArrayList<Pgv00331> LoadPgMx(Pgv00331 bean) throws Exception {
		ArrayList<Pgv00331> listResult = new ArrayList<Pgv00331>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003313(?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getSysPssd());
			call.setString(5, bean.getCd00301Swid());
			call.setString(6, bean.getNsrmc());
			call.setString(7, bean.getCd00302Fcid());
			call.setString(8, bean.getSysSsgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				listResult.add(SetV00331Parameters(rs));
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
	protected Pgv00331 SetV00331Parameters(ResultSet rs) throws Exception {
		String total = "TOTAL";
		String rid = "RID";
		String cd00302Fcid = "CD_00302_FCID";
		String cd00002Pssdy = "CD_00002_PSSDY";
		String pgjg = "PGJG";
		String cd00002Pssd = "CD_00002_PSSD";
		String pfmjg = "PFMJG";
		String jysj = "JYSJ";
		//String lcxz = "LCXZ";
		String cd00303Lfid = "CD_00303_LFID";
		String xqdm = "XQDM";
		String fwlx = "FWLX";
		String jylx = "JYLX";
		String jzjg = "JZJG";
		String szlc = "SZLC";
		String zlc = "ZLC";
		String ywdt = "YWDT";
		String jzmj = "JZMJ";
		String cd00301Swid = "CD_00301_SWID";
		String upddate = "UPDDATE";
		String czr = "CZR";
		String note = "NOTE";
		String nsrmc = "NSRMC";
		String cd00001Ssgx = "CD_00001_SSGX";
		String gbpgjg = "GBPGJG";
		String scpgczr = "SCPGCZR";
		String gzCount = "GZCOUNT";
		String zjhm = "ZJHM";
		Pgv00331 e = new Pgv00331();
		e.setCd00002Pssd(rs.getDate(cd00002Pssd));
		e.setCd00002Pssdy(rs.getString(cd00002Pssdy));
		e.setCd00301Swid(rs.getString(cd00301Swid));
		e.setCd00302Fcid(rs.getString(cd00302Fcid));
		e.setCd00303Lfid(rs.getString(cd00303Lfid));
		//e.setCgxz(rs.getDouble(cgxz));
		//e.setCgzk(rs.getString(cgzk));
		//e.setCxxz(rs.getDouble(cxxz));
		e.setCzr(rs.getString(czr));
		//e.setFwcx(rs.getString(fwcx));
		e.setFwlx(rs.getString(fwlx));
		//e.setFwtdzl(rs.getString(fwtdzl));
		e.setGbpgjg(rs.getDouble(gbpgjg));
		e.setJylx(rs.getString(jylx));
		e.setJysj(rs.getDate(jysj));
		e.setJzjg(rs.getString(jzjg));
		e.setJzmj(rs.getDouble(jzmj));
		//e.setLcxz(rs.getDouble(lcxz));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setPfmjg(rs.getDouble(pfmjg));
		e.setPgCzr(rs.getString(scpgczr));
		e.setPgjg(rs.getDouble(pgjg));
		e.setRecordCount(rs.getInt(total));
		e.setRecordIndex(rs.getInt(rid));
		e.setSzlc(rs.getShort(szlc));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setXqdm(rs.getString(xqdm));
		e.setYwdt(rs.getBoolean(ywdt));
		e.setZlc(rs.getShort(zlc));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setGzCount(rs.getInt(gzCount));
		e.setZjhm(rs.getString(zjhm));
		return e;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPg30001gDAO#GetPgCommand(com.sunway.vo.Pgv00331)
	 */
	
	@Override
	public Boolean GetPgCommand(Pgv00331 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_003321(?,?,?,?)}");
			// 輸出參數
			call.registerOutParameter(1, OracleTypes.INTEGER);
			// 输入参数
			call.setString(2, bean.getSlid());
			call.setString(3, bean.getPgCzr());
			call.setString(4, bean.getCd00302Fcid());
			call.execute();
			tran.commit();
			bResult = call.getBoolean(1);
		} catch (Exception e) {
			tran.rollback();
			throw e;
		} finally {
			getFree(call, conn, session);
		}
		return bResult;
	}
}
