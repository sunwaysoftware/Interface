package com.sunway.action;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02005Service;
import com.sunway.vo.Pgv02005;

/**
 * 收益法国土状态
 * @author Light
 *
 */
public class Pgt02005Action extends ActionSupport{

	private static final long serialVersionUID = 1064187925219708531L;
	
	private IPgt02005Service t02005Service;
	
	// Detail
	private String FCID;
	private Pgv02005 v02005Bean;
	
	/**
	 * 已通过详细信息
	 * @return
	 * @throws Exception
	 */
	public String detailY()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("detailY() ********** start **********");
		}
		try{
			//
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("detailY() ********** end **********");
			}
			return INPUT;
		}finally{
			//	
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("detailY() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 读取详细信息状态数据
	 * @return
	 * @throws Exception
	 */
	public String detailZT()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("detailZT() ********** start **********");
		}
		try{
			Pgv02005 bean = new Pgv02005();
			bean.setCd02002Fcid(FCID);
			v02005Bean = t02005Service.LoadDetailZT(bean);
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("detailZT() ********** end **********");
			}
			return INPUT;
		}finally{
			//	
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("detailZT() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/***********************   set && get   *************************/
	/**
	 * @return the t02005Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt02005Service getT02005Service() {
		return t02005Service;
	}
	/**
	 * @param t02005Service the t02005Service to set
	 */
	public void setT02005Service(IPgt02005Service t02005Service) {
		this.t02005Service = t02005Service;
	}
	/**
	 * @return the FCID
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
	 * @return the v02005Bean
	 */
	public Pgv02005 getV02005Bean() {
		return v02005Bean;
	}

	/**
	 * @param v02005Bean the v02005Bean to set
	 */
	public void setV02005Bean(Pgv02005 v02005Bean) {
		this.v02005Bean = v02005Bean;
	}

}
