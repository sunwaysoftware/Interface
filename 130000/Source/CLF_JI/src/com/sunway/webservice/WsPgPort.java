/**
 * 
 */
package com.sunway.webservice;

import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.sunway.service.impl.CL00390Service;
import com.sunway.service.impl.Pg30001Service;
import com.sunway.service.impl.Pgt00302Service;
import com.sunway.service.impl.Pgt00331Service;
import com.sunway.service.impl.Pgt00352Service;
import com.sunway.service.impl.Pgt00370Service;
import com.sunway.util.Common;
import com.sunway.vo.BF00000;
import com.sunway.vo.Pgt00302;
import com.sunway.vo.Pgt00331;
import com.sunway.vo.Pgt00352;
import com.sunway.vo.Pgt00370;
import com.sunway.vo.Pgv00302;
import com.sunway.vo.Pgv00331;
import com.sunway.vo.Pgv00352;
import com.sunway.vo.Pgv00370;

/**
 * @author amani
 *
 */
public class WsPgPort {
	private static Logger logger = LogManager.getLogger(WsPgPort.class);
	private Pgt00302Service t00302Service;
	private Pgt00352Service t00352Service;
	private Pg30001Service pg30001Service;
	private Pgt00331Service t00331Service;
	private CL00390Service cl00390Service;
	private Pgt00370Service t00370Service;
	private Pgt00302 tBean;
	private Pgv00302 v00302Bean;
	private Pgt00331 t00331Bean;
	
	/**
	 * 完税认定接口
	 * @param xml 认定XML
	 * @return
	 */
	public String execRD(String xml) {
		logger.info("秦皇岛完税认定--Begin");
		logger.info("完税认定报文IN：{}", xml);
		StringBuilder rtnXML = new StringBuilder();
		String rtnCode = "0";
		String rtnMsg = "不动产交易价格完税认定失败";

		//初始化Bean
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		cl00390Service = (CL00390Service)wac.getBean("CL00390ServiceBean");
		t00370Service = (Pgt00370Service)wac.getBean("T00370ServiceBean");
		//将字符串转化为Document
		Document document;
		try {
			document = DocumentHelper.parseText(xml);
			// 解析XML报文
			Element rowElement = document.getRootElement();
			// 1、实现“打印通知单”环节
			BF00000 bf00000 = new BF00000();
			bf00000.setFcid(chkElement(rowElement.element(new QName("pgid"))));
			bf00000.setSysSsgx(chkElement(rowElement.element(new QName("ssgx"))));
			bf00000.setCzr(chkElement(rowElement.element(new QName("czr"))));
			cl00390Service.execTzs(bf00000);		
			// 2、实现“税额”保存
			Pgt00370 t00370Bean = new Pgt00370();
			Pgv00370 v00370Bean = new Pgv00370();
			t00370Bean.setFcid(bf00000.getFcid());
			t00370Bean.setCd_00002_czr(bf00000.getCzr());
			t00370Service.GetDeleteCommand(t00370Bean);
			// 组装税额数据
			ArrayList<Pgv00370> v370List = packageV00370(rowElement.element(new QName("wsxx")));
			for (int i = 0; i < v370List.size(); i++) {
				v00370Bean = v370List.get(i);
				t00370Bean.setCd_00001_sz(v00370Bean.getPg_sz());
				t00370Bean.setSe(Common.convertToDouble(v00370Bean.getPg_se()));
				t00370Service.GetInsertCommand(t00370Bean);
			}
			// 3、实现“完税确认”环节			
			Pgv00331 v00331 = new Pgv00331();
			//准備查詢條件
			v00331.setCd00302Fcid(bf00000.getFcid());
			v00331.setCzr(bf00000.getCzr());
			v00331.setSysSsgx(bf00000.getSysSsgx());
			//执行查询
			cl00390Service.execRD(v00331);
			rtnCode = "1";
			rtnMsg = "不动产交易价格完税认定成功";
		} catch (Exception e) {
			logger.error(e);
			rtnMsg = rtnMsg + "【" + StringEscapeUtils.escapeXml(e.getMessage()) + "】";
		} finally {
			//组装返回报文
			rtnXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><BDC><rtn_code>");
			rtnXML.append(rtnCode);
			rtnXML.append("</rtn_code><rtn_msg>");
			rtnXML.append(rtnMsg);
			rtnXML.append("</rtn_msg></BDC>");
		}		
		logger.info("完税认定报文OUT：{}", rtnXML.toString());
		logger.info("完税认定--End");
		return rtnXML.toString();
	}
	
