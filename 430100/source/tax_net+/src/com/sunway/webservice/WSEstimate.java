/**
 * 
 */
package com.sunway.webservice;

import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.sunway.service.impl.Pg30001Service;
import com.sunway.service.impl.Pgt00302Service;
import com.sunway.service.impl.Pgt00303Service;
import com.sunway.service.impl.Pgt00331Service;
import com.sunway.service.impl.Pgt00352Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.MakeUtil;
import com.sunway.vo.Pgt00302;
import com.sunway.vo.Pgt00331;
import com.sunway.vo.Pgt00352;
import com.sunway.vo.Pgv00302;
import com.sunway.vo.Pgv00303;


/**
 * @author amani
 *
 */
public class WSEstimate {
	private static Logger logger = LogManager.getLogger(WSEstimate.class);
	private Pgt00303Service t00303Service;
	private Pgt00302Service t00302Service;
	private Pgt00352Service t00352Service;
	private Pg30001Service pg30001Service;
	private Pgt00331Service t00331Service;
	private Pgt00302 tBean;
	private Pgv00302 v00302Bean;
	private Pgt00331 t00331Bean;
	
	/**
	 * 查找“估价分区”
	 * @param strXML
	 * @return
	 */
	public String findArea(String strXML) {
		logger.info("长沙评估分区查询--Begin");
		logger.info("评估分区查询报文IN：{}", strXML);
		StringBuilder rtnXML = new StringBuilder();
		ArrayList<Pgv00303> rtnList = new ArrayList<Pgv00303>();
		Pgv00303 v00303 = new Pgv00303();
		String rtnCode = "0";
		String rtnMsg = "评估分区查询失败";
		//初始化Bean
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		t00303Service = (Pgt00303Service)wac.getBean("T00303ServiceBean");
		//将字符串转化为Document
		Document document;
		try {
			document = DocumentHelper.parseText(strXML);
			// 解析XML报文
			Element rowElement = document.getRootElement().element(new QName("XQVO"));
			v00303.setFwtdzl(chkElement(rowElement.element(new QName("jdlm"))));
			v00303.setSzqy(chkElement(rowElement.element(new QName("szqy"))));
			//查询“估价分区”
			if(v00303.getFwtdzl() != null && !CheckUtil.chkEmpty(v00303.getFwtdzl())){
				v00303.setZcdzl(FormatUtil.toSearchLike(v00303.getFwtdzl()));
				rtnList = t00303Service.readFwtdzl(v00303);
				rtnCode = "1";
				rtnMsg = "查询到评估分区结果：" + rtnList.size()+ "条";
			}
		} catch (Exception e) {
			logger.error(e);
			rtnMsg = rtnMsg + "【" + StringEscapeUtils.escapeXml(e.getMessage()) + "】";
		} finally {
			//组装返回报文
			rtnXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><taxML><xqList>");
			for (Pgv00303 b : rtnList) {
				rtnXML.append("<XQVO><xqmc>"+b.getXqnm()+"</xqmc><bjms>"+b.getFwtdzl()+"</bjms></XQVO>");
			}
			rtnXML.append("</xqList><rtn_code>"+rtnCode+"</rtn_code><rtn_msg>"+rtnMsg+"</rtn_msg></taxML>");	
		}
		logger.info("评估分区查询报文OUT：{}", rtnXML.toString());
		logger.info("长沙评估分区查询--End");
		return rtnXML.toString();
	}
	
