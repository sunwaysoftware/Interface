package com.sunway.function.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Element;
import org.hibernate.Session;

import com.sunway.function.IBaseObject;
import com.sunway.jdbc.HibernateUtils;
import com.sunway.vo.FC002;
import com.sunway.vo.SysCmdRequest;

/**
 * 回写完税信息
 * @author Andy.Gao
 *
 */
public class WriFCXX extends BaseFunction implements IBaseObject{
	static Logger logger = LogManager.getLogger(WriFCXX.class);
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
		fcxx_w.setPgjg(new BigDecimal(element.elements().get(3).attributeValue("PGJG")));
//		fcxx_w.setQsjg(Double.valueOf(element.elements().get(4).attributeValue("QSJG")));
//		fcxx_w.setQtjg(Double.valueOf(element.elements().get(5).attributeValue("QTJG")));
//		fcxx_w.setOINSID(element.elements().get(6).attributeValue("OINSID"));
//		fcxx_w.setROOMID(element.elements().get(7).attributeValue("ROOMID"));
		fcxx_w.setLsh(element.elements().get(7).attributeValue("ROOMID"));
		fcxx_w.setBdcdyh(element.elements().get(8).attributeValue("OWNROOMID"));
//		fcxx_w.setJyjg(Double.valueOf(element.elements().get(9).attributeValue("HTZJ")));
//		fcxx_w.setPrice(Double.valueOf(element.elements().get(10).attributeValue("PGDJ")));
//		fcxx_w.setIsHX(1);
//		fcxx_w.setDfspid(element.elements().get(11).attributeValue("DFSPID"));
//		fcxx_w.setSsqy(element.elements().get(12).attributeValue("SSQY"));
		fcxx_w.setDjz_qs(new BigDecimal(element.elements().get(13).attributeValue("QS")));
		fcxx_w.setDjz_yys(new BigDecimal(element.elements().get(14).attributeValue("YYS")));
		fcxx_w.setDjz_cjs(new BigDecimal(element.elements().get(15).attributeValue("CJS")));
		fcxx_w.setDjz_dfjys(new BigDecimal(element.elements().get(16).attributeValue("DFJYS")));
		fcxx_w.setDjz_grsds(new BigDecimal(element.elements().get(17).attributeValue("GRSDS")));
		fcxx_w.setDjz_yhs(new BigDecimal(element.elements().get(18).attributeValue("YHS")));
		fcxx_w.setDjz_tdzzs(new BigDecimal(element.elements().get(19).attributeValue("TDZZS")));
		fcxx_w.setPgid(element.elements().get(20).attributeValue("PGID"));
		
		try{
			String dataID = generateID();
	        session = HibernateUtils.getSession();
	        session.beginTransaction(); 
	        logger.info("【指令流水表】Executing insert data status...");
	        SysCmdRequest cmdReq = new SysCmdRequest();
	        cmdReq.setCmd_code("300101");
	        cmdReq.setCreate_time(new Date());
	        cmdReq.setData_id(dataID);
	        cmdReq.setResolve_state(0);
	        cmdReq.setType(0);
	        session.save(cmdReq);
	        logger.info("【指令流水表】SYS_CMD_REQUEST table has been successfully saved.");	
			logger.info("【完税信息表】Saving Tax information data...");
			fcxx_w.setQqlsh(dataID);
			fcxx_w.setUpdatetime(new Date());
	        session.save(fcxx_w);
	        session.getTransaction().commit();			
			strResult = "OK";
			logger.info("【完税信息表】Tax information saved successfully.");
			errorMessage = "完税信息保存成功";
		}catch(Exception e){
			session.getTransaction().rollback();
			errorMessage = e.getMessage();
			logger.error("【完税信息表】Tax information saved failed.", e);
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
		return strResult;
	}

	@Override
	public String combineFunctionXML(List<?> list) {
		return null;
	}
}
