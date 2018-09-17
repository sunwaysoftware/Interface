package com.sunway.function.impl;

import java.sql.Connection;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;

import org.apache.log4j.Logger;
import org.dom4j.Element;

import com.sunway.function.IBaseObject;
import com.sunway.vo.PgtFCXX_W;
//import com.troyka.FC_SHW_WebServiceStub;
//import com.troyka.FC_SHW_WebServiceStub.SetSKXX;
//import com.troyka.FC_SHW_WebServiceStub.SetSKXXResponse;

/**
 * 回写完税信息
 * @author Administrator
 *
 */
public class WriFCXX extends BaseFunction implements IBaseObject{

	static Logger logger = Logger.getLogger(WriFCXX.class);
	
	private PgtFCXX_W fcxx_w;
	private String errorMessage;
	
	@Override
	public String executeFunction(Element element, Connection conn) {
		logger.info("1、解析完税信息报文...");
		ArrayList<String> fcxx_wList = new ArrayList<String>(); 
		String result = null;
		String sql = null;
		fcxx_w = new PgtFCXX_W();
		fcxx_w.setFcslh(element.elements().get(0).attributeValue("FCSLH"));
		fcxx_w.setFpid(element.elements().get(1).attributeValue("FPID"));
		fcxx_w.setSpid(element.elements().get(2).attributeValue("SPID"));
		fcxx_w.setPgjg(Double.valueOf(element.elements().get(3).attributeValue("PGJG")));
		fcxx_w.setQsjg(Double.valueOf(element.elements().get(4).attributeValue("QSJG")));
		fcxx_w.setQtjg(Double.valueOf(element.elements().get(5).attributeValue("QTJG")));
		fcxx_w.setOINSID(element.elements().get(6).attributeValue("OINSID"));
		fcxx_w.setROOMID(element.elements().get(7).attributeValue("ROOMID"));
		fcxx_w.setOwnroomid(element.elements().get(8).attributeValue("OWNROOMID"));
		fcxx_w.setJyjg(Double.valueOf(element.elements().get(9).attributeValue("HTZJ")));
		fcxx_w.setPrice(Double.valueOf(element.elements().get(10).attributeValue("PGDJ")));
		fcxx_w.setIsHX(1);
		fcxx_w.setDfspid(element.elements().get(11).attributeValue("DFSPID"));
		fcxx_w.setSsqy(element.elements().get(12).attributeValue("SSQY"));
		fcxx_w.setDjz_qs(Double.valueOf(element.elements().get(13).attributeValue("QS")));
		fcxx_w.setDjz_yys(Double.valueOf(element.elements().get(14).attributeValue("YYS")));
		fcxx_w.setDjz_cjs(Double.valueOf(element.elements().get(15).attributeValue("CJS")));
		fcxx_w.setDjz_dfjys(Double.valueOf(element.elements().get(16).attributeValue("DFJYS")));
		fcxx_w.setDjz_grsds(Double.valueOf(element.elements().get(17).attributeValue("GRSDS")));
		fcxx_w.setDjz_yhs(Double.valueOf(element.elements().get(18).attributeValue("YHS")));
		fcxx_w.setDjz_tdzzs(Double.valueOf(element.elements().get(19).attributeValue("TDZZS")));
		fcxx_w.setPgid(element.elements().get(20).attributeValue("PGID"));
		fcxx_w.setBz(element.elements().get(21).attributeValue("BZXX"));
		sql = String.format("call PG_INS_FC002('%s','%s','%f','%f','%f','%f','%f','%f','%f','%s','%s','%s','%s','%f','%s')",
				fcxx_w.getFcslh(),fcxx_w.getROOMID(),fcxx_w.getDjz_qs(),fcxx_w.getDjz_yys(),fcxx_w.getDjz_cjs(),
				fcxx_w.getDjz_dfjys(),fcxx_w.getDjz_grsds(),fcxx_w.getDjz_yhs(),fcxx_w.getDjz_tdzzs(),
				fcxx_w.getFpid(), fcxx_w.getSpid(), "",fcxx_w.getPgid(),fcxx_w.getPgjg(),fcxx_w.getBz());
		try{
			logger.info("2、存储完税信息...");
			executeFunction(sql, conn);
//			logger.info("3、将完税信息组成报文传递给房产部门...");
//			sendFcXML(fcxx_w);
			logger.info("4、完税信息回写成功");
			fcxx_wList.add("OK");
			result = combineFunctionXML(fcxx_wList);
		}catch(Exception e){
			logger.error(e);
			errorMessage = e.getMessage();
			fcxx_wList.add("NO");
			result = combineFunctionXML(fcxx_wList);
			logger.info("4、完税信息回写失败");
			return result;
		}
		
		return result;
	}
	