	/**
	 * 评估不动产
	 * @param strXML
	 * @return
	 */
	public String execEstimate(String strXML)  {
		logger.info("长沙国土评估--Begin");
		logger.info("评估报文IN：{}", strXML);
		StringBuilder rtnXML = new StringBuilder();
		tBean = new Pgt00302();
		v00302Bean = new Pgv00302();
		t00331Bean = new Pgt00331();
		String rtnCode = "0";
		String rtnMsg = "不动产交易价格评估失败";
		Double rtnPgjg = null;
		String rtnPgid = null;
		
		try {
			//初始化Bean
			WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
			t00302Service = (Pgt00302Service)wac.getBean("T00302ServiceBean");
			t00352Service = (Pgt00352Service)wac.getBean("T00352ServiceBean");
			pg30001Service = (Pg30001Service)wac.getBean("Pg30001ServiceBean");
			t00331Service = (Pgt00331Service)wac.getBean("T00331ServiceBean");
			//将字符串转化为Document
			Document document = DocumentHelper.parseText(strXML);
			// 解析XML报文
			analysisPGXML(document);
			
			if(!CheckUtil.chkEmpty(tBean.getFcid())){
				// 更新数据
				tBean.setBgsj(new Date());
				tBean.setBglx(1);
				t00302Service.GetDeleteCommand(tBean);
				tBean.setFcid(null);
			}
			// 新数据保存
			t00302Service.GetInsertCommand(tBean);
			logger.info("评估数据保存成功...");
			//评估
			v00302Bean.setFcid(tBean.getFcid());
			v00302Bean.setPgCzr(tBean.getCd00002Czr());
			v00302Bean = pg30001Service.GetExecPG(v00302Bean);
			logger.info("不动产数据评估完毕...");
			if (v00302Bean.getbResult()==1){
				rtnCode = "1";
				rtnMsg = "不动产交易价格评估成功";
				t00331Bean.setCd00302Fcid(tBean.getFcid());
				t00331Bean = t00331Service.LoadByPrimaryKey(t00331Bean);
				rtnPgjg = t00331Bean.getPgjg();
			}
			rtnPgid = tBean.getFcid();
		} catch (Exception e) {
			logger.error(e);
			rtnMsg = rtnMsg + "【" + StringEscapeUtils.escapeXml(e.getMessage()) + "】";
		} finally {
			//组装返回报文
			rtnXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT><RESRETURN>");
			rtnXML.append("<RESULT>"+rtnCode+"</RESULT><RESULT_MSG>"+rtnMsg+"</RESULT_MSG>");
			rtnXML.append("<FWPGJG>"+rtnPgjg+"</FWPGJG><PGID>"+rtnPgid+"</PGID>");
			rtnXML.append("</RESRETURN></ROOT>");
		}
		logger.info("评估报文OUT：{}", rtnXML.toString());
		logger.info("长沙国土评估--End");
		return rtnXML.toString();
	}	
	
