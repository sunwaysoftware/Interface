package com.sunway.function.impl;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import javax.sql.rowset.CachedRowSet;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.sunway.function.IBaseObject;
import com.sunway.vo.PgtFCXX;

import pub.webservice.impl.FdcqServiceImplServiceStub;
import pub.webservice.impl.FdcqServiceImplServiceStub.GetFdcqByYwh;
import pub.webservice.impl.FdcqServiceImplServiceStub.GetFdcqByYwhE;
import pub.webservice.impl.FdcqServiceImplServiceStub.GetFdcqByYwhResponseE;

/**
 * 读取国土局信息
 * 
 * @author Administrator
 * 
 */
public class GetFCXX extends BaseFunction implements IBaseObject {

	static Logger logger = Logger.getLogger(GetFCXX.class);

	private static final String XQDM = "f0"; // 小区代码
	private static final String FCSLH = "f1"; // 国土受理号
	private static final String YFCZH = "f2"; // 原国土证号
	private static final String ZRFSFLX = "f3"; // 转让方身份证照类型
	private static final String ZRFSFID = "f4"; // 转让方身份证照号码/企业管理代码
	private static final String ZRFMC = "f5"; // 转让方名称/企业名称
	private static final String CSFSFLX = "f6"; // 承受方身份证照类型
	private static final String CSFSFID = "f7"; // 承受方身份证照号码/企业管理代码
	private static final String CSFMC = "f8"; // 承受方名称/企业名称
	private static final String CLH = "f9"; // 测量号
	private static final String SJYT = "f10"; // 设计用途
	private static final String LFDZ = "f11"; // 楼房地址
	private static final String DYFH = "f12"; // 单元及房号
	private static final String SZLC = "f13"; // 所在楼层
	private static final String ZLC = "f14"; // 总楼层
	private static final String JZJG = "f15"; // 建筑结构
	private static final String FWLX = "f16"; // 房屋类别
	private static final String JYLX = "f17"; // 交易类型
	private static final String JZMJ = "f18"; // 建筑面积(平方米)
	private static final String HTZJ = "f19"; // 合同总价(元)
	private static final String JYSJ = "f20"; // 交易时间
	private static final String FZRQ = "f21"; // 发证日期
	private static final String DF = "f22"; // 端房
	private static final String CX = "f23"; // 朝向
	private static final String CG = "f24"; // 层高
	private static final String OINSID = "f25"; // 外键
	private static final String YJG = "f26"; // 原值
	private static final String PGJG = "f27"; // 评估结果
	private static final String ROOMID = "f28"; // 房屋ID
	private static final String SFSYFC = "f30"; // 是否私有国土
	private static final String OWNROOMID = "f31"; // 房屋ID
	private static final String JCNF = "JCNF";      	//建成年份
	private static final String QSWSRQ = "qswsrq";      //契税完税日期
	private static final String QSWSJS = "qswsjs";      //契税完税基数	
	private static final String ZRFTEL = "zrftel";		//转让方电话
	private static final String CSFTEL = "csftel";		//转让方电话
	private static final String TDCRJ = "TDCRJ";
	
	private PgtFCXX fcxx;
	private boolean errorSign = false;
	private String errorMessage;

