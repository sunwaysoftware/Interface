package com.sunway.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class ConnectionFactory {

	static Logger logger = Logger.getLogger(ConnectionFactory.class);
	
	/**
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		DataSource ds = null;
		Context context = null;
		Connection conn = null;
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup("fcDB");
			conn = ds.getConnection();
			logger.info("Database connectioned sucessed");
		} catch (NamingException e) {
			logger.error("Get dataSource failed");
			throw e;
		} catch (SQLException e) {
			logger.error("Database connection failed");
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return conn;
	}
	
}
