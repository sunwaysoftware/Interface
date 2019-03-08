package com.sunway.function.impl;

import java.util.ArrayList;
import javax.annotation.PostConstruct;

import com.sunway.dao.BdcCqDao;
import com.sunway.dao.BdcFwsxDao;
import com.sunway.dao.BdcQlrDao;
import com.sunway.entity.tax.BdcCq;
import com.sunway.entity.tax.BdcFwsx;
import com.sunway.entity.tax.BdcQlr;

import com.sunway.util.CheckUtil;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.MakeUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.text.StringEscapeUtils;
import org.dom4j.Element;
import com.sunway.function.IBaseObject;
import com.sunway.vo.PgtFCXX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 读取房产局信息
 * @author Administrator
 *
 */
@Component
public class GetFCXX extends BaseFunction implements IBaseObject{
	static Log log = LogFactory.getLog(GetFCXX.class);
	private static GetFCXX fcxxUtil;
	@Autowired
	private BdcFwsxDao bdcFwsxDao;
	@Autowired
	private BdcCqDao bdcCqDao;
	@Autowired
	private BdcQlrDao bdcQlrDao;

	@PostConstruct
	public void init(){
		fcxxUtil = this;
		fcxxUtil.bdcFwsxDao = this.bdcFwsxDao;
		fcxxUtil.bdcCqDao = this.bdcCqDao;
		fcxxUtil.bdcQlrDao = this.bdcQlrDao;
	}

	private PgtFCXX fcxx;
	private boolean errorSign = false;
	private String errorMessage;
	
	@Override
	public String executeFunction(Element element) {
		ArrayList<PgtFCXX> fcxxList = new ArrayList<PgtFCXX>();
		String result = null;
		fcxx = new PgtFCXX();
		fcxx.setParamName(element.elements().get(0).attributes().get(0).getName());
		fcxx.setParamVal(element.elements().get(0).attributeValue(fcxx.getParamName()));
		fcxx.setParamName2(element.elements().get(1).attributes().get(0).getName());
		fcxx.setParamVal2(element.elements().get(1).attributeValue(fcxx.getParamName2()));
		try {
			BdcFwsx fwsx = new BdcFwsx();
			fwsx.setYwh(fcxx.getParamVal());
			for (BdcFwsx b: fcxxUtil.bdcFwsxDao.getDataByYwh(fwsx)) {
				fcxxList.add(setFCXXParameters(b));
			}
			result = combineFunctionXML(fcxxList);
		} catch(Exception e) {
			e.printStackTrace();
			errorSign = true;
			errorMessage = e.getMessage();
			result = combineFunctionXML(fcxxList);
		} finally {
			//
		}
		return result;
	}
	
	/**
	 * 装载数据
	 * @param ocrs
	 * @return
	 * @throws Exception
	 */
	protected PgtFCXX setFCXXParameters(BdcFwsx ocrs) throws Exception {
		PgtFCXX e = new PgtFCXX();
		//------------- 读取产权 -------------------------------
		BdcCq cq = new BdcCq();
		cq.setYwh(ocrs.getYwh());
		for (BdcCq b: fcxxUtil.bdcCqDao.getDataByYwh(cq)) {
			e.setYfczh(b.getYbdcqzh());
			e.setHtzj(String.valueOf(CheckUtil.chkNull(b.getJyjg())*10000));// 国土价格为万元，需转换
			e.setJysj(FormatUtil.toYYYYMMDD(b.getJysj()));
			e.setFzrq(FormatUtil.toYYYYMMDD(b.getFzrq()));
		}
		//-------------- 读取房屋属性 --------------------------
		e.setFcslh(ocrs.getYwh());
		e.setClh(ocrs.getBdcdyh());
		if(null!=ocrs.getDictGhty())
			e.setSjyt(ocrs.getDictGhty().getTaxNm());
		e.setLfdz(ocrs.getBsit());
		e.setDyfh(ocrs.getRoomnum());
		e.setSzlc(String.valueOf(ocrs.getCurflr()));
		e.setZlc(String.valueOf(ocrs.getTtlflrs()));
		if(null!=ocrs.getDictJzjg())
			e.setJzjg(ocrs.getDictJzjg().getTaxNm());
		if(null!=ocrs.getDictFwlx())
			e.setFwlx(ocrs.getDictFwlx().getTaxNm());
		if(null!=ocrs.getDictJylx())
			e.setJylx(ocrs.getDictJylx().getTaxNm());
		e.setJzmj(String.valueOf(ocrs.getBarea()));

		e.setDf(ocrs.getDf());
		e.setCx(ocrs.getCx());
		e.setCg(ocrs.getCg());
		e.setOinsid(ocrs.getId());
//		e.setYjg(ocrs.getString(YJG));
//		e.setPgjg(ocrs.getString(PGJG));
//		e.setRoomid(ocrs.getString(ROOMID));
//		e.setOwnRoomid(ocrs.getString(OWNROOMID));
		e.setSfsyfc(ocrs.getSfsyfc());
		e.setQswsrq(FormatUtil.toYYYYMMDD(ocrs.getQswsrq()));
		e.setQswsjs(String.valueOf(ocrs.getQswsjs()));
//		e.setJcnf(ocrs.getString(JCNF));
		//------- 权利人 ------------------------
		String sign = "、";
		String zrfZjlx = "";
		String zrfZjbm = "";
		String zrfNm = "";
		String csfZjlx = "";
		String csfZjbm = "";
		String csfNm = "";
		for (BdcQlr qlr: fcxxUtil.bdcQlrDao.getDataByYwh(new BdcQlr(ocrs.getYwh()))) {
			// 0转让方；1承受方
			if("0".equals(qlr.getDictQlrlb().getTaxNm())){// 0 转让方/义务人
				if(null!=qlr.getDictZjlx())
					zrfZjlx = zrfZjlx + qlr.getDictZjlx().getTaxNm() + sign;
				zrfZjbm = zrfZjbm + qlr.getScnum() + sign;
				zrfNm = zrfNm + qlr.getSname() + sign;
			}else if ("1".equals(qlr.getDictQlrlb().getTaxNm())){// 1 承受方/权利人
				if(null!=qlr.getDictZjlx())
					csfZjlx = csfZjlx + qlr.getDictZjlx().getTaxNm() + sign;
				csfZjbm = csfZjbm + qlr.getScnum() + sign;
				csfNm = csfNm + qlr.getSname() + sign;
			}
		}
		e.setZrfsflx(zrfZjlx);
		e.setZrfsfid(zrfZjbm);
		e.setZrfmc(zrfNm);
		e.setCsfsflx(csfZjlx);
		e.setCsfsfid(csfZjbm);
		e.setCsfmc(csfNm);
//		e.setZrfTel(ocrs.getString(ZRFTEL));
//		e.setCsfTel(ocrs.getString(CSFTEL));
		return e;
	}
	