	@Override
	public String combineFunctionXML(ArrayList<?> list) {
		String result = String.format("<Request Name='WriFCXX'>" +
					"<Results>" +
						"<Result>" +
							"<Rows>" +
								"<Row RESULT='%s' errorMessage='%s' />" +
							"</Rows>" +
						"</Result>" +
					 "</Results>" +
				   "</Request>",list.get(0), errorMessage);
		
		return result;
	}

	/**
	 * 将完税信息组成XML后，传入房产接口
	 * @param b
	 * @throws Exception 
	 */
//	private void sendFcXML(PgtFCXX_W b) throws Exception {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		FC_SHW_WebServiceStub fc = null;
//		SetSKXXResponse skxxResponse = null;
//		fc = new FC_SHW_WebServiceStub();
//		SetSKXX skxx = new SetSKXX();
//		StringBuffer strXml = new StringBuffer();
//		strXml.append("<?xml version='1.0' encoding='UTF-8'?>");
//		strXml.append("<FCPG Name='SetSKXX'>");
//		strXml.append(" <ROW>");
//		strXml.append("  <FCSLH>"+ b.getFcslh() +"</FCSLH>");
//		strXml.append("  <FCID>"+ b.getROOMID() +"</FCID>");
//		strXml.append("  <DJZ_QS>"+ b.getDjz_qs() +"</DJZ_QS>");
//		strXml.append("  <DJZ_YYS>"+ b.getDjz_yys() +"</DJZ_YYS>");
//		strXml.append("  <DJZ_CJS>"+ b.getDjz_cjs() +"</DJZ_CJS>");
//		strXml.append("  <DJZ_DFJYS>"+ b.getDjz_dfjys() +"</DJZ_DFJYS>");
//		strXml.append("  <DJZ_GRSDS>"+ b.getDjz_grsds() +"</DJZ_GRSDS>");
//		strXml.append("  <DJZ_YHS>"+ b.getDjz_yhs() +"</DJZ_YHS>");
//		strXml.append("  <DJZ_TDZZS>"+ b.getDjz_tdzzs() +"</DJZ_TDZZS>");
//		// 因金三系统不提供发票号信息，所有无法传递给房产部门
//		strXml.append("  <FPHM>"+ b.getFpid() +" </FPHM>");
//		strXml.append("  <QSSPHM>"+ b.getSpid() +" </QSSPHM>");
//		strXml.append("  <DFGSSPHM>"+ b.getDfspid() +" </DFGSSPHM>");
//		//---------------------
//		strXml.append("  <UPDATETIME>"+ sdf.format(new Date()) +"</UPDATETIME>");
//		strXml.append("  <PGJG>"+ b.getPgjg() +"</PGJG>");
//		strXml.append("  <BZ>"+ b.getBz() +"</BZ>");			
//		strXml.append(" </ROW>");
//		strXml.append("</FCPG>");
//		logger.info(strXml);
//		skxx.setReqxml(strXml.toString());			
//		skxxResponse = fc.setSKXX(skxx);
//		logger.info("完税报文发送完毕");
//		logger.info(skxxResponse.getSetSKXXResult().getExtraElement());		
//	}

}