	@Override
	public String executeFunction(Element element, Connection conn) {
		ArrayList<PgtFCXX> fcxxList = new ArrayList<PgtFCXX>();
		String result = null;
		CachedRowSet ocrs = null;
		String sql = null;
		fcxx = new PgtFCXX();
		fcxx.setParamName(element.elements().get(0).attributes().get(0).getName());
		fcxx.setParamVal(element.elements().get(0).attributeValue(fcxx.getParamName()));
		fcxx.setParamName2(element.elements().get(1).attributes().get(0).getName());
		fcxx.setParamVal2(element.elements().get(1).attributeValue(fcxx.getParamName2()));
		// 从国土接口获得数据后，将国土数据写入DB --------------------------------
		logger.info("1、正在调用国土接口【GetFdcqByYwh】获取国土信息...");
		FdcqServiceImplServiceStub bdcWsStub = null;
		GetFdcqByYwhResponseE ywhResponse = null;
		SAXReader saxReader = new SAXReader();
		try {
			bdcWsStub = new  FdcqServiceImplServiceStub();
			GetFdcqByYwhE ywhE = new GetFdcqByYwhE();
			GetFdcqByYwh ywh = new GetFdcqByYwh();
			ywh.setArg0(String.format("<?xml version='1.0' encoding='UTF-8'?><INFO><USERNAME>DS1001</USERNAME><PASSWORD>123456</PASSWORD><JID>%s</JID></INFO>", fcxx.getParamVal()));
			ywhE.setGetFdcqByYwh(ywh);
			// 增加此句，屏蔽SOAP_ACTION
			bdcWsStub._getServiceClient().getOptions().setProperty(org.apache.axis2.Constants.Configuration.DISABLE_SOAP_ACTION, true);
			ywhResponse = bdcWsStub.getFdcqByYwh(ywhE);
			String strReturn = ywhResponse.getGetFdcqByYwhResponse().get_return();
			logger.info("2、国土返回报文：\n"+ strReturn);
			Document  document = saxReader.read(new ByteArrayInputStream(strReturn.getBytes("utf-8")));
			Element rootElement = document.getRootElement();
			String hasInfo = "1";
			String hasMsg = null;
			hasInfo = rootElement.elementTextTrim("RESULT_FLAG");
			hasMsg = rootElement.elementTextTrim("RESULT_MESSAGE");
			if(!"1".equals(hasInfo)){
				throw new Exception(hasMsg);
			} else {		
				// 读取XML中SQRINFO节点信息
				String strZRFMC = null;
				String strZRFSFLX = null;
				String strZRFSFID = null;
				String strZRFTEL = null;
				String strCSFMC = null;
				String strCSFSFID = null;
				String strCSFSFLX = null;
				String strCSFTEL = null;
				Iterator<Element> sqr = rootElement.element("SQRINFO").elementIterator();
				Boolean bSign_zrf = false;
				Boolean bSign_csf = false;
				while (sqr.hasNext()){
					Element rowElement = sqr.next();
					if(bSign_zrf==false && "权利转让人".equals(rowElement.elementTextTrim("FSQRLX"))){
						strZRFMC = isNotEmpty(rowElement)?rowElement.elementTextTrim("FSQRMC"):null;
						strZRFSFID = isNotEmpty(rowElement)?rowElement.elementTextTrim("FZJHM"):null;
						strZRFSFLX = isNotEmpty(rowElement)?rowElement.elementTextTrim("FZJZL"):null;
						strZRFTEL = isNotEmpty(rowElement)?rowElement.elementTextTrim("FLXDH"):null;			
						bSign_zrf = true;
					}
					if(bSign_csf==false && "房地产权利人".equals(rowElement.elementTextTrim("FSQRLX"))){
						strCSFMC = isNotEmpty(rowElement)?rowElement.elementTextTrim("FSQRMC"):null;
						strCSFSFID = isNotEmpty(rowElement)?rowElement.elementTextTrim("FZJHM"):null;
						strCSFSFLX = isNotEmpty(rowElement)?rowElement.elementTextTrim("FZJZL"):null;
						strCSFTEL = isNotEmpty(rowElement)?rowElement.elementTextTrim("FLXDH"):null;		
						bSign_csf = true;
					}
					if(bSign_csf==true && bSign_zrf==true){
						break;
					}
				}
				
				// 读取XML中FDCQINFO节点信息
				Iterator<Element> desc = rootElement.element("FDCQINFO").elementIterator();
				while (desc.hasNext()) {
					Element rowElement = desc.next();
					sql = String.format("call PG_INS_FC001('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %f, %f, '%s', '%s', '%s', %f, %f, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %f, '%s', '%s', %f, %f)", 
							//isNotEmpty(rowElement.getFirstChildWithName(new QName("FCSLH")))?rowElement.getFirstChildWithName(new QName("FCSLH")).getText():null,
							isNotEmpty(rowElement)?rowElement.elementTextTrim("JID"):null,		
							isNotEmpty(rowElement)?rowElement.elementTextTrim("FBDCDYH"):null,
							null, //isNotEmpty(rowElement.getFirstChildWithName(new QName("YFCZH")))?rowElement.getFirstChildWithName(new QName("YFCZH")).getText():null,
							strZRFMC, // isNotEmpty(rowElement.getFirstChildWithName(new QName("ZRFMC")))?rowElement.getFirstChildWithName(new QName("ZRFMC")).getText():null,
							strZRFSFID, // isNotEmpty(rowElement.getFirstChildWithName(new QName("ZRFSFID")))?rowElement.getFirstChildWithName(new QName("ZRFSFID")).getText():null,
							strZRFSFLX , //isNotEmpty(rowElement.getFirstChildWithName(new QName("ZRFSFLX")))?rowElement.getFirstChildWithName(new QName("ZRFSFLX")).getText():null,
							strZRFTEL, //isNotEmpty(rowElement.getFirstChildWithName(new QName("ZRFTEL")))?rowElement.getFirstChildWithName(new QName("ZRFTEL")).getText():null,
							strCSFMC, // isNotEmpty(rowElement.getFirstChildWithName(new QName("CSFMC")))?rowElement.getFirstChildWithName(new QName("CSFMC")).getText():null,
							strCSFSFID, // isNotEmpty(rowElement.getFirstChildWithName(new QName("CSFSFID")))?rowElement.getFirstChildWithName(new QName("CSFSFID")).getText():null,
							strCSFSFLX, // isNotEmpty(rowElement.getFirstChildWithName(new QName("CSFSFLX")))?rowElement.getFirstChildWithName(new QName("CSFSFLX")).getText():null,
							strCSFTEL,  // isNotEmpty(rowElement.getFirstChildWithName(new QName("CSFTEL")))?rowElement.getFirstChildWithName(new QName("CSFTEL")).getText():null,
							//isNotEmpty(rowElement.getFirstChildWithName(new QName("CLH")))?rowElement.getFirstChildWithName(new QName("CLH")).getText():null,
							isNotEmpty(rowElement)?rowElement.elementTextTrim("FBDCDYH"):null,
							isNotEmpty(rowElement)?rowElement.elementTextTrim("FGHYT"):null,
							//isNotEmpty(rowElement.getFirstChildWithName(new QName("LFDZ")))?rowElement.getFirstChildWithName(new QName("LFDZ")).getText():null,
							isNotEmpty(rowElement)?rowElement.elementTextTrim("FFDZL"):null,
							//isNotEmpty(rowElement.getFirstChildWithName(new QName("DYFH")))?rowElement.getFirstChildWithName(new QName("DYFH")).getText():null,
							isNotEmpty(rowElement)?rowElement.elementTextTrim("FHH"):null,
							//isNotEmpty(rowElement.getFirstChildWithName(new QName("ZLC")))?Double.valueOf(rowElement.getFirstChildWithName(new QName("ZLC")).getText()):null,
							isNotEmpty(rowElement)?Double.valueOf(rowElement.elementTextTrim("FZCS")):null,
							//isNotEmpty(rowElement.getFirstChildWithName(new QName("SZLC")))?Double.valueOf(rowElement.getFirstChildWithName(new QName("SZLC")).getText()):null,
							isNotEmpty(rowElement)?Double.valueOf(rowElement.elementTextTrim("FSZC")):null,
							//isNotEmpty(rowElement.getFirstChildWithName(new QName("JZJG")))?rowElement.getFirstChildWithName(new QName("JZJG")).getText():null,
							isNotEmpty(rowElement)?rowElement.elementTextTrim("FFWJG"):null,
							null, //isNotEmpty(rowElement.getFirstChildWithName(new QName("FWLX")))?rowElement.getFirstChildWithName(new QName("FWLX")).getText():null,
							null, //isNotEmpty(rowElement.getFirstChildWithName(new QName("JYLX")))?rowElement.getFirstChildWithName(new QName("JYLX")).getText():null,
							//isNotEmpty(rowElement.getFirstChildWithName(new QName("JZMJ")))?Double.valueOf(rowElement.getFirstChildWithName(new QName("JZMJ")).getText()):null,
							isNotEmpty(rowElement)?Double.valueOf(rowElement.elementTextTrim("FJZMJ")):null,
							null, //isNotEmpty(rowElement.getFirstChildWithName(new QName("HTZJ")))?Double.valueOf(rowElement.getFirstChildWithName(new QName("HTZJ")).getText()):null,
							null, //isNotEmpty(rowElement.getFirstChildWithName(new QName("FZRQ")))?rowElement.getFirstChildWithName(new QName("FZRQ")).getText():null,
							null, //isNotEmpty(rowElement.getFirstChildWithName(new QName("JCNF")))?rowElement.getFirstChildWithName(new QName("JCNF")).getText():null,
							null, //isNotEmpty(rowElement.getFirstChildWithName(new QName("JYSJ")))?rowElement.getFirstChildWithName(new QName("JYSJ")).getText():null,
							null, //rowElement.getFirstChildWithName(new QName("SFSYFC")).getText(),
							null, //isNotEmpty(rowElement.getFirstChildWithName(new QName("CX")))?rowElement.getFirstChildWithName(new QName("CX")).getText():null,
							null, //isNotEmpty(rowElement.getFirstChildWithName(new QName("DF")))?rowElement.getFirstChildWithName(new QName("DF")).getText():null,
							null, //rowElement.getFirstChildWithName(new QName("JG")).getText(),
							null, //rowElement.getFirstChildWithName(new QName("ZX")).getText(),
							null, //isNotEmpty(rowElement.getFirstChildWithName(new QName("CG")))?Double.valueOf(rowElement.getFirstChildWithName(new QName("CG")).getText()):null,
							null, //isNotEmpty(rowElement.getFirstChildWithName(new QName("XQDM")))?rowElement.getFirstChildWithName(new QName("XQDM")).getText():null,
							null, //isNotEmpty(rowElement.getFirstChildWithName(new QName("QSWSRQ")))?rowElement.getFirstChildWithName(new QName("QSWSRQ")).getText():null,
							null, //isNotEmpty(rowElement.getFirstChildWithName(new QName("QSWSJS")))?Double.valueOf(rowElement.getFirstChildWithName(new QName("QSWSJS")).getText()):null);
							isNotEmpty(rowElement)?Double.valueOf(rowElement.elementTextTrim("TDCRJ")):null);
					executeFunction(sql, conn);
				}
				logger.info("3、国土信息存储完毕...");
				// 读取国土信息 --------------------------------
				sql = String.format("SELECT * FROM PG_VFC001 WHERE SLID = '%s'", fcxx.getParamVal());
				ocrs = queryFunction(sql, conn);
				while (null != ocrs && ocrs.next()) {
					fcxxList.add(setFCXXParameters(ocrs));
				}
				result = combineFunctionXML(fcxxList);
				logger.info("4、整合国土报文，返回给评估系统...");
			}
		} catch (Exception e) {
			logger.error(e);
			errorSign = true;
			errorMessage = errorMessage +  e.getMessage();
			result = combineFunctionXML(fcxxList);
		} finally {
			getFreeORS(ocrs);
		}
		return result;
	}

