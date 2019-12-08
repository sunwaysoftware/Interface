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
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.WBJH00000;

import gov.gt3.iitms.base.app.business.osb.GT3Port;

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
	private String txtSBH;
	private String txtNSRMC;
	private String txtZJHM;
	private String txtZJLX;
	private String txtGJDM;
	private String txtSSGX;
	private ArrayList<WBJH00000> tabList;
	//报文返回错误信息
	private String xmlErrMsg;
	private String xmlErrCod;

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
			tabList = wbjh00Service.LoadQyxx(wbjh);
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
		String tmpSBH = "";
		String[] arrNsrmc = txtNSRMC.split("、");
		String[] arrZjhm =  txtZJHM.split("、");		

		for(int i=0; i<arrNsrmc.length;){
			txtNSRMC = arrNsrmc[i];
			txtZJHM = arrZjhm[i];
			
			GT3Port gt3Port = new GT3Port();
			String tmpStr = gt3Port.web(makeSbXml(), ws_urll);
			tmpSBH = parserSbXml(tmpStr);
			// 1.验证自然人是否登记
			if(Common.isNullOrEmpty(tmpSBH)){
				// 如未登记，调用接口登记后，即返回 txtSB
				String tmpStr1 = gt3Port.web(makeDjXml(), ws_urll);
				tmpSBH = parserDjXml(tmpStr1);		
			}
			if(i==0){
				txtSBH = tmpSBH;
			} else {
				txtSBH = txtSBH + "、" + tmpSBH;
			}
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
	private String parserDjXml(String xml) throws IOException {
		ByteArrayInputStream stream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
		SAXReader saxReader = new SAXReader();
		Document document = null;
		String strCode = null;
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
						return zrrxxResList.element("nsrsbh").getText();
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
		return null;
	}	
	
	/**
	 * 解析金三【自然人登记查询】返回的报文
	 * @param xml 返回报文
	 * @return 自然人识别号
	 * @throws IOException 
	 */
	private String parserSbXml(String xml) throws IOException {
		ByteArrayInputStream stream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
		SAXReader saxReader = new SAXReader();
		Document document = null;
		String strCode = null;
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
						return zrrxxlb.element("nsrsbh").getText();
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
		return null;
	}

	/**
	 * 查询自然人登记信息XML
	 * 
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	private String makeSbXml() throws Exception {
		Date tmpDate = new Date();
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
		String sDate = sdfDate.format(tmpDate);
		SimpleDateFormat sdfTime = new SimpleDateFormat("hhmmssSSS");
		String sTime = sdfTime.format(tmpDate);

		StringBuffer tmpXML = new StringBuffer();
		tmpXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		tmpXML.append("<service xmlns=\"http://www.chinatax.gov.cn/spec/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><head>");
		tmpXML.append("<tran_id>SWZJ.GSGL.SB.CXZRRDJXXWBXT</tran_id>");
		tmpXML.append("<channel_id>HNDS.ZJNB.CLFJYNSPG</channel_id><tran_seq>");
		tmpXML.append(Common.makeUUID());//通用唯一识别码
		tmpXML.append("</tran_seq><tran_date>");
		tmpXML.append(sDate);//当前日期
		tmpXML.append("</tran_date><tran_time>");
		tmpXML.append(sTime);//当前时间
		tmpXML.append("</tran_time><expand><name>sjry</name><value>24300CLFPG0</value></expand><expand><name>sjjg</name><value>");
		tmpXML.append(txtSSGX);//转换后的税务机关
		tmpXML.append("</value></expand></head><body><![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
		tmpXML.append("<taxML xsi:type=\"zrrxxcxrequest\" xmlbh=\"String\" bbh=\"String\" xmlmc=\"String\" ");
		tmpXML.append("xsi:schemaLocation=\"http://www.chinatax.gov.cn/dataspec/TaxMLBw_GSGL_SB_001_Request_v1.0.xsd\" ");
		tmpXML.append("xmlns=\"http://www.chinatax.gov.cn/dataspec/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><xm>");
		tmpXML.append(txtNSRMC);// 纳税人名称
		tmpXML.append("</xm><zjhm>");
		tmpXML.append(txtZJHM);// 证件号码
		tmpXML.append("</zjhm><zjzlDm>");
		tmpXML.append(wbjh00Service.FindCode(t00001Service.GetInfoZJLX(), txtZJLX));// 证件类型
		tmpXML.append("</zjzlDm></taxML>]]></body></service>");
		return tmpXML.toString();
	}

	/**
	 * 自然人关键信息间接登记服务XML
	 * 
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	private String makeDjXml() throws Exception {
		Date tmpDate = new Date();
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
		String sDate = sdfDate.format(tmpDate);
		SimpleDateFormat sdfTime = new SimpleDateFormat("hhmmssSSS");
		String sTime = sdfTime.format(tmpDate);

		StringBuffer tmpXML = new StringBuffer();
		tmpXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		tmpXML.append("<service xmlns=\"http://www.chinatax.gov.cn/spec/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><head>");
		tmpXML.append("<tran_id>SWZJ.GSGL.DJ.BCZRRGJXXJJDJFW</tran_id>");
		tmpXML.append("<channel_id>HNDS.ZJNB.CLFJYNSPG</channel_id><tran_seq>");
		tmpXML.append(Common.makeUUID());//通用唯一识别码
		tmpXML.append("</tran_seq><tran_date>");
		tmpXML.append(sDate);//当前日期
		tmpXML.append("</tran_date><tran_time>");
		tmpXML.append(sTime);//当前时间
		tmpXML.append("</tran_time><expand><name>sjry</name><value>24300CLFPG0</value></expand><expand><name>sjjg</name><value>");
		tmpXML.append(txtSSGX);//转换后的税务机关
		tmpXML.append("</value></expand></head><body><![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
		tmpXML.append("<taxML xsi:type=\"zrrjjdjRequest\" xmlbh=\"String\" bbh=\"String\" xmlmc=\"String\" ");
		tmpXML.append("xsi:schemaLocation=\"http://www.chinatax.gov.cn/dataspec/TaxMLBw_GSGL_DJ_001_Request_v1.0.xsd\" ");
		tmpXML.append("xmlns=\"http://www.chinatax.gov.cn/dataspec/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
		tmpXML.append("<zrrxxGrid><zrrxxList><sfzjlx_dm>");
		tmpXML.append(wbjh00Service.FindCode(getT00001Service().GetInfoZJLX(), txtZJLX));// 证件类型
		tmpXML.append("</sfzjlx_dm><sfzjhm>");
		tmpXML.append(txtZJHM);// 证件号码
		tmpXML.append("</sfzjhm><xm>");
		tmpXML.append(txtNSRMC);// 纳税人名称
		tmpXML.append("</xm><gj_dm>");
        tmpXML.append(txtGJDM);// 国籍
        tmpXML.append("</gj_dm><slrDm>");
		tmpXML.append(sessionCtrl.getUserId());// 操作人
		tmpXML.append("</slrDm><slswjgDm>");
		tmpXML.append(txtSSGX);// 受理税务机关
		tmpXML.append("</slswjgDm><lyqdDm>HNDS.ZJNB.CLFJYNSPG</lyqdDm>");
		tmpXML.append("</zrrxxList></zrrxxGrid></taxML>]]></body></service>");
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
	 * @return the tabList
	 */
	public ArrayList<WBJH00000> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList
	 *            the tabList to set
	 */
	public void setTabList(ArrayList<WBJH00000> tabList) {
		this.tabList = tabList;
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

}
