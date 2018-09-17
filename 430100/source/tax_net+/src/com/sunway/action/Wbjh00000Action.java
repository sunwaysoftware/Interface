/**
 * 
 */
package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00001Service;
import com.sunway.service.IWBJH00Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.MakeUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.WBJH00000;

import cn.gov.chinatax.www.spec.GT3Port;

/**
 * @author Amani
 *
 */
public class Wbjh00000Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -5260312455759490424L;
	// 金三数据源
	private String gt3DriverClass;
	private String gt3DSUrl;
	private String gt3User;
	private String gt3Password;
	
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private IPgt00001Service t00001Service;
	private IWBJH00Service wbjh00Service;
	private String ws_urll;
	private String ws_channel_id;
	private String ws_expand_sjry;
	private String txtSBH;
	private String txtNSRMC;
	private String txtZJHM;
	private String txtZJLX;
	private String txtGJDM;
	private String txtSSGX;
	private ArrayList<WBJH00000> rows;
	private WBJH00000 bean;
	//报文返回错误信息
	private String xmlErrMsg;
	private String xmlErrCod;
	
	private String FCID;
	private String FWUUID;
	private String HTBH;
	private String SLMsg;	
	private String resSign;
	
	/**
	 * 发送评估数据至征管系统
	 * 
	 * @return
	 * @throws Exception
	 */
	public String sendXMLI() throws Exception {
		
		try {
			if(wbjh00Service.InsGT3WBJH(FCID))
				resSign = "0";
			else
				resSign = "1";
		} catch (Exception e) {
			LOG.error(e.getMessage());
			SLMsg = e.getMessage();
			resSign = "1";
		} finally {
				
		}
		return SUCCESS;
	}
	
	/**
	 * 发送评估数据至征管系统
	 * 
	 * @return
	 * @throws Exception
	 */
	public String sendXMLISY() throws Exception {
		
		try {
			if(wbjh00Service.InsGT3WBJHSY(FCID))
				resSign = "0";
			else
				resSign = "1";
		} catch (Exception e) {
			LOG.error(e.getMessage());
			SLMsg = e.getMessage();
			resSign = "1";
		} finally {
				
		}
		return SUCCESS;
	}	

	/**
	 * 获取征管系统税额接口XML
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String SendSeXML() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("SendSeXML() ********** start **********");
		}
		this.clearErrorsAndMessages();
		WBJH00000 gt3 = new WBJH00000();
		try {
			gt3.setGt3DriverClass(gt3DriverClass);
			gt3.setGt3DSUrl(gt3DSUrl);
			gt3.setGt3User(gt3User);
			gt3.setGt3Password(gt3Password);
			gt3.setFwuuid(FWUUID);
			rows = wbjh00Service.GetGT3WSXX(gt3);
			xmlErrCod = "1";
			xmlErrMsg = "取得数据成功！";
		} catch (Exception e) {
			LOG.error("Pgt00302XMLAction -- SendSeXML()", e);
			xmlErrCod = "0";
			xmlErrMsg = e.getMessage();
			this.addActionMessage("与大集中连接错误");
			return SUCCESS;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("SendSeXML() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据【纳税人识别号】读取企业信息
	 * 
	 * @return
	 */
	public String queryGsQyxx() {

		WBJH00000 wbjh = new WBJH00000();
		// 载入金三数据源
		wbjh.setGt3DriverClass(gt3DriverClass);
		wbjh.setGt3DSUrl(gt3DSUrl);
		wbjh.setGt3User(gt3User);
		wbjh.setGt3Password(gt3Password);
		try {
			wbjh.setNsrsbh(txtSBH);
			rows = wbjh00Service.LoadQyxx(wbjh);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return SUCCESS;
	}

	/**
	 * 根据【纳税人名称、证件号码、证件类型】进行自然人间接登记
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryGsZrr() throws Exception {
		//String tmpSBH = "";
		String[] arrNsrmc = txtNSRMC.split("、");
		String[] arrZjhm =  txtZJHM.split("、");		

		for(int i=0; i<arrNsrmc.length;){
			/*txtNSRMC = arrNsrmc[i];
			txtZJHM = arrZjhm[i];*/
			
			GT3Port gt3Port = new GT3Port();
			String tmpStr = gt3Port.web(makeSbXml(arrZjhm[i],txtZJLX,arrNsrmc[i]), ws_urll);
			System.out.print(tmpStr);
			// 1.验证自然人是否登记
			if(!parserSbXml(tmpStr)){
				// 如未登记，调用接口登记后，即返回 txtSB
				String tmpStr1 = gt3Port.web(makeDjXml(arrZjhm[i],txtZJLX,arrNsrmc[i],txtGJDM), ws_urll);
				System.out.print(tmpStr1);
				parserDjXml(tmpStr1);
			}
			/*if(i==0){
				txtSBH = tmpSBH;
			} else {
				txtSBH = txtSBH + "、" + tmpSBH;
			}*/
			//取第一个纳税人识别号就行了。20150901
			break;
		}
		return SUCCESS;
	}

	/**
	 * 解析金三【自然人登记查询】返回的报文
	 * @param xml 返回报文
	 * @return 自然人识别号
	 * @throws IOException 
	 */
	private boolean parserDjXml(String xml) throws IOException {
		ByteArrayInputStream stream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
		SAXReader saxReader = new SAXReader();
		Document document = null;
		String strCode = null;
		boolean b = false;
		bean = new WBJH00000();
		try {
			document = saxReader.read(stream,"UTF-8");
			// 获取根元素
			Element root = document.getRootElement();
			List<?> heads = root.elements("head");
			if(heads.size()>0){
				Element head = (Element) heads.get(0);
				Element rtncode = head.element("rtn_code");
				Element rtnmag = head.element("rtn_msg");
				strCode = rtncode.getText() + rtnmag.element("Code").getText();
				xmlErrCod = strCode;
				xmlErrMsg = rtnmag.element("Message").getText();
			}
			// "0000"代表报文成功返回
			if("0000".equals(strCode)){
				// 获取特定名称的子元素
				List<?> bodys = root.elements("body");
				Element body = (Element) bodys.get(0);
				ByteArrayInputStream is = new ByteArrayInputStream(body.getText().getBytes("UTF-8"));
				SAXReader saxr = new SAXReader();
				Document doc = null;
				try {
					doc = saxr.read(is,"UTF-8");
					Element taxml = doc.getRootElement();
					List<?> zrrxxResGrids = taxml.element("zrrxxResGrid").elements();
					if(zrrxxResGrids.size()>0){
						Element zrrxxResList = (Element) zrrxxResGrids.get(0);
						bean.setNsrsbh(zrrxxResList.element("nsrsbh").getText());
						bean.setDjxh(zrrxxResList.element("djxh").getText());
						b = true;
					}
				} catch (DocumentException e) {
					LOG.error(e.getMessage());
				} finally {
					is.close();
				}
			}
		} catch (DocumentException e) {
			LOG.error(e.getMessage());
		} finally {
			stream.close();
		}
		return b;
	}	
	
	/**
	 * 解析金三【自然人登记查询】返回的报文
	 * @param xml 返回报文
	 * @return 自然人识别号
	 * @throws IOException 
	 */
	private boolean parserSbXml(String xml) throws IOException {
		ByteArrayInputStream stream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
		SAXReader saxReader = new SAXReader();
		Document document = null;
		String strCode = null;
		boolean b = false;
		bean = new WBJH00000();
		try {
			document = saxReader.read(stream,"UTF-8");
			// 获取根元素
			Element root = document.getRootElement();
			List<?> heads = root.elements("head");
			if(heads.size()>0){
				Element head = (Element) heads.get(0);
				Element rtncode = head.element("rtn_code");
				Element rtnmag = head.element("rtn_msg");
				strCode = rtncode.getText() + rtnmag.element("Code").getText();
				xmlErrCod = strCode;
				xmlErrMsg = rtnmag.element("Message").getText();
			}
			// "0000"代表报文成功返回
			if("0000".equals(strCode)){
				// 获取特定名称的子元素
				List<?> bodys = root.elements("body");
				Element body = (Element) bodys.get(0);
				ByteArrayInputStream is = new ByteArrayInputStream(body.getText().getBytes("UTF-8"));
				SAXReader saxr = new SAXReader();
				Document doc = null;
				try {
					doc = saxr.read(is,"UTF-8");
					Element taxml = doc.getRootElement();
					List<?> zrrxxgridList = taxml.element("zrrxxgrid").elements();
					if(zrrxxgridList.size()>0){
						Element zrrxxlb = (Element) zrrxxgridList.get(0);
						bean.setNsrsbh(zrrxxlb.element("nsrsbh").getText());
						bean.setDjxh(zrrxxlb.element("djxh").getText());
						b = true;
					}
				} catch (DocumentException e) {
					LOG.error(e.getMessage());
				} finally {
					is.close();
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		} finally {
			stream.close();
		}
		return b;
	}

	/**
	 * 查询自然人登记信息XML
	 * 
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	private String makeSbXml(String zjhm,String zjlx,String nsrmc) throws Exception {
		Date tmpDate = new Date();
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
		String sDate = sdfDate.format(tmpDate);
		SimpleDateFormat sdfTime = new SimpleDateFormat("hhmmssSSS");
		String sTime = sdfTime.format(tmpDate);

		StringBuffer tmpXML = new StringBuffer();
		tmpXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");		
		tmpXML.append("<service xmlns=\"http://www.chinatax.gov.cn/spec/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><head>");
		tmpXML.append("<tran_id>SWZJ.GSGL.SB.CXZRRDJXXWBXT</tran_id><channel_id>");
		tmpXML.append(ws_channel_id);
		tmpXML.append("</channel_id><tran_seq>");
		tmpXML.append(MakeUtil.UUID());//通用唯一识别码
		tmpXML.append("</tran_seq><tran_date>");
		tmpXML.append(sDate);//当前日期
		tmpXML.append("</tran_date><tran_time>");
		tmpXML.append(sTime);//当前时间
		tmpXML.append("</tran_time><expand><name>sjry</name><value>");
		tmpXML.append(ws_expand_sjry);
		tmpXML.append("</value></expand><expand><name>sjjg</name><value>");
		tmpXML.append(txtSSGX);//转换后的税务机关
		tmpXML.append("</value></expand>");
		tmpXML.append("<expand><name>identityType</name><value>");//2016版本新添加的
		tmpXML.append(ws_channel_id);
		tmpXML.append("</value></expand>");
		tmpXML.append("</head><body><![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
		tmpXML.append("<taxML xsi:type=\"zrrxxcxrequest\" xmlbh=\"String\" bbh=\"String\" xmlmc=\"String\" ");
		tmpXML.append("xsi:schemaLocation=\"http://www.chinatax.gov.cn/dataspec/TaxMLBw_GSGL_SB_001_Request_v1.0.xsd\" ");
		tmpXML.append("xmlns=\"http://www.chinatax.gov.cn/dataspec/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><xm>");
		tmpXML.append(nsrmc);// 纳税人名称
		tmpXML.append("</xm><zjhm>");
		tmpXML.append(zjhm);// 证件号码
		tmpXML.append("</zjhm><zjzlDm>");
		tmpXML.append(wbjh00Service.FindCode(t00001Service.GetInfoZJLX(), zjlx));// 证件类型
		tmpXML.append("</zjzlDm></taxML>]]></body></service>");
		System.out.print(tmpXML.toString());
		return tmpXML.toString();
	}

	/**
	 * 自然人关键信息间接登记服务XML
	 * 
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	private String makeDjXml(String zjhm,String zjlx,String nsrmc,String gjdm) throws Exception {
		Date tmpDate = new Date();
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
		String sDate = sdfDate.format(tmpDate);
		SimpleDateFormat sdfTime = new SimpleDateFormat("hhmmssSSS");
		String sTime = sdfTime.format(tmpDate);

		StringBuffer tmpXML = new StringBuffer();
		tmpXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		tmpXML.append("<service xmlns=\"http://www.chinatax.gov.cn/spec/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><head>");
		tmpXML.append("<tran_id>SWZJ.GSGL.DJ.BCZRRGJXXJJDJFW</tran_id><channel_id>");
		tmpXML.append(ws_channel_id);
		tmpXML.append("</channel_id><tran_seq>");
		tmpXML.append(MakeUtil.UUID());//通用唯一识别码
		tmpXML.append("</tran_seq><tran_date>");
		tmpXML.append(sDate);//当前日期
		tmpXML.append("</tran_date><tran_time>");
		tmpXML.append(sTime);//当前时间
		tmpXML.append("</tran_time><expand><name>sjry</name><value>");
		tmpXML.append(ws_expand_sjry);
		tmpXML.append("</value></expand><expand><name>sjjg</name><value>");
		tmpXML.append(txtSSGX);//转换后的税务机关
		tmpXML.append("</value></expand>");
		tmpXML.append("<expand><name>identityType</name><value>");//2016版本新添加的
		tmpXML.append(ws_channel_id);
		tmpXML.append("</value></expand>");
		tmpXML.append("</head><body><![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
		tmpXML.append("<taxML xsi:type=\"zrrjjdjRequest\" xmlbh=\"String\" bbh=\"String\" xmlmc=\"String\" ");
		tmpXML.append("xsi:schemaLocation=\"http://www.chinatax.gov.cn/dataspec/TaxMLBw_GSGL_DJ_001_Request_v1.0.xsd\" ");
		tmpXML.append("xmlns=\"http://www.chinatax.gov.cn/dataspec/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
		tmpXML.append("<zrrxxGrid><zrrxxList><sfzjlx_dm>");
		tmpXML.append(wbjh00Service.FindCode(getT00001Service().GetInfoZJLX(), zjlx));// 证件类型
		tmpXML.append("</sfzjlx_dm><sfzjhm>");
		tmpXML.append(zjhm);// 证件号码
		tmpXML.append("</sfzjhm><xm>");
		tmpXML.append(nsrmc);// 纳税人名称
		tmpXML.append("</xm><gj_dm>");
        tmpXML.append(gjdm);// 国籍
        tmpXML.append("</gj_dm><slrDm>");
		tmpXML.append(CheckUtil.chkSubstring(sessionCtrl.getUserId(),11));// 操作人
		tmpXML.append("</slrDm><slswjgDm>");
		tmpXML.append(txtSSGX);// 受理税务机关
		tmpXML.append("</slswjgDm><lyqdDm>");
		tmpXML.append(ws_channel_id);
		tmpXML.append("</lyqdDm>");
		tmpXML.append("</zrrxxList></zrrxxGrid></taxML>]]></body></service>");
		System.out.print(tmpXML.toString());
		return tmpXML.toString();
	}

	/******************************
	 * SET AND GET
	 ***********************************/
	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
		try {
			txtSSGX = wbjh00Service.FindCode(t00001Service.GetInfoSSGX(),sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}

	public String getTxtSBH() {
		return txtSBH;
	}

	public void setTxtSBH(String txtSBH) {
		this.txtSBH = txtSBH;
	}

	/**
	 * @return the wbjh00Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IWBJH00Service getWbjh00Service() {
		return wbjh00Service;
	}

	/**
	 * @param wbjh00Service
	 *            the wbjh00Service to set
	 */
	public void setWbjh00Service(IWBJH00Service wbjh00Service) {
		this.wbjh00Service = wbjh00Service;
	}

	/**
	 * @return the t00001Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00001Service getT00001Service() {
		return t00001Service;
	}

	/**
	 * @param t00001Service
	 *            the t00001Service to set
	 */
	public void setT00001Service(IPgt00001Service t00001Service) {
		this.t00001Service = t00001Service;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<WBJH00000> getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            the rows to set
	 */
	public void setRows(ArrayList<WBJH00000> rows) {
		this.rows = rows;
	}

	/**
	 * @return the txtNSRMC
	 */
	public String getTxtNSRMC() {
		return txtNSRMC;
	}

	/**
	 * @param txtNSRMC
	 *            the txtNSRMC to set
	 */
	public void setTxtNSRMC(String txtNSRMC) {
		this.txtNSRMC = txtNSRMC;
	}

	/**
	 * @return the txtZJHM
	 */
	public String getTxtZJHM() {
		return txtZJHM;
	}

	/**
	 * @param txtZJHM
	 *            the txtZJHM to set
	 */
	public void setTxtZJHM(String txtZJHM) {
		this.txtZJHM = txtZJHM;
	}

	/**
	 * @return the txtZJLX
	 */
	public String getTxtZJLX() {
		return txtZJLX;
	}

	/**
	 * @param txtZJLX
	 *            the txtZJLX to set
	 */
	public void setTxtZJLX(String txtZJLX) {
		this.txtZJLX = txtZJLX;
	}

	/**
	 * @return the ws_urll
	 */
	public String getWs_urll() {
		return ws_urll;
	}

	/**
	 * @param ws_urll
	 *            the ws_urll to set
	 */
	public void setWs_urll(String ws_urll) {
		this.ws_urll = ws_urll;
	}

	/**
	 * @return the xmlErrMsg
	 */
	public String getXmlErrMsg() {
		return xmlErrMsg;
	}

	/**
	 * @param xmlErrMsg the xmlErrMsg to set
	 */
	public void setXmlErrMsg(String xmlErrMsg) {
		this.xmlErrMsg = xmlErrMsg;
	}

	/**
	 * @return the xmlErrCod
	 */
	public String getXmlErrCod() {
		return xmlErrCod;
	}

	/**
	 * @param xmlErrCod the xmlErrCod to set
	 */
	public void setXmlErrCod(String xmlErrCod) {
		this.xmlErrCod = xmlErrCod;
	}

	public String getTxtGJDM() {
		return txtGJDM;
	}

	public void setTxtGJDM(String txtGJDM) {
		this.txtGJDM = txtGJDM;
	}

	/**
	 * @return the gt3DriverClass
	 */
	public String getGt3DriverClass() {
		return gt3DriverClass;
	}

	/**
	 * @param gt3DriverClass the gt3DriverClass to set
	 */
	public void setGt3DriverClass(String gt3DriverClass) {
		this.gt3DriverClass = gt3DriverClass;
	}

	/**
	 * @return the gt3DSUrl
	 */
	public String getGt3DSUrl() {
		return gt3DSUrl;
	}

	/**
	 * @param gt3dsUrl the gt3DSUrl to set
	 */
	public void setGt3DSUrl(String gt3dsUrl) {
		gt3DSUrl = gt3dsUrl;
	}

	/**
	 * @return the gt3User
	 */
	public String getGt3User() {
		return gt3User;
	}

	/**
	 * @param gt3User the gt3User to set
	 */
	public void setGt3User(String gt3User) {
		this.gt3User = gt3User;
	}

	/**
	 * @return the gt3Password
	 */
	public String getGt3Password() {
		return gt3Password;
	}

	/**
	 * @param gt3Password the gt3Password to set
	 */
	public void setGt3Password(String gt3Password) {
		this.gt3Password = gt3Password;
	}

	/**
	 * @return the txtSSGX
	 */
	public String getTxtSSGX() {
		return txtSSGX;
	}

	/**
	 * @param txtSSGX the txtSSGX to set
	 */
	public void setTxtSSGX(String txtSSGX) {
		this.txtSSGX = txtSSGX;
	}

	/**
	 * @return the fCID
	 */
	public String getFCID() {
		return FCID;
	}

	/**
	 * @param fCID the fCID to set
	 */
	public void setFCID(String fCID) {
		FCID = fCID;
	}

	/**
	 * @return the sLMsg
	 */
	public String getSLMsg() {
		return SLMsg;
	}

	/**
	 * @param sLMsg the sLMsg to set
	 */
	public void setSLMsg(String sLMsg) {
		SLMsg = sLMsg;
	}

	/**
	 * @return the resSign
	 */
	public String getResSign() {
		return resSign;
	}

	/**
	 * @param resSign the resSign to set
	 */
	public void setResSign(String resSign) {
		this.resSign = resSign;
	}

	public WBJH00000 getBean() {
		return bean;
	}

	public void setBean(WBJH00000 bean) {
		this.bean = bean;
	}

	/**
	 * @return the ws_channel_id
	 */
	public String getWs_channel_id() {
		return ws_channel_id;
	}

	/**
	 * @param ws_channel_id the ws_channel_id to set
	 */
	public void setWs_channel_id(String ws_channel_id) {
		this.ws_channel_id = ws_channel_id;
	}

	/**
	 * @return the ws_expand_sjry
	 */
	public String getWs_expand_sjry() {
		return ws_expand_sjry;
	}

	/**
	 * @param ws_expand_sjry the ws_expand_sjry to set
	 */
	public void setWs_expand_sjry(String ws_expand_sjry) {
		this.ws_expand_sjry = ws_expand_sjry;
	}

	public String getHTBH() {
		return HTBH;
	}

	public void setHTBH(String hTBH) {
		HTBH = hTBH;
	}

	public String getFWUUID() {
		return FWUUID;
	}

	public void setFWUUID(String fWUUID) {
		FWUUID = fWUUID;
	}
	

}
