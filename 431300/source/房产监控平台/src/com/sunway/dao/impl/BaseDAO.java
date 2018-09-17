/**
 * 
 */
package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

/**
 * @author Andy.Gao 
 *
 */
public class BaseDAO {

	private SessionFactory sessionFactory;
	
	public BaseDAO(){}
   
	/**
	 * 獲取 Session
	 * @return
	 */
	public Session getSession() throws Exception {
		Session session = null;
		try{
			session = sessionFactory.openSession();
		}catch(Exception e){
			throw e;
		}
		return session;
	}

	/**
	 * 獲取 Connection
	 * @return
	 */
	public Connection getConnection() throws Exception {
		Connection conn = null;
		try{
			conn = SessionFactoryUtils.getDataSource(getSessionFactory()).getConnection();
		}catch(Exception e){
			throw e;
		}
		return conn;
	}	
	
	/**
	 * 釋放數據庫資源
	 * @param rs 釋放ResultSet對象
	 * @param call 釋放CallableStatement對象
	 * @param conn 釋放Connection對象
	 * @param session 釋放Session對象
	 * @throws Exception
	 */
	protected void getFree(ResultSet rsSum, ResultSet rs, CallableStatement call, Connection conn, Session session) throws Exception {
		// 釋放ResultSet
		try{
			if(null!=rsSum) 
				rsSum.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			rsSum = null;
		}
		try{
			if(null!=rs) 
				rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			rs = null;
		}
		// 釋放CallableStatement
		try{
			if(null!=call) 
				call.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			call = null;
		}
		// 釋放Connection
		try{
			if(null!=conn && !conn.isClosed())
				conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn = null;
		}
		// 釋放Session
		try{
			if(null!=session) 
				session.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session = null;
		}
	}
	/**
	 * 釋放數據庫資源
	 * @param call 釋放CallableStatement對象
	 * @param conn 釋放Connection對象
	 * @param session 釋放Session對象
	 * @throws Exception
	 */
	protected void getFree(CallableStatement call, Connection conn) throws Exception {
		// 釋放CallableStatement
		try{
			if(null!=call) 
				call.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			call = null;
		}
		// 釋放Connection
		try{
			if(null!=conn && !conn.isClosed())
				conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn = null;
		}
			
	}
	
	/**
	 * 釋放數據庫資源
	 * @param rs 釋放ResultSet對象
	 * @param call 釋放CallableStatement對象
	 * @param conn 釋放Connection對象
	 * @param session 釋放Session對象
	 * @throws Exception
	 */
	protected void getFree(ResultSet rs, CallableStatement call, Connection conn) throws Exception {
		// 釋放ResultSet
		try{
			if(null!=rs) 
				rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			rs = null;
		}
		// 釋放CallableStatement
		try{
			if(null!=call) 
				call.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			call = null;
		}
		// 釋放Connection
		try{
			if(null!=conn && !conn.isClosed())
				conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn = null;
		}
		
	}
	/**
	 * 釋放數據庫資源
	 * @param rs 釋放ResultSet對象
	 * @param call 釋放CallableStatement對象
	 * @param conn 釋放Connection對象
	 * @param session 釋放Session對象
	 * @throws Exception
	 */
	protected void getFree(ResultSet rs, CallableStatement call, Connection conn, Session session) throws Exception {
		// 釋放ResultSet
		try{
			if(null!=rs) 
				rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			rs = null;
		}
		// 釋放CallableStatement
		try{
			if(null!=call) 
				call.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			call = null;
		}
		// 釋放Connection
		try{
			if(null!=conn && !conn.isClosed())
				conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn = null;
		}
		// 釋放Session
		try{
			if(null!=session) 
				session.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session = null;
		}
	}
	
	/**
	 * 釋放數據庫資源
	 * @param call 釋放CallableStatement對象
	 * @param conn 釋放Connection對象
	 * @param session 釋放Session對象
	 * @throws Exception
	 */
	protected void getFree(CallableStatement call, Connection conn, Session session) throws Exception {
		// 釋放CallableStatement
		try{
			if(null!=call) 
				call.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			call = null;
		}
		// 釋放Connection
		try{
			if(null!=conn && !conn.isClosed())
				conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn = null;
		}
		// 釋放Session
		try{
			if(null!=session) 
				session.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session = null;
		}		
	}
	
	/***************************** set and get ***********************************/
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * 填写导出日志
	 * @param cd00001Ssgx
	 * @param tableName
	 * @param cd00002Czr
	 * @param note
	 * @throws Exception
	 */
	protected void WriteLogExp(String cd00001Ssgx,String tableName,String cd00002Czr,String note)throws Exception{
		Session session = null;
		Connection conn = null;
		CallableStatement call = null;
		Transaction tran = null;
		@SuppressWarnings("unused")
		String result = null;
		try{
			session = getSession();
			tran = session.beginTransaction();
			conn = getConnection();
			call = conn.prepareCall("{?=call fn_writelogexp(?,?,?,?)}");
			call.registerOutParameter(1, OracleTypes.VARCHAR);
			call.setString(2, cd00001Ssgx);
			call.setString(3, tableName);
			call.setString(4, cd00002Czr);
			call.setString(5, note);
			call.execute();
			tran.commit();
		    result = call.getString(1);
		}catch(Exception e){
			tran.rollback();
			throw e;
		}finally{
			getFree(call, conn, session);
		}
	}
	
}
