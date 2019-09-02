/**
 * 
 */
package com.sunway.function.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

import org.apache.log4j.Logger;

/**
 * @author amani
 *
 */
public class QueryBdcInfo extends BaseFunction {
	static Logger logger = Logger.getLogger(QueryBdcInfo.class);
	/**
	 * 记录请求应答记录
	 * @param req 请求JSON
	 * @param resp 应答JSON
	 * @throws Exception 
	 */
	public void insertLogData(String req, String resp, String czr) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		try {
			conn = getConnection();
			ps = conn.prepareStatement("INSERT INTO FC003 VALUES(?,?,?,?,sysdate)");
			ps.setString(1, uuid);
			ps.setString(2, req);
			ps.setString(3, resp);
			ps.setString(4, czr);
			ps.execute();
		} catch (Exception e) {
			logger.error("记录请求应答过程中报错", e);
		}finally {
			if(null != conn)
				conn.close();
		}

	}
	
	
	
	
	
	
	
	
	
}