	/**
	 * 装载数据
	 * 
	 * @param ocrs
	 * @return
	 * @throws Exception
	 */
	protected PgtFCXX setFCXXParameters(CachedRowSet ocrs) throws Exception {
		PgtFCXX e = new PgtFCXX();
		e.setXqdm(ocrs.getString(XQDM));
		e.setFcslh(ocrs.getString(FCSLH));
		e.setYfczh(ocrs.getString(YFCZH));
		e.setZrfsflx(ocrs.getString(ZRFSFLX));
		e.setZrfsfid(ocrs.getString(ZRFSFID));
		e.setZrfmc(ocrs.getString(ZRFMC));
		e.setCsfsflx(ocrs.getString(CSFSFLX));
		e.setCsfsfid(ocrs.getString(CSFSFID));
		e.setCsfmc(ocrs.getString(CSFMC));
		e.setClh(ocrs.getString(CLH));
		e.setSjyt(ocrs.getString(SJYT));
		e.setLfdz(ocrs.getString(LFDZ));
		e.setDyfh(ocrs.getString(DYFH));
		e.setSzlc(ocrs.getString(SZLC));
		e.setZlc(ocrs.getString(ZLC));
		e.setJzjg(ocrs.getString(JZJG));
		e.setFwlx(ocrs.getString(FWLX));
		e.setJylx(ocrs.getString(JYLX));
		e.setJzmj(ocrs.getString(JZMJ));
		e.setHtzj(ocrs.getString(HTZJ));
		e.setJysj(ocrs.getString(JYSJ));
		e.setFzrq(ocrs.getString(FZRQ));
		e.setDf(ocrs.getString(DF));
		e.setCx(ocrs.getString(CX));
		e.setCg(ocrs.getString(CG));
		e.setOinsid(ocrs.getString(OINSID));
		e.setYjg(ocrs.getString(YJG));
		e.setPgjg(ocrs.getString(PGJG));
		e.setRoomid(ocrs.getString(ROOMID));
		e.setOwnRoomid(ocrs.getString(OWNROOMID));
		e.setSfsyfc(ocrs.getString(SFSYFC));
		e.setJcnf(ocrs.getString(JCNF));
		e.setQswsrq(ocrs.getString(QSWSRQ));
		e.setQswsjs(ocrs.getString(QSWSJS));
		e.setZrfTel(ocrs.getString(ZRFTEL));
		e.setCsfTel(ocrs.getString(CSFTEL));
		e.setTdcrj(ocrs.getString(TDCRJ));
		return e;
	}

