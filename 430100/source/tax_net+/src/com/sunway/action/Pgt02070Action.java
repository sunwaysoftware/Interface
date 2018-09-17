package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02002Service;
import com.sunway.service.IPgt02070Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.util.XML;
import com.sunway.vo.Pgt02002;
import com.sunway.vo.Pgt02070;
import com.sunway.vo.Pgv02002;
import com.sunway.webservice.WebXml;

import org.apache.axis2.AxisFault;

/**
 * 完税信息
 *
 */

public class Pgt02070Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -8943454789866027085L;
	private IPgt02070Service t02070Service;
	private IPgt02002Service t02002Service;
	// private String ws_url;
	private String ws_url_action;
	private String ws_url_QNameIp;
	private String ws_url_QNameFun;
	private String ws_urll;
	private String ws_urll_action;
	private String ws_urll_QNameIp;
	private String ws_urll_QNameFun;

	private final SessionCtrl sessionCtrl = new SessionCtrl();

	// 页面所需List && Bean
	private ArrayList<Pgt02070> rows;
	private ArrayList<Pgt02070> resList;
	private Pgt02070 t02070Bean;
	private Pgt02070 v02070Bean;

	// 分页设置
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;

	// 编辑操作符
	private String ACT;

	// 页面传来条件
	private String txtUPDDATE;
	private String txtFCID;
	private String txtSZ;
	private String txtSE;
	private String txtNOTE;
	private String txt1;
	private String txt2;
	private String txt3;
	private String txt4;
	private String txt5;
	private String txt6;
	private String txt7;
	private String txt8;
	//【湘潭】是否是存量房标识：1存量房;0非存量房；
	private String txtIsClf;

	private String txtFCSLHSign;
	private String txtPGJG;
	// 回写
	private String txtFPID;
	private String txtSPID;
	private String txtDFSPID;
	private String txtSFMS;
	private String txtSFZS;
	private String txtBZ;
	private String txtHXSign;
	private String FCID;
	private String FWUUID;
	private Boolean isAdd;
	private String errorMessage;

	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 更新操作前的验证
	 * 
	 * @throws Exception
	 */
	public void validateUpdate() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** start **********");
		}

		// sessionCtrl = new
		// SessionCtrl(ActionContext.getContext().getSession());
		Pgt02070 t02070 = new Pgt02070();
		this.clearErrorsAndMessages();
		// 准备查询条件

		if (Constant.MOD_DELETE.equals(getACT())) {
			t02070.setCd_00001_sz(ConvertUtil.encoding(txtSZ));
			// t02070.setSe(ConvertUtil.toDouble(txtSE));
		}

		t02070.setFcid(ConvertUtil.encoding(txtFCID));
		t02070.setCd_00002_czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
		t02070.setNote(ConvertUtil.encoding(txtNOTE));
		setT02070Bean(t02070);
		/**
		 * 验证是否存在主键冲突
		 * 
		 * @throws Exception
		 */
		if (Constant.MOD_CREATE.equals(getACT())) {
			// Pgt02070 v02070 = new Pgt02070();
			// v02070.setFcid(txtFCID);
			// Pgt02070 bea = null;
			// resList = t02070Service.LoadByPrimaryKey(v02070);
			// for(int i = 0;i < resList.size();i++){
			// for(int j = 0; j < packageV02070().size();j++){
			// bea = packageV02070().get(j);
			// if(txtFCID.equals(resList.get(i).getFcid())
			// &&bea.getPg_sz().equals(resList.get(i).getCd_00001_sz())){
			// this.addActionError(getText("app.msg.error.pk", new
			// String[]{"税额种类"}));
			// }
			// }
			//
			// }
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** end **********");
		}
	}

	/**
	 * 验证是否存在主键冲突
	 * 
         * @return 
	 * @throws Exception
	 * 
	 *             protected void valiPK() throws Exception{ Pgt02070 v02070 =
	 *             new Pgt02070(); v02070.setFcid(txtFCID); Pgt02070 bea = null;
	 *             resList = t02070Service.LoadByPrimaryKey(v02070); for(int i =
	 *             0;i < resList.size();i++){ for(int j = 0; j <
	 *             packageV02070().size();j++){ bea = packageV02070().get(i);
	 *             if(txtFCID.equals(resList.get(i).getFcid())
	 *             &&bea.getPg_sz().equals(resList.get(i).getCd_00001_sz())){
	 *             this.addActionError(getText("app.msg.error.pk", new
	 *             String[]{"税额种类"})); } }
	 * 
	 *             } }
	 */
	protected ArrayList<Pgt02070> packageV02070() throws Exception {
		ArrayList<Pgt02070> list = new ArrayList<Pgt02070>();
		Pgt02070 v02070 = null;
		if (txt1 != null) {
			v02070 = new Pgt02070();
			v02070.setPg_sz("01");
			v02070.setPg_se(txt1);
			list.add(v02070);
		}
		if (txt2 != null) {
			v02070 = new Pgt02070();
			v02070.setPg_sz("02");
			v02070.setPg_se(txt2);
			list.add(v02070);
		}
		if (txt3 != null) {
			v02070 = new Pgt02070();
			v02070.setPg_sz("03");
			v02070.setPg_se(txt3);
			list.add(v02070);
		}
		if (txt4 != null) {
			v02070 = new Pgt02070();
			v02070.setPg_sz("04");
			v02070.setPg_se(txt4);
			list.add(v02070);
		}
		if (txt5 != null) {
			v02070 = new Pgt02070();
			v02070.setPg_sz("05");
			v02070.setPg_se(txt5);
			list.add(v02070);
		}
		if (txt6 != null) {
			v02070 = new Pgt02070();
			v02070.setPg_sz("06");
			v02070.setPg_se(txt6);
			list.add(v02070);
		}
		if (txt7 != null) {
			v02070 = new Pgt02070();
			v02070.setPg_sz("07");
			v02070.setPg_se(txt7);
			list.add(v02070);
		}
		if (txt8 != null) {
			v02070 = new Pgt02070();
			v02070.setPg_sz("08");
			v02070.setPg_se(txt8);
			list.add(v02070);
		}

		return list;
	}

	/**
	 * 进行更新操作
	 * 
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}
		try {
			Pgt02070 bea = null;
			
			if (Constant.MOD_CREATE.equals(getACT())) {
				boolean iResult = true;
				t02070Service.GetDeleteCommand(getT02070Bean());
				for (int i = 0; i < packageV02070().size(); i++) {

					bea = packageV02070().get(i);
					getT02070Bean().setCd_00001_sz(bea.getPg_sz());
					getT02070Bean().setSe(ConvertUtil.toDouble(bea.getPg_se()));
					if (!t02070Service.GetInsertCommand(getT02070Bean()))
					{
						iResult = false;
					}
				}
				
				/*// 插入票号信息
				bea = new Pgt02070();
				bea.setFcid(txtFCID);
				bea.setFpid(CheckUtil.chkTrim(txtFPID));
				bea.setSpid(CheckUtil.chkTrim(txtSPID));
				bea.setDfspid(CheckUtil.chkTrim(txtDFSPID));
				bea.setNote("发票：" + txtFPID + " 税票：" + txtSPID);
				bea.setCd_00002_czr(sessionCtrl.getUserId());
				try {
					t02070Service.GetInsertCommandFPSP(bea);
					iResult = true;
				} catch (Exception e) {
					LOG.error(e.getMessage());
				}*/

				if (iResult) {
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[] { "参数" }));
				} else {
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[] { "参数" }));
				}
			} else if (Constant.MOD_DELETE.equals(getACT())) {
				if (t02070Service.GetDeleteCommand(getT02070Bean())) {
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[] { "参数" }));
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[] { "参数" }));
				}
			} else if (Constant.MOD_UPDATE.equals(getACT())) {
				if (t02070Service.GetUpdateCommand(getT02070Bean())) {
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[] { "参数" }));
				} else {
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[] { "参数" }));
				}
			}

		} catch (Exception e) {
			this.addActionError(e.getMessage());
			LOG.error(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return SUCCESS;
	}

	public String execute3701() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute3701() ********** start **********");
		}
		Pgt02070 v02070 = new Pgt02070();
		try {
			v02070.setFcid(txtFCID);
			resList = t02070Service.LoadByPrimaryKey(v02070);
			isAdd = false;
			if (resList.size() > 0) {
				if (!CheckUtil.chkEmpty(resList.get(0).getFcid())) {
					isAdd = true;
				}
			}
			Pgt02002 t02002 = new Pgt02002();
			t02002.setFcid(txtFCID);
			t02002 = t02002Service.LoadByPrimaryKey(t02002);
			//存量房标识,控制页面税额框是否可以输入
			String tmpLx = t02002.getCd00001Jylx();
			if(null!=tmpLx && tmpLx.equals("012")){
				//只读
				txtIsClf = "1";
			} else {
				//可写
				txtIsClf = "0";
			}
			txtFPID = t02002.getFpid();
			txtSPID = t02002.getSpid();
			txtDFSPID = t02002.getDfspid();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("execute() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("execute3701() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 国土回写
	 * 
	 * @return
	 * @throws Exception
	 */
	public String executeHX() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeHX() ********** start **********");
		}
		StringBuilder strBuf = new StringBuilder(String.format("<FCXX SSQY='%s'/>", sessionCtrl.Get(SessionCtrl.FCBMBM)));
		Double qsV = 0.0;
		Double qtV = 0.0;
		Pgt02070 v02070 = new Pgt02070();
		Pgt02070 v02070Bean = null;
		Pgv02002 Pgv02002 = new Pgv02002();
		try {
			v02070.setFcid(txtFCID);
			resList = t02070Service.LoadByPrimaryKey(v02070);
			Pgv02002.setFcid(txtFCID);
			Pgv02002 = t02002Service.GetXMLI(Pgv02002);
			if (CheckUtil.chkEmpty(Pgv02002.getFcslh())) {
				txtHXSign = "Y";
			} else {
				for (int i = 0; i < resList.size(); i++) {
					v02070Bean = resList.get(i);
					// 01时是契税的税额
					if ("01".equals(v02070Bean.getCd_00001_sz())) {
						qsV += v02070Bean.getSe();
						strBuf.append(String.format("<FCXX QS='%s'/>", v02070Bean.getSe()));
					} else {
						qtV += v02070Bean.getSe();
						if ("02".equals(v02070Bean.getCd_00001_sz()))
							strBuf.append(String.format("<FCXX YYS='%s'/>", v02070Bean.getSe()));
						else if ("03".equals(v02070Bean.getCd_00001_sz()))
							strBuf.append(String.format("<FCXX CJS='%s'/>", v02070Bean.getSe()));
						else if ("04".equals(v02070Bean.getCd_00001_sz()))
							strBuf.append(String.format("<FCXX DFJYS='%s'/>", v02070Bean.getSe()));
						else if ("05".equals(v02070Bean.getCd_00001_sz()))
							strBuf.append(String.format("<FCXX GRSDS='%s'/>", v02070Bean.getSe()));
						else if ("06".equals(v02070Bean.getCd_00001_sz()))
							strBuf.append(String.format("<FCXX YHS='%s'/>", v02070Bean.getSe()));
						else if ("07".equals(v02070Bean.getCd_00001_sz()))
							strBuf.append(String.format("<FCXX TDZZS='%s'/>", v02070Bean.getSe()));
						// else if ("08".equals(v02070Bean.getCd_00001_sz()))
						// strBuf.append(String.format("<FCXX JYFFJ='%s'/>",
						// v02070Bean.getSe()));
					}
				}
				strBuf.append(String.format("<FCXX PGID='%s'/>", txtFCID));
				strBuf.append(String.format("<FCXX BZXX='%s'/>", Pgv02002.getNote()));
				XML person = new XML();
				WebXml web = new WebXml();
				String strXML = person
						.getHXxml(Pgv02002.getFcslh(), CheckUtil.chkNull(txtFPID), CheckUtil.chkNull(txtSPID),
								Pgv02002.getSypgjg().toString(), qsV.toString(), qtV.toString(), Pgv02002.getOINSID(),
								Pgv02002.getROOMID(), Pgv02002.getOwnRoomid(), Pgv02002.getJyjg().toString(),
								String.valueOf(ConvertUtil.toDouble(Pgv02002.getSypgjg().toString()) / Pgv02002.getJzmj()),
								CheckUtil.chkNull(txtDFSPID), strBuf.toString());
				String resXML = null;
				try {
					resXML = web.web(strXML, sessionCtrl.Get(SessionCtrl.FCJKDZ));
				} catch (AxisFault errAxis) {
					txtHXSign = "N";
					setErrorMessage("与WebService连接异常，请检查接口配置及网络连接");
					return SUCCESS;
				} catch (Exception e) {
					txtHXSign = "N";
					setErrorMessage("报错原因：" + e.getMessage());
					return SUCCESS;
				}

				try {

					String result = person.jxHXxml(resXML);
					if ("true".equals(result)) {
						txtHXSign = "Y";
					} else {
						txtHXSign = "N";
						setErrorMessage(result);
						return SUCCESS;
					}
				} catch (Exception e) {
					txtHXSign = "N";
					setErrorMessage(e.getMessage());
					return SUCCESS;
				}
			}

		} catch (Exception e) {
			LOG.error(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("executeHX() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("executeHX() ********** end **********");
		}
		return SUCCESS;
	}

	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgt02070 v02070 = new Pgt02070();
		v02070.setFcid(FCID);
		resList = t02070Service.LoadByPrimaryKey(v02070);
		Pgt02002 t02002 = new Pgt02002();
		t02002.setFcid(FCID);
		t02002 = t02002Service.LoadByPrimaryKey(t02002);
		txtFPID = t02002.getFpid();
		txtSPID = t02002.getSpid();
		txtDFSPID = t02002.getDfspid();

		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** end **********");
		}
		return SUCCESS;
	}

	public String detailB() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgt02070 v02070 = new Pgt02070();
		v02070.setFcid(FCID);
		resList = t02070Service.LoadByPrimaryKey_B(v02070);
		Pgv02002 v02002 = new Pgv02002();
		v02002.setFcid(FCID);
		v02002 = t02002Service.LoadDetail_B(v02002);
		txtFPID = v02002.getFpid();
		txtSPID = v02002.getSpid();
		txtDFSPID = v02002.getDfspid();

		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** end **********");
		}
		return SUCCESS;
	}

	/*********************** set and get ******************************/

	@JSON(deserialize = false, serialize = false)
	public IPgt02070Service getT02070Service() {
		return t02070Service;
	}

	public void setT02070Service(IPgt02070Service t02070Service) {
		this.t02070Service = t02070Service;
	}

	public ArrayList<Pgt02070> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Pgt02070> rows) {
		this.rows = rows;
	}

	public Pgt02070 getT02070Bean() {
		return t02070Bean;
	}

	public void setT02070Bean(Pgt02070 t02070Bean) {
		this.t02070Bean = t02070Bean;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getACT() {
		return ACT;
	}

	public void setACT(String aCT) {
		ACT = aCT;
	}

	public String getTxtUPDDATE() {
		return txtUPDDATE;
	}

	public void setTxtUPDDATE(String txtUPDDATE) {
		this.txtUPDDATE = txtUPDDATE;
	}

	public String getTxtFCID() {
		return txtFCID;
	}

	public void setTxtFCID(String txtFCID) {
		this.txtFCID = txtFCID;
	}

	public ArrayList<Pgt02070> getResList() {
		return resList;
	}

	public void setResList(ArrayList<Pgt02070> resList) {
		this.resList = resList;
	}

	/*
	 * public String getTxtSZ() { return txtSZ; }
	 * 
	 * 
	 * 
	 * public void setTxtSZ(String txtSZ) { this.txtSZ = txtSZ; }
	 * 
	 */

	public String getTxtSE() {
		return txtSE;
	}

	public void setTxtSE(String txtSE) {
		this.txtSE = txtSE;
	}

	public String getTxtNOTE() {
		return txtNOTE;
	}

	public void setTxtNOTE(String txtNOTE) {
		this.txtNOTE = txtNOTE;
	}

	public String getTxtFCSLHSign() {
		return txtFCSLHSign;
	}

	public void setTxtFCSLHSign(String txtFCSLHSign) {
		this.txtFCSLHSign = txtFCSLHSign;
	}

	public String getTxtFPID() {
		return txtFPID;
	}

	public void setTxtFPID(String txtFPID) {
		this.txtFPID = txtFPID;
	}

	public String getTxtSPID() {
		return txtSPID;
	}

	public void setTxtSPID(String txtSPID) {
		this.txtSPID = txtSPID;
	}

	public String getTxtSFMS() {
		return txtSFMS;
	}

	public void setTxtSFMS(String txtSFMS) {
		this.txtSFMS = txtSFMS;
	}

	public String getTxtSFZS() {
		return txtSFZS;
	}

	public void setTxtSFZS(String txtSFZS) {
		this.txtSFZS = txtSFZS;
	}

	public String getTxtBZ() {
		return txtBZ;
	}

	public void setTxtBZ(String txtBZ) {
		this.txtBZ = txtBZ;
	}

	public String getTxtPGJG() {
		return txtPGJG;
	}

	public void setTxtPGJG(String txtPGJG) {
		this.txtPGJG = txtPGJG;
	}

	/*
	 * public String getWs_url() { return ws_url; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public void setWs_url(String wsUrl) { ws_url = wsUrl; }
	 * 
	 * 
	 * 
	 */

	public String getTxtHXSign() {
		return txtHXSign;
	}

	public void setTxtHXSign(String txtHXSign) {
		this.txtHXSign = txtHXSign;
	}

	@JSON(deserialize = false, serialize = false)
	public IPgt02002Service getT02002Service() {
		return t02002Service;
	}

	public void setT02002Service(IPgt02002Service t02002Service) {
		this.t02002Service = t02002Service;
	}

	/**
	 * @return the txt1
	 */
	public String getTxt1() {
		return txt1;
	}

	/**
	 * @param txt1
	 *            the txt1 to set
	 */
	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}

	/**
	 * @return the txt2
	 */
	public String getTxt2() {
		return txt2;
	}

	/**
	 * @param txt2
	 *            the txt2 to set
	 */
	public void setTxt2(String txt2) {
		this.txt2 = txt2;
	}

	/**
	 * @return the txt3
	 */
	public String getTxt3() {
		return txt3;
	}

	/**
	 * @param txt3
	 *            the txt3 to set
	 */
	public void setTxt3(String txt3) {
		this.txt3 = txt3;
	}

	/**
	 * @return the txt4
	 */
	public String getTxt4() {
		return txt4;
	}

	/**
	 * @param txt4
	 *            the txt4 to set
	 */
	public void setTxt4(String txt4) {
		this.txt4 = txt4;
	}

	/**
	 * @return the txt5
	 */
	public String getTxt5() {
		return txt5;
	}

	/**
	 * @param txt5
	 *            the txt5 to set
	 */
	public void setTxt5(String txt5) {
		this.txt5 = txt5;
	}

	/**
	 * @return the txt6
	 */
	public String getTxt6() {
		return txt6;
	}

	/**
	 * @param txt6
	 *            the txt6 to set
	 */
	public void setTxt6(String txt6) {
		this.txt6 = txt6;
	}

	/**
	 * @return the txt7
	 */
	public String getTxt7() {
		return txt7;
	}

	/**
	 * @param txt7
	 *            the txt7 to set
	 */
	public void setTxt7(String txt7) {
		this.txt7 = txt7;
	}

	/**
	 * @return the txt8
	 */
	public String getTxt8() {
		return txt8;
	}

	/**
	 * @param txt8
	 *            the txt8 to set
	 */
	public void setTxt8(String txt8) {
		this.txt8 = txt8;
	}

	/**
	 * @return the txtSZ
	 */
	public String getTxtSZ() {
		return txtSZ;
	}

	/**
	 * @param txtSZ
	 *            the txtSZ to set
	 */
	public void setTxtSZ(String txtSZ) {
		this.txtSZ = txtSZ;
	}

	public Pgt02070 getV02070Bean() {
		return v02070Bean;
	}

	public void setV02070Bean(Pgt02070 v02070Bean) {
		this.v02070Bean = v02070Bean;
	}

	public String getFCID() {
		return FCID;
	}

	public void setFCID(String fCID) {
		FCID = fCID;
	}

	public void setTxtDFSPID(String txtDFSPID) {
		this.txtDFSPID = txtDFSPID;
	}

	public String getTxtDFSPID() {
		return txtDFSPID;
	}

	public String getWs_url_action() {
		return ws_url_action;
	}

	public void setWs_url_action(String wsUrlAction) {
		ws_url_action = wsUrlAction;
	}

	public String getWs_url_QNameIp() {
		return ws_url_QNameIp;
	}

	public void setWs_url_QNameIp(String wsUrlQNameIp) {
		ws_url_QNameIp = wsUrlQNameIp;
	}

	public String getWs_url_QNameFun() {
		return ws_url_QNameFun;
	}

	public void setWs_url_QNameFun(String wsUrlQNameFun) {
		ws_url_QNameFun = wsUrlQNameFun;
	}

	public String getWs_urll() {
		return ws_urll;
	}

	public void setWs_urll(String wsUrll) {
		ws_urll = wsUrll;
	}

	public String getWs_urll_action() {
		return ws_urll_action;
	}

	public void setWs_urll_action(String wsUrllAction) {
		ws_urll_action = wsUrllAction;
	}

	public String getWs_urll_QNameIp() {
		return ws_urll_QNameIp;
	}

	public void setWs_urll_QNameIp(String wsUrllQNameIp) {
		ws_urll_QNameIp = wsUrllQNameIp;
	}

	public String getWs_urll_QNameFun() {
		return ws_urll_QNameFun;
	}

	public void setWs_urll_QNameFun(String wsUrllQNameFun) {
		ws_urll_QNameFun = wsUrllQNameFun;
	}

	public Boolean getIsAdd() {
		return isAdd;
	}

	public void setIsAdd(Boolean isAdd) {
		this.isAdd = isAdd;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

	/**
	 * @return the txtIsClf
	 */
	public String getTxtIsClf() {
		return txtIsClf;
	}

	/**
	 * @param txtIsClf the txtIsClf to set
	 */
	public void setTxtIsClf(String txtIsClf) {
		this.txtIsClf = txtIsClf;
	}

	public String getFWUUID() {
		return FWUUID;
	}

	public void setFWUUID(String fWUUID) {
		FWUUID = fWUUID;
	}
}
