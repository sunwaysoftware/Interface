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

import com.sunway.dao.ICL00390DAO;
import com.sunway.util.CheckUtil;
import com.sunway.util.ConvertUtil;
import com.sunway.vo.BF00000;
import com.sunway.vo.Pgv00331;

/**
 * @author Andy.Gao
 *
 */
public class CL00390DAO extends BaseDAO implements ICL00390DAO {

	
	public ArrayList<Pgv00331> LoadJs(Pgv00331 bean) throws Exception {
		ArrayList<Pgv00331> listResult = new ArrayList<Pgv00331>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT0033123(?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getSysPssd());
			call.setString(5, bean.getCd00301Swid());
			call.setString(6, bean.getNsrmc());
			call.setString(7, bean.getSysSsgx());
			call.setString(8, bean.getCd00302Fcid());
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
		String cd00301Swid = "CD_00301_SWID";
		String nsrmc = "NSRMC";
		String scpgczr = "SCPGCZR";
		String pgjg = "PGJG";
		String scpgzt = "SCPGZT";
		String cd00302Fcid = "CD_00302_FCID";
		//String isCqts = "ISINFO";
		String zjhm = "ZJHM";
		String SBZT = "SBZT";
		String fcslh = "FCSLH";
		String SCDJZZT = "SCDJZZT";
		String upddate = "UPDDATE";
		String isbg = "ISBG";
		String fwuuid = "FWUUID";
		Pgv00331 v00331 = new Pgv00331(rs.getString(cd00302Fcid),
				rs.getDouble(pgjg),
				rs.getString(cd00301Swid),
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
		v00331.setSbzt(rs.getInt(SBZT));
		v00331.setScdjzzt(rs.getInt(SCDJZZT));
		v00331.setScpgzt(rs.getInt(scpgzt));
		v00331.setUpddate(rs.getTimestamp(upddate));
		v00331.setIsbg(rs.getShort(isbg)); 
		v00331.setFwuuid(rs.getString(fwuuid));
		try{
			v00331.setFcslh(rs.getString(fcslh));
		}catch(Exception e){
			return v00331;
		}
		
		return v00331;
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.ICL00390DAO#execRD(com.sunway.vo.Pgv00331)
	 */
	
	@Override
	public Boolean execRD(Pgv00331 bean) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;		
		try {
			session = getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_CZ_000452(?,?,?)}");
			//传入输入参数
			call.setString(1, bean.getCd00302Fcid());
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
	 * @see com.sunway.dao.ICL00390DAO#LoadSb(com.sunway.vo.Pgv00331)
	 */
	
	@Override
	public ArrayList<Pgv00331> LoadSb(Pgv00331 bean) throws Exception {
		ArrayList<Pgv00331> listResult = new ArrayList<Pgv00331>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT0033122(?,?,?,?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getSysPssd());
			call.setString(5, bean.getCd00301Swid());
			call.setString(6, bean.getNsrmc());
			call.setString(7, bean.getSysSsgx());
			call.setString(8, bean.getFcslh());
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
	 * @see com.sunway.dao.ICL00390DAO#execTzs(com.sunway.vo.BF00000)
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
			call = conn.prepareCall("{call PGSP_BF_00000(?,?,?,?)}");
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
				e.setJyjg(rs.getBigDecimal("jyjg"));
				e.setJylx(rs.getString("jylx"));
				e.setJzjg(rs.getString("jzjg"));
				e.setJzmj(rs.getDouble("jzmj"));
				e.setLxdh(rs.getString("lxdh"));
				e.setNsrmc(rs.getString("nsrmc"));
				e.setPgjg(rs.getBigDecimal("pgjg"));
				e.setSwid(rs.getString("swid"));
				e.setSzlc(rs.getString("szlc"));
				e.setSzqy(rs.getString("szqy"));
				e.setXqnm(rs.getString("xqnm"));
				e.setYwdt(rs.getString("ywdt"));
				e.setZcdzl(rs.getString("zcdzl"));
				e.setZhxz(rs.getString("zhxz"));
				e.setZjlx(rs.getString("zjlx"));
				e.setZlc(rs.getInt("zlc"));
				e.setPgjgZh(ConvertUtil.toCNY(e.getPgjg().doubleValue()));
				e.setCsfmc(rs.getString("csfnsrmc"));
				e.setCsfsflx(rs.getString("csfzjlx"));
				e.setCsfsfid(rs.getString("csfzjhm"));
				if(CheckUtil.chkEmpty(rs.getString("gbpgjg"))){
					e.setSwjg("税 务 机 关"+"\r\n"+"评 估 价 格");
				}else{
					e.setSwjg("个 案 评 估");
					//e.setSwjg("专 业 机 构"+"\r\n"+"评 估 价 格");
				}
				e.setSsgx(bean.getSsgx());
				e.setCsflxdh(rs.getString("CSFLXDH"));
				e.setJcnf(rs.getString("JCSJ"));
				e.setQswsjs(rs.getBigDecimal("QSWSJS"));
				e.setQswsrq(rs.getDate("QSWSRQ"));
				e.setPgjgF(rs.getBigDecimal("PGJGF"));
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
