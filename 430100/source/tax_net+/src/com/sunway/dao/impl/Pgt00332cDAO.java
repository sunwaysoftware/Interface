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
import com.sunway.dao.IPgt00332cDAO;
import com.sunway.vo.Pgt00332c;

/**
 * @author Andy.Gao
 *
 */
public class Pgt00332cDAO extends BaseDAO implements IPgt00332cDAO {

	private static final String cd00302Fcid =  "CD_00302_FCID";
	private static final String cd00001Rootid = "CD_00001_ROOTID";
	private static final String rootnm = "ROOTNM";
	private static final String infonm =  "INFONM";
	private static final String xzxs =  "XZXS";
	private static final String czlx =  "CZLX";

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00332cDAO#LoadAll(com.sunway.vo.Pgt00332c)
	 */
	
	@Override
	public ArrayList<Pgt00332c> LoadAll(Pgt00332c bean) throws Exception {
		ArrayList<Pgt00332c> listResult = new ArrayList<Pgt00332c>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00332c(?,?)}");
			//注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd00302Fcid());
			call.execute();
			//返回數據集
			rs = (ResultSet) call.getObject(1);
			while(null!=rs && rs.next()){
				Pgt00332c e = new Pgt00332c();
				e.setCd00302Fcid(rs.getString(cd00302Fcid));
				e.setCd00001Rootid(rs.getString(cd00001Rootid));
				e.setRootnm(rs.getString(rootnm));
				e.setInfonm(rs.getString(infonm));
				e.setXzxs(rs.getInt(xzxs));
				e.setCzlx(rs.getInt(czlx));
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
