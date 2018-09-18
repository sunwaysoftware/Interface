/**
 * 
 */
package com.sunway.function.impl;

import java.sql.CallableStatement;
import java.sql.Connection;

import org.apache.log4j.Logger;

import com.sunway.vo.PgtFCXX;

/**
 * 
 * 提供外部系统交换
 * @author amani
 *
 */
public class WbjhDAO extends BaseFunction {

	static Logger logger = Logger.getLogger(WbjhDAO.class);
	
	public String execInsData(PgtFCXX bean){
		StringBuilder strResult = new StringBuilder("<?xml version='1.0' encoding='UTF-8'?><FCPG><MESSAGE>");
		Integer iResult = 0;
		String strMsg = null;
		Connection conn = null;
		CallableStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareCall("{call PG_INS_FC001(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, bean.getFcslh());
			stmt.setString(2, bean.getSsgx());
			stmt.setString(3, bean.getYfczh());
			stmt.setString(4, bean.getZrfmc());
			stmt.setString(5, bean.getZrfsfid());
			stmt.setString(6, bean.getZrfsflx());
			stmt.setString(7, bean.getZrfTel());
			stmt.setString(8, bean.getCsfmc());
			stmt.setString(9, bean.getCsfsfid());
			stmt.setString(10, bean.getCsfsflx());
			stmt.setString(11, bean.getCsfTel());
			stmt.setString(12, bean.getClh());
			stmt.setString(13, bean.getSjyt());
			stmt.setString(14, bean.getLfdz());
			stmt.setString(15, bean.getDyfh());
			stmt.setDouble(16, Double.valueOf(bean.getZlc()));
			stmt.setDouble(17, Double.valueOf(bean.getSzlc()));
			stmt.setString(18, bean.getJzjg());
			stmt.setString(19, bean.getFwlx());
			stmt.setString(20, bean.getJylx());
			stmt.setDouble(21, Double.valueOf(bean.getJzmj()));
			stmt.setDouble(22, Double.valueOf(bean.getHtzj()));
			stmt.setString(23, bean.getFzrq());
			stmt.setString(24, bean.getJcnf());
			stmt.setString(25, bean.getJysj());
			stmt.setString(26, "");
			stmt.setString(27, bean.getCx());
			stmt.setString(28, bean.getDf());
			stmt.setString(29, "");
			stmt.setString(30, "");
			stmt.setDouble(31, Double.valueOf(bean.getCg()));
			stmt.setString(32, bean.getXqdm());
			stmt.setString(33, bean.getQswsrq());
			stmt.setDouble(34, Double.valueOf(bean.getQswsjs()));
			stmt.execute();
			iResult = 1;
			strMsg="存量房数据成功登入";
		} catch (Exception e) {
			iResult = 0;
			strMsg="存量房数据登入失败：" + e.getMessage();
			logger.error(e.getMessage());
		}finally {
			try{
	            if (null != stmt) {  
					stmt.close();
	            }
	            if (null != conn) {
	            	conn.close();  
				}
			}catch(Exception e){
				logger.error(e.getMessage());
			}
			strResult.append("<FLAG>");
			strResult.append(iResult);
			strResult.append("</FLAG>");
			strResult.append("<CONTENT>");
			strResult.append(strMsg);
			strResult.append("</CONTENT>");
			strResult.append("</MESSAGE></FCPG>");
		}
		return strResult.toString();
	}
	
}
