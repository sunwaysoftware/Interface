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

import com.sunway.dao.IPgt00334aDAO;
import com.sunway.vo.Pgt00334a;

/**
 *
 * 市场法参与评税的实例库
 * @author Andy.Gao
 *
 */
public class Pgt00334aDAO extends BaseDAO implements IPgt00334aDAO {

	private static final String cd00302Fcid = "CD_00302_FCID";		//评税的编码
	private static final String cdSlid = "CD_SLID";					//可比实例的编码
	private static final String cd00002Pssd = "CD_00002_PSSD";		//评税时点
	private static final String cd00053Qtxzid = "CD_00053_QTXZID";	//其它修正参数
	private static final String cd00053Qtxz = "CD_00053_QTXZ";		//其它修正系数
	private static final String cd00053Slqtxz = "CD_00053_SLQTXZ";	//实例其它修正系数
	private static final String upddate = "UPDDATE";				//更新日期
	private static final String cd00002Czr = "CD_00002_CZR";		//录入人
	private static final String qtxzNm = "QTXZNM";					//备注信息
	private static final String czr = "CZR";						//录入人
	private static final String cd00053Czlx = "CD_00053_CZLX";		//录入人

	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt00334aDAO#LoadAll(com.sunway.vo.Pgt00334a)
	 */
	
	@Override
	public ArrayList<Pgt00334a> LoadAll(Pgt00334a bean) throws Exception {
		ArrayList<Pgt00334a> listResult = new ArrayList<Pgt00334a>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT00334A(?,?,?)}");
			// 注冊輸出參數
			call.registerOutParameter(1, OracleTypes.CURSOR);
			// 传入输入参数
			call.setString(2, bean.getCd00302Fcid());
			call.setString(3, bean.getCdSlid());
			call.execute();
			// 返回数据集
			rs = (ResultSet) call.getObject(1);
			while (null != rs && rs.next()) {
				listResult.add(SetTParameters(rs));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
	/**
	 * 数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00334a SetTParameters(ResultSet rs) throws Exception {
		return new Pgt00334a(rs.getString(cd00302Fcid),
				 rs.getString(cdSlid),
				 rs.getString(cd00002Pssd),
				 rs.getString(cd00053Qtxzid),
				 rs.getDouble(cd00053Qtxz),
				 rs.getDouble(cd00053Slqtxz),
				 rs.getTimestamp(upddate),
				 rs.getString(cd00002Czr),
				 rs.getString(qtxzNm),
				 rs.getString(czr),
				 rs.getInt(cd00053Czlx));
	}
}
