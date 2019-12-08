/**
 * 
 */
package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunway.dao.IWBJH00DAO;
import com.sunway.vo.Pgt00370;
import com.sunway.vo.Pgv00370;
import com.sunway.vo.WBJH00000;

/**
 * @author Amani
 *
 */
public class WBJH00DAO extends BaseDAO implements IWBJH00DAO {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunway.dao.IWBJH00DAO#InsGT3WBJH(java.lang.String)
	 */
	@Override
	public Boolean InsGT3WBJH(String fcid) throws Exception {
		boolean bResult = false;
		Connection conn = null;
		CallableStatement call = null;
		Session session = null;
		Transaction tran = null;
		try {
			session = super.getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();
			call = conn.prepareCall("{call WBJH_INS_GT3(?)}");
			// 傳入輸入參數
			call.setString(1, fcid);
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
	public String FindCode(String root, String code) throws Exception {
		String sResult;
		Connection conn = null;
		CallableStatement call = null;
		try {
			conn = super.getConnection();
			call = conn.prepareCall("{? = call WBJH_F01(?,?)}");
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			// 傳入輸入參數
			call.setString(2, root);
			call.setString(3, code);
			call.execute();
			sResult = call.getString(1);
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(call, conn, null);
		}
		return sResult;
	}

	@Override
	public ArrayList<WBJH00000> LoadQyxx(WBJH00000 wbjh) throws Exception {
		StringBuilder dbSQL = new StringBuilder();
		dbSQL.append(" SELECT A.FDDBRXM,A.FDDBRSFZJHM,E.SFZJLXMC,B.JYFW,");
		dbSQL.append(" A.NSRMC,F.NSRZTMC,A.SCJYDZ,A.ZCDZ,C.SWJGMC,");
		dbSQL.append(" D.SWJGMC,A.ZZJG_DM,A.NSRSBH FROM HX_DJ.DJ_NSRXX A,");
		dbSQL.append(" HX_DJ.DJ_NSRXX_KZ B,HX_DM_ZDY.DM_GY_SWJG C,HX_DM_ZDY.DM_GY_SWJG D,");
		dbSQL.append(" HX_DM_QG.DM_GY_SFZJLX E,HX_DM_QG.DM_GY_NSRZT F");
		dbSQL.append(" WHERE A.NSRSBH = ? AND A.DJXH = B.DJXH");
		dbSQL.append(" AND A.ZGSWJ_DM = C.SWJG_DM AND A.ZGSWSKFJ_DM = D.SWJG_DM");
		dbSQL.append(" AND A.FDDBRSFZJLX_DM = E.SFZJLX_DM AND A.NSRZT_DM = F.NSRZT_DM");

		ArrayList<WBJH00000> listResult = new ArrayList<WBJH00000>();
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pre = null;
		try {
			logger.info("【企业】准备金三数据库连接资源");
			Class.forName(wbjh.getGt3DriverClass());
			conn = DriverManager.getConnection(wbjh.getGt3DSUrl(), wbjh.getGt3User(), wbjh.getGt3Password());
			logger.info("金三数据库连接成功");
			pre = conn.prepareStatement(dbSQL.toString());// 实例化预编译语句
			pre.setString(1, wbjh.getNsrsbh());
			rs = pre.executeQuery();// 执行查询，注意括号中不需要再加参数		
			while (null != rs && rs.next()) {
				WBJH00000 e = new WBJH00000();
				e.setFddbr(rs.getString(1));
				e.setFrzjhm(rs.getString(2));
				e.setFrzjlx(rs.getString(3));
				e.setJyfw(rs.getString(4));
				e.setNsrmc(rs.getString(5));
				e.setNsrzt(rs.getString(6));
				e.setScjydz(rs.getString(7));
				e.setZcdz(rs.getString(8));
				e.setZgswjg(rs.getString(9));
				e.setZgsws(rs.getString(10));
				e.setZzjgdm(rs.getString(11));
				e.setNsrsbh(rs.getString(12));
				listResult.add(e);
				e = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (rs != null) rs.close();
				if (pre != null) pre.close();
				if (conn != null) conn.close();
				logger.info("【企业】释放金三数据库连接资源");
			} catch (Exception e) {
				logger.error(e.getMessage());
			}			
		}
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sunway.dao.IWBJH00DAO#GetGT3WSXX(java.lang.String)
	 */
	@Override
	public Pgt00370 GetGT3WSXX(String fcid, WBJH00000 gt3) throws Exception {
		Pgt00370 listResult = new Pgt00370();
		ArrayList<Pgv00370> wsxxList = new ArrayList<Pgv00370>();
		ResultSet rs = null;
		Connection conn = null;
		CallableStatement call = null;
		PreparedStatement pre = null;
		Session session = null;
		Transaction tran = null;		
		String fwuuid = null;
		try {
			session = super.getSession();
			tran = session.beginTransaction();
			conn = super.getConnection();			
			// 1.将FCID转换为FWUUID
			pre = conn.prepareStatement("SELECT fwuuid FROM pgt00302 t WHERE t.fcid=?");
			pre.setString(1, fcid);
			rs = pre.executeQuery();
			while (rs.next()) {
				fwuuid = rs.getString("fwuuid");
			}
			rs.close();
			pre.close();
			// 2.读取金三完税数据
			ArrayList<Pgv00370> wsxx = readGT3WSXX(fwuuid, gt3);
			if(wsxx.isEmpty()){
				logger.info("未读取到该笔交易的完税信息");
			} else {
				call = conn.prepareCall("{call WBJH_ADD00002(?,?,?)}");
				for (Pgv00370 b : wsxx) {	
					// 傳入輸入參數
					call.setString(1, b.getFwuuid());
					call.setString(2, b.getCd_00001_sz());
					call.setDouble(3, b.getSe());
					call.execute();
				}
				tran.commit();
				call.close();
			}
			// 3.在评估系统中读取税额信息
			call = conn.prepareCall("{call WBJH_GET00002(?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 傳入輸入參數
			call.setString(2, fwuuid);
			call.execute();
			// 返回數據集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				Pgv00370 b = new Pgv00370();
				b.setCd_00001_sz(rs.getString("INFOID"));
				b.setSe(rs.getDouble("SJJE"));
				b.setFwuuid(rs.getString("FWUUID"));	
				wsxxList.add(b);
				b = null;
			}	
			listResult.setSzxxList(wsxxList);			
		} catch (Exception e) {
			tran.rollback();
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	/**
	 * 读取金三完税信息
	 * 
	 * @param fwuuid
	 *            外部服务FWUUID
	 * @return 税额列表 
	 * @throws Exception 
	 */
	private ArrayList<Pgv00370> readGT3WSXX(String fwuuid, WBJH00000 gt3) throws Exception {
		StringBuilder dbSQL = new StringBuilder();
		//YNSE：应纳税额; JMSE：减免税额; SNSE：实纳税额
		dbSQL.append(" SELECT A.FWUUID, C.ZSXM_DM, SUM(C.YNSE) AS YNSE, SUM(C.JMSE) AS JMSE, SUM(C.YBTSE) AS SNSE ");
		dbSQL.append(" FROM HX_SB.SB_CXS_FCJYCJXX A, HX_SB.SB_CXS_FCJY B, HX_SB.SB_CXS_FCJY_SKXX C ");
		dbSQL.append(" WHERE A.FWUUID = ? AND B.ZFBZ_1 = 'N' AND A.FCJYCJXXUUID = B.FCJYCJXXUUID AND B.FCJYUUID = C.FCJYUUID GROUP BY A.FWUUID, C.ZSXM_DM");

		ArrayList<Pgv00370> szxxList = new ArrayList<Pgv00370>();
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			logger.info("【完税】准备金三数据库连接资源");
			Class.forName(gt3.getGt3DriverClass());
			con = DriverManager.getConnection(gt3.getGt3DSUrl(), gt3.getGt3User(), gt3.getGt3Password());
			logger.info("金三数据库连接成功");
			String sql = dbSQL.toString();
			pre = con.prepareStatement(sql);// 实例化预编译语句
			pre.setString(1, fwuuid);
			rs = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			while (rs.next()) {
				Pgv00370 b = new Pgv00370();
				b.setCd_00001_sz(rs.getString("ZSXM_DM"));
				b.setSe(rs.getDouble("SNSE")); //SNSE：实纳税额
				b.setFwuuid(rs.getString("FWUUID"));
				szxxList.add(b);
				b = null;	
			} 
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		} finally {
			try {
				if (rs != null) rs.close();
				if (pre != null) pre.close();
				if (con != null) con.close();
				logger.info("【完税】释放金三数据库连接资源");
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		return szxxList;
	}
}
