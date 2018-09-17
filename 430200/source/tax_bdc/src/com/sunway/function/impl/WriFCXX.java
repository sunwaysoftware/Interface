package com.sunway.function.impl;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.dom4j.Element;
import org.hibernate.Session;

import com.sunway.function.IBaseObject;
import com.sunway.jdbc.HibernateBdcUtils;
import com.sunway.vo.FC001_PK;
import com.sunway.vo.FC002;
import com.sunway.vo.PgtFCXX_W;


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
		fcxx_w.setFcslh(((Element)element.elements().get(0)).attributeValue("FCSLH"));
		fcxx_w.setFpid(((Element)element.elements().get(1)).attributeValue("FPID"));
		fcxx_w.setSpid(((Element)element.elements().get(2)).attributeValue("SPID"));
		fcxx_w.setPgjg(Double.valueOf(((Element)element.elements().get(3)).attributeValue("PGJG")));
		fcxx_w.setQsjg(Double.valueOf(((Element)element.elements().get(4)).attributeValue("QSJG")));
		fcxx_w.setQtjg(Double.valueOf(((Element)element.elements().get(5)).attributeValue("QTJG")));
		fcxx_w.setOINSID(((Element)element.elements().get(6)).attributeValue("OINSID"));
		fcxx_w.setROOMID(((Element)element.elements().get(7)).attributeValue("ROOMID"));
		fcxx_w.setOwnroomid(((Element)element.elements().get(8)).attributeValue("OWNROOMID"));
		fcxx_w.setJyjg(Double.valueOf(((Element)element.elements().get(9)).attributeValue("HTZJ")));
		fcxx_w.setPrice(Double.valueOf(((Element)element.elements().get(10)).attributeValue("PGDJ")));
		fcxx_w.setIsHX(1);
		fcxx_w.setDfspid(((Element)element.elements().get(11)).attributeValue("DFSPID"));
		fcxx_w.setSsqy(((Element)element.elements().get(12)).attributeValue("SSQY"));
		fcxx_w.setDjz_qs(Double.valueOf(((Element)element.elements().get(13)).attributeValue("QS")));
		fcxx_w.setDjz_yys(Double.valueOf(((Element)element.elements().get(14)).attributeValue("YYS")));
		fcxx_w.setDjz_cjs(Double.valueOf(((Element)element.elements().get(15)).attributeValue("CJS")));
		fcxx_w.setDjz_dfjys(Double.valueOf(((Element)element.elements().get(16)).attributeValue("DFJYS")));
		fcxx_w.setDjz_grsds(Double.valueOf(((Element)element.elements().get(17)).attributeValue("GRSDS")));
		fcxx_w.setDjz_yhs(Double.valueOf(((Element)element.elements().get(18)).attributeValue("YHS")));
		fcxx_w.setDjz_tdzzs(Double.valueOf(((Element)element.elements().get(19)).attributeValue("TDZZS")));
		fcxx_w.setPgid(((Element)element.elements().get(20)).attributeValue("PGID"));
		fcxx_w.setBz(((Element)element.elements().get(21)).attributeValue("BZXX"));
		sql = String.format("call PG_INS_FC002('%s','%s','%f','%f','%f','%f','%f','%f','%f','%s','%s','%s','%s','%f','%s')",
				fcxx_w.getFcslh(),fcxx_w.getROOMID(),fcxx_w.getDjz_qs(),fcxx_w.getDjz_yys(),fcxx_w.getDjz_cjs(),
				fcxx_w.getDjz_dfjys(),fcxx_w.getDjz_grsds(),fcxx_w.getDjz_yhs(),fcxx_w.getDjz_tdzzs(),
				fcxx_w.getFpid(), fcxx_w.getSpid(), "",fcxx_w.getPgid(),fcxx_w.getPgjg(),fcxx_w.getBz());
		try{
			logger.info("2、向不动产传递完税信息...");
			insTAX2BDC(fcxx_w);
			logger.info("3、本地存储完税信息...");
			executeFunction(sql, conn);
			fcxx_wList.add("OK");
			result = combineFunctionXML(fcxx_wList);
			logger.info("4、完税信息回写成功");
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
	 * 将完税信息传入不动产
	 * @param bean
	 */
	private void insTAX2BDC(PgtFCXX_W bean) {
		FC002 wsBean = new FC002();
		Session session = null;
		
		//转换完税信息
		wsBean.setId(new FC001_PK(bean.getFcslh(), fcxx_w.getROOMID()));
		wsBean.setSeQs(fcxx_w.getDjz_qs());
		wsBean.setSeYys(fcxx_w.getDjz_yys());
		wsBean.setSeCjs(fcxx_w.getDjz_cjs());
		wsBean.setSeDfjys(fcxx_w.getDjz_dfjys());
		wsBean.setSeGrsds(fcxx_w.getDjz_grsds());
		wsBean.setSeYhs(fcxx_w.getDjz_yhs());
		wsBean.setSeTdzzs(fcxx_w.getDjz_tdzzs());
		wsBean.setFphm(fcxx_w.getFpid());
		wsBean.setQssphm(fcxx_w.getSpid());
		wsBean.setPgid(fcxx_w.getPgid());
		wsBean.setPgjg(fcxx_w.getPgjg());
		wsBean.setNote(fcxx_w.getBz());
		// 会话对象
		try {
	        session = HibernateBdcUtils.getSession();
	        session.beginTransaction(); 
	        session.delete(wsBean);
	        session.save(wsBean);
	        session.getTransaction().commit();			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	
}
