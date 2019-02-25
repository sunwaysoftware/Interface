package com.sunway.function.impl;

import java.util.ArrayList;

import com.sunway.dao.TaxWsxxDao;
import com.sunway.entity.TaxWsxx;
import com.sunway.util.DateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Element;

import com.sunway.function.IBaseObject;
import com.sunway.vo.PgtFCXX_W;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 回写完税信息
 * @author Administrator
 *
 */
@Component
public class WriFCXX extends BaseFunction implements IBaseObject{
	static Log log = LogFactory.getLog(WriFCXX.class);
	@Autowired
	private TaxWsxxDao taxWsxxDao;
	private static WriFCXX wsxxUtil;

	@PostConstruct
	public void init(){
		wsxxUtil = this;
		wsxxUtil.taxWsxxDao = this.taxWsxxDao;
	}

	private PgtFCXX_W fcxx_w;
	private String errorMessage;
	
	@Override
	public String executeFunction(Element element) {
		ArrayList<String> fcxx_wList = new ArrayList<String>();
		String result = null;
		fcxx_w = new PgtFCXX_W();
		fcxx_w.setFcslh(element.elements().get(0).attributeValue("FCSLH"));
		fcxx_w.setFpid(element.elements().get(1).attributeValue("FPID"));
		fcxx_w.setSpid(element.elements().get(2).attributeValue("SPID"));
		fcxx_w.setPgjg(Double.valueOf(element.elements().get(3).attributeValue("PGJG")));
		fcxx_w.setQsjg(Double.valueOf(element.elements().get(4).attributeValue("QSJG")));
		fcxx_w.setQtjg(Double.valueOf(element.elements().get(5).attributeValue("QTJG")));
		fcxx_w.setOINSID(element.elements().get(6).attributeValue("OINSID"));
		fcxx_w.setROOMID(element.elements().get(7).attributeValue("ROOMID"));
		fcxx_w.setOwnroomid(element.elements().get(8).attributeValue("OWNROOMID"));
		fcxx_w.setJyjg(Double.valueOf(element.elements().get(9).attributeValue("HTZJ")));
		fcxx_w.setPrice(Double.valueOf(element.elements().get(10).attributeValue("PGDJ")));
		fcxx_w.setIsHX(1);
		fcxx_w.setDfspid(element.elements().get(11).attributeValue("DFSPID"));
		fcxx_w.setSsqy(element.elements().get(12).attributeValue("SSQY"));
		fcxx_w.setDjz_qs(Double.valueOf(element.elements().get(13).attributeValue("QS")));
		fcxx_w.setDjz_yys(Double.valueOf(element.elements().get(14).attributeValue("YYS")));
		fcxx_w.setDjz_cjs(Double.valueOf(element.elements().get(15).attributeValue("CJS")));
		fcxx_w.setDjz_dfjys(Double.valueOf(element.elements().get(16).attributeValue("DFJYS")));
		fcxx_w.setDjz_grsds(Double.valueOf(element.elements().get(17).attributeValue("GRSDS")));
		fcxx_w.setDjz_yhs(Double.valueOf(element.elements().get(18).attributeValue("YHS")));
		fcxx_w.setDjz_tdzzs(Double.valueOf(element.elements().get(19).attributeValue("TDZZS")));
		fcxx_w.setPgid(element.elements().get(20).attributeValue("PGID"));
		
//		sql = String.format("call PG_INS_FC002('%s','%s','%f','%f','%f','%f','%f','%f','%f','%s','%s','%s','%s','%f')",
//				fcxx_w.getFcslh(),fcxx_w.getSsqy(),fcxx_w.getDjz_qs(),fcxx_w.getDjz_yys(),fcxx_w.getDjz_cjs(),
//				fcxx_w.getDjz_dfjys(),fcxx_w.getDjz_grsds(),fcxx_w.getDjz_yhs(),fcxx_w.getDjz_tdzzs(),
//				fcxx_w.getFpid(), fcxx_w.getSpid(),fcxx_w.getDfspid(),fcxx_w.getPgid(),fcxx_w.getPgjg());

		TaxWsxx wsxx = new TaxWsxx();
		try{
			wsxx.setYwh(fcxx_w.getFcslh());
			wsxx.setSeQs(fcxx_w.getDjz_qs());
			wsxx.setSeZzs(fcxx_w.getDjz_yys());
			wsxx.setSeCjs(fcxx_w.getDjz_cjs());
			wsxx.setSeDfjys(fcxx_w.getDjz_dfjys());
			wsxx.setSeGrsds(fcxx_w.getDjz_grsds());
			wsxx.setSeYhs(fcxx_w.getDjz_yhs());
			wsxx.setSeTdzzs(fcxx_w.getDjz_tdzzs());
			wsxx.setFphm(fcxx_w.getFpid());
			wsxx.setZrfsphm(fcxx_w.getSpid());
			wsxx.setCsfsphm(fcxx_w.getDfspid());
			wsxx.setPgid(fcxx_w.getPgid());
			wsxx.setPgjg(fcxx_w.getPgjg());
			wsxx.setWsrq(DateUtil.getNowDate());
			if(wsxxUtil.taxWsxxDao.execInsert(wsxx))
				fcxx_wList.add("OK");
			else
				fcxx_wList.add("NO");
			result = combineFunctionXML(fcxx_wList);
		}catch(Exception e){
			log.error(e);
			errorMessage = e.getMessage();
			fcxx_wList.add("NO");
			result = combineFunctionXML(fcxx_wList);
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


}