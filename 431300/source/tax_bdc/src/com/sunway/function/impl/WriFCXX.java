package com.sunway.function.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Element;
import org.hibernate.Session;

import com.sunway.function.IBaseObject;
import com.sunway.jdbc.HibernateUtils;
import com.sunway.vo.FC002;

/**
 * 回写完税信息
 * @author Andy.Gao
 *
 */
public class WriFCXX extends BaseFunction implements IBaseObject{
	static Logger logger = Logger.getLogger(WriFCXX.class);
	private FC002 fcxx_w;
	private String errorMessage;
	
	@Override
	public String executeFunction(Element element) {
		String strResult = "NO";
		Session session = null;
		fcxx_w = new FC002();
//		fcxx_w.setFcslh(element.elements().get(0).attributeValue("FCSLH"));
//		fcxx_w.setFpid(element.elements().get(1).attributeValue("FPID"));
//		fcxx_w.setSpid(element.elements().get(2).attributeValue("SPID"));
		fcxx_w.setPgjg(Double.valueOf(element.elements().get(3).attributeValue("PGJG")));
//		fcxx_w.setQsjg(Double.valueOf(element.elements().get(4).attributeValue("QSJG")));
//		fcxx_w.setQtjg(Double.valueOf(element.elements().get(5).attributeValue("QTJG")));
//		fcxx_w.setOINSID(element.elements().get(6).attributeValue("OINSID"));
//		fcxx_w.setROOMID(element.elements().get(7).attributeValue("ROOMID"));
		fcxx_w.setLsh(element.elements().get(8).attributeValue("OWNROOMID"));
//		fcxx_w.setJyjg(Double.valueOf(element.elements().get(9).attributeValue("HTZJ")));
//		fcxx_w.setPrice(Double.valueOf(element.elements().get(10).attributeValue("PGDJ")));
//		fcxx_w.setIsHX(1);
//		fcxx_w.setDfspid(element.elements().get(11).attributeValue("DFSPID"));
//		fcxx_w.setSsqy(element.elements().get(12).attributeValue("SSQY"));
		fcxx_w.setDjz_qs(Double.valueOf(element.elements().get(13).attributeValue("QS")));
		fcxx_w.setDjz_yys(Double.valueOf(element.elements().get(14).attributeValue("YYS")));
		fcxx_w.setDjz_cjs(Double.valueOf(element.elements().get(15).attributeValue("CJS")));
		fcxx_w.setDjz_dfjys(Double.valueOf(element.elements().get(16).attributeValue("DFJYS")));
		fcxx_w.setDjz_grsds(Double.valueOf(element.elements().get(17).attributeValue("GRSDS")));
		fcxx_w.setDjz_yhs(Double.valueOf(element.elements().get(18).attributeValue("YHS")));
		fcxx_w.setDjz_tdzzs(Double.valueOf(element.elements().get(19).attributeValue("TDZZS")));
		fcxx_w.setPgid(element.elements().get(20).attributeValue("PGID"));
		
//		sql = String.format("call PG_INS_FC002('%s','%s','%f','%f','%f','%f','%f','%f','%f','%s','%s','%s','%s','%f')",
//				fcxx_w.getFcslh(),fcxx_w.getSsqy(),fcxx_w.getDjz_qs(),fcxx_w.getDjz_yys(),fcxx_w.getDjz_cjs(),
//				fcxx_w.getDjz_dfjys(),fcxx_w.getDjz_grsds(),fcxx_w.getDjz_yhs(),fcxx_w.getDjz_tdzzs(),
//				fcxx_w.getFpid(), fcxx_w.getSpid(),fcxx_w.getDfspid(),fcxx_w.getPgid(),fcxx_w.getPgjg());
		try{
	        session = HibernateUtils.getSession();
	        session.beginTransaction(); 
	        session.save(fcxx_w);
	        session.getTransaction().commit();			
			strResult = "OK";
			logger.info("Tax information saved successfully.");
		}catch(Exception e){
			session.getTransaction().rollback();
			logger.error(e);
			errorMessage = e.getMessage();
		} finally {
			session.close();
			strResult = String.format("<Request Name='WriFCXX'>" +
					"<Results>" +
						"<Result>" +
							"<Rows>" +
								"<Row RESULT='%s' errorMessage='%s' />" +
							"</Rows>" +
						"</Result>" +
					 "</Results>" +
				   "</Request>", strResult, errorMessage);	
		}
		logger.info("Response XML:\n" + strResult);
		return strResult;
	}

	@Override
	public String combineFunctionXML(List<?> list) {
		return null;
	}
}
