package com.sunway.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConnectionFactory {

	static Log log = LogFactory.getLog(ConnectionFactory.class);

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
			log.info("Database connectioned sucessed");
		} catch (NamingException e) {
			log.error("Get dataSource failed");
			throw e;
		} catch (SQLException e) {
			log.error("Database connection failed");
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		return conn;
	}
	
}