	@Override
	public String combineFunctionXML(ArrayList<?> list) {
		StringBuffer strBuffer = new StringBuffer();
		String result = null;
		String str = null;
		PgtFCXX fcxxBean = null;

		if (!errorSign) {
			for (int i = 0; i < list.size(); i++) {
				fcxxBean = (PgtFCXX) list.get(i);
				str = String
						.format("<ROW FCSLH='%s' YFCZH='%s' ZRFSFLX='%s' ZRFSFID='%s' ZRFMC='%s' CSFSFLX='%s' CSFSFID='%s' CSFMC='%s' CLH='%s' SJYT='%s' LFDZ='%s' DYFH='%s' SZLC='%s' ZLC='%s' JZJG='%s' FWLX='%s' JYLX='%s' JZMJ='%s' HTZJ='%s' JYSJ='%s' FZRQ='%s' DF='%s' CX='%s' CG='%s' OINSID='%s' YJG='%s' PGJG='%s' ROOMID='%s' OWNROOMID='%s' SFSYFC='%s' XQDM='%s' JCNF='%s' WSRQ='%s' WSJS='%s' ZRFTEL='%s' CSFTEL='%s' TDCRJ='%s' ERRORSIGN='0' ERRORMESSAGE='%s'/>",
								fcxxBean.getFcslh(), fcxxBean.getYfczh(),
								fcxxBean.getZrfsflx(), fcxxBean.getZrfsfid(),
								fcxxBean.getZrfmc(), fcxxBean.getCsfsflx(),
								fcxxBean.getCsfsfid(), fcxxBean.getCsfmc(),
								fcxxBean.getClh(), fcxxBean.getSjyt(),
								fcxxBean.getLfdz(), fcxxBean.getDyfh(),
								fcxxBean.getSzlc(), fcxxBean.getZlc(),
								fcxxBean.getJzjg(), fcxxBean.getFwlx(),
								fcxxBean.getJylx(), fcxxBean.getJzmj(),
								fcxxBean.getHtzj(), fcxxBean.getJysj(),
								fcxxBean.getFzrq(), fcxxBean.getDf(),
								fcxxBean.getCx(), fcxxBean.getCg(),
								fcxxBean.getOinsid(), fcxxBean.getYjg(),
								fcxxBean.getPgjg(), fcxxBean.getRoomid(),
								fcxxBean.getOwnRoomid(), fcxxBean.getSfsyfc(),
								fcxxBean.getXqdm(), fcxxBean.getJcnf(), 
								fcxxBean.getQswsrq(), fcxxBean.getQswsjs(),
								fcxxBean.getZrfTel(), fcxxBean.getCsfTel(),
								fcxxBean.getTdcrj(), "交易数据获取成功");
				strBuffer.append(str);
			}
		} else {
			for (int i = 0; i < list.size(); i++) {
				fcxxBean = (PgtFCXX) list.get(i);
				str = String
						.format("<ROW FCSLH='' YFCZH='' ZRFSFLX='' ZRFSFID='' ZRFMC='' CSFSFLX='' CSFSFID='' CSFMC='' CLH='' SJYT='' LFDZ='' DYFH='' SZLC='' ZLC='' JZJG='' FWLX='' JYLX='' JZMJ='' HTZJ='' JYSJ='' FZRQ='' DF='' CX='' CG='' OINSID='' YJG='' PGJG='' ROOMID='' OWNROOMID='' SFSYFC='' XQDM='' JCNF='' WSRQ='' WSJS='' ZRFTEL='' CSFTEL='' TDCRJ='' ERRORSIGN='1' ERRORMESSAGE='%s'/>",
								errorMessage);
				strBuffer.append(str);
			}
		}

		result = "<Request Name='GetTAXREAD'>" + "<TAXREAD "
				+ fcxx.getParamName() + "='" + fcxx.getParamVal() + "'/>"
				+ "<Results>" + "<Result>" + "<ROWS>" + strBuffer.toString()
				+ "</ROWS>" + "</Result>" + "</Results>" + "</Request>";
		return result;
	}
	
	/**
	 * 判断是否为空
	 * @param value
	 * @return
	 */
	private Boolean isNotEmpty(Element value) {
		Boolean bResult;
		if (null==value)
			bResult = false;
		else
			bResult = true;
		
		return bResult;
		
	}
	

}
