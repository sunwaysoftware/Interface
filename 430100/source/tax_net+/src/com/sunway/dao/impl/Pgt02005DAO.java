package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.hibernate.Session;

import oracle.jdbc.OracleTypes;

import com.sunway.dao.IPgt02005DAO;
import com.sunway.vo.Pgv02005;

/**
 * 收益法国土状态
 * @author Light
 *
 */
public class Pgt02005DAO extends BaseDAO implements IPgt02005DAO{
	
	private final String FCID = "FCID";
	private final String ZRFMC = "ZRFMC";
	private final String ZRFZJHM = "ZRFZJHM";
	private final String SYPGZT = "SYPGZT";
	private final String SYDYCS = "SYDYCS";
	private final String SYPGCZR = "SYPGCZR";
	private final String SYDYCZR = "SYDYCZR";
	private final String PGJG = "PGJG";

	
	@Override
	public Pgv02005 LoadDetailZT(Pgv02005 bean) throws Exception {
		ArrayList<Pgv02005> resList = new ArrayList<Pgv02005>();
		Connection conn = null;
		CallableStatement call = null;
		ResultSet rs = null;
		Session session = null;
		try{
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETT020051(?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, bean.getCd02002Fcid());
			call.execute();
			rs = (ResultSet)call.getObject(1);
			while(null != rs && rs.next()){
				resList.add(SetDParameters(rs));
			}
		}catch(Exception e){
			throw e;
		}finally{
			getFree(rs, call, conn, session);
		}
		if(null != resList && resList.size() > 0){
			return resList.get(0);
		}else{
			return bean;
		}
	}
	
	/**
	 * 装载国土状态信息
	 * @return
	 * @throws Exception
	 */
	private Pgv02005 SetDParameters(ResultSet rs)throws Exception{
		Pgv02005 e = new Pgv02005();
		e.setZrfmc(rs.getString(ZRFMC));
		e.setZrfzjhm(rs.getString(ZRFZJHM));
		e.setSypgzt(rs.getInt(SYPGZT));
		e.setSydycs(rs.getInt(SYDYCS));
		e.setPgjg(rs.getDouble(PGJG));
		e.setCd02002Fcid(rs.getString(FCID));
		e.setSypgczr(rs.getString(SYPGCZR));
		e.setSydyczr(rs.getString(SYDYCZR));
		return e;
	}

}
