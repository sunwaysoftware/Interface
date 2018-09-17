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

import com.sunway.dao.ICL02090DAO;
import com.sunway.util.CheckUtil;
import com.sunway.util.ConvertUtil;
import com.sunway.vo.BF00000;
import com.sunway.vo.Pgv02031;

/**
 * @author Andy.Gao
 *
 */
public class CL02090DAO extends BaseDAO implements ICL02090DAO {

	
	public ArrayList<Pgv02031> LoadJs(Pgv02031 bean) throws Exception {
		ArrayList<Pgv02031> listResult = new ArrayList<Pgv02031>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT0203123(?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getZjhm());
			call.setString(5, bean.getNsrmc());
			call.setString(6, bean.getSysSsgx());
			call.setString(7, bean.getCd02002Fcid());
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
	protected Pgv02031 SetV00331Parameters(ResultSet rs) throws Exception {
		String total = "TOTAL";
		String rid = "RID";
		String nsrmc = "ZRFMC";
		String scpgczr = "SYPGCZR";
		String pgjg = "PGJG";
		String scpgzt = "SYPGZT";
		String cd02002Fcid = "CD_02002_FCID";
		//String isCqts = "ISINFO";
		String zjhm = "ZRFZJHM";
		String SBZT = "SBZT";
		String fcslh = "FCSLH";
		String SCDJZZT = "SYDJZZT";	
		String upddate = "UPDDATE";
		String isbg = "ISBG";
		String fwuuid = "FWUUID";
		Pgv02031 v02031 = new Pgv02031(rs.getString(cd02002Fcid),
				rs.getDouble(pgjg),
				null,
				rs.getString(nsrmc),
				0.0,
				rs.getInt(total),
				rs.getInt(rid),
				rs.getString(scpgczr),
				
				//rs.getInt(isCqts),
				0,
				0.0,
				rs.getString(zjhm)
				);
		v02031.setScdjzzt(rs.getInt(SCDJZZT));
		v02031.setSbzt(rs.getInt(SBZT));
		v02031.setSypgzt(rs.getInt(scpgzt));
		v02031.setUpddate(rs.getTimestamp(upddate));
		v02031.setIsbg(rs.getShort(isbg));
		v02031.setFwuuid(rs.getString(fwuuid));
		try{
			v02031.setFcslh(rs.getString(fcslh));
		}catch(Exception e){
			return v02031;
		}
		
		return v02031;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.ICL00390DAO#execRD(com.sunway.vo.Pgv02031)
	 */
	
	@Override
	public Boolean execRD(Pgv02031 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;		
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_020452(?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getCd02002Fcid());
			call.setString(2, bean.getCzr());
			call.setString(3, bean.getSysSsgx());
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
	 * @see com.sunway.dao.ICL00390DAO#LoadSb(com.sunway.vo.Pgv02031)
	 */
	
	@Override
	public ArrayList<Pgv02031> LoadSb(Pgv02031 bean) throws Exception {
		ArrayList<Pgv02031> listResult = new ArrayList<Pgv02031>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT0203122(?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getZjhm());
			call.setString(5, bean.getNsrmc());
			call.setString(6, bean.getSysSsgx());
			call.setString(7, bean.getFcslh());
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

	/* (non-Javadoc)
	 * @see com.sunway.dao.ICL02090DAO#execTzs(com.sunway.vo.BF00000)
	 */
	
	@Override
	public ArrayList<BF00000> execTzs(BF00000 bean) throws Exception {
		ArrayList<BF00000> listResult = new ArrayList<BF00000>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_BF_02000(?,?,?,?)}");
			// 注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, bean.getFcid());
			call.setString(3, bean.getCzr());
			call.setString(4, bean.getSysSsgx());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				BF00000 e = new BF00000();
				e.setDjrq(rs.getDate("DJRQ"));
				e.setFcid(rs.getString("FCID"));
				e.setFczh(rs.getString("FCZH"));
				e.setFwlx(rs.getString("Fwlx"));
				e.setJyjg(rs.getBigDecimal("SBJG"));
				e.setJylx(rs.getString("jylx"));
				e.setJzjg(rs.getString("jzjg"));
				e.setJzmj(rs.getDouble("jzmj"));
				e.setLxdh(rs.getString("ZRFLXDH"));
				e.setNsrmc(rs.getString("ZRFMC"));
				e.setPgjg(rs.getBigDecimal("HDJG"));
				e.setSwid(rs.getString("ZRFZJHM"));
				e.setSzlc(rs.getString("SZCS"));
				e.setSzqy(rs.getString("szqy"));
				e.setXqnm(rs.getString("xqnm"));
				//e.setYwdt(rs.getString("ywdt"));
				e.setZcdzl(rs.getString("zcdzl"));
				e.setZhxz(rs.getString("zhxz"));
				e.setZjlx(rs.getString("ZRFZJLX"));
				e.setZlc(rs.getInt("CS"));
				e.setPgjgZh(ConvertUtil.toCNY(e.getPgjg().doubleValue()));
				e.setCsfmc(rs.getString("SRFMC"));
				e.setCsfsflx(rs.getString("SRFZJLX"));
				e.setCsfsfid(rs.getString("SRFZJHM"));
				if(CheckUtil.chkEmpty(rs.getString("gbpgjg"))){
					e.setSwjg("税 务 机 关"+"\r\n"+"评 估 价 格");
				}else{
					e.setSwjg("个 案 评 估");
					//e.setSwjg("专 业 机 构"+"\r\n"+"评 估 价 格");
				}
				e.setSsgx(bean.getSsgx());
				e.setCsflxdh(rs.getString("SRFLXDH"));
				e.setJcnf(rs.getString("JCNF"));
				e.setQswsjs(rs.getBigDecimal("QSWSJS"));
				e.setQswsrq(rs.getDate("QSWSRQ"));
				e.setPgjgF(rs.getBigDecimal("HDJGF"));
				e.setPgjgZhF(ConvertUtil.toCNY(e.getPgjgF().doubleValue()));
				e.setSbh_zr(rs.getString("SBH_ZR"));
				e.setHtbh(rs.getString("HTBH"));
				listResult.add(e);
				e = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
}