	/**
	 * 查询“估价分区”
	 * @param xml 查询报文
	 * @return 评估结果报文
	 */
	public String findGJFQ(String xml){
		logger.info("评估分区查询--Begin");
		logger.info("评估分区查询报文IN：{}", xml);
		StringBuilder rtnXML = new StringBuilder();
		ArrayList<Pgv00352> rtnList = new ArrayList<Pgv00352>();
		Pgt00352 t00352 = new Pgt00352();
		String rtnCode = "0";
		String rtnMsg = "评估分区查询失败";
		//初始化Bean
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		t00352Service = (Pgt00352Service)wac.getBean("T00352ServiceBean");
		//将字符串转化为Document
		Document document;
		try {
			document = DocumentHelper.parseText(xml);
			// 解析XML报文
			Element rowElement = document.getRootElement();
			t00352.setXqnm(chkElement(rowElement.element(new QName("gjfq"))));
			t00352.setSsgx(chkElement(rowElement.element(new QName("ssgx"))));
			//查询“估价分区”
			if(t00352.getXqnm() != null && !Common.isNullOrEmpty(t00352.getXqnm())){
				rtnList = t00352Service.GetXQNM(t00352);
				rtnCode = "1";
				rtnMsg = "查询到评估分区结果：" + rtnList.size()+ "条";
			}
		} catch (Exception e) {
			logger.error(e);
			rtnMsg = rtnMsg + "【" + StringEscapeUtils.escapeXml(e.getMessage()) + "】";
		} finally {
			//组装返回报文
			rtnXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><BDC><rtn_code>");
			rtnXML.append(rtnCode);
			rtnXML.append("</rtn_code><rtn_msg>");
			rtnXML.append(rtnMsg);
			rtnXML.append("</rtn_msg><fqList>");
			for (Pgv00352 b : rtnList) {
				rtnXML.append("<fq fwlx=\""+b.getNote()+"\" pCode=\"" + b.getXqdmh() + "\" pName=\""+b.getParentnm()+"\">" + b.getXqnm() + "</fq>");
			}
			rtnXML.append("</fqList></BDC>");			
		}
		logger.info("评估分区查询报文OUT：{}", rtnXML.toString());
		logger.info("评估分区查询--End");
		return rtnXML.toString();
	}
	
