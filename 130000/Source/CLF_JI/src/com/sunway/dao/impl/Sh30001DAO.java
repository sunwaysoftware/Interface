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

import com.sunway.dao.ISh30001DAO;
import com.sunway.vo.Pgv00301;
import com.sunway.vo.Pgv00302;

/**
 * 
 * 未审核操作[市場法]
 * @author Andy.Gao
 *
 */
public class Sh30001DAO extends BaseDAO implements ISh30001DAO {

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.ISh30001DAO#GetExecSH(com.sunway.vo.Pgv00302)
	 */
	
	@Override
	public Boolean GetExecSH(Pgv00302 bean) throws Exception {
		boolean bResult = false;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_00381(?,?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.INTEGER);
			//传入输入参数
			call.setString(2, bean.getFcid());
			call.setString(3, bean.getShCzr());
			call.setString(4, bean.getCd00001Ssgx());
			call.execute();
			tran.commit();
			if(call.getInt(1)==0)
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
	 * @see com.sunway.dao.ISh30001DAO#LoadSh(com.sunway.vo.Pgv00302)
	 */
	
	@Override
	public ArrayList<Pgv00302> LoadSh(Pgv00302 bean) throws Exception {
		ArrayList<Pgv00302> listResult = new ArrayList<Pgv00302>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003011(?,?,?,?,?,?,?)}");
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
				listResult.add(SetVShParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.ISh30001DAO#LoadShMxNgList(com.sunway.vo.Pgv00302)
	 */
	
	@Override
	public ArrayList<Pgv00302> LoadShMxNgList(Pgv00302 bean) throws Exception {
		ArrayList<Pgv00302> listResult = new ArrayList<Pgv00302>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003841(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd00301Swid());
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

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.ISh30001DAO#LoadShList(com.sunway.vo.Pgv00302)
	 */
	
	@Override
	public ArrayList<Pgv00302> LoadShList(Pgv00302 bean) throws Exception {
		ArrayList<Pgv00302> listResult = new ArrayList<Pgv00302>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT0030111(?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getSysPssd());
			call.setString(3, bean.getCd00301Swid());
			call.setString(4, bean.getNsrmc());
			call.setString(5, bean.getCd00001Ssgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				Pgv00302 e = new Pgv00302();
				e.setFcid(rs.getString("FCID"));
				listResult.add(e);
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
	protected Pgv00301 SetV00301Parameters(ResultSet rs) throws Exception {
		String swid = "SWID";					//税务编码/证件号码
		String nsrmc = "NSRMC";					//姓名
		String cd00001Zjlx = "CD_00001_ZJLX";	//证件类型
		String zz = "ZZ";						//住址
		String lxdh = "LXDH";					//联系电话
		String yddh = "YDDH";					//移动电话
		String cd00001Ssgx = "CD_00001_SSGX";	//税收管辖
		String upddate = "UPDDATE";				//更新时间
		String cd00002Czr = "CD_00002_CZR";		//录入人
		String note = "NOTE";					//备注信息
		String total = "TOTAL";
		String rid = "RID";
		String zjlx = "ZJLX";
		String ssgx = "SSGX";
		String czr ="CZR";
		String shCzr = "SCSHCZR";
		String isInfo = "ISINFO";
		
		Pgv00301 e = new Pgv00301();
		e.setCd00001Zjlx(rs.getString(cd00001Zjlx));
		e.setCd00001Ssgx(rs.getString(cd00001Ssgx));
		e.setCd00002Czr(rs.getString(cd00002Czr));
		e.setCzr(rs.getString(czr));
		e.setLxdh(rs.getString(lxdh));
		e.setNote(rs.getString(note));
		e.setNsrmc(rs.getString(nsrmc));
		e.setRecordCount(rs.getInt(total));
		e.setRecordIndex(rs.getInt(rid));
		e.setSsgx(rs.getString(ssgx));
		e.setSwid(rs.getString(swid));
		e.setUpddate(rs.getTimestamp(upddate));
		e.setZz(rs.getString(zz));
		e.setYddh(rs.getString(yddh));
		e.setZjlx(rs.getString(zjlx));
		e.setShCzr(rs.getString(shCzr));
		e.setIsInfo(rs.getBoolean(isInfo));
		return e;
	}

	/**
	 * View數據轉存
	 * @param rs 數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgv00302 SetVShParameters(ResultSet rs) throws Exception {

		String total = "TOTAL";
		String rid = "RID";
		String shCzr = "SCSHCZR";
		String isInfo = "ISINFO";
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
		e.setIsInfo(rs.getBoolean(isInfo));
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
		//e.setDtgj(rs.getDouble(dtgj));
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

	/**
	 * View數據轉存
	 * @param rs 數據集
	 * @return 數據實體
	 * @throws Exception
	 */
	protected Pgv00302 SetV00302Parameters(ResultSet rs) throws Exception {
		
//		String total = "TOTAL";
//		String rid = "RID";
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
//		e.setRecordCount(rs.getInt(total));
//		e.setRecordIndex(rs.getInt(rid));
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

	/*
	 * (non-Javadoc)
	 * @see com.sunway.dao.ISh30001DAO#LoadSh0030112(com.sunway.vo.Pgv00301)
	 */
	
	@Override
	public ArrayList<Pgv00301> LoadSh0030112(Pgv00301 bean) throws Exception {
		ArrayList<Pgv00301> listResult = new ArrayList<Pgv00301>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT0030112(?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getSwid());
			call.setString(5, bean.getNsrmc());
			call.setString(6, bean.getSysSsgx());
			call.setString(7, bean.getSysPssd());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				listResult.add(SetV00301Parameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
}