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

import com.sunway.dao.IPgt00358DAO;
import com.sunway.vo.Pgv00358;

/**
 *
 * 临时的实例库
 * @author Andy.Gao
 *
 */
public class Pgt00358DAO extends BaseDAO implements IPgt00358DAO {

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00358DAO#LoadAll(com.sunway.vo.Pgv00358)
	 */
	
	@Override
	public ArrayList<Pgv00358> LoadAll(Pgv00358 bean) throws Exception {
		ArrayList<Pgv00358> listResult = new ArrayList<Pgv00358>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			// 插入数据
			call = conn.prepareCall("{call PGSP_CZ_00332(?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.INTEGER);
			//傳入輸入參數
			call.setString(2, bean.getCd00302Fcid());
			call.setInt(3, bean.getPssdToJyjg());
			call.execute();
			call.close();
			// 数据查询
			call = conn.prepareCall("{call PGSP_GETALLT00358(?,?,?,?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//傳入輸入參數
			call.setInt(2, bean.getPageIndex());
			call.setInt(3, bean.getPageSize());
			call.setString(4, bean.getCd00302Fcid());
			call.setString(5, bean.getCd00002Pssd());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				listResult.add(SetVParameters(rs));
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
	protected Pgv00358 SetVParameters(ResultSet rs) throws Exception {

		String cd00302Fcid = "CD_00302_FCID";
		String cdSlid = "CD_SLID";
		String cd00002Pssd = "CD_00002_PSSD";
		String yxj = "YXJ";
		String zyxj = "ZYXJ";
		String xqnm = "XQNM";
		String jylx = "JYLX";
		String jzjg = "JZJG";
		String fwlx = "FWLX";
//		String fwcx = "FWCX";
//		String cgzk = "CGZK";
		String ywdt = "YWDT";
		String zlc = "ZLC";
		String szlc = "SZLC";
		String pfmjg = "PFMJG";
//		String cd00001Fwcx = "CD_00001_FWCX";
//		String cd00001Cgzk = "CD_00001_CGZK";
		String fwtdzl = "FWTDZL";
		String jysj = "JYSJ";
		String total = "TOTAL";
		String rid = "RID";
		return new Pgv00358(rs.getString(cd00302Fcid),
							rs.getString(cdSlid),
							rs.getString(cd00002Pssd),
							rs.getInt(yxj),
							rs.getInt(zyxj),
							rs.getString(xqnm),
							rs.getString(jylx),
							rs.getString(jzjg),
							rs.getString(fwlx),
							rs.getInt(ywdt),
							rs.getInt(zlc),
							rs.getInt(szlc),
							rs.getDouble(pfmjg),
							rs.getString(fwtdzl),
							rs.getDate(jysj),
							rs.getInt(total),
							rs.getInt(rid));
	}
}
