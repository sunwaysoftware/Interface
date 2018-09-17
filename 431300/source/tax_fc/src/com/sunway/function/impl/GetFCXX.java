package com.sunway.function.impl;

import java.sql.Connection;
import java.util.ArrayList;
import javax.sql.rowset.CachedRowSet;
import org.dom4j.Element;
import com.sunway.function.IBaseObject;
import com.sunway.vo.PgtFCXX;

/**
 * 读取房产局信息
 * @author Administrator
 *
 */
public class GetFCXX extends BaseFunction implements IBaseObject{

	private static final String FCSLH = "f1";			//房产受理号
	private static final String YFCZH = "f2";			//原房产证号
	private static final String ZRFSFLX = "f3";			//转让方身份证照类型
	private static final String ZRFSFID = "f4";			//转让方身份证照号码/企业管理代码
	private static final String ZRFMC = "f5";			//转让方名称/企业名称
	private static final String CSFSFLX = "f6";			//承受方身份证照类型
	private static final String CSFSFID = "f7";			//承受方身份证照号码/企业管理代码
	private static final String CSFMC = "f8";			//承受方名称/企业名称
	private static final String CLH = "f9";				//测量号
	private static final String SJYT = "f10";			//设计用途
	private static final String LFDZ = "f11";			//楼房地址
	private static final String DYFH = "f12";			//单元及房号
	private static final String SZLC = "f13";			//所在楼层
	private static final String ZLC = "f14";			//总楼层
	private static final String JZJG = "f15";			//建筑结构
	private static final String FWLX = "f16";			//房屋类别
	private static final String JYLX = "f17";			//交易类型
	private static final String JZMJ = "f18";			//建筑面积(平方米)
	private static final String HTZJ = "f19";			//合同总价(元)
	private static final String JYSJ = "f20";			//交易时间
	private static final String FZRQ = "f21";			//发证日期
	private static final String DF = "f22";				//端房
	private static final String CX = "f23";				//朝向
	private static final String CG = "f24";				//层高
	private static final String OINSID = "f25";    		//外键
	private static final String YJG = "f26";			//原值
	private static final String PGJG = "f27";			//评估结果
	private static final String ROOMID = "f28";			//房屋ID
	private static final String SFSYFC = "f30";			//是否私有房产 
	private static final String OWNROOMID = "f31";      //房屋ID
	private static final String JCNF = "JCNF";      	//建成年份
	private static final String QSWSRQ = "qswsrq";      //契税完税日期
	private static final String QSWSJS = "qswsjs";      //契税完税基数
	
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
		sql = String.format("SELECT * FROM PG_VFC001 WHERE SLID = '%s' AND SSQY = '%s'", fcxx.getParamVal(), fcxx.getParamVal2());
		try {
			ocrs = queryFunction(sql, conn);
			while(null != ocrs && ocrs.next()){
				fcxxList.add(setFCXXParameters(ocrs));
			}
			result = combineFunctionXML(fcxxList);
		} catch(Exception e) {
			e.printStackTrace();
			errorSign = true;
			errorMessage = e.getMessage();
			result = combineFunctionXML(fcxxList);
		} finally {
			getFreeORS(ocrs);
		}
		return result;
	}
	
	/**
	 * 装载数据
	 * @param ocrs
	 * @return
	 * @throws Exception
	 */
	protected PgtFCXX setFCXXParameters(CachedRowSet ocrs) throws Exception {
		PgtFCXX e = new PgtFCXX();
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
				str = String.format("<ROW FCSLH='%s' YFCZH='%s' ZRFSFLX='%s' ZRFSFID='%s' ZRFMC='%s' CSFSFLX='%s' CSFSFID='%s' CSFMC='%s' CLH='%s' SJYT='%s' LFDZ='%s' DYFH='%s' SZLC='%s' ZLC='%s' JZJG='%s' FWLX='%s' JYLX='%s' JZMJ='%s' HTZJ='%s' JYSJ='%s' FZRQ='%s' DF='%s' CX='%s' CG='%s' OINSID='%s' YJG='%s' PGJG='%s' ROOMID='%s' OWNROOMID='%s' SFSYFC='%s' JCNF='%s' WSRQ='%s' WSJS='%s' ERRORSIGN='0' ERRORMESSAGE='%s'/>"
						, fcxxBean.getFcslh(),fcxxBean.getYfczh(),fcxxBean.getZrfsflx(),fcxxBean.getZrfsfid(),fcxxBean.getZrfmc(),fcxxBean.getCsfsflx(),fcxxBean.getCsfsfid(),fcxxBean.getCsfmc(),fcxxBean.getClh(),fcxxBean.getSjyt(),fcxxBean.getLfdz(),fcxxBean.getDyfh(),fcxxBean.getSzlc(),fcxxBean.getZlc(),fcxxBean.getJzjg(),fcxxBean.getFwlx(),fcxxBean.getJylx(),fcxxBean.getJzmj(),fcxxBean.getHtzj(),fcxxBean.getJysj(),fcxxBean.getFzrq(),fcxxBean.getDf(),fcxxBean.getCx(),fcxxBean.getCg(),fcxxBean.getOinsid(),fcxxBean.getYjg(),fcxxBean.getPgjg(),fcxxBean.getRoomid(),fcxxBean.getOwnRoomid(),fcxxBean.getSfsyfc(), fcxxBean.getJcnf(), fcxxBean.getQswsrq(), fcxxBean.getQswsjs(),"获取成功");
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
	
		return result;
	}

}
