/**
 * 
 */
package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.struts2.json.JSONException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.SessionFactoryUtils;

import com.sunway.log.LogInfo;


/**
 * @author Andy.Gao 
 *
 */
public class BaseDAO {
	static Logger logger = LogManager.getLogger(BaseDAO.class);
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
			logger.error(e);
		}finally {
			rsSum = null;
		}
		try{
			if(null!=rs) 
				rs.close();
		}catch (Exception e) {
			logger.error(e);
		}finally {
			rs = null;
		}
		// 釋放CallableStatement
		try{
			if(null!=call) 
				call.close();
		}catch (Exception e) {
			logger.error(e);
		}finally {
			call = null;
		}
		// 釋放Connection
		try{
			if(null!=conn && !conn.isClosed())
				conn.close();
		}catch (Exception e) {
			logger.error(e);
		}finally {
			conn = null;
		}
		// 釋放Session
		try{
			if(null!=session) 
				session.close();
		}catch (Exception e) {
			logger.error(e);
		}finally {
			session = null;
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
			logger.error(e);
		}finally {
			rs = null;
		}
		// 釋放CallableStatement
		try{
			if(null!=call) 
				call.close();
		}catch (Exception e) {
			logger.error(e);
		}finally {
			call = null;
		}
		// 釋放Connection
		try{
			if(null!=conn && !conn.isClosed())
				conn.close();
		}catch (Exception e) {
			logger.error(e);
		}finally {
			conn = null;
		}
		// 釋放Session
		try{
			if(null!=session) 
				session.close();
		}catch (Exception e) {
			logger.error(e);
		}finally {
			session = null;
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
			logger.error(e);
		}finally {
			rs = null;
		}
		// 釋放CallableStatement
		try{
			if(null!=call) 
				call.close();
		}catch (Exception e) {
			logger.error(e);
		}finally {
			call = null;
		}
		// 釋放Connection
		try{
			if(null!=conn && !conn.isClosed())
				conn.close();
		}catch (Exception e) {
			logger.error(e);
		}finally {
			conn = null;
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
			logger.error(e);
		}finally {
			call = null;
		}
		// 釋放Connection
		try{
			if(null!=conn && !conn.isClosed())
				conn.close();
		}catch (Exception e) {
			logger.error(e);
		}finally {
			conn = null;
		}
		// 釋放Session
		try{
			if(null!=session) 
				session.close();
		}catch (Exception e) {
			logger.error(e);
		}finally {
			session = null;
		}		
	}	
	
	protected void execShowSQL(LogInfo loginfo) throws Exception {
		logger.info("{}", loginfo.showInfo());
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
	
}