	/**
	 * 解析XML，报文赋值
	 * @param strXML
	 * @throws Exception 
	 */
	private void analysisPGXML(Document doc) throws Exception {
		//解析required部分
		Element rowElement = doc.getRootElement().element(new QName("houseList")).element(new QName("houseVo"));
		tBean.setCd00002Czr(chkElement(rowElement.element(new QName("czr"))));
		String ssgx = chkElement(rowElement.element(new QName("ssgx")));
		tBean.setCd00001Ssgx(ssgx);
		tBean.setCd00352Xqdm(xqdmByName(chkElement(rowElement.element(new QName("xqmc"))), ssgx));
		tBean.setCd00001Fwlx(chkElement(rowElement.element(new QName("fwlx"))));
		tBean.setCd00001Jylx(chkElement(rowElement.element(new QName("jyfs"))));
		tBean.setCd00001Jzjg(chkElement(rowElement.element(new QName("fwjg"))));
		tBean.setJzmj(ConvertUtil.toBigDecimal(chkElement(rowElement.element(new QName("jzmj")))));
		tBean.setSzlc(ConvertUtil.toShort(chkElement(rowElement.element(new QName("fwlc")))));
		tBean.setBwjfh(chkElement(rowElement.element(new QName("fwfjh"))));
		tBean.setJyjg(ConvertUtil.toBigDecimal(chkElement(rowElement.element(new QName("htje")))));
//		tBean.setJysj(ConvertUtil.toTimestamp(chkElement(rowElement.element(new QName("jysj")))));
		tBean.setJysj(ConvertUtil.toTimestamp(MakeUtil.currentDate()));
		tBean.setZlc(ConvertUtil.toShort(chkElement(rowElement.element(new QName("fwzlc")))));
		tBean.setFczh(chkElement(rowElement.element(new QName("fwcqzsh"))));
		tBean.setGhyt(chkElement(rowElement.element(new QName("ghyt"))));
		tBean.setDjrq(ConvertUtil.toUtilDate(chkElement(rowElement.element(new QName("scqdfwsj")))));
		tBean.setZcdzl(chkElement(rowElement.element(new QName("fwzlwz"))));
		tBean.setZcdzbm(chkElement(rowElement.element(new QName("fwzlwz"))));
		tBean.setCd00001Szqy(chkElement(rowElement.element(new QName("xzqu"))));
		tBean.setSfsyfc(ConvertUtil.toInteger(chkElement(rowElement.element(new QName("sfsyfc")))));
		tBean.setNsrLx_zr(ConvertUtil.toInteger(chkElement(rowElement.element(new QName("mflx")))));
		tBean.setCd00001Mfgjdm(chkElement(rowElement.element(new QName("mfgj"))));
		tBean.setCd00301Swid(chkElement(rowElement.element(new QName("mfsfzhmsbm"))));	
		tBean.setNsrmc(chkElement(rowElement.element(new QName("mfmc"))));
		tBean.setCd00001Zjlx(chkElement(rowElement.element(new QName("mfzjlxdm"))));
		tBean.setNsrLx_cs(ConvertUtil.toInteger(chkElement(rowElement.element(new QName("gmflx")))));
		tBean.setCd00001Gmfgjdm(chkElement(rowElement.element(new QName("gmfgj"))));
		tBean.setTxtCSFZJLX(chkElement(rowElement.element(new QName("gmfzjlxdm")))); 
		tBean.setTxtCSFNSRMC(chkElement(rowElement.element(new QName("gmfmc"))));
		tBean.setTxtCSFZJHM(chkElement(rowElement.element(new QName("gmfsfzhmsbm"))));
		StringBuilder zhxz = new StringBuilder();
		zhxz.append(chkElement(rowElement.element(new QName("cx"))));
		zhxz.append(","+chkElement(rowElement.element(new QName("cg"))));
		tBean.setZhxz(zhxz.toString());
		// 非必录入项目
		tBean.setFcid(chkElement(rowElement.element(new QName("pgid"))));//-----------
		tBean.setLxdh(chkElement(rowElement.element(new QName("mfdh"))));
		tBean.setCsflxdh(chkElement(rowElement.element(new QName("gmfdh"))));
		tBean.setJcsj(chkElement(rowElement.element(new QName("jcnf"))));  
		tBean.setLh(chkElement(rowElement.element(new QName("fwdh"))));
		tBean.setDyh(chkElement(rowElement.element(new QName("fwdyh"))));
		tBean.setWsjs(ConvertUtil.toDouble(chkElement(rowElement.element(new QName("wsjs")))));
		tBean.setWsrq(ConvertUtil.toUtilDate(chkElement(rowElement.element(new QName("wsrq")))));
		//赋默认值
		tBean.setCd00352Xqzt(ConvertUtil.toByte("1"));
		tBean.setTdsyqmj(0.0);
		tBean.setRjl(0.0);
		tBean.setYjg(0.0);
		tBean.setSbpgjg(0.0);
		tBean.setWsjs(0.0);
		tBean.setOinsid(0);
		tBean.setIsExistQmpg(0);
	}
	
	/**
	 * 根据小区名转换为代码
	 * @param xqnm 小区名称
	 * @return 小区代码
	 * @throws Exception 
	 */
	private String xqdmByName(String xqnm, String ssgx) throws Exception {
		Pgt00352 t00352 = new Pgt00352();
		t00352.setXqnm(xqnm);
		t00352.setSsgx(ssgx);
		t00352 = t00352Service.LoadByXqnm(t00352);
		if(null == t00352.getXqdm()){
			throw new Exception("该估价分区未在评估系统中登记！");
		}
		return t00352.getXqdm();
	}
	
	private String chkElement(Element e) {
		if(null!=e)
			return e.getTextTrim();
		else
			return "";
	}
	
}
