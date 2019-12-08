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

import com.sunway.dao.IPgt00384DAO;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.vo.Pgv00384;

/**
 *
 * 市場审核和评税未过原因说明
 * @author Andy.Gao
 *
 */
public class Pgt00384DAO extends BaseDAO implements IPgt00384DAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00384DAO#LoadAll(com.sunway.vo.Pgv00384)
	 */
	
	@Override
	public ArrayList<Pgv00384> LoadAll(Pgv00384 bean) throws Exception {
		ArrayList<Pgv00384> listResult = new ArrayList<Pgv00384>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00384(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd00302Fcid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				Pgv00384 e = new Pgv00384();
				e.setBxsh(rs.getBoolean("BXSH"));
				e.setCd00002Pssd(rs.getString("CD_00002_PSSD"));
				e.setCd00302Fcid(rs.getString("CD_00302_FCID"));
				e.setShlx(rs.getInt("SHLX"));
				e.setShyy(rs.getString("SHYY"));
				e.setUpddate(rs.getDate("UPDDATE"));
				e.setNote(rs.getString("NOTE"));
				e.setShmc(rs.getString("SHMC"));
				e.setOpenWinUrl(makeUrl(e.getCd00302Fcid(),e.getShlx(),e.getNote()));
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

	/**
	 * 組織需要轉向的URL
	 * @param value 審核未通過原因
	 * @return 轉向的URL
	 */
	protected String makeUrl(String mxid, Integer shlx, String value) {
		String resultValue = null;
		//進行ACTION組合判讀
		switch (shlx) {
		case 81:// 00353
			resultValue = "xtwh/ADDT00353.action?ACT=U";
			break;
		case 83:// 00354
			resultValue = "xtwh/ADDT00353.action?ACT=U";
			break;
		case 82:// 00355
			resultValue = "xtwh/ADDT00355.action?ACT=U";
			break;
		case 84:// 00356
			resultValue = "xtwh/ADDT00356.action?ACT=U";
			break;
		case 85:
			resultValue = "xtwh/ADDT00351.action?ACT=C&FROM=U";
			break;
		case 86:
			resultValue = "";
			break;
		case 87:// 00353
			resultValue = "xtwh/ADDT00353.action?ACT=U";
			break;
		case 88:// 00353
			resultValue = "xtwh/ADDT00353.action?ACT=U";
			break;
		case 89:// 00353
			resultValue = "xtwh/ADDT00353.action?ACT=U";
			break;
		default:
			break;
		}
		// 進行參數組合
		if(!Common.isNullOrEmpty(value)){
			String[] param = value.split(Constant.STRING_COMMA);
			for(Integer i=0; i < param.length; i++){
				String[] keyValue = param[i].split(":");
				if(keyValue.length>0){
					if(keyValue.length==1)
						resultValue = resultValue + "&" + keyValue[0] + "=";
					if(keyValue.length==2)
						resultValue = resultValue + "&" + keyValue[0] + "=" + keyValue[1];
				}
			}
		}
		return Common.checkNull(resultValue);
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00384DAO#LoadYY()
	 */
	
	@Override
	public ArrayList<Pgv00384> LoadYY(Pgv00384 bean) throws Exception {
		ArrayList<Pgv00384> listResult = new ArrayList<Pgv00384>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003840(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd00001Szqy());
			call.setString(3, bean.getCd00001Ssgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				Pgv00384 e = new Pgv00384();
				e.setShlx(rs.getInt("SHLX"));
				e.setShyy(rs.getString("SHYY"));
				e.setNote(rs.getString("NOTE"));
				e.setShmc(rs.getString("SHMC"));
				e.setOpenWinUrl(makeUrl(e.getCd00302Fcid(),e.getShlx(),e.getNote()));
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

	
	@Override
	public ArrayList<Pgv00384> LoadQMPG(Pgv00384 bean) throws Exception {
		ArrayList<Pgv00384> listResult = new ArrayList<Pgv00384>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT003842(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd00302Fcid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				Pgv00384 e = new Pgv00384();
				e.setBxsh(rs.getBoolean("BXSH"));
				e.setCd00002Pssd(rs.getString("CD_00002_PSSD"));
				e.setCd00302Fcid(rs.getString("CD_00320_FCID"));
				e.setShlx(rs.getInt("SHLX"));
				e.setShyy(rs.getString("SHYY"));
				e.setUpddate(rs.getDate("UPDDATE"));
				e.setNote(rs.getString("NOTE"));
				e.setShmc(rs.getString("SHMC"));
				e.setOpenWinUrl(makeUrl(e.getCd00302Fcid(),e.getShlx(),e.getNote()));
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
