package com.sunway.function.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.text.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Element;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.google.gson.Gson;
import com.sunway.function.IBaseObject;
import com.sunway.jdbc.HibernateUtils;
import com.sunway.vo.FC001;
import com.sunway.vo.SysCmdResponse;

/**
 * 读取房产局信息
 * @author Administrator
 *
 */
public class GetFCXX extends BaseFunction implements IBaseObject{
	static Logger logger = LogManager.getLogger(GetFCXX.class);
	private boolean errorSign = false;
	private String errorMessage;
	
	@Override
	public String executeFunction(Element element) {
		List<FC001> fcxxList = new ArrayList<FC001>();
		String result = null;
		Session session = null;
		FC001 fcxx = new FC001();
		fcxx.setSlid(element.elements().get(0).attributeValue(element.elements().get(0).attributes().get(0).getName()));
//		fcxx.setParamName(element.elements().get(0).attributes().get(0).getName());
//		fcxx.setParamName2(element.elements().get(1).attributes().get(0).getName());
//		fcxx.setParamVal2(element.elements().get(1).attributeValue(element.elements().get(1).attributes().get(0).getName()));
//		sql = String.format("SELECT * FROM PG_VFC001 WHERE SLID = '%s' AND SSQY = '%s'", fcxx.getParamVal(), fcxx.getParamVal2());
		try {
			logger.info("【请求响应表】Querying Sys_Cmd_Response table data...");
	        session = HibernateUtils.getSession();
	        Query<?> query1 = session.createQuery("from SysCmdResponse where biz_code = ?1"); 
	        query1.setParameter(1, fcxx.getSlid());
	        List<SysCmdResponse> fcList = (List<SysCmdResponse>) query1.list();
	        logger.info("【协税信息】Number of query results：" + fcList.size());
	        for (SysCmdResponse sys : fcList) {
	        	// JSON to javabean
	    		Gson gson = new Gson();
	    		FC001 fc = gson.fromJson(sys.getContent(), FC001.class);
	    		fc.setSlid(fcxx.getSlid());
	    		fc.setSn(sys.getQqlsh());
	    		fcxxList.add(fc);
			}
			result = combineFunctionXML(fcxxList);
			if(fcxxList.size()>0) {
				logger.info("【请求响应表】Some data was successfully read from Sys_Cmd_Response table.");
				//------------ insert cmd table------------------------
				logger.info("【指令流水表】Executing update data status...");
				session.beginTransaction();
		        Query<?> query2 = session.createQuery("update SysCmdRequest set resolve_state=1, resolve_time=current_timestamp() where data_id=?1"); 
		        query2.setParameter(1, fcxxList.get(0).getSn());
				query2.executeUpdate();
		        session.getTransaction().commit();
		        logger.info("【指令流水表】SYS_CMD_REQUEST table has been successfully updated.");				
			} else {
				logger.info("【协税信息】There are no data was read.");
			}
		} catch(Exception e) {
			session.getTransaction().rollback();
			errorSign = true;
			errorMessage = e.getMessage();
			result = combineFunctionXML(fcxxList);
			logger.error("【协税信息】Error during query execution...", e);
		} finally {
			session.close();
		}
		return result;
	}
	
	@Override
	public String combineFunctionXML(List<?> list) {
		StringBuffer strBuffer = new StringBuffer();
		String result = null;
		String str = null;
		FC001 fcxxBean = null;
		
		if(!errorSign){
			for(int i = 0; i< list.size();i++){
				fcxxBean = (FC001)list.get(i);
				str = String.format("<ROW FCSLH='%s' YFCZH='%s' ZRFSFLX='%s' ZRFSFID='%s' ZRFMC='%s' CSFSFLX='%s' CSFSFID='%s' CSFMC='%s' CLH='%s' SJYT='%s' LFDZ='%s' DYFH='%s' SZLC='%s' ZLC='%s' JZJG='%s' FWLX='%s' JYLX='%s' JZMJ='%s' HTZJ='%s' JYSJ='%s' FZRQ='%s' DF='%s' CX='%s' CG='%s' OINSID='%s' YJG='%s' PGJG='%s' ROOMID='%s' OWNROOMID='%s' SFSYFC='%s' JCNF='%s' WSRQ='%s' WSJS='%s' ZRFTEL='%s' CSFTEL='%s' ERRORSIGN='0' ERRORMESSAGE='%s'/>"
						,fcxxBean.getSlid(),fcxxBean.getFczh(),fcxxBean.getZrfZjlx(),fcxxBean.getZrfId(),
						fcxxBean.getZrfName(),fcxxBean.getCsfZjlx(),fcxxBean.getCsfId(),fcxxBean.getCsfName(),
						fcxxBean.getBdcdyh(),fcxxBean.getGhyt(),StringEscapeUtils.escapeXml11(fcxxBean.getLfdz()),
						fcxxBean.getDyfh(),	fcxxBean.getSzlc(),	fcxxBean.getZlc(),fcxxBean.getJzjg(),
						fcxxBean.getFwlx(),fcxxBean.getJylx(), fcxxBean.getJzmj(),fcxxBean.getHtzj(),
						fcxxBean.getJysj(),fcxxBean.getFzrq(), fcxxBean.getDf(),fcxxBean.getCx(),
						fcxxBean.getCg(), "", "", "", fcxxBean.getSn(), fcxxBean.getBdcdyh(), fcxxBean.getSfsyfc(), fcxxBean.getJcnf(), 
						fcxxBean.getQswsrq(), fcxxBean.getQswsjs(),fcxxBean.getZrfTel(), 
						fcxxBean.getCsfTel(), "获取成功");
				strBuffer.append(str);
			}
		}else{
			for(int i = 0; i< list.size();i++){
				fcxxBean = (FC001)list.get(i);
				str = String.format("<ROW FCSLH='' YFCZH='' ZRFSFLX='' ZRFSFID='' ZRFMC='' CSFSFLX='' CSFSFID='' CSFMC='' CLH='' SJYT='' LFDZ='' DYFH='' SZLC='' ZLC='' JZJG='' FWLX='' JYLX='' JZMJ='' HTZJ='' JYSJ='' FZRQ='' DF='' CX='' CG='' OINSID='' YJG='' PGJG='' ROOMID='' OWNROOMID='' SFSYFC='' JCNF='' WSRQ='' WSJS='' ERRORSIGN='1' ERRORMESSAGE='%s'/>", errorMessage);
				strBuffer.append(str);
			}
		}		

		result = "<Request Name='GetTAXREAD'>" +
//					"<TAXREAD "+ fcxx.getParamName() +"='"+ fcxx.getParamVal() + "'/>" +
					"<Results>" +
						"<Result>" +
							"<ROWS>" +
								strBuffer.toString()+
							"</ROWS>" +
						"</Result>" +
					"</Results>"+
			 	 "</Request>";
		return result;
	}

}