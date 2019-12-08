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

import com.sunway.dao.IPgt02032DAO;
import com.sunway.vo.Pgt02032;

/**
 * 
 * 收益法个案评税结果表
 * @author Andy.Gao
 *
 */
public class Pgt02032DAO extends BaseDAO implements IPgt02032DAO {

	private static final String cd12004Mxid = "CD_12004_MXID";	//房产明细编码
	private static final String cd00002Pssd = "CD_00002_PSSD";	//评税时点
	private static final String gbpgjg = "GBPGJG";				//个案评税结果
	private static final String gbxzxs = "GBXZXS";				//修正值 必须要大于0
	private static final String upddate = "UPDDATE";			//更改时间
	private static final String cd00002Czr = "CD_00002_CZR";	//操作人字段
	private static final String note = "NOTE";					//备注信息
	private static final String pgjg = "PGJG";					//評估值
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.IPgt02032DAO#LoadByPrimaryKey(com.sunway.vo.Pgt02032)
	 */
	
	@Override
	public Pgt02032 LoadByPrimaryKey(Pgt02032 bean) throws Exception {
		ArrayList<Pgt02032> listResult = new ArrayList<Pgt02032>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT02032(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//传入输入参数
			call.setString(2, bean.getCd00002Pssd());
			call.setString(3, bean.getCd12004Mxid());
			call.execute();
			//返回数据集
			rs = (ResultSet)call.getObject(1);
			while (null!=rs && rs.next()) {
				listResult.add(SetTParameters(rs));			
			}
		} catch (Exception e) {
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		if(listResult!=null && listResult.size()>0)
			return listResult.get(0);
		else
			return null;
	}

	/**
	 * Table数据转存
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt02032 SetTParameters(ResultSet rs) throws Exception {
		return new Pgt02032(rs.getString(cd12004Mxid),
							rs.getString(cd00002Pssd),
							rs.getDouble(gbpgjg),
							rs.getDouble(gbxzxs),
							rs.getTimestamp(upddate),
							rs.getString(cd00002Czr),
							rs.getString(note),
							rs.getDouble(pgjg));
	}
	
}
