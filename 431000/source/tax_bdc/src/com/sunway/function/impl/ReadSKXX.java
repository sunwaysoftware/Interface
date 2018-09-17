/**
 * 
 */
package com.sunway.function.impl;

import java.sql.Connection;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;

import org.apache.log4j.Logger;

import com.sunway.vo.PgtFCXX_W;

/**
 * @author Amami
 *
 */
public class ReadSKXX extends BaseFunction {

	private boolean errorSign = true;
	private String errorMessage = "未查到完税信息";
	
	static Logger logger = Logger.getLogger(ReadSKXX.class);
	
	/* (non-Javadoc)
	 * @see com.sunway.function.IBaseObject#executeFunction(org.dom4j.Element, java.sql.Connection)
	 */
	public String executeFunction(PgtFCXX_W bean) {
		ArrayList<PgtFCXX_W> fcxx_wList = new ArrayList<PgtFCXX_W>(); 
		Connection conn = null;
		CachedRowSet ocrs = null;
		String result = null;
		String sql = null;
		sql = String.format("SELECT * FROM FC002 WHERE SLID = '%s'", bean.getFcslh());
		try {
			conn = getConnection();
			ocrs = queryFunction(sql, conn);
			while (null != ocrs && ocrs.next()) {
				fcxx_wList.add(setFCXXParameters(ocrs));
				errorSign = false;
			}
			result = combineFunctionXML(fcxx_wList);
			// 关闭数据库资源
			getFreeORS(ocrs);
			conn.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
			errorSign = true;
			errorMessage = e.getMessage();
			result = combineFunctionXML(fcxx_wList);
		} finally {
			ocrs = null;
			conn = null;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.sunway.function.IBaseObject#combineFunctionXML(java.util.ArrayList)
	 */
	public String combineFunctionXML(ArrayList<?> list) {
		StringBuffer strXml = new StringBuffer();
		strXml.append("<?xml version='1.0' encoding='UTF-8'?>");
		strXml.append("<FCPG>");
		strXml.append("  <MESSAGE>");
		if (errorSign) {
			strXml.append("    <FLAG>0</FLAG>");
			strXml.append("    <CONTENT>"+ errorMessage +"</CONTENT>");	
		} else {
			strXml.append("    <FLAG>1</FLAG>");
			strXml.append("    <CONTENT>成功完税</CONTENT>");		
		}
		strXml.append("  </MESSAGE><DATAS>");
		for (Object obj : list) {
			PgtFCXX_W b = (PgtFCXX_W)obj;
			strXml.append(" <DATA>");
			strXml.append("  <JID>"+ b.getFcslh() +"</JID>");
			strXml.append("  <FBDCDYH>"+ b.getSsqy() +"</FBDCDYH>");
			strXml.append("<SSQY></SSQY><DSRMC></DSRMC><JSMJ></JSMJ><JSJG></JSJG><ZRF_ID></ZRF_ID>");
			//strXml.append("  <PGID>"+ b.getSsqy() +"</PGID>");
			strXml.append("  <DJZ_QS>"+ b.getDjz_qs() +"</DJZ_QS>");
			strXml.append("  <DJZ_YYS>"+ b.getDjz_yys() +"</DJZ_YYS>");
			strXml.append("  <DJZ_CJS>"+ b.getDjz_cjs() +"</DJZ_CJS>");
			strXml.append("  <DJZ_DFJYS>"+ b.getDjz_dfjys() +"</DJZ_DFJYS>");
			strXml.append("  <DJZ_GRSDS>"+ b.getDjz_grsds() +"</DJZ_GRSDS>");
			strXml.append("  <DJZ_YHS>"+ b.getDjz_yhs() +"</DJZ_YHS>");
			strXml.append("  <DJZ_TDZZS>"+ b.getDjz_tdzzs() +"</DJZ_TDZZS>");
			// 因金三系统不提供发票号信息，所有无法传递给国土部门
			strXml.append("  <FPHM>"+ b.getFpid() +" </FPHM>");
			strXml.append("  <QSSPHM>"+ b.getSpid() +" </QSSPHM>");
			strXml.append("  <DFGSSPHM>"+ b.getDfspid() +" </DFGSSPHM>");
			//---------------------------
			strXml.append("  <UPDATETIME>"+ b.getUpdtime() +"</UPDATETIME>");
			strXml.append("  <PGID>"+ b.getPgid() +"</PGID>");
			//strXml.append("  <PGJG>"+ b.getPgjg() +"</PGJG>");
			//strXml.append("  <BZ>"+ b.getBz() +"</BZ>");
			strXml.append(" </DATA>");
		}
		strXml.append("</DATAS></FCPG>");	
		logger.info("【完税报文】"+strXml);
		return strXml.toString();
	}

	/**
	 * 装载数据
	 * 
	 * @param ocrs
	 * @return
	 * @throws Exception
	 */
	protected PgtFCXX_W setFCXXParameters(CachedRowSet ocrs) throws Exception {
		PgtFCXX_W e = new PgtFCXX_W();
		e.setFcslh(ocrs.getString("SLID"));
		e.setSsqy(ocrs.getString("SSQY"));
		e.setDjz_qs(ocrs.getDouble("DJZ_QS"));
		e.setDjz_yys(ocrs.getDouble("DJZ_YYS"));
		e.setDjz_cjs(ocrs.getDouble("DJZ_CJS"));
		e.setDjz_dfjys(ocrs.getDouble("DJZ_DFJYS"));
		e.setDjz_grsds(ocrs.getDouble("DJZ_GRSDS"));
		e.setDjz_yhs(ocrs.getDouble("DJZ_YHS"));
		e.setDjz_tdzzs(ocrs.getDouble("DJZ_TDZZS"));
		e.setFpid(ocrs.getString("FPHM"));
		e.setSpid(ocrs.getString("QSSPHM"));
		e.setDfspid(ocrs.getString("DFGSSPHM"));
		e.setPgid(ocrs.getString("PGID"));
		e.setUpdtime(ocrs.getDate("UPDATETIME"));
		e.setPgjg(ocrs.getDouble("PGJG"));
		e.setBz(ocrs.getString("NOTE"));
		e.setClh(ocrs.getString("BDCDYH"));
		return e;
	}
	
}
