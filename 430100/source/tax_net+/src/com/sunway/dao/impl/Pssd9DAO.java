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

import com.sunway.dao.IPssd9DAO;
import com.sunway.vo.Pssd;

/**
 * @author lEE
 *
 */
public class Pssd9DAO extends BaseDAO implements IPssd9DAO {

	/**
	 * 通用类，读取参数复制功能所需评税时点
	 * 
	 */
	
	public ArrayList<Pssd> LoadAllPssd(Pssd pssd) throws Exception {
		ArrayList<Pssd> listResult = new ArrayList<Pssd>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT"+pssd.getUrl()+"(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setString(2, pssd.getSzqy());
			call.setString(3, pssd.getCurrentPssd());
			call.execute();
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				Pssd bean = new Pssd();
				bean.setPssds(rs.getString("CD_00002_PSSD"));
				listResult.add(bean);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}

	
	/**
	 * 通用类，读取参数复制功能所需评税时点
	 * 
	 */
	
	public ArrayList<Pssd> LoadAllPssdNoSzqy(Pssd pssd) throws Exception {
		ArrayList<Pssd> listResult = new ArrayList<Pssd>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT"+pssd.getUrl()+"(?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			//注册输入参数
			call.setString(2, pssd.getCurrentPssd());
			call.execute();
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				Pssd bean = new Pssd();
				bean.setPssds(rs.getString("CD_00002_PSSD"));
				listResult.add(bean);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
}