	@Override
	public String combineFunctionXML(ArrayList<?> list) {
		StringBuffer strBuffer = new StringBuffer();
		String result = null;
		String str = null;
		PgtFCXX fcxxBean = null;
		
		if(!errorSign){
			for(int i = 0; i< list.size();i++){
				fcxxBean = (PgtFCXX)list.get(i);
				str = String.format("<ROW FCSLH='%s' YFCZH='%s' ZRFSFLX='%s' ZRFSFID='%s' ZRFMC='%s' CSFSFLX='%s' CSFSFID='%s' CSFMC='%s' CLH='%s' SJYT='%s' LFDZ='%s' DYFH='%s' SZLC='%s' ZLC='%s' JZJG='%s' FWLX='%s' JYLX='%s' JZMJ='%s' HTZJ='%s' JYSJ='%s' FZRQ='%s' DF='%s' CX='%s' CG='%s' OINSID='%s' YJG='%s' PGJG='%s' ROOMID='%s' OWNROOMID='%s' SFSYFC='%s' JCNF='%s' WSRQ='%s' WSJS='%s' ZRFTEL='%s' CSFTEL='%s' ERRORSIGN='0' ERRORMESSAGE='%s'/>"
						,fcxxBean.getFcslh(),fcxxBean.getYfczh(),fcxxBean.getZrfsflx(),fcxxBean.getZrfsfid(),
						fcxxBean.getZrfmc(),fcxxBean.getCsfsflx(),fcxxBean.getCsfsfid(),fcxxBean.getCsfmc(),
						fcxxBean.getClh(),fcxxBean.getSjyt(),StringEscapeUtils.escapeXml11(fcxxBean.getLfdz()),
						fcxxBean.getDyfh(),	fcxxBean.getSzlc(),	fcxxBean.getZlc(),fcxxBean.getJzjg(),
						fcxxBean.getFwlx(),fcxxBean.getJylx(), fcxxBean.getJzmj(),fcxxBean.getHtzj(),
						fcxxBean.getJysj(),fcxxBean.getFzrq(), fcxxBean.getDf(),fcxxBean.getCx(),
						fcxxBean.getCg(),fcxxBean.getOinsid(), fcxxBean.getYjg(),fcxxBean.getPgjg(),
						fcxxBean.getRoomid(), fcxxBean.getOwnRoomid(),fcxxBean.getSfsyfc(), fcxxBean.getJcnf(), 
						fcxxBean.getQswsrq(), fcxxBean.getQswsjs(),fcxxBean.getZrfTel(), 
						fcxxBean.getCsfTel(), "获取成功");
				strBuffer.append(str);
			}
		}else{
			for(int i = 0; i< list.size();i++){
				fcxxBean = (PgtFCXX)list.get(i);
				str = String.format("<ROW FCSLH='' YFCZH='' ZRFSFLX='' ZRFSFID='' ZRFMC='' CSFSFLX='' CSFSFID='' CSFMC='' CLH='' SJYT='' LFDZ='' DYFH='' SZLC='' ZLC='' JZJG='' FWLX='' JYLX='' JZMJ='' HTZJ='' JYSJ='' FZRQ='' DF='' CX='' CG='' OINSID='' YJG='' PGJG='' ROOMID='' OWNROOMID='' SFSYFC='' JCNF='' WSRQ='' WSJS='' ERRORSIGN='1' ERRORMESSAGE='%s'/>"
						, errorMessage);
				strBuffer.append(str);
			}
		}		

		result = "<Request Name='GetTAXREAD'>" +
					"<TAXREAD "+ fcxx.getParamName() +"='"+ fcxx.getParamVal() + "'/>" +
					"<Results>" +
						"<Result>" +
							"<ROWS>" +
								strBuffer.toString()+
							"</ROWS>" +
						"</Result>" +
					"</Results>"+
			 	 "</Request>";
		log.info(strBuffer.toString());
		return result;
	}

}