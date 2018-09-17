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

import com.sunway.dao.IPgt02084DAO;
import com.sunway.util.CheckUtil;
import com.sunway.util.Constant;
import com.sunway.vo.Pgv02084;

/**
 *
 * 市場审核和评税未过原因说明
 * @author Andy.Gao
 *
 */
public class Pgt02084DAO extends BaseDAO implements IPgt02084DAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02084DAO#LoadAll(com.sunway.vo.Pgv02084)
	 */
	
	@Override
	public ArrayList<Pgv02084> LoadAll(Pgv02084 bean) throws Exception {
		ArrayList<Pgv02084> listResult = new ArrayList<Pgv02084>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02084(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd02002Fcid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				Pgv02084 e = new Pgv02084();
				e.setBxsh(rs.getBoolean("BXSH"));
				e.setCd02002Fcid(rs.getString("CD_02002_FCID"));
				e.setShlx(rs.getInt("SHLX"));
				e.setShyy(rs.getString("SHYY"));
				e.setUpddate(rs.getDate("UPDDATE"));
				e.setNote(rs.getString("NOTE"));
				e.setShmc(rs.getString("SHMC"));
				e.setOpenWinUrl(makeUrl(e.getCd02002Fcid(),e.getShlx(),e.getNote()));
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
		case 81:// 02053
			resultValue = "xtwh/ADDT02053.action?ACT=U";
			break;
		case 83:// 02054
			resultValue = "xtwh/ADDT02053.action?ACT=U";
			break;
		case 82:// 02055
			resultValue = "xtwh/ADDT02055.action?ACT=U";
			break;
		case 84:// 02056
			resultValue = "xtwh/ADDT02056.action?ACT=U";
			break;
		case 85:
			resultValue = "xtwh/ADDT02051.action?ACT=C&FROM=U";
			break;
		case 86:
			resultValue = "";
			break;
		case 87:// 02053
			resultValue = "xtwh/ADDT02053.action?ACT=U";
			break;
		case 88:// 02053
			resultValue = "xtwh/ADDT02053.action?ACT=U";
			break;
		case 89:// 02053
			resultValue = "xtwh/ADDT02053.action?ACT=U";
			break;
		default:
			break;
		}
		// 進行參數組合
		if(!CheckUtil.chkEmpty(value)){
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
		return CheckUtil.chkNull(resultValue);
	}

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02084DAO#LoadYY()
	 */
	
	@Override
	public ArrayList<Pgv02084> LoadYY(Pgv02084 bean) throws Exception {
		ArrayList<Pgv02084> listResult = new ArrayList<Pgv02084>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020840(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd00001Szqy());
			call.setString(3, bean.getCd00001Ssgx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				Pgv02084 e = new Pgv02084();
				e.setShlx(rs.getInt("SHLX"));
				e.setShyy(rs.getString("SHYY"));
				e.setNote(rs.getString("NOTE"));
				e.setShmc(rs.getString("SHMC"));
				e.setOpenWinUrl(makeUrl(e.getCd02002Fcid(),e.getShlx(),e.getNote()));
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
	public ArrayList<Pgv02084> LoadQMPG(Pgv02084 bean) throws Exception {
		ArrayList<Pgv02084> listResult = new ArrayList<Pgv02084>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT020842(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd02002Fcid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				Pgv02084 e = new Pgv02084();
				e.setBxsh(rs.getBoolean("BXSH"));
				e.setCd00002Pssd(rs.getString("CD_00002_PSSD"));
				e.setCd02002Fcid(rs.getString("CD_02020_FCID"));
				e.setShlx(rs.getInt("SHLX"));
				e.setShyy(rs.getString("SHYY"));
				e.setUpddate(rs.getDate("UPDDATE"));
				e.setNote(rs.getString("NOTE"));
				e.setShmc(rs.getString("SHMC"));
				e.setOpenWinUrl(makeUrl(e.getCd02002Fcid(),e.getShlx(),e.getNote()));
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
