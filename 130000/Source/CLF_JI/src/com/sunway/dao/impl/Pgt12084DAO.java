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

import com.sunway.dao.IPgt12084DAO;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.vo.Pgv12084;

/**
 * 
 * 成本，收益审核和评税未过原因说明
 * @author Andy.Gao
 *
 */
public class Pgt12084DAO extends BaseDAO implements IPgt12084DAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt12084DAO#LoadAll(com.sunway.vo.Pgv12084)
	 */
	
	@Override
	public ArrayList<Pgv12084> LoadAll(Pgv12084 bean) throws Exception {
		ArrayList<Pgv12084> listResult = new ArrayList<Pgv12084>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT12084(?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setString(2, bean.getCd12004Mxid());
			call.setString(3, bean.getCd00002Pssd());
			call.setInt(4, bean.getShlx());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				Pgv12084 e = new Pgv12084();
				e.setBxsh(rs.getBoolean("BXSH"));
				e.setCd00002Pssd(rs.getString("CD_00002_PSSD"));
				e.setCd12004Mxid(rs.getString("CD_12004_MXID"));
				e.setShlx(rs.getInt("SHLX"));
				e.setShyy(rs.getString("SHYY"));
				e.setUpddate(rs.getDate("UPDDATE"));
				e.setNote(rs.getString("NOTE"));
				e.setShmc(rs.getString("SHMC"));
				e.setOpenWinUrl(makeUrl(e.getCd12004Mxid(),e.getShlx(),e.getNote()));
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
		case 1:	// 12002
			resultValue = "sjcj/ADDT12002.action?ACT=U";
			break;
		case 2:	// 12002
			resultValue = "sjcj/ADDT12002.action?ACT=U";
			break;
		case 3:	// 12003
			resultValue = "sjcj/ADDT12003.action?ACT=U";
			break;
		case 4:	// 12003
			resultValue = "sjcj/ADDT12003.action?ACT=U";
			break;
		case 5:	// 12004
			resultValue = "sjcj/ADDT12004.action?ACT=U";
			break;
		case 6:	// 12003
			resultValue = "sjcj/ADDT12003.action?ACT=U";
			break;
		case 7:	// 12001
			resultValue = "sjcj/ADDT12001.action?ACT=U";
			break;
		case 8:	// 12002
			resultValue = "sjcj/ADDT12002.action?ACT=U";
			break;
		case 9: // 土地面积参数审核
			resultValue = "xtwh/ADDT12083.action?ACT=U";
			break;
		case 10: // 平方米单价参数审核
			resultValue = "xtwh/ADDT12081.action?ACT=U";
			break;
		case 11: // 个别容积率参数审核
			resultValue = "xtwh/ADDT12082.action?ACT=U";
			break;
		case 31:// 12003
			resultValue = "sjcj/ADDT12003.action?ACT=U";
			break;
		case 32:// 12002
			resultValue = "sjcj/ADDT12002.action?ACT=U";
			break;
		case 33:// 12052
			resultValue = "xtwh/ADDT12052.action?ACT=U";
			break;
		case 34:// 10051
			resultValue = "xtwh/ADDT10051.action?ACT=U";
			break;
		case 35:// 10053
			resultValue = "xtwh/ADDT10053.action?ACT=U";
			break;
		case 36:// 10055
			resultValue = "xtwh/ADDT10055.action?ACT=U";
			break;
		case 37:// 10056
			resultValue = "xtwh/ADDT10056.action?ACT=U";
			break;
		case 38:// 10052
			resultValue = "xtwh/ADDT10052.action?ACT=U";
			break;
		case 39:// 10057
			resultValue = "xtwh/ADDT10057.action?ACT=U";
			break;
		case 61:// 02059
			resultValue = "xtwh/ADDT02059.action?ACT=U";
			break;
		case 62:// 02057
			resultValue = "xtwh/ADDT02057.action?ACT=U";
			break;
		case 63:// 12052
			resultValue = "xtwh/ADDT12052.action?ACT=U";
			break;
		case 64:// 02053
			resultValue = "xtwh/ADDT02053.action?ACT=U";
			break;
		case 66:// 02055
			resultValue = "xtwh/ADDT02055.action?ACT=U";
			break;
		case 67:// 02058
			resultValue = "xtwh/ADDT02058.action?ACT=U";
			break;
		case 68:// 12004
			resultValue = "sjcj/ADDT12004.action?ACT=U";
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
		return Common.checkNull(resultValue) ;
	}
	
}