	/**
	 * 统一评估接口
	 * @param xml 评估报文
	 * @return 评估结果报文
	 */
	public String execPG(String xml){
		logger.info("房产评估--Begin");
		logger.info("评估报文IN：{}", xml);
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
			Document document = DocumentHelper.parseText(xml);
			// 解析XML报文
			analysisPGXML(document);
			
			if(!Common.isNullOrEmpty(tBean.getFcid())){
				// 更新数据
				tBean.setBgsj(new Date());
				tBean.setBglx(1);
				t00302Service.GetDeleteCommand(tBean);
				tBean.setFcid(null);
			}
			// 新数据保存
			t00302Service.GetInsertCommand(tBean);
			//评估
			v00302Bean.setFcid(tBean.getFcid());
			v00302Bean.setPgCzr(tBean.getCd00002Czr());
			v00302Bean = pg30001Service.GetExecPG(v00302Bean);
			if (v00302Bean.getbResult()==1){
				rtnCode = "1";
				rtnMsg = "不动产交易价格评估成功";
			}
			t00331Bean.setCd00302Fcid(tBean.getFcid());
			t00331Bean = t00331Service.LoadByPrimaryKey(t00331Bean);
			rtnPgjg = t00331Bean.getPgjg();
			rtnPgid = tBean.getFcid();
		} catch (Exception e) {
			logger.error(e);
			rtnMsg = rtnMsg + "【" + StringEscapeUtils.escapeXml(e.getMessage()) + "】";
		} finally {
			//组装返回报文
			rtnXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><BDC><rtn_code>");
			rtnXML.append(rtnCode);
			rtnXML.append("</rtn_code><rtn_msg>");
			rtnXML.append(rtnMsg);
			rtnXML.append("</rtn_msg><pgjg>");
			rtnXML.append(rtnPgjg);
			rtnXML.append("</pgjg><pgid>");
			rtnXML.append(rtnPgid);
			rtnXML.append("</pgid></BDC>");
		}
		logger.info("评估报文OUT：{}", rtnXML.toString());
		logger.info("房产评估--End");
		return rtnXML.toString();
	}
	
	/**
	 * 解析XML，报文赋值
	 * @param strXML
	 * @throws Exception 
	 */
	private void analysisPGXML(Document doc) throws Exception {
		//解析required部分
		Element rowElement = doc.getRootElement().element(new QName("required"));
		tBean.setCd00002Czr(chkElement(rowElement.element(new QName("czr"))));
		String ssgx = chkElement(rowElement.element(new QName("ssgx")));
		tBean.setCd00001Ssgx(ssgx);
		tBean.setCd00352Xqdm(xqdmByName(chkElement(rowElement.element(new QName("gjfq"))), ssgx));
		tBean.setCd00001Fwlx(chkElement(rowElement.element(new QName("fwlx"))));
		tBean.setCd00001Jylx(chkElement(rowElement.element(new QName("jylx"))));
		tBean.setCd00001Jzjg(chkElement(rowElement.element(new QName("jzjg"))));
		tBean.setJzmj(Common.convertToBigDecimal(chkElement(rowElement.element(new QName("jzmj")))));
		tBean.setSzlc(Common.convertToShort(chkElement(rowElement.element(new QName("szlc")))));
		tBean.setBwjfh(chkElement(rowElement.element(new QName("fh"))));
		tBean.setJyjg(Common.convertToBigDecimal(chkElement(rowElement.element(new QName("htzj")))));
		tBean.setJysj(Common.convertStringToTimestamp(chkElement(rowElement.element(new QName("jysj")))));
		tBean.setZlc(Common.convertToShort(chkElement(rowElement.element(new QName("zlc")))));
		tBean.setFczh(chkElement(rowElement.element(new QName("fczh"))));
		tBean.setGhyt(chkElement(rowElement.element(new QName("ghyt"))));
		tBean.setDjrq(Common.convertToDate(chkElement(rowElement.element(new QName("fzrq")))));
		tBean.setZcdzl(chkElement(rowElement.element(new QName("lfdz"))));
		tBean.setZcdzbm(chkElement(rowElement.element(new QName("lfdz"))));
		tBean.setCd00001Szqy(chkElement(rowElement.element(new QName("szqy"))));
		tBean.setSfsyfc(Common.convertToInteger(chkElement(rowElement.element(new QName("sfsy")))));
		tBean.setNsrLx_zr(Common.convertToInteger(chkElement(rowElement.element(new QName("zrf_lx")))));
		tBean.setCd00001Mfgjdm(chkElement(rowElement.element(new QName("zrf_gj"))));
		tBean.setCd00301Swid(chkElement(rowElement.element(new QName("zrf_zjh"))));	
		tBean.setNsrmc(chkElement(rowElement.element(new QName("zrf_xm"))));
		tBean.setCd00001Zjlx(chkElement(rowElement.element(new QName("zrf_zjlx"))));
		tBean.setNsrLx_cs(Common.convertToInteger(chkElement(rowElement.element(new QName("csf_lx")))));
		tBean.setCd00001Gmfgjdm(chkElement(rowElement.element(new QName("csf_gj"))));
		tBean.setTxtCSFZJLX(chkElement(rowElement.element(new QName("csf_zjlx")))); 
		tBean.setTxtCSFNSRMC(chkElement(rowElement.element(new QName("csf_xm"))));
		tBean.setTxtCSFZJHM(chkElement(rowElement.element(new QName("csf_zjh"))));
		tBean.setZhxz(chkElement(rowElement.element(new QName("zhxz"))));
//		tBean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
		//解析非required部分
		rowElement = doc.getRootElement();
		tBean.setFcid(chkElement(rowElement.element(new QName("pgid"))));
		tBean.setLxdh(chkElement(rowElement.element(new QName("zrf_tel"))));
		tBean.setCsflxdh(chkElement(rowElement.element(new QName("csf_tel"))));
		tBean.setJcsj(chkElement(rowElement.element(new QName("jcnf"))));  
		tBean.setLh(chkElement(rowElement.element(new QName("lh"))));
		tBean.setDyh(chkElement(rowElement.element(new QName("dyh"))));
		tBean.setWsjs(Common.convertToDouble(chkElement(rowElement.element(new QName("wsjs")))));
		tBean.setWsrq(Common.convertToDate(chkElement(rowElement.element(new QName("wsrq")))));
		//赋默认值
		tBean.setCd00352Xqzt(Common.convertToByte("1"));
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
	
	/**
	 * 组装税额数据
	 * @param rowElement
	 * @return
	 * @throws Exception
	 */
	private ArrayList<Pgv00370> packageV00370(Element rowElement) throws Exception {
		ArrayList<Pgv00370> list = new ArrayList<Pgv00370>();
		Pgv00370 v00370 = null;
		
		// 契税
		if (rowElement.element(new QName("qs")) != null) {
			v00370 = new Pgv00370();
			v00370.setPg_sz("01");
			v00370.setPg_se(chkElement(rowElement.element(new QName("qs"))));
			list.add(v00370);
		}
		// 增值税
		if (rowElement.element(new QName("zzs")) != null) {
			v00370 = new Pgv00370();
			v00370.setPg_sz("02");
			v00370.setPg_se(chkElement(rowElement.element(new QName("zzs"))));
			list.add(v00370);
		}
		// 城市维护建设税
		if (rowElement.element(new QName("cjs")) != null) {
			v00370 = new Pgv00370();
			v00370.setPg_sz("03");
			v00370.setPg_se(chkElement(rowElement.element(new QName("cjs"))));
			list.add(v00370);
		}
		// 地方教育附加
		if (rowElement.element(new QName("dfjyfj")) != null) {
			v00370 = new Pgv00370();
			v00370.setPg_sz("04");
			v00370.setPg_se(chkElement(rowElement.element(new QName("dfjyfj"))));
			list.add(v00370);
		}
		// 个人所得税
		if (rowElement.element(new QName("grsds")) != null) {
			v00370 = new Pgv00370();
			v00370.setPg_sz("05");
			v00370.setPg_se(chkElement(rowElement.element(new QName("grsds"))));
			list.add(v00370);
		}
		// 印花税
		if (rowElement.element(new QName("yhs")) != null) {
			v00370 = new Pgv00370();
			v00370.setPg_sz("06");
			v00370.setPg_se(chkElement(rowElement.element(new QName("yhs"))));
			list.add(v00370);
		}
		// 土地增值税
		if (rowElement.element(new QName("tdzzs")) != null) {
			v00370 = new Pgv00370();
			v00370.setPg_sz("07");
			v00370.setPg_se(chkElement(rowElement.element(new QName("tdzzs"))));
			list.add(v00370);
		}
		// 教育费附加
		if (rowElement.element(new QName("jyffj")) != null) {
			v00370 = new Pgv00370();
			v00370.setPg_sz("08");
			v00370.setPg_se(chkElement(rowElement.element(new QName("jyffj"))));
			list.add(v00370);
		}
		return list;
	}
	
}
