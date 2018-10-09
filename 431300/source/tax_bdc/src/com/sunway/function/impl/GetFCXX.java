package com.sunway.function.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.text.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.dom4j.Element;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sunway.function.IBaseObject;
import com.sunway.jdbc.HibernateUtils;
import com.sunway.vo.FC001;

/**
 * 读取房产局信息
 * @author Administrator
 *
 */
public class GetFCXX extends BaseFunction implements IBaseObject{
	static Logger logger = Logger.getLogger(GetFCXX.class);
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
	        session = HibernateUtils.getSession();
	        session.beginTransaction();
	        Query<?> query1 = session.createQuery("from FC001 where SLID = ?1"); 
	        query1.setParameter(1, fcxx.getSlid());
	        fcxxList = (List<FC001>) query1.list();
			result = combineFunctionXML(fcxxList);
			//------------ insert cmd table------------------------
	        Query<?> query2 = session.createQuery("update sys_cmd_request set resolve_state=2, resolve_time=current_timestamp() where cmd_code=?1"); 
	        query2.setParameter(1, fcxxList.get(0).getZlbh());
			query2.executeUpdate();
	        session.getTransaction().commit();
		} catch(Exception e) {
			session.getTransaction().rollback();
			errorSign = true;
			errorMessage = e.getMessage();
			logger.error(errorMessage);
			result = combineFunctionXML(fcxxList);
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
						,fcxxBean.getSlid(),fcxxBean.getFczh(),fcxxBean.getZrf_zjlx(),fcxxBean.getZrf_id(),
						fcxxBean.getZrf_name(),fcxxBean.getCsf_zjlx(),fcxxBean.getCsf_id(),fcxxBean.getCsf_name(),
						fcxxBean.getClh(),fcxxBean.getGhyt(),StringEscapeUtils.escapeXml11(fcxxBean.getLfdz()),
						fcxxBean.getDyfh(),	fcxxBean.getSzlc(),	fcxxBean.getZlc(),fcxxBean.getJzjg(),
						fcxxBean.getFwlx(),fcxxBean.getJylx(), fcxxBean.getJzmj(),fcxxBean.getHtzj(),
						fcxxBean.getJysj(),fcxxBean.getFzrq(), fcxxBean.getDf(),fcxxBean.getCx(),
						fcxxBean.getCg(), "", "", "", "", fcxxBean.getSn(), fcxxBean.getSfsyfc(), fcxxBean.getJcnf(), 
						fcxxBean.getQswsrq(), fcxxBean.getQswsjs(),fcxxBean.getZrf_tel(), 
						fcxxBean.getCsf_tel(), "获取成功");
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
		logger.info(strBuffer.toString());
		return result;
	}

}